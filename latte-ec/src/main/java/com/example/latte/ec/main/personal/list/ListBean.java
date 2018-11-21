package com.example.latte.ec.main.personal.list;

import android.text.TextUtils;
import android.widget.CompoundButton;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.latte_core.delegates.LatteDelegate;

public class ListBean implements MultiItemEntity {

    private int mItenType = 0;
    private String mImageUrl = null;
    private String mText = null;
    private String mValue = null;
    private int mId = 0 ;
    private LatteDelegate mDelegate = null;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener = null;

    public ListBean(int mItenType, String mImageUrl, String mText, String mValue, int mId, LatteDelegate mDelegate, CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener) {
        this.mItenType = mItenType;
        this.mImageUrl = mImageUrl;
        this.mText = mText;
        this.mValue = mValue;
        this.mId = mId;
        this.mDelegate = mDelegate;
        this.mOnCheckedChangeListener = mOnCheckedChangeListener;
    }





    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getText() {
        if (TextUtils.isEmpty(mText)) {
            return "";
        }
        return mText;
    }

    public void setText(String mText) {
        this.mText = mText;
    }

    public String getValue() {
        if (TextUtils.isEmpty(mValue)) {
            return "";
        }
        return mValue;
    }

    public void setValue(String mValue) {
        this.mValue = mValue;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public LatteDelegate getDelegate() {
        return mDelegate;
    }

    public void setDelegate(LatteDelegate mDelegate) {
        this.mDelegate = mDelegate;
    }

    public CompoundButton.OnCheckedChangeListener getOnClickListener() {
        return mOnCheckedChangeListener;
    }

    public void setOnClickListener(CompoundButton.OnCheckedChangeListener mOnClickListener) {
        this.mOnCheckedChangeListener = mOnClickListener;
    }

    @Override
    public int getItemType() {
        return mItenType;
    }

    public static final class Builder{
        private int id = 0;
        private int itemType = 0;
        private String imageUrl = null;
        private String text = null;
        private String value = null;
        private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener = null;
        private LatteDelegate delegate = null;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setItemType(int itemType) {
            this.itemType = itemType;
            return this;
        }

        public Builder setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder setText(String text) {
            this.text = text;
            return this;
        }

        public Builder setValue(String value) {
            this.value = value;
            return this;
        }

        public Builder setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onClickListener) {
            this.mOnCheckedChangeListener = onClickListener;
            return this;
        }

        public Builder setDelegate(LatteDelegate delegate) {
            this.delegate = delegate;
            return this;
        }

        public ListBean build() {
            return new ListBean(itemType,imageUrl,text,value,id,delegate,mOnCheckedChangeListener);
        }
    }
}
