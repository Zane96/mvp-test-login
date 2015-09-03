package com.example.think.mvp_test_login.Presenter;

import com.example.think.mvp_test_login.Model.Bean.Biz.IListviewBiz;
import com.example.think.mvp_test_login.Model.Bean.Biz.ListviewBiz;
import com.example.think.mvp_test_login.Model.Bean.Biz.OnFinishedListener;
import com.example.think.mvp_test_login.View.IListviewView;

import java.util.List;

/**
 * Created by think on 2015/9/3.
 */
public class IListviewPresenter implements IListviewListener, OnFinishedListener{

    private IListviewView iListviewView;
    private IListviewBiz iListviewBiz;

    public IListviewPresenter(IListviewView iListviewView) {
        this.iListviewView = iListviewView;
        iListviewBiz = new ListviewBiz();
    }

    @Override
    public void onResume() {
        iListviewView.showProgressbar();
        iListviewBiz.findItem(this);
    }

    @Override
    public void onItemClick(int position) {
        iListviewView.showMessage("press "+String.valueOf(position+1));
    }

    @Override
    public void Finished(List<String> items) {
        iListviewView.setItem(items);
        iListviewView.hideProgressbar();
    }
}
