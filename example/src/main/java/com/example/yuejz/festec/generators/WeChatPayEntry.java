package com.example.yuejz.festec.generators;

import com.example.latte_annotations.annotations.EntryGenerator;
import com.example.latte_annotations.annotations.PayEntryGenerator;
import com.example.latte_core.wechat.templates.WXEntryTemplate;
import com.example.latte_core.wechat.templates.WXPayEntryTemplate;

@PayEntryGenerator(
        packageName = "com.example.yuejz.festec",
        payEntryTemplete = WXPayEntryTemplate.class
)
public class WeChatPayEntry {
}
