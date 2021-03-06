package com.example.musicapp;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class ListenerMenuActivity extends Activity implements OnClickListener{
	Button Logout; 
	//ArrayList<Users> users;
	//WE WILL USE CustomAdataApater once we have Users class
	MyCustomAdapter dataAdapter;
	ArrayAdapter<String> ratingAdapter = null;

	
	//CustomArrayAdapter dataAdapt = null;
	String[] users = {"Covel Commons", "De Neve", "Feast", "Bruin Plate", "Hedrick"};
	String[] ratings = {"100", "89", "56", "70", "60"};

	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        setContentView(R.layout.listenermenu);
        
        displayUsers(users);
        displayRatings(ratings);
        
        Logout = (Button)findViewById(R.id.Logout);
        Logout.setOnClickListener(this);
        
	}
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		int clickedBtnId=arg0.getId();

		if (clickedBtnId == R.id.Logout)
		{
			Intent Logout = new Intent (this, MainActivity.class);
			//How to disconnect logic
			startActivity(Logout);
		}
		
	}
	private void displayUsers(String[] users){
		dataAdapter = new MyCustomAdapter(this, R.layout.listview, users); 
		ListView list = (ListView) findViewById(R.id.listView1);
		list.setAdapter(dataAdapter);
	}
	
	private void displayRatings(String[] ratings){
		
		ratingAdapter = new ArrayAdapter<String>(this, R.layout.viewsongs, ratings); 
		ListView list = (ListView) findViewById(R.id.listView2);
		list.setAdapter(ratingAdapter);
	}
	
	class MyCustomAdapter extends ArrayAdapter<String>
    {
            private String[] userList;

            public MyCustomAdapter(Context context, int resourceID,
                            String[] users) 
            {
                    super(context, resourceID, users);
                    this.userList = users;
            }
    
            //This function is why we write custom adapter in the first place.
            //We can design how to display on the screen using this function.
            //For now, it only deal with the checkbox text.
            public View getView(int position, View convertView, ViewGroup parent) 
            {
                    View row=convertView;
                    String u = userList[position];
                    //inflater are expensive, 20~30ms, checking for row==null, we can save some time
                    if (row==null){
                            LayoutInflater inflater=getLayoutInflater();
                            row=inflater.inflate(R.layout.listview, null);
                    }

                    TextView name_button = (TextView) row.findViewById(R.id.listview_row_button);
                    name_button.setText(u);
                    name_button.setTag(u); //let tag of button be name of menu so we can take appropriate response
                                                                                            //when button is clicked by looking at the tag

                    //listener for the button at right side of each row
                    name_button.setOnClickListener(new View.OnClickListener()
                    {
                            @Override
                            public void onClick(View v) {
                                    Button btn = (Button) v;
                                    String userName = (String) btn.getTag(); //tag is name of menu assigned above
                                    Bundle basket = new Bundle();                        //bundle is just way to pass data between Activities 
                                    basket.putString("name", userName);         //we will pass name of menu that user clicked
                                    Intent ToUserFavorites = new Intent (ListenerMenuActivity.this, CurrentSessionActivity.class);
                                    ToUserFavorites.putExtras(basket);
                                    startActivity(ToUserFavorites); //Go to MenuInfo Screen
                            }                        
                    });
                    return row;                        
            }


    }//end of class MyCustomAdapter
	
	
}
