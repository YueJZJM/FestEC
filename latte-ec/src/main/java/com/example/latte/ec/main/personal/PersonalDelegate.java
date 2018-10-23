package com.example.latte.ec.main.personal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.latte.ec.R;
import com.example.latte.ec.R2;
import com.example.latte.ec.main.personal.list.ListAdapter;
import com.example.latte.ec.main.personal.list.ListBean;
import com.example.latte.ec.main.personal.list.ListItemType;
import com.example.latte_core.delegates.bottom.BottomItemDelegate;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class PersonalDelegate extends BottomItemDelegate {

    @BindView(R2.id.rv_personal_setting)
    RecyclerView mRecyclerViewSetting;

    @Override
    public Object setLayout() {
        return R.layout.delegate_personal;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        ListBean push = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(1)
                .setText("收货地址")
                .setValue("add")
                .build();

        ListBean system = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(2)
                .setText("系统设置")
                .setValue("add")
                .build();

        final List<ListBean> data = new ArrayList<>();
        data.add(push);
        data.add(system);

        //设置RecyclerView
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRecyclerViewSetting.setLayoutManager(manager);
        ListAdapter adapter = new ListAdapter(data);
        mRecyclerViewSetting.setAdapter(adapter);
    }
}
