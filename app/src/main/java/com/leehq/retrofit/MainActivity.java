package com.leehq.retrofit;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String CATEGORY = "android.intent.category.LEEHQ_SAMPLE_CODE";
    private static final String ACTION = "android.intent.action.LEEHQ_SAMPLE_CODE";
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listview);
        mListView.setAdapter(new SimpleAdapter(this, getData(),
                android.R.layout.simple_list_item_1, new String[]{"title"},
                new int[] { android.R.id.text1 }));
        mListView.setOnItemClickListener(this);

    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

        Intent mainIntent = new Intent(ACTION);
        mainIntent.addCategory(CATEGORY);

        PackageManager pm = getPackageManager();
        List<ResolveInfo> list = pm.queryIntentActivities(mainIntent, 0);
        if (list == null) {
            return data;
        }
        int len = list.size();

        for (int i = 0; i < len; i++) {
            ResolveInfo info = list.get(i);
            int index = info.activityInfo.name.lastIndexOf(".");
            String label = info.activityInfo.name.substring(index+1);

            Map<String, Object> temp = new HashMap<String, Object>();
            temp.put("title", label);
            temp.put("intent", activityIntent(
                    info.activityInfo.applicationInfo.packageName,
                    info.activityInfo.name));
            data.add(temp);
        }
        return data;
    }

    protected Intent activityIntent(String pkg, String componentName) {
        Intent result = new Intent();
        result.setClassName(pkg, componentName);
        return result;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Map<String, Object> map = (Map<String, Object>)mListView.getItemAtPosition(position);

        Intent intent = (Intent) map.get("intent");
        startActivity(intent);
    }
}
