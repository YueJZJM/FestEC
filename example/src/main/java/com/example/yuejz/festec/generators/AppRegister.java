package com.example.yuejz.festec.generators;

import com.example.latte_annotations.annotations.AppRegisterGenerator;
import com.example.latte_annotations.annotations.EntryGenerator;
import com.example.latte_core.wechat.templates.AppRegisterTemplate;
import com.example.latte_core.wechat.templates.WXEntryTemplate;

@AppRegisterGenerator(
        packageName = "com.example.yuejz.festec",
        registerTempleate = AppRegisterTemplate.class
)
public class AppRegister {
}
