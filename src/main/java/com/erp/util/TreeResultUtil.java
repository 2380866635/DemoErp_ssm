package com.erp.util;

import java.util.List;

public class TreeResultUtil {
    private int id;//指定的id
    private String text;//展示的内容
    private  String iconCls;//权限图标
    private  String url;
    private List<TreeResultUtil> children;

    @Override
    public String toString() {
        return "TreeResultUtil{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", url='" + url + '\'' +
                ", children=" + children +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<TreeResultUtil> getChildren() {
        return children;
    }

    public void setChildren(List<TreeResultUtil> children) {
        this.children = children;
    }
}
