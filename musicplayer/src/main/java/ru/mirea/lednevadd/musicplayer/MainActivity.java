package ru.mirea.lednevadd.musicplayer;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import ru.mirea.lednevadd.musicplayer.databinding.ActivityMainBinding;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding	= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}