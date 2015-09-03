package com.example.think.mvp_test_login.Model.Bean.Biz;

import android.os.Handler;

import java.util.Arrays;
import java.util.List;

/**
 * Created by think on 2015/9/3.
 */
public class ListviewBiz implements IListviewBiz{

    @Override
    public void findItem(OnFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                listener.Finished(onCreatData());
            }
        }, 2000);

    }


    public List<String> onCreatData(){
        return Arrays.asList("item1","item1","item1","item1","item1","item1"
        ,"item1","item1","item1");
    }
}
