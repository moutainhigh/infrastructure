package org.springframework.social.wechat.api.impl.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class ValueColorPairMixin extends WechatObjectMixin {
    @JsonProperty("value")
    private String value;

    @JsonProperty("color")
    private String color;

}
