package com.example.miprimeraapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.miprimeraapp.databinding.ActivityTabBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class TabActivity extends AppCompatActivity {

    private ActivityTabBinding binding;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTabBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new ViewPagerAdapter(this);
        binding.viewPager.setAdapter(adapter);

        new TabLayoutMediator(binding.tabLayout, binding.viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Chats");
                    tab.setIcon(android.R.drawable.sym_action_chat);
                    break;
                case 1:
                    tab.setText("Estados");
                    tab.setIcon(android.R.drawable.ic_menu_gallery);
                    break;
                case 2:
                    tab.setText("Llamadas");
                    tab.setIcon(android.R.drawable.ic_menu_call);
                    break;
            }
        }).attach();
    }
}