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
			
			initializeDatabase(db);
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
		private void createCategory(Category category, SQLiteDatabase db) {
			ContentValues values = new ContentValues();
			values.put(CATEGORY_ID, category.getId());
			values.put(CATEGORY_NAME, category.getName());
			values.put(CATEGORY_COLOUR, category.getColour());
			
			// Inserting Row
			db.insert(TABLE_CATEGORY, null, values);
		}
		
		/*
		 * Creating a Category
		 */
		public void createCategory(Category category) {
			SQLiteDatabase db = this.getWritableDatabase();
			createCategory(category, db);
			db.close();
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
		public void createBricks(Bricks bricks, SQLiteDatabase db) {
			
			ContentValues values = new ContentValues();
			values.put(BRICKS_ID, bricks.getId());
			values.put(BRICKS_NAME, bricks.getName());
			values.put(BRICKS_COLOUR, bricks.getColour());

			// Inserting Row
			db.insert(TABLE_BRICKS, null, values);
		}
		
		/*
		 * Creating a Brick
		 */
		public void createBricks(Bricks bricks) {
			SQLiteDatabase db = this.getWritableDatabase();
			createBricks(bricks, db);
			db.close();
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

		
		/**
		 * Add values to the database.
		 */
		private void initializeDatabase(SQLiteDatabase db)
		{
			/**
			 * Inserting
			 * */
			// Inserting Bricks
			Log.d("Insert: ", "Inserting Lilla purple...");
			createBricks(new Bricks(1, "Æstetik", "BD1550"), db);
			createBricks(new Bricks(2, "Privat", "BD1550"), db);
			createBricks(new Bricks(3, "Inspiration", "BD1550"), db);
			createBricks(new Bricks(4, "Skygge", "BD1550"), db);
			createBricks(new Bricks(5, "Historie", "BD1550"), db);
			createBricks(new Bricks(6, "Støj", "BD1550"), db);
			createBricks(new Bricks(7, "Modernisme", "BD1550"), db);
			createBricks(new Bricks(8, "Farver", "BD1550"), db);
			createBricks(new Bricks(9, "Stilhed", "BD1550"), db);
			createBricks(new Bricks(10, "Høj", "BD1550"), db);
			/**
			 * Inserting
			 * */

			// Inserting Bricks
			Log.d("Insert: ", "Inserting Lilla Green...");

			createBricks(new Bricks(111, "Brand", "8A9B0F"), db);
			createBricks(new Bricks(112, "Adgangsforhold", "8A9B0F"), db);
			createBricks(new Bricks(113, "Problemanalyse", "8A9B0F"), db);
			createBricks(new Bricks(114, "Klimateknik", "8A9B0F"), db);
			createBricks(new Bricks(115, "Storsp�nd", "8A9B0F"), db);
			createBricks(new Bricks(116, "Kuldebro", "8A9B0F"), db);
			createBricks(new Bricks(117, "LCA", "8A9B0F"), db);
			createBricks(new Bricks(118, "Byggesystemer", "8A9B0F"), db);
			createBricks(new Bricks(119, "Handicapforhold", "8A9B0F"), db);
			createBricks(new Bricks(120, "Statisk system", "8A9B0F"), db);
			createBricks(new Bricks(121, "Konstruktion", "8A9B0F"), db);
			createBricks(new Bricks(122, "Installationer", "8A9B0F"), db);
			createBricks(new Bricks(123, "Økonomi", "8A9B0F"), db);
			createBricks(new Bricks(124, "Drift", "8A9B0F"), db);
			createBricks(new Bricks(125, "Organisation", "8A9B0F"), db);
			createBricks(new Bricks(126, "BR 15", "8A9B0F"), db);

			/**
			 * Inserting
			 * */
			// Inserting Bricks
			Log.d("Insert: ", "Inserting Lilla Yellow...");

			createBricks(new Bricks(190, "+", "F8CB00"), db);
			createBricks(new Bricks(191, "-", "F8CB00"), db);
			createBricks(new Bricks(192, "=", "F8CB00"), db);
			createBricks(new Bricks(193, "?", "F8CB00"), db);
			createBricks(new Bricks(194, "+", "F8CB00"), db);
			createBricks(new Bricks(195, "Kalk", "F8CB00"), db);
			createBricks(new Bricks(196, "Mørtel", "F8CB00"), db);
			createBricks(new Bricks(197, "Plastfolie", "F8CB00"), db);
			createBricks(new Bricks(198, "Cement", "F8CB00"), db);
			createBricks(new Bricks(199, "Sand", "F8CB00"), db);
			createBricks(new Bricks(200, "Kork", "F8CB00"), db);
			createBricks(new Bricks(201, "Kalksten", "F8CB00"), db);
			createBricks(new Bricks(202, "Tapet", "F8CB00"), db);

			/**
			 * Inserting
			 * */
			// Inserting Bricks
			Log.d("Insert: ", "Inserting Lilla Orange...");

			createBricks(new Bricks(215, "Kontor", "E87F00"), db);
			createBricks(new Bricks(216, "Atrium", "E87F00"), db);
			createBricks(new Bricks(217, "Teknikrum", "E87F00"), db);
			createBricks(new Bricks(218, "Værelse", "E87F00"), db);
			createBricks(new Bricks(219, "Kælder", "E87F00"), db);
			createBricks(new Bricks(220, "Støj", "E87F00"), db);
			createBricks(new Bricks(221, "Lejligheder", "E87F00"), db);
			createBricks(new Bricks(222, "Terasse", "E87F00"), db);
			createBricks(new Bricks(223, "Køkken", "E87F00"), db);
			createBricks(new Bricks(224, "Have", "E87F00"), db);
			createBricks(new Bricks(225, "Udhus", "E87F00"), db);

			/**
			 * Inserting
			 * */
			// Inserting Categories
			Log.d("Insert: ", "Inserting Categories...");
			createCategory(new Category(1, "Arkitektur", "Hvid"), db);
			createCategory(new Category(2, "Brugere/Funktion", "Sand"), db);
			createCategory(new Category(3, "Industralisering", "Lyserblå"), db);
			createCategory(new Category(4, "Energidesign", "MørkSort"), db);
			createCategory(new Category(5, "Økonomi", "Mørkebrun"), db);
			createCategory(new Category(6, "Stabilitet", "Brun"), db);
			createCategory(new Category(7, "Stedet", "Lysergrå"), db);
			createCategory(new Category(8, "Tekniske installioner", "grå"), db);
		}
}
