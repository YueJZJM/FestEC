package com.example.latte.ec.main.personal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.latte.ec.R;
import com.example.latte.ec.R2;
import com.example.latte.ec.main.personal.address.AddressDelegate;
import com.example.latte.ec.main.personal.list.ListAdapter;
import com.example.latte.ec.main.personal.list.ListBean;
import com.example.latte.ec.main.personal.list.ListItemType;
import com.example.latte.ec.main.personal.order.OrderListDelegate;
import com.example.latte.ec.main.personal.profile.UserPrfileDelegate;
import com.example.latte.ec.main.personal.settings.SettingDelegate;
import com.example.latte_core.delegates.bottom.BottomItemDelegate;

import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;

import butterknife.BindView;
import butterknife.OnClick;


public class PersonalDelegate extends BottomItemDelegate {

    @BindView(R2.id.rv_personal_setting)
    RecyclerView mRecyclerViewSetting;

    public static final String ORDER_TYPE = "ORDER_TYPE";

    private Bundle mArge = null;

    @Override
    public Object setLayout() {
        return R.layout.delegate_personal;
    }

    @OnClick(R2.id.tv_all_order)
    void onClickAllOrder() {
        mArge.putString(ORDER_TYPE,"all");
        startOrderListByType();
    }

    @OnClick(R2.id.img_user_avatar)
    void onClickAvatar() {
        getParentDelegate().getSupportDelegate().start(new UserPrfileDelegate());
    }
    private void startOrderListByType() {
        final OrderListDelegate delegate = new OrderListDelegate();
        delegate.setArguments(mArge);
        getParentDelegate().getSupportDelegate().start(delegate);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mArge = new Bundle();
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        ListBean push = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(1)
                .setDelegate(new AddressDelegate())
                .setText("收货地址")
                .setValue("add")
                .build();

        ListBean system = new ListBean.Builder()
                .setItemType(ListItemType.ITEM_NORMAL)
                .setId(2)
                .setDelegate(new SettingDelegate())
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
        mRecyclerViewSetting.addOnItemTouchListener(new PersonalClickListener(this));
    }
}
