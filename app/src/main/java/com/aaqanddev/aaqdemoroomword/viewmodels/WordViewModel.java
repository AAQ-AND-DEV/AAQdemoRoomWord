package com.aaqanddev.aaqdemoroomword.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.aaqanddev.aaqdemoroomword.database.Word;
import com.aaqanddev.aaqdemoroomword.repos.WordRepo;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WordRepo mRepo;
    private LiveData<List<Word>> mAllWords;

    public WordViewModel(Application application){
        super(application);
        mRepo = new WordRepo(application);
        mAllWords = mRepo.getAllWords();

    }

    public LiveData<List<Word>> getAllWords(){return mAllWords;}

    public void insert(Word word){mRepo.insert(word);}
}
