package com.learning.insanes.chothastore;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddCourseActivity extends Activity {

    EditText name, subtitle;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
        name = findViewById(R.id.edit_add_name);
        subtitle = findViewById(R.id.edit_add_subtitle);
        subtitle.setHint("Teacher name");

        final String courseName = getIntent().getStringExtra("name");

        ((Button) findViewById(R.id.button_add)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = openOrCreateDatabase("mydb", Context.MODE_PRIVATE, null);
                db.execSQL("CREATE TABLE IF NOT EXISTS COURSES(_id PRIMARY KEY AUTOINCREMENT,name TEXT, subtitle TEXT);");
                db.execSQL("INSERT INTO COURSES ('name', 'subtitle') VALUES(" +
                        "'" +
                        name.getText().toString() + "','" + subtitle.getText().toString() + "');");
                finish();
            }
        });
    }
}
