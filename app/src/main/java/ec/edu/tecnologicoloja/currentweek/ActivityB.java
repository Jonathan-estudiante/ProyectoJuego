package ec.edu.tecnologicoloja.currentweek;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ec.edu.tecnologicoloja.currentweek.R;

public class ActivityB extends AppCompatActivity {

    private Button jugar;
    private TextView textoValores, textoFinal;
    private EditText textoNumero;
    private int aleatorio, intentos=3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);


        // Set views

        jugar = (Button) findViewById(R.id.btn_comprobar);
        textoValores = (TextView) findViewById(R.id.txt_valores);
        textoNumero = (EditText) findViewById(R.id.txt_numero);
        textoFinal = (TextView) findViewById(R.id.txt_final);

        aleatorio= aleatorio();
        System.out.println(aleatorio);

        // Set Listeners
        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if(textoNumero.getText().length()==0){
                        textoValores.setText("NO HAY VALORES...");
                    }else{
                        int numero;
                        numero=Integer.parseInt(textoNumero.getText().toString());
                        if (numero <1 || numero>10) {
                            textoValores.setText("INGRESE NÚMERO DEL 1 AL 10");
                        }else
                        if(aleatorio!=numero){
                            intentos=intentos-1;
                            textoValores.setText("INCORRECTO...TE QUEDAN "+ intentos+ " INTENTOS");
                            textoNumero.setText("");
                        }else{
                            textoNumero.setText("");
                            Intent intent = new Intent(ActivityB.this, ActivityA.class);
                            intent.putExtra("dato1","GANASTE...");
                            startActivity(intent);
                        }
                        if (intentos==0){
                            textoNumero.setText("");
                            Intent intent = new Intent(ActivityB.this, ActivityA.class);
                            intent.putExtra("dato1","PERDISTE...");
                            startActivity(intent);

                        }
                }
            }
        });

    }
    private int aleatorio(){
        return (int)(Math.random()*10+1);
    }
}
