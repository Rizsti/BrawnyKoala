package com.rizsti.classes;

import java.util.Map;

/**
 * A spell 
 * @author Andrea Dewey
 * Last Edited: May 2013
 *
 */
public class Spell {

	private String name; 	//The name of the spell
	private String type; 	//The type of the spell ie conjuration etc
	private Map<String,String> classes;	//The classes that can use the spell and the level it can be used at (class, level)
	private String range;	//The distance the spell will reach
	private String target; 	//Who the spell can hit
	private String[] components;
	private String castingTime;	//The length of time it takes to cast the spell
	private String duration;	//The length of time the spell lasts
	private String spellResistanceEffect;	//The effect of the spell resistance
	private String savingThrow;	//The saving throw
	private String area;		//The area of effect
	
	private boolean spellResistance;	//Whether the spell is affected by spell resistance
	
	
	
}
