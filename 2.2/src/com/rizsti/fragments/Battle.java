package com.rizsti.fragments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.rizsti.classes.Attack;
import com.rizsti.classes.Character;
import com.rizsti.teddy.R;

/**
 * 
 * @author Andrea Dewey
 *
 */
public class Battle extends Fragment {

	//The view that gets inflated
	View v;
	
	//Edit texts
	EditText cHealth; 	//Current health
	EditText exp;		//Experience
	
	//TextViews
	TextView tHealth, 	//Total health
	init,				//Initiative
	melee,				//Melee attack
	ranged,				//Ranged Attack
	grapple,			//Grapple
	will,				//Will save
	fort,				//Fortitude save
	ref;				//Reflex save
	
	//List view
	ListView lv;		//Attacks listview
	
	Character c=new Character();
	
	List<Map<String,String>> lm;
	
	/*
	 * When the View is created
	 * (non-Javadoc)
	 * @see android.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
		      Bundle savedInstanceState) {
		 //infalte a view  
		 v= inflater.inflate(R.layout.fragment_battle,
		        container, false);
		 //Assign the page elements to variables
		 cHealth = (EditText) v.findViewById(R.id.batCurHealth);
		 tHealth = (TextView) v.findViewById(R.id.batTotHealth);
		 init	 = (TextView) v.findViewById(R.id.bInit);
		 exp 	 = (EditText) v.findViewById(R.id.bExp);
		 melee	 = (TextView) v.findViewById(R.id.bMelee);
		 ranged	 = (TextView) v.findViewById(R.id.bRanged);
		 grapple = (TextView) v.findViewById(R.id.bGrapple);
		 will	 = (TextView) v.findViewById(R.id.bWill);
		 fort 	 = (TextView) v.findViewById(R.id.bFort);
		 ref	 = (TextView) v.findViewById(R.id.bRef);
		 lv 	 = (ListView) v.findViewById(R.id.lvAttacks);
		 
		 //return the view
		 return v;
	 }
	 
	 /**
	  * When the fragment resumes, update the page elements
	  */
	 public void onResume()
	 {
		 cHealth.setText(String.valueOf(c.getcHealth()));
		 tHealth.setText(String.valueOf(c.gettHealth()));
		 init.setText(String.valueOf(c.getInitiative()));
		 exp.setText(String.valueOf(c.getExperience()));
		 melee.setText(String.valueOf(calcMelee()));
		 ranged.setText(String.valueOf(calcRanged()));
		 grapple.setText(String.valueOf(calcGrapple()));
		 will.setText(String.valueOf(c.getWill()));
		 fort.setText(String.valueOf(c.getFortitude()));
		 ref.setText(String.valueOf(c.getReflex()));
		 SimpleAdapter sa = new SimpleAdapter(getActivity(),
				 convertData(c.getAttacks()), 
				 R.layout.listview_attacks, 
				 new String[]{"Name", "AtkBonus","Damage","Crit","Range","Weight","Type","Size","Special"}, 
				 new int[]{R.id.attkName,R.id.attkBonus,R.id.attkDamage,R.id.attkCrit, R.id.attkRange,
			 R.id.attkWeight,R.id.attkType, R.id.attkSize,R.id.attkSpecial});
		 lv.setAdapter(sa);
		 super.onResume();
	 }
	 
	 /*
	  * Update the elements on the page based off of a given character
	  */
	 public void setCharacter(Character ch)
	 {
		 c=ch;
	 }
	 
	 /*
	  * Return an updated Character object
	  */
	 public Character updateCharacter(Character c)
	 {
		 c.setcHealth(getInt(cHealth.getText().toString()));
		 c.setExperience(getInt(exp.getText().toString()));
		 c.setInitiative(getInt(init.getText().toString()));
		 c.setAttacks(this.c.getAttacks());
		return c;
		 
	 }
	 
	 /*
	  * Convert the list of attacks into a hash map
	  */
	 public List<Map<String,String>> convertData(ArrayList<Attack> at)
	 {
		 //Create the list of hashmaps to return
		 List<Map<String,String>> lm = new ArrayList<Map<String,String>>();
		 
		 //Add each element to the hashmap
		 for (int i=0; i<at.size();i++)
		 {
			 //The current attack
			 Attack a = at.get(i);
			 //Create a hashmap to add to the list
			 Map<String,String> map = new HashMap<String,String>();
			 
			 //Add the data to the map
			 map.put("Name", a.getName());
			 map.put("AtkBonus", String.valueOf(a.getaBonus()));
			 map.put("Damage",String.valueOf(a.getDamage()));
			 map.put("Crit", String.valueOf(a.getLowCrit())+"-"+String.valueOf(a.getHighCrit()));
			 map.put("Range", String.valueOf(a.getRange()));
			 map.put("Weight", String.valueOf(a.getWeight()));
			 map.put("Type", String.valueOf(a.getType()));
			 map.put("Size", String.valueOf(a.getSize()));
			 map.put("Special", String.valueOf(a.getSpecial()));
			 map.put("Id", String.valueOf(a.getId()));
			 
			 //Add the map to the list
			 lm.add(map);
		 }
		 
		 //Return the list
		 return lm;
	 }
	 
