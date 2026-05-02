package com.quickreply.app.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TabHost;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import com.quickreply.app.models.Phrase;
import com.quickreply.app.adapters.PhraseAdapter;

public class PhraseListActivity extends AppCompatActivity {
    
    private RecyclerView recyclerView;
    private PhraseAdapter adapter;
    private List<Phrase> phrases = new ArrayList<>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrase_list);
        
        // 初始化话术示例数据
        initSamplePhrases();
        
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PhraseAdapter(phrases);
        recyclerView.setAdapter(adapter);
        
        // 搜索功能
        SearchView searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            
            @Override
            public boolean onQueryTextChange(String newText) {
                filterPhrases(newText);
                return true;
            }
        });
        
        // 新建话术按钮
        Button btnAddPhrase = findViewById(R.id.btn_add_phrase);
        btnAddPhrase.setOnClickListener(v -> {
            // TODO: 打开新建话术界面
        });
        
        // 选项卡切换
        TabHost tabHost = findViewById(R.id.tab_host);
        tabHost.setup();
        
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("company");
        tabSpec1.setIndicator("公司话术");
        tabSpec1.setContent(R.id.tab_company);
        
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("group");
        tabSpec2.setIndicator("小组话术");
        tabSpec2.setContent(R.id.tab_group);
        
        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("personal");
        tabSpec3.setIndicator("私人话术");
        tabSpec3.setContent(R.id.tab_personal);
        
        tabHost.addTab(tabSpec1);
        tabHost.addTab(tabSpec2);
        tabHost.addTab(tabSpec3);
    }
    
    private void initSamplePhrases() {
        // 公司话术示例
        Phrase phrase1 = new Phrase();
        phrase1.setContent("您好，欢迎咨询我们的产品！");
        phrase1.setCategory("公司话术");
        phrase1.setTags("售前,欢迎");
        phrase1.setColor(android.graphics.Color.GREEN);
        phrases.add(phrase1);
        
        Phrase phrase2 = new Phrase();
        phrase2.setContent("请问您对我们的产品有什么疑问吗？");
        phrase2.setCategory("公司话术");
        phrase2.setTags("售前,提问");
        phrase2.setColor(android.graphics.Color.BLUE);
        phrases.add(phrase2);
        
        Phrase phrase3 = new Phrase();
        phrase3.setContent("产品价格是¥299元");
        phrase3.setCategory("公司话术");
        phrase3.setTags("价格");
        phrase3.setColor(android.graphics.Color.RED);
        phrases.add(phrase3);
        
        Phrase phrase4 = new Phrase();
        phrase4.setContent("感谢您的反馈！");
        phrase4.setCategory("公司话术");
        phrase4.setTags("售后,感谢");
        phrase4.setColor(android.graphics.Color.YELLOW);
        phrases.add(phrase4);
        
        // 小组话术示例
        Phrase phrase5 = new Phrase();
        phrase5.setContent("周末活动：全场8折优惠！");
        phrase5.setCategory("小组话术");
        phrase5.setGroupName("促销小组");
        phrase5.setTags("促销,活动");
        phrase5.setColor(android.graphics.Color.CYAN);
        phrases.add(phrase5);
        
        // 私人话术示例
        Phrase phrase6 = new Phrase();
        phrase6.setContent("这是我常用的客户问候语");
        phrase6.setCategory("私人话术");
        phrase6.setTags("问候");
        phrase6.setColor(android.graphics.Color.MAGENTA);
        phrases.add(phrase6);
    }
    
    private void filterPhrases(String keyword) {
        List<Phrase> filtered = new ArrayList<>();
        for (Phrase phrase : phrases) {
            if (phrase.getContent().contains(keyword) || 
                phrase.getTags().contains(keyword)) {
                filtered.add(phrase);
            }
        }
        adapter.updatePhrases(filtered);
    }
}