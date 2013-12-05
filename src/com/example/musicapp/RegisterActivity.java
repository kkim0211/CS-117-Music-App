package com.example.musicapp;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView; 

public class RegisterActivity extends Activity implements OnClickListener {

	Button register, exist; 
	EditText username;
	EditText password;
	EditText email;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        register=(Button)findViewById(R.id.btnRegister);
        register.setOnClickListener(this);
        
        username=(EditText)findViewById(R.id.reg_username);
        password=(EditText)findViewById(R.id.reg_password);
        email=(EditText)findViewById(R.id.reg_email);

        
        
        exist=(Button)findViewById(R.id.link_to_login);
        exist.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		int clickedBtnId=arg0.getId();
		
		//TODO create actual login logic
		if (clickedBtnId == R.id.btnRegister)
		{
			//user and pass is user input username and password. Create login logic with that
			String user = username.getText().toString();
			String pass = password.getText().toString();
			String em = email.getText().toString();
			//Perform logic to check if user exists or not. How to register user is up to you.
			
			Intent ToCheck = new Intent (this, HomeActivity.class);
			startActivity(ToCheck);
		}
		
		else if (clickedBtnId == R.id.link_to_login)
		{
			Intent ToHome = new Intent (this, HomeActivity.class);
			startActivity(ToHome);
		}
		
	}


}