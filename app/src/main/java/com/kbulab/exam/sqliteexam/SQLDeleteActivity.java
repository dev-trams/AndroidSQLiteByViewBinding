package com.kbulab.exam.sqliteexam;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.kbulab.exam.sqliteexam.Database.DB;
import com.kbulab.exam.sqliteexam.databinding.ActivitySqldeleteBinding;

public class SQLDeleteActivity extends AppCompatActivity {
    ActivitySqldeleteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySqldeleteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DB db = new DB(this, "student.db", null, 1);
        SQLiteDatabase database = db.getWritableDatabase();

        Cursor cursor = db.searchData();
//                Cursor cursor = db.searchData();
        if (cursor.getCount() == 0) {
            binding.viewQuery.append("\n 데이터가 없습니다.");
        } else {
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                int age = cursor.getInt(2);
                String address = cursor.getString(3);

                binding.viewQuery.append("\n id = " + id + ", 이름 = " + name + ", 나이 = " + age + ", 주소 = " + address);
                cursor.moveToNext();
            }
            binding.viewQuery.append("\n"+cursor.getCount() + "개");
        }
        cursor.close();

        binding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                db.onDelete(binding.textKeywordName.getText().toString());
                Cursor cursor = db.keywordSearchData(binding.textKeywordName.getText().toString());
//                Cursor cursor = db.searchData();
                if (cursor.getCount() == 0) {
                    binding.viewQuery.append("\n delete 실패 - 항목이 없습니다."+cursor.getCount()+"번째 row delete 성공");
                } else {
                    cursor.moveToFirst();
                    for (int i = 0; i < cursor.getCount(); i++) {
                        int id = cursor.getInt(0);
                        String name = cursor.getString(1);
                        int age = cursor.getInt(2);
                        String address = cursor.getString(3);

                        binding.textViewAge.setText(String.valueOf(age));
                        binding.textViewAddress.setText(address);
                        binding.viewQuery.append("\n"+cursor.getCount()+"번째 row delete 성공");
                        cursor.moveToNext();
                    }
                }
                cursor.close();
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