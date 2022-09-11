package com.algostackbd.findmybus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        drawerLayout =findViewById(R.id.nav_view);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.frg_cnt,new busInfoAdd());


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navifation_draw_open,R.string.navifation_draw_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState==null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.frg_cnt,new busInfoAdd()).commit();
            navigationView.setCheckedItem(R.id.busInfo);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {

        switch (menuitem.getItemId())
        {
            case R.id.busInfo:
                getSupportFragmentManager().beginTransaction().replace(R.id.frg_cnt,new busInfoAdd()).commit();
                break;
            case R.id.businventore:
                getSupportFragmentManager().beginTransaction().replace(R.id.frg_cnt,new busInventory_update()).commit();
                break;
            case R.id.updateTransport:
                getSupportFragmentManager().beginTransaction().replace(R.id.frg_cnt,new bus_trans_demand()).commit();
                break;
            case R.id.logout:
                Intent myIntent = new Intent(MainActivity.this, Adcon.class);
                startActivity(myIntent);
                finishAffinity();
                break;

        }

        drawerLayout.closeDrawer(GravityCompat.START);



        return true;
    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }

    }

}