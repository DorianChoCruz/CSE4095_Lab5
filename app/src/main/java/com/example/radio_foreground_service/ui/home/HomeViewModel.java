package com.example.radio_foreground_service.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Radio Player                                                       " +
                "Created By: Dorian Studios                                                       " +
                "Enjoy!");
    }

    public LiveData<String> getText() {
        return mText;
    }
}