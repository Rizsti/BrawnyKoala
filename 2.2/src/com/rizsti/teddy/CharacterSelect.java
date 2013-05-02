package com.rizsti.teddy;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.rizsti.dataprocessing.DatabaseHelper;
import com.rizsti.dataprocessing.MySettings;
/**
 * 
 * @author Andrea Dewey
 *
 */
public class CharacterSelect extends Activity {
	
	//Variables for element(s) in the view
	ListView charSelect;
	DatabaseHelper dh;
	List<Map<String,String>> lm;
	MySettings mySettings;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_character_select);
		
		dh=  new DatabaseHelper(this);
		//Get instances of the elements in the view
		charSelect = (ListView) findViewById(R.id.lvCharSelect);
		mySettings = MySettings.getInstance(this);
		charSelect.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> adapter, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				Intent i = new Intent(CharacterSelect.this, Details.class);
				i.putExtra("Type", MySettings.OLD_CHARACTER);
				Map<String,String> t = lm.get(position);
				i.putExtra("CharId", Integer.parseInt(t.get("Id")));
				Log.d("CharId", t.get("Id"));
				startActivity(i);
			}
			
		});
	
	}
	

	/* (non-Javadoc)
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {	
		super.onResume();
		lm = dh.getCharsForSelect();
		//populate the list view
		SimpleAdapter sa = new SimpleAdapter(
				this,
				lm,
				R.layout.listview_char_select,
				new String[] {"Name", "Level", "Class"},
				new int[] {R.id.tvName, R.id.tvLevel, R.id.tvClass});
		
		charSelect.setAdapter(sa);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.character_select, menu);
		return true;
	}

	/*
	 * What to execute when a menu item is selected
	 * (non-Javadoc)
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId())
		{
		case R.id.action_new:
			Intent i = new Intent(CharacterSelect.this, Details.class);
			i.putExtra("Type", MySettings.NEW_CHARACTER);
			startActivity(i);
			break;
		case R.id.action_settings:
			startActivity(new Intent(this,Settings.class));
			break;
			
		}
		return super.onOptionsItemSelected(item);
	}
}
