package me.jessyan.mvparms.demo.common.data;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;

public class BaseBean implements Serializable, Cloneable, MultiItemEntity {
    protected int itemtype;
    public int getItemType(){
        return itemtype;
    }

    public void setItemtype(int itemtype) {
        this.itemtype = itemtype;
    }
}
