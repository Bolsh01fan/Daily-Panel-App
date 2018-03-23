package com.app.dailypanel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ReadStoryActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_story);

        webView = (WebView) findViewById(R.id.web_view_read_story);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String url = bundle.getString("url");

        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl(url);

        // Hide the header, menu, and footer from the website
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url)
            {
                webView.loadUrl("javascript:(function() { " +
                        "var head = document.getElementsByTagName('header')[0];"
                        + "head.parentNode.removeChild(head);" +
                        "})()");

                webView.loadUrl("javascript:(function() { " +
                        "var menu = document.getElementsByClassName('menu-box')[0];"
                        + "menu.parentNode.removeChild(menu);" +
                        "})()");

                webView.loadUrl("javascript:(function() { " +
                        "var footer = document.getElementsByTagName('footer')[0];"
                        + "footer.parentNode.removeChild(footer);" +
                        "})()");
            }
        });
    }
}