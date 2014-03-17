package com.example.kodetilkunde;

import com.example.sqlite.Database;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;

public class SelectCategoryActivity extends Activity {

	private int brickId;
	private int catId;
	private Database db = new Database(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_category);

		Intent intent = getIntent();
		brickId = intent.getIntExtra("brickId", 999);

		if (brickId == 999) {
			AlertDialog.Builder alertbox = new AlertDialog.Builder(this);

			// Set the message to display
			alertbox.setMessage("Brick ID er 999, gå tilbage!");

			// Add a neutral button to the alert box and assign a click listener
			alertbox.setNeutralButton("OK",
					new DialogInterface.OnClickListener() {

						// Click listener on the neutral button of alert box
						public void onClick(DialogInterface arg0, int arg1) {
							// The neutral button was clicked
						}
					});

			// show the alert box
			alertbox.show();
		}
	}

	public void setBrickToCat(View v) {
		switch (v.getId()) {
		case R.id.arkitektur:
			catId = 1;
			break;
		case R.id.brugerefunktioner:
			catId = 2;
			break;
		case R.id.industrialisering:
			catId = 3;
			break;
		case R.id.energidesign:
			catId = 4;
			break;
		case R.id.oekonomi:
			catId = 5;
			break;
		case R.id.stabilitet:
			catId = 6;
			break;
		case R.id.stedet:
			catId = 7;
			break;
		case R.id.tekinstallationer:
			catId = 8;
			break;
		default:
			throw new RuntimeException("Unknow button ID");
		}
		try 
		{
			db.createSelectedBricks(catId, brickId);
			finish();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
