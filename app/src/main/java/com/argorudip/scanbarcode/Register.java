package com.argorudip.scanbarcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;

public class Register extends AppCompatActivity {
    public static String dataBarcode = "";
    public static Boolean cari = false;
    ImageView imageView;
    TextInputEditText inputLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        imageView = findViewById(R.id.gambar);
        inputLink = findViewById(R.id.inputLink);

    }


    @Override
    protected void onResume() {
        super.onResume();
        if (!cari) {
            Intent intent = new Intent(Register.this, Barcode.class);
            startActivity(intent);
        } else {
            inputLink.setText(dataBarcode);
            Glide.with(getApplicationContext())
                    .load("https://chart.googleapis.com/chart?cht=qr&chs=300x300&chl=" + dataBarcode + "&choe=UTF-8")
                    .error(R.color.colorDark)
                    .into(imageView);
        }
    }
}