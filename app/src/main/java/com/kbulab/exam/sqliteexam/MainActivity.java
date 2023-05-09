package com.kbulab.exam.sqliteexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kbulab.exam.sqliteexam.Database.DB;
import com.kbulab.exam.sqliteexam.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase database = null;
    final String dbName = "student.db";
    final String tableName = "student";

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // findViewById를 사용하지 않고 ViewBinding을 사용하여 레이아웃의 오브젝트를 사용함
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DB db = new DB(this, dbName, null, 1);
        db.getWritableDatabase();

        binding.btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "추가 버튼 클릭", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SQLInsertActivity.class);
                startActivity(intent);
            }
        });

        binding.btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "갱신 버튼 클릭", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SQLRequestActivity.class);
                startActivity(intent);
            }
        });

        binding.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "삭제 버튼 클릭", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SQLDeleteActivity.class);
                startActivity(intent);
            }
        });

        binding.btnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.viewQuery.setText("");
//                Cursor cursor = db.keywordSearchData(binding.viewQuery.getText().toString());
                Cursor cursor = db.searchData();
                if (cursor.getCount() == 0) {
                    binding.viewQuery.setText("\n 데이터가 없습니다.");
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
                    binding.viewQuery.append("\n" + cursor.getCount() + " 개");
                }
                cursor.close();
            }
        });

    }
}