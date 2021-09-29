package com.example.listofpresidents;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listofpresidents.databinding.ListItemBinding;

public class KayttajaAktiiviteetti extends AppCompatActivity {

    ListItemBinding binding;

    @Override
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        binding = ListItemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if (intent != null){
            String kokoNimi = intent.getStringExtra("");

            binding.presidentinNimi.setText(kokoNimi);
        }

    }
}
