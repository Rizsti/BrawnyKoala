package com.rizsti.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.rizsti.classes.Character;
import com.rizsti.teddy.R;

public class Basic extends Fragment {
	
	private View v;
	private Character c;
	
	//Numbers for calculations
	private final int SUBMOD = 10;
	private final int HALF = 2;
	
	//Arrays
	private final String RACES[] = {"Race", "Human", "Elf", "Dwarf", "Half-Elf", "Driders", "Half-Orc", "Halfling", "Goblin", "Kobold", "Orc"};
	private final String CLASSES[] = {"Class", "Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Wizard"};
	private final String ALIGNMENT[] = {"Alignment", "Lawful Good", "Neutral Good", "Chaotic Good", "Lawful Neutral", "Neutral", "Chaotic Neutral", "Lawful Evil", "Neutral Evil", "Chaotic Evil"};
	private final String DEITIES[] = {"Deity", "Heironeous", "Moradin", "Yondalla", "Ehlonna", "Garl Glittergold", "Pelor", "Corellon Larethian", "Kord", "Wee Jas", "St. Cuthbert", "Boccob", "Fharlanghn", "Obad-Hai", "Olidammara", "Hextor", "Necrull", "Vecna", "Erythnul", "Gruumsh"};

	//Default display values
	private final String dv = "0";
	
