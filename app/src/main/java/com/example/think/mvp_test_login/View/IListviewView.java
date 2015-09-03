package com.example.think.mvp_test_login.View;

import java.util.List;

/**
 * Created by think on 2015/9/3.
 */
public interface IListviewView {

    public void showProgressbar();

    public void hideProgressbar();

    public void setItem(List<String> items);

    public void showMessage(String message);

}
