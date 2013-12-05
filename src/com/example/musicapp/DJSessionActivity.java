package com.example.musicapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DJSessionActivity extends Activity implements OnClickListener{
	Button EndSesh, Logout, Users; 
	TextView SessionName;
	TextView SongName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.djsession);
        
        EndSesh=(Button)findViewById(R.id.EndSession);
        EndSesh.setOnClickListener(this);
        
        Users=(Button)findViewById(R.id.ViewUsers);
        Users.setOnClickListener(this);
        
        SessionName=(TextView)findViewById(R.id.textView1);
    	String val = getIntent().getStringExtra("SessionName");
        SessionName.setText(val);
        
        //TODO: obtain currently playing song name from whatever
        String CurrentlyPlayingSong = "Niggahz Paradise";
        SongName=(TextView)findViewById(R.id.textView2);
        SongName.setText(CurrentlyPlayingSong);
        
        Logout = (Button)findViewById(R.id.Logout);
        Logout.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		int clickedBtnId=arg0.getId();
		
		//TODO create actual login logic
		if (clickedBtnId == R.id.EndSession)
		{
			Intent ToDashSession = new Intent (this, HomeActivity.class);
			//Store name in database logic
			startActivity(ToDashSession);
		}
		else if (clickedBtnId == R.id.ViewUsers)
		{
			Intent ToViewUsers = new Intent (this, ViewUsersActivity.class);
			String val = getIntent().getStringExtra("SessionName");
			ToViewUsers.putExtra("SessionName", val);
			//How to disconnect logic
			startActivity(ToViewUsers);
		}
		else if (clickedBtnId == R.id.Logout)
		{
			Intent Logout = new Intent (this, MainActivity.class);
			//How to disconnect logic
			startActivity(Logout);
		}
		
	}
}
