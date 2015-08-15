package com.example.think.mvp_test_login.Model.Bean.Biz;

/**
 * Created by think on 2015/8/15.
 */
public interface ILoginListener {

    void loginSuccess(String username);

    void loginFailed();

}
