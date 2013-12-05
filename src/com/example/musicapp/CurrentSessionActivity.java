package com.example.musicapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class CurrentSessionActivity extends Activity implements OnClickListener{
	Button EndSesh, Logout; 
	TextView SessionName;
	TextView SongName;
	CheckBox like;
	CheckBox dislike;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.currentsession);
        
        EndSesh=(Button)findViewById(R.id.EndSession);
        EndSesh.setOnClickListener(this);
        
        SessionName=(TextView)findViewById(R.id.textView1);
        Bundle gotBasket = getIntent().getExtras();
        String val = gotBasket.getString("name");
        SessionName.setText(val);
        
        /*
        like = (CheckBox)findViewById(R.id.checkBox1);
        dislike = (CheckBox)findViewById(R.id.checkBox2);
        */
        
        /*
        like.setChecked(song.isFavorite());
        like.setTag(song.getName());
        like.setOnClickListener(new View.OnClickListener()
        
        @Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								CheckBox ckbox = (CheckBox) v;
								String menuName = (String)ckbox.getTag();
								info.open();
								info.changeFavorite(menuName); //change favorite state in the database for that menu (info is menuDatabaseSQL)
								info.close();
							}
						});
        */
        
        //TODO: obtain currently playing song name from whatever
        String CurrentlyPlayingSong = "Niggahz Paradise";
        SongName=(TextView)findViewById(R.id.songname);
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
		else if (clickedBtnId == R.id.Logout)
		{
			Intent Logout = new Intent (this, MainActivity.class);
			//How to disconnect logic
			startActivity(Logout);
		}
		
	}
}
