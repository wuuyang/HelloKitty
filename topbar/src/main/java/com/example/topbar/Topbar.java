package com.example.topbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Topbar extends RelativeLayout {

    private Context mContext;

    private Button btnLeft, btnRight;
    private TextView tvTitle;

    private int leftTextColor;
    private Drawable leftBackground;
    private String leftText;

    private int rightTextColor;
    private Drawable rightBackground;
    private String rightText;

    private float titleTextSize;
    private int titleTextColor;
    private String toptitle;

    //定义三个布局参数
    private LayoutParams leftParams, rightParams, titleParams;

    private TopbarClickListener listener;

    public interface TopbarClickListener{
        //左侧按钮点击事件
        void onLeftClick();

        //右侧按钮点击事件
        void onRightClick();
    }

    public void setOnTopbarClickListener(TopbarClickListener listener){
        this.listener = listener;
    }

    public Topbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        setBackgroundColor(0xfff59563);               //设置View的背景颜色
        getAttrs(attrs);
        initTitle();
        initLeftButton();
        initRightButton();

    }

    /**
     * 将xml中的属性映射到attrs中
     */
    private void getAttrs(AttributeSet attrs){
        TypedArray ta = mContext.obtainStyledAttributes(attrs, R.styleable.Topbar);

        leftTextColor = ta.getColor(R.styleable.Topbar_leftTextColor, 0);
        leftBackground = ta.getDrawable(R.styleable.Topbar_leftBackground);
        leftText = ta.getString(R.styleable.Topbar_leftText);

        rightTextColor = ta.getColor(R.styleable.Topbar_rightTextColor, 0);
        rightBackground = ta.getDrawable(R.styleable.Topbar_rightBackground);
        rightText = ta.getString(R.styleable.Topbar_rightText);

        titleTextSize = ta.getDimension(R.styleable.Topbar_titleTextSize, 0);
        titleTextColor = ta.getColor(R.styleable.Topbar_titleTextColor, 0);
        toptitle = ta.getString(R.styleable.Topbar_topTitle);

        ta.recycle();
    }

    private void initTitle(){
        tvTitle = new TextView(mContext);
        tvTitle.setTextColor(titleTextColor);         //设置字体颜色
        tvTitle.setTextSize(titleTextSize);           //设置字体大小
        tvTitle.setText(toptitle);                    //设置文本
        tvTitle.setGravity(Gravity.CENTER);           //居中显示

        //设置布局属性的width和height
        titleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        //设置对齐方式为居中对齐
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        //将中间TextView添加到视图中，并设置布局属性
        addView(tvTitle, titleParams);
    }

    private void initLeftButton(){
        btnLeft = new Button(mContext);
        //设置控件的值
        btnLeft.setTextColor(leftTextColor);          //设置文字颜色
        btnLeft.setBackground(leftBackground);        //设置背景
        btnLeft.setText(leftText);                    //设置文本

        //设置布局属性的width和height
        leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        //设置对齐方式为父容器的左侧
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        //将左边按钮添加到视图中，并设置布局属性
        addView(btnLeft, leftParams);

        btnLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onLeftClick();
            }
        });
    }

    private void initRightButton(){
        btnRight = new Button(mContext);
        btnRight.setTextColor(rightTextColor);        //设置文字颜色
        btnRight.setBackground(rightBackground);      //设置背景
        btnRight.setText(rightText);                  //设置文本

        //设置布局属性的width和height
        rightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        //设置对齐方式为父容器的右侧
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        //将右边按钮添加到视图中，并设置布局属性
        addView(btnRight, rightParams);

        btnRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onRightClick();
            }
        });
    }

}
