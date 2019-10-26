package com.aysel.multirowrecyclerview;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_List)
    RecyclerView mRvList;
    @BindView(R.id.swipeLayout)
    SwipeRefreshLayout pullToRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        F_GetData();

        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                F_GetData();
                pullToRefresh.setRefreshing(false);
            }
        });
    }

    private void F_GetData() {
        Adapter mAdapter = new Adapter(DummyData.getData());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);
        mRvList.setLayoutManager(linearLayoutManager);
        mRvList.setAdapter(mAdapter);
    }
}
