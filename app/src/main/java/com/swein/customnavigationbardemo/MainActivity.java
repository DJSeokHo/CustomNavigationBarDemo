package com.swein.customnavigationbardemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.swein.customnavigationbardemo.navigationbarviewholder.NavigationBarViewHolder;

/**
 * 该项目使用androidx包
 *
 * 可以在 gradle.properties里添加
 * android.useAndroidX=true
 * android.enableJetifier=true
 * 以便启用androidx
 *
 * 如果不用androidx
 * 可以自己修改成目前使用的support包
 */
public class MainActivity extends Activity {

    private FrameLayout frameLayoutNavigationBarContainer;
    private TextView textView;

    private NavigationBarViewHolder navigationBarViewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setStatusBarColor();
        findView();
        initNavigationBar();
    }

    /**
     * 改变系统状态栏颜色
     */
    private void setStatusBarColor() {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#EE6E60"));
    }

    private void findView() {
        frameLayoutNavigationBarContainer = findViewById(R.id.frameLayoutNavigationBarContainer);
        textView = findViewById(R.id.textView);
    }

    /**
     * 初始化导航栏
     */
    private void initNavigationBar() {
        navigationBarViewHolder = new NavigationBarViewHolder(this, new NavigationBarViewHolder.NavigationBarViewHolderDelegate() {
            @Override
            public void onLeftClicked() {
                textView.setText("点击了导航栏左键");
            }

            @Override
            public void onRightClicked() {
                textView.setText("点击了导航栏右键");
            }
        }, frameLayoutNavigationBarContainer);

        navigationBarViewHolder.setTitle("自定义导航栏");
        navigationBarViewHolder.showTitle();

        navigationBarViewHolder.setLeft(R.drawable.icon_back);
        navigationBarViewHolder.showLeft();

        navigationBarViewHolder.setRight(R.drawable.icon_menu);
        navigationBarViewHolder.showRight();

    }

    /**
     * 移除导航栏
     */
    private void removeNavigationBar() {

        if(navigationBarViewHolder != null) {
            frameLayoutNavigationBarContainer.removeView(navigationBarViewHolder.getView());
            navigationBarViewHolder = null;
        }
    }

    @Override
    protected void onDestroy() {
        removeNavigationBar();
        super.onDestroy();
    }
}
