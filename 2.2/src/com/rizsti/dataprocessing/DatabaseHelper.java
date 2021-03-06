package com.rizsti.dataprocessing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rizsti.classes.Attack;
import com.rizsti.classes.CSkills;
import com.rizsti.classes.Character;
import com.rizsti.classes.Item;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
		
	//Database name and version
	private final static String DATABASE_NAME	="Teddy";
	private final static int DATABASE_VERSION	=1;
	
	//Table names
	private final String TABLE_CHARACTERS	="Characters";
	private final String TABLE_STATS		="Stats";
	private final String TABLE_ITEMS		="Items";
	private final String TABLE_SKILLS		="Skills";
	private final String TABLE_ATTACKS		="Attacks";
	private final String TABLE_INVENTORY	="Inventory";
	
	//Data types
	private final String TYPE_INT 	= " INTEGER";
	private final String TYPE_TEXT 	= " TEXT";
	private final String C = ",";
	
	//Attributes
	private final String PK = " PRIMARY KEY";
	private final String NN = " NOT NULL";
	
	//Global Columns
	private final String COL_ID 	= "Id"; 	
	private final String COL_CHID	= "CharId";
	private final String COL_NAME 	= "Name";
	
	//Columns for the Characters table
	private final String COL_CRACE 		= "Race";
	private final String COL_CCLASS 	= "Class";
	private final String COL_CALIGN 	= "Align";
	private final String COL_CDEITY 	= "Deity";
	private final String COL_CEXP 		= "Experience";
	private final String COL_CINIT		= "Initiative";
	private final String COL_CCARCAP	= "CarryingCap";
	private final String COL_CBASEATK	= "BaseAttack";
	private final String COL_CGRAPPLE	= "Grapple";
	private final String COL_CGOLD		= "Gold";
	private final String COL_CLEVEL		= "Level";
	private final String COL_CAC		= "AC";
	private final String COL_CTOUCH		= "Touch";	
	private final String COL_CCHEALTH	= "CHealth";
	private final String COL_CTHEALTH	= "THealth";
	private final String COL_REF		= "Ref";
	private final String COL_FORT		= "Fort";
	private final String COL_WILL		= "Will";
	private final String COL_HITDIE		= "HitDie";
	
	//Attacks
	private final String COL_ARANGE		= "Range";
	private final String COL_AWEIGHT	= "Weight";
	private final String COL_ATYPE		= "Type";
	private final String COL_ASIZE		= "Size";
	private final String COL_ADAMAGE	= "Damage";
	private final String COL_ALOWCRIT	= "LCrit";
	private final String COL_AHIGHCRIT	= "HCrit";
	private final String COL_ABONUS		= "AtkBonus";
	private final String COL_SPECIAL	= "Special";
	
	//Columns for the Stats table
	private final String COL_SSTR	= "Str";
	private final String COL_STSTR	= "TmpStr";
	private final String COL_SWIS	= "Wis";
	private final String COL_STWIS	= "TmpWis";
	private final String COL_SCON	= "Con";
	private final String COL_STCON	= "TmpCon";
	private final String COL_SDEX	= "Dex";
	private final String COL_STDEX	= "TmpDex";
	private final String COL_SINT	= "Int";
	private final String COL_STINT	= "TmpInt";
	private final String COL_SCHA	= "Cha";
	private final String COL_STCHA	= "TmpCha";
	
	//Items
	private final String COL_IPRICE = "Price";
	private final String COL_IPOS	= "Position";
	private final String COL_IATTACK = "Attack";
	private final String COL_IDEFENSE= "Defense";
	private final String COL_IWEIGHT = "Weight";
	private final String COL_IENCHANT = "Enchantment";
	private final String COL_ICLASS = "Class";
	private final String COL_ITYPE = "Type";
	
	//Inventory
	private final String COL_IID = "ItemId";
	private final String COL_QUANTITY = "Quantity";
	
	//Skills
	private final String COL_APP	="Appraise";
	private final String COL_AUTO	="Autohypnosis";
	private final String COL_BAL	="Balance";
	private final String COL_BLUFF	="Bluff";
	private final String COL_CLIMB	="Climb";
	private final String COL_CONTS	="ControlShape";
	private final String COL_CONC	="Concentration";
	private final String COL_DEC	="DecipherScript";
	private final String COL_DIP	="Diplomacy";
	private final String COL_DISDEV ="DisableDevice";
	private final String COL_DISG	="Disguise";
	private final String COL_ESC	="EscapseArtist";
	private final String COL_FORG	="Forgery";
	private final String COL_GATINFO="GatherInformation"; 
	private final String COL_HANDLEAN="HandleAnimal";
	private final String COL_HEAL	="Heal";
	private final String COL_HIDE	="Hide";
	private final String COL_HYPNO	="Hypnosis";
	private final String COL_INTIM	="Intimidate";
	private final String COL_JUMP	="Jump";
	private final String COL_KARCA	="KnowldgeArcana";
	private final String COL_KARCH	="KnowledgeArchEng";
	private final String COL_KDUN	="KnowledgeDungeoneering"; 
	private final String COL_KGEO	="KnowledgeGeography"; 
	private final String COL_KHIST	="KnowledgeHistory";
	private final String COL_KLOC	="KnowledgeLocal";
	private final String COL_KMON	="KnowledgeMonsterLore";
	private final String COL_KNAT	="KnowledgeNature";
	private final String COL_KNOB	="KnowledgeNobility";
	private final String COL_KPSI	="KnowledgePsionics"; 
	private final String COL_KRAV	="KnowledgeRavenloft"; 
	private final String COL_KREL	="KnowledgeReligion"; 
	private final String COL_KPLA	="KnowledgePlanes";
	private final String COL_LIST	="Listen";
	private final String COL_MOVSIL	="MoveSilent";
	private final String COL_OPLOCK	="OpenLock"; 
	private final String COL_PSICR	="Psicraft";
	private final String COL_RIDE	="Ride";
	private final String COL_SEARCH	="Search";
	private final String COL_SENSMOT="SenseMotive";
	private final String COL_SKILTRIC="SkillTricks";
	private final String COL_SOH	="SleightOfHand";
	private final String COL_SPEAK	="SpeakLanguage";
	private final String COL_SPELLC	="Spellcraft";
	private final String COL_SPOT	="Spot";
	private final String COL_SURV	="Survival";
	private final String COL_SWIM	="Swim";
	private final String COL_TUMB	="Tumble";
	private final String COL_UMD	="UseMagicDevice";
	private final String COL_UPD	="UsePsionicDevice";
	private final String COL_USEROPE="UseRope";
	private final String COL_MAPP	="MAppraise";
	private final String COL_MAUTO	="MAutohypnosis";
	private final String COL_MBAL	="MBalance";
	private final String COL_MBLUFF	="MBluff";
	private final String COL_MCLIMB	="MClimb";
	private final String COL_MCONTS	="MControlShape";
	private final String COL_MCONC	="MConcentration";
	private final String COL_MDEC	="MDecipherScript";
	private final String COL_MDIP	="MDiplomacy";
	private final String COL_MDISDEV ="MDisableDevice";
	private final String COL_MDISG	="MDisguise";
	private final String COL_MESC	="MEscapseArtist";
	private final String COL_MFORG	="MForgery";
	private final String COL_MGATINFO="MGatherInformation"; 
	private final String COL_MHANDLEAN="MHandleAnimal";
	private final String COL_MHEAL	="MHeal";
	private final String COL_MHIDE	="MHide";
	private final String COL_MHYPNO	="MHypnosis";
	private final String COL_MINTIM	="MIntimidate";
	private final String COL_MJUMP	="MJump";
	private final String COL_MKARCA	="MKnowldgeArcana";
	private final String COL_MKARCH	="MKnowledgeArchEng";
	private final String COL_MKDUN	="MKnowledgeDungeoneering"; 
	private final String COL_MKGEO	="MKnowledgeGeography"; 
	private final String COL_MKHIST	="MKnowledgeHistory";
	private final String COL_MKLOC	="MKnowledgeLocal";
	private final String COL_MKMON	="MKnowledgeMonsterLore";
	private final String COL_MKNAT	="MKnowledgeNature";
	private final String COL_MKNOB	="MKnowledgeNobility";
	private final String COL_MKPSI	="MKnowledgePsionics"; 
	private final String COL_MKRAV	="MKnowledgeRavenloft"; 
	private final String COL_MKREL	="MKnowledgeReligion"; 
	private final String COL_MKPLA	="MKnowledgePlanes";
	private final String COL_MLIST	="MListen";
	private final String COL_MMOVSIL	="MMoveSilent";
	private final String COL_MOPLOCK	="MOpenLock"; 
	private final String COL_MPSICR	="MPsicraft";
	private final String COL_MRIDE	="MRide";
	private final String COL_MSEARCH	="MSearch";
	private final String COL_MSENSMOT="MSenseMotive";
	private final String COL_MSKILTRIC="MSkillTricks";
	private final String COL_MSOH	="MSleightOfHand";
	private final String COL_MSPEAK	="MSpeakLanguage";
	private final String COL_MSPELLC	="MSpellcraft";
	private final String COL_MSPOT	="MSpot";
	private final String COL_MSURV	="MSurvival";
	private final String COL_MSWIM	="MSwim";
	private final String COL_MTUMB	="MTumble";
	private final String COL_MUMD	="MUseMagicDevice";
	private final String COL_MUPD	="MUsePsionicDevice";
	private final String COL_MUSEROPE="MUseRope";
	
	//CREATION STATEMENTS
	private final String CREATE_CHARACTERS = 
			"CREATE TABLE " + TABLE_CHARACTERS + " (" +
					COL_ID 		+ TYPE_INT 	+ PK + 	C + 
					COL_NAME 	+ TYPE_TEXT + NN + 	C +
					COL_CRACE 	+ TYPE_TEXT + 		C + 
					COL_CALIGN 	+ TYPE_TEXT + 		C + 
					COL_CCLASS	+ TYPE_TEXT +		C +
					COL_CDEITY	+ TYPE_TEXT +		C +
					COL_CEXP	+ TYPE_INT	+		C +
					COL_CINIT	+ TYPE_INT  +		C +
					COL_CCARCAP + TYPE_INT  +		C +
					COL_WILL	+ TYPE_INT 	+		C +
					COL_REF		+ TYPE_INT	+		C +
					COL_FORT	+ TYPE_INT  +		C +
					COL_CBASEATK+ TYPE_INT	+		C +
					COL_CGRAPPLE+ TYPE_INT  + 		C +
					COL_CGOLD	+ TYPE_INT	+		C +
					COL_CLEVEL	+ TYPE_INT  +		C +
					COL_CAC		+ TYPE_INT  + 		C +
					COL_CTOUCH	+ TYPE_INT  + 		C +
					COL_CCHEALTH+ TYPE_INT 	+		C + 
					COL_CTHEALTH+ TYPE_INT  +		C +
					COL_HITDIE	+ TYPE_INT	+					
					");";
	
	private final String CREATE_STATS = 
			"CREATE TABLE " + TABLE_STATS + " (" +
					COL_ID		+ TYPE_INT + PK + 	C +
					COL_CHID	+ TYPE_INT + NN	+	C +
					COL_SSTR	+ TYPE_INT +		C +
					COL_STSTR	+ TYPE_INT + 		C +
					COL_SWIS	+ TYPE_INT +		C +
					COL_STWIS	+ TYPE_INT + 		C +
					COL_SCON	+ TYPE_INT +		C +
					COL_STCON	+ TYPE_INT +		C +
					COL_SCHA	+ TYPE_INT + 		C +
					COL_STCHA	+ TYPE_INT +		C +
					COL_SINT	+ TYPE_INT +		C +
					COL_STINT	+ TYPE_INT +		C +
					COL_SDEX	+ TYPE_INT +		C +
					COL_STDEX   + TYPE_INT +		C +
					"FOREIGN KEY("+COL_CHID+") REFERENCES "+ TABLE_CHARACTERS+"("+COL_ID+"));";
	
	private final String CREATE_ATTACKS = 
			"CREATE TABLE " + TABLE_ATTACKS + " (" +
					COL_ID		+ TYPE_INT + PK	+	C +
					COL_CHID	+ TYPE_INT + NN	+	C +
					COL_NAME	+ TYPE_TEXT + 		C +
					COL_ARANGE	+ TYPE_TEXT +		C +
					COL_AWEIGHT + TYPE_TEXT +		C +
					COL_ATYPE	+ TYPE_TEXT +		C +
					COL_ASIZE	+ TYPE_TEXT +		C +
					COL_ADAMAGE + TYPE_INT 	+		C +
					COL_ALOWCRIT+ TYPE_INT 	+ 		C +
					COL_AHIGHCRIT+TYPE_INT	+		C +
					COL_ABONUS	+ TYPE_INT	+		C +
					COL_SPECIAL + TYPE_TEXT + 		C +
					"FOREIGN KEY("+COL_CHID+") REFERENCES " + TABLE_CHARACTERS+"("+COL_ID+"));";
	
	private final String CREATE_ITEMS = 
			"CREATE TABLE " + TABLE_ITEMS + " (" +
					COL_ID		+ TYPE_INT 	+ PK +	C +
					COL_NAME	+ TYPE_TEXT + 		C +
					COL_IPRICE	+ TYPE_INT 	+ 		C +
					COL_IPOS	+ TYPE_TEXT + 		C +
					COL_IATTACK + TYPE_INT	+		C +
					COL_IDEFENSE+ TYPE_INT	+		C +
					COL_IWEIGHT	+ TYPE_INT	+		C +
					COL_IENCHANT+ TYPE_TEXT +		C +
					COL_ICLASS	+ TYPE_TEXT +		C +
					COL_ITYPE	+ TYPE_TEXT	+	
					");";
	
	private final String CREATE_INVENTORY = 
			"CREATE TABLE " + TABLE_INVENTORY + " (" +
					COL_IID		+ TYPE_INT		+	C +
					COL_CHID	+ TYPE_INT		+ 	C +
					COL_QUANTITY+ TYPE_INT		+	C +
					"PRIMARY KEY ("+COL_IID+C+COL_CHID+")" +C+
					"FOREIGN KEY("+COL_IID+") REFERENCES " + TABLE_ITEMS+"("+COL_ID+")"+C+
					"FOREIGN KEY("+COL_CHID+") REFERENCES "+TABLE_CHARACTERS+"("+COL_ID+"));";
	
	private final String CREATE_SKILLS =
			"CREATE TABLE " + TABLE_SKILLS + " (" +
					COL_ID		+ TYPE_INT	+ PK	+ C +
					COL_CHID	+ TYPE_INT	+ NN	+ C +
					COL_APP		+ TYPE_INT 			+ C +
					COL_MAPP	+ TYPE_INT 			+ C +
					COL_AUTO	+ TYPE_INT 			+ C +
					COL_MAUTO	+ TYPE_INT 			+ C +
					COL_BAL		+ TYPE_INT 			+ C +
					COL_MBAL	+ TYPE_INT 			+ C +
					COL_BLUFF	+ TYPE_INT 			+ C +
					COL_MBLUFF	+ TYPE_INT 			+ C +
					COL_CLIMB	+ TYPE_INT 			+ C +
					COL_MCLIMB	+ TYPE_INT 			+ C +
					COL_CONTS	+ TYPE_INT 			+ C +
					COL_MCONTS	+ TYPE_INT 			+ C +
					COL_CONC	+ TYPE_INT 			+ C +
					COL_MCONC	+ TYPE_INT 			+ C +
					COL_DEC		+ TYPE_INT 			+ C +
					COL_MDEC	+ TYPE_INT 			+ C +
					COL_DIP		+ TYPE_INT 			+ C +
					COL_MDIP	+ TYPE_INT 			+ C +
					COL_DISDEV	+ TYPE_INT 			+ C +
					COL_MDISDEV	+ TYPE_INT 			+ C +
					COL_DISG	+ TYPE_INT 			+ C +
					COL_MDISG	+ TYPE_INT 			+ C +
					COL_ESC		+ TYPE_INT 			+ C +
					COL_MESC	+ TYPE_INT 			+ C +
					COL_FORG	+ TYPE_INT 			+ C +
					COL_MFORG	+ TYPE_INT 			+ C +
					COL_GATINFO	+ TYPE_INT 			+ C +
					COL_MGATINFO+ TYPE_INT 			+ C +
					COL_HANDLEAN+ TYPE_INT 			+ C +
					COL_MHANDLEAN+ TYPE_INT 		+ C +
					COL_HEAL	+ TYPE_INT 			+ C +
					COL_MHEAL	+ TYPE_INT 			+ C +
					COL_HIDE	+ TYPE_INT 			+ C +
					COL_MHIDE	+ TYPE_INT 			+ C +
					COL_HYPNO	+ TYPE_INT 			+ C +
					COL_MHYPNO	+ TYPE_INT 			+ C +
					COL_INTIM	+ TYPE_INT 			+ C +
					COL_MINTIM	+ TYPE_INT 			+ C +
					COL_JUMP	+ TYPE_INT 			+ C +
					COL_MJUMP	+ TYPE_INT 			+ C +
					COL_KARCA	+ TYPE_INT 			+ C +
					COL_MKARCA	+ TYPE_INT 			+ C +
					COL_KARCH	+ TYPE_INT 			+ C +
					COL_MKARCH	+ TYPE_INT 			+ C +
					COL_KDUN	+ TYPE_INT 			+ C +
					COL_MKDUN	+ TYPE_INT 			+ C +
					COL_KGEO	+ TYPE_INT 			+ C +
					COL_MKGEO	+ TYPE_INT 			+ C +
					COL_KHIST	+ TYPE_INT 			+ C +
					COL_MKHIST	+ TYPE_INT 			+ C +
					COL_KLOC	+ TYPE_INT 			+ C +
					COL_MKLOC	+ TYPE_INT 			+ C +
					COL_KMON	+ TYPE_INT 			+ C +
					COL_MKMON	+ TYPE_INT 			+ C +
					COL_KNAT	+ TYPE_INT 			+ C +
					COL_MKNAT	+ TYPE_INT 			+ C +
					COL_KNOB	+ TYPE_INT 			+ C +
					COL_MKNOB	+ TYPE_INT 			+ C +
					COL_KPSI	+ TYPE_INT 			+ C +
					COL_MKPSI	+ TYPE_INT 			+ C +
					COL_KRAV	+ TYPE_INT 			+ C +
					COL_MKRAV	+ TYPE_INT 			+ C +
					COL_KREL	+ TYPE_INT 			+ C +
					COL_MKREL	+ TYPE_INT 			+ C +
					COL_KPLA	+ TYPE_INT 			+ C +
					COL_MKPLA	+ TYPE_INT 			+ C +
					COL_LIST	+ TYPE_INT 			+ C +
					COL_MLIST	+ TYPE_INT 			+ C +
					COL_MOVSIL	+ TYPE_INT 			+ C +
					COL_MMOVSIL + TYPE_INT 			+ C +
					COL_OPLOCK	+ TYPE_INT 			+ C +
					COL_MOPLOCK	+ TYPE_INT 			+ C +
					COL_PSICR	+ TYPE_INT 			+ C +
					COL_MPSICR	+ TYPE_INT 			+ C +
					COL_RIDE	+ TYPE_INT 			+ C +
					COL_MRIDE	+ TYPE_INT 			+ C +
					COL_SEARCH 	+ TYPE_INT 			+ C +
					COL_MSEARCH + TYPE_INT 			+ C +
					COL_SENSMOT	+ TYPE_INT 			+ C +
					COL_MSENSMOT+ TYPE_INT 			+ C +
					COL_SKILTRIC+ TYPE_INT 			+ C +
					COL_MSKILTRIC+ TYPE_INT 		+ C +
					COL_SOH		+ TYPE_INT 			+ C +
					COL_MSOH	+ TYPE_INT 			+ C +
					COL_SPEAK	+ TYPE_INT 			+ C +
					COL_MSPEAK	+ TYPE_INT 			+ C +
					COL_SPELLC	+ TYPE_INT 			+ C +
					COL_MSPELLC + TYPE_INT 			+ C +
					COL_SPOT	+ TYPE_INT 			+ C +
					COL_MSPOT	+ TYPE_INT 			+ C +
					COL_SURV	+ TYPE_INT 			+ C +
					COL_MSURV	+ TYPE_INT 			+ C +
					COL_SWIM	+ TYPE_INT 			+ C +
					COL_MSWIM	+ TYPE_INT 			+ C +
					COL_TUMB	+ TYPE_INT 			+ C +
					COL_MTUMB	+ TYPE_INT 			+ C +
					COL_UMD		+ TYPE_INT 			+ C +
					COL_MUMD	+ TYPE_INT 			+ C +
					COL_UPD		+ TYPE_INT 			+ C +
					COL_MUPD	+ TYPE_INT 			+ C +
					COL_USEROPE	+ TYPE_INT 			+ C +
					COL_MUSEROPE+ TYPE_INT 			+ C +
					"FOREIGN KEY("+COL_CHID+") REFERENCES "+TABLE_CHARACTERS+"("+COL_ID+"));";
	
	
	//Drop table statement
	private final String DROP_CHAR 	= "DROP TABLE IF EXISTS " + TABLE_CHARACTERS;
	private final String DROP_ITEM 	= "DROP TABLE IF EXISTS " + TABLE_ITEMS;		
	private final String DROP_INV  	= "DROP TABLE IF EXISTS " + TABLE_INVENTORY;
	private final String DROP_STATS = "DROP TABLE IF EXISTS " + TABLE_STATS;
	private final String DROP_ATTACK= "DROP TABLE IF EXISTS " + TABLE_ATTACKS;
	private final String DROP_SKILLS= "DROP TABLE IF EXISTS " + TABLE_SKILLS;

		public DatabaseHelper(Context context)
		{
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}
		
		/*
		 * Create the Tables
		 * (non-Javadoc)
		 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
		 */
		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(CREATE_CHARACTERS);
			db.execSQL(CREATE_ATTACKS);
			db.execSQL(CREATE_ITEMS);
			db.execSQL(CREATE_INVENTORY);
			db.execSQL(CREATE_STATS);
			db.execSQL(CREATE_SKILLS);
			
		}

		/*
		 * Drop and re-add the tables
		 * (non-Javadoc)
		 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
		 */
		@Override
		public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
			db.execSQL(DROP_INV);
			db.execSQL(DROP_STATS);
			db.execSQL(DROP_ATTACK);
			db.execSQL(DROP_ITEM);
			db.execSQL(DROP_CHAR);
			db.execSQL(DROP_SKILLS);
			onCreate(db);	
		}
		
		
		
		
//		   ___   ___                                                           
//		      / /    /|    / / //   ) )  //   / /  //   ) ) /__  ___/ //   ) ) 
//		     / /    //|   / / ((        //____    //___/ /    / /    ((        
//		    / /    // |  / /    \\     / ____    / ___ (     / /       \\      
//		   / /    //  | / /       ) ) //        //   | |    / /          ) )   
//		__/ /___ //   |/ / ((___ / / //____/ / //    | |   / /    ((___ / /  
		
		/*
		 * Create a new character and all other necessary elements
		 */
		public Character createCharacter(Character c)
		{
			//get a writable database
			SQLiteDatabase db = getWritableDatabase();
			
			//create the content values to insert
			ContentValues insertValues = createCharacterCV(c);
						
			//insert the character values
			c.setId((int)db.insert(TABLE_CHARACTERS, null, insertValues));
			
			
			//reset the contentvalues
			insertValues = createStatsCV(c);
			
			//insert the values
			db.insert(TABLE_STATS, null, insertValues);
			
			
			//Get the arraylist of attacks
			ArrayList<Attack> attacks = c.getAttacks();
			if (!(attacks==null)){
				//Insert the character's attacks
				for (int i=0; i<attacks.size();i++)
				{
					//The attack for the current position in the arraylist
					Attack a = attacks.get(i);
					
					//reset the Content Values
					insertValues= createAttackCV(c, a);
					
					//insert the values
					a.setId((int)db.insert(TABLE_ATTACKS, null, insertValues));
					
				}
			}
			
			//TODO: Add the code to prevent duplicate items in the database
			//get the arraylist of items
			ArrayList<Item> items = c.getInventory();
			if (!(items==null))
			{
				//inset the characters items and populate the inventory
				for (int i=0; i<items.size(); i++)
				{
					//The item for the current position in the arraylist
					Item it = items.get(i);
					
					//reset the content values
					insertValues = createItemCV(it);
					
					//insert the item into the database
					it.setItemId((int)db.insert(TABLE_ITEMS, null, insertValues));
					
					//reset the content values
					insertValues = new ContentValues();
					//Add the data
					insertValues.put(COL_IID, it.getItemId());
					insertValues.put(COL_CHID, c.getId());
					insertValues.put(COL_QUANTITY, it.getQuantity());
					//insert the data
					db.insert(TABLE_INVENTORY, null, insertValues);
					
				}
			}
			
			//insert the skills
			//reset the content values
			insertValues = createSkillsCV(c);
			//insert the values
			db.insert(TABLE_SKILLS, null, insertValues);
			
			//Close the database 
			db.close();
			
			return c;
			
		}
		
		
		/*
		 * Update the character in the database
		 */
		public Character updateCharacter(Character c)
		{
			//get a writable database
			SQLiteDatabase db = getWritableDatabase();
			
			//create the content values to insert
			ContentValues insertValues = createCharacterCV(c);
						
			//Update the character table
			db.update(TABLE_CHARACTERS, insertValues, COL_ID+"="+c.getId(), null);
			
			
			//reset the contentvalues
			insertValues = createStatsCV(c);
			
			//update the stats table
			db.update(TABLE_STATS, insertValues, COL_CHID+"="+c.getId(),null);
			
			
			//Get the arraylist of attacks
			ArrayList<Attack> attacks = c.getAttacks();
			//make sure the attacks array list is not null
			if (!(attacks==null)){
				//Insert or update the character's attacks
				for (int i=0; i<attacks.size();i++)
				{
					//The attack for the current position in the arraylist
					Attack a = attacks.get(i);
					
					//reset the Content Values
					insertValues= createAttackCV(c, a);
					
					if (a.getId()==null||a.getId()==0)
					{
						//insert the values
						db.insert(TABLE_ATTACKS, null, insertValues);
					}
					else
					{
						//update the attack
						db.update(TABLE_ATTACKS, insertValues, COL_ID+"="+a.getId(), null);
					}
					
				}
			}
			
			//TODO: Add the code to prevent duplicate items in the database
			//get the arraylist of items
			ArrayList<Item> items = c.getInventory();
			if (!(items==null))
			{
				//inset the characters items and populate the inventory
				for (int i=0; i<items.size(); i++)
				{
					//The item for the current position in the arraylist
					Item it = items.get(i);
					
					//reset the content values
					insertValues = createItemCV(it);
					
					//If the item doesn't already exist
					if (it.getItemId()==null)
					{
						//insert the item into the database
						it.setItemId((int)db.insert(TABLE_ITEMS, null, insertValues));
						
						//reset the content values
						insertValues = new ContentValues();
						//Add the data
						insertValues.put(COL_IID, it.getItemId());
						insertValues.put(COL_CHID, c.getId());
						insertValues.put(COL_QUANTITY,it.getQuantity());
						//insert the data
						db.insert(TABLE_INVENTORY, null, insertValues);
					}else //If the item already exists
					{
						//update the existing data in the items table
						db.update(TABLE_ITEMS,insertValues,COL_ID+"="+it.getItemId(),null);
						//update the data in the inventory table
						insertValues.put(COL_QUANTITY,it.getQuantity());
						db.update(TABLE_INVENTORY, insertValues, COL_IID+"="+it.getItemId(), null);
					}
					
					
				}
			}
			
			//insert the skills
			//reset the content values
			insertValues = createSkillsCV(c);
			//update skills table
			db.update(TABLE_SKILLS, insertValues, COL_CHID+"="+c.getId(), null);
			
			//Close the database 
			db.close();
			
			return c;
		}
		
		
