package com.example.urbandictionaryjava.viewmodel;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.urbandictionaryjava.model.datasource.urbanDictionary.UrbanDictionaryResponse;
import com.example.urbandictionaryjava.model.datasource.remote.CallBack;
import com.example.urbandictionaryjava.model.datasource.remote.RetrofitHelper;
import com.example.urbandictionaryjava.model.datasource.remote.UrbanDictionaryObserver;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UrbanDictionaryViewModel extends ViewModel implements CallBack, Observable {

    PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();



    @Bindable
    UrbanDictionaryResponse urbanDictionaryResponse;


    public MutableLiveData<UrbanDictionaryResponse> urbanDictionaryResponseMutableLiveData
            = new MutableLiveData<>();

    public void getUrbanDictionaryData(String userInput){
        RetrofitHelper retrofitHelper = new RetrofitHelper();
        retrofitHelper.getUrbanDictionaryApiService().userEntry(userInput)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new UrbanDictionaryObserver(this));
    }

    @Override
    public void onUrbanDictionaryResult(UrbanDictionaryResponse urbanDictionaryResponse) {
        urbanDictionaryResponseMutableLiveData.postValue(urbanDictionaryResponse);
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        propertyChangeRegistry.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        propertyChangeRegistry.remove(callback);
    }

    public UrbanDictionaryResponse getUrbanDictionaryResponse() {
        return urbanDictionaryResponse;
    }

    public void setUrbanDictionaryResponse(UrbanDictionaryResponse urbanDictionaryResponse) {
        this.urbanDictionaryResponse = urbanDictionaryResponse;
    }
}
