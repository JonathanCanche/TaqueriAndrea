package com.canchemoguel.taqueriandrea;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainCorte extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent b1 = new Intent(MainCorte.this,Menu.class);
                    startActivity(b1);
                    finish();
                    break;
                case R.id.navigation_dashboard:
                    Intent b2 = new Intent(MainCorte.this,Main2Activity.class);
                    startActivity(b2);
                    finish();
                    break;
                case R.id.navigation_corte:

                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_corte);
        setTitle("Historial corte de caja");

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        android.view.Menu menu = navView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        final DbHandler db = new DbHandler(this);
        final ArrayList<HashMap<String, String>> corteList = db.GetCorte();
        final ListView lv = (ListView) findViewById(R.id.listCorte);
        final ListAdapter adapter = new SimpleAdapter(MainCorte.this, corteList, R.layout.list_row_dos,new String[]{"corte","datecorte"}, new int[]{R.id.corte,R.id.type});
        lv.setAdapter(adapter);
    }
}
