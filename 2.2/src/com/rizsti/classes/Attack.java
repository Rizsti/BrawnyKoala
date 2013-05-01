package com.rizsti.classes;

public class Attack {
	
	private String name;		//the name of the weapon/attack
	private String type;		//the type of weapon
	private String size;		//The size classification of the weapon
	private String special;		//The special properties of the attack
	private String range;			//the distance at which the attack may hit
	private String weight;			//the weight of the weapon
	private String damage;			//the damage the attack does
	
	private int lowCrit;		//the bottom of the critical range
	private int highCrit;		//the top of the critical range
	private int aBonus;			//the attack bonus
	private Integer id;				//the attack's identification number
	
	
	/*
	 * Blank constructor
	 */
	public Attack() {
		this.name = "";
		this.type = "";
		this.size = "";
		this.id = null;
		this.range = "0";
		this.weight = "0";
		this.damage = "0";
		this.lowCrit = 0;
		this.highCrit = 0;
		this.aBonus = 0;
		this.special="";
	}


	/*
	 * All args constructor
	 */
	public Attack(String name, String type, String size, Integer id, String range,
			String weight, String damage, int lowCrit, int highCrit, int aBonus, String special) {
		
		this.name = name;
		this.type = type;
		this.size = size;
		this.id = id;
		this.range = range;
		this.weight = weight;
		this.damage = damage;
		this.lowCrit = lowCrit;
		this.highCrit = highCrit;
		this.aBonus = aBonus;
		this.special = special;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the range
	 */
	public String getRange() {
		return range;
	}


	/**
	 * @return the weight
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * @return the damage
	 */
	public String getDamage() {
		return damage;
	}

	/**
	 * @return the lowCrit
	 */
	public int getLowCrit() {
		return lowCrit;
	}

	/**
	 * @return the highCrit
	 */
	public int getHighCrit() {
		return highCrit;
	}

	/**
	 * @return the aBonus
	 */
	public int getaBonus() {
		return aBonus;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}



	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * @param range the range to set
	 */
	public void setRange(String range) {
		this.range = range;
	}



	/**
	 * @param weight the weight to set
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}



	/**
	 * @param damage the damage to set
	 */
	public void setDamage(String damage) {
		this.damage = damage;
	}



	/**
	 * @param lowCrit the lowCrit to set
	 */
	public void setLowCrit(int lowCrit) {
		this.lowCrit = lowCrit;
	}



	/**
	 * @param highCrit the highCrit to set
	 */
	public void setHighCrit(int highCrit) {
		this.highCrit = highCrit;
	}



	/**
	 * @param aBonus the aBonus to set
	 */
	public void setaBonus(int aBonus) {
		this.aBonus = aBonus;
	}



	/**
	 * @return the special
	 */
	public String getSpecial() {
		return special;
	}



	/**
	 * @param special the special to set
	 */
	public void setSpecial(String special) {
		this.special = special;
	}
	
	
}
