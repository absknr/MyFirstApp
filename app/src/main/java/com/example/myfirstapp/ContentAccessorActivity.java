package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.provider.UserDictionary;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContentAccessorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_accessor);
        this.search();
    }

    public void search() {
//        String[] projection = {UserDictionary.Words.WORD, UserDictionary.Words.LOCALE};
//        String[] selectionArgs = {""};
//        String selectionClause;
//        String sortOrder = "asc";

//        System.out.println("searchString" + searchString);
//
//        if (TextUtils.isEmpty(searchString)) {
//            // Setting the selection clause to null will return all words
//            selectionClause = null;
//            selectionArgs[0] = "";
//
//        } else {
//            // Constructs a selection clause that matches the word that the user entered.
//            selectionClause = UserDictionary.Words.WORD + " = ?";
//
//            // Moves the user's input string to the selection arguments.
//            selectionArgs[0] = searchString;
//
//        }

        // Does a query against the table and returns a Cursor object
        Cursor cursor = getContentResolver().query(
                ContactsContract.Contacts.CONTENT_URI,  // The content URI of the words table
                null,                       // The columns to return for each row
                null,                  // Either null, or the word the user entered
                null,                    // Either empty, or the string the user entered
                null
        );

        // The sort order for the returned rows
        TextView textView = findViewById(R.id.textView3);

        if (cursor.getCount() > 0) {
            List<String> contacts = new ArrayList<>();
            // Move the cursor to first. Also check whether the cursor is empty or not.
            if (cursor.moveToFirst()) {
                // Iterate through the cursor
                do {
                    // Get the contacts name
                    String name = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME));
                    contacts.add(name);
                } while (cursor.moveToNext());
            }
            textView.setText(contacts.toString());
        } else {
            textView.setText("No contacts found");
        }

        // Some providers return null if an error occurs, others throw an exception
//        if (null == mCursor) {
//            /*
//             * Insert code here to handle the error. Be sure not to use the cursor! You may want to
//             * call android.util.Log.e() to log this error.
//             *
//             */
//            // If the Cursor is empty, the provider found no matches
//            System.out.println("Error occurred");
//        } else if (mCursor.getCount() < 1) {
//
//            /*
//             * Insert code here to notify the user that the search was unsuccessful. This isn't necessarily
//             * an error. You may want to offer the user the option to insert a new row, or re-type the
//             * search term.
//             */
//            System.out.println("Not Found");
//        } else {
//            // Insert code here to do something with the results
//            System.out.println(mCursor);
//        }

    }
}