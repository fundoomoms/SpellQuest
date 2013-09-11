package com.fundoozz.spellquest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onRadioButtonClicked(View view) {
		
		// Is the button now checked?
	    boolean checked = ((RadioButton) view).isChecked();
	    Intent intent = null; 
	    
	    // Check which radio button was clicked
	    switch(view.getId()) {
	        case R.id.view_treasure_radio:	        
	            if (checked) {
					intent = new Intent(this, TreasureActivity.class);
					startActivity(intent);
					break;	            	
		            } 
            
	        case R.id.spell_quiz_radio:
	        	if (checked) {
					intent = new Intent(this, SpellQuizActivity.class);
					startActivity(intent);
					break;	            	
		            }
	        case R.id.vocab_quiz_radio:
	        	if (checked) {
					intent = new Intent(this, VocabQuizActivity.class);
					startActivity(intent);
					break;	            	
		            }
	        case R.id.learn_radio:
	        	if (checked) {
					intent = new Intent(this, WordListDetailActivity.class);
					startActivity(intent);
					break;	            	
		            }
	        case R.id.add_words_radio:
	        	if (checked) {
					intent = new Intent(this, AddWordsActivity.class);	
					startActivity(intent);
					break;	            	
		            }
	        case R.id.find_words_radio:
	        	if (checked) {
					intent = new Intent(this, FindWordsActivity.class);	
					startActivity(intent);
					break;	            	
		            }
	        	
	            
	    }

		
	}

}
