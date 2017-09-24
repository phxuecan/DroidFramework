package com.leehq.sample.rxandroid;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.leehq.retrofit.R;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * RxAndroid demo
 */
public class RxAndroidActivity extends Activity {

    private static final String TAG = "RxAndroidSamples";

    private final CompositeDisposable disposables = new CompositeDisposable();
    private ProgressBar mProgressBar;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rxandroid_activity);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        findViewById(R.id.button_run_scheduler).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                onRunSchedulerExampleButtonClicked();
            }
        });
    }

    protected void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    protected void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        disposables.clear();
    }

    void onRunSchedulerExampleButtonClicked() {
        Log.d(TAG, "onRunSchedulerExampleButtonClicked");
        disposables.add(sampleObservable()
                // Run on a background thread
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept (String s) throws Exception {
                        showProgressBar();
                    }
                })
                .observeOn(Schedulers.io())
                .map(new Function<String, String>() {
                    @Override
                    public String apply (String s) throws Exception {
                        return s + " ,has modify";
                    }
                })
                // Be notified on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<String>() {
                    @Override public void onComplete() {
                        Log.d(TAG, "onComplete()");
                        Toast.makeText(RxAndroidActivity.this, "onComplete", Toast.LENGTH_SHORT).show();
                        hideProgressBar();
                    }

                    @Override public void onError(Throwable e) {
                        Log.e(TAG, "onError()", e);
                    }

                    @Override public void onNext(String string) {
                        String msg = "onNext(" + string + ")";
                        Log.d(TAG, msg);
                        Toast.makeText(RxAndroidActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                }));
    }

    static Observable<String> sampleObservable() {
        return Observable.defer(new Callable<ObservableSource<? extends String>>() {
            @Override public ObservableSource<? extends String> call() throws Exception {
                // Do some long running operation
                SystemClock.sleep(5000);
                return Observable.just("one", "two", "three", "four", "five");
            }
        });
    }
}
