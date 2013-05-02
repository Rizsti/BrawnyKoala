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
	
	/**
	 * Blank constructor
	 */
	public Spell() {
		super();
		this.name = "";
		this.type = "";
		this.classes = null;
		this.range = "";
		this.target = "";
		this.area = "";
		this.components = null;
		this.castingTime = "";
		this.duration = "";
		this.spellResistance = false;
		this.spellResistanceEffect = "";
		this.savingThrow = "";
	}



	
	/**
	 * @param name
	 * @param type
	 * @param classes
	 * @param range
	 * @param target
	 * @param area
	 * @param components
	 * @param castingTime
	 * @param duration
	 * @param spellResistance
	 * @param spellResistanceEffect
	 * @param savingThrow
	 */
	public Spell(String name, String type, Map<String, String> classes,
			String range, String target, String area, String[] components,
			String castingTime, String duration, boolean spellResistance,
			String spellResistanceEffect, String savingThrow) {
		super();
		this.name = name;
		this.type = type;
		this.classes = classes;
		this.range = range;
		this.target = target;
		this.area = area;
		this.components = components;
		this.castingTime = castingTime;
		this.duration = duration;
		this.spellResistance = spellResistance;
		this.spellResistanceEffect = spellResistanceEffect;
		this.savingThrow = savingThrow;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the classes
	 */
	public Map<String, String> getClasses() {
		return classes;
	}

	/**
	 * @param classes the classes to set
	 */
	public void setClasses(Map<String, String> classes) {
		this.classes = classes;
	}

	/**
	 * @return the range
	 */
	public String getRange() {
		return range;
	}


	/**
	 * @param range the range to set
	 */
	public void setRange(String range) {
		this.range = range;
	}

	/**
	 * @return the target
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * @param target the target to set
	 */
	public void setTarget(String target) {
		this.target = target;
	}

	/**
	 * @return the components
	 */
	public String[] getComponents() {
		return components;
	}

	/**
	 * @param components the components to set
	 */
	public void setComponents(String[] components) {
		this.components = components;
	}

	/**
	 * @return the castingTime
	 */
	public String getCastingTime() {
		return castingTime;
	}

	/**
	 * @param castingTime the castingTime to set
	 */
	public void setCastingTime(String castingTime) {
		this.castingTime = castingTime;
	}

	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}

	/**
	 * @return the spellResistanceEffect
	 */
	public String getSpellResistanceEffect() {
		return spellResistanceEffect;
	}

	/**
	 * @param spellResistanceEffect the spellResistanceEffect to set
	 */
	public void setSpellResistanceEffect(String spellResistanceEffect) {
		this.spellResistanceEffect = spellResistanceEffect;
	}

	/**
	 * @return the savingThrow
	 */
	public String getSavingThrow() {
		return savingThrow;
	}

	/**
	 * @param savingThrow the savingThrow to set
	 */
	public void setSavingThrow(String savingThrow) {
		this.savingThrow = savingThrow;
	}

	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @return the spellResistance
	 */
	public boolean isSpellResistance() {
		return spellResistance;
	}

	/**
	 * @param spellResistance the spellResistance to set
	 */
	public void setSpellResistance(boolean spellResistance) {
		this.spellResistance = spellResistance;
	}

	
	
}
