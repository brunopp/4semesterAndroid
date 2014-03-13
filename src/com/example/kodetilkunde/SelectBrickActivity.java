package com.example.kodetilkunde;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SelectBrickActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_brick);
		
		List<String> l = new ArrayList<String>();
		l.add("B1");
		l.add("B2");
		l.add("B3");
		
		ArrayAdapter<String> aa = new ArrayAdapter<String>(this, R.id.listViewBricks, android.R.layout.simple_list_item_1, l);
		
		ListView lv = (ListView) findViewById(R.id.listViewBricks);
		lv.setAdapter(aa);
		
		final Toast t = Toast.makeText(this, "onPause", Toast.LENGTH_SHORT);
		lv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				t.show();
			}
		});
	}
}
