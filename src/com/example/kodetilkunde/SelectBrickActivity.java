package com.example.kodetilkunde;

import java.util.ArrayList;
import java.util.List;


import com.example.model.Bricks;
import com.example.sqlite.Database;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SelectBrickActivity extends Activity implements OnItemClickListener {
	
	//fields
	
	//sender beskeder videre
	public final static String EXTRA_ID = "com.example.kodetilkunde.id";
	public final static String EXTRA_NAME = "com.example.kodetilkunde.name";
	public final static String EXTRA_COLOUR = "com.example.kodetilkunde.COLOUR";
	
	
	ListView listview;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_brick);
		
		// listview element
		listview = (ListView)findViewById(R.id.listViewBricks);
		
		// setter item click listener
		listview.setOnItemClickListener(this);
		
		// hent listview data fra databasen
		loadListviewData();
		
		
//		List<String> l = new ArrayList<String>();
//		l.add("B1");
//		l.add("B2");
//		l.add("B3");
//		
//		ListView lv = (ListView) findViewById(R.id.listViewBricks);
//		ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, l);
//		lv.setAdapter(aa);
//		
//		final Context c = this;
//		lv.setOnItemClickListener(new OnItemClickListener() {
// 
//			@Override
//			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//				Intent i = new Intent(c, SelectCategoryActivity.class);
//				i.putExtra("brickId", -1);
//				startActivity(i);
//			}
//		});
	}
		
		private void loadListviewData() {
			// database handler
			Database db = new Database(getApplicationContext());

			// listview Drop down elements
			List<Bricks> getAllBricks = db.getAllBricks();

			// Opretter adapter for spinner
			ArrayAdapter<Bricks> dataAdapter = new ArrayAdapter<Bricks>(this,
					android.R.layout.simple_list_item_1, getAllBricks);

			// Drop down layout - listview med radio button
			dataAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

			// tilf�jer data adapter til listview
			listview.setAdapter(dataAdapter);
		}
		
		// listview click

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                long id) {
        	Bricks b = new Bricks();
    		b = (Bricks) parent.getItemAtPosition(position);
    		Intent intent = new Intent(this, SelectCategoryActivity.class);
    		intent.putExtra(EXTRA_ID, b.getId());
    		intent.putExtra(EXTRA_NAME, b.getName());
    		intent.putExtra(EXTRA_COLOUR, b.getColour());

    		startActivity(intent);        	
    		
        }

	
}
