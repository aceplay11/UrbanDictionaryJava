package com.example.urbandictionaryjava.model.datasource.remote;

import com.example.urbandictionaryjava.model.datasource.urbanDictionary.UrbanDictionaryResponse;

public interface CallBack {
    void onUrbanDictionaryResult(UrbanDictionaryResponse urbanDictionaryResponse);
}
