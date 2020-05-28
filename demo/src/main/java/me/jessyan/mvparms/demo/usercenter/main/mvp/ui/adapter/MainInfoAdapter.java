package me.jessyan.mvparms.demo.usercenter.main.mvp.ui.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import javax.inject.Inject;

import me.jessyan.mvparms.demo.usercenter.main.mvp.model.entity.MainBean;

public class MainInfoAdapter extends BaseQuickAdapter<MainBean,BaseViewHolder> {

    @Inject
    public MainInfoAdapter(@Nullable List<MainBean> data) {
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MainBean item) {

    }
}
