package com.example.latte.ec.main.index;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;

import com.example.latte.ec.R;
import com.example.latte_core.ui.recycler.RgbValue;

//通过反射的方式来写这个方法
@SuppressWarnings("ALL")
public class TransluncentBehavior extends CoordinatorLayout.Behavior<Toolbar> {

    //顶部距离
    private int mDistanceY = 0;
    //颜色变化速度
    private static final int SHOW_SPEED = 3;
    //定义颜色变化
    private final RgbValue RGB_VALUE = RgbValue.create(255,124,2);


    //必须有这个构造函数
    public TransluncentBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, Toolbar child, View dependency) {
        return dependency.getId() == R.id.rv_index;
    }


    //接管它的事件
    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Toolbar child, @NonNull View directTargetChild,
                                       @NonNull View target, int axes, int type) {
        return true;
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Toolbar child, @NonNull View target, int dx, int dy,
                                  @NonNull int[] consumed, int type) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
        //增加滑动距离，每次滑动都会变大
        mDistanceY += dy;
        //toolbar 的高度
        final int targetHeight = child.getBottom();
        //当滑动时，并且距离小于toolbar高度时，调整渐变色
        if (mDistanceY > 0 && mDistanceY <= targetHeight){
            final float scale =(float) mDistanceY/targetHeight;
            final float alpha = scale * 255;
            child.setBackgroundColor(Color.argb((int) alpha,RGB_VALUE.red(),RGB_VALUE.green(),RGB_VALUE.blue()));
        }else if (mDistanceY > targetHeight){ //滑动的距离大于oolbar高度时，恢复原来的颜色
            child.setBackgroundColor(Color.rgb(RGB_VALUE.red(),RGB_VALUE.green(),RGB_VALUE.blue()));
        }
    }
}
