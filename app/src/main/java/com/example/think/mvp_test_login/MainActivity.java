package com.example.think.mvp_test_login;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.example.think.mvp_test_login.Presenter.ILoginPresenter;
import com.example.think.mvp_test_login.View.ILoginView;

/**
 * activity在这里只是view，业务逻辑全部抽出去到presenter
 */
public class MainActivity extends ActionBarActivity implements ILoginView{

    private EditText userName, passWord;

    private Button login, clear;

    private ProgressBar progressBar;

    private ILoginPresenter presenter = new ILoginPresenter(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    /**
     * view还负责初始化组件
     */
    private void initView() {

        userName = (EditText)findViewById(R.id.account);
        passWord = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.button_login);
        clear = (Button)findViewById(R.id.button_clear);
        progressBar = (ProgressBar)findViewById(R.id.progressbar);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clear();
            }
        });
    }

    /**
     * 这些都是如何显示的逻辑，都是view的任务，在presenter里面被调用实现与model的交互
     * @return
     */

    @Override
    public String getUsername() {
        return userName.getText().toString();
    }

    @Override
    public String  getPassword() {
        return passWord.getText().toString();
    }

    @Override
    public void clearName() {
        userName.setText("");
    }

    @Override
    public void clearPassword() {
        passWord.setText("");
    }

    @Override
    public void showLoding() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(String username) {
        Toast.makeText(MainActivity.this, username+" login success",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(MainActivity.this, "Please enter right info",
                Toast.LENGTH_LONG).show();
    }
}
