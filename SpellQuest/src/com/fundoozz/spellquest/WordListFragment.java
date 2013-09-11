package com.fundoozz.spellquest;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class WordListFragment extends ListFragment {
	
	OnWordSelectedListener mCallBack;
	
	public interface OnWordSelectedListener {
		public void onWordSelected(int position);
	}

	
	@Override
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ? 
				     android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;
		
		setListAdapter(new ArrayAdapter<String>(getActivity(), layout, WordData.words));
		
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
		mCallBack = (OnWordSelectedListener) activity;
		}
		catch(ClassCastException e) {
			throw new ClassCastException(activity.toString()
                    + " must implement OnWordSelectedListener");
		}
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (getFragmentManager().findFragmentById(R.id.word_detail_fragment) != null) {
			getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		}
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		mCallBack.onWordSelected(position);
		getListView().setItemChecked(position, true);
		
	}


}
