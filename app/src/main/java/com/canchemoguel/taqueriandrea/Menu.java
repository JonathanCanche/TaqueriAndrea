package com.canchemoguel.taqueriandrea;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class Menu extends AppCompatActivity {

    private ImageView AddTaco;
    private ImageView LessTaco;
    private ImageView AddArina;
    private ImageView LessArina;
    private ImageView AddBurger;
    private ImageView LessBurger;
    private ImageView AddTorta;
    private ImageView LessTorta;
    private ImageView AddTortaEspecial;
    private ImageView LessTortaEspecial;
    private ImageView AddBurritas;
    private ImageView LessBurritas;
    private ImageView AddBurritaco;
    private ImageView LessBurritaco;
    private ImageView AddCocaPlastico;
    private ImageView LessCocaPlastico;
    private ImageView AddCocaVidrio;
    private ImageView LessCocaVidrio;
    private ImageView AddCocaZero;
    private ImageView LessCocaZero;
    private ImageView AddOrden;
    private ImageView LessOrden;
    private ImageView AddOrdenMedia;
    private ImageView LessOrdenMedia;
    private TextView ContadorTaco;
    private TextView ContadorArina;
    private TextView ContadorBurger;
    private TextView ContadorTorta;
    private TextView ContadorOrden;
    private TextView ContadorOrdenMedia;
    private TextView ContadorTortaEspecial;
    private TextView ContadorBurritas;
    private TextView ContadorBurritaco;
    private TextView ContadorCocaPlastico;
    private TextView ContadorCocaVidrio;
    private TextView ContadorCocaZero;
    private EditText txtRecibido;
    private TextView Total;
    private Button btnLimpiar;
    private Button btnCobrar;
    private int mostrar;
    private int click = 0;

    private String Vtorta = " torta";
    private String Vtaco = " taco";
    private String Vburger = " burger";
    private String VOrden = " orden";
    private String VBurrita = " burrita";
    private String VBurritaco = " burritaco";
    private String VTortaEspecial = " torta especial";
    private String VOrdenMedia = " media orden";
    private String VTacoArina = " taco harina";
    private String VCocaVidrio = " coca vidrio";
    private String VCocaPlastico = " coca plastico";
    private String VCocaZero = " coca zero";

    private DbHandler dbHandler;
    private String torta;
    private String tortaEspecial;
    private String taco;
    private String tacoHarina;
    private String burger;
    private String burrita;
    private String burritaco;
    private String orden;
    private String ordenMedia;
    private String cocaVidrio;
    private String cocaPlastico;
    private String cocaZero;

    private TextView CambioDos;
    private TextView TotalDoS;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    break;
                case R.id.navigation_dashboard:
                    Intent b = new Intent(Menu.this,Main2Activity.class);
                    startActivity(b);
                    finish();
                    break;
                case R.id.navigation_corte:
                    Intent b2 = new Intent(Menu.this,MainCorte.class);
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
        setContentView(R.layout.activity_menu);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        android.view.Menu menu = navView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        /*SpannableString s = new SpannableString("Menú");
        s.setSpan(new TypefaceSpan("capriola_regular.ttf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);*/

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Menú");

        AddTaco = (ImageView)findViewById(R.id.ImgAddTaco);
        LessTaco = (ImageView)findViewById(R.id.ImgLessTaco);
        AddArina = (ImageView)findViewById(R.id.ImgAddArina);
        LessArina = (ImageView)findViewById(R.id.ImgLessArina);
        AddBurger = (ImageView)findViewById(R.id.ImgAddBurger);
        LessBurger = (ImageView)findViewById(R.id.ImgLessBurger);
        AddTorta = (ImageView)findViewById(R.id.ImgAddTorta);
        LessTorta = (ImageView)findViewById(R.id.ImgLessTorta);
        AddTortaEspecial = (ImageView)findViewById(R.id.ImgAddTortaEspecial);
        LessTortaEspecial = (ImageView)findViewById(R.id.ImgLessTortaEspecial);
        AddBurritas = (ImageView)findViewById(R.id.ImgAddBurritas);
        LessBurritas = (ImageView)findViewById(R.id.ImgLessBurritas);
        AddBurritaco = (ImageView)findViewById(R.id.ImgAddBurritaco);
        LessBurritaco = (ImageView)findViewById(R.id.ImgLessBurritaco);
        AddCocaPlastico = (ImageView)findViewById(R.id.ImgAddCocaPlastico);
        LessCocaPlastico = (ImageView)findViewById(R.id.ImgLessCocaPlastico);
        AddCocaVidrio = (ImageView)findViewById(R.id.ImgAddCocaVidrio);
        LessCocaVidrio = (ImageView)findViewById(R.id.ImgLessCocaVidrio);
        AddCocaZero = (ImageView)findViewById(R.id.ImgAddCocaZero);
        LessCocaZero = (ImageView)findViewById(R.id.ImgLessCocaZero);
        AddOrden = (ImageView)findViewById(R.id.ImgAddOrden);
        LessOrden = (ImageView)findViewById(R.id.ImgLessOrden);
        AddOrdenMedia = (ImageView)findViewById(R.id.ImgAddOrdenMedia);
        LessOrdenMedia = (ImageView)findViewById(R.id.ImgLessOrdenMedia);
        ContadorTaco = (TextView)findViewById(R.id.TxtContadorTaco);
        ContadorArina = (TextView)findViewById(R.id.TxtContadorArina);
        ContadorBurger = (TextView)findViewById(R.id.TxtContadorBurger);
        ContadorBurritas = (TextView)findViewById(R.id.TxtContadorBurritas);
        ContadorBurritaco = (TextView)findViewById(R.id.TxtContadorBurritaco);
        ContadorTorta = (TextView)findViewById(R.id.TxtContadorTorta);
        ContadorTortaEspecial = (TextView)findViewById(R.id.TxtContadorTortaEspecial);
        ContadorCocaPlastico = (TextView)findViewById(R.id.TxtContadorCocaPlastico);
        ContadorCocaVidrio = (TextView)findViewById(R.id.TxtContadorCocaVidrio);
        ContadorCocaZero = (TextView)findViewById(R.id.TxtContadorCocaZero);
        ContadorOrden = (TextView)findViewById(R.id.TxtContadorOrden);
        ContadorOrdenMedia = (TextView)findViewById(R.id.TxtContadorOrdenMedia);
       // Total = (TextView)findViewById(R.id.TxtTotal) ;
        btnCobrar = (Button)findViewById(R.id.btncobrar);
        txtRecibido = (EditText)findViewById(R.id.TxtRecibo);
        btnLimpiar = (Button)findViewById(R.id.btnLimpiarOmitir);


        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nuevo();
                Toast.makeText(getApplicationContext(),"Menú limpio",Toast.LENGTH_SHORT).show();
            }
        });

        btnCobrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (txtRecibido.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Operación invalida,Introduzca una cantidad",Toast.LENGTH_SHORT).show();
                }else if (mostrar > Integer.parseInt(txtRecibido.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Operación invalida,cantidad insuficiente",Toast.LENGTH_SHORT).show();
                }else {
                    AlertDialog.Builder builder =
                            new AlertDialog.Builder(Menu.this);
                    LayoutInflater inflater = getLayoutInflater();

                    View vie = inflater.inflate(R.layout.ventanacobrar, null);
                    builder.setView(vie);



                    final TextView txtTotalDos = (TextView)vie.findViewById(R.id.txtTotalDos);
                    final TextView txtCambio = (TextView)vie.findViewById(R.id.txtCambio);
                    txtTotalDos.setText(String.valueOf(mostrar));

                    txtRecibido.getText().toString();
                    int dinero = Integer.valueOf(txtRecibido.getText().toString());
                    int resultado = dinero - mostrar;
                    txtCambio.setText(String.valueOf(resultado));

                    builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            SaveProducts();


                        }
                    });
                    builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    builder.show();
                }
            }
        });


        AddTaco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click = Integer.parseInt(ContadorTaco.getText().toString());
                mostrar = mostrar + 10;
                click = click + 1;
                ContadorTaco.setText(String.valueOf(click));
                Total.setText(String.valueOf(mostrar));
                taco = click + Vtaco;
            }
        });

        LessTaco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(ContadorTaco.getText().toString())<1){
                    Toast.makeText(getApplicationContext(),"Acción no permitida",Toast.LENGTH_SHORT).show();
                }else {
                    click = Integer.parseInt(ContadorTaco.getText().toString());
                    mostrar = mostrar - 10;
                    click = click - 1;
                    ContadorTaco.setText(String.valueOf(click));
                    Total.setText(String.valueOf(mostrar));
                    taco = click + Vtaco;
                }
            }
        });

        AddArina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click = Integer.parseInt(ContadorArina.getText().toString());
                mostrar = mostrar + 13;
                click = click + 1;
                ContadorArina.setText(String.valueOf(click));
                Total.setText(String.valueOf(mostrar));
                tacoHarina = click + VTacoArina;
            }
        });

        LessArina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(ContadorArina.getText().toString())<1){
                    Toast.makeText(getApplicationContext(),"Acción no permitida",Toast.LENGTH_SHORT).show();
                }else {
                    click = Integer.parseInt(ContadorArina.getText().toString());
                    mostrar = mostrar - 13;
                    click = click - 1;
                    ContadorArina.setText(String.valueOf(click));
                    Total.setText(String.valueOf(mostrar));
                    tacoHarina = click + VTacoArina;
                }
            }
        });

        AddBurger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click = Integer.parseInt(ContadorBurger.getText().toString());
                mostrar = mostrar + 22;
                click = click + 1;
                ContadorBurger.setText(String.valueOf(click));
                Total.setText(String.valueOf(mostrar));
                burger = click + Vburger;
            }
        });

        LessBurger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Integer.parseInt(ContadorBurger.getText().toString())<1){
                    Toast.makeText(getApplicationContext(),"Acción no permitida",Toast.LENGTH_SHORT).show();
                }else {
                    click = Integer.parseInt(ContadorBurger.getText().toString());
                    mostrar = mostrar - 22;
                    click = click - 1;
                    ContadorBurger.setText(String.valueOf(click));
                    Total.setText(String.valueOf(mostrar));
                    burger = click + Vburger;
                }
            }
        });

        AddTorta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click = Integer.parseInt(ContadorTorta.getText().toString());
                mostrar = mostrar + 18;
                click = click + 1;
                ContadorTorta.setText(String.valueOf(click));
                Total.setText(String.valueOf(mostrar));
                torta = click + Vtorta;
            }
        });

        LessTorta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(ContadorTorta.getText().toString())<1){
                    Toast.makeText(getApplicationContext(),"Acción no permitida",Toast.LENGTH_SHORT).show();
                }else {
                    click = Integer.parseInt(ContadorTorta.getText().toString());
                    mostrar = mostrar - 18;
                    click = click - 1;
                    ContadorTorta.setText(String.valueOf(click));
                    Total.setText(String.valueOf(mostrar));
                    torta = click + Vtorta;
                }
            }
        });

        AddTortaEspecial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click = Integer.parseInt(ContadorTortaEspecial.getText().toString());
                mostrar = mostrar + 25;
                click = click + 1;
                ContadorTortaEspecial.setText(String.valueOf(click));
                Total.setText(String.valueOf(mostrar));
                tortaEspecial = click + VTortaEspecial;
            }
        });

        LessTortaEspecial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(ContadorTortaEspecial.getText().toString())<1){
                    Toast.makeText(getApplicationContext(),"Acción no permitida",Toast.LENGTH_SHORT).show();
                }else {
                    click = Integer.parseInt(ContadorTortaEspecial.getText().toString());
                    mostrar = mostrar - 25;
                    click = click - 1;
                    ContadorTortaEspecial.setText(String.valueOf(click));
                    Total.setText(String.valueOf(mostrar));
                    tortaEspecial = click + VTortaEspecial;
                }
            }
        });

        AddBurritas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click = Integer.parseInt(ContadorBurritas.getText().toString());
                mostrar = mostrar + 8;
                click = click + 1;
                ContadorBurritas.setText(String.valueOf(click));
                Total.setText(String.valueOf(mostrar));
                burrita = click + VBurrita;
            }
        });

        LessBurritas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(ContadorBurritas.getText().toString())<1){
                    Toast.makeText(getApplicationContext(),"Acción no permitida",Toast.LENGTH_SHORT).show();
                }else {
                    click = Integer.parseInt(ContadorBurritas.getText().toString());
                    mostrar = mostrar - 8;
                    click = click - 1;
                    ContadorBurritas.setText(String.valueOf(click));
                    Total.setText(String.valueOf(mostrar));
                    burrita = click + VBurrita;
                }
            }
        });

        AddBurritaco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click = Integer.parseInt(ContadorBurritaco.getText().toString());
                mostrar = mostrar + 25;
                click = click + 1;
                ContadorBurritaco.setText(String.valueOf(click));
                Total.setText(String.valueOf(mostrar));
                burritaco = click + VBurritaco;
            }
        });

        LessBurritaco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(ContadorBurritaco.getText().toString())<1){
                    Toast.makeText(getApplicationContext(),"Acción no permitida",Toast.LENGTH_SHORT).show();
                }else {
                    click = Integer.parseInt(ContadorBurritaco.getText().toString());
                    mostrar = mostrar - 25;
                    click = click - 1;
                    ContadorBurritaco.setText(String.valueOf(click));
                    Total.setText(String.valueOf(mostrar));
                    burritaco = click + VBurritaco;
                }
            }
        });

        AddOrden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click = Integer.parseInt(ContadorOrden.getText().toString());
                mostrar = mostrar + 60;
                click = click + 1;
                ContadorOrden.setText(String.valueOf(click));
                Total.setText(String.valueOf(mostrar));
                orden = click + VOrden;
            }
        });

        LessOrden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(ContadorOrden.getText().toString())<1){
                    Toast.makeText(getApplicationContext(),"Acción no permitida",Toast.LENGTH_SHORT).show();
                }else {
                    click = Integer.parseInt(ContadorOrden.getText().toString());
                    mostrar = mostrar - 60;
                    click = click - 1;
                    ContadorOrden.setText(String.valueOf(click));
                    Total.setText(String.valueOf(mostrar));
                    orden = click + VOrden;
                }
            }
        });

        AddOrdenMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click = Integer.parseInt(ContadorOrdenMedia.getText().toString());
                mostrar = mostrar + 50;
                click = click + 1;
                ContadorOrdenMedia.setText(String.valueOf(click));
                Total.setText(String.valueOf(mostrar));
                ordenMedia = click + VOrdenMedia;
            }
        });

        LessOrdenMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(ContadorOrdenMedia.getText().toString())<1){
                    Toast.makeText(getApplicationContext(),"Acción no permitida",Toast.LENGTH_SHORT).show();
                }else {
                    click = Integer.parseInt(ContadorOrdenMedia.getText().toString());
                    mostrar = mostrar - 50;
                    click = click - 1;
                    ContadorOrdenMedia.setText(String.valueOf(click));
                    Total.setText(String.valueOf(mostrar));
                    ordenMedia = click + VOrdenMedia;
                }
            }
        });

        AddCocaPlastico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click = Integer.parseInt(ContadorCocaPlastico.getText().toString());
                mostrar = mostrar + 13;
                click = click + 1;
                ContadorCocaPlastico.setText(String.valueOf(click));
                Total.setText(String.valueOf(mostrar));
                cocaPlastico = click + VCocaPlastico;
            }
        });

        LessCocaPlastico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(ContadorCocaPlastico.getText().toString())<1){
                    Toast.makeText(getApplicationContext(),"Acción no permitida",Toast.LENGTH_SHORT).show();
                }else {
                    click = Integer.parseInt(ContadorCocaPlastico.getText().toString());
                    mostrar = mostrar - 13;
                    click = click - 1;
                    ContadorCocaPlastico.setText(String.valueOf(click));
                    Total.setText(String.valueOf(mostrar));
                    cocaPlastico = click + VCocaPlastico;
                }
            }
        });

        AddCocaVidrio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click = Integer.parseInt(ContadorCocaVidrio.getText().toString());
                mostrar = mostrar + 12;
                click = click + 1;
                ContadorCocaVidrio.setText(String.valueOf(click));
                Total.setText(String.valueOf(mostrar));
                cocaVidrio = click + VCocaVidrio;
            }
        });

        LessCocaVidrio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(ContadorCocaVidrio.getText().toString())<1){
                    Toast.makeText(getApplicationContext(),"Acción no permitida",Toast.LENGTH_SHORT).show();
                }else {
                    click = Integer.parseInt(ContadorCocaVidrio.getText().toString());
                    mostrar = mostrar - 12;
                    click = click - 1;
                    ContadorCocaVidrio.setText(String.valueOf(click));
                    Total.setText(String.valueOf(mostrar));
                    cocaVidrio = click + VCocaVidrio;
                }
            }
        });

        AddCocaZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click = Integer.parseInt(ContadorCocaZero.getText().toString());
                mostrar = mostrar + 14;
                click = click + 1;
                ContadorCocaZero.setText(String.valueOf(click));
                Total.setText(String.valueOf(mostrar));
                cocaZero = click + VCocaZero;
            }
        });

        LessCocaZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(ContadorCocaZero.getText().toString())<1){
                    Toast.makeText(getApplicationContext(),"Acción no permitida",Toast.LENGTH_SHORT).show();
                }else {
                    click = Integer.parseInt(ContadorCocaZero.getText().toString());
                    mostrar = mostrar - 14;
                    click = click - 1;
                    ContadorCocaZero.setText(String.valueOf(click));
                    Total.setText(String.valueOf(mostrar));
                    cocaZero = click + VCocaZero;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        final MenuItem menuItem = menu.findItem(R.id.action_notifications);

        View actionView = MenuItemCompat.getActionView(menuItem);
        Total = (TextView) actionView.findViewById(R.id.notification_badge);

        setupBadge();

        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(menuItem);
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_notifications: {

                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupBadge() {

        Total.setText(String.valueOf(mostrar));
    }

    public void Nuevo(){

        ContadorTaco.setText("0");
        ContadorArina.setText("0");
        ContadorTorta.setText("0");
        ContadorCocaZero.setText("0");
        ContadorCocaVidrio.setText("0");
        ContadorCocaPlastico.setText("0");
        ContadorTortaEspecial.setText("0");
        ContadorBurritas.setText("0");
        ContadorBurritaco.setText("0");
        ContadorBurger.setText("0");
        ContadorOrden.setText("0");
        ContadorOrdenMedia.setText("0");
        Total.setText("0");
        txtRecibido.setText("");
        mostrar = 0;
        taco=null;
        tacoHarina=null;
        burger=null;
        torta=null;
        tortaEspecial=null;
        burrita=null;
        burritaco=null;
        orden=null;
        ordenMedia=null;
        cocaPlastico=null;
        cocaVidrio=null;
        cocaZero=null;

    }

    public void SaveProducts(){

        if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),taco);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),tacoHarina);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();

        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),burger);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();

        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),torta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();

        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),tortaEspecial);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();

        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),burrita);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();

        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),burritaco);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();

        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),orden);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();

        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),ordenMedia);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();

        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),cocaPlastico);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();

        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),cocaVidrio);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();

        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio"))){

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),cocaZero);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();

        }else if ((burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {taco,tacoHarina};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {taco,burger};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {taco,torta};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {taco,tortaEspecial};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {taco,burrita};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {taco,burritaco};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {taco,orden};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {taco,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {taco,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {taco,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio"))){

            String[]  Total_venta =  new String[] {taco,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {tacoHarina,burger};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {tacoHarina,torta};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {tacoHarina,tortaEspecial};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {tacoHarina,burrita};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {tacoHarina,burritaco};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {tacoHarina,orden};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {tacoHarina,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {tacoHarina,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {tacoHarina,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio"))){

            String[]  Total_venta =  new String[] {tacoHarina,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {burger,torta};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {burger,tortaEspecial};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {burger,burrita};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {burger,burritaco};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {burger,orden};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {burger,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {burger,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {burger,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio"))){

            String[]  Total_venta =  new String[] {burger,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {torta,tortaEspecial};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {torta,burrita};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {torta,burritaco};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {torta,orden};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {torta,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {torta,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {torta,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio"))){

            String[]  Total_venta =  new String[] {torta,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&(tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {tortaEspecial,burrita};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&(tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {tortaEspecial,burritaco};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&(tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {tortaEspecial,orden};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&(tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {tortaEspecial,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&(tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {tortaEspecial,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&(tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {tortaEspecial,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&(tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio"))){

            String[]  Total_venta =  new String[] {tortaEspecial,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {burrita,burritaco};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {burrita,orden};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {burrita,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {burrita,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {burrita,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio"))){

            String[]  Total_venta =  new String[] {burrita,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {burritaco,orden};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {burritaco,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {burritaco,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {burritaco,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio"))){

            String[]  Total_venta =  new String[] {burritaco,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) &&  (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {orden,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) &&  (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {orden,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) &&  (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {orden,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) &&  (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio"))){

            String[]  Total_venta =  new String[] {orden,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) &&  (orden==null || orden.equals("0 orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {ordenMedia,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) &&  (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {ordenMedia,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) &&  (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio"))){

            String[]  Total_venta =  new String[] {ordenMedia,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) &&  (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {cocaPlastico,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) && (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) &&  (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio"))){

            String[]  Total_venta =  new String[] {cocaPlastico,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) &&  (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {taco,tacoHarina,burger};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) &&  (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {taco,tacoHarina,torta};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) &&  (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {taco,tacoHarina,tortaEspecial};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) &&  (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {taco,tacoHarina,burrita};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) &&  (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {taco,tacoHarina,burritaco};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) &&  (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {taco,tacoHarina,orden};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) &&  (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {taco,tacoHarina,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) &&  (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {taco,tacoHarina,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) &&  (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {taco,tacoHarina,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) &&  (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio"))){

            String[]  Total_venta =  new String[] {taco,tacoHarina,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) &&  (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {taco,burger,torta};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) &&  (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {taco,burger,tortaEspecial};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) &&  (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {taco,burger,burrita};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) &&  (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {taco,burger,burritaco};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) &&  (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {taco,burger,orden};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) &&  (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {taco,burger,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) &&  (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {taco,burger,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) &&  (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero"))){

            String[]  Total_venta =  new String[] {taco,burger,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) &&  (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio"))){

            String[]  Total_venta =  new String[] {taco,burger,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (burrita==null || burrita.equals("0 burrita")) &&  (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,torta,tortaEspecial};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) &&  (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,torta,burrita};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) &&  (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,torta,burritaco};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) &&  (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,torta,orden};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) &&  (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,torta,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) &&  (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,torta,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) &&  (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,torta,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) &&  (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {taco,torta,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,tortaEspecial,burrita};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,tortaEspecial,burritaco};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,tortaEspecial,orden};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,tortaEspecial,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,tortaEspecial,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,tortaEspecial,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {taco,tortaEspecial,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,burrita,burritaco};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,burrita,orden};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,burrita,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,burrita,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,burrita,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {taco,burrita,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,burritaco,orden};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,burritaco,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,burritaco,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,burritaco,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {taco,burritaco,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,orden,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,orden,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,orden,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {taco,orden,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,ordenMedia,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,ordenMedia,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {taco,ordenMedia,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {taco,cocaPlastico,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {taco,cocaPlastico,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) &&  (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) ){

            String[]  Total_venta =  new String[] {taco,cocaVidrio,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else{
            SaveProductsHarina();
        }

    }

    public void SaveProductsHarina(){

        if ((taco==null || taco.equals("0 taco")) &&  (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,burger,torta};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (torta==null || torta.equals("0 torta")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,burger,tortaEspecial};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,burger,burrita};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,burger,burritaco};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,burger,orden};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,burger,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,burger,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,burger,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {tacoHarina,burger,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,torta,tortaEspecial};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,torta,burrita};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,torta,burritaco};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,torta,orden};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,torta,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,torta,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,torta,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {tacoHarina,torta,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,tortaEspecial,burrita};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,tortaEspecial,burritaco};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,tortaEspecial,orden};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,tortaEspecial,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,tortaEspecial,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,tortaEspecial,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {tacoHarina,tortaEspecial,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,burrita,burritaco};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,burrita,orden};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,burrita,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,burrita,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,burrita,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {tacoHarina,burrita,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,burritaco,orden};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,burritaco,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,burritaco,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,burritaco,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {tacoHarina,burritaco,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,orden,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,orden,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,orden,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {tacoHarina,orden,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,ordenMedia,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,ordenMedia,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {tacoHarina,ordenMedia,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {tacoHarina,cocaPlastico,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (burger==null || burger.equals("0 burger")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {tacoHarina,cocaPlastico,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else {
            SaveProductsBurger();
        }
    }

    public void SaveProductsBurger(){

        if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,torta,tortaEspecial};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,torta,burrita};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,torta,burritaco};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,torta,orden};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,torta,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,torta,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,torta,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {burger,torta,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,tortaEspecial,burrita};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,tortaEspecial,burritaco};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,tortaEspecial,orden};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,tortaEspecial,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,tortaEspecial,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,tortaEspecial,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {burger,tortaEspecial,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,burrita,burritaco};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,burrita,orden};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,burrita,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,burrita,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,burrita,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {burger,burrita,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,burritaco,orden};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,burritaco,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,burritaco,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,burritaco,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {burger,burritaco,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,orden,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,orden,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,orden,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {burger,orden,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,ordenMedia,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,ordenMedia,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {burger,ordenMedia,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,cocaPlastico,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {burger,cocaPlastico,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }
    }

    public void SaveProductsTorta(){

        if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {torta,tortaEspecial,burrita};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {torta,tortaEspecial,burritaco};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {torta,tortaEspecial,orden};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {torta,tortaEspecial,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {torta,tortaEspecial,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {torta,tortaEspecial,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {torta,tortaEspecial,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {torta,burrita,burritaco};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {torta,burrita,orden};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {torta,burrita,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {torta,burrita,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {torta,burrita,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (burger==null || burger.equals("0 burger")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {torta,burrita,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,tortaEspecial,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {burger,tortaEspecial,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,burrita,burritaco};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,burrita,orden};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,burrita,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,burrita,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,burrita,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {burger,burrita,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,burritaco,orden};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,burritaco,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,burritaco,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,burritaco,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {burger,burritaco,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,orden,ordenMedia};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,orden,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,orden,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {burger,orden,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,ordenMedia,cocaPlastico};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,ordenMedia,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (cocaPlastico==null || cocaPlastico.equals("0 coca plastico")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {burger,ordenMedia,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaZero==null || cocaZero.equals("0 coca zero")) ){

            String[]  Total_venta =  new String[] {burger,cocaPlastico,cocaVidrio};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }else if ((taco==null || taco.equals("0 taco")) &&  (tacoHarina==null || tacoHarina.equals("0 taco harina")) && (torta==null || torta.equals("0 torta")) && (tortaEspecial==null || tortaEspecial.equals("0 torta especial")) && (burrita==null || burrita.equals("0 burrita")) && (burritaco==null || burritaco.equals("0 burritaco")) && (orden==null || orden.equals("0 orden")) && (ordenMedia==null || ordenMedia.equals("0 media orden")) && (cocaVidrio==null || cocaVidrio.equals("0 coca vidrio")) ){

            String[]  Total_venta =  new String[] {burger,cocaPlastico,cocaZero};

            String result_venta = ("" + Arrays.asList(Total_venta)).
                    replaceAll("(^.|.$)", "  ").replace(", ", "  , " );

            dbHandler = new DbHandler(Menu.this);
            dbHandler.insertUserDetails(Integer.toString(mostrar),result_venta);
            Nuevo();
            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
        }
    }

}
