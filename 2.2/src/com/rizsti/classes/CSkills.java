package com.rizsti.classes;


/**
 * 
 * @author Andrea Dewey
 * Last edited: January 31 2013
 * Monitors the ranks in each skill
 */
public class CSkills {
	
	//the name of the variable corresponds to the characters skill of the same name
	private int id=0;
	private int appraise=0;
	private int autohypnosis=0;
	private int balance=0;
	private int bluff=0;
	private int climb=0;
	private int controlShape=0;
	private int concentration=0;
	private int[] craftSkills;	
	private int decipherScript=0;
	private int diplomacy=0;
	private int disableDevice=0;
	private int disguise=0;
	private int escapseArtist=0;
	private int forgery=0;
	private int gatherInformation=0;
	private int handleAnimal=0;
	private int heal=0;
	private int hide=0;
	private int hypnosis=0;
	private int intimidate=0;
	private int jump=0;
	private int kArcana=0;
	private int kArchEng=0;
	private int kDungeoneering=0;
	private int kGeography=0;
	private int kHistory=0;
	private int kLocal=0;
	private int kMonsterLore=0;
	private int kNature=0;
	private int kNobility=0;
	private int kPsionics=0;
	private int kRavenloft=0;
	private int kReligion=0;
	private int kPlanes=0;
	private int[] knowledgeSkills;	
	private int listen=0;
	private int moveSilent=0;
	private int openLock=0;
	private int[] performSkills;		
	private int psicraft=0;
	private int ride=0;
	private int search=0;
	private int senseMotive=0;
	private int skillTricks=0;
	private int slieghtOfHand=0;
	private int speakLanguage=0;
	private int spellcraft=0;
	private int spot=0;
	private int survival=0;
	private int swim=0;
	private int tumble=0;
	private int useMagicDevice=0;
	private int usePsionicDevice=0;
	private int useRope=0;
	
	
	//*******  ********	**   **	 ****** ******** ******	 **   ** ******* ******** ******** ******   ******
	//**	   **    ** ***  ** **		   **	 **   ** **   ** **		    **	  **    ** **   ** **
	//**	   **    ** ** * **  *****	   **	 ******  **   ** **			**	  **    ** ******	*****
	//**       **    ** **  ***      **	   **	 **  **	 **   ** **			**    **    ** **  **		**
	//*******  ******** **   **  ***** 	   **	 **   ** ******* *******    **    ******** **   ** ******
	
	/**
	 * All args constructor
	 * @param id
	 * @param appraise
	 * @param autohypnosis
	 * @param balance
	 * @param bluff
	 * @param climb
	 * @param controlShape
	 * @param concentration
	 * @param craftSkills
	 * @param decipherScript
	 * @param diplomacy
	 * @param disableDevice
	 * @param disguise
	 * @param escapseArtist
	 * @param forgery
	 * @param gatherInformation
	 * @param handleAnimal
	 * @param heal
	 * @param hide
	 * @param hypnosis
	 * @param intimidate
	 * @param jump
	 * @param kArcana
	 * @param kArchEng
	 * @param kDungeoneering
	 * @param kGeography
	 * @param kHistory
	 * @param kLocal
	 * @param kMonsterLore
	 * @param kNature
	 * @param kNobility
	 * @param kPsionics
	 * @param kRavenloft
	 * @param kReligion
	 * @param kPlanes
	 * @param knowledgeSkills
	 * @param listen
	 * @param moveSilent
	 * @param openLock
	 * @param performSkills
	 * @param psicraft
	 * @param ride
	 * @param search
	 * @param senseMotive
	 * @param skillTricks
	 * @param slieghtOfHand
	 * @param speakLanguage
	 * @param spellcraft
	 * @param spot
	 * @param survival
	 * @param swim
	 * @param tumble
	 * @param useMagicDevice
	 * @param usePsionicDevice
	 * @param useRope
	 */
	public CSkills(int id,int appraise, int autohypnosis, int balance, int bluff,
			int climb, int controlShape, int concentration,
			int[] craftSkills, int decipherScript, int diplomacy,
			int disableDevice, int disguise, int escapseArtist, int forgery,
			int gatherInformation, int handleAnimal, int heal, int hide,
			int hypnosis, int intimidate, int jump, int kArcana, int kArchEng,
			int kDungeoneering, int kGeography, int kHistory, int kLocal,
			int kMonsterLore, int kNature, int kNobility, int kPsionics,
			int kRavenloft, int kReligion, int kPlanes,
			int[] knowledgeSkills, int listen, int moveSilent, int openLock,
			int[] performSkills, int psicraft, int ride, int search,
			int senseMotive, int skillTricks, int slieghtOfHand,
			int speakLanguage, int spellcraft, int spot, int survival,
			int swim, int tumble, int useMagicDevice, int usePsionicDevice,
			int useRope) {
		this.id = id;
		this.appraise = appraise;
		this.autohypnosis = autohypnosis;
		this.balance = balance;
		this.bluff = bluff;
		this.climb = climb;
		this.controlShape = controlShape;
		this.concentration = concentration;
		this.craftSkills = craftSkills;
		this.decipherScript = decipherScript;
		this.diplomacy = diplomacy;
		this.disableDevice = disableDevice;
		this.disguise = disguise;
		this.escapseArtist = escapseArtist;
		this.forgery = forgery;
		this.gatherInformation = gatherInformation;
		this.handleAnimal = handleAnimal;
		this.heal = heal;
		this.hide = hide;
		this.hypnosis = hypnosis;
		this.intimidate = intimidate;
		this.jump = jump;
		this.kArcana = kArcana;
		this.kArchEng = kArchEng;
		this.kDungeoneering = kDungeoneering;
		this.kGeography = kGeography;
		this.kHistory = kHistory;
		this.kLocal = kLocal;
		this.kMonsterLore = kMonsterLore;
		this.kNature = kNature;
		this.kNobility = kNobility;
		this.kPsionics = kPsionics;
		this.kRavenloft = kRavenloft;
		this.kReligion = kReligion;
		this.kPlanes = kPlanes;
		this.knowledgeSkills = knowledgeSkills;
		this.listen = listen;
		this.moveSilent = moveSilent;
		this.openLock = openLock;
		this.performSkills = performSkills;
		this.psicraft = psicraft;
		this.ride = ride;
		this.search = search;
		this.senseMotive = senseMotive;
		this.skillTricks = skillTricks;
		this.slieghtOfHand = slieghtOfHand;
		this.speakLanguage = speakLanguage;
		this.spellcraft = spellcraft;
		this.spot = spot;
		this.survival = survival;
		this.swim = swim;
		this.tumble = tumble;
		this.useMagicDevice = useMagicDevice;
		this.usePsionicDevice = usePsionicDevice;
		this.useRope = useRope;
	}


	/**
	 * Blank constructor
	 * Does nothing as variables are already set to 0
	 */
	public CSkills()
	{
		
	}
	
	//********  ********  ********	*********	********   ******    ******
	//**		**			 **		    **		**		   **   **  **
	//**  ****  ******		 **			**		*******    ****** 	 *****
	//**    **  **			 **			**		**		   **  ** 		 **
	//********  *********    **			**		*********  **   **   *****
	
	// ******   ********  ********	*********	********   ******    ******
	//**		**			 **		    **		**		   **   **  **
	// *****    ******		 **			**		*******    ****** 	 *****
	//      **  **			 **			**		**		   **  ** 		 **
	//*******   *********    **			**		*********  **   **   *****
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	public int getAppraise() {
		return appraise;
	}
	public void setAppraise(int appraise) {
		this.appraise = appraise;
	}
	public int getAutohypnosis() {
		return autohypnosis;
	}
	public void setAutohypnosis(int autohypnosis) {
		this.autohypnosis = autohypnosis;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getBluff() {
		return bluff;
	}
	public void setBluff(int bluff) {
		this.bluff = bluff;
	}
	public int getClimb() {
		return climb;
	}
	public void setClimb(int climb) {
		this.climb = climb;
	}
	public int getControlShape() {
		return controlShape;
	}
	public void setControlShape(int controlShape) {
		this.controlShape = controlShape;
	}
	public int getConcentration() {
		return concentration;
	}
	public void setConcentration(int concentration) {
		this.concentration = concentration;
	}
	public int[] getCraftSkills() {
		return craftSkills;
	}
	public void setCraftSkills(int[] craftSkills) {
		this.craftSkills = craftSkills;
	}
	public int getDecipherScript() {
		return decipherScript;
	}
	public void setDecipherScript(int decipherScript) {
		this.decipherScript = decipherScript;
	}
	public int getDiplomacy() {
		return diplomacy;
	}
	public void setDiplomacy(int diplomacy) {
		this.diplomacy = diplomacy;
	}
	public int getDisableDevice() {
		return disableDevice;
	}
	public void setDisableDevice(int disableDevice) {
		this.disableDevice = disableDevice;
	}
	public int getDisguise() {
		return disguise;
	}
	public void setDisguise(int disguise) {
		this.disguise = disguise;
	}
	public int getEscapseArtist() {
		return escapseArtist;
	}
	public void setEscapseArtist(int escapseArtist) {
		this.escapseArtist = escapseArtist;
	}
	public int getForgery() {
		return forgery;
	}
	public void setForgery(int forgery) {
		this.forgery = forgery;
	}
	public int getGatherInformation() {
		return gatherInformation;
	}
	public void setGatherInformation(int gatherInformation) {
		this.gatherInformation = gatherInformation;
	}
	public int getHandleAnimal() {
		return handleAnimal;
	}
	public void setHandleAnimal(int handleAnimal) {
		this.handleAnimal = handleAnimal;
	}
	public int getHeal() {
		return heal;
	}
	public void setHeal(int heal) {
		this.heal = heal;
	}
	public int getHide() {
		return hide;
	}
	public void setHide(int hide) {
		this.hide = hide;
	}
	public int getHypnosis() {
		return hypnosis;
	}
	public void setHypnosis(int hypnosis) {
		this.hypnosis = hypnosis;
	}
	public int getIntimidate() {
		return intimidate;
	}
	public void setIntimidate(int intimidate) {
		this.intimidate = intimidate;
	}
	public int getJump() {
		return jump;
	}
	public void setJump(int jump) {
		this.jump = jump;
	}
	public int getkArcana() {
		return kArcana;
	}
	public void setkArcana(int kArcana) {
		this.kArcana = kArcana;
	}
	public int getkArchEng() {
		return kArchEng;
	}
	public void setkArchEng(int kArchEng) {
		this.kArchEng = kArchEng;
	}
	public int getkDungeoneering() {
		return kDungeoneering;
	}
	public void setkDungeoneering(int kDungeoneering) {
		this.kDungeoneering = kDungeoneering;
	}
	public int getkGeography() {
		return kGeography;
	}
	public void setkGeography(int kGeography) {
		this.kGeography = kGeography;
	}
	public int getkHistory() {
		return kHistory;
	}
	public void setkHistory(int kHistory) {
		this.kHistory = kHistory;
	}
	public int getkLocal() {
		return kLocal;
	}
	public void setkLocal(int kLocal) {
		this.kLocal = kLocal;
	}
	public int getkMonsterLore() {
		return kMonsterLore;
	}
	public void setkMonsterLore(int kMonsterLore) {
		this.kMonsterLore = kMonsterLore;
	}
	public int getkNature() {
		return kNature;
	}
	public void setkNature(int kNature) {
		this.kNature = kNature;
	}
	public int getkNobility() {
		return kNobility;
	}
	public void setkNobility(int kNobility) {
		this.kNobility = kNobility;
	}
	public int getkPsionics() {
		return kPsionics;
	}
	public void setkPsionics(int kPsionics) {
		this.kPsionics = kPsionics;
	}
	public int getkRavenloft() {
		return kRavenloft;
	}
	public void setkRavenloft(int kRavenloft) {
		this.kRavenloft = kRavenloft;
	}
	public int getkReligion() {
		return kReligion;
	}
	public void setkReligion(int kReligion) {
		this.kReligion = kReligion;
	}
	public int getkPlanes() {
		return kPlanes;
	}
	public void setkPlanes(int kPlanes) {
		this.kPlanes = kPlanes;
	}
	public int[] getKnowledgeSkills() {
		return knowledgeSkills;
	}
	public void setKnowledgeSkills(int[] knowledgeSkills) {
		this.knowledgeSkills = knowledgeSkills;
	}
	public int getListen() {
		return listen;
	}
	public void setListen(int listen) {
		this.listen = listen;
	}
	public int getMoveSilent() {
		return moveSilent;
	}
	public void setMoveSilent(int moveSilent) {
		this.moveSilent = moveSilent;
	}
	public int getOpenLock() {
		return openLock;
	}
	public void setOpenLock(int openLock) {
		this.openLock = openLock;
	}
	public int[] getPerformSkills() {
		return performSkills;
	}
	public void setPerformSkills(int[] performSkills) {
		this.performSkills = performSkills;
	}
	public int getPsicraft() {
		return psicraft;
	}
	public void setPsicraft(int psicraft) {
		this.psicraft = psicraft;
	}
	public int getRide() {
		return ride;
	}
	public void setRide(int ride) {
		this.ride = ride;
	}
	public int getSearch() {
		return search;
	}
	public void setSearch(int search) {
		this.search = search;
	}
	public int getSenseMotive() {
		return senseMotive;
	}
	public void setSenseMotive(int senseMotive) {
		this.senseMotive = senseMotive;
	}
	public int getSkillTricks() {
		return skillTricks;
	}
	public void setSkillTricks(int skillTricks) {
		this.skillTricks = skillTricks;
	}
	public int getSlieghtOfHand() {
		return slieghtOfHand;
	}
	public void setSlieghtOfHand(int slieghtOfHand) {
		this.slieghtOfHand = slieghtOfHand;
	}
	public int getSpeakLanguage() {
		return speakLanguage;
	}
	public void setSpeakLanguage(int speakLanguage) {
		this.speakLanguage = speakLanguage;
	}
	public int getSpellcraft() {
		return spellcraft;
	}
	public void setSpellcraft(int spellcraft) {
		this.spellcraft = spellcraft;
	}
	public int getSpot() {
		return spot;
	}
	public void setSpot(int spot) {
		this.spot = spot;
	}
	public int getSurvival() {
		return survival;
	}
	public void setSurvival(int survival) {
		this.survival = survival;
	}
	public int getSwim() {
		return swim;
	}
	public void setSwim(int swim) {
		this.swim = swim;
	}
	public int getTumble() {
		return tumble;
	}
	public void setTumble(int tumble) {
		this.tumble = tumble;
	}
	public int getUseMagicDevice() {
		return useMagicDevice;
	}
	public void setUseMagicDevice(int useMagicDevice) {
		this.useMagicDevice = useMagicDevice;
	}
	public int getUsePsionicDevice() {
		return usePsionicDevice;
	}
	public void setUsePsionicDevice(int usePsionicDevice) {
		this.usePsionicDevice = usePsionicDevice;
	}
	public int getUseRope() {
		return useRope;
	}
	public void setUseRope(int useRope) {
		this.useRope = useRope;
	}

	public int[] getSkillsArray()
	{
		int r[] = {appraise, autohypnosis, balance, bluff, climb, concentration, controlShape, 0, decipherScript,
				diplomacy, disableDevice, disguise, escapseArtist, forgery, gatherInformation, handleAnimal, heal, hide, hypnosis,
				intimidate, jump, kArcana, kArchEng, kDungeoneering, kGeography, kHistory, kLocal, kMonsterLore,
				kNature, kNobility, kPsionics, kRavenloft, kReligion, kPlanes, 0, listen, moveSilent, openLock,
				0, psicraft, ride, search, senseMotive, skillTricks, slieghtOfHand,speakLanguage, spellcraft,
				spot, survival, swim, tumble, useMagicDevice, usePsionicDevice, useRope};
		return r;
	}
	

}
