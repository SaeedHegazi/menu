package com.example.myapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
public static FrameLayout frHome,frFirst,frSecond;
private BottomNavigationView nav1;
private homeFrag homeFrag;
private firstFrag firstFrag;
private secondFrag secondFrag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frHome = findViewById(R.id.fr1);
        frFirst = findViewById(R.id.fr2);
        frSecond = findViewById(R.id.fr3);

        homeFrag = new homeFrag();
        firstFrag = new firstFrag();
        secondFrag = new secondFrag();

        getSupportFragmentManager().beginTransaction().replace(R.id.fr1,homeFrag).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fr2,firstFrag).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fr3,secondFrag).commit();

        nav1 = findViewById(R.id.nav);
        nav1.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.mnuHome) {
                    frHome.setVisibility(View.VISIBLE);
                    frFirst.setVisibility(View.INVISIBLE);
                    frSecond.setVisibility(View.INVISIBLE);
                }
                if (item.getItemId() == R.id.mnuFrag1) {
                    frFirst.setVisibility(View.VISIBLE);
                    frSecond.setVisibility(View.INVISIBLE);
                    frHome.setVisibility(View.INVISIBLE);
                }
                if (item.getItemId() == R.id.mnuFrag2) {
                    frSecond.setVisibility(View.VISIBLE);
                    frFirst.setVisibility(View.INVISIBLE);
                    frHome.setVisibility(View.INVISIBLE);
                }

                return true;
            }

        });
    }

}