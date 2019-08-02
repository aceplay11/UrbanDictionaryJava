package com.example.urbandictionaryjava.model.datasource.remote;

import com.example.urbandictionaryjava.model.datasource.urbanDictionary.UrbanDictionaryResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import static com.example.urbandictionaryjava.model.datasource.remote.UrlConstants.HOST_HEADER;
import static com.example.urbandictionaryjava.model.datasource.remote.UrlConstants.KEY_HEADER;
import static com.example.urbandictionaryjava.model.datasource.remote.UrlConstants.PATH;

public interface UrbanDictionaryApiService {


    @GET(PATH)
    @Headers({HOST_HEADER, KEY_HEADER})
    Observable<UrbanDictionaryResponse> userEntry(@Query("term")String input) ;
}
