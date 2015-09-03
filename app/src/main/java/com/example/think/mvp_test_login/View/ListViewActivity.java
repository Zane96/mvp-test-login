package com.example.think.mvp_test_login.View;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.think.mvp_test_login.Model.Bean.Biz.IListviewBiz;
import com.example.think.mvp_test_login.Presenter.IListviewPresenter;
import com.example.think.mvp_test_login.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by think on 2015/9/3.
 */
public class ListViewActivity extends ActionBarActivity implements IListviewView,
        AdapterView.OnItemClickListener{

    @Bind(R.id.id_progressbar)
    ProgressBar progressBar;

    @Bind(R.id.id_listview)
    ListView listView;

    private IListviewPresenter iListviewPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_activity_layout);
        ButterKnife.bind(this);

        listView.setOnItemClickListener(this);

        iListviewPresenter = new IListviewPresenter(this);
        iListviewPresenter.onResume();


    }

    @Override
    public void showProgressbar() {
        progressBar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgressbar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setItem(List<String> items) {
        listView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items));
        listView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(ListViewActivity.this, message, Toast.LENGTH_LONG).show();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        iListviewPresenter.onItemClick(position);
    }

}
