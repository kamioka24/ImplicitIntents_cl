package com.example.implicitintents_cl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebsiteEditText = findViewById(R.id.edit_text1);
        mLocationEditText = findViewById(R.id.edit_text2);
        mShareEditText = findViewById(R.id.edit_text3);
    }

    public void openWebsite(View view) {
        String url = mWebsiteEditText.getText().toString();

        // 上の文字列を Uri オブジェクトにエンコードして解析する。
        Uri webpage = Uri.parse(url);

        // 指定されたデータの表示
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
    }
}