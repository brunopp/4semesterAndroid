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
        db.createBricks(new Bricks (1, "Æstetik" , "BD1550"));
        db.createBricks(new Bricks (2, "Privat" , "BD1550"));
        db.createBricks(new Bricks (3, "Inspiration" , "BD1550"));
        db.createBricks(new Bricks (4, "Skygge" , "BD1550"));
        db.createBricks(new Bricks (5, "Historie" , "BD1550"));
        db.createBricks(new Bricks (6, "Støj" , "BD1550"));
        db.createBricks(new Bricks (7, "Modernisme" , "BD1550"));
        db.createBricks(new Bricks (8, "Farver" , "BD1550"));
        db.createBricks(new Bricks (9, "Stilhed" , "BD1550"));        
        db.createBricks(new Bricks (10, "Høj" , "BD1550"));
        db.createBricks(new Bricks (11, "Integreret" , "BD1550"));
        db.createBricks(new Bricks (12, "Trængsel" , "BD1550"));
        db.createBricks(new Bricks (13, "System" , "BD1550"));
        db.createBricks(new Bricks (14, "Ekslusiv" , "BD1550"));
        db.createBricks(new Bricks (15, "Struktur" , "BD1550"));
        db.createBricks(new Bricks (16, "Overflader" , "BD1550"));
        db.createBricks(new Bricks (17, "Rolig" , "BD1550"));
        db.createBricks(new Bricks (18, "Lav" , "BD1550"));   
        db.createBricks(new Bricks (19, "Passiv" , "BD1550"));
        db.createBricks(new Bricks (20, "Terræn" , "BD1550"));
        db.createBricks(new Bricks (21, "Offentlig" , "BD1550"));
        db.createBricks(new Bricks (22, "Intelligent" , "BD1550"));
        db.createBricks(new Bricks (23, "Billig" , "BD1550"));
        db.createBricks(new Bricks (24, "Oplevelse" , "BD1550"));
        db.createBricks(new Bricks (25, "Rytme" , "BD1550"));
        db.createBricks(new Bricks (26, "Udtryk" , "BD1550"));
        db.createBricks(new Bricks (27, "Kaotisk" , "BD1550"));
        db.createBricks(new Bricks (28, "Tyk" , "BD1550"));
        db.createBricks(new Bricks (29, "Aktiv" , "BD1550"));
        db.createBricks(new Bricks (30, "Grønne områder" , "BD1550"));
        db.createBricks(new Bricks (31, "Kold" , "BD1550"));
        db.createBricks(new Bricks (32, "Minimere" , "BD1550"));
        db.createBricks(new Bricks (33, "Vinter" , "BD1550"));
        db.createBricks(new Bricks (34, "Brugerstyring" , "BD1550"));
        db.createBricks(new Bricks (35, "Fortælling" , "BD1550"));
        db.createBricks(new Bricks (36, "Livsstil" , "BD1550"));
        db.createBricks(new Bricks (37, "Symmetri" , "BD1550"));
        db.createBricks(new Bricks (38, "Tynd" , "BD1550"));
        db.createBricks(new Bricks (39, "Stor" , "BD1550"));
        db.createBricks(new Bricks (40, "Nord" , "BD1550"));
        db.createBricks(new Bricks (41, "Varm" , "BD1550"));
        db.createBricks(new Bricks (42, "Fællesskab" , "BD1550"));
        db.createBricks(new Bricks (43, "Sommer" , "BD1550"));
        db.createBricks(new Bricks (44, "Organisk" , "BD1550"));
        db.createBricks(new Bricks (45, "Udsigt" , "BD1550"));
        db.createBricks(new Bricks (46, "Brugere" , "BD1550"));
        db.createBricks(new Bricks (47, "Asymmetri" , "BD1550"));
        db.createBricks(new Bricks (48, "Larm" , "BD1550"));
        db.createBricks(new Bricks (49, "Lille" , "BD1550"));
        db.createBricks(new Bricks (50, "Syd" , "BD1550"));
        db.createBricks(new Bricks (51, "Kontrast" , "BD1550"));
        db.createBricks(new Bricks (52, "Less is more" , "BD1550"));
        db.createBricks(new Bricks (53, "Perception" , "BD1550"));
        db.createBricks(new Bricks (54, "Solen" , "BD1550"));
        db.createBricks(new Bricks (55, "Dagslys" , "BD1550"));
        db.createBricks(new Bricks (56, "Diffus" , "BD1550"));
        db.createBricks(new Bricks (57, "Sundhed" , "BD1550"));
        db.createBricks(new Bricks (58, "Økonomi" , "BD1550"));
        db.createBricks(new Bricks (59, "Fornem" , "BD1550"));
        db.createBricks(new Bricks (60, "xxxxxx" , "BD1550"));
        db.createBricks(new Bricks (61, "Åben" , "BD1550"));
        db.createBricks(new Bricks (62, "Øst" , "BD1550"));
        db.createBricks(new Bricks (63, "Leg" , "BD1550"));
        db.createBricks(new Bricks (64, "Alvorlig" , "BD1550"));
        db.createBricks(new Bricks (65, "Beklædning" , "BD1550"));
        db.createBricks(new Bricks (66, "Regn" , "BD1550"));
        db.createBricks(new Bricks (67, "Tydelig" , "BD1550"));
        db.createBricks(new Bricks (68, "Livskvalitet" , "BD1550"));
        db.createBricks(new Bricks (69, "xxxxxx" , "BD1550"));
        db.createBricks(new Bricks (70, "Nuancer" , "BD1550"));
        db.createBricks(new Bricks (71, "xxxxxx" , "BD1550"));
        db.createBricks(new Bricks (72, "Lukket" , "BD1550"));
        db.createBricks(new Bricks (73, "Vest" , "BD1550"));
        db.createBricks(new Bricks (74, "Humor" , "BD1550"));
        db.createBricks(new Bricks (75, "Højtidelig" , "BD1550"));
        db.createBricks(new Bricks (76, "Lugt" , "BD1550"));	
        db.createBricks(new Bricks (77, "Komfort" , "BD1550"));
        db.createBricks(new Bricks (78, "Rytme" , "BD1550"));
        db.createBricks(new Bricks (79, "xxxxxx" , "BD1550"));
        db.createBricks(new Bricks (80, "xxxxxx" , "BD1550"));	
        db.createBricks(new Bricks (81, "Værdiskabelse" , "BD1550"));
        db.createBricks(new Bricks (82, "xxxxxx" , "BD1550"));
        db.createBricks(new Bricks (83, "Mindmapping" , "BD1550"));
        db.createBricks(new Bricks (84, "Natur" , "BD1550"));
        db.createBricks(new Bricks (85, "Mødested" , "BD1550"));
        db.createBricks(new Bricks (86, "Sikker" , "BD1550"));	
        db.createBricks(new Bricks (87, "Aroma" , "BD1550"));
        db.createBricks(new Bricks (88, "Akustik" , "BD1550"));	
        db.createBricks(new Bricks (89, "Naturlig" , "BD1550"));
        db.createBricks(new Bricks (90, "xxxxxx" , "BD1550"));	
        db.createBricks(new Bricks (91, "xxxxxx" , "BD1550"));
        db.createBricks(new Bricks (92, "Tryghed" , "BD1550"));
        db.createBricks(new Bricks (93, "xxxxxx" , "BD1550"));
        db.createBricks(new Bricks (94, "Benspænd" , "BD1550"));	
        db.createBricks(new Bricks (95, "Introvert" , "BD1550"));
        db.createBricks(new Bricks (96, "Træk" , "BD1550"));	
        db.createBricks(new Bricks (97, "Skæv" , "BD1550"));
        db.createBricks(new Bricks (98, "Principper" , "BD1550"));	
        db.createBricks(new Bricks (99, "funktion" , "BD1550"));
        db.createBricks(new Bricks (100, "Oprørsk" , "BD1550"));
        db.createBricks(new Bricks (101, "xxxxxx" , "BD1550"));	
        db.createBricks(new Bricks (102, "xxxxxx" , "BD1550"));
        db.createBricks(new Bricks (103, "Akustik" , "BD1550"));	
        db.createBricks(new Bricks (104, "xxxxxx" , "BD1550"));
        db.createBricks(new Bricks (105, "Litteratur" , "BD1550"));	
        db.createBricks(new Bricks (106, "Ekstrovert" , "BD1550"));	
        db.createBricks(new Bricks (107, "Orientering" , "BD1550"));
        db.createBricks(new Bricks (108, "ankomst" , "BD1550"));	
        db.createBricks(new Bricks (109, "geometri" , "BD1550"));
        db.createBricks(new Bricks (110, "" , "BD1550"));	
        db.createBricks(new Bricks (111, "" , "BD1550"));	
        db.createBricks(new Bricks (112, "" , "BD1550"));
        db.createBricks(new Bricks (113, "" , "BD1550"));	
        db.createBricks(new Bricks (114, "" , "BD1550"));
        db.createBricks(new Bricks (115, "" , "BD1550"));	

        
		 /**
         * Inserting
         * */
        // Inserting Bricks
        Log.d("Insert: ", "Inserting Lilla Green...");
        
        db.createBricks(new Bricks (1, "" , "Green"));	


		 /**
         * Inserting
         * */
        // Inserting Bricks
        Log.d("Insert: ", "Inserting Lilla Yellow...");
        
        db.createBricks(new Bricks (1, "" , "Yellow"));	

        
        
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
