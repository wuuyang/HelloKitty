package com.example.hellokitty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import com.study.xuan.gifshow.widget.stlview.callback.OnReadCallBack;
import com.study.xuan.gifshow.widget.stlview.widget.STLView;
import com.study.xuan.gifshow.widget.stlview.widget.STLViewBuilder;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private Button btn;
    private STLView stlView;

    private static final String PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/wy/";

    private String fileName = "swxg.stl";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        stlView = findViewById(R.id.stl);

        STLViewBuilder.init(stlView).Assets(this,PATH + fileName).build();
        stlView.setTouch(true);//是否可以触摸
        stlView.setScale(true);//是否可以缩放
        stlView.setRotate(true);//是否可以拖拽
        stlView.setSensor(true);//是否支持陀螺仪
        //stl文件读取过程中的回调
        stlView.setOnReadCallBack(new OnReadCallBack() {
            @Override
            public void onStart() {

            }
            @Override
            public void onReading(int cur, int total) {

            }
            @Override
            public void onFinish() {

            }
        });
    }
}
