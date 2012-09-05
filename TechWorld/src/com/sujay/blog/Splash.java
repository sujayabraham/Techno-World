package com.sujay.blog;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;


public class Splash extends BankBaseActivity {
	
	protected boolean _active = true;
	protected int _splashTime = 500; // time to display the splash screen in ms
	private Intent nextIntent;
	
   /** Called when the activity is first created. */
   @Override
   public void onCreate(Bundle savedInstanceState) 
   {
	   super.onCreate(savedInstanceState);
       setContentView(R.layout.splash);
       nextIntent = new Intent(this, WebViewDemo.class);
       nextIntent.setFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
       
    // thread for displaying the SplashScreen
       Thread splashTread = new Thread() {
           @Override
           public void run() {
               try {
                   int waited = 0;
                   while(_active && (waited < _splashTime)) {
                       sleep(200);
                       if(_active) {
                           waited += 100;
                       }
                   }
               } catch(InterruptedException e) {
                   // do nothing
               } finally {
                   finish();
            	   startActivity(nextIntent);
                   //sathish commented to avoid deprecated method. added bellow line
            	   //stop();
            	   interrupt();
               }
           }
       };
       splashTread.start();
       HttpManager.loadHttp();
   }
   

   @Override
   public boolean onTouchEvent(MotionEvent event) {
       if (event.getAction() == MotionEvent.ACTION_DOWN) {
           _active = false;
       }
       return true;
   }
}