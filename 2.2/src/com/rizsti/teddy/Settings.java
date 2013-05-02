package com.rizsti.teddy;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.rizsti.dataprocessing.MySettings;
/**
 * 
 * @author Andrea Dewey
 *
 */
public class Settings extends Activity {

	MySettings mySettings;
	ActionBar ab;
	Spinner colours;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		//Get an instance of the global settings
		mySettings= MySettings.getInstance(this);
		//Get an instance of the action bar
		ab = getActionBar();
		//Get an instance of the colours spinner
		colours = (Spinner) findViewById(R.id.colours);
		//Create an adapter for the spinner
		ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,MySettings.COLOUR_LIST);
		//Set the adapter for the spinner
		colours.setAdapter(ad);
		//Set the on item selected listener for the spinner
		colours.setOnItemSelectedListener(new ItemSelectedListener());
		
	}

	@Override
	protected void onResume() {
		//Set the color for the action bar
		ab.setBackgroundDrawable(mySettings.GetDrawableTheme(this));
		//Select the item in the spinner that corresponds to the current selected color
		colours.setSelection(selectedPosition(mySettings.GetThemeColor()));
		super.onResume();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.settings, menu);
		return true;
	}
	
	//To prevent the white background of the onResume
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		//when the back button is pressed
		if (keyCode ==KeyEvent.KEYCODE_BACK)
		{
			startActivity(new Intent(this, CharacterSelect.class));
			return false;
		}
		
		return super.onKeyDown(keyCode, event);
	}
	
	//Get the position in the array of the passed in string
	public int selectedPosition(String s)
	{
		int p=0;
		
		for (int i=0; i<MySettings.COLOUR_LIST.length;i++)
		{
			if (s.equals(MySettings.COLOUR_LIST[i].toString()))
				p=i;
		}
		
		return p;
	}
	//Item selected listener
	public class ItemSelectedListener implements OnItemSelectedListener
	{

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		//Save the selected color
		mySettings.SetThemeColor(MySettings.COLOUR_LIST[arg2]);
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		
		
	}
		
	}
}
	
