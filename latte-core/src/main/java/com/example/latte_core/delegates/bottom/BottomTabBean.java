package com.example.latte_core.delegates.bottom;

public final class BottomTabBean {
    private final CharSequence ICON;
    private final CharSequence TITLE;
    //变量声明为final，在构造函数中赋值，是线程安全的
    public BottomTabBean(CharSequence icon, CharSequence title) {
        this.ICON = icon;
        this.TITLE = title;
    }

    public CharSequence getIcon() {
        return ICON;
    }

    public CharSequence getTitle() {
        return TITLE;
    }
}
