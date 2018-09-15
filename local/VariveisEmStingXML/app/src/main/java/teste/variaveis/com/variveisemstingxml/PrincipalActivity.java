package teste.variaveis.com.variveisemstingxml;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class PrincipalActivity extends AppCompatActivity {

    EditText inReais;
    TextView txtExibeDolar, txtExibeEuro;
    Button btnConverter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        inReais = findViewById(R.id.inReais);
        txtExibeDolar = findViewById(R.id.txtExibeDolar);
        txtExibeEuro = findViewById(R.id.txtExibeEuro);
        btnConverter = findViewById(R.id.btnConverter);

        btnConverter.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {

                String c = String.valueOf(inReais.getText());
                if (c.equals("")){
                    inReais.setError("O campo deve ser preenchido!");
                    txtExibeDolar.setText("");
                    txtExibeEuro.setText("");
                }else{
                    Float valor = Float.parseFloat(inReais.getText().toString());
                    txtExibeDolar.setText(String.format("%.2f", valor / 3.5705));
                    txtExibeEuro.setText(String.format("%.2f", valor / 4.2601));
                }
            }
        });
    }
}
