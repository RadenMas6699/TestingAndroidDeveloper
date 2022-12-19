package com.radenmas.testing_android_developer.ui.part1.java;

//import static com.radenmas.testing_android_developer.ui.part1.java.MyServiceJava.setInterfaceJava;

import static com.radenmas.testing_android_developer.ui.part1.java.MyServiceJava.setInterfaceJava;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.radenmas.testing_android_developer.databinding.ActivityPart1JavaBinding;

public class Part1ActivityJava extends AppCompatActivity implements MyInterfaceJava {

    private static ActivityPart1JavaBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityPart1JavaBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        bind.btnStartServiceJava.setOnClickListener(view -> {
            Intent service = new Intent(Part1ActivityJava.this, MyServiceJava.class);
            startService(service);
            setInterfaceJava(Part1ActivityJava.this);
        });
    }

    @Override
    public void callBackJava(String data) {
        bind.tvStatusService.setText(data);
    }
}