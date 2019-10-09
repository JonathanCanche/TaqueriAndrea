package com.canchemoguel.taqueriandrea;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;

public class Main2Activity extends AppCompatActivity {

    private RelativeLayout rl;
    private DbHandler dbManager;
    private String result = "";
    private TextView corte;
    private TextView item;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent b1 = new Intent(Main2Activity.this,Menu.class);
                    startActivity(b1);
                    finish();
                    break;
                case R.id.navigation_dashboard:

                    break;
                case R.id.navigation_corte:
                    Intent b2 = new Intent(Main2Activity.this,MainCorte.class);
                    startActivity(b2);
                    finish();
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("Historial de ventas");

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        android.view.Menu menu = navView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        final DbHandler db = new DbHandler(this);
        final ArrayList<HashMap<String, String>> userList = db.GetUsers();
        final ListView lv = (ListView) findViewById(R.id.user_list);
        final ListAdapter adapter = new SimpleAdapter(Main2Activity.this, userList, R.layout.list_row,new String[]{"name","date","productos"}, new int[]{R.id.letrero,R.id.name,R.id.location});
        lv.setAdapter(adapter);

        item = (TextView)findViewById(R.id.action_corte);
        rl = (RelativeLayout)findViewById(R.id.rlInvisible);

        if (adapter.isEmpty()){
            rl.setVisibility(View.VISIBLE);
            ((SimpleAdapter) adapter).notifyDataSetChanged();
        }else {

        }

        dbManager = new DbHandler(this);
        Cursor Distance = dbManager.Distance();

        if (Distance.moveToNext())
            result = String.valueOf(Distance.getDouble(Distance.getColumnIndex("myTotal")));

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long l) {
                final int idElemento = i + 1;

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(Main2Activity.this);
                dialogo1.setTitle("Importante");
                dialogo1.setMessage("¿Eliminar está venta?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        db.DeleteUser(idElemento);
                        userList.remove(i);
                        ((SimpleAdapter) adapter).notifyDataSetChanged();

                    }
                });
                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                    }
                });
                dialogo1.show();
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        // Inflate the menu items for use in the action bar
        getMenuInflater().inflate(R.menu.menu_corte, menu);

        final MenuItem menuItem = menu.findItem(R.id.action_corte);

        View actionView = MenuItemCompat.getActionView(menuItem);
        corte = (TextView) actionView.findViewById(R.id.txtCorte);

        setupBadge();

        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(menuItem);
            }
        });

        return true;
    }
    private void setupBadge() {

        corte.setText(String.valueOf(result));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items

        switch (item.getItemId()) {
            case R.id.action_search:
                AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);

                builder.setTitle("Aviso")
                        .setMessage("¿Realizar el corte de caja?")
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dbManager.DeleteTable();
                                        Toast.makeText(getApplicationContext(),"Corte de caja realizado",Toast.LENGTH_LONG).show();
                                        DbHandler dbHandler = new DbHandler(Main2Activity.this);
                                        dbHandler.insertCorteDetails(result);
                                    }
                                })
                        .setNegativeButton("CANCELAR",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });

                builder.create();
                builder.show();
                return true;
            case R.id.action_corte:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
