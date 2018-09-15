package conversor.ronei.com.conversordemoeda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText valorReais, cotacaoDolar, cotacaoEuro;
    TextView valorDolares, valorEuros;
    Button btnLimpar, btnConverter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorReais = findViewById(R.id.valorReais);
        cotacaoDolar = findViewById(R.id.cotacaoDolar);
        cotacaoEuro = findViewById(R.id.cotacaoEuro);
        valorDolares = findViewById(R.id.valorDolares);
        valorEuros = findViewById(R.id.valorEuros);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnConverter = findViewById(R.id.btnConverter);


        try{
            btnLimpar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    valorReais.setText("");
                    cotacaoDolar.setText("");
                    cotacaoEuro.setText("");
                    valorDolares.setText("");
                    valorEuros.setText("");
                }
            });


            btnConverter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String real = String.valueOf(valorReais.getText());
                    String dolar = String.valueOf(cotacaoDolar.getText());
                    String euro = String.valueOf(cotacaoEuro.getText());

                    if (real.equals("") || dolar.equals("") || euro.equals("")){
                        if(real.equals("")){
                            valorReais.setError("Insira um valor para converter");
                            valorReais.requestFocus();
                        }
                        if (euro.equals("")){
                            cotacaoEuro.setError("Insira uma cotação para o Euro");
                            cotacaoEuro.requestFocus();
                        }
                        if (dolar.equals("")){
                            cotacaoDolar.setError("Insira uma cotação para o Dólar");
                            cotacaoDolar.requestFocus();
                        }
                    }
                    if (real.length()!=0 && euro.length()!=0 && dolar.length()!=0){

                        Float valorReal = Float.parseFloat(valorReais.getText().toString());
                        Float valorDolar = Float.parseFloat(cotacaoDolar.getText().toString());
                        Float valorEuro = Float.parseFloat(cotacaoEuro.getText().toString());

                        valorDolares.setText(String.format("%.3f",valorReal/valorDolar));
                        valorEuros.setText(String.format("%.3f",valorReal/valorEuro));
                    }
                }
            });
        }catch (Exception i){
            Toast.makeText(getApplicationContext(),"Erro no APP", Toast.LENGTH_LONG).show();
        }
    }
}
