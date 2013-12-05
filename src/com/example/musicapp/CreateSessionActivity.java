package com.example.musicapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class CreateSessionActivity extends Activity implements OnClickListener{
	Button CreateSesh, Logout; 
	EditText SessionName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.createsession);
        
        CreateSesh=(Button)findViewById(R.id.CreateSession);
        CreateSesh.setOnClickListener(this);
        
        SessionName=(EditText)findViewById(R.id.SessionName);
        
        Logout = (Button)findViewById(R.id.Logout);
        Logout.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		int clickedBtnId=arg0.getId();
		
		//TODO create actual login logic
		if (clickedBtnId == R.id.CreateSession)
		{
			Intent ToCreateSession = new Intent (this, DJSessionActivity.class);
			String name = SessionName.getText().toString();
			ToCreateSession.putExtra("SessionName", name);
			//Store name in database logic
			Log.v("EditText", name);
			startActivity(ToCreateSession);
		}
		else if (clickedBtnId == R.id.Logout)
		{
			Intent Logout = new Intent (this, MainActivity.class);
			//How to disconnect logic
			startActivity(Logout);
		}
		
	}
}
