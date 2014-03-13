package com.example.kodetilkunde;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class SelectCategoryActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_category);
		
		Intent intent = getIntent();
		int brickId = intent.getIntExtra("brickId", 999);
	}


}
