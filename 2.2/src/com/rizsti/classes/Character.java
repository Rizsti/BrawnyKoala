package com.rizsti.classes;

import java.util.ArrayList;
import java.util.Random;



public class Character {
	
	//calculation variables
	private final int HALF =2;
	private final int TEN = 10;
	private final int BATTLE_SUB = 5;
	private final int BATTLE_FIRST_MARK = 6;
	private final int BATTLE_SECOND_MARK = 11;
	private final int BATTLE_THIRD_MARK = 16;
	
	
	Random generator;
	
	private String name;		//characters name
	private String hairColour;	//characters hair colour
	private String eyeColour;	//characters eyecolour
	private String race;		//characters race
	private String alignment;	//characters alignment
	private String deity;		//deity the character worships
	private String classs;		//the characters class
	private ArrayList<String> language;	//languages that character knows

	private Integer id;			//The custom id of the character
	private int age;			//age of the character
	private int experience;		//current character experience
	private int hitDie=1;		//characters hit die


	private int initiative;		//characters initiative
	private int tHealth;		//characters total health
	private int cHealth;		//the characters current health
	private int level=1;		//the characters level
	private int height;			//characters height
	private int weight;			//characters weight
	private int grapple;		//the characters grapple
	private int[] baseAttack;		//the characters base attack
	private int gold;			//the amount of gold the character has
	private int ac;				//Armour class
	private int touch;			//Touch ac
	
	private double carryingCapacity;	//the weight the character can carry without taking minuses
	
	//Abilities
	private int strength; 		//Actual strength
	private int wisdom;			//Actual wisdom
	private int dexterity;		//Actual dexterity
	private int constitution;	//Actual constitution
	private int intelligence;	//Actual intelligence
	private int charisma;		//Actual charisma
	private int tmpStr;
	private int tmpWis; 
	private int tmpDex;
	private int tmpCon;
	private int tmpInt;
	private int tmpCha;
	private int modStr; 		//Strength modifier
	private int modWis;			//Wisdom modifier
	private int modDex;			//Dexterity modifier
	private int modCon;			//Constitution modifier
	private int modInt;			//Intelligence modifier
	private int modCha;			//Charisma modifier
	
	//Saving throws
	private int fortitude; 		//Character's base fortitude save
	private int reflex; 		//Character's base reflex save
	private int will; 			//Character's base will save	
	
	private CSkills skillsRanks;		//The characters ranks in certain skills
	private CSkills skillsMisc;			//The misc additions to the skills
	
	private ArrayList<Item> inventory;	//The characters inventory
	private ArrayList<Attack> attacks; //The characters known attacks

	
	
//	    //   ) )                                                            
//	   //         ___       __      ___    __  ___  __               ___     __  __
//	  //        //   ) ) //   ) ) ((   ) )  / /   //  ) ) //   / / //   ) )   / /
//	 //        //   / / //   / /   \ \     / /   //      //   / / //         / /
//	((____/ / ((___/ / //   / / //   ) )  / /   //      ((___( ( ((____     / /
	         
	
	/*
	 * Empty Contsructor
	 */
	public Character()
	{
		id 			= null;
		name 		= "";
		hairColour 	= "";
		eyeColour 	= "";
		race 		= "";
		alignment 	= "";
		deity 		= "";
		classs 		= "";
		language 	= null;
		age 		= 0;
		experience 	= 0;
		initiative 	= 0;
		tHealth 	= 0;
		cHealth		= tHealth;
		level 		= 1;
		height 		= 0;
		weight 		= 0;
		grapple 	= 0;
		baseAttack 	= new int[] {0};
		gold 		= 0;
		carryingCapacity = 0;
		strength 	= 0;
		wisdom 		= 0;
		dexterity 	= 0;
		constitution= 0;
		intelligence= 0;
		charisma 	= 0;
		modStr 		= 0;
		modWis 		= 0;
		modDex 		= 0;
		modCon 		= 0;
		modInt 		= 0;
		modCha 		= 0;
		fortitude 	= 0;
		reflex 		= 0;
		will 		= 0;
		inventory 	= null;
		attacks 	= null;
		skillsRanks	= new CSkills();
		skillsMisc 	= new CSkills();
		attacks 	= new ArrayList<Attack>();
		ac			= 0;
		touch		= 0;
	}

	/*
	 * No attacks contsructor
	 */
	public Character(int id, String name, String hairColour, String eyeColour,
			String race, String alignment, String deity, String classs,
			ArrayList<String> language, int age, int experience,
			int initiative, int health, int chealth, int level, int height, int weight,
			int grapple, int[] baseAttack, int gold, double carryingCapacity,
			int strength, int wisdom, int dexterity, int constitution,
			int intelligence, int charisma, int modStr, int modWis, int modDex,
			int modCon, int modInt, int modCha, int fortitude, int reflex,
			int will, ArrayList<Item> inventory) {
		this.id = id;
		this.name = name;
		this.hairColour = hairColour;
		this.eyeColour = eyeColour;
		this.race = race;
		this.alignment = alignment;
		this.deity = deity;
		this.classs = classs;
		this.language = language;
		this.age = age;
		this.experience = experience;
		this.initiative = initiative;
		this.tHealth = health;
		this.cHealth = chealth;
		this.level = level;
		this.height = height;
		this.weight = weight;
		this.grapple = grapple;
		this.baseAttack = baseAttack;
		this.gold = gold;
		this.carryingCapacity = carryingCapacity;
		this.strength = strength;
		this.wisdom = wisdom;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.charisma = charisma;
		this.modStr = modStr;
		this.modWis = modWis;
		this.modDex = modDex;
		this.modCon = modCon;
		this.modInt = modInt;
		this.modCha = modCha;
		this.fortitude = fortitude;
		this.reflex = reflex;
		this.will = will;
		this.inventory = inventory;
	}
	

	/*
	 * full constructor
	 */
	public Character(String name, String race, String alignment, String deity,
			String classs, int experience, int initiative, int tHealth,
			int cHealth, int level, int grapple, int[] baseAttack, int gold,
			int ac, int touch, double carryingCapacity, int strength,
			int wisdom, int dexterity, int constitution, int intelligence,
			int charisma, int tmpStr, int tmpWis, int tmpDex, int tmpCon,
			int tmpInt, int tmpCha, int modStr, int modWis, int modDex,
			int modCon, int modInt, int modCha, int fortitude, int reflex,
			int will, CSkills skillsRanks, CSkills skillsMisc,
			ArrayList<Item> inventory, ArrayList<Attack> attacks) {
		super();
		this.name = name;
		this.race = race;
		this.alignment = alignment;
		this.deity = deity;
		this.classs = classs;
		this.experience = experience;
		this.initiative = initiative;
		this.tHealth = tHealth;
		this.cHealth = cHealth;
		this.level = level;
		this.grapple = grapple;
		this.baseAttack = baseAttack;
		this.gold = gold;
		this.ac = ac;
		this.touch = touch;
		this.carryingCapacity = carryingCapacity;
		this.strength = strength;
		this.wisdom = wisdom;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.charisma = charisma;
		this.tmpStr = tmpStr;
		this.tmpWis = tmpWis;
		this.tmpDex = tmpDex;
		this.tmpCon = tmpCon;
		this.tmpInt = tmpInt;
		this.tmpCha = tmpCha;
		this.modStr = modStr;
		this.modWis = modWis;
		this.modDex = modDex;
		this.modCon = modCon;
		this.modInt = modInt;
		this.modCha = modCha;
		this.fortitude = fortitude;
		this.reflex = reflex;
		this.will = will;
		this.skillsRanks = skillsRanks;
		this.skillsMisc = skillsMisc;
		this.inventory = inventory;
		this.attacks = attacks;
	}

	
	
	/*
	 * Calculate the modifier of a stat
	 */
	public int calcMod(int i)
	{
		return (i-TEN)/HALF;
	}
	
//    //   ) )                                                  
//   //         ___    __  ___ __  ___  ___      __      ___    
//  //  ____  //___) )  / /     / /   //___) ) //  ) ) ((   ) ) 
// //    / / //        / /     / /   //       //        \ \     
//((____/ / ((____    / /     / /   ((____   //      //   ) ) 	

	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	public Integer getIntegerId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @return the hairColour
	 */
	public String getHairColour() {
		return hairColour;
	}


	/**
	 * @return the eyeColour
	 */
	public String getEyeColour() {
		return eyeColour;
	}


	/**
	 * @return the race
	 */
	public String getRace() {
		return race;
	}


	/**
	 * @return the alignment
	 */
	public String getAlignment() {
		return alignment;
	}


	/**
	 * @return the deity
	 */
	public String getDeity() {
		return deity;
	}


	/**
	 * @return the classs
	 */
	public String getClasss() {
		return classs;
	}


	/**
	 * @return the language
	 */
	public ArrayList<String> getLanguage() {
		return language;
	}


	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}


	/**
	 * @return the experience
	 */
	public int getExperience() {
		return experience;
	}


	/**
	 * @return the initiative
	 */
	public int getInitiative() {
		return initiative;
	}


	
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}


	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}


	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}


	/**
	 * @return the grapple
	 */
	public int getGrapple() {
		return grapple;
	}


	/**
	 * @return the baseAttack
	 */
	public int[] getBaseAttack() {
		return baseAttack;
	}
	
	public int[] getBaseAttackArray()
	{
		//Cast the object to an array
		int[] r = (int[]) baseAttack;
		return r;
	}


	/**
	 * @return the gold
	 */
	public int getGold() {
		return gold;
	}


	/**
	 * @return the carryingCapacity
	 */
	public double getCarryingCapacity() {
		return carryingCapacity;
	}


	/**
	 * @return the strength
	 */
	public int getStrength() {
		return strength;
	}


	/**
	 * @return the wisdom
	 */
	public int getWisdom() {
		return wisdom;
	}


	/**
	 * @return the dexterity
	 */
	public int getDexterity() {
		return dexterity;
	}


	/**
	 * @return the constitution
	 */
	public int getConstitution() {
		return constitution;
	}


	/**
	 * @return the intelligence
	 */
	public int getIntelligence() {
		return intelligence;
	}


	/**
	 * @return the charisma
	 */
	public int getCharisma() {
		return charisma;
	}


	/**
	 * @return the modStr
	 */
	public int getModStr() {
		return modStr;
	}


	/**
	 * @return the modWis
	 */
	public int getModWis() {
		return modWis;
	}


	/**
	 * @return the modDex
	 */
	public int getModDex() {
		return modDex;
	}


	/**
	 * @return the modCon
	 */
	public int getModCon() {
		return modCon;
	}


	/**
	 * @return the modInt
	 */
	public int getModInt() {
		return modInt;
	}


	/**
	 * @return the modCha
	 */
	public int getModCha() {
		return modCha;
	}


	/**
	 * @return the fortitude
	 */
	public int getFortitude() {
		return fortitude;
	}


	/**
	 * @return the reflex
	 */
	public int getReflex() {
		return reflex;
	}


	/**
	 * @return the will
	 */
	public int getWill() {
		return will;
	}


	/**
	 * @return the inventory
	 */
	public ArrayList<Item> getInventory() {
		return inventory;
	}

	
