package lanren.com.lanrentv2.webview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import lanren.com.lanrentv2.R;

public class WebviewActivity extends AppCompatActivity {
    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        web = (WebView) findViewById(R.id.webview);
        // 得到传值
        Intent intent = getIntent();

        String url = intent.getStringExtra("url");
        String name = intent.getStringExtra("name");
        // 打开地址
        web.loadUrl(url);
        web.setWebChromeClient(new WebChromeClient());
    }
}
