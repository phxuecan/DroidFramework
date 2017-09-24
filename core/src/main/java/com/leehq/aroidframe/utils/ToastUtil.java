package com.leehq.aroidframe.utils;

import android.widget.Toast;

import com.leehq.aroidframe.BaseApplication;

/*******************************************************
 * Description:
 * Author: leehq phxuecan@sina.cn
 * since:2017-09-11
 *******************************************************
 */

public class ToastUtil {

    public static void toast(String message) {
        Toast.makeText(BaseApplication.getInstance(), message, Toast.LENGTH_SHORT).show();
    }
}
