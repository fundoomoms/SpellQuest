package com.fundoozz.spellquest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SpellQuizActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spell_quiz);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.spell_quiz, menu);
		return true;
	}

}
