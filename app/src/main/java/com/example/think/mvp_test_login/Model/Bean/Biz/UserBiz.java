package com.example.think.mvp_test_login.Model.Bean.Biz;

import com.example.think.mvp_test_login.Model.Bean.User;

/**
 * Created by think on 2015/8/15.
 * 这里面model主要是抛出一些接口，在这个project里面，model主要存储了如何让view调用什么方法。怎么显示的
 * 一些东西，比如loginSuccess(), loginFailed();
 * login就负责在presenter中与view进行数据交互。
 */
public class UserBiz implements IUserBiz{

    User user = new User();

    @Override
    public void login(final String username, final String  userpassword, final ILoginListener listener) {

        /**
         * set the right information
         */
        user.setUserName("Zane");
        user.setUesrPassword("123");
        /**
         * Login will take much time,so I have a thread to sleep 2s
         */
        new Thread(){
            @Override
            public void run() {
                try {

                    this.sleep(2000);

                    if(username.equals(user.getUserName()) &&
                            userpassword.equals(user.getUesrPassword())){
                        listener.loginSuccess(username);
                    }else {
                        listener.loginFailed();

                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
