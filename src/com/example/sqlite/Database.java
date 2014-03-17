package com.example.sqlite;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Bricks;
import com.example.model.Category;
import com.example.model.SelectedBricks;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends  SQLiteOpenHelper {
	
	private Context context;
	
	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 3;
	
	// Database Name
	private static final String DATABASE_NAME = "ConceptManager";

	// Category table name
	private static final String TABLE_CATEGORY = "category";
	
	// Bricks table name
	private static final String TABLE_BRICKS = "bricks";
	
	// Selected bricks table name
	private static final String TABLE_SELECTEDBRICKS = "selectedbricks";
	
	// Category Table Columns names
	private static final String CATEGORY_ID = "c_id";
	private static final String CATEGORY_NAME = "name";
	private static final String CATEGORY_COLOUR = "colour";
	
	// Bricks Table Columns names
	private static final String BRICKS_ID = "b_id";
	private static final String BRICKS_NAME = "name";
	private static final String BRICKS_COLOUR = "colour";
	
	// Selected bricks Table Columns names
	private static final String SELECTEDBRICKS_ID = "s_id";
	private static final String SELECTEDBRICKS_KID = "kId";
	private static final String SELECTEDBRICKS_BID = "bId";
	
	// Category table create statement
	private static final String CREATE_CATEGORY_TABLE = "CREATE TABLE " + TABLE_CATEGORY + "("
			+ CATEGORY_ID + " INTEGER PRIMARY KEY," + CATEGORY_NAME + " TEXT,"
			+ CATEGORY_COLOUR + " TEXT" + ")";
	
	// Bricks table create statement
	private static final String CREATE_BRICKS_TABLE = "CREATE TABLE " + TABLE_BRICKS + "("
			+ BRICKS_ID + " INTEGER PRIMARY KEY," + BRICKS_NAME + " TEXT,"
			+ CATEGORY_COLOUR + " TEXT" + ")";
	
	// Selected bricks table create statement
	private static final String CREATE_SELECTEDBRICKS_TABLE = "CREATE TABLE " + TABLE_SELECTEDBRICKS + "("
			+ SELECTEDBRICKS_ID + " INTEGER PRIMARY KEY," + SELECTEDBRICKS_KID + " INTEGER,"
			+ SELECTEDBRICKS_BID + " INTEGER" + ")";
	
	public Database(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.context = context;
	}
		
		// Creating Tables
		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(CREATE_CATEGORY_TABLE);
			db.execSQL(CREATE_BRICKS_TABLE);
			db.execSQL(CREATE_SELECTEDBRICKS_TABLE);
			
			// Populate database with initial values.
			initializeDatabase();
		}
	
		
		// Upgrading database
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// Drop older table if existed
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORY);
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_BRICKS);
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_SELECTEDBRICKS);

			// Create tables again
			onCreate(db);
		}
		
		// ------------------------ "CATEGORY" table methods ----------------//

		/*
		 * Creating a Category
		 */
		public void createCategory(Category category) {
			SQLiteDatabase db = this.getWritableDatabase();

			ContentValues values = new ContentValues();
			values.put(CATEGORY_ID, category.getId());
			values.put(CATEGORY_NAME, category.getName());
			values.put(CATEGORY_COLOUR, category.getColour());

			// Inserting Row
			db.insert(TABLE_CATEGORY, null, values);
			db.close(); // Closing database connection
		}
		
		/*
		 * Getting a single Category
		 */
		public Category getCategory(int id) {
			SQLiteDatabase db = this.getReadableDatabase();

			Cursor cursor = db.query(TABLE_CATEGORY, new String[] { CATEGORY_ID,
					CATEGORY_NAME, CATEGORY_COLOUR }, CATEGORY_ID + "=?",
					new String[] { String.valueOf(id) }, null, null, null, null);
			if (cursor != null)
				cursor.moveToFirst();

			Category category = new Category(Integer.parseInt(cursor.getString(0)),
					cursor.getString(1), cursor.getString(2));
			// return contact
			return category;
		}
		
		/*
		 * Get all Categories
		 */
		public List<Category> getAllCategories() {
			List<Category> CategoryList = new ArrayList<Category>();
			// Select All Query
			String selectQuery = "SELECT  * FROM " + TABLE_CATEGORY;

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Category category = new Category();
					category.setId(Integer.parseInt(cursor.getString(0)));
					category.setName(cursor.getString(1));
					category.setColour(cursor.getString(2));
					// Adding category to list
					CategoryList.add(category);
				} while (cursor.moveToNext());
			}

			// return contact list
			return CategoryList;
		}
		
		// ------------------------ "Bricks" table methods ----------------//

		/*
		 * Creating a Brick
		 */
		public void createBricks(Bricks bricks) {
			SQLiteDatabase db = this.getWritableDatabase();

			ContentValues values = new ContentValues();
			values.put(BRICKS_ID, bricks.getId());
			values.put(BRICKS_NAME, bricks.getName());
			values.put(BRICKS_COLOUR, bricks.getColour());

			// Inserting Row
			db.insert(TABLE_BRICKS, null, values);
			db.close(); // Closing database connection
		}
		
		/*
		 * Getting a single Brick
		 */
		public Bricks getBrick(int id) {
			SQLiteDatabase db = this.getReadableDatabase();

			Cursor cursor = db.query(TABLE_BRICKS, new String[] { BRICKS_ID,
					BRICKS_NAME, BRICKS_COLOUR }, BRICKS_ID + "=?",
					new String[] { String.valueOf(id) }, null, null, null, null);
			if (cursor != null)
				cursor.moveToFirst();

			Bricks category = new Bricks(Integer.parseInt(cursor.getString(0)),
					cursor.getString(1), cursor.getString(2));
			// return Brick
			return category;
		}
		
		/*
		 * Get all Bricks
		 */
		public List<Bricks> getAllBricks() {
			List<Bricks> BricksList = new ArrayList<Bricks>();
			// Select All Query
			String selectQuery = "SELECT  * FROM " + TABLE_BRICKS;

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Bricks bricks = new Bricks();
					bricks.setId(Integer.parseInt(cursor.getString(0)));
					bricks.setName(cursor.getString(1));
					bricks.setColour(cursor.getString(2));
					// Adding category to list
					BricksList.add(bricks);
				} while (cursor.moveToNext());
			}

			// return contact list
			return BricksList;
		}
		
		// Get all bricks by name
		
		public List<Bricks> getAllBricksByName(String name) {
			List<Bricks> brickList = new ArrayList<Bricks>();

			// get selected query
			String selectQuery = "SELECT * FROM bricks WHERE name like '%" + name + "%'";

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// loop through all rows and add
			if (cursor.moveToFirst()) {
				do {
					Bricks brick = new Bricks();
					brick.setId(Integer.parseInt(cursor.getString(0)));
					brick.setName(cursor.getString(1));
					brick.setColour(cursor.getString(2));
					// tilf�jer Opskrift til listen
					brickList.add(brick);
				} while (cursor.moveToNext());
			}
			// close db
			db.close();
			// return the bricklist
			return brickList;
		}

		// ------------------------ "SelectedBricks" table methods ----------------//
	
		/**
		 * Gets all the selected bricks by category id.
		 * @param categoryId that the bricks belong to.
		 * @return a list containing the category's bricks.
		 */
		public List<Bricks> getSelectedBricks(int categoryId) {
			List<Bricks> bricks = new ArrayList<Bricks>();
			
			// select query
			String selectQuery = "SELECT " + SELECTEDBRICKS_BID + " FROM selectedBricks WHERE " + SELECTEDBRICKS_KID + " = " + categoryId;

			SQLiteDatabase db = this.getWritableDatabase();
			Cursor cursor = db.rawQuery(selectQuery, null);

			// loop through all rows and add
			if (cursor.moveToFirst()) {
				do {
					// Get the brick.
					Bricks b = getBrick(cursor.getInt(0));
					bricks.add(b);
				} while (cursor.moveToNext());
			}
			// close db
			db.close();
			
			return bricks;
		}
		
		public long createSelectedBricks(long c_id, long b_id) {
			SQLiteDatabase db = this.getWritableDatabase();

			ContentValues values = new ContentValues();
			values.put(SELECTEDBRICKS_KID, c_id); 
			values.put(SELECTEDBRICKS_BID, b_id);

			long id = db.insert(TABLE_SELECTEDBRICKS, null, values);

			return id;
		}
		
		public Pair startPage()
		{
			
			ArrayList<Category> resp = new ArrayList<Category>();
			ArrayList<Bricks> brickResp = new ArrayList<Bricks>();
			int katId;
			int briId;
			String query = "select * from selectedbricks";
			
			
			SQLiteDatabase db = this.getWritableDatabase();
			
			Cursor cursor = db.rawQuery(query, null);

			// loop through all rows and add
			if (cursor.moveToFirst()) {
				do {
					katId = Integer.parseInt(cursor.getString(1));
					briId = Integer.parseInt(cursor.getString(2));
					
					Category cat = getCategory(katId);
					Bricks brick = getBrick(briId);
					brickResp.add(brick);
					resp.add(cat);
					
				} while (cursor.moveToNext());
			}
			// close db
			db.close();
			// return the bricklist
			return new Pair(resp, brickResp);
			
		}
		
		public class Pair
		{
		    private ArrayList<Category> array1;
		    private ArrayList<Bricks> array2;
		    public Pair(ArrayList<Category> array1, ArrayList<Bricks> array2)
		    {
		        this.array1 = array1;
		        this.array2 = array2;

		    }
		    public ArrayList<Category> getArray1() { return array1; }
		    public ArrayList<Bricks> getArray2() { return array2; }
		}
		
		

		
		/**
		 * Add values to the database.
		 */
		private void initializeDatabase()
		{
			Database db = new Database(context);

			/**
			 * Inserting
			 * */
			// Inserting Bricks
			Log.d("Insert: ", "Inserting Lilla purple...");
			db.createBricks(new Bricks(1, "Æstetik", "BD1550"));
			db.createBricks(new Bricks(2, "Privat", "BD1550"));
			db.createBricks(new Bricks(3, "Inspiration", "BD1550"));
			db.createBricks(new Bricks(4, "Skygge", "BD1550"));
			db.createBricks(new Bricks(5, "Historie", "BD1550"));
			db.createBricks(new Bricks(6, "Støj", "BD1550"));
			db.createBricks(new Bricks(7, "Modernisme", "BD1550"));
			db.createBricks(new Bricks(8, "Farver", "BD1550"));
			db.createBricks(new Bricks(9, "Stilhed", "BD1550"));
			db.createBricks(new Bricks(10, "Høj", "BD1550"));
			// db.createBricks(new Bricks (11, "Integreret" , "BD1550"));
			// db.createBricks(new Bricks (12, "Trængsel" , "BD1550"));
			// db.createBricks(new Bricks (13, "System" , "BD1550"));
			// db.createBricks(new Bricks (14, "Ekslusiv" , "BD1550"));
			// db.createBricks(new Bricks (15, "Struktur" , "BD1550"));
			// db.createBricks(new Bricks (16, "Overflader" , "BD1550"));
			// db.createBricks(new Bricks (17, "Rolig" , "BD1550"));
			// db.createBricks(new Bricks (18, "Lav" , "BD1550"));
			// db.createBricks(new Bricks (19, "Passiv" , "BD1550"));
			// db.createBricks(new Bricks (20, "Terræn" , "BD1550"));
			// db.createBricks(new Bricks (21, "Offentlig" , "BD1550"));
			// db.createBricks(new Bricks (22, "Intelligent" , "BD1550"));
			// db.createBricks(new Bricks (23, "Billig" , "BD1550"));
			// db.createBricks(new Bricks (24, "Oplevelse" , "BD1550"));
			// db.createBricks(new Bricks (25, "Rytme" , "BD1550"));
			// db.createBricks(new Bricks (26, "Udtryk" , "BD1550"));
			// db.createBricks(new Bricks (27, "Kaotisk" , "BD1550"));
			// db.createBricks(new Bricks (28, "Tyk" , "BD1550"));
			// db.createBricks(new Bricks (29, "Aktiv" , "BD1550"));
			// db.createBricks(new Bricks (30, "Grønne områder" , "BD1550"));
			// db.createBricks(new Bricks (31, "Kold" , "BD1550"));
			// db.createBricks(new Bricks (32, "Minimere" , "BD1550"));
			// db.createBricks(new Bricks (33, "Vinter" , "BD1550"));
			// db.createBricks(new Bricks (34, "Brugerstyring" , "BD1550"));
			// db.createBricks(new Bricks (35, "Fortælling" , "BD1550"));
			// db.createBricks(new Bricks (36, "Livsstil" , "BD1550"));
			// db.createBricks(new Bricks (37, "Symmetri" , "BD1550"));
			// db.createBricks(new Bricks (38, "Tynd" , "BD1550"));
			// db.createBricks(new Bricks (39, "Stor" , "BD1550"));
			// db.createBricks(new Bricks (40, "Nord" , "BD1550"));
			// db.createBricks(new Bricks (41, "Varm" , "BD1550"));
			// db.createBricks(new Bricks (42, "Fællesskab" , "BD1550"));
			// db.createBricks(new Bricks (43, "Sommer" , "BD1550"));
			// db.createBricks(new Bricks (44, "Organisk" , "BD1550"));
			// db.createBricks(new Bricks (45, "Udsigt" , "BD1550"));
			// db.createBricks(new Bricks (46, "Brugere" , "BD1550"));
			// db.createBricks(new Bricks (47, "Asymmetri" , "BD1550"));
			// db.createBricks(new Bricks (48, "Larm" , "BD1550"));
			// db.createBricks(new Bricks (49, "Lille" , "BD1550"));
			// db.createBricks(new Bricks (51, "Kontrast" , "BD1550"));
			// db.createBricks(new Bricks (52, "Less is more" , "BD1550"));
			// db.createBricks(new Bricks (53, "Perception" , "BD1550"));
			// db.createBricks(new Bricks (54, "Solen" , "BD1550"));
			// db.createBricks(new Bricks (55, "Dagslys" , "BD1550"));
			// db.createBricks(new Bricks (56, "Diffus" , "BD1550"));
			// db.createBricks(new Bricks (57, "Sundhed" , "BD1550"));
			// db.createBricks(new Bricks (58, "Økonomi" , "BD1550"));
			// db.createBricks(new Bricks (59, "Fornem" , "BD1550"));
			// db.createBricks(new Bricks (60, "xxxxxx" , "BD1550"));
			// db.createBricks(new Bricks (61, "Åben" , "BD1550"));
			// db.createBricks(new Bricks (62, "Øst" , "BD1550"));
			// db.createBricks(new Bricks (63, "Leg" , "BD1550"));
			// db.createBricks(new Bricks (64, "Alvorlig" , "BD1550"));
			// db.createBricks(new Bricks (65, "Beklædning" , "BD1550"));
			// db.createBricks(new Bricks (66, "Regn" , "BD1550"));
			// db.createBricks(new Bricks (67, "Tydelig" , "BD1550"));
			// db.createBricks(new Bricks (68, "Livskvalitet" , "BD1550"));
			// db.createBricks(new Bricks (69, "xxxxxx" , "BD1550"));
			// db.createBricks(new Bricks (70, "Nuancer" , "BD1550"));
			// db.createBricks(new Bricks (71, "xxxxxx" , "BD1550"));
			// db.createBricks(new Bricks (72, "Lukket" , "BD1550"));
			// db.createBricks(new Bricks (73, "Vest" , "BD1550"));
			// db.createBricks(new Bricks (74, "Humor" , "BD1550"));
			// db.createBricks(new Bricks (75, "Højtidelig" , "BD1550"));
			// db.createBricks(new Bricks (76, "Lugt" , "BD1550"));
			// db.createBricks(new Bricks (77, "Komfort" , "BD1550"));
			// db.createBricks(new Bricks (78, "Rytme" , "BD1550"));
			// db.createBricks(new Bricks (79, "xxxxxx" , "BD1550"));
			// db.createBricks(new Bricks (80, "xxxxxx" , "BD1550"));
			// db.createBricks(new Bricks (81, "Værdiskabelse" , "BD1550"));
			// db.createBricks(new Bricks (82, "xxxxxx" , "BD1550"));
			// db.createBricks(new Bricks (83, "Mindmapping" , "BD1550"));
			// db.createBricks(new Bricks (84, "Natur" , "BD1550"));
			// db.createBricks(new Bricks (85, "Mødested" , "BD1550"));
			// db.createBricks(new Bricks (86, "Sikker" , "BD1550"));
			// db.createBricks(new Bricks (87, "Aroma" , "BD1550"));
			// db.createBricks(new Bricks (88, "Akustik" , "BD1550"));
			// db.createBricks(new Bricks (89, "Naturlig" , "BD1550"));
			// db.createBricks(new Bricks (90, "xxxxxx" , "BD1550"));
			// db.createBricks(new Bricks (91, "xxxxxx" , "BD1550"));
			// db.createBricks(new Bricks (92, "Tryghed" , "BD1550"));
			// db.createBricks(new Bricks (93, "xxxxxx" , "BD1550"));
			// db.createBricks(new Bricks (94, "Benspænd" , "BD1550"));
			// db.createBricks(new Bricks (95, "Introvert" , "BD1550"));
			// db.createBricks(new Bricks (96, "Træk" , "BD1550"));
			// db.createBricks(new Bricks (97, "Skæv" , "BD1550"));
			// db.createBricks(new Bricks (98, "Principper" , "BD1550"));
			// db.createBricks(new Bricks (99, "funktion" , "BD1550"));
			// db.createBricks(new Bricks (100, "Oprørsk" , "BD1550"));
			// db.createBricks(new Bricks (101, "xxxxxx" , "BD1550"));
			// db.createBricks(new Bricks (102, "xxxxxx" , "BD1550"));
			// db.createBricks(new Bricks (103, "Akustik" , "BD1550"));
			// db.createBricks(new Bricks (104, "xxxxxx" , "BD1550"));
			// db.createBricks(new Bricks (105, "Litteratur" , "BD1550"));
			// db.createBricks(new Bricks (106, "Ekstrovert" , "BD1550"));
			// db.createBricks(new Bricks (107, "Orientering" , "BD1550"));
			// db.createBricks(new Bricks (108, "ankomst" , "BD1550"));
			// db.createBricks(new Bricks (109, "geometri" , "BD1550"));
			// db.createBricks(new Bricks (110, "Syd" , "BD1550"));
			//
			/**
			 * Inserting
			 * */

			// Inserting Bricks
			Log.d("Insert: ", "Inserting Lilla Green...");

			db.createBricks(new Bricks(111, "Brand", "8A9B0F"));
			db.createBricks(new Bricks(112, "Adgangsforhold", "8A9B0F"));
			db.createBricks(new Bricks(113, "Problemanalyse", "8A9B0F"));
			db.createBricks(new Bricks(114, "Klimateknik", "8A9B0F"));
			db.createBricks(new Bricks(115, "Storsp�nd", "8A9B0F"));
			db.createBricks(new Bricks(116, "Kuldebro", "8A9B0F"));
			db.createBricks(new Bricks(117, "LCA", "8A9B0F"));
			db.createBricks(new Bricks(118, "Byggesystemer", "8A9B0F"));
			db.createBricks(new Bricks(119, "Handicapforhold", "8A9B0F"));
			db.createBricks(new Bricks(120, "Statisk system", "8A9B0F"));
			db.createBricks(new Bricks(121, "Konstruktion", "8A9B0F"));
			db.createBricks(new Bricks(122, "Installationer", "8A9B0F"));
			db.createBricks(new Bricks(123, "�konomi", "8A9B0F"));
			db.createBricks(new Bricks(124, "Drift", "8A9B0F"));
			db.createBricks(new Bricks(125, "Organisation", "8A9B0F"));
			db.createBricks(new Bricks(126, "BR 15", "8A9B0F"));
			// db.createBricks(new Bricks (127, "BR 20" , "8A9B0F"));
			// db.createBricks(new Bricks (128, "Vugge til vugge" , "8A9B0F"));
			// db.createBricks(new Bricks (129, "Varmetilskud" , "8A9B0F"));
			// db.createBricks(new Bricks (130, "Energi" , "8A9B0F"));
			// db.createBricks(new Bricks (131, "Vindm�ller" , "8A9B0F"));
			// db.createBricks(new Bricks (132, "Gr�n tag" , "8A9B0F"));
			// db.createBricks(new Bricks (133, "Ventilation" , "8A9B0F"));
			// db.createBricks(new Bricks (134, "Plug & play" , "8A9B0F"));
			// db.createBricks(new Bricks (135, "80/ 20" , "8A9B0F"));
			// db.createBricks(new Bricks (136, "Kraftforl�b" , "8A9B0F"));
			// db.createBricks(new Bricks (137, "Lean" , "8A9B0F"));
			// db.createBricks(new Bricks (138, "Mass Customization" , "8A9B0F"));
			// db.createBricks(new Bricks (139, "Passive virkemidler" , "8A9B0F"));
			// db.createBricks(new Bricks (140, "Snelast" , "8A9B0F"));
			// db.createBricks(new Bricks (141, "Nyttelast" , "8A9B0F"));
			// db.createBricks(new Bricks (142, "Egenlast" , "8A9B0F"));
			// db.createBricks(new Bricks (143, "Rumprogram" , "8A9B0F"));
			// db.createBricks(new Bricks (144, "Funktionsdiagram" , "8A9B0F"));
			// db.createBricks(new Bricks (145, "Temperatur" , "8A9B0F"));
			// db.createBricks(new Bricks (146, "Luftskifte" , "8A9B0F"));
			// db.createBricks(new Bricks (147, "Naturlig ventilation" , "8A9B0F"));
			// db.createBricks(new Bricks (148, "Overophedning" , "8A9B0F"));
			// db.createBricks(new Bricks (149, "U-v�rdi" , "8A9B0F"));
			// db.createBricks(new Bricks (150, "Fugt" , "8A9B0F"));
			// db.createBricks(new Bricks (151, "Produktion" , "8A9B0F"));
			// db.createBricks(new Bricks (152, "Genbrug" , "8A9B0F"));
			// db.createBricks(new Bricks (153, "Bygningsdesign" , "8A9B0F"));
			// db.createBricks(new Bricks (154, "3D modellering" , "8A9B0F"));
			// db.createBricks(new Bricks (155, "BIM" , "8A9B0F"));
			// db.createBricks(new Bricks (156, "Revit" , "8A9B0F"));
			// db.createBricks(new Bricks (157, "Adgangsforhold" , "8A9B0F"));
			// db.createBricks(new Bricks (158, "Regulativer" , "8A9B0F"));
			// db.createBricks(new Bricks (159, "Forretning" , "8A9B0F"));
			// db.createBricks(new Bricks (160, "Montage" , "8A9B0F"));
			// db.createBricks(new Bricks (161, "Lovgivning" , "8A9B0F"));
			// db.createBricks(new Bricks (162, "Naturgas" , "8A9B0F"));
			// db.createBricks(new Bricks (163, "A kraft" , "8A9B0F"));
			// db.createBricks(new Bricks (164, "Radiator" , "8A9B0F"));
			// db.createBricks(new Bricks (165, "Genv�kst" , "8A9B0F"));
			// db.createBricks(new Bricks (166, "Vindenergi" , "8A9B0F"));
			// db.createBricks(new Bricks (167, "Digital signatur" , "8A9B0F"));
			// db.createBricks(new Bricks (168, "Konfigurering" , "8A9B0F"));
			// db.createBricks(new Bricks (169, "Termisk masse" , "8A9B0F"));
			// db.createBricks(new Bricks (170, "Solfanger" , "8A9B0F"));
			// db.createBricks(new Bricks (171, "Klima" , "8A9B0F"));
			// db.createBricks(new Bricks (172, "Mekanisk ventilation" , "8A9B0F"));
			// db.createBricks(new Bricks (173, "Naturlig ventilation" , "8A9B0F"));
			// db.createBricks(new Bricks (174, "Overophedning" , "8A9B0F"));
			// db.createBricks(new Bricks (175, "Str�levarme" , "8A9B0F"));
			// db.createBricks(new Bricks (176, "Afsk�rmning" , "8A9B0F"));
			// db.createBricks(new Bricks (177, "Levedygtig" , "8A9B0F"));
			// db.createBricks(new Bricks (178, "�konomi" , "8A9B0F"));
			// db.createBricks(new Bricks (179, "Lokal energi" , "8A9B0F"));
			// db.createBricks(new Bricks (180, "Belysning" , "8A9B0F"));
			// db.createBricks(new Bricks (181, "Levetid" , "8A9B0F"));
			// db.createBricks(new Bricks (182, "Komfort temperatur" , "8A9B0F"));
			// db.createBricks(new Bricks (183, "CO2 udledning" , "8A9B0F"));
			// db.createBricks(new Bricks (184, "Total�konomi" , "8A9B0F"));
			// db.createBricks(new Bricks (185, "Levetidsomkostninger" , "8A9B0F"));
			// db.createBricks(new Bricks (186, "Totalv�rdi" , "8A9B0F"));
			// db.createBricks(new Bricks (187, "H�ndtering af brugsvand" ,
			// "8A9B0F"));
			// db.createBricks(new Bricks (188, "H�ndtering af spildevand" ,
			// "8A9B0F"));
			// db.createBricks(new Bricks (189, "H�ndtering af regnvand" ,
			// "8A9B0F"));

			/**
			 * Inserting
			 * */
			// Inserting Bricks
			Log.d("Insert: ", "Inserting Lilla Yellow...");

			db.createBricks(new Bricks(190, "+", "F8CB00"));
			db.createBricks(new Bricks(191, "-", "F8CB00"));
			db.createBricks(new Bricks(192, "=", "F8CB00"));
			db.createBricks(new Bricks(193, "?", "F8CB00"));
			db.createBricks(new Bricks(194, "+", "F8CB00"));
			db.createBricks(new Bricks(195, "Kalk", "F8CB00"));
			db.createBricks(new Bricks(196, "M�rtel", "F8CB00"));
			db.createBricks(new Bricks(197, "Plastfolie", "F8CB00"));
			db.createBricks(new Bricks(198, "Cement", "F8CB00"));
			db.createBricks(new Bricks(199, "Sand", "F8CB00"));
			db.createBricks(new Bricks(200, "Kork", "F8CB00"));
			db.createBricks(new Bricks(201, "Kalksten", "F8CB00"));
			db.createBricks(new Bricks(202, "Tapet", "F8CB00"));
			// db.createBricks(new Bricks (203, "Ler" , "F8CB00"));
			// db.createBricks(new Bricks (204, "Papir" , "F8CB00"));
			// db.createBricks(new Bricks (205, "Marmor" , "F8CB00"));
			// db.createBricks(new Bricks (206, "Vand" , "F8CB00"));
			// db.createBricks(new Bricks (207, "Luft" , "F8CB00"));
			// db.createBricks(new Bricks (208, "Bly" , "F8CB00"));
			// db.createBricks(new Bricks (209, "Stilhed" , "F8CB00"));
			// db.createBricks(new Bricks (210, "Rolig" , "F8CB00"));
			// db.createBricks(new Bricks (211, "Kaotisk" , "F8CB00"));
			// db.createBricks(new Bricks (212, "Symmetri" , "F8CB00"));
			// db.createBricks(new Bricks (213, "Asymmetri" , "F8CB00"));
			// db.createBricks(new Bricks (214, "Flamingo" , "F8CB00"));

			/**
			 * Inserting
			 * */
			// Inserting Bricks
			Log.d("Insert: ", "Inserting Lilla Orange...");

			db.createBricks(new Bricks(215, "Kontor", "E87F00"));
			db.createBricks(new Bricks(216, "Atrium", "E87F00"));
			db.createBricks(new Bricks(217, "Teknikrum", "E87F00"));
			db.createBricks(new Bricks(218, "V�relse", "E87F00"));
			db.createBricks(new Bricks(219, "K�lder", "E87F00"));
			db.createBricks(new Bricks(220, "St�j", "E87F00"));
			db.createBricks(new Bricks(221, "Lejligheder", "E87F00"));
			db.createBricks(new Bricks(222, "Terasse", "E87F00"));
			db.createBricks(new Bricks(223, "K�kken", "E87F00"));
			db.createBricks(new Bricks(224, "Have", "E87F00"));
			db.createBricks(new Bricks(225, "Udhus", "E87F00"));
			// db.createBricks(new Bricks (226, "Depot" , "E87F00"));
			// db.createBricks(new Bricks (227, "Penthouse" , "E87F00"));
			// db.createBricks(new Bricks (228, "Badev�relse" , "E87F00"));
			// db.createBricks(new Bricks (229, "Toilet" , "E87F00"));
			// db.createBricks(new Bricks (230, "Udestue" , "E87F00"));
			// db.createBricks(new Bricks (231, "Garderobe" , "E87F00"));
			// db.createBricks(new Bricks (232, "Bryggers" , "E87F00"));
			// db.createBricks(new Bricks (233, "Forskudte planer" , "E87F00"));
			// db.createBricks(new Bricks (234, "Rammer" , "E87F00"));
			// db.createBricks(new Bricks (235, "F�llesarealer" , "E87F00"));
			// db.createBricks(new Bricks (236, "Opgang" , "E87F00"));
			// db.createBricks(new Bricks (237, "Vindue" , "E87F00"));
			// db.createBricks(new Bricks (238, "D�re" , "E87F00"));
			// db.createBricks(new Bricks (239, "Interi�r" , "E87F00"));
			// db.createBricks(new Bricks (240, "S�jler" , "E87F00"));
			// db.createBricks(new Bricks (241, "Gulv" , "E87F00"));
			// db.createBricks(new Bricks (242, "M�bler" , "E87F00"));
			// db.createBricks(new Bricks (243, "Elementer" , "E87F00"));
			// db.createBricks(new Bricks (244, "Facade" , "E87F00"));
			// db.createBricks(new Bricks (245, "Bj�lker" , "E87F00"));
			// db.createBricks(new Bricks (246, "Plader" , "E87F00"));
			// db.createBricks(new Bricks (247, "Trappe" , "E87F00"));
			// db.createBricks(new Bricks (248, "Tag" , "E87F00"));
			// db.createBricks(new Bricks (249, "D�k" , "E87F00"));
			// db.createBricks(new Bricks (250, "Loft" , "E87F00"));
			// db.createBricks(new Bricks (251, "Elevator" , "E87F00"));
			// db.createBricks(new Bricks (252, "Gang" , "E87F00"));
			// db.createBricks(new Bricks (253, "Overnlysvindue" , "E87F00"));
			// db.createBricks(new Bricks (254, "Balkon" , "E87F00"));
			// db.createBricks(new Bricks (255, "Affaldsskakt" , "E87F00"));
			// db.createBricks(new Bricks (256, "V�dzoner" , "E87F00"));
			// db.createBricks(new Bricks (257, "F�ringsveje" , "E87F00"));
			// db.createBricks(new Bricks (258, "Solpaneler" , "E87F00"));
			// db.createBricks(new Bricks (259, "V�g" , "E87F00"));
			// db.createBricks(new Bricks (260, "Solceller" , "E87F00"));
			// db.createBricks(new Bricks (261, "Gr�nt tag" , "E87F00"));
			// db.createBricks(new Bricks (262, "Drivhus" , "E87F00"));
			// db.createBricks(new Bricks (263, "V�ksthus" , "E87F00"));
			// db.createBricks(new Bricks (264, "Korridor" , "E87F00"));
			// db.createBricks(new Bricks (265, "Hal" , "E87F00"));
			// db.createBricks(new Bricks (266, "Kantine" , "E87F00"));
			// db.createBricks(new Bricks (267, "Garage" , "E87F00"));
			// db.createBricks(new Bricks (268, "B�rnev�relse" , "E87F00"));
			// db.createBricks(new Bricks (269, "Sovev�relse" , "E87F00"));
			// db.createBricks(new Bricks (270, "Walk in" , "E87F00"));
			// db.createBricks(new Bricks (271, "Sauna" , "E87F00"));
			// db.createBricks(new Bricks (272, "Fordelingsareal" , "E87F00"));
			// db.createBricks(new Bricks (273, "Bibliotek" , "E87F00"));
			// db.createBricks(new Bricks (274, "Venterum" , "E87F00"));
			// db.createBricks(new Bricks (275, "Reception" , "E87F00"));
			// db.createBricks(new Bricks (276, "M�delokaler" , "E87F00"));
			// db.createBricks(new Bricks (277, "Aktivitetsrum" , "E87F00"));
			// db.createBricks(new Bricks (278, "V�rksted" , "E87F00"));
			// db.createBricks(new Bricks (279, "Loftrum" , "E87F00"));
			// db.createBricks(new Bricks (280, "Hems" , "E87F00"));
			// db.createBricks(new Bricks (281, "Repos" , "E87F00"));
			// db.createBricks(new Bricks (282, "Skorsten" , "E87F00"));
			// db.createBricks(new Bricks (283, "Tung v�g" , "E87F00"));
			// db.createBricks(new Bricks (284, "Let v�g" , "E87F00"));
			// db.createBricks(new Bricks (285, "Lager" , "E87F00"));
			// db.createBricks(new Bricks (286, "Redskabsskur" , "E87F00"));
			// db.createBricks(new Bricks (287, "Skur" , "E87F00"));
			// db.createBricks(new Bricks (288, "Hall" , "E87F00"));
			// db.createBricks(new Bricks (289, "Entre" , "E87F00"));
			// db.createBricks(new Bricks (290, "Forgang" , "E87F00"));
			// db.createBricks(new Bricks (291, "Baggang" , "E87F00"));
			// db.createBricks(new Bricks (292, "G�stetoilet" , "E87F00"));
			// db.createBricks(new Bricks (293, "Yderv�g" , "E87F00"));
			// db.createBricks(new Bricks (294, "Inderv�g" , "E87F00"));
			// db.createBricks(new Bricks (295, "Indk�rsel" , "E87F00"));
			// db.createBricks(new Bricks (296, "Plads" , "E87F00"));
			// db.createBricks(new Bricks (297, "Fortorv" , "E87F00"));
			// db.createBricks(new Bricks (298, "Torvet" , "E87F00"));
			// db.createBricks(new Bricks (299, "Mursten" , "E87F00"));
			// db.createBricks(new Bricks (300, "Glas" , "E87F00"));
			// db.createBricks(new Bricks (301, "Beton" , "E87F00"));
			// db.createBricks(new Bricks (302, "Eternit" , "E87F00"));
			// db.createBricks(new Bricks (303, "Isolering" , "E87F00"));
			// db.createBricks(new Bricks (304, "Tagpap" , "E87F00"));
			// db.createBricks(new Bricks (305, "Tegl" , "E87F00"));
			// db.createBricks(new Bricks (306, "Jern" , "E87F00"));
			// db.createBricks(new Bricks (307, "Tr�" , "E87F00"));
			// db.createBricks(new Bricks (308, "St�l" , "E87F00"));
			// db.createBricks(new Bricks (309, "Kobber" , "E87F00"));
			// db.createBricks(new Bricks (310, "Composit" , "E87F00"));
			// db.createBricks(new Bricks (311, "Glasfiber" , "E87F00"));
			// db.createBricks(new Bricks (312, "Plastik" , "E87F00"));
			// db.createBricks(new Bricks (313, "Bambus" , "E87F00"));
			// db.createBricks(new Bricks (314, "Tekstil" , "E87F00"));
			// db.createBricks(new Bricks (315, "Gummi" , "E87F00"));
			// db.createBricks(new Bricks (316, "Skifer" , "E87F00"));
			// db.createBricks(new Bricks (317, "Zink" , "E87F00"));
			// db.createBricks(new Bricks (318, "Klinker" , "E87F00"));
			// db.createBricks(new Bricks (319, "Linolium" , "E87F00"));
			// db.createBricks(new Bricks (320, "Uld" , "E87F00"));
			// db.createBricks(new Bricks (321, "Granit" , "E87F00"));
			// db.createBricks(new Bricks (322, "Halm" , "E87F00"));
			// db.createBricks(new Bricks (323, "Gips" , "E87F00"));
			// db.createBricks(new Bricks (324, "Jord" , "E87F00"));
			// db.createBricks(new Bricks (325, "Grus" , "E87F00"));
			// db.createBricks(new Bricks (326, "Aluminium" , "E87F00"));
			// db.createBricks(new Bricks (327, "Polystyren" , "E87F00"));
			// db.createBricks(new Bricks (328, "Muslingeskaller" , "E87F00"));
			// db.createBricks(new Bricks (329, "Legan�dder" , "E87F00"));

			/**
			 * Inserting
			 * */
			// Inserting Categories
			Log.d("Insert: ", "Inserting Categories...");
			db.createCategory(new Category(1, "Arkitektur", "Hvid"));
			db.createCategory(new Category(2, "Brugere/Funktion", "Sand"));
			db.createCategory(new Category(3, "Industralisering", "Lyserblå"));
			db.createCategory(new Category(4, "Energidesign", "MørkSort"));
			db.createCategory(new Category(5, "Økonomi", "Mørkebrun"));
			db.createCategory(new Category(6, "Stabilitet", "Brun"));
			db.createCategory(new Category(7, "Stedet", "Lysergrå"));
			db.createCategory(new Category(8, "Tekniske installioner", "grå"));
		}
}
