package com.fundoozz.spellquest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WordDetailFragment extends Fragment {
	public static final String ARG_POSITION = "position";
	int mCurrentPosition = -1;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {
		
		if(savedInstanceState != null) {
			mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
			
		}
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.word_detail, container, false);
    }
	
	public void onStart() {
		super.onStart();
		Bundle args = getArguments();
		if(args != null) {
			updateWordDetailView(args.getInt(ARG_POSITION));			
		}
		else  if (mCurrentPosition != -1) {
			updateWordDetailView(mCurrentPosition);
		}
	}
	
	public void updateWordDetailView(int position) {
		
		TextView wordDetailView = (TextView)getActivity().findViewById(R.id.word_detail);
		wordDetailView.setText(WordData.details[position]);
		mCurrentPosition = position;
	}

}
