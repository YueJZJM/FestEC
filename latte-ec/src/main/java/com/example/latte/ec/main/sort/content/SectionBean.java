package com.example.latte.ec.main.sort.content;

import com.chad.library.adapter.base.entity.SectionEntity;

public class SectionBean extends SectionEntity<SectionContentItemEntity> {

    private boolean mIsMore = false;
    private int mId = -1;

    public boolean isMore() {
        return mIsMore;
    }

    public void setIsMore(boolean isMore) {
        this.mIsMore = isMore;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    //isHeader为true表示是不是分组开头部分，false表示是内容部分
    public SectionBean(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public SectionBean(SectionContentItemEntity sectionContentItemEntity) {
        super(sectionContentItemEntity);
    }


}
