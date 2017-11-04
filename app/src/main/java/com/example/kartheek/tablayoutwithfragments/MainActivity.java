package com.example.kartheek.tablayoutwithfragments;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import static com.example.kartheek.tablayoutwithfragments.R.id.tab;

public class MainActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout=(FrameLayout)findViewById(R.id.frame);
        tabLayout=(TabLayout)findViewById(tab);

        TabLayout.Tab firstTab = tabLayout.newTab();
        firstTab.setText("First");
        firstTab.setIcon(android.R.drawable.ic_menu_help);
        tabLayout.addTab(firstTab);

        TabLayout.Tab secondTab = tabLayout.newTab();
        firstTab.setText("Second");
        firstTab.setIcon(android.R.drawable.ic_menu_help);
        tabLayout.addTab(secondTab);

        TabLayout.Tab thirdTab = tabLayout.newTab();
        firstTab.setText("Third");
        firstTab.setIcon(android.R.drawable.ic_menu_help);
        tabLayout.addTab(thirdTab);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                Fragment fragment=null;
                switch (tab.getPosition())
                {

                    case 0:
                        fragment=new FragmentOne();
                        break;
                    case 1:
                        fragment=new FragmentTwo();
                        break;
                    case 3:
                        fragment=new FragmentThree();
                        break;
                }
                //FragmentManager fragmentManager=getFragmentManager();
                FragmentManager fm=getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.frame,fragment);
                ft.setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
