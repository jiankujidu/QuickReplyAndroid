package com.quickreply.app.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class FloatingWindowManager {
    
    private Context context;
    private WindowManager windowManager;
    private View floatingView;
    private WindowManager.LayoutParams params;
    
    public FloatingWindowManager(Context context) {
        this.context = context;
    }
    
    /**
     * 检查并请求悬浮窗权限
     */
    public boolean checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(context)) {
                Toast.makeText(context, "需要悬浮窗权限", Toast.LENGTH_SHORT).show();
                // 跳转到权限设置页面
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + context.getPackageName()));
                context.startActivity(intent);
                return false;
            }
        }
        return true;
    }
    
    /**
     * 创建悬浮窗
     */
    public void createFloatingWindow() {
        if (!checkPermission()) {
            return;
        }
        
        windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        floatingView = inflater.inflate(R.layout.floating_view, null);
        
        params = new WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ?
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY :
                WindowManager.LayoutParams.TYPE_PHONE,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            android.graphics.PixelFormat.TRANSLUCENT
        );
        
        params.gravity = Gravity.TOP | Gravity.LEFT;
        params.x = 0;
        params.y = 100;
        
        windowManager.addView(floatingView, params);
        
        setupFloatingWindowControls();
    }
    
    /**
     * 设置悬浮窗控制
     */
    private void setupFloatingWindowControls() {
        View floatingIcon = floatingView.findViewById(R.id.floating_icon);
        
        floatingIcon.setOnClickListener(v -> {
            View phraseMenu = floatingView.findViewById(R.id.phrase_menu);
            phraseMenu.setVisibility(phraseMenu.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
        });
        
        floatingIcon.setOnLongClickListener(v -> {
            destroyFloatingWindow();
            return true;
        });
        
        floatingIcon.setOnTouchListener(new DragListener(params, windowManager, floatingView));
    }
    
    /**
     * 销毁悬浮窗
     */
    public void destroyFloatingWindow() {
        if (floatingView != null) {
            windowManager.removeView(floatingView);
            floatingView = null;
        }
    }
    
    /**
     * 拖动监听器
     */
    static class DragListener implements View.OnTouchListener {
        private WindowManager.LayoutParams params;
        private WindowManager windowManager;
        private View floatingView;
        private int initialX, initialY;
        private float initialTouchX, initialTouchY;
        
        public DragListener(WindowManager.LayoutParams params, 
                          WindowManager windowManager, View floatingView) {
            this.params = params;
            this.windowManager = windowManager;
            this.floatingView = floatingView;
        }
        
        @Override
        public boolean onTouch(View v, android.view.MotionEvent event) {
            switch (event.getAction()) {
                case android.view.MotionEvent.ACTION_DOWN:
                    initialX = params.x;
                    initialY = params.y;
                    initialTouchX = event.getRawX();
                    initialTouchY = event.getRawY();
                    return true;
                case android.view.MotionEvent.ACTION_MOVE:
                    params.x = initialX + (int) (event.getRawX() - initialTouchX);
                    params.y = initialY + (int) (event.getRawY() - initialTouchY);
                    windowManager.updateViewLayout(floatingView, params);
                    return true;
            }
            return false;
        }
    }
}