package com.example.myapplicationwithsqlitebd;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;


import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private DBHelper helper;
    private SQLiteDatabase database;
    public Button button_toys;
    public Button button_clothes;
    public Button button_food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView1);
        helper = new DBHelper(MainActivity.this);
        try {
            database = helper.getWritableDatabase();
        }catch (Exception e) {
            e.printStackTrace();
        }

        button_food = findViewById(R.id.button);
        button_clothes = findViewById(R.id.button2);
        button_toys=findViewById(R.id.button3);

    }

    public void btn_toys(View view) {
        // Общий список
        ArrayList<HashMap<String, String>> products = new ArrayList<>();
        // Отдельнй продукт
        HashMap <String, String> product;
        // SQL запрос
        Cursor cursor = database.rawQuery("SELECT * FROM products WHERE category_id = 1", null);
        cursor.moveToFirst();
        // Цикл прохода по всем строкам
        while (!cursor.isAfterLast()){
            // Сохраняем каждое значение в массив
            product = new HashMap<>();
            product.put("product", cursor.getString(1));
            product.put("description", cursor.getString(3));
            product.put("price", cursor.getString(4));
            products.add(product);
            cursor.moveToNext();
        }
        cursor.close();

        SimpleAdapter adapter = new SimpleAdapter(
                MainActivity.this,
                products, R.layout.listview_item,
                new String[]{"product", "description", "price"},
                new int[]{R.id.text1, R.id.text2, R.id.text3}
        );
        listView.setAdapter(adapter);

    }

    public void btn_clothes(View view) {
        // Общий список
        ArrayList<HashMap<String, String>> products = new ArrayList<>();
        // Отдельнй продукт
        HashMap <String, String> product;
        // SQL запрос
        Cursor cursor = database.rawQuery("SELECT * FROM products WHERE category_id = 3", null);
        cursor.moveToFirst();
        // Цикл прохода по всем строкам
        while (!cursor.isAfterLast()){
            // Сохраняем каждое значение в массив
            product = new HashMap<>();
            product.put("product", cursor.getString(1));
            product.put("description", cursor.getString(3));
            product.put("price", cursor.getString(4));
            products.add(product);
            cursor.moveToNext();
        }
        cursor.close();

        SimpleAdapter adapter = new SimpleAdapter(
                MainActivity.this,
                products, R.layout.listview_item,
                new String[]{"product", "description", "price"},
                new int[]{R.id.text1, R.id.text2, R.id.text3}
        );
        listView.setAdapter(adapter);

    }

    public void btn_food(View view) {
        // Общий список
        ArrayList<HashMap<String, String>> products = new ArrayList<>();
        // Отдельнй продукт
        HashMap <String, String> product;
        // SQL запрос
        Cursor cursor = database.rawQuery("SELECT * FROM products WHERE category_id = 2", null);
        cursor.moveToFirst();
        // Цикл прохода по всем строкам
        while (!cursor.isAfterLast()){
            // Сохраняем каждое значение в массив
            product = new HashMap<>();
            product.put("product", cursor.getString(1));
            product.put("description", cursor.getString(3));
            product.put("price", cursor.getString(4));
            products.add(product);
            cursor.moveToNext();
        }
        cursor.close();

        SimpleAdapter adapter = new SimpleAdapter(
                MainActivity.this,
                products, R.layout.listview_item,
                new String[]{"product", "description", "price"},
                new int[]{R.id.text1, R.id.text2, R.id.text3}
        );
        listView.setAdapter(adapter);

    }
}