package com.example.yuejz.festec.generators;

import com.example.latte_annotations.annotations.EntryGenerator;
import com.example.latte_core.wechat.templates.WXEntryTemplate;

@EntryGenerator(
        packageName = "com.example.yuejz.festec",
        entryTemplete = WXEntryTemplate.class
)
public class WeChatEntry {
}
