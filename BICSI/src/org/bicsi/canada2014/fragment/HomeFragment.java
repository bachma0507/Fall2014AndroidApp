package org.bicsi.canada2014.fragment;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.content.Intent;

import org.bicsi.fall2014.R;
import org.bicsi.canada2014.activities.MainActivity;

import org.bicsi.canada2014.common.MizeUtil.NavigateToTabFragmentListener;


import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.MapBuilder;

public class HomeFragment extends Fragment {

	private NavigateToTabFragmentListener mCallback;
	private ImageView ivConfsch, ivContacts, ivPresent, ivSurvey, ivCec, ivExhall, ivExfloor, ivExhbit, ivHtinfo, ivCommeet, ivTrainexam, ivBicsiwelcome;
	private Fragment newFragment = new WebviewFragment();
	private Fragment newFragment2 = new EhallSchedFragment2();
	private Fragment newFragment3 = new ConfSchedFragment();
	private Fragment newFragment4 = new CommitteeFragment();

	
	
	

	public void onAttach(Activity activity) {
		super.onAttach(activity);

		try {
			mCallback = (NavigateToTabFragmentListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement NavigateToListener");
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View v = inflater.inflate(R.layout.home_layout, container, false);


		
		 	ivConfsch = (ImageView)v.findViewById(R.id.confsch);
	        ivContacts = (ImageView)v.findViewById(R.id.contacts);
	        ivPresent = (ImageView)v.findViewById(R.id.present);
	        ivSurvey = (ImageView)v.findViewById(R.id.survey);
	        ivCec = (ImageView)v.findViewById(R.id.cec);
	        ivExhall = (ImageView)v.findViewById(R.id.exhall);
	        ivExfloor = (ImageView)v.findViewById(R.id.exfloor);
	        ivExhbit = (ImageView)v.findViewById(R.id.exhbit);
	        ivHtinfo = (ImageView)v.findViewById(R.id.htinfo);
	        ivCommeet = (ImageView)v.findViewById(R.id.commeet);
	        ivTrainexam = (ImageView)v.findViewById(R.id.trainexam);
	        ivBicsiwelcome = (ImageView)v.findViewById(R.id.bicsiwelcome);
	       // iv11 = (ImageView)v.findViewById(R.id.contacts);
	             	     
		ivConfsch.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				//openInternalWebview("http://www.bicsi.org/m/Schedule.aspx");
				
				mCallback.navigateToTabFragment(newFragment3, null);
			}
		});

		ivContacts.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				openInternalWebview("http://www.bicsi.org/m/content.aspx?id=6554");
			}
		});

		ivPresent.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				openInternalWebview("http://www.bicsi.org/m/content.aspx?id=7265");
			}
		});
		ivSurvey.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				openInternalWebview("http://www.bicsi.org/m/surveys.aspx#one");
			}
		});
		ivCec.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				openInternalWebview("http://www.bicsi.org/m/content.aspx?id=7005");
			}
		});
		ivExhall.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				     //when a user selects an event from your list

				mCallback.navigateToTabFragment(newFragment2, null);

				//openInternalWebview("http://www.bicsi.org/m/content.aspx?id=7006");
				
				//Need here code to open EhallSchedFragment.java
				
				// Start NewActivity.class
                /*Intent myIntent = new Intent(getActivity(),
                        EhallSchedFragment.class);
                startActivity(myIntent);*/
			}
		});
		ivExfloor.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				openInternalWebview("http://speedyreference.com/floormap/boothinfofall14.htm");
				//openInternalWebview("http://speedyreference.com/bicsiappcms/floormaps.html");
			}
		});
		ivExhbit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				openInternalWebview("http://www.bicsi.org/m/hall.aspx");
			}
		});
		ivHtinfo.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				openInternalWebview("http://www.bicsi.org/m/content.aspx?id=7011");
			}
		});
		ivCommeet.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				mCallback.navigateToTabFragment(newFragment4, null);
				//openInternalWebview("http://www.bicsi.org/m/content.aspx?id=7003");
			}
		});
		ivTrainexam.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				openInternalWebview("http://www.bicsi.org/m/content.aspx?id=7024");
				
			}
		});
		ivBicsiwelcome.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				openInternalWebview("http://microsite.anaheimoc.org/2014-bicsi-fall-conference-exhibition");
			}
		});
		return v;
	}
	private void openInternalWebview(CharSequence urlToOpen) {
		if (urlToOpen == null) {
			return;
		}
		String urlString = urlToOpen.toString();
		((MainActivity)getActivity()).mWebViewURL = urlString;
		mCallback.navigateToTabFragment(newFragment, null);
	}

	@Override
	public void onResume() {
		super.onResume();
		((MainActivity)getActivity()).updateTracker("Home Tab");
	}

	
	
	


	
}