//	    	//   ) )  //   / /  / /        //   / /  //   ) ) /__  ___/ //   ) ) 
//		   ((        //____    / /        //____    //          / /    ((        
//		     \\     / ____    / /        / ____    //          / /       \\      
//		       ) ) //        / /        //        //          / /          ) )   
//		((___ / / //____/ / / /____/ / //____/ / ((____/ /   / /    ((___ / /

		/*
		 * Retrieve the character data for the select character list view
		 */
		public List<Map<String,String>> getCharsForSelect()
		{
			//the List to return
			List<Map<String,String>> lm = new ArrayList<Map<String,String>>();
			
			//The columns you will be selecting
			String selection[] = {COL_ID, COL_NAME, COL_CCLASS, COL_CLEVEL};
			
			//The readable database
			SQLiteDatabase db = getReadableDatabase();
			
			//The cursor containing the information
			Cursor c = db.query(TABLE_CHARACTERS,	//The name of the table to query
					selection,				//The columns to return
					null,					//The column for the where clause
					null,					//The values for the where clause
					null,					//Group the rows
					null,					//Filter the row groups
					null);					//The sort order
			
			//Move to the first returned row
			c.moveToFirst();
			for (int i=0; i<c.getCount(); i++)
			{
				Map<String,String> map = new HashMap<String,String>();
				//assign the values
				map.put("Id", String.valueOf(c.getInt(0)));
				map.put("Name", c.getString(1));
				map.put("Class", c.getString(2));
				map.put("Level", String.valueOf(c.getInt(3)));
				
				//Add the hasmap to the list
				lm.add(map);
				//move to the next row
				c.moveToNext();
			}
			//close the cursor and database
			c.close();
			db.close();
			//return the listmap
			return lm;
		}
		
		/*
		 * Load a character from the database based on the character id passed in
		 */
		public Character loadCharacter(int id)
		{
			//the Character to return
			Character ch=new Character();
			//The columns you will be selecting
			String cSelection[] = {COL_ID,COL_NAME,COL_CRACE,COL_CALIGN,COL_CCLASS,COL_CDEITY,
					COL_CEXP,COL_CINIT,COL_CCARCAP,COL_WILL,COL_REF,COL_FORT,COL_CBASEATK,
					COL_CGRAPPLE,COL_CGOLD,COL_CLEVEL,COL_CAC,COL_CTOUCH,COL_CCHEALTH,COL_CTHEALTH,COL_HITDIE};
			String stSelection[] = {COL_ID,COL_SSTR,COL_STSTR,COL_SWIS,COL_STWIS,COL_SCON,COL_STCON,
					COL_SCHA,COL_STCHA,COL_SINT,COL_STINT,COL_SDEX,COL_STDEX};
			String skSelection[] = {COL_ID,COL_CHID,COL_APP,COL_MAPP,COL_AUTO,COL_MAUTO,COL_BAL,
			COL_MBAL,COL_BLUFF,COL_MBLUFF,COL_CLIMB,COL_MCLIMB,COL_CONTS,COL_MCONTS,COL_CONC,
			COL_MCONC,COL_DEC,COL_MDEC,COL_DIP,COL_MDIP,COL_DISDEV,COL_MDISDEV,COL_DISG,COL_MDISG,
			COL_ESC,COL_MESC,COL_FORG,COL_MFORG,COL_GATINFO,COL_MGATINFO,COL_HANDLEAN,COL_MHANDLEAN,
			COL_HEAL,COL_MHEAL,COL_HIDE,COL_MHIDE,COL_HYPNO,COL_MHYPNO,COL_INTIM,COL_MINTIM,
			COL_JUMP,COL_MJUMP,COL_KARCA,COL_MKARCA,COL_KARCH,COL_MKARCH,COL_KDUN,COL_MKDUN,COL_KGEO,
			COL_MKGEO,COL_KHIST,COL_MKHIST,COL_KLOC,COL_MKLOC,COL_KMON,COL_MKMON,COL_KNAT,COL_MKNAT,
			COL_KNOB,COL_MKNOB,COL_KPSI,COL_MKPSI,COL_KRAV,COL_MKRAV,COL_KREL,COL_MKREL,COL_KPLA,
			COL_MKPLA,COL_LIST,COL_MLIST,COL_MOVSIL,COL_MMOVSIL,COL_OPLOCK,COL_MOPLOCK,COL_PSICR,
			COL_MPSICR,COL_RIDE,COL_MRIDE,COL_SEARCH,COL_MSEARCH,COL_SENSMOT,COL_MSENSMOT,
			COL_SKILTRIC,COL_MSKILTRIC,COL_SOH,COL_MSOH,COL_SPEAK,COL_MSPEAK,COL_SPELLC,COL_MSPELLC,
			COL_SPOT,COL_MSPOT,COL_SURV,COL_MSURV,COL_SWIM,COL_MSWIM,COL_TUMB,COL_MTUMB,COL_UMD,COL_MUMD,
			COL_UPD,COL_MUPD,COL_USEROPE,COL_MUSEROPE};
			
			String invSelection[]={COL_IID, COL_CHID, COL_QUANTITY};
			
			String itSelection[] ={COL_ID,COL_NAME,COL_IPRICE,COL_IPOS,COL_IATTACK,COL_IDEFENSE,COL_IWEIGHT,COL_IENCHANT,COL_ICLASS,COL_ITYPE};
			
			String aSelection[]  ={COL_ID,COL_NAME,COL_ARANGE,COL_AWEIGHT,COL_ATYPE,COL_ASIZE,COL_ADAMAGE,
					COL_ALOWCRIT,COL_AHIGHCRIT,COL_ABONUS, COL_SPECIAL};
			//The readable database
			SQLiteDatabase db = getReadableDatabase();
			
			//The cursor containing the information from the characters table
			Cursor c = db.query(TABLE_CHARACTERS,	//The name of the table to query
					cSelection,				//The columns to return
					COL_ID+'='+id,					//the where clause
					null,
					null,					//Group the rows
					null,					//Filter the row groups
					null);					//The sort order
			//Populate the character
			c.moveToFirst();
			ch.setId(id);
			ch.setName(c.getString(1));
			ch.setRace(c.getString(2));
			ch.setAlignment(c.getString(3));
			ch.setClasss(c.getString(4));
			ch.setDeity(c.getString(5));
			ch.setExperience(c.getInt(6));
			ch.setInitiative(c.getInt(7));
			ch.setCarryingCapacity(c.getDouble(8));
			ch.setWill(c.getInt(9));
			ch.setReflex(c.getInt(10));
			ch.setFortitude(c.getInt(11));
			ch.setBaseAttack(c.getInt(12));
			ch.setGrapple(c.getInt(13));
			ch.setGold(c.getInt(14));
			ch.setLevel(c.getInt(15));
			ch.setAc(c.getInt(16));
			ch.setTouch(c.getInt(17));
			ch.setcHealth(c.getInt(18));
			ch.settHealth(c.getInt(19));
			ch.setHitDie(c.getInt(20));
			//Close the character cursor
			c.close();
			
			Cursor st = db.query(TABLE_STATS,	//The name of the table to query
					stSelection,				//The columns to return
					COL_CHID +'='+id,					//The column for the where clause
					null,					
					null,					//Group the rows
					null,					//Filter the row groups
					null);					//The sort order
			st.moveToFirst();
			//populate the character
			ch.setStrength(st.getInt(1));
			ch.setTmpStr(st.getInt(2));
			ch.setWisdom(st.getInt(3));
			ch.setTmpWis(st.getInt(4));
			ch.setConstitution(st.getInt(5));
			ch.setTmpCon(st.getInt(6));
			ch.setCharisma(st.getInt(7));
			ch.setTmpCha(st.getInt(8));
			ch.setIntelligence(st.getInt(9));
			ch.setTmpInt(st.getInt(10));
			ch.setDexterity(st.getInt(11));
			ch.setTmpDex(st.getInt(12));
			//close the cursor
			st.close();
			
			Cursor sk = db.query(TABLE_SKILLS,	//The name of the table to query
					skSelection,				//The columns to return
					COL_CHID +'='+id,					//The column for the where clause
					null,							//The values for the where clause
					null,					//Group the rows
					null,					//Filter the row groups
					null);					//The sort order
			
			if(sk.getCount()>0){
				
				//move to the first row (There should only be one)
				sk.moveToFirst();
				//Create the misc skills item
				CSkills ms = new CSkills(sk.getInt(0), sk.getInt(3),sk.getInt(5),sk.getInt(7),sk.getInt(9),
						sk.getInt(11),sk.getInt(13),sk.getInt(15),null,sk.getInt(17),sk.getInt(19),sk.getInt(21),sk.getInt(23),
						sk.getInt(25), sk.getInt(27), sk.getInt(29),sk.getInt(31),sk.getInt(33),sk.getInt(35),sk.getInt(37),
						sk.getInt(39),sk.getInt(41),sk.getInt(43),sk.getInt(45),sk.getInt(47),sk.getInt(49),sk.getInt(51),
						sk.getInt(53),sk.getInt(55), sk.getInt(57),sk.getInt(59),sk.getInt(61),sk.getInt(63),sk.getInt(65),
						sk.getInt(67),null,sk.getInt(69),sk.getInt(71), sk.getInt(73), null,sk.getInt(75),sk.getInt(77), 
						sk.getInt(79),sk.getInt(81),sk.getInt(83),sk.getInt(85), sk.getInt(87),sk.getInt(89),sk.getInt(91),
						sk.getInt(93),sk.getInt(95),sk.getInt(97),sk.getInt(99),sk.getInt(101), sk.getInt(103));
				
				//create the ranks skill items
				CSkills rs = new CSkills(sk.getInt(0), sk.getInt(2),sk.getInt(4),sk.getInt(6),sk.getInt(8),
						sk.getInt(10),sk.getInt(12),sk.getInt(14),null,sk.getInt(16),sk.getInt(18),sk.getInt(20),sk.getInt(22),
						sk.getInt(24), sk.getInt(26), sk.getInt(28),sk.getInt(30),sk.getInt(32),sk.getInt(34),sk.getInt(36),
						sk.getInt(38),sk.getInt(40),sk.getInt(42),sk.getInt(44),sk.getInt(46),sk.getInt(48),sk.getInt(50),
						sk.getInt(52),sk.getInt(54), sk.getInt(56),sk.getInt(58),sk.getInt(60),sk.getInt(62),sk.getInt(64),
						sk.getInt(66),null,sk.getInt(68),sk.getInt(70), sk.getInt(72), null,sk.getInt(74),sk.getInt(76), 
						sk.getInt(78),sk.getInt(80),sk.getInt(82),sk.getInt(84), sk.getInt(86),sk.getInt(88),sk.getInt(90),
						sk.getInt(92),sk.getInt(94),sk.getInt(96),sk.getInt(98),sk.getInt(100), sk.getInt(102));

				//Set the ranks
				ch.setSkillRanks(rs);
				ch.setSkillsMisc(ms);
			}
			//close the skills cursor
			sk.close();
			
			Cursor inv = db.query(TABLE_INVENTORY,	//The name of the table to query
					invSelection,				//The columns to return
					COL_CHID +'='+id,					//The column for the where clause
					null,							//The values for the where clause
					null,					//Group the rows
					null,					//Filter the row groups
					null);					//The sort order
			
			//an array of item ids associated with the character
			String itIds[]=new String[inv.getCount()];
			//Make sure columns have been returned
			if (inv.getCount()>0){
				//move to the first inventory item
				inv.moveToFirst();
				//populate the itemIds
				for(int i=0; i<inv.getCount(); i++)
				{
					itIds[i]=String.valueOf(inv.getInt(i));
					inv.moveToNext();
				}
				inv.close();
				Cursor it = db.query(TABLE_ITEMS,	//The name of the table to query
						itSelection,				//The columns to return
						COL_CHID +'='+id,					//The column for the where clause
						null,							//The values for the where clause
						null,					//Group the rows
						null,					//Filter the row groups
						null);					//The sort order
				ArrayList<Item> items = new ArrayList<Item>();
				it.moveToFirst();
				for (int i=0; i<it.getCount(); i++)
				{
					//Create the item
					Item j = new Item(it.getInt(0),it.getInt(4), it.getInt(5), inv.getInt(2), it.getString(1), 
							it.getString(3), it.getInt(2), it.getInt(6), it.getString(7), it.getString(8),
							it.getString(9));
					//Add it to the inventory array
					items.add(j);
					it.moveToNext();
				}
				
				it.close();
				ch.setInventory(items);
				}
			inv.close();
			Cursor a = db.query(TABLE_ATTACKS,	//The name of the table to query
					aSelection,				//The columns to return
					COL_CHID +'='+id,					//The column for the where clause
					null,							//The values for the where clause
					null,					//Group the rows
					null,					//Filter the row groups
					null);					//The sort order
			
			if (a.getCount()>0)
			{
			//Create the attacks arraylist
			a.moveToFirst();
			ArrayList<Attack> attacks = new ArrayList<Attack>();
			
			for (int i=0; i<a.getCount();i++)
			{
				attacks.add(new Attack(a.getString(1),a.getString(4),a.getString(5),a.getInt(0),a.getString(2),a.getString(3),
						a.getString(6),a.getInt(7),a.getInt(8),a.getInt(9), a.getString(10)));
				a.moveToNext();
			}
			
			ch.setAttacks(attacks);
			}
			a.close();
			db.close();
			
			
			//return the character
			return ch;
		}
		
		/*
		 * A method that returns a contentValues object populated with character information based off of the 
		 * character passed in
		 */
		public ContentValues createCharacterCV(Character c)
		{
			ContentValues insertValues = new ContentValues();
			//Add the data to the content values
			insertValues.put(COL_NAME, c.getName());
			insertValues.put(COL_CRACE, c.getRace());
			insertValues.put(COL_CCLASS, c.getClasss());
			insertValues.put(COL_CALIGN, c.getAlignment());
			insertValues.put(COL_CDEITY, c.getDeity());
			insertValues.put(COL_CEXP, c.getExperience());
			insertValues.put(COL_CINIT, c.getInitiative());
			insertValues.put(COL_CCARCAP, c.getCarryingCapacity());
			insertValues.put(COL_CBASEATK, Integer.valueOf(c.getBaseAttack()[0]));
			insertValues.put(COL_CGRAPPLE, c.getGrapple());
			insertValues.put(COL_CGOLD, c.getGold());
			insertValues.put(COL_CLEVEL, c.getLevel());
			insertValues.put(COL_CAC, c.getAc());
			insertValues.put(COL_CTOUCH, c.getTouch());
			insertValues.put(COL_CCHEALTH, c.getcHealth());
			insertValues.put(COL_CTHEALTH, c.gettHealth());
			insertValues.put(COL_REF, c.getReflex());
			insertValues.put(COL_FORT, c.getFortitude());
			insertValues.put(COL_WILL, c.getWill());
			insertValues.put(COL_HITDIE,c.getHitDie());
			
			return insertValues;
		}
		
		/*
		 * A method that returns a contentValues object populated with stats information based off of
		 * the character passed in
		 */
		public ContentValues createStatsCV(Character c)
		{
			ContentValues insertValues = new ContentValues();
			//insert the characters stats
			insertValues.put(COL_CHID, c.getId());
			insertValues.put(COL_SSTR, c.getStrength());
			insertValues.put(COL_SWIS, c.getWisdom());
			insertValues.put(COL_SDEX, c.getDexterity());
			insertValues.put(COL_SCON, c.getConstitution());
			insertValues.put(COL_SCHA, c.getCharisma());
			insertValues.put(COL_SINT, c.getIntelligence());
			insertValues.put(COL_STSTR, c.getTmpStr());
			insertValues.put(COL_STWIS, c.getTmpWis());
			insertValues.put(COL_STDEX, c.getTmpDex());
			insertValues.put(COL_STCON, c.getTmpCon());
			insertValues.put(COL_STCHA, c.getTmpCha());
			insertValues.put(COL_STINT, c.getTmpInt());
			
			return insertValues;
		}
		
		/*
		 * A method that returns a ContentValues object populated with Attack information bassed off of the character and attack
		 * objects passed in
		 */
		public ContentValues createAttackCV(Character c, Attack a)
		{
			ContentValues insertValues= new ContentValues();
			
			//add the data to be inserted
			insertValues.put(COL_CHID, c.getId());
			insertValues.put(COL_NAME, a.getName());
			insertValues.put(COL_ARANGE, a.getRange());
			insertValues.put(COL_AWEIGHT, a.getWeight());
			insertValues.put(COL_ATYPE, a.getType());
			insertValues.put(COL_ASIZE, a.getSize());
			insertValues.put(COL_ADAMAGE, a.getDamage());
			insertValues.put(COL_ALOWCRIT, a.getLowCrit());
			insertValues.put(COL_AHIGHCRIT, a.getHighCrit());
			insertValues.put(COL_ABONUS, a.getaBonus());
			insertValues.put(COL_SPECIAL, a.getSpecial());
			
			return insertValues;
		}
		
		/*
		 * A method that returns a ContentValues object filled with item information bassed off of the item passed in
		 */
		public ContentValues createItemCV(Item it)
		{
			ContentValues insertValues = new ContentValues();
			
			//add the data to insert
			insertValues.put(COL_NAME, it.getName());
			insertValues.put(COL_IPRICE, it.getPrice());
			insertValues.put(COL_IPOS, it.getPosition());
			insertValues.put(COL_IATTACK, it.getAttack());
			insertValues.put(COL_IDEFENSE, it.getDefense());
			insertValues.put(COL_IWEIGHT, it.getWeight());
			insertValues.put(COL_IENCHANT, it.getEnchantment());
			insertValues.put(COL_ICLASS, it.getIclass());
			insertValues.put(COL_ITYPE, it.getType());
			
			return insertValues;
		}
		
		/*
		 * A method that returns a ContentValues object filled with skills information based off of the passed in character
		 */
		public ContentValues createSkillsCV(Character c)
		{
			ContentValues insertValues = new ContentValues();
			CSkills r = c.getSkillsRanks();
			CSkills m = c.getSkillsMisc();
			//add the data
			insertValues.put(COL_CHID, c.getIntegerId());
			insertValues.put(COL_APP, r.getAppraise());
			insertValues.put(COL_MAPP, m.getAppraise());
			insertValues.put(COL_AUTO, r.getAutohypnosis());
			insertValues.put(COL_MAUTO, m.getAutohypnosis());
			insertValues.put(COL_BAL, r.getBalance());
			insertValues.put(COL_MBAL, m.getBalance());
			insertValues.put(COL_BLUFF, r.getBluff());
			insertValues.put(COL_MBLUFF, m.getBluff());
			insertValues.put(COL_CLIMB, r.getClimb());
			insertValues.put(COL_MCLIMB, m.getClimb());
			insertValues.put(COL_CONTS, r.getControlShape());
			insertValues.put(COL_MCONTS, m.getControlShape());
			insertValues.put(COL_CONC, r.getConcentration());
			insertValues.put(COL_MCONC, m.getConcentration());
			insertValues.put(COL_DEC, r.getDecipherScript());
			insertValues.put(COL_MDEC, m.getDecipherScript());
			insertValues.put(COL_DIP, r.getDiplomacy());	
			insertValues.put(COL_MDIP, m.getDiplomacy());
			insertValues.put(COL_DISDEV, r.getDisableDevice());
			insertValues.put(COL_MDISDEV, m.getDisableDevice());
			insertValues.put(COL_DISG, r.getDisguise());
			insertValues.put(COL_MDISG, m.getDisguise());
			insertValues.put(COL_ESC, r.getEscapseArtist());
			insertValues.put(COL_MESC, m.getEscapseArtist());
			insertValues.put(COL_FORG, r.getForgery());
			insertValues.put(COL_MFORG, m.getForgery());
			insertValues.put(COL_GATINFO, r.getGatherInformation());
			insertValues.put(COL_MGATINFO, m.getGatherInformation());
			insertValues.put(COL_HANDLEAN, r.getHandleAnimal());
			insertValues.put(COL_MHANDLEAN, m.getHandleAnimal());
			insertValues.put(COL_HEAL, r.getHeal());
			insertValues.put(COL_MHEAL, m.getHeal());
			insertValues.put(COL_HIDE, r.getHide());
			insertValues.put(COL_MHIDE, m.getHide());
			insertValues.put(COL_HYPNO, r.getHypnosis());
			insertValues.put(COL_MHYPNO, m.getHypnosis());
			insertValues.put(COL_INTIM, r.getIntimidate());
			insertValues.put(COL_MINTIM, m.getIntimidate());
			insertValues.put(COL_JUMP, r.getJump());
			insertValues.put(COL_MJUMP, m.getJump());
			insertValues.put(COL_KARCA, r.getkArcana());
			insertValues.put(COL_MKARCA, m.getkArcana());
			insertValues.put(COL_KARCH, r.getkArchEng());
			insertValues.put(COL_MKARCH, m.getkArchEng());
			insertValues.put(COL_KDUN, r.getkDungeoneering());
			insertValues.put(COL_MKDUN, m.getkDungeoneering()); 
			insertValues.put(COL_KGEO, r.getkGeography());
			insertValues.put(COL_MKGEO, m.getkGeography());
			insertValues.put(COL_KHIST, r.getkHistory());
			insertValues.put(COL_MKHIST, m.getkHistory());
			insertValues.put(COL_KLOC, r.getkLocal());
			insertValues.put(COL_MKLOC, m.getkLocal());
			insertValues.put(COL_KMON, r.getkMonsterLore());
			insertValues.put(COL_MKMON,m.getkMonsterLore());
			insertValues.put(COL_KNAT, r.getkNature());
			insertValues.put(COL_MKNAT, m.getkNature());
			insertValues.put(COL_KNOB, r.getkNobility());
			insertValues.put(COL_MKNOB,m.getkNobility());
			insertValues.put(COL_KPSI,r.getkPsionics());
			insertValues.put(COL_MKPSI,m.getkPsionics());
			insertValues.put(COL_KRAV, r.getkRavenloft());
			insertValues.put(COL_MKRAV,m.getkRavenloft());
			insertValues.put(COL_KREL, r.getkReligion());
			insertValues.put(COL_MKREL, m.getkReligion());
			insertValues.put(COL_KPLA, r.getkPlanes());
			insertValues.put(COL_MKPLA,m.getkPlanes());
			insertValues.put(COL_LIST, r.getListen());
			insertValues.put(COL_MLIST,m.getListen());
			insertValues.put(COL_MOVSIL,r.getMoveSilent());
			insertValues.put(COL_MMOVSIL,m.getMoveSilent());
			insertValues.put(COL_OPLOCK,r.getOpenLock());
			insertValues.put(COL_MOPLOCK,m.getOpenLock());
			insertValues.put(COL_PSICR, r.getPsicraft());
			insertValues.put(COL_MPSICR,m.getPsicraft());
			insertValues.put(COL_RIDE,r.getRide());
			insertValues.put(COL_MRIDE,m.getRide());
			insertValues.put(COL_SEARCH,r.getSearch());
			insertValues.put(COL_MSEARCH,m.getSearch());
			insertValues.put(COL_SENSMOT,r.getSenseMotive());
			insertValues.put(COL_MSENSMOT,m.getSenseMotive());
			insertValues.put(COL_SKILTRIC,r.getSkillTricks());
			insertValues.put(COL_MSKILTRIC,m.getSkillTricks());
			insertValues.put(COL_SOH, r.getSlieghtOfHand());
			insertValues.put(COL_MSOH,m.getSlieghtOfHand());
			insertValues.put(COL_SPEAK, r.getSpeakLanguage());
			insertValues.put(COL_MSPEAK,m.getSpeakLanguage());
			insertValues.put(COL_SPELLC,r.getSpellcraft());
			insertValues.put(COL_MSPELLC,m.getSpellcraft());
			insertValues.put(COL_SPOT,r.getSpot());
			insertValues.put(COL_MSPOT,m.getSpot());
			insertValues.put(COL_SURV,r.getSurvival());
			insertValues.put(COL_MSURV,m.getSurvival());
			insertValues.put(COL_SWIM,r.getSwim());
			insertValues.put(COL_MSWIM,m.getSwim());
			insertValues.put(COL_TUMB,r.getTumble());
			insertValues.put(COL_MTUMB,m.getTumble());
			insertValues.put(COL_UMD,r.getUseMagicDevice());
			insertValues.put(COL_MUMD,m.getUseMagicDevice());
			insertValues.put(COL_UPD,r.getUsePsionicDevice());
			insertValues.put(COL_MUPD,m.getUsePsionicDevice());
			insertValues.put(COL_USEROPE,r.getUseRope());
			insertValues.put(COL_MUSEROPE,m.getUseRope());
			
			return insertValues;
			
		}
}
