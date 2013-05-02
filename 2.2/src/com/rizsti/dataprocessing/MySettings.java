package com.rizsti.dataprocessing;

import com.rizsti.teddy.R;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
/**
 * 
 * @author Andrea Dewey
 *
 */
/*
 * This object uses Singletons pattern which prevents multiple instances from being created.
 * 
 * When first instantiated, the object will load the settings file.
 * 
 * All set methods will update the settings.
 */
public class MySettings {
	//Singletons pattern. 
	private static MySettings mInstance = null;

	//SharedPreferences and Editor.
	private SharedPreferences mSharedPrefs;
	private Editor mEdit;
	
	//Final variables for file and preference names
	private static final String EXIST_PREF = "SETTINGS_EXIST";
	
	//Saved setting names
	public static final String THEME_COLOR = "THEME_COLOR";
	
	//Global Variables
	public static final int NEW_CHARACTER=1;
	public static final int OLD_CHARACTER=0;
	public static final String BLUE = "BLUE";
	public static final String DBLUE = "DARKBLUE";
	public static final String GREEN = "GREEN";
	public static final String DGREEN = "DARKGREEN";
	public static final String RED = "RED";
	public static final String DRED = "DARKRED";
	public static final String PINK = "PINK";
	public static final String PURPLE = "PURPLE";
	public static final String[] COLOUR_LIST ={MySettings.BLUE,MySettings.DBLUE,MySettings.DGREEN,MySettings.DRED,
			MySettings.PINK,MySettings.PURPLE,MySettings.RED};
	
	/**
	 * Constructor
	 * @param context
	 */
    protected MySettings(Context context)
    {
		mSharedPrefs  = context.getSharedPreferences(EXIST_PREF, Context.MODE_PRIVATE);
		mEdit = mSharedPrefs.edit();
		
		//If the settings file doesn't exist then set the default values
		if (mSharedPrefs.contains(EXIST_PREF))
			return;
			
		mEdit.putBoolean(EXIST_PREF, true);
		
		//SET THE DEFAULT SETTINGS
		SetThemeColor(BLUE);
		
		
		//END of default settings
		
		mEdit.commit();
    }

    /**
     * get an instance of this class using the passed in context
     * @param context
     * @return: Instance of this class
     */
    public static synchronized MySettings getInstance(Context context) {
    	if(null == mInstance){
    		mInstance = new MySettings(context);
    	}
    	return mInstance;
    }
    /**
     * Get an instance of this class
     * @return
     */
    public static synchronized MySettings getInstance() {
    	if(null == mInstance){
    		return null;
    	}
    	return mInstance;
    }
    
    
//  //   ) )                                                  
// //         ___    __  ___ __  ___  ___      __      ___    
////  ____  //___) )  / /     / /   //___) ) //  ) ) ((   ) ) 
////    / / //        / /     / /   //       //        \ \     
//((____/ / ((____    / /     / /   ((____   //      //   ) ) 	
    
    /**
     * 
     * @return String value of the currently selected color
     */
    public String GetThemeColor()
    {
    	return mSharedPrefs.getString(THEME_COLOR, null);
    }
    /**
     * 
     * @param c
     * @return A drawable object for the currently selected color
     */
    public Drawable GetDrawableTheme(Context c)
    {
    	//Create a default drawable
    	Drawable d = c.getResources().getDrawable(R.drawable.blue);
    	//Get the chosen color
    	String theme = GetThemeColor();
    	//Ensure the color is not null
    	if (!(theme==null))
    	{
	    	if (theme.equals(BLUE))
	    	{
	    		d = c.getResources().getDrawable(R.drawable.blue);
	    	}else if(theme.equals(DBLUE))
	    	{
	    		d = c.getResources().getDrawable(R.drawable.dblue);
	    	}else if(theme.equals(RED))
	    	{
	    		d = c.getResources().getDrawable(R.drawable.red);
	    	}else if(theme.equals(DRED))
	    	{
	    		d = c.getResources().getDrawable(R.drawable.dred);
	    	}else if(theme.equals(DGREEN))
	    	{
	    		d = c.getResources().getDrawable(R.drawable.dgreen);
	    	}else if(theme.equals(GREEN))
	    	{
	    		d = c.getResources().getDrawable(R.drawable.green);
	    	}else if(theme.equals(PINK))
	    	{
	    		d = c.getResources().getDrawable(R.drawable.pink);
	    	}else if(theme.equals(PURPLE))
	    	{
	    		d = c.getResources().getDrawable(R.drawable.purple);
	    	}
    	}
    	//Return the drawable
    	return d;
    }
    //Set the chosen theme color
    public void SetThemeColor(String value)
    {
    	//save the passed in value
    	mEdit.putString(THEME_COLOR, value);
    	//commit change
    	mEdit.commit();
    }

    

}
