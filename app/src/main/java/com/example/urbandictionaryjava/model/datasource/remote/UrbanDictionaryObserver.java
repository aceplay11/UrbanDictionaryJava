package com.example.urbandictionaryjava.model.datasource.remote;

import android.util.Log;

import com.example.urbandictionaryjava.model.datasource.urbanDictionary.UrbanDictionaryResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class UrbanDictionaryObserver implements Observer<UrbanDictionaryResponse> {
    CallBack callBack;
    UrbanDictionaryResponse urbanDictionaryResponse;

    public UrbanDictionaryObserver(CallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(UrbanDictionaryResponse urbanDictionaryResponse) {
        this.urbanDictionaryResponse = urbanDictionaryResponse;
    }

    @Override
    public void onError(Throwable e) {
        Log.e("TAG", "onError: Urban Dictionary Error" + e.getMessage(), e);

    }

    @Override
    public void onComplete() {
        callBack.onUrbanDictionaryResult(urbanDictionaryResponse);
    }
}
