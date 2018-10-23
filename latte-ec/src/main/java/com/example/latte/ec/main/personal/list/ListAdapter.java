package com.example.latte.ec.main.personal.list;

import android.util.Log;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.latte.ec.R;

import java.util.List;

public class ListAdapter extends BaseMultiItemQuickAdapter<ListBean,BaseViewHolder> {

    public ListAdapter(List<ListBean> data) {
        super(data);
        addItemType(ListItemType.ITEM_NORMAL,R.layout.arrow_item_layout);
       // addItemType(0,R.layout.array_item_zero);
    }

    @Override
    protected void convert(BaseViewHolder helper, ListBean item) {
        switch (helper.getItemViewType()) {
            case ListItemType.ITEM_NORMAL:
                helper.setText(R.id.tv_arrow_text,  item.getText());
                helper.setText(R.id.tv_arrow_value, item.getValue());
              //  Log.d("convert", ListItemType.ITEM_NORMAL + "");
                break;
            default:
                break;
        }
    }

}
