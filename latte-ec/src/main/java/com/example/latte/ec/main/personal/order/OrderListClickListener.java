package com.example.latte.ec.main.personal.order;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.SimpleClickListener;

public class OrderListClickListener extends SimpleClickListener {

    private final OrderListDelegate delegate;

    public OrderListClickListener(OrderListDelegate delegate) {
        this.delegate = delegate;
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        delegate.getSupportDelegate().start(new OrderCommentDelegate());
    }

    @Override
    public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
