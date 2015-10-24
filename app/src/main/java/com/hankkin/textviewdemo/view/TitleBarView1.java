package com.hankkin.textviewdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hankkin.textviewdemo.R;

/**
 * Created by Hankkin on 15/10/23.
 */
public class TitleBarView1  extends RelativeLayout implements View.OnClickListener{

    private Button btnLeft;     //左侧按钮
    private Button btnRight;    //右侧按钮
    private TextView tvTitle;   //标题文本
    private BtnClickListener listener;

    public TitleBarView1(Context context) {
        super(context);
    }

    public TitleBarView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    /**
     * 初始化组件
     * @param context
     */
    private void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.titlebar1,this);
        btnLeft = (Button) findViewById(R.id.btn_titlebar_left);
        btnRight = (Button) findViewById(R.id.btn_titlebar_right);
        tvTitle = (TextView) findViewById(R.id.tv_titlebar_name);
        btnLeft.setOnClickListener(this);
        btnRight.setOnClickListener(this);
    }

    public void setTitleBarListener(BtnClickListener listener){
        this.listener = listener;
    }

    /**
     * 按钮点击接口
     */
    public interface BtnClickListener{
        void leftClick();
        void rightClick();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_titlebar_left:
                listener.leftClick();
                break;
            case R.id.btn_titlebar_right:
                listener.rightClick();
                break;
            default:
                break;
        }
    }

    /**
     * 设置左侧按钮是否可见
     * @param flag  是否可见
     */
    public void setLeftBtnVisable(boolean flag){
        if (flag){
            btnLeft.setVisibility(VISIBLE);
        }
        else {
            btnLeft.setVisibility(GONE);
        }
    }

    /**
     * 设置右侧按钮是否可见
     * @param flag  是否可见
     */
    public void setRightBtnVisable(boolean flag){
        if (flag){
            btnRight.setVisibility(VISIBLE);
        }
        else {
            btnRight.setVisibility(GONE);
        }
    }
}
