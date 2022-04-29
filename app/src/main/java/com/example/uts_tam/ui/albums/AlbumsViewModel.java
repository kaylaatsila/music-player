package com.example.uts_tam.ui.albums;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AlbumsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AlbumsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is library fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}