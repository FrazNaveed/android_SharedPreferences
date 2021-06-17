package com.example.journal13;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {
    LinearLayout lLayout; // Root ViewGroup in which you want to add textviews
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lLayout = (LinearLayout) findViewById(R.id.linearlayout2);
        SharedPreferences sp = getSharedPreferences("demo", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        final int N = sp.getInt("count", 1);; // total number of textviews to add
        final TextView[] myTextViews = new TextView[N]; // create an empty array;

        for (int i = 0; i < N; i++) {
            final TextView rowTextView = new TextView(this);
            String id = String.valueOf(i);
            rowTextView.setText(sp.getString(id, ""));
            lLayout.addView(rowTextView);
            myTextViews[i] = rowTextView;
        }
    }
}