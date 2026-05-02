package com.quickreply.app.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.Room;
import android.content.Context;

import com.quickreply.app.models.Phrase;
import com.quickreply.app.dao.PhraseDao;

@Database(entities = {Phrase.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    
    public abstract PhraseDao phraseDao();
    
    private static volatile AppDatabase INSTANCE;
    
    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        AppDatabase.class,
                        "quick_reply_db"
                    ).build();
                }
            }
        }
        return INSTANCE;
    }
}