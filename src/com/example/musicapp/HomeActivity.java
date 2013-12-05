package com.example.musicapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeActivity extends Activity implements OnClickListener{
	Button NewSesh, ViewCurrent, ViewFav, Logout; 
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        
        NewSesh=(Button)findViewById(R.id.EnterDJ);
        NewSesh.setOnClickListener(this);
        
        ViewCurrent=(Button)findViewById(R.id.EnterListener);
        ViewCurrent.setOnClickListener(this);
        
        ViewFav=(Button)findViewById(R.id.ViewFav);
        ViewFav.setOnClickListener(this);
        
        Logout=(Button)findViewById(R.id.Logout);
        Logout.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		int clickedBtnId=arg0.getId();
		
		//TODO create actual login logic
		if (clickedBtnId == R.id.EnterDJ)
		{
			Intent ToCreateSession = new Intent (this, CreateSessionActivity.class);
			startActivity(ToCreateSession);
		}
		
		else if (clickedBtnId == R.id.EnterListener)
		{
			Intent ToListenerMenu = new Intent (this, ListenerMenuActivity.class);
			startActivity(ToListenerMenu);
		}
		else if (clickedBtnId == R.id.ViewFav)
		{
			Intent ToMyFav = new Intent (this, MyFavActivity.class);
			startActivity(ToMyFav);
		}
		else if (clickedBtnId == R.id.Logout)
		{
			Intent Logout = new Intent (this, MainActivity.class);
			//How to disconnect logic
			startActivity(Logout);
		}
		
	}
}
