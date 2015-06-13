package com.ddugi1214.kancolle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


public class MainActivity extends ActionBarActivity {
    WebView mWeb;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWeb = (WebView)findViewById(R.id.web);
        mWeb.setWebChromeClient(new WebChromeClient() {
             ProgressBar probar = (ProgressBar)findViewById(R.id.ProgressBar);

             public void onProgressChanged(WebView view,int progress) {
                 probar.setProgress(progress);
                 if (progress == 100) {
                     probar.setVisibility(View.GONE);
                 } else {
                     probar.setVisibility(View.VISIBLE);
                 }
             }
        });
        WebSettings set = mWeb.getSettings();
        set.setUserAgentString("Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; Trident/6.0; SLCC2;.NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0)");
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
    public boolean onKeyDown(int KeyCode, KeyEvent event) {
        super.onKeyDown(KeyCode, event);
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
        switch (KeyCode) {
            case KeyEvent.KEYCODE_BACK:
                new AlertDialog.Builder(this)
                .setTitle("칸코레 모바일 접속기")
                .setMessage("칸코레 모바일 접속기를 종료합니다")
                .setPositiveButton("종료", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        finish();
                    }
                })
                .setNegativeButton("취소", null)
                .show();
        }
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
