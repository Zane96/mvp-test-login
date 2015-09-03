package com.example.think.mvp_test_login.Presenter;

import android.content.Intent;
import android.os.Handler;

import com.example.think.mvp_test_login.Model.Bean.Biz.ILoginListener;
import com.example.think.mvp_test_login.Model.Bean.Biz.IUserBiz;
import com.example.think.mvp_test_login.Model.Bean.Biz.UserBiz;
import com.example.think.mvp_test_login.View.ILoginView;



/**
 * Created by think on 2015/8/15.
 * have IUserListener and ILoginView
 */
public class ILoginPresenter {

    private ILoginView iLoginView;

    private IUserBiz iUserBiz;

    private Handler handler = new Handler();

    /**
     * 用实现了接口的类来对接口对象进行实例化，这根以前写的接口回调的setListener()是一个道理
     * 这样写更方便。
     */
    public ILoginPresenter(ILoginView iLoginView){

        iUserBiz = new UserBiz();//对ILoginListener接口进行回调
        this.iLoginView = iLoginView;

    }

    public void login(){
        iLoginView.showLoding();
        iUserBiz.login(iLoginView.getUsername(), iLoginView.getPassword(),
                new ILoginListener() {
                    @Override
                    public void loginSuccess(final String username) {
                        handler.post(() -> {
                            iLoginView.hideLoading();
                            iLoginView.toListviewActivity();
                        });
                    }

                    @Override
                    public void loginFailed() {
                        handler.post(() -> {
                            iLoginView.showFailedError();
                            iLoginView.hideLoading();
                        });
                    }
                });
    }

    public void clear(){
        iLoginView.clearName();
        iLoginView.clearPassword();
    }

}
