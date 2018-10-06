package com.example.android.roomwordsample;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "word_table")
public class Word {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name="word")
    private String word;

//    @PrimaryKey(autoGenerate = true)
//    private int id;

    public String getWord() {
        return this.word;
    }

    public Word(@NonNull String word) {
        this.word = word;
    }

}
