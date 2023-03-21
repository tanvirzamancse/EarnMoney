package com.tzp.earnmoney.view.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.tzp.earnmoney.R;
import com.tzp.earnmoney.databinding.ActivityMainBinding;
import com.tzp.earnmoney.view.ui.base.BaseActivity;
import com.tzp.earnmoney.viewmodel.AuthViewModel;

import dagger.hilt.android.components.ActivityComponent;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

/*        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);*/

   /*     Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);*/

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        assert navHostFragment != null;
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(binding.bottomNav, navController);


        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {

                switch (navDestination.getId()) {

                    case R.id.homeFragment:
                    case R.id.cashBoxFragment:
                    case R.id.walletFragment:
                    case R.id.profileFragment:
                        binding.bottomNav.setVisibility(View.VISIBLE);
                        binding.toolbar.setVisibility(View.VISIBLE);
                        break;

                }

            }
        });


    }

    @Override
    public void performDependencyInjection(ActivityComponent buildComponent) {

    }
}