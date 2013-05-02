package com.rizsti.fragments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import com.rizsti.classes.Character;
import com.rizsti.teddy.R;
	
/**
 * 
 * @author Andrea Dewey
 *
 */
public class Skills extends ListFragment {
	
	//The view created
	private View v;
	//The skills a character can have
	private final String SKILLS[] = {"Appraise","Autohypnosis","Balance","Bluff",
			"Climb","Control Shape", "Concentration", "Craft Skills...","Decipher Script", "Diplomacy",
			"Disable Device", "Disguise", "Escapse Artist", "Forgery", "Gather Information", 
			"Handle Animal", "Heal", "Hide", "Hypnosis", "Intimidate", "Jump", "Knowldge(Arcana)",
			"Knowledge(Arch & Eng)", "Knowledge(Dungeoneering)", "Knowledge(Geography)", "Knowledge(History)",
			"Knowledge(Local)","Knowledge(Monster Lore)", "Knowledge(Nature)", "Knowledge(Nobility)", 
			"Knowledge(Psionics)", "Knowledge(Ravenloft)", "Knowledge(Religion)", "Knowledge(Planes)",
			"Knowledge Skills...", "Listen","Move Silent", "Open Lock", "Perform Skills...", "Psicraft",
			"Ride", "Search", "Sense Motive", "Skill Tricks", "Sleight of Hand", "Speak Language", "Spellcraft",
			"Spot", "Survival", "Swim", "Tumble", "Use Magic Device", "Use Psionic Device", "Use Rope"};
	//An array with the corresponding statistic modifier for the skills array
	private final String STATMOD[] ={"INT","WIS","DEX","CHA","STR","WIS", "CON", "INT", "INT", "CHA", 
			"DEX", "INT", "CHA", "CHA", "WIS", "DEX", "CHA", "CHA", "WIS", "DEX", "CHA", "CHA", "STR", "INT", 
			"INT", "INT","INT", "INT","INT", "INT","INT", "INT","INT", "INT","INT", "INT","INT","WIS", 
			"INT", "DEX", "DEX", "CHA", "WIS", "INT", "DEX", "INT", "WIS", "", "DEX", "INT", "INT", "WIS", 
			"WIS", "STR", "DEX", "CHA", "CHA", "DEX"};
	
	
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		      Bundle savedInstanceState) {
		//infalte the view
		v= inflater.inflate(R.layout.fragment_skills,
	        container, false);
		
		//return the view
		return v;
	}
	
	public void populateListView(Character c, Context con)
	{
		List<Map<String,String>> lm = getData(c);
		if(con==null)
		{
			Log.d("Null", "Context is null");
		}
		if(lm==null)
		{
			Log.d("Null", "ListMap is null");
		}
				//create the adapter
				SimpleAdapter sa = new SimpleAdapter(con, 
						getData(c), 
						R.layout.listview_skills, 
						new String[] {"SkillName", "Mod", "Rank", "Stat", "Misc"}, 
						new int[] {R.id.sName, R.id.sMod, R.id.sRank, R.id.sAMod, R.id.sMisc});
				//assign the adapter
				setListAdapter(sa);
		
	}
	
	public List<Map<String,String>> getData(Character c)
	{
		//create an instance of the List of HashMaps that you will return
		List<Map<String, String>> lm = new ArrayList<Map<String,String>>();
		int[] ranks = c.getSkillsRanks().getSkillsArray();
		int[] misc = c.getSkillsMisc().getSkillsArray();
			for (int i=0; i<SKILLS.length; i++)
			{
				//Create a new hashmap to add to you list
				Map<String,String> map = new HashMap<String,String>();
				
				int stat=0;
				//determine the stat to be added to the skill
				if (STATMOD[i].equals("STR"))
					stat= (c.getModStr());
				
				if(STATMOD[i].equals("INT"))
					stat=(c.getModInt());
				
				if(STATMOD[i].equals("WIS"))
					stat=(c.getModWis());
				
				if(STATMOD[i].equals("DEX"))
					stat=(c.getModDex());
				
				if(STATMOD[i].equals("CHA"))
					stat=(c.getModCha());
				
				if(STATMOD[i].equals("CON"))
					stat=(c.getModCon());
				
				//array of skill ranks
				int r = ranks[i];
				int m = misc[i];
				//populate the hashmap
				map.put("SkillName", SKILLS[i]);
				map.put("Mod", String.valueOf(calcModifier(m, r, stat)));
				map.put("Rank", String.valueOf(r));
				map.put("Stat", String.valueOf(stat));
				map.put("Misc", String.valueOf(m));
				
				//add the hashmap to your list of hashmaps
				lm.add(map);
				
			}
			
			//return your list
			return lm;
	}
	
	//calculate the skill modifier
	public int calcModifier(int misc, int rank, int stat)
	{
		return misc + rank + stat;
		
	}
	
	
}
