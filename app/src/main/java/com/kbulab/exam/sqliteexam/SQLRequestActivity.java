package com.kbulab.exam.sqliteexam;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.kbulab.exam.sqliteexam.Database.DB;
import com.kbulab.exam.sqliteexam.databinding.ActivitySqlrequestBinding;

public class SQLRequestActivity extends AppCompatActivity {
    ActivitySqlrequestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySqlrequestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DB db = new DB(this, "student.db", null, 1);
        SQLiteDatabase database = db.getWritableDatabase();
        Cursor cursor = db.searchData();
//                Cursor cursor = db.searchData();
        if (cursor.getCount() == 0) {
            binding.textViewLog.append("\n 데이터가 없습니다.");
        } else {
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                int age = cursor.getInt(2);
                String address = cursor.getString(3);

                binding.textViewLog.append("\n id = " + id + ", 이름 = " + name + ", 나이 = " + age + ", 주소 = " + address);
                cursor.moveToNext();
            }
            binding.textViewLog.append("\n"+cursor.getCount() + "개");
        }
        cursor.close();
        binding.btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = db.keywordSearchData(binding.textKeywordName.getText().toString());
//                Cursor cursor = db.searchData();
                if (cursor.getCount() == 0) {
                    binding.textViewLog.append("\n 데이터가 없습니다.");
                } else {
                    cursor.moveToFirst();
                    for (int i = 0; i < cursor.getCount(); i++) {
                        int id = cursor.getInt(0);
                        String name = cursor.getString(1);
                        int age = cursor.getInt(2);
                        String address = cursor.getString(3);

                        binding.textEditName.setText(name);
                        binding.textEditAge.setText(String.valueOf(age));
                        binding.textEditAddress.setText(address);

                        cursor.moveToNext();
                    }
                }
                cursor.close();
            }
        });
        binding.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.onUpdate(
                        binding.textKeywordName.getText().toString(),
                        binding.textEditName.getText().toString(),
                        binding.textEditAge.getText().toString(),
                        binding.textEditAddress.getText().toString()
                );
                binding.textViewLog.append("\nUpdate 성공");
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