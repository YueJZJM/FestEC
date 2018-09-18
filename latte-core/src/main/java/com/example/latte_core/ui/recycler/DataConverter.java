package com.example.latte_core.ui.recycler;

import android.text.TextUtils;

import java.util.ArrayList;

public abstract class DataConverter  {

    protected final ArrayList<MultipleItemEntity> ENTITIES = new ArrayList<>();
    private String mJsonData = null;

    public abstract ArrayList<MultipleItemEntity> convert();

    public DataConverter setJsonData(String json) {
        this.mJsonData = json;
        return this;
    }

    protected String getJsonData(){
        if (TextUtils.isEmpty(mJsonData)){
            throw new NullPointerException("DATA IS NULL");
        }
        return mJsonData;
    }
}
