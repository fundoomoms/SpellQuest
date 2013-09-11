package com.fundoozz.spellquest;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;

public class WordListDetailActivity extends FragmentActivity implements WordListFragment.OnWordSelectedListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_word_list_detail);
		if(findViewById(R.id.word_list_detail_fragment_container) != null) {
			
			if(savedInstanceState != null) {
				return;
			}
			
			WordListFragment listFragment = new WordListFragment();
			listFragment.setArguments(getIntent().getExtras());
			getSupportFragmentManager().beginTransaction()
				.add(R.id.word_list_detail_fragment_container, listFragment).commit();			
			
		}
	}
	
	public void onWordSelected(int position){
		
		// Basically, check to see which mode we are in. If the layout already has the 
		// word detail view, get hold of it and update it. 
		// If the word detail view isn't there in the layout, then 
		// create the new fragment for word detail and swap the current view with the word detail view. 
		WordDetailFragment detailFragment = (WordDetailFragment) getSupportFragmentManager().findFragmentById(R.id.word_detail_fragment);
		if(detailFragment != null) {
			
			detailFragment.updateWordDetailView(position);
			
		}
		else { 
			WordDetailFragment newFragment = new WordDetailFragment();
			Bundle args = new Bundle();
			args.putInt(WordDetailFragment.ARG_POSITION, position);
			newFragment.setArguments(args);
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
			transaction.replace(R.id.word_list_detail_fragment_container, newFragment);
			transaction.addToBackStack(null);
			transaction.commit();
			
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.word_list_detail, menu);
		return true;
	}

}
