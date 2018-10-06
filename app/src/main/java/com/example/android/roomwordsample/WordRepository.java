package com.example.android.roomwordsample;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class WordRepository {
    private WordDao wordDao;
    private LiveData<List<Word>> allWords;

    public WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDataBase(application);
        wordDao = db.worddao();
        allWords = wordDao.getAllWords();
    }
    LiveData<List<Word>> getAllWords(){
        return allWords;
    }

    public void insert(Word word) {
        new insertAsyncTask(wordDao).execute(word);
    }

    public static class insertAsyncTask extends AsyncTask<Word,Void,Void> {

        private WordDao mAsyncTaskDao;
        public insertAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Word... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
