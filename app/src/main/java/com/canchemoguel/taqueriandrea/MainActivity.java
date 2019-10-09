package com.canchemoguel.taqueriandrea;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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
    private TextView ContadorTaco;
    private TextView ContadorArina;
    private TextView ContadorBurger;
    private TextView ContadorTorta;
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

    private TextView CambioDos;
    private TextView TotalDoS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Taquería Andrea");


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
        Total = (TextView)findViewById(R.id.TxtTotal) ;
        btnCobrar = (Button)findViewById(R.id.btncobrar);
        txtRecibido = (EditText)findViewById(R.id.TxtRecibo);
        btnLimpiar = (Button)findViewById(R.id.btnLimpiarOmitir);


        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
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
                            new AlertDialog.Builder(MainActivity.this);
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
                            Nuevo();
                            Toast.makeText(getApplicationContext(),"Guardado en la base de datos",Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Nuevo();
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
                }
            }
        });
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
        Total.setText("0");
        txtRecibido.setText("");
        mostrar = 0;
    }

    /*public void DarCambio(){
        if (mostrar > Integer.parseInt(txtRecibido.getText().toString())){
            Toast.makeText(getApplicationContext(),"Operación invalida,cantidad insuficiente",Toast.LENGTH_LONG).show();
        }else {
            txtRecibido.getText().toString();
            int dinero = Integer.valueOf(txtRecibido.getText().toString());
            int resultado = dinero - mostrar;
            Toast.makeText(getApplicationContext(),"Acción no permitida"+resultado,Toast.LENGTH_LONG).show();
        }
    }*/
}
