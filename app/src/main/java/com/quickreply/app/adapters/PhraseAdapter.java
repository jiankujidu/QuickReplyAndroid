package com.quickreply.app.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.quickreply.app.models.Phrase;

public class PhraseAdapter extends RecyclerView.Adapter<PhraseAdapter.ViewHolder> {
    
    private List<Phrase> phrases;
    
    public PhraseAdapter(List<Phrase> phrases) {
        this.phrases = phrases;
    }
    
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.phrase_item, parent, false);
        return new ViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Phrase phrase = phrases.get(position);
        
        holder.content.setText(phrase.getContent());
        holder.shortcut.setText(phrase.getShortcutKey() != null ? phrase.getShortcutKey() : "");
        
        // 根据标签设置颜色
        String tags = phrase.getTags();
        if (tags.contains("售前")) {
            holder.colorIndicator.setBackgroundColor(android.graphics.Color.GREEN);
        } else if (tags.contains("售后")) {
            holder.colorIndicator.setBackgroundColor(android.graphics.Color.RED);
        } else if (tags.contains("价格")) {
            holder.colorIndicator.setBackgroundColor(android.graphics.Color.BLUE);
        } else {
            holder.colorIndicator.setBackgroundColor(android.graphics.Color.YELLOW);
        }
        
        // 点击发送话术
        holder.itemView.setOnClickListener(v -> {
            // TODO: 实现发送话术功能
        });
    }
    
    @Override
    public int getItemCount() {
        return phrases.size();
    }
    
    public void updatePhrases(List<Phrase> newPhrases) {
        phrases = newPhrases;
        notifyDataSetChanged();
    }
    
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView content;
        TextView shortcut;
        View colorIndicator;
        
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.phrase_content);
            shortcut = itemView.findViewById(R.id.shortcut_key);
            colorIndicator = itemView.findViewById(R.id.color_indicator);
        }
    }
}