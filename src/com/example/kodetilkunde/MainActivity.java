package com.example.kodetilkunde;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.apmem.tools.layouts.*;

import com.example.model.Bricks;
import com.example.sqlite.Database;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Get the container holding the categories.
		LinearLayout container = (LinearLayout) findViewById(R.id.layoutContainer);

		// ArrayList of categories
		List<String> category = new ArrayList<String>();
		// Add categories
		category.add("Arkitekur");
		category.add("Stedet");
		category.add("Brugere/Funktion");
		category.add("Stabilitet");
		category.add("Økonomi");
		category.add("Energidesign");
		category.add("Tekniske installationer");
		category.add("Industrialisering");
		
		Database db = new Database(this);
		
		 /**
         * Inserting
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.createBricks(new Bricks (1, "Æstetik" , "lilla"));
        db.createBricks(new Bricks (2, "Privat" , "lilla"));
        db.createBricks(new Bricks (3, "Inspiration" , "lilla"));
        db.createBricks(new Bricks (4, "Skygge" , "lilla"));
        db.createBricks(new Bricks (5, "Historie" , "lilla"));
        db.createBricks(new Bricks (6, "Støj" , "lilla"));
 
        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Bricks> bri = db.getAllBricks();     
 
        for (Bricks bn : bri) {
            String log = "Id: "+bn.getId()+" ,Name: " + bn.getName() + " ,Colour: " + bn.getColour();
                // Writing Contacts to log
        Log.d("Name: ", log);
		
		// Create 8 categories.
		for (String c : category) {
			// Inflate the FlowLayout (=create a flowlayout from an XML file).
			FlowLayout fl = (FlowLayout) View.inflate(this, R.layout.flow_layout, null);
			// Find the TextView in the FlowLayout.
			TextView tv = (TextView) fl.findViewById(R.id.textView);
			tv.setText(c);

			// Add 10 buttons to the FlowLayout.
			for (int j = 0; j < 10; j++) {
				Button b = new Button(this);

				b.setText(""+j);
				
				fl.addView(b);
			
			}

			// Add the FlowLayout to the container.
			container.addView(fl);
		}
       }

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId()) {
		case R.id.action_add:
			startSelectBrickActivity();
			break;
		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	private void startSelectBrickActivity()
	{
		Intent i = new Intent(this, SelectBrickActivity.class);
		startActivity(i);
	}
}
