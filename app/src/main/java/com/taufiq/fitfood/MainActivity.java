package com.taufiq.fitfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(new HomeFragment());

//        TextView textView = findViewById(R.id.login);
//        textView.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            startActivity(new Intent(getApplicationContext(), Login.class));
//        }
//    });
//        TextView textView2 = findViewById(R.id.register);
//        textView2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(), Register.class));
//            }
//        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;

        switch(item.getItemId()){
            case R.id.menu_navigation_home:
                fragment = new HomeFragment();
                break;

            case R.id.menu_navigation_consultation:
                fragment = new HelpFragment();
                break;

            case R.id.menu_navigation_account:
//                startActivity(new Intent(this, Register.class));
                fragment = new AccountFragment();
                break;
        }
        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment){
        if( fragment!= null ){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }



    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