	//page elements
	public Spinner classs, align, deity, race;
	EditText name, level, strScore, strTmpScore, conScore, conTmpScore, dexScore, dexTmpScore,
		intScore, intTmpScore, chaScore, chaTmpScore, wisScore, wisTmpScore;
	TextView strMod, strTmpMod, conMod, conTmpMod, dexMod, dexTmpMod, intMod, intTmpMod,
		chaMod, chaTmpMod, wisMod, wisTmpMod;
		
	
	@Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {
	   v= inflater.inflate(R.layout.fragment_basic,
	        container, false);
	   
	   	//get the elements in the beginning half of the layout
	   	//Edit Texts
	    //Initialize parse
	 	Parse.initialize(getActivity(), "3sfbEGVbyq3lgjRZJJbLgonYfHz83LkaJlp7e0WP", "HFMtnDO5kzeSqcL9TEXrtRsrvWCwNsZUBGvsndbS"); 
	 		
	   	name 	= (EditText) v.findViewById(R.id.etName);
		level	= (EditText) v.findViewById(R.id.etLevel);
		//Spinners		
		classs	= (Spinner) v.findViewById(R.id.spClass);
		align 	= (Spinner) v.findViewById(R.id.spAlign);
		deity 	= (Spinner) v.findViewById(R.id.spDeity);
		race 	= (Spinner) v.findViewById(R.id.spRace);
		
		//Elements from the end half of the layout
		//Edit Texts  --  Stat scores
		strScore 	= (EditText) v.findViewById(R.id.strScore);
		strTmpScore = (EditText) v.findViewById(R.id.strTmpScore);
		dexScore	= (EditText) v.findViewById(R.id.dexScore);
		dexTmpScore = (EditText) v.findViewById(R.id.dexTmpScore);
		conScore 	= (EditText) v.findViewById(R.id.conScore);
		conTmpScore	= (EditText) v.findViewById(R.id.conTmpScore);
		intScore	= (EditText) v.findViewById(R.id.intScore);
		intTmpScore = (EditText) v.findViewById(R.id.intTmpScore);
		wisScore	= (EditText) v.findViewById(R.id.wisScore);
		wisTmpScore = (EditText) v.findViewById(R.id.wisTmpScore);
		chaScore	= (EditText) v.findViewById(R.id.chaScore);
		chaTmpScore	= (EditText) v.findViewById(R.id.chaTmpScore);		
		
		//TextViews  --  Stat modifiers
		strMod		= (TextView) v.findViewById(R.id.strMod);
		strTmpMod	= (TextView) v.findViewById(R.id.strTmpMod);
		dexMod		= (TextView) v.findViewById(R.id.dexMod);
		dexTmpMod	= (TextView) v.findViewById(R.id.dexTmpMod);
		conMod		= (TextView) v.findViewById(R.id.conMod);
		conTmpMod	= (TextView) v.findViewById(R.id.conTmpMod);
		intMod		= (TextView) v.findViewById(R.id.intMod);
		intTmpMod	= (TextView) v.findViewById(R.id.intTmpMod);
		wisMod		= (TextView) v.findViewById(R.id.wisMod);
		wisTmpMod	= (TextView) v.findViewById(R.id.wisTmpMod);
		chaMod		= (TextView) v.findViewById(R.id.chaMod);
		chaTmpMod	= (TextView) v.findViewById(R.id.chaTmpMod);
		
		//Set the default of the editTexts to 0 to ensure that onResume does not provide errors
		strScore.setText(dv);
		strTmpScore.setText(dv);
		dexScore.setText(dv);
		dexTmpScore.setText(dv);
		conScore.setText(dv);
		conTmpScore.setText(dv);
		intScore.setText(dv);
		intTmpScore.setText(dv);
		wisScore.setText(dv);
		wisTmpScore.setText(dv);
		chaScore.setText(dv);
		chaTmpScore.setText(dv);
		
		//Set the onEditorActionListeners for the EditTexts
		strScore.setOnFocusChangeListener(new StatsListener());
		strTmpScore.setOnFocusChangeListener(new StatsListener());
		dexScore.setOnFocusChangeListener(new StatsListener());
		dexTmpScore.setOnFocusChangeListener(new StatsListener());
		conScore.setOnFocusChangeListener(new StatsListener());
		conTmpScore.setOnFocusChangeListener(new StatsListener());
		intScore.setOnFocusChangeListener(new StatsListener());
		intTmpScore.setOnFocusChangeListener(new StatsListener());
		wisScore.setOnFocusChangeListener(new StatsListener());
		wisTmpScore.setOnFocusChangeListener(new StatsListener());
		chaScore.setOnFocusChangeListener(new StatsListener());
		chaTmpScore.setOnFocusChangeListener(new StatsListener());
		
		level.setOnFocusChangeListener(new LevelListener());
		
		//Create that adapters to populate the spinners
		ArrayAdapter<String> adRace = new ArrayAdapter<String>(getActivity(), R.layout.spinner_center, RACES);
		ArrayAdapter<String> adClass = new ArrayAdapter<String>(getActivity(), R.layout.spinner_center, CLASSES);
		ArrayAdapter<String> adAlign = new ArrayAdapter<String>(getActivity(), R.layout.spinner_center, ALIGNMENT);
		ArrayAdapter<String> adDeities = new ArrayAdapter<String>(getActivity(), R.layout.spinner_center, DEITIES);
		
		//Set the onItemSelectedListener to populate character data when a class is selected
		classs.setOnItemSelectedListener(new SelectedListener());
		
		
		//Set the spinners' adapters
		classs.setAdapter(adClass);
		align.setAdapter(adAlign);
		deity.setAdapter(adDeities);
		race.setAdapter(adRace);
		
		//return the infalted view
	   return v;
	    
	  }
	
	/**
	 * When the fragment resumes, update the page elements
	 */
	@Override
	public void onResume() {
		//Ensure that whenever you return to the basic tab the modifiers updates
		strMod.setText(String.valueOf(calcMod(getInt(strScore.getText().toString()))));
		dexMod.setText(String.valueOf(calcMod(getInt(dexScore.getText().toString()))));
		intMod.setText(String.valueOf(calcMod(getInt(intScore.getText().toString()))));
		conMod.setText(String.valueOf(calcMod(getInt(conScore.getText().toString()))));
		chaMod.setText(String.valueOf(calcMod(getInt(chaScore.getText().toString()))));
		wisMod.setText(String.valueOf(calcMod(getInt(wisScore.getText().toString()))));
		//Ensure temporary modifiers are updated
		strTmpMod.setText(String.valueOf(calcMod(getInt(strTmpScore.getText().toString()))));
		dexTmpMod.setText(String.valueOf(calcMod(getInt(dexTmpScore.getText().toString()))));
		intTmpMod.setText(String.valueOf(calcMod(getInt(intTmpScore.getText().toString()))));
		conTmpMod.setText(String.valueOf(calcMod(getInt(conTmpScore.getText().toString()))));
		chaTmpMod.setText(String.valueOf(calcMod(getInt(chaTmpScore.getText().toString()))));
		wisTmpMod.setText(String.valueOf(calcMod(getInt(wisTmpScore.getText().toString()))));
		
		super.onResume();
	}

	/*
	 * Set the element values based on the character object passed in
	 */
	public void setCharacter(Character ch)
	{
		c = ch;
		//Top half
		name.setText(c.getName());
		level.setText(String.valueOf(c.getLevel()));
		classs.setSelection(getSpinnerPosition(0, c.getClasss()));
		align.setSelection(getSpinnerPosition(1, c.getAlignment()));
		deity.setSelection(getSpinnerPosition(2, c.getDeity()));
		race.setSelection(getSpinnerPosition(3, c.getRace()));
		//Bottom half
		//Strength
		strScore.setText(String.valueOf(c.getStrength()));
		strTmpScore.setText(String.valueOf(c.getTmpStr()));
		//Dexterity
		dexScore.setText(String.valueOf(c.getDexterity()));
		dexTmpScore.setText(String.valueOf(c.getTmpDex()));
		//Constitution
		conScore.setText(String.valueOf(c.getConstitution()));
		conTmpScore.setText(String.valueOf(c.getTmpCon()));
		//Intelligence
		intScore.setText(String.valueOf(c.getIntelligence()));
		intTmpScore.setText(String.valueOf(c.getTmpInt()));
		//Charisma
		chaScore.setText(String.valueOf(c.getCharisma()));
		chaTmpScore.setText(String.valueOf(c.getTmpCha()));
		//Wisdom
		wisScore.setText(String.valueOf(c.getWisdom()));
		wisTmpScore.setText(String.valueOf(c.getTmpWis()));
		
	}
	
	/*
	 * Update the character passed in
	 */
	public Character updateCharacter(Character c)
	{
		//Update the values based on the content of the 
		c.setName(name.getText().toString());
		c.setLevel(getInt(level.getText().toString()));
		c.setClasss(classs.getSelectedItem().toString());
		c.setAlignment(align.getSelectedItem().toString());
		c.setDeity(deity.getSelectedItem().toString());
		c.setRace(race.getSelectedItem().toString());
		c.setStrength(getInt(strScore.getText().toString()));
		c.setTmpStr(getInt(strTmpScore.getText().toString()));
		c.setDexterity(getInt(dexScore.getText().toString()));
		c.setTmpDex(getInt(dexTmpScore.getText().toString()));
		c.setConstitution(getInt(conScore.getText().toString()));
		c.setTmpCon(getInt(conTmpScore.getText().toString()));
		c.setIntelligence(getInt(intScore.getText().toString()));
		c.setTmpInt(getInt(intTmpScore.getText().toString()));
		c.setWisdom(getInt(wisScore.getText().toString()));
		c.setTmpWis(getInt(wisTmpScore.getText().toString()));
		c.setCharisma(getInt(chaScore.getText().toString()));
		c.setTmpCha(getInt(chaTmpScore.getText().toString()));
		
		
		//Return the populated character
		return c;
	}
	
	/*
	 * Return the int value of a string.  if the string is blank return 0
	 */
	public int getInt(String s)
	{
		int r =0;
		if (s.length()>0)
		{
			r=Integer.parseInt(s);
		}
		return r;
	}
	