//    //   ) )                                                  
//   ((         ___    __  ___ __  ___  ___      __      ___    
//     \\     //___) )  / /     / /   //___) ) //  ) ) ((   ) ) 
//       ) ) //        / /     / /   //       //        \ \     
//((___ / / ((____    / /     / /   ((____   //      //   ) )
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @param hairColour the hairColour to set
	 */
	public void setHairColour(String hairColour) {
		this.hairColour = hairColour;
	}


	/**
	 * @param eyeColour the eyeColour to set
	 */
	public void setEyeColour(String eyeColour) {
		this.eyeColour = eyeColour;
	}


	/**
	 * @param race the race to set
	 */
	public void setRace(String race) {
		this.race = race;
	}


	/**
	 * @param alignment the alignment to set
	 */
	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}


	/**
	 * @param deity the deity to set
	 */
	public void setDeity(String deity) {
		this.deity = deity;
	}


	/**
	 * @param classs the classs to set
	 */
	public void setClasss(String classs) {
		this.classs = classs;
	}


	/**
	 * @param language the language to set
	 */
	public void setLanguage(ArrayList<String> language) {
		this.language = language;
	}


	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}


	/**
	 * @param experience the experience to set
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}


	/**
	 * @param initiative the initiative to set
	 */
	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}


	
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}


	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}


	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}


	/**
	 * @param grapple the grapple to set
	 */
	public void setGrapple(int grapple) {
		this.grapple = grapple;
	}


	/**
	 * @param baseAttack the baseAttack to set
	 */
	public void setBaseAttack(int baseAttack) {
		
		if (baseAttack<BATTLE_FIRST_MARK)
		{
			//the length of the array is 1
			this.baseAttack = new int[] {baseAttack};
		}
		else if(baseAttack>BATTLE_FIRST_MARK&&baseAttack<BATTLE_SECOND_MARK)
		{
			//the length of the array is 2
			this.baseAttack = new int[] {baseAttack,baseAttack-BATTLE_SUB};
		}
		else if(baseAttack>BATTLE_SECOND_MARK&&baseAttack<BATTLE_THIRD_MARK)
		{
			//the length of the array is 3
			this.baseAttack = new int[] {baseAttack,baseAttack-BATTLE_SUB,baseAttack-BATTLE_SUB-BATTLE_SUB};
		}
		else if(baseAttack>BATTLE_THIRD_MARK)
		{
			this.baseAttack = new int[] {baseAttack,baseAttack-BATTLE_SUB,baseAttack-BATTLE_SUB-BATTLE_SUB,
					baseAttack-BATTLE_SUB-BATTLE_SUB-BATTLE_SUB};
		
		}
		
	}


	/**
	 * @param gold the gold to set
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}


	/**
	 * @param carryingCapacity the carryingCapacity to set
	 */
	public void setCarryingCapacity(double carryingCapacity) {
		this.carryingCapacity = carryingCapacity;
	}


	/**
	 * @param strength the strength to set
	 */
	public void setStrength(int strength) {
		this.strength = strength;
		modStr = calcMod(strength);
	}


	/**
	 * @param wisdom the wisdom to set
	 */
	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
		modWis = calcMod(wisdom);
	}


	/**
	 * @param dexterity the dexterity to set
	 */
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
		modDex = calcMod(dexterity);

		//Calculate the initiative because initiative is based off of dexterity
		calcInit();
	}


	/**
	 * @param constitution the constitution to set
	 */
	public void setConstitution(int constitution) {
		this.constitution = constitution;
		modCon = calcMod(constitution);
	}


	/**
	 * @param intelligence the intelligence to set
	 */
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
		modInt = calcMod(intelligence);
	}


	/**
	 * @param charisma the charisma to set
	 */
	public void setCharisma(int charisma) {
		this.charisma = charisma;
		modCha = calcMod(charisma);
	}


	/**
	 * @param modStr the modStr to set
	 */
	public void setModStr(int modStr) {
		this.modStr = modStr;
	}


	/**
	 * @param modWis the modWis to set
	 */
	public void setModWis(int modWis) {
		this.modWis = modWis;
	}


	/**
	 * @param modDex the modDex to set
	 */
	public void setModDex(int modDex) {
		this.modDex = modDex;

	}


	/**
	 * @param modCon the modCon to set
	 */
	public void setModCon(int modCon) {
		this.modCon = modCon;
	}


	/**
	 * @param modInt the modInt to set
	 */
	public void setModInt(int modInt) {
		this.modInt = modInt;
	}


	/**
	 * @param modCha the modCha to set
	 */
	public void setModCha(int modCha) {
		this.modCha = modCha;
	}


	/**
	 * @param fortitude the fortitude to set
	 */
	public void setFortitude(int fortitude) {
		this.fortitude = fortitude;
	}

	/**
	 * @param reflex the reflex to set
	 */
	public void setReflex(int reflex) {
		this.reflex = reflex;
	}

	/**
	 * @param will the will to set
	 */
	public void setWill(int will) {
		this.will = will;
	}

	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}

	/**
	 * @return the skillRanks
	 */
	public CSkills getSkillsRanks() {
		return skillsRanks;
	}

	/**
	 * @param skillsRanks the skillsRanks to set
	 */
	public void setSkillsRanks(CSkills skillsRanks) {
		this.skillsRanks = skillsRanks;
	}

	/**
	 * @param skillRanks the skillRanks to set
	 */
	public void setSkillRanks(CSkills skills) {
		this.skillsRanks = skills;
	}

	/**
	 * @return the skillsMisc
	 */
	public CSkills getSkillsMisc() {
		return skillsMisc;
	}

	/**
	 * @param skillsMisc the skillsMisc to set
	 */
	public void setSkillsMisc(CSkills skillsMisc) {
		this.skillsMisc = skillsMisc;
	}

	/**
	 * @return the tHealth
	 */
	public int gettHealth() {
		return tHealth;
	}


	/**
	 * @return the cHealth
	 */
	public int getcHealth() {
		return cHealth;
	}


	/**
	 * @param tHealth the tHealth to set
	 */
	public void settHealth(int tHealth) {
		this.tHealth = tHealth;
	}


	/**
	 * @param cHealth the cHealth to set
	 */
	public void setcHealth(int cHealth) {
		this.cHealth = cHealth;
	}

	/**
	 * @return the ac
	 */
	public int getAc() {
		return ac;
	}

	/**
	 * @return the touch
	 */
	public int getTouch() {
		return touch;
	}

	/**
	 * @param ac the ac to set
	 */
	public void setAc(int ac) {
		this.ac = ac;
	}

	/**
	 * @param touch the touch to set
	 */
	public void setTouch(int touch) {
		this.touch = touch;
	}

	/**
	 * @return the tmpStr
	 */
	public int getTmpStr() {
		return tmpStr;
	}

	/**
	 * @return the tmpWis
	 */
	public int getTmpWis() {
		return tmpWis;
	}

	/**
	 * @return the tmpDex
	 */
	public int getTmpDex() {
		return tmpDex;
	}

	/**
	 * @return the tmpCon
	 */
	public int getTmpCon() {
		return tmpCon;
	}

	/**
	 * @return the tmpInt
	 */
	public int getTmpInt() {
		return tmpInt;
	}

	/**
	 * @return the tmpCha
	 */
	public int getTmpCha() {
		return tmpCha;
	}

	/**
	 * @param tmpStr the tmpStr to set
	 */
	public void setTmpStr(int tmpStr) {
		this.tmpStr = tmpStr;
	}

	/**
	 * @param tmpWis the tmpWis to set
	 */
	public void setTmpWis(int tmpWis) {
		this.tmpWis = tmpWis;
	}

	/**
	 * @param tmpDex the tmpDex to set
	 */
	public void setTmpDex(int tmpDex) {
		this.tmpDex = tmpDex;
	}

	/**
	 * @param tmpCon the tmpCon to set
	 */
	public void setTmpCon(int tmpCon) {
		this.tmpCon = tmpCon;
	}

	/**
	 * @param tmpInt the tmpInt to set
	 */
	public void setTmpInt(int tmpInt) {
		this.tmpInt = tmpInt;
	}

	/**
	 * @param tmpCha the tmpCha to set
	 */
	public void setTmpCha(int tmpCha) {
		this.tmpCha = tmpCha;
	}
	
	/**
	 * @return the attacks
	 */
	public ArrayList<Attack> getAttacks() {
		return attacks;
	}

	/**
	 * @param attacks the attacks to set
	 */
	public void setAttacks(ArrayList<Attack> attacks) {
		this.attacks = attacks;
	}
	
	public int getHitDie() {
		return hitDie;
	}

	public void setHitDie(int hitDie) {
		this.hitDie = hitDie;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setBaseAttack(int[] baseAttack) {
		this.baseAttack = baseAttack;
	}

	/**
	 * 
	 * @param a: The attack to add to the array
	 */
	public void addAttack(Attack a)
	{
		attacks.add(a);
	}
	
	/*
	 * Calculate the amount of health to add to the character at the current level
	 */
	public int calcCurrentLevelHealth(int level)
	{
		int health=0;
		//If the character is at the first level 
		if(level==1)
		{
			health=hitDie+modCon;
		}
		else
		{//If the character is at any level other than first
			//instantiate a random number generator
			generator = new Random();
			//'roll the die' to determine the number of health to be added
			int roll = generator.nextInt(hitDie)+1;
			//Add the constitution to the roll
			health = roll + modCon;
			//The health added must be at least 1
			if (health<1)
				health=1;
		}
		
		return health;
	}
	
	/*
	 * Calculate the will, fortitude and reflex of the 
	 */
	public int calcSave(int baseSave, int statMod, int misc)
	{
		int r =0;
		
		r=baseSave + statMod + misc;
		
		return r;
	}
	
	/*
	 * Calculate the characters initiative
	 */
	public void calcInit()
	{
		//Formula: ModDex + Misc
		
		setInitiative(modDex);
	}

}
