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
        // Inserting Bricks
        Log.d("Insert: ", "Inserting Lilla purple...");
        db.createBricks(new Bricks (1, "Æstetik" , "lilla"));
        db.createBricks(new Bricks (2, "Privat" , "lilla"));
        db.createBricks(new Bricks (3, "Inspiration" , "lilla"));
        db.createBricks(new Bricks (4, "Skygge" , "lilla"));
        db.createBricks(new Bricks (5, "Historie" , "lilla"));
        db.createBricks(new Bricks (6, "Støj" , "lilla"));
        db.createBricks(new Bricks (7, "Modernisme" , "lilla"));
        db.createBricks(new Bricks (7, "Farver" , "lilla"));
        db.createBricks(new Bricks (7, "Stilhed" , "lilla"));        
        db.createBricks(new Bricks (1, "Høj" , "lilla"));
        db.createBricks(new Bricks (2, "Integreret" , "lilla"));
        db.createBricks(new Bricks (3, "Trængsel" , "lilla"));
        db.createBricks(new Bricks (4, "System" , "lilla"));
        db.createBricks(new Bricks (5, "Ekslusiv" , "lilla"));
        db.createBricks(new Bricks (6, "Struktur" , "lilla"));
        db.createBricks(new Bricks (7, "Overflader" , "lilla"));
        db.createBricks(new Bricks (7, "Rolig" , "lilla"));
        db.createBricks(new Bricks (7, "Lav" , "lilla"));   
        db.createBricks(new Bricks (1, "Passiv" , "lilla"));
        db.createBricks(new Bricks (2, "Terræn" , "lilla"));
        db.createBricks(new Bricks (3, "Offentlig" , "lilla"));
        db.createBricks(new Bricks (4, "Intelligent" , "lilla"));
        db.createBricks(new Bricks (5, "Billig" , "lilla"));
        db.createBricks(new Bricks (6, "Oplevelse" , "lilla"));
        db.createBricks(new Bricks (7, "Rytme" , "lilla"));
        db.createBricks(new Bricks (7, "Udtryk" , "lilla"));
        db.createBricks(new Bricks (7, "Kaotisk" , "lilla"));
        db.createBricks(new Bricks (1, "Tyk" , "lilla"));
        db.createBricks(new Bricks (2, "Aktiv" , "lilla"));
        db.createBricks(new Bricks (3, "Grønne områder" , "lilla"));
        db.createBricks(new Bricks (4, "Kold" , "lilla"));
        db.createBricks(new Bricks (5, "Minimere" , "lilla"));
        db.createBricks(new Bricks (6, "Vinter" , "lilla"));
        db.createBricks(new Bricks (7, "Brugerstyring" , "lilla"));
        db.createBricks(new Bricks (7, "Fortælling" , "lilla"));
        db.createBricks(new Bricks (7, "Livsstil" , "lilla"));
        db.createBricks(new Bricks (1, "Symmetri" , "lilla"));
        db.createBricks(new Bricks (2, "Tynd" , "lilla"));
        db.createBricks(new Bricks (3, "Stor" , "lilla"));
        db.createBricks(new Bricks (4, "Nord" , "lilla"));
        db.createBricks(new Bricks (5, "Varm" , "lilla"));
        db.createBricks(new Bricks (6, "Fællesskab" , "lilla"));
        db.createBricks(new Bricks (7, "Sommer" , "lilla"));
        db.createBricks(new Bricks (7, "Organisk" , "lilla"));
        db.createBricks(new Bricks (7, "Udsigt" , "lilla"));
        db.createBricks(new Bricks (1, "Brugere" , "lilla"));
        db.createBricks(new Bricks (2, "Asymmetri" , "lilla"));
        db.createBricks(new Bricks (3, "Larm" , "lilla"));
        db.createBricks(new Bricks (4, "Lille" , "lilla"));
        db.createBricks(new Bricks (5, "Syd" , "lilla"));
        db.createBricks(new Bricks (6, "Kontrast" , "lilla"));
        db.createBricks(new Bricks (7, "Less is more" , "lilla"));
        db.createBricks(new Bricks (7, "Perception" , "lilla"));
        db.createBricks(new Bricks (7, "Solen" , "lilla"));
        db.createBricks(new Bricks (1, "Dagslys" , "lilla"));
        db.createBricks(new Bricks (2, "Diffus" , "lilla"));
        db.createBricks(new Bricks (3, "Sundhed" , "lilla"));
        db.createBricks(new Bricks (4, "Økonomi" , "lilla"));
        db.createBricks(new Bricks (5, "Fornem" , "lilla"));
        db.createBricks(new Bricks (6, "xxxxxx" , "lilla"));
        db.createBricks(new Bricks (7, "Åben" , "lilla"));
        db.createBricks(new Bricks (7, "Øst" , "lilla"));
        db.createBricks(new Bricks (7, "Leg" , "lilla"));
        db.createBricks(new Bricks (1, "Alvorlig" , "lilla"));
        db.createBricks(new Bricks (2, "Beklædning" , "lilla"));
        db.createBricks(new Bricks (3, "Regn" , "lilla"));
        db.createBricks(new Bricks (4, "Tydelig" , "lilla"));
        db.createBricks(new Bricks (5, "Livskvalitet" , "lilla"));
        db.createBricks(new Bricks (6, "xxxxxx" , "lilla"));
        db.createBricks(new Bricks (7, "Nuancer" , "lilla"));
        db.createBricks(new Bricks (7, "xxxxxx" , "lilla"));
        db.createBricks(new Bricks (7, "Lukket" , "lilla"));
        db.createBricks(new Bricks (6, "Vest" , "lilla"));
        db.createBricks(new Bricks (7, "Humor" , "lilla"));
        db.createBricks(new Bricks (7, "Højtidelig" , "lilla"));
        db.createBricks(new Bricks (7, "Lugt" , "lilla"));	
        db.createBricks(new Bricks (6, "Komfort" , "lilla"));
        db.createBricks(new Bricks (7, "Rytme" , "lilla"));
        db.createBricks(new Bricks (7, "xxxxxx" , "lilla"));
        db.createBricks(new Bricks (7, "xxxxxx" , "lilla"));	
        db.createBricks(new Bricks (6, "Værdiskabelse" , "lilla"));
        db.createBricks(new Bricks (7, "xxxxxx" , "lilla"));
        db.createBricks(new Bricks (7, "Mindmapping" , "lilla"));
        db.createBricks(new Bricks (7, "Natur" , "lilla"));
        db.createBricks(new Bricks (7, "Mødested" , "lilla"));
        db.createBricks(new Bricks (7, "Sikker" , "lilla"));	
        db.createBricks(new Bricks (7, "Aroma" , "lilla"));
        db.createBricks(new Bricks (7, "Akustik" , "lilla"));	
        db.createBricks(new Bricks (7, "Naturlig" , "lilla"));
        db.createBricks(new Bricks (7, "xxxxxx" , "lilla"));	
        db.createBricks(new Bricks (7, "xxxxxx" , "lilla"));
        db.createBricks(new Bricks (7, "Tryghed" , "lilla"));
        db.createBricks(new Bricks (7, "xxxxxx" , "lilla"));
        db.createBricks(new Bricks (7, "Benspænd" , "lilla"));	
        db.createBricks(new Bricks (7, "Introvert" , "lilla"));
        db.createBricks(new Bricks (7, "Træk" , "lilla"));	
        db.createBricks(new Bricks (7, "Skæv" , "lilla"));
        db.createBricks(new Bricks (7, "Principper" , "lilla"));	
        db.createBricks(new Bricks (7, "funktion" , "lilla"));
        db.createBricks(new Bricks (7, "Oprørsk" , "lilla"));
        db.createBricks(new Bricks (7, "xxxxxx" , "lilla"));	
        db.createBricks(new Bricks (7, "xxxxxx" , "lilla"));
        db.createBricks(new Bricks (7, "Akustik" , "lilla"));	
        db.createBricks(new Bricks (7, "xxxxxx" , "lilla"));
        db.createBricks(new Bricks (7, "Litteratur" , "lilla"));	
        db.createBricks(new Bricks (7, "Ekstrovert" , "lilla"));	
        db.createBricks(new Bricks (7, "Orientering" , "lilla"));
        db.createBricks(new Bricks (7, "ankomst" , "lilla"));	
        db.createBricks(new Bricks (7, "geometri" , "lilla"));
        db.createBricks(new Bricks (7, "" , "lilla"));	
        db.createBricks(new Bricks (7, "" , "lilla"));	
        db.createBricks(new Bricks (7, "" , "lilla"));
        db.createBricks(new Bricks (7, "" , "lilla"));	
        db.createBricks(new Bricks (7, "" , "lilla"));
        db.createBricks(new Bricks (7, "" , "lilla"));	

        
		 /**
         * Inserting
         * */
        // Inserting Bricks
        Log.d("Insert: ", "Inserting Lilla Green...");
        
        db.createBricks(new Bricks (7, "" , "Green"));	


		 /**
         * Inserting
         * */
        // Inserting Bricks
        Log.d("Insert: ", "Inserting Lilla Yellow...");
        
        db.createBricks(new Bricks (7, "" , "Yellow"));	

        
        
		 /**
         * Inserting
         * */
        // Inserting Categories
        Log.d("Insert: ", "Inserting Categories...");
        db.createCategory(new Category (1, "Arkitektur" , "Hvid"));
        db.createCategory(new Category (2, "Brugere/Funktion" , "Sand"));
        db.createCategory(new Category (3, "Industralisering" , "Lyserblå"));
        db.createCategory(new Category (4, "Energidesign" , "MørkSort"));
        db.createCategory(new Category (5, "Økonomi" , "Mørkebrun"));
        db.createCategory(new Category (6, "Stabilitet" , "Brun"));
        db.createCategory(new Category (7, "Stedet" , "Lysergrå"));
        db.createCategory(new Category (8, "Tekniske installioner" , "grå"));
        

        // Reading all Bricks
        Log.d("Reading: ", "Reading all Bricks..");
        List<Bricks> bri = db.getAllBricks();     
 
        for (Bricks bn : bri) {
            String log = "Id: "+bn.getId()+" ,Name: " + bn.getName() + " ,Colour: " + bn.getColour();
                // Writing Bricks to log
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
