package com.yf.munews.widget.view;

import android.content.Context;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ${yf} on 2017/3/10.
 */

public class FlodDrawerLayout extends DrawerLayout {

    public FlodDrawerLayout(Context context) {
        super(context);
    }

    public FlodDrawerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (isDrawerView(child)) {
                FoldLayout foldLayout = new FoldLayout(getContext());
                removeView(child);
                foldLayout.addView(child);
                ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
                addView(foldLayout, i, layoutParams);
            }
        }
        setDrawerListener(new DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                if (drawerView instanceof FoldLayout) {
                    FoldLayout foldLayout = (FoldLayout) drawerView;
                    Log.e("TAG", "slideoffset" + slideOffset);
                    foldLayout.setFactor(slideOffset);
                    foldLayout.setAnchor(1);//DrawerLayout因为其侧滑菜单只能显示侧滑布局右侧的50%，
                    //往右侧拉的时候拉50%才能显示出来
                    // 所以要设置搜索的原始坐标点
                }
            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    boolean isDrawerView(View child) {
        final int gravity = ((LayoutParams) child.getLayoutParams()).gravity;
        final int absGravity = GravityCompat.getAbsoluteGravity(gravity,
                ViewCompat.getLayoutDirection(child));
        return (absGravity & (Gravity.LEFT | Gravity.RIGHT)) != 0;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
