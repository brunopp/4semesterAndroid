package com.example.kodetilkunde;

import java.util.List;

import com.example.model.Bricks;
import com.example.sqlite.Database;


import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class SelectBrickActivity extends Activity implements OnItemClickListener {
	
	//fields
	
	EditText edittext;
	
	
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
			
			edittext = (EditText)findViewById(R.id.editTextSearch);
		}
		
		// listview click

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                long id) {
        	Bricks b = new Bricks();
    		b = (Bricks) parent.getItemAtPosition(position);
    		Intent intent = new Intent(this, SelectCategoryActivity.class);
    		intent.putExtra("brickId", b.getId());


    		startActivity(intent);  
    		finish();
    		
        }
        
        public void ButtonSearch(View v)
        {
			String name;
			
			// set name 
			
			name = edittext.getText().toString();
			
			// database handler
			Database db = new Database(getApplicationContext());

			// listview Drop down elements
			List<Bricks> allBricks = db.getAllBricksByName(name);

			// Opretter adapter for listview
			ArrayAdapter<Bricks> dataAdapter = new ArrayAdapter<Bricks>(this,
					android.R.layout.simple_list_item_1, allBricks);

			// Drop down layout - listview med radio button
			dataAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

			// tilf�jer data adapter til listview
			listview.setAdapter(dataAdapter);
        }

	
}
