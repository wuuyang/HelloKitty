package com.example.kittylibrary;

import android.content.Context;
import android.widget.Toast;

import java.nio.charset.Charset;

/**
 * @ClassName ToastUtils
 * @Description TODO
 * @Author User
 * @Date 2020/4/2 15:21
 * @Version 1.0
 * e-mail：oom1391069@163.com
 */
public class ToastUtils {

    public static void show(Context context, CharSequence text, int duration) {
        Toast.makeText(context, text, duration).show();
    }

    public static void show(Context context, int resId) {
        show(context, context.getResources().getText(resId), Toast.LENGTH_SHORT);
    }

    public static void show(Context context, int resId, int duration) {
        show(context, context.getResources().getText(resId), duration);
    }

    public static void show(Context context, CharSequence text) {
        show(context, text, Toast.LENGTH_SHORT);
    }

    public static void show(Context context, int resId, Object... args) {
        show(context, String.format(context.getResources().getString(resId), args), Toast.LENGTH_SHORT);
    }

    public static void show(Context context, String format, Object... args) {
        show(context, String.format(format, args), Toast.LENGTH_SHORT);
    }

    public static void show(Context context, int resId,int duration ,Object... args) {
        show(context, String.format(context.getResources().getString(resId), args), duration);
    }

    public static void show(Context context, String format,int duration ,Object... args) {
        show(context, String.format(format, args), duration);
    }
}
