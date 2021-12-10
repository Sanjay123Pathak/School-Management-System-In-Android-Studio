package com.example.schoolmanagementsystemapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class NavigationDrawerPage extends AppCompatActivity {
  NavigationView navView;
  ActionBarDrawerToggle toggle;
  DrawerLayout drawerLayout;
  FrameLayout frameLayout;
  Toolbar toolbar;
  Fragment fragment=null;
//  int backCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer_page);

        frameLayout=findViewById(R.id.fragment_container);

        //1ST WORK
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // 2ND WORK
        navView=findViewById(R.id.navView);
        drawerLayout=findViewById(R.id.NavDrawer);
        //3RD WORK
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_toolbar,R.string.close_toolbar);
        // changing the hamburgerIcon color
        toggle.getDrawerArrowDrawable().setColor(Color.WHITE);
        //drawer is listening this toggle
        drawerLayout.addDrawerListener(toggle);
        // sync it
        toggle.syncState();

        // by default home fragment rahega
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
        navView.setCheckedItem(R.id.homeIcon);

        // on click on the nav  this happens
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                 switch (item.getItemId())
                 {
                     case R.id.homeIcon:
                         Toast.makeText(getApplicationContext(), "Home is clicked", Toast.LENGTH_LONG).show();
//                         drawerLayout.closeDrawer(GravityCompat.START);//THIS WILL GO TO END WHERE IT HAS BEEN STARTED FROM
                         fragment= new HomeFragment();
                         loadFragment(fragment);

                         break;


                     case R.id.settingIcon:
                         Toast.makeText(getApplicationContext(), "Setting is clicked", Toast.LENGTH_LONG).show();
//                         drawerLayout.closeDrawer(GravityCompat.START);//THIS WILL GO TO END WHERE IT HAS BEEN STARTED FROM
//                         settingItem();

                         break;
                     case R.id.announcementIcon:
                         Toast.makeText(getApplicationContext(), "Notification is clicked", Toast.LENGTH_LONG).show();
                         fragment= new AnnouncementFragmentDetails();
                         loadFragment(fragment);

                         break;
                     case R.id.logOutIcon:
                         Toast.makeText(getApplicationContext(), "Logout  is clicked", Toast.LENGTH_LONG).show();
//                         drawerLayout.closeDrawer(GravityCompat.START);//THIS WILL GO TO END WHERE IT HAS BEEN STARTED FROM
//                         Intent i = new Intent(NavigationDrawerPage.this, MainActivity.class);
//                         startActivity(i);
//                         finish();
                         Intent i = new Intent(NavigationDrawerPage.this, LoginPage.class);
                         startActivity(i);
                         break;
                     default:
                 }
//                 getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,temp).commit();
                // 93 line was showing error that is null reference object a
                drawerLayout.closeDrawer(GravityCompat.START);//THIS WILL GO TO END WHERE IT HAS BEEN STARTED FROM


                return true;
            }
        });
    }
//    public  void settingItem() {
//        //Creating the instance of PopupMenu
//        PopupMenu popup = new PopupMenu(NavigationDrawerPage.this, navView);
//        //Inflating the Popup using xml file
//        popup.getMenuInflater().inflate(R.menu.setting_menu_item, popup.getMenu());
//
//        //registering popup with OnMenuItemClickListener
//        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.goToHome:
//                        Intent i= new Intent(NavigationDrawerPage.this,HomeFragment.class);
//                        startActivity(i);
//                        finish();
//                        break;
//                    case  R.id.goToLogin:
//                        Intent li= new Intent(NavigationDrawerPage.this,LoginPage.class);
//                        startActivity(li);
//                        finish();
//                    default:
//                }
//                Toast.makeText(NavigationDrawerPage.this, "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
//
//                return true;
////            }
//
//        });
//        popup.show();
//    }

    public  void loadFragment(Fragment fragment){
        FragmentManager fragmentManager= getSupportFragmentManager();
//        backCount=fragmentManager.getBackStackEntryCount();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragment);
        // major change
        fragmentTransaction.addToBackStack(null).commit();
    }


}