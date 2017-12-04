package com.learning.insanes.chothastore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ChothaListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        final String courseName = getIntent().getStringExtra("coursename");

        SQLiteDatabase db = openOrCreateDatabase("mydb", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS [" + courseName + "] (name TEXT, subtitle TEXT);");
        Cursor cursor = db.query("'" +courseName+ "'", new String[]{"name","subtitle"}, null, null, null, null, null);

        DatabaseUtils.dumpCursorToString(cursor);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new CourseAdapter(cursor));

        findViewById(R.id.course_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChothaListActivity.this, AddChothaActivity.class);
                intent.putExtra("name", courseName);
                startActivity(intent);
            }
        });
    }
}