	/*
	 * The position you want the spinner to be set to
	 */
	public int getSpinnerPosition(int b, //the class you are switching
			String s)
	{
		//The value to return
		int r=0;
		//The array of values to compare to
		String ar[]=null;
		
		switch (b)
		{
		case 0:	//Classes
			ar=CLASSES;
			break;
		case 1:	//Alignment
			ar=ALIGNMENT;
			break;
		case 2:	//Deities
			ar=DEITIES;
			break;
		case 3:	//Races
			ar=RACES;
			break;
		}
		//compare the String passed in to the chosen array
		for (int i=0; i<ar.length;i++)
		{
			if (s.equals(ar[i]))
			{
				r=i;
			}
		}
		//Return the position
		return r;
	}
	
	/*
	 * Calculate the modifier based off of the score passed in
	 */
	public int calcMod(int score)
	{
		//formula: (score-10)/2
		return (score-SUBMOD)/HALF;
	}
	
	/*
	 * Update the Stats Textviews when view is lost
	 */
	public class StatsListener implements EditText.OnFocusChangeListener
	{

		@Override
		public void onFocusChange(View v, boolean hasFocus) {
			if(!hasFocus)
			{
				onResume();
			}
		}
	}
	
	public class LevelListener implements EditText.OnFocusChangeListener
	{

		@Override
		public void onFocusChange(View v, boolean hasFocus) {
			if (!hasFocus)
			{
				if((!(c.gettHealth()==0)) && (!(c.getLevel()==Integer.parseInt(level.getText().toString()))))
				{
					//determine the difference between the previous level and the new level
					int difference = Integer.parseInt(level.getText().toString())-c.getLevel();
					
					if(difference>0)
					{//level up
						for(int i=0; i<difference;i++)
						{
							//Add 2 because for correct health calculation the value must be greater than 1
							c.settHealth(c.gettHealth()+c.calcCurrentLevelHealth(i+2));
						}
					}else if(difference<0)
					{//level down
						difference = difference*-1;
						for(int i=0;i<difference;i++)
						{
							//Add 2 because for correct health calculation the value must be greater than 1
							c.settHealth(c.gettHealth()-c.calcCurrentLevelHealth(i+2));
						}
					}
					//Set the current health to the total health
					c.setcHealth(c.gettHealth());
				}
			}
		}
	}
	
	public class SelectedListener implements OnItemSelectedListener
	{
		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			
			//When a class is selcted query Parse to get character details
			String classSelected = classs.getSelectedItem().toString();
			//ensure that the spinner label was not selected
			if (!(classSelected.equalsIgnoreCase(CLASSES[0])))
			{
				//Get the class details for the given class
				new ParseQuery("ClassDetails").whereEqualTo("Name", classSelected).getFirstInBackground(new GetCallback() {
					
					@Override
					public void done(ParseObject classDetails, ParseException e) {
						if (e==null)
						{
							int p = c.getLevel()-1; //The position in the array associated with the current level
							//the array is base 0 but the level is not
							
							//Set the base attack of the character to the returned value
							c.setBaseAttack((Integer)classDetails.getList("BaseAttackBonus").get(p));
							
							//set the hitdie
							c.setHitDie(classDetails.getInt("hitDie"));
							
							//Set the characters saves
							c.setWill(c.calcSave(Integer.parseInt(classDetails.getList("WillSave").get(p).toString()),c.getModWis(),0));
							c.setReflex(c.calcSave(Integer.parseInt(classDetails.getList("RefSave").get(p).toString()),c.getModDex(), 0));
							c.setFortitude(c.calcSave(Integer.parseInt(classDetails.getList("FortSave").get(p).toString()),c.getModCon(), 0));
						}
					}
				});
				
				//if the class has changed reset the health
				if (!(classSelected.equalsIgnoreCase(c.getClasss())))
				{
					//set the health
					c.settHealth(0);
					c.setcHealth(0);
				}
			}
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
						
		}
		
	}
	

}
