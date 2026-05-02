package com.quickreply.app.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "phrases")
public class Phrase {
    @PrimaryKey(autoGenerate = true)
    private int id;
    
    @ColumnInfo(name = "content")
    private String content;
    
    @ColumnInfo(name = "category")
    private String category; // 公司话术/小组话术/私人话术
    
    @ColumnInfo(name = "group_name")
    private String groupName; // 小组名称
    
    @ColumnInfo(name = "tags")
    private String tags; // 标签（多彩分类）
    
    @ColumnInfo(name = "color")
    private int color; // 颜色标识
    
    @ColumnInfo(name = "shortcut_key")
    private String shortcutKey; // 快捷键
    
    @ColumnInfo(name = "media_path")
    private String mediaPath; // 多媒体路径
    
    @ColumnInfo(name = "created_at")
    private long createdAt;
    
    @ColumnInfo(name = "updated_at")
    private long updatedAt;
    
    public Phrase() {
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = System.currentTimeMillis();
    }
    
    // Getters and Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
        this.updatedAt = System.currentTimeMillis();
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
        this.updatedAt = System.currentTimeMillis();
    }
    
    public String getGroupName() {
        return groupName;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
        this.updatedAt = System.currentTimeMillis();
    }
    
    public String getTags() {
        return tags;
    }
    
    public void setTags(String tags) {
        this.tags = tags;
        this.updatedAt = System.currentTimeMillis();
    }
    
    public int getColor() {
    return color;
    }
    
    public void setColor(int color) {
        this.color = color;
        this.updatedAt = System.currentTimeMillis();
    }
    
    public String getShortcutKey() {
        return shortcutKey;
    }
    
    public void setShortcutKey(String shortcutKey) {
        this.shortcutKey = shortcutKey;
        this.updatedAt = System.currentTimeMillis();
    }
    
    public String getMediaPath() {
        return mediaPath;
    }
    
    public void setMediaPath(String mediaPath) {
        this.mediaPath = mediaPath;
        this.updatedAt = System.currentTimeMillis();
    }
    
    public long getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
    
    public long getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }
}