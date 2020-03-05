package com.example.memorise.ui.set;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SetViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> mText;

    public SetViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("这是设置界面");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
