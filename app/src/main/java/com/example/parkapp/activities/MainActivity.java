package com.example.parkapp.activities;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import com.example.parkapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);

        if (navHostFragment != null) {
            NavController navController = navHostFragment.getNavController();
            NavigationUI.setupWithNavController(bottomNavigationView, navController);

            bottomNavigationView.setOnItemSelectedListener(item -> {
                int itemId = item.getItemId();
                if (itemId == R.id.navigation_home) {
                    navController.navigate(R.id.fragment_home);
                } else if (itemId == R.id.navigation_purchase) {
                    navController.navigate(R.id.fragment_tickets);
                } else if (itemId == R.id.navigation_profile) {
                    navController.navigate(R.id.fragment_profile);
//                } else if (itemId == R.id.navigation_attractions) {
//                    navController.navigate(R.id.fragment_attractions);
//                } else if (itemId == R.id.navigation_qr_code) {
//                    navController.navigate(R.id.fragment_qr_code);
                } else {
                    return false;
                }
                return true;
            });
        } else {
            Log.e("MainActivity", "NavHostFragment not found");
        }
    }
}