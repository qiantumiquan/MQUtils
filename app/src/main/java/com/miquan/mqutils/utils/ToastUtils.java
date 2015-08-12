package com.miquan.mqutils.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

public class ToastUtils {
    private static Toast mToast = null;

    public static void showToast(Context context, int resId) {
        String text = context.getString(resId);
        showToast(context, text, Toast.LENGTH_SHORT);
    }

    public static void showToast(Context context, String text) {
        showToast(context, text, Toast.LENGTH_SHORT);
    }

    public static void showToast(Context context, String text, int duration) {
        if (TextUtils.isEmpty(text)) return;
        if (mToast == null) {
            mToast = Toast.makeText(context, text, duration);
        } else {
            mToast.setText(text);
            mToast.setDuration(duration);
        }
        mToast.show();
    }
}
