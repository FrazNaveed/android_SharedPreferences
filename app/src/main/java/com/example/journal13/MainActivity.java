package com.example.journal13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button save, view;
    EditText text;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      save = (Button) findViewById(R.id.button);
      view = (Button) findViewById(R.id.button2);
      text = (EditText) findViewById(R.id.txt);
    }

    public void save(View view)
    {
        String txt = text.getText().toString();
        SharedPreferences sp = getSharedPreferences("demo", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        count = sp.getInt("count", 1);
        String id = String.valueOf(count);
        ed.putString(id, txt);
        count = count + 1;
        ed.putInt("count", count);
        ed.commit();
        Toast.makeText(this, "Note Saved" , Toast.LENGTH_SHORT).show();
    }
    public void view(View view)
    {

         Intent i = new Intent(this, MainActivity2.class);
         startActivity(i);

        /*  SharedPreferences sp = getSharedPreferences("file", Context.MODE_PRIVATE);
       String read = sp.getString("t", "");
      tv.setText(String.valueOf(read));
        Toast.makeText(this, "showing" , Toast.LENGTH_SHORT).show();

         */
    }
}