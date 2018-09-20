package com.example.latte.ec.main.sort.list;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.latte_core.ui.recycler.DataConverter;
import com.example.latte_core.ui.recycler.ItemType;
import com.example.latte_core.ui.recycler.MultipleFields;
import com.example.latte_core.ui.recycler.MultipleItemEntity;

import java.time.LocalDate;
import java.util.ArrayList;

public final class VerticalListDataConverter extends DataConverter {
    @Override
    public ArrayList<MultipleItemEntity> convert() {
        final ArrayList<MultipleItemEntity> dataList = new ArrayList<>();
        final JSONArray dataArray = JSON
                .parseObject(getJsonData())
                .getJSONObject("data")
                .getJSONArray("list");
        final int size = dataArray.size();
       // Log.d("size",size+"");
        for (int i = 0; i < size; i ++){
            final JSONObject data = dataArray.getJSONObject(i);
            final int id = data.getInteger("id");
            final String name = data.getString("name");

            final MultipleItemEntity entity = MultipleItemEntity.builder()
                    .setField(MultipleFields.ITEM_TYPE, ItemType.VERTICAL_MENU_LIST)
                    .setField(MultipleFields.ID,id)
                    .setField(MultipleFields.TEXT,name)
                    .setField(MultipleFields.TAG,false) //表示是否选中
                    .build();

          //  Log.d("entity",entity.getField(MultipleFields.NAME));
            dataList.add(entity);
        }
        //设置第一个被选中
        dataList.get(0).setField(MultipleFields.TAG,true);
        return dataList;
    }
}
