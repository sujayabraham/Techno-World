package com.sujay.blog;

import java.util.Timer;


import java.util.TimerTask;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Spinner;

import com.sujay.blog.R;


public class BankBaseActivity extends Activity {

	
	public AlertDialog alertDialog1;
	protected ImageView MyImageView;
	protected Timer timer; 
	public int CounterTimer=0;
	
	protected LinearLayout _manager;
	protected LinearLayout form;
	protected BankBaseActivity _self;
	
		

	
	public void loadFormFromResource(int resourceID)
	{
		LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(resourceID, null);
		_manager.addView(view);
	}

	public void loadDefaultForm()
	{
		form=new LinearLayout(this);
		form.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT));
		form.setOrientation(LinearLayout.VERTICAL);
		_manager.addView(form);
	}

	
	protected void showScreen(Intent intent) {
		startActivity(intent);
	}

	

	public Handler progressCloseHandler = new Handler() {
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if (alertDialog1 != null)
				alertDialog1.cancel();
		}

	};

	
	
	
	
	public void onAlertOK(int id) {
		
	}

	

	private Handler closeViewHandler=new Handler() {
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			_self.finish();
		}
	};

	public void closeScreen() {
		closeViewHandler.sendMessage(Message.obtain(closeViewHandler));
	}

	
		
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// ignore orientation/keyboard change
		super.onConfigurationChanged(newConfig);
	}
	public void setMaxLength(EditText fld, int maxLength) {
		InputFilter[] FilterArray = new InputFilter[1];
		FilterArray[0] = new InputFilter.LengthFilter(maxLength);
		fld.setFilters(FilterArray);
	}
	
		protected InputFilter filter = new InputFilter() {
		    public CharSequence filter(CharSequence source, int start, int end,Spanned dest, int dstart, int dend) { 
		        for (int i = start; i < end; i++) { 
		             if (Character.isLetterOrDigit(source.charAt(i))) { 
		                    
		             }  else if(Character.isSpace(source.charAt(i)))  {
		            	 return "";
		             }
		             else {
		            	 return "";
		             }
		        }
		        return source;
		    }  
		};
		protected InputFilter namefilter = new InputFilter() {
		    public CharSequence filter(CharSequence source, int start, int end,Spanned dest, int dstart, int dend) { 
		        for (int i = start; i < end; i++) { 
		             if (Character.isLetterOrDigit(source.charAt(i))) { 
		                    
		             }  else if(Character.isSpace(source.charAt(i)))  {
		             }
		             else {
		            	 return "";
		             }
		        }
		        return source;
		    }  
		};

}
