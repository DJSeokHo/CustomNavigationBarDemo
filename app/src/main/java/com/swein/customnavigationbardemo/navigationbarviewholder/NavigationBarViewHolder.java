package com.swein.customnavigationbardemo.navigationbarviewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.swein.customnavigationbardemo.R;

public class NavigationBarViewHolder {

    /**
     * 导航栏控件委托
     */
    public interface NavigationBarViewHolderDelegate {
        void onLeftClicked();
        void onRightClicked();
    }

    private View view;

    private ImageButton imageButtonLeft;
    private ImageButton imageButtonRight;
    private TextView textViewTitle;

    private NavigationBarViewHolderDelegate navigationBarViewHolderDelegate;

    /**
     *
     * @param context 上下文
     * @param navigationBarViewHolderDelegate 委托
     * @param parent 把这个导航栏xml资源加载到parent上
     */
    public NavigationBarViewHolder(Context context, NavigationBarViewHolderDelegate navigationBarViewHolderDelegate, @Nullable ViewGroup parent) {
        this.navigationBarViewHolderDelegate = navigationBarViewHolderDelegate;
        view = inflateView(context, R.layout.view_holder_simple_navigation_bar, parent);
        findView();
        setListener();
    }

    /**
     * 载入xml
     *
     * 注意：这个方法可以单独提取成工具类方法
     */
    private View inflateView(Context context, int resource, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(resource, viewGroup);
    }

    /**
     * 绑定控件
     */
    private void findView() {
        imageButtonLeft = view.findViewById(R.id.imageButtonLeft);
        imageButtonRight = view.findViewById(R.id.imageButtonRight);
        textViewTitle = view.findViewById(R.id.textViewTitle);
    }

    /**
     * 设置监听
     */
    private void setListener() {
        imageButtonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationBarViewHolderDelegate.onLeftClicked();
            }
        });

        imageButtonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationBarViewHolderDelegate.onRightClicked();
            }
        });
    }

    /**
     * 设置导航栏左键图标
     */
    public void setLeft(int resource) {
        imageButtonLeft.setImageResource(resource);
    }
    /**
     * 显示导航栏左键图标
     */
    public void showLeft() {
        imageButtonLeft.setVisibility(View.VISIBLE);
    }
    /**
     * 隐藏导航栏左键图标
     */
    public void hideLeft() {
        imageButtonLeft.setVisibility(View.GONE);
    }

    /**
     * 设置导航栏右键图标
     */
    public void setRight(int resource) {
        imageButtonRight.setImageResource(resource);
    }
    /**
     * 显示导航栏右键图标
     */
    public void showRight() {
        imageButtonRight.setVisibility(View.VISIBLE);
    }
    /**
     * 隐藏导航栏右键图标
     */
    public void hideRight() {
        imageButtonRight.setVisibility(View.GONE);
    }

    /**
     * 设置导航栏中间文字
     */
    public void setTitle(String title) {
        textViewTitle.setText(title);
    }
    /**
     * 显示导航栏中间文字
     */
    public void showTitle() {
        textViewTitle.setVisibility(View.VISIBLE);
    }
    /**
     * 隐藏导航栏中间文字
     */
    public void hideTitle() {
        textViewTitle.setVisibility(View.GONE);
    }

    /**
     * 返回 持有导航栏xml资源的view，以便提供给该view的父view group 进行操作
     */
    public View getView() {
        return view;
    }

}
