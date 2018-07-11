package com.aaqanddev.aaqdemoroomword.repos;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.aaqanddev.aaqdemoroomword.database.Word;
import com.aaqanddev.aaqdemoroomword.database.WordDao;
import com.aaqanddev.aaqdemoroomword.database.WordRoomDatabase;

import java.util.List;

public class WordRepo {
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public WordRepo(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDb(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    public LiveData<List<Word>> getAllWords(){
        return mAllWords;
    }

    public void insert (Word word){
        new insertAsyncTask(mWordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void>{
        private WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... words) {
            mAsyncTaskDao.insert(words[0]);
            return null;
        }
    }
}
