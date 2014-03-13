package com.example.kodetilkunde;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.apmem.tools.layouts.*;

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
				b.setText("BUTTON" + j);
				
				fl.addView(b);
			
			// Add the FlowLayout to the container.
			container.addView(fl);
			}
		}
		
	}
		
//		// Create 8 categories
//		for (int i = 0; i < 8; i++) {
//			// Inflate the FlowLayout (=create a flowlayout from an XML file).
//			FlowLayout fl = (FlowLayout) View.inflate(this, R.layout.flow_layout, null);
//			// Find the TextView in the FlowLayout.
//			TextView tv = (TextView) fl.findViewById(R.id.textView);
//			tv.setText("KATEGORI" + i);
			
			
			// Add 10 buttons to the FlowLayout.
//			for (int j = 0; j < 10; j++) {
//				Button b = new Button(this);
//				b.setText("BUTTON" + j);
//				
//				fl.addView(b);
//			}
			
			// Add the FlowLayout to the container.
//			container.addView(fl);
//		}
//	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
