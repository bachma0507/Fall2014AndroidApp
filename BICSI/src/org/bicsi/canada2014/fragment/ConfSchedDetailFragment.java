package org.bicsi.canada2014.fragment;

import java.util.List;
import org.bicsi.fall2014.R;
import org.bicsi.canada2014.adapter.SQLiteDBAllData;
import org.bicsi.canada2014.common.MizeUtil.NavigateToTabFragmentListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.FilterQueryProvider;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import org.bicsi.canada2014.activities.MainActivity;


public class ConfSchedDetailFragment extends Fragment implements AdapterView.OnItemClickListener{

	private NavigateToTabFragmentListener mCallback;//interface from MizeUtil
	private SQLiteDBAllData sqlite_obj;
	private SimpleCursorAdapter dataAdapter;
	public String confDate;

	public void onAttach(Activity activity) {
		super.onAttach(activity);


		try {
			mCallback = (NavigateToTabFragmentListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement NavigateToListener");
		}
	}

	//}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		super.onCreateView(inflater, container, savedInstanceState);
		final View v = inflater.inflate(R.layout.fragment_confschedule_detail, container, false);
		
		Bundle bundle = getArguments();
				if(bundle != null){
				
				confDate = bundle.getString("date");
				
				}

				System.out.println("BUNDLE DATE PASSED IS " + confDate);

		sqlite_obj = new SQLiteDBAllData(getActivity());

		sqlite_obj.open();

		Cursor cursor = sqlite_obj.fetchAllSchedulesByDate(confDate);
		
		
		//Cursor cursor = sqlite_obj.fetchAllSchedules();
		

		// The desired columns to be bound
		String[] columns = new String[] {
				SQLiteDBAllData.KEY_functiontitle,
				SQLiteDBAllData.KEY_fucntioindate,
				SQLiteDBAllData.KEY_functionStartTime,
				SQLiteDBAllData.KEY_functionEndTime,
				SQLiteDBAllData.KEY_ID
				

		};

		
		// the XML defined views which the data will be bound to
		int[] to = new int[] { 
				R.id.textViewfunctiontitle,
				R.id.textViewfunctiondate,
				R.id.textViewfunctionStartTime,
				R.id.textViewfunctionEndTime,
				R.id.textViewFUNCTIONCD
				

		};

		
		// create the adapter using the cursor pointing to the desired data 
		//as well as the layout information
		dataAdapter = new SimpleCursorAdapter(
				getActivity(), R.layout.confschedule_detail_info_list, 
				cursor, 
				columns, 
				to,
				0);

		ListView listView = (ListView)v. findViewById(android.R.id.list);
		// Assign adapter to ListView
		listView.setAdapter(dataAdapter);
		listView.setOnItemClickListener(this);


		EditText myFilter = (EditText)v. findViewById(R.id.myFilter);
		myFilter.addTextChangedListener(new TextWatcher() {

			public void afterTextChanged(Editable s) {
			}

			public void beforeTextChanged(CharSequence s, int start, 
					int count, int after) {
			}

			public void onTextChanged(CharSequence s, int start, 
					int before, int count) {
				dataAdapter.getFilter().filter(s.toString());
			}
		});

		dataAdapter.setFilterQueryProvider(new FilterQueryProvider() {
			public Cursor runQuery(CharSequence constraint) {
				return sqlite_obj.fetchScheduleByDate(constraint.toString(), confDate);
			}
		});

		return v;
		
	}

	@Override
	public void onItemClick(AdapterView<?> listView, View view, 
			int position, long id) {

		//Toast.makeText(getActivity(), "Clicked "+ position, Toast.LENGTH_LONG).show();
		// Get the cursor, positioned to the corresponding row in the result set
		Cursor cursor = (Cursor) listView.getItemAtPosition(position);


		String confFUNCTIONCD = 
				cursor.getString(cursor.getColumnIndexOrThrow("_id"));

		//String allData = exHallScheduleDate + " \n" + exHallSessionName + "\n" + exHallSessionTime;

		Toast.makeText(getActivity(), confFUNCTIONCD, Toast.LENGTH_LONG).show();


		/*ConfSchedDetailFragment myDetailFragment = new ConfSchedDetailFragment();

		Bundle bundle = new Bundle();

		bundle.putString("date", confSchedDate);

		myDetailFragment.setArguments(bundle);

		mCallback.navigateToTabFragment(myDetailFragment, null); //interface method
		*/

		sqlite_obj.close();

	}

	@Override
	public void onResume() {
		super.onResume();
		((MainActivity)getActivity()).updateTracker("Home Tab");
	}


}
