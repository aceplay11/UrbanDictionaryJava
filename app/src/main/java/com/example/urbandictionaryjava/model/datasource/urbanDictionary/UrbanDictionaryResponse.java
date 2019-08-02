
package com.example.urbandictionaryjava.model.datasource.urbanDictionary;


import com.google.gson.annotations.Expose;


public class UrbanDictionaryResponse {

    @Expose
    private java.util.List<com.example.urbandictionaryjava.model.datasource.urbanDictionary.List> list;

    public java.util.List<com.example.urbandictionaryjava.model.datasource.urbanDictionary.List> getList() {
        return list;
    }

    public void setList(java.util.List<com.example.urbandictionaryjava.model.datasource.urbanDictionary.List> list) {
        this.list = list;
    }

}