	 /*
	  * Convert the data in the hash map to an array list of attacks
	  */
	 public ArrayList<Attack> unConvert(List<Map<String,String>> lm)
	 {
		 
		 ArrayList<Attack> at = new ArrayList<Attack>();
		 if (!(lm==null))
		 {
			 for (int i =0; i<lm.size(); i++)
			 {
				 Map<String,String> map = lm.get(i);
				 //Create the attack object based on the parameters in the hash map
				 Attack a = new Attack(map.get("Name"),map.get("Type"),map.get("Size"),getInt(map.get("Id")), 
						 map.get("Range"),map.get("Weight"),map.get("Damage"),getCrit(map.get("Crit"),"low"),
						 getCrit(map.get("Crit"),"high"),getInt(map.get("AtkBonus")), map.get("Special"));
				 //Add the attack object to the arraylist
				 at.add(a);
			 }
		 }
		 
		 //Return the array list
		 return at;
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
		 * Determine the high or low value of the crit based on the crit range passed in
		 */
		public int getCrit(String range, String highOrLow)
		{
			int r=0;
			String dash="-";
			String c;
			int dashPosition=range.indexOf(dash); //The posisiton of the dash
			int length = range.length();	//The length of the string passed in
			//If we're looking for the low end of the crit range
			if(highOrLow.equalsIgnoreCase("low"))
			{
				c = new String(range.toCharArray(), 0, dashPosition);
			}
			else
			{//if we're looking for the high end of the crit range
				dashPosition+=1;
				c = new String(range.toCharArray(), dashPosition, length-dashPosition);
			}
			
			r = Integer.parseInt(c);
			return r;
		}
		
		/**
		 * Calculate the characters melee bonus 
		 * return: Melee bonus
		 */
		public int calcMelee()
		{
			//Formula: BaseAttack+Strength modifier+size modifier + misc
			//Currently ignoring size and misc
			int r=0;
			r = c.getBaseAttack()[0] + c.getModStr();
			return r;
		}
		
		/**
		 * Calculate the characters ranged bonus
		 * return: Ranged bonus
		 */
		public int calcRanged()
		{
			//Formula: Baseattack + Dex Modifier + size + misc
			//Currently ignoring size and misc
			int r =0;
			r = c.getBaseAttack()[0]+c.getModDex();
			return r;
		}
		
		/**
		 * Calculate the characters grapple
		 */
		public int calcGrapple()
		{
			
			int r =0;
			r = c.getBaseAttack()[0]+c.getModStr();
			return r;
		}
		
		
		/**
		 * Show the dialog that creates the attack
		 * @param edit: Whether the attack is being created(false) or edited(true)
		 */
		public Dialog onCreateDialog(Bundle savedInstanceState, boolean edit) {
		    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		    // Get the layout inflater
		    LayoutInflater inflater = getActivity().getLayoutInflater();

		    // Inflate and set the layout for the dialog
		    // Pass null as the parent view because its going in the dialog layout
		    final View view = inflater.inflate(R.layout.dialogue_add_attack,null);
		    builder.setView(view)
		    // Add action buttons
		           .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
		               @Override
		               public void onClick(DialogInterface dialog, int id) {
		            	   String name 		= ((EditText) view.findViewById(R.id.addAtName)).getText().toString();
		            	   String type 		= ((EditText) view.findViewById(R.id.addAtType)).getText().toString();
		            	   String size 		= ((EditText) view.findViewById(R.id.addAtSize)).getText().toString();
		            	   String special	= ((EditText) view.findViewById(R.id.addAtSpecPro)).getText().toString();
		            	   String range 	= ((EditText) view.findViewById(R.id.addAtRange)).getText().toString();
		            	   String weight	= ((EditText) view.findViewById(R.id.addAtWeight)).getText().toString();
		            	   String damage	= ((EditText) view.findViewById(R.id.addAtDamage)).getText().toString();
		            	   String crit  	= ((EditText) view.findViewById(R.id.addAtCrit)).getText().toString();
		            	   String bonus		= ((EditText) view.findViewById(R.id.addAtBonus)).getText().toString();
		            	   
		            	   Attack a = new Attack(name,type,size,0,range,weight,damage,getCrit(crit, "low"),getCrit(crit,"high"),getInt(bonus),special);
		            	   
		            	   c.addAttack(a);
		            	   onResume();
		               }
		           })
		           .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
		               public void onClick(DialogInterface dialog, int id) {
		                   dialog.cancel();
		               }
		           });      
		    return builder.create();
		}
}
