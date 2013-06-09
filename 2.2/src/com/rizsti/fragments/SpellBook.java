package com.rizsti.fragments;

import com.rizsti.teddy.R;
import com.rizsti.teddy.R.layout;
import com.rizsti.teddy.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SpellBook extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_spell_book);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.spell_book, menu);
		return true;
	}

}