package com.rizsti.teddy;


import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.parse.Parse;
import com.rizsti.classes.Character;
import com.rizsti.dataprocessing.DatabaseHelper;
import com.rizsti.dataprocessing.MySettings;
import com.rizsti.fragments.Basic;
import com.rizsti.fragments.Battle;

/**
 * The activity that holds the fragments
 * @author Andrea Dewey
 *
 */

public class Details extends Activity {
	
	//Tab related variables
	private final String T1="Basic";
	private final String T2="Battle";
	//private final String T3="Skills";
	
	private final int NUM_TABS=2; //Number of tabs we have
	private Basic basic;
	//private Skills skills;
	private Battle battle;
	
	private String storedFrag[] = new String[NUM_TABS]; //Length is the number of tabs we have
	private Tab tabBasic,tabBattle;//,tabSkills;
	private boolean existingChar=false;
	
	//Object Variables
	Character c;
	ActionBar ab;
	DatabaseHelper dbh;
	MySettings mySettings;
	Bundle savedInstanceState;
	
	//Counting variables
	int j = 0;  //The number of elements currently in storedFrag that are not null
	
	/*
	 * Activity creation
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
		this.savedInstanceState = savedInstanceState;
		
		//Initialize parse
		Parse.initialize(this, "3sfbEGVbyq3lgjRZJJbLgonYfHz83LkaJlp7e0WP", "HFMtnDO5kzeSqcL9TEXrtRsrvWCwNsZUBGvsndbS"); 
		mySettings = MySettings.getInstance(this);
		
		//get the actionbar
		ab = getActionBar();
		
		//get the database handler
		dbh = new DatabaseHelper(this);
		
		//Set the navigation mode
		ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		//Create the tab listener
		Listener l = new Listener();
		
		//Instantiate the fragments
		basic = new Basic();
		//skills = new Skills();
		battle = new Battle();
		
		//create the tabs
		tabBasic = ab.newTab().setText(T1).setTabListener(l).setTag(T1);
		tabBattle = ab.newTab().setText(T2).setTabListener(l).setTag(T2);
		//tabSkills = ab.newTab().setText(T3).setTabListener(l).setTag(T3);
		
		//add the tabs
		ab.addTab(tabBasic);
		ab.addTab(tabBattle);
		//ab.addTab(tabSkills);
		
		//Enable upward navigation and the title
		ab.setDisplayHomeAsUpEnabled(true);
		ab.setDisplayShowTitleEnabled(true);
				
		//Get the intent information
		Intent i = getIntent();
	
		//Create the character
		if (i.getIntExtra("Type", 1)==MySettings.NEW_CHARACTER) 
		{
			//create a new character
			c = new Character();
		}
		else
		{
			//load an existing character
			c = dbh.loadCharacter(i.getIntExtra("CharId", 0));
			existingChar=true;
		}

		//Select the first tab
		ab.selectTab(tabBasic);

		//Enable upward navigation and the title
		ab.setDisplayHomeAsUpEnabled(true);
		ab.setDisplayShowTitleEnabled(true);
		
	}

	
	/* (non-Javadoc)
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		//Set the character
		basic.setCharacter(c);
		
		//Set the title
		if (c.getName()==null)
		{
			//if the character name is null
			ab.setTitle("New Character");
		}
		else {
			if (c.getName().equals(""))
			{
				//if the character still has no name
				ab.setTitle("New Character");
			}
			else
			{
				//If the character has a name
				ab.setTitle(c.getName());
			}
		}
		
		super.onResume();
	}


	/*
	 * When the menu is created
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.details, menu);
		return true;
	}
	
	
	/* When an menu item is selected
	 * (non-Javadoc)
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId())
		{
		case R.id.newChar:
			//TODO:Insert a dialogue that informs the user that all unsaved data will be lost if they accept, go to a blank Details class
			startActivity(new Intent(this, Details.class));
			break;
		case R.id.saveChar:
			//Insert code to save character here
			
			//Ensure the values you're inserting are the most recent
			updateCharacter();
			//If the Character's id is null that means it hasn't been saved before
			if (c.getIntegerId()==null)
			{
				//Code for inserting a new character
				c=dbh.createCharacter(c);
				
			}
			else
			{
				//Code to update an existing character
				c=dbh.updateCharacter(c);
			}
			onResume();
			Toast.makeText(this, c.getName() + " has been saved.", Toast.LENGTH_LONG).show();
			break;
		case R.id.loadChar:
			//TODO:Insert a dialogue that informs the user that all unsaved data will be lost if they accept, go to the character select class
			//Take the user to the character select screen
			startActivity(new Intent(this, CharacterSelect.class));
			break;
		case android.R.id.home:
            // Return the user to the home screen
            Intent parentActivityIntent = new Intent(this, CharacterSelect.class);
            parentActivityIntent.addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP |
                    Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(parentActivityIntent);
            finish();
            return true;
		case R.id.action_settings:
			startActivity(new Intent(this,Settings.class));
			break;
		
		}
		return super.onOptionsItemSelected(item);
	}
	
	/*
	 * Update the character object with the latest information from the fragments
	 */
	public void updateCharacter()
	{
		basic.updateCharacter(c);
		battle.updateCharacter(c);
	}
	
	/*
	 * The TabListener class
	 */
	private class Listener implements ActionBar.TabListener
	{

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			String t = (String) tab.getTag(); //The tag of the selected fragment
			Boolean b=false; //If the fragment that was selected has already been created
			for (int i=0; i<storedFrag.length; i++)
			{
				String sf = storedFrag[i];
				if (!(sf==null))
				{
					if (t.equals(sf))
						b=true;
				}
				
			}
			
			if (t.equals(T1))
			{
				if(b)
					ft.attach(basic);
				else
				{
					ft.add(R.id.fragment1, basic);
					storedFrag[j] = t;
					j++;
				}
				
			}
			if (t.equals(T2))
			{
				if(b)
					ft.attach(battle);
				else
				{
					ft.add(R.id.fragment1,battle);
					storedFrag[j] = t;
					j++;
				}
				//Set the character for the battle fragment
				battle.setCharacter(c);
			}
//			if (t.equals(T3))
//			{
//				if(b)
//					ft.attach(skills);
//				else
//				{
//					ft.add(R.id.fragment1,skills);
//					storedFrag[j] = t;
//					j++;
//				}
//				skills.populateListView(c, getApplicationContext());
//			}
			if(existingChar)
				basic.setCharacter(c);
			
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			String t = (String) tab.getTag();
			if (t.equals(T1))
			{
				ft.detach(basic);
				basic.updateCharacter(c);
				//If the health has not yet been calculated, do so now
				if (c.gettHealth()==0)
				{
					//calculate the health for every level
					for (int i=1;i<c.getLevel()+1;i++)
					{
						c.settHealth(c.gettHealth()+c.calcCurrentLevelHealth(i));
					}
				}
				
			}
			if (t.equals(T2))
			{
				ft.detach(battle);
			}
//			if (t.equals(T3))
//			{
//				ft.detach(skills);
//			}
		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			//Nothing happens when a tab is reselected
			
		}
		
	}
	
	/**
	 * Create a dialog that allows the user to add an attack
	 * @param v
	 */
	public void createDialog(View v)
	{
		battle.onCreateDialog(savedInstanceState, false).show();
	}
	
}
