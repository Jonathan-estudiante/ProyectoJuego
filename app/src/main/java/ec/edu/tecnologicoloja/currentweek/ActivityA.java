package ec.edu.tecnologicoloja.currentweek;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ec.edu.tecnologicoloja.currentweek.R;

public class ActivityA extends AppCompatActivity{

    private Button again;
    private TextView textFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        // Set views
        again = (Button) findViewById(R.id.btn_jugar);
        textFinal = (TextView) findViewById(R.id.txt_final);

        Bundle extras = getIntent().getExtras();
        String d1 = extras.getString("dato1");
        textFinal.setText(d1);
        if (d1.equals("GANASTE...")){
            textFinal.setTextColor(Color.GREEN);
        }else{
            textFinal.setTextColor(Color.RED);
        }

        // Set Listeners
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityA.this, ActivityB.class);
                startActivity(intent);
            }
        });
    }
}
