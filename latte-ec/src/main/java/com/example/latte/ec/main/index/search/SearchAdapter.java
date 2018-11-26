package com.example.latte.ec.main.index.search;

import android.support.v7.widget.AppCompatTextView;

import com.example.latte.ec.R;
import com.example.latte_core.ui.recycler.MultipleFields;
import com.example.latte_core.ui.recycler.MultipleItemEntity;
import com.example.latte_core.ui.recycler.MultipleRecyclerAdapter;
import com.example.latte_core.ui.recycler.MultipleViewHolder;

import java.util.List;

public class SearchAdapter extends MultipleRecyclerAdapter {
    protected SearchAdapter(List<MultipleItemEntity> data) {
        super(data);
        addItemType(SearchItemType.ITEM_SEARCH,R.layout.item_search);
    }

    @Override
    protected void convert(MultipleViewHolder holder, MultipleItemEntity item) {
        super.convert(holder, item);
        switch (item.getItemType()) {
            case SearchItemType.ITEM_SEARCH:
                final AppCompatTextView tvSearchView = holder.getView(R.id.tv_search_item2);
                final String history = item.getField(MultipleFields.TEXT);
                tvSearchView.setText(history);
                break;
            default:
                break;
        }
    }
}
