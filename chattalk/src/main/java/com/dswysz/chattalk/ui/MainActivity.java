package com.dswysz.chattalk.ui;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.dswysz.chattalk.R;
import com.dswysz.chattalk.utils.FragmentFactory;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

public class MainActivity extends AppCompatActivity {

    private BottomBar mBottomBar;
    private int mCurrentItem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.setItemsFromMenu(R.menu.botton_nav, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                // The user selected item number one.
                switch (menuItemId) {
                    case R.id.bottomBarHome:
                        mCurrentItem = 0;
                        break;
                    case R.id.bottomBarTools:
                        mCurrentItem = 1;
                        break;
                    case R.id.bottomBarAbout:
                        mCurrentItem = 2;
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment, FragmentFactory.getFragment(mCurrentItem)).commit();
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }
        });
        mBottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorAccent));
        mBottomBar.mapColorForTab(1, "#FF5D4037");
        mBottomBar.mapColorForTab(2, "#7B1FA2");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.
        mBottomBar.onSaveInstanceState(outState);
    }


}
