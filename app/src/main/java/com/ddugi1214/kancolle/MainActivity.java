package com.ddugi1214.kancolle;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends ActionBarActivity {
    WebView mWeb;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWeb = (WebView)findViewById(R.id.web);
        WebSettings set = mWeb.getSettings();
        set.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        set.setJavaScriptEnabled(true);
        set.setSupportZoom(true);
        mWeb.loadUrl("http://www.dmm.com/netgame/social/-/gadgets/=/app_id=854854/");
    }

    class MyWebClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
