package com.example.implicitintents_cl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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

    // web サイトを開くメソッド
    public void openWebsite(View view) {
        String url = mWebsiteEditText.getText().toString();

        // 上の文字列を Uri オブジェクトにエンコードして解析する。
        Uri webpage = Uri.parse(url);

        // 指定されたデータの表示
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        // null チェック。リクエスト処理できるものが、1つはあることを示す。
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("MainActivity", "webサイトの取得に失敗しました。");
        }
    }

    // 場所を開くメソッド
    public void openLocation(View view) {
        String loc = mLocationEditText.getText().toString();

        // 地理検索クエリを使用してその文字列を Uri オブジェクトに解析する。
        Uri addressUri = Uri.parse("geo:0.0?q=" + loc);

        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("MainActivity", "場所の取得に失敗しました。");
        }
    }

    // 共有ボタン処理
    public void shareText(View view) {
        String txt = mShareEditText.getText().toString();

        // 共有する mime タイプを定義する。
        String mimeType = "text/plain";

        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(txt)
                .startChooser();
    }
}