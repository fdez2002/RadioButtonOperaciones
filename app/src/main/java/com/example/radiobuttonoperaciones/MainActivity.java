package com.example.radiobuttonoperaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText numero_uno;
    private EditText numero_dos;
    private RadioGroup radioG;
    private RadioButton rb_suma;
    private RadioButton rb_resta;
    private RadioButton rb_multiplicacion;
    private RadioButton rb_division;
    private TextView tx_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializamos los componentes
        numero_uno = (EditText) findViewById(R.id.editTextNumber_1);
        numero_dos = (EditText) findViewById(R.id.editTextNumber_2);
        rb_suma = (RadioButton) this.findViewById(R.id.radioButton_sumar);
        rb_resta = (RadioButton) findViewById(R.id.radioButton_restar);
        rb_multiplicacion = (RadioButton) findViewById(R.id.radioButton_multiplicar);
        rb_division = (RadioButton) findViewById(R.id.radioButton_dividir);
        tx_resultado = (TextView) findViewById(R.id.textView_resultado);

        //Asignamos los distintos listener
        rb_suma.setOnClickListener(this);
        rb_resta.setOnClickListener(this);
        rb_multiplicacion.setOnClickListener(this);
        rb_division.setOnClickListener(this);


    }

    //Controlamos que control ha sido seleccionado
    @Override
    public void onClick(View view){
        double res = 0;
        double num1 = Integer.parseInt(numero_uno.getText().toString());
        double num2 = Integer.parseInt(numero_dos.getText().toString());

        //Cada boton tiene un valor unico en formato entero
        switch (view.getId()){//El metodo getid() nos devuelve el control que fue seleccionado en formato de entero
            case R.id.radioButton_sumar:
                res = num1 + num2;
                break;
            case R.id.radioButton_restar:
                res = num1 - num2;
                break;
            case R.id.radioButton_multiplicar:
                res = num1 * num2;
                break;
            case R.id.radioButton_dividir:
                if(num2 == 0){//Si num2 es igual a 0 nos devuelve un mensaje diciendo que no s epuede dividir por 0
                    Toast.makeText(this, "No se puede dividir por 0", Toast.LENGTH_SHORT).show();
                }else{
                    res = num1 / num2;
                }
                break;
        }
        //Comprobamos de nuevo si num2 = 0 y si esta seleccionado la opcion dividir, si es asi resultado dara un mensaje de error
        //Si no hara la operación sin ningun tipo de error
        if (view.getId() == R.id.radioButton_dividir && num2 == 0){
            tx_resultado.setText(("No se puede dividir por 0"));
        }else{
            tx_resultado.setText(String.valueOf(res));
        }

    }
}