package com.example.think.mvp_test_login.View;

import android.text.Editable;

/**
 * Created by think on 2015/8/15.
 */
public interface ILoginView {

    /**
     * things that presenter wanted when login
     */
    String getUsername();
    String  getPassword();

    /**
     * the thing to do when you press clear button
     */
    void clearName();
    void clearPassword();

    /**
     * make the progressbar visible or gone
     */
    void showLoding();
    void hideLoading();

    /**
     * do something when I have a response
     */
    void toListviewActivity();
    void showFailedError();
}
