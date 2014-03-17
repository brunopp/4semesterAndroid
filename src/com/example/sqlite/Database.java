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

public class Database extends  SQLiteOpenHelper {
	
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
	}
		
		// Creating Tables
		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(CREATE_CATEGORY_TABLE);
			db.execSQL(CREATE_BRICKS_TABLE);
			db.execSQL(CREATE_SELECTEDBRICKS_TABLE);
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
		public Category getBrick(int id) {
			SQLiteDatabase db = this.getReadableDatabase();

			Cursor cursor = db.query(TABLE_BRICKS, new String[] { BRICKS_ID,
					BRICKS_NAME, BRICKS_COLOUR }, BRICKS_ID + "=?",
					new String[] { String.valueOf(id) }, null, null, null, null);
			if (cursor != null)
				cursor.moveToFirst();

			Category category = new Category(Integer.parseInt(cursor.getString(0)),
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
	
		public long createSelectedBricks(long c_id, long b_id) {
			SQLiteDatabase db = this.getWritableDatabase();

			ContentValues values = new ContentValues();
			values.put(SELECTEDBRICKS_KID, c_id); 
			values.put(SELECTEDBRICKS_BID, b_id);

			long id = db.insert(TABLE_SELECTEDBRICKS, null, values);

			return id;
		}

		
}
