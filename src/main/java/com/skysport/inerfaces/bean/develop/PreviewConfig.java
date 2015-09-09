package com.skysport.inerfaces.bean.develop;

import com.skysport.inerfaces.bean.Extra;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/20.
 */
public class PreviewConfig {
    private String caption;
    private String width;
    private String url;
    private String key;
    private Extra extra;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }
}
