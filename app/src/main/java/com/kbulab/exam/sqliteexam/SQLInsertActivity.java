package com.kbulab.exam.sqliteexam;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.kbulab.exam.sqliteexam.Database.DB;
import com.kbulab.exam.sqliteexam.databinding.ActivityMainBinding;
import com.kbulab.exam.sqliteexam.databinding.ActivitySqlinsertBinding;

public class SQLInsertActivity extends AppCompatActivity {
    ActivitySqlinsertBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySqlinsertBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DB db = new DB(this, "student.db", null, 1);
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
        db.onCreate(sqLiteDatabase);
        binding.btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long result = db.insertData(binding.textInsertName.getText().toString(), Integer.parseInt(binding.textInsertAge.getText().toString()), binding.textInsertAddress.getText().toString());
                if(result == -1L) {
                    binding.textViewLog.append("\n중복된 데이터 입니다.");
                } else {
                    Cursor cursor = db.searchData();
                    binding.textViewLog.append("\n".concat(String.valueOf(cursor.getCount())).concat("번째 row insert 성공"));
                }
            }
        });
        binding.btnBackMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}