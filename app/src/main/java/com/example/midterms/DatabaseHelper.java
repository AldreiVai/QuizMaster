package com.example.midterms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "login_signup.db";
    private static final int DATABASE_VERSION = 4;

    public static final String TABLE_USERS = "users";
    private static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_COINS = "coins";
    public static final String COLUMN_X2SCORE = "x2score";
    public static final String COLUMN_SKIP = "skip";

    public static final String COLUMN_THIRTY_SECONDS= "thirty_seconds";
    public static final String COLUMN_COMPUTER_EASY_SCORE = "computer_easy_score";
    public static final String COLUMN_COMPUTER_MEDIUM_SCORE = "computer_medium_score";
    public static final String COLUMN_COMPUTER_HARD_SCORE = "computer_hard_score";
    public static final String COLUMN_TRIVIA_EASY_SCORE = "trivia_easy_score";
    public static final String COLUMN_TRIVIA_MEDIUM_SCORE = "trivia_medium_score";
    public static final String COLUMN_TRIVIA_HARD_SCORE = "trivia_hard_score";
    public static final String COLUMN_MUSIC_EASY_SCORE = "music_easy_score";
    public static final String COLUMN_MUSIC_MEDIUM_SCORE = "music_medium_score";
    public static final String COLUMN_MUSIC_HARD_SCORE = "music_hard_score";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_USERNAME + " TEXT,"
                + COLUMN_PASSWORD + " TEXT,"
                + COLUMN_COINS + " INTEGER DEFAULT 0,"
                + COLUMN_X2SCORE + " INTEGER DEFAULT 0,"
                + COLUMN_SKIP + " INTEGER DEFAULT 0,"
                + COLUMN_THIRTY_SECONDS + " INTEGER DEFAULT 0,"
                + COLUMN_COMPUTER_EASY_SCORE + " INTEGER DEFAULT 0,"
                + COLUMN_COMPUTER_MEDIUM_SCORE + " INTEGER DEFAULT 0,"
                + COLUMN_COMPUTER_HARD_SCORE + " INTEGER DEFAULT 0,"
                + COLUMN_TRIVIA_EASY_SCORE + " INTEGER DEFAULT 0,"
                + COLUMN_TRIVIA_MEDIUM_SCORE + " INTEGER DEFAULT 0,"
                + COLUMN_TRIVIA_HARD_SCORE + " INTEGER DEFAULT 0,"
                + COLUMN_MUSIC_EASY_SCORE + " INTEGER DEFAULT 0,"
                + COLUMN_MUSIC_MEDIUM_SCORE + " INTEGER DEFAULT 0,"
                + COLUMN_MUSIC_HARD_SCORE + " INTEGER DEFAULT 0"
                + ")";
        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if exists and recreate the table
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    // Method to add a new user to the database
    public void addUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_PASSWORD, password);

        db.insert(TABLE_USERS, null, values);
        db.close();
    }

    // Method to check if a username already exists in the database
    public boolean isUsernameExists(String username) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = COLUMN_USERNAME + " = ?";
        String[] selectionArgs = {username};

        Cursor cursor = db.query(TABLE_USERS, null, selection, selectionArgs, null, null, null);
        boolean exists = cursor.moveToFirst();
        cursor.close();
        db.close();

        return exists;
    }

    // Method to validate login credentials
    public boolean login(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selection = COLUMN_USERNAME + " = ? AND " + COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query(TABLE_USERS, null, selection, selectionArgs, null, null, null);
        boolean loginSuccessful = cursor.moveToFirst();
        cursor.close();
        db.close();

        return loginSuccessful;
    }






    // Method to update the computer easy score for a user
    public void updateComputerEasyScore(String username, int score) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_COMPUTER_EASY_SCORE, score);

        String whereClause = COLUMN_USERNAME + " = ?";
        String[] whereArgs = {username};

        db.update(TABLE_USERS, values, whereClause, whereArgs);
        db.close();
    }

    // Method to update the computer medium score for a user
    public void updateComputerMediumScore(String username, int score) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_COMPUTER_MEDIUM_SCORE, score);

        String whereClause = COLUMN_USERNAME + " = ?";
        String[] whereArgs = {username};

        db.update(TABLE_USERS, values, whereClause, whereArgs);
        db.close();
    }

    // Method to update the computer hard score for a user
    public void updateComputerHardScore(String username, int score) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_COMPUTER_HARD_SCORE, score);

        String whereClause = COLUMN_USERNAME + " = ?";
        String[] whereArgs = {username};

        db.update(TABLE_USERS, values, whereClause, whereArgs);
        db.close();
    }

    // Method to update the trivia easy score for a user
    public void updateTriviaEasyScore(String username, int score) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_TRIVIA_EASY_SCORE, score);

        String whereClause = COLUMN_USERNAME + " = ?";
        String[] whereArgs = {username};

        db.update(TABLE_USERS, values, whereClause, whereArgs);
        db.close();
    }

    // Method to update the trivia medium score for a user
    public void updateTriviaMediumScore(String username, int score) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_TRIVIA_MEDIUM_SCORE, score);

        String whereClause = COLUMN_USERNAME + " = ?";
        String[] whereArgs = {username};

        db.update(TABLE_USERS, values, whereClause, whereArgs);
        db.close();
    }

    // Method to update the trivia hard score for a user
    public void updateTriviaHardScore(String username, int score) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_TRIVIA_HARD_SCORE, score);

        String whereClause = COLUMN_USERNAME + " = ?";
        String[] whereArgs = {username};

        db.update(TABLE_USERS, values, whereClause, whereArgs);
        db.close();
    }

    // Method to update the music easy score for a user
    public void updateMusicEasyScore(String username, int score) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_MUSIC_EASY_SCORE, score);

        String whereClause = COLUMN_USERNAME + " = ?";
        String[] whereArgs = {username};

        db.update(TABLE_USERS, values, whereClause, whereArgs);
        db.close();
    }

    // Method to update the music medium score for a user
    public void updateMusicMediumScore(String username, int score) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_MUSIC_MEDIUM_SCORE, score);

        String whereClause = COLUMN_USERNAME + " = ?";
        String[] whereArgs = {username};

        db.update(TABLE_USERS, values, whereClause, whereArgs);
        db.close();
    }

    // Method to update the music hard score for a user
    public void updateMusicHardScore(String username, int score) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_MUSIC_HARD_SCORE, score);

        String whereClause = COLUMN_USERNAME + " = ?";
        String[] whereArgs = {username};

        db.update(TABLE_USERS, values, whereClause, whereArgs);
        db.close();
    }

    // Method to get the computer easy score for a user
    public int getComputerEasyScore(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        int score = 0;

        String selection = COLUMN_USERNAME + " = ?";
        String[] selectionArgs = {username};

        Cursor cursor = db.query(TABLE_USERS, null, selection, selectionArgs, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex(COLUMN_COMPUTER_EASY_SCORE);
            if (columnIndex != -1) {
                score = cursor.getInt(columnIndex);
            }
        }

        cursor.close();
        db.close();

        return score;
    }

    // Method to get the computer medium score for a user
    public int getComputerMediumScore(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        int score = 0;

        String selection = COLUMN_USERNAME + " = ?";
        String[] selectionArgs = {username};

        Cursor cursor = db.query(TABLE_USERS, null, selection, selectionArgs, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex(COLUMN_COMPUTER_MEDIUM_SCORE);
            if (columnIndex != -1) {
                score = cursor.getInt(columnIndex);
            }
        }

        cursor.close();
        db.close();

        return score;
    }

    // Method to get the computer hard score for a user
    public int getComputerHardScore(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        int score = 0;

        String selection = COLUMN_USERNAME + " = ?";
        String[] selectionArgs = {username};

        Cursor cursor = db.query(TABLE_USERS, null, selection, selectionArgs, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex(COLUMN_COMPUTER_HARD_SCORE);
            if (columnIndex != -1) {
                score = cursor.getInt(columnIndex);
            }
        }

        cursor.close();
        db.close();

        return score;
    }

    // Method to get the trivia easy score for a user
    public int getTriviaEasyScore(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        int score = 0;

        String selection = COLUMN_USERNAME + " = ?";
        String[] selectionArgs = {username};

        Cursor cursor = db.query(TABLE_USERS, null, selection, selectionArgs, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex(COLUMN_TRIVIA_EASY_SCORE);
            if (columnIndex != -1) {
                score = cursor.getInt(columnIndex);
            }
        }

        cursor.close();
        db.close();

        return score;
    }

    // Method to get the trivia medium score for a user
    public int getTriviaMediumScore(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        int score = 0;

        String selection = COLUMN_USERNAME + " = ?";
        String[] selectionArgs = {username};

        Cursor cursor = db.query(TABLE_USERS, null, selection, selectionArgs, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex(COLUMN_TRIVIA_MEDIUM_SCORE);
            if (columnIndex != -1) {
                score = cursor.getInt(columnIndex);
            }
        }

        cursor.close();
        db.close();

        return score;
    }

    // Method to get the trivia hard score for a user
    public int getTriviaHardScore(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        int score = 0;

        String selection = COLUMN_USERNAME + " = ?";
        String[] selectionArgs = {username};

        Cursor cursor = db.query(TABLE_USERS, null, selection, selectionArgs, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex(COLUMN_TRIVIA_HARD_SCORE);
            if (columnIndex != -1) {
                score = cursor.getInt(columnIndex);
            }
        }

        cursor.close();
        db.close();

        return score;
    }

    // Method to get the music easy score for a user
    public int getMusicEasyScore(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        int score = 0;

        String selection = COLUMN_USERNAME + " = ?";
        String[] selectionArgs = {username};

        Cursor cursor = db.query(TABLE_USERS, null, selection, selectionArgs, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex(COLUMN_MUSIC_EASY_SCORE);
            if (columnIndex != -1) {
                score = cursor.getInt(columnIndex);
            }
        }

        cursor.close();
        db.close();

        return score;
    }

    // Method to get the music medium score for a user
    public int getMusicMediumScore(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        int score = 0;

        String selection = COLUMN_USERNAME + " = ?";
        String[] selectionArgs = {username};

        Cursor cursor = db.query(TABLE_USERS, null, selection, selectionArgs, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex(COLUMN_MUSIC_MEDIUM_SCORE);
            if (columnIndex != -1) {
                score = cursor.getInt(columnIndex);
            }
        }

        cursor.close();
        db.close();

        return score;
    }

    // Method to get the music hard score for a user
    public int getMusicHardScore(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        int score = 0;

        String selection = COLUMN_USERNAME + " = ?";
        String[] selectionArgs = {username};

        Cursor cursor = db.query(TABLE_USERS, null, selection, selectionArgs, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex(COLUMN_MUSIC_HARD_SCORE);
            if (columnIndex != -1) {
                score = cursor.getInt(columnIndex);
            }
        }

        cursor.close();
        db.close();

        return score;
    }

    // Method to get the total score for a user
    public int getTotalScore(String username) {
        int computerEasyScore = getComputerEasyScore(username);
        int computerMediumScore = getComputerMediumScore(username);
        int computerHardScore = getComputerHardScore(username);
        int triviaEasyScore = getTriviaEasyScore(username);
        int triviaMediumScore = getTriviaMediumScore(username);
        int triviaHardScore = getTriviaHardScore(username);
        int musicEasyScore = getMusicEasyScore(username);
        int musicMediumScore = getMusicMediumScore(username);
        int musicHardScore = getMusicHardScore(username);

        return computerEasyScore + computerMediumScore + computerHardScore +
                triviaEasyScore + triviaMediumScore + triviaHardScore +
                musicEasyScore + musicMediumScore + musicHardScore;
    }

    // Method to get the leaderboard
    public List<UserScore> getLeaderboard() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<UserScore> leaderboard = new ArrayList<>();

        // Query the database to retrieve the scores for all users
        String query = "SELECT " + COLUMN_USERNAME + ", "
                + COLUMN_COMPUTER_EASY_SCORE + ", "
                + COLUMN_COMPUTER_MEDIUM_SCORE + ", "
                + COLUMN_COMPUTER_HARD_SCORE + ", "
                + COLUMN_TRIVIA_EASY_SCORE + ", "
                + COLUMN_TRIVIA_MEDIUM_SCORE + ", "
                + COLUMN_TRIVIA_HARD_SCORE + ", "
                + COLUMN_MUSIC_EASY_SCORE + ", "
                + COLUMN_MUSIC_MEDIUM_SCORE + ", "
                + COLUMN_MUSIC_HARD_SCORE
                + " FROM " + TABLE_USERS
                + " WHERE " + COLUMN_USERNAME + " != 'admin'"
                + " ORDER BY "
                + "(" + COLUMN_COMPUTER_EASY_SCORE + " + "
                + COLUMN_COMPUTER_MEDIUM_SCORE + " + "
                + COLUMN_COMPUTER_HARD_SCORE + " + "
                + COLUMN_TRIVIA_EASY_SCORE + " + "
                + COLUMN_TRIVIA_MEDIUM_SCORE + " + "
                + COLUMN_TRIVIA_HARD_SCORE + " + "
                + COLUMN_MUSIC_EASY_SCORE + " + "
                + COLUMN_MUSIC_MEDIUM_SCORE + " + "
                + COLUMN_MUSIC_HARD_SCORE + ") DESC";

        Cursor cursor = db.rawQuery(query, null);

        // Iterate through the cursor and populate the leaderboard list
        if (cursor != null && cursor.moveToFirst()) {
            do {
                String username = cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME));
                int totalScore = getTotalScore(username); // Use the getTotalScore method

                UserScore userScore = new UserScore(username, totalScore);
                leaderboard.add(userScore);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return leaderboard;
    }

    public String getAllUserAccounts() {
        StringBuilder result = new StringBuilder();
        List<UserAccount> userAccounts = getUsers();

        // Iterate through the list of user accounts and append their details to the result
        for (UserAccount userAccount : userAccounts) {
            result.append("User ID: ").append(userAccount.getUserId()).append("\n");
            result.append("Username: ").append(userAccount.getUsername()).append("\n");
            result.append("--------------------").append("\n");
        }

        return result.toString();
    }

    public List<UserAccount> getUsers() {
        List<UserAccount> userAccounts = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            int userId = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
            String username = cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME));

            UserAccount userAccount = new UserAccount(userId, username);
            userAccounts.add(userAccount);
        }

        cursor.close();
        db.close();

        return userAccounts;
    }

    public void deleteUserAccount(int userId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS, COLUMN_ID + " = ?", new String[]{String.valueOf(userId)});
        db.close();
    }

    public boolean isUserExists(int userId) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(userId)};
        Cursor cursor = db.query(TABLE_USERS, null, selection, selectionArgs, null, null, null);
        boolean isExists = cursor.moveToFirst();
        cursor.close();
        return isExists;
    }


    public void updateCoins(String username, int coins) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_COINS, coins);
        db.update(DatabaseHelper.TABLE_USERS, values, DatabaseHelper.COLUMN_USERNAME + "=?", new String[]{username});
        db.close();
    }

    public void updateX2Score(String username, int x2Score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_X2SCORE, x2Score);
        db.update(DatabaseHelper.TABLE_USERS, values, DatabaseHelper.COLUMN_USERNAME + "=?", new String[]{username});
        db.close();
    }

    public void updateSkip(String username, int skip) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_SKIP, skip);
        db.update(DatabaseHelper.TABLE_USERS, values, DatabaseHelper.COLUMN_USERNAME + "=?", new String[]{username});
        db.close();
    }

    public void updateThirtySeconds(String username, int thirtySeconds) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_THIRTY_SECONDS, thirtySeconds);
        db.update(DatabaseHelper.TABLE_USERS, values, DatabaseHelper.COLUMN_USERNAME + "=?", new String[]{username});
        db.close();
    }

    public int getCoins(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {DatabaseHelper.COLUMN_COINS};
        String selection = DatabaseHelper.COLUMN_USERNAME + "=?";
        String[] selectionArgs = {username};
        Cursor cursor = db.query(DatabaseHelper.TABLE_USERS, projection, selection, selectionArgs, null, null, null);
        int coins = 0;
        if (cursor.moveToFirst()) {
            coins = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_COINS));
        }
        cursor.close();
        db.close();
        return coins;
    }

    public int getX2Score(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {DatabaseHelper.COLUMN_X2SCORE};
        String selection = DatabaseHelper.COLUMN_USERNAME + "=?";
        String[] selectionArgs = {username};
        Cursor cursor = db.query(DatabaseHelper.TABLE_USERS, projection, selection, selectionArgs, null, null, null);
        int x2Score = 0;
        if (cursor.moveToFirst()) {
            x2Score = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_X2SCORE));
        }
        cursor.close();
        db.close();
        return x2Score;
    }

    public int getSkip(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {DatabaseHelper.COLUMN_SKIP};
        String selection = DatabaseHelper.COLUMN_USERNAME + "=?";
        String[] selectionArgs = {username};
        Cursor cursor = db.query(DatabaseHelper.TABLE_USERS, projection, selection, selectionArgs, null, null, null);
        int skip = 0;
        if (cursor.moveToFirst()) {
            skip = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_SKIP));
        }
        cursor.close();
        db.close();
        return skip;
    }

    public int getThirtySeconds(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {DatabaseHelper.COLUMN_THIRTY_SECONDS};
        String selection = DatabaseHelper.COLUMN_USERNAME + "=?";
        String[] selectionArgs = {username};
        Cursor cursor = db.query(DatabaseHelper.TABLE_USERS, projection, selection, selectionArgs, null, null, null);
        int thirtySeconds = 0;
        if (cursor.moveToFirst()) {
            thirtySeconds = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_THIRTY_SECONDS));
        }
        cursor.close();
        db.close();
        return thirtySeconds;
    }

}