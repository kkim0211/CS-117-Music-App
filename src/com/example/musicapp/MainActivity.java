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

public class MainActivity extends Activity implements OnClickListener {

	Button login, newuser; 
	EditText username;
	EditText password;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        login=(Button)findViewById(R.id.Login);
        login.setOnClickListener(this);
        
        username=(EditText)findViewById(R.id.get_username);
        password=(EditText)findViewById(R.id.get_password);

        
        
        newuser=(Button)findViewById(R.id.NewUser);
        newuser.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		int clickedBtnId=arg0.getId();
		
		//TODO create actual login logic
		if (clickedBtnId == R.id.Login)
		{
			//user and pass is user input username and password. Create login logic with that
			String user = username.getText().toString();
			String pass = password.getText().toString();
			
			Intent ToHome = new Intent (this, HomeActivity.class);
			startActivity(ToHome);
		}
		
		else if (clickedBtnId == R.id.NewUser)
		{
			Intent ToRegister = new Intent (this, RegisterActivity.class);
			startActivity(ToRegister);
		}
		
	}


}