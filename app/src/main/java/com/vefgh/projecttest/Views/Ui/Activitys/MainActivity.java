package com.vefgh.projecttest.Views.Ui.Activitys;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vefgh.projecttest.R;
import com.vefgh.projecttest.Utils.FragmentChanger;
import com.vefgh.projecttest.Views.Ui.Fragments.NewsFragment;
import com.vefgh.projecttest.Views.Ui.Fragments.SearchFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    public static AppCompatActivity self;
    @BindView(R.id.btn_navigation)
    BottomNavigationView btnNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        self = this;
        btnNavigation.setOnNavigationItemSelectedListener(this);
        FragmentChanger.init(MainActivity.self).setCommit(new NewsFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.home:
                FragmentChanger.init(this).setCommitBackStack(new NewsFragment(), "");

                break;
            case R.id.search:
                FragmentChanger.init(this).setCommitBackStack(new SearchFragment(), "");
                break;
        }
        return false;
    }
}
