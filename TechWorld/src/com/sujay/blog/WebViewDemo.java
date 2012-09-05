package com.sujay.blog;

import com.sujay.blog.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class WebViewDemo extends Activity {
	
	private class MyWebViewClient extends WebViewClient
	{
      @Override
      public boolean shouldOverrideUrlLoading(WebView view, String url) {
    	  //url="http://192.9.200.3:8080/demobank/";
    	  view.loadUrl(url);
          return true;
       }
    }
	private WebView webView;
	
	
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Create reference to UI elements
        webView  = (WebView) findViewById(R.id.webview_compontent);
      
        // workaround so that the default browser doesn't take over
        webView.setWebViewClient(new MyWebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        
        webView.loadUrl("http://sujayabraham.blogspot.in/");
        
        //webView.loadUrl("http://192.9.200.118:8084/MBS_CORE/PrepaidTC.html");
        
        
 
    }
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.options, menu);
		return true;
	}
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.item_settings:
				finish();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
    
     
}
