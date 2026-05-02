package com.quickreply.app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;

import com.quickreply.app.utils.FloatingWindowManager;

public class MainActivity extends AppCompatActivity {
    
    private FloatingWindowManager floatingWindowManager;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        floatingWindowManager = new FloatingWindowManager(this);
        
        Toast.makeText(this, "快捷回复应用启动", Toast.LENGTH_SHORT).show();
        
        Button btnCreateSnippet = findViewById(R.id.btn_create_snippet);
        btnCreateSnippet.setOnClickListener(v -> {
            Toast.makeText(this, "创建话术功能", Toast.LENGTH_SHORT).show();
            // TODO: 实现创建话术界面
        });
        
        Button btnStartFloating = findViewById(R.id.btn_start_floating);
        btnStartFloating.setOnClickListener(v -> {
            floatingWindowManager.createFloatingWindow();
            Toast.makeText(this, "悬浮窗已启动", Toast.LENGTH_SHORT).show();
        });
    }
}