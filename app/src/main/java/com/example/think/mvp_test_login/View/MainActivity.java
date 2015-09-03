package com.example.think.mvp_test_login.View;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.example.think.mvp_test_login.Presenter.ILoginPresenter;
import com.example.think.mvp_test_login.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * activity在这里只是view，业务逻辑全部抽出去到presenter
 */
public class MainActivity extends ActionBarActivity implements ILoginView{

    @Bind(R.id.account)
    EditText userName;
    @Bind(R.id.password)
    EditText passWord;

    @Bind(R.id.button_login)
    Button login;
    @Bind(R.id.button_clear)
    Button clear;

    @Bind(R.id.progressbar)
    ProgressBar progressBar;

    private ILoginPresenter presenter = new ILoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    /**
     *
     */
    private void initView() {

        login.setOnClickListener(v -> presenter.login());

        clear.setOnClickListener(v -> presenter.clear());
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
    public void toListviewActivity() {
        startActivity(new Intent(MainActivity.this, ListViewActivity.class));
    }

    @Override
    public void showFailedError() {
        Toast.makeText(MainActivity.this, "Please enter right info",
                Toast.LENGTH_LONG).show();
    }
}
