package com.quickreply.app.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import com.quickreply.app.models.Phrase;

@Dao
public interface PhraseDao {
    
    @Insert
    void insert(Phrase phrase);
    
    @Update
    void update(Phrase phrase);
    
    @Delete
    void delete(Phrase phrase);
    
    @Query("SELECT * FROM phrases WHERE category = :category")
    LiveData<List<Phrase>> getPhrasesByCategory(String category);
    
    @Query("SELECT * FROM phrases WHERE group_name = :groupName AND category = '小组话术'")
    LiveData<List<Phrase>> getPhrasesByGroup(String groupName);
    
    @Query("SELECT * FROM phrases WHERE tags LIKE :tag")
    LiveData<List<Phrase>> getPhrasesByTag(String tag);
    
    @Query("SELECT * FROM phrases WHERE content LIKE :keyword OR tags LIKE :keyword")
    LiveData<List<Phrase>> searchPhrases(String keyword);
    
    @Query("SELECT * FROM phrases WHERE shortcut_key = :shortcutKey")
    Phrase getPhraseByShortcut(String shortcutKey);
    
    @Query("SELECT * FROM phrases ORDER BY updated_at DESC")
    LiveData<List<Phrase>> getAllPhrases();
}