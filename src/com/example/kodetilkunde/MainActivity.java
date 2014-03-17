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
import com.example.model.Category;
import com.example.sqlite.Database;
import com.example.sqlite.Database.Pair;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		updateSelectedBricks();
	}
	
	private void updateSelectedBricks()
	{
		// Get the container holding the categories.
		LinearLayout container = (LinearLayout) findViewById(R.id.layoutContainer);

		Database db = new Database(this);

		// Get all categories.
		List<Category> categories = db.getAllCategories();

		for (Category c : categories) {
			// Inflate the FlowLayout (=create a flowlayout from an XML file).
			FlowLayout fl = (FlowLayout) View.inflate(this, R.layout.flow_layout, null);
			// Find the TextView in the FlowLayout.
			TextView tv = (TextView) fl.findViewById(R.id.textView);
			
			// Set TextView to the category name.
			tv.setText(c.getName().toString());

			// Get the selected bricks for the current category.
			List<Bricks> bricks = db.getSelectedBricks(c.getId());
			// Add the bricks as buttons to the FlowLayout.
			for (Bricks brick : bricks) {
				Button b = new Button(this);
				b.setText(brick.getName());

				// Add button to FlowLayout.
				fl.addView(b);
			}

			// Add the FlowLayout to the container.
			container.addView(fl);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_add:
			startSelectBrickActivity();
			break;
		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}

	private void startSelectBrickActivity() {
		Intent i = new Intent(this, SelectBrickActivity.class);
		startActivity(i);
	}
}
