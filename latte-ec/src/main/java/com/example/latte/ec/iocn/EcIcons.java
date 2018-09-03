package com.example.latte.ec.iocn;

import com.joanzapata.iconify.Icon;

public enum  EcIcons implements Icon {

    //阿里巴巴矢量图 http://www.iconfont.cn
    icon_scan('\ue606'),
    icon_ali_pay('\ue606');

    private char character;

    EcIcons(char character){
        this.character = character;
    }

    @Override
    public String key() {
        return this.name().replace('_', '-');
    }

    @Override
    public char character() {
        return 0;
    }
}
