package org.bicsi.canada2014.fragment;

import org.bicsi.canada2014.activities.MainActivity;
import org.bicsi.canada2014.adapter.SQLiteDBAllData;
import org.bicsi.canada2014.common.MizeUtil.NavigateToTabFragmentListener;
import org.bicsi.fall2014.R;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class ConfSchedSingleFragment extends Fragment  {
	
	
	public String newFunctioncd;
	
	TextView title;
	TextView date;
	TextView start;
	TextView end;
	TextView desc;
	TextView location;
	TextView trainer1fname;
	TextView trainer1lname;
	TextView speakerslabel;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		super.onCreateView(inflater, container, savedInstanceState);
		final View v = inflater.inflate(R.layout.fragment_confschedule_single, container, false);
		
		title = (TextView)v.findViewById(R.id.functiontitle);
		date = (TextView)v.findViewById(R.id.functiondate);
		start = (TextView)v.findViewById(R.id.functionstarttimestr);
		end = (TextView)v.findViewById(R.id.functionendtimestr);
		desc = (TextView)v.findViewById(R.id.functiondecsription);
		location = (TextView)v.findViewById(R.id.functionlocation);
		trainer1fname = (TextView)v.findViewById(R.id.trainer1fname);
		trainer1lname = (TextView)v.findViewById(R.id.trainer1lname);
		speakerslabel = (TextView)v.findViewById(R.id.speakers_label);
		
		
		Bundle bundle = getArguments();
				if(bundle != null){
				
				newFunctioncd = bundle.getString("_id");
				
				if(newFunctioncd.contains("CONCSES") || newFunctioncd.contains("PRECON") || newFunctioncd.contains("GS_TUES") || newFunctioncd.contains("GS_THURS") == true){
					speakerslabel.setVisibility(View.VISIBLE);
				}
				else{
					speakerslabel.setVisibility(View.GONE);
				}
				
				String ftitle = bundle.getString("functiontitle");
				title.setText(ftitle);
				
				String fdate = bundle.getString("fucntioindate");
				date.setText(fdate);
				
				String fstart = bundle.getString("functionStartTimeStr");
				start.setText(fstart);
				
				String fend = bundle.getString("functionEndTimeStr");
				end.setText(fend);
				
				String fdesc = bundle.getString("functiondescription");
				desc.setText(fdesc);
				
				String floc = bundle.getString("LOCATIONNAME");
				location.setText(floc);
				
				String t1fname = bundle.getString("trainer1firstname");
				trainer1fname.setText(t1fname);
				
				String t1lname = bundle.getString("trainer1lastname");
				trainer1lname.setText(t1lname);
				
				}
				
				return v;
	}
	
	
}
