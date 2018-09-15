package media.ronei.com.calculodemediaescolar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PrimeiroBimestreActivity extends AppCompatActivity {

    TextView txtResultado, txtSituacaoFinal;
    EditText editMateria, editNotaProva, editNotaTrabalho;
    Button btnCalcular;

    String apr, rpr;

    double notaProva, notaTrabalho, media;
    boolean dadosValidados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primeiro_bimestre_activity_main);

        txtResultado = findViewById(R.id.txtResultado);
        txtSituacaoFinal = findViewById(R.id.txtSituacaoFinal);
        editMateria = findViewById(R.id.editMateria);
        editNotaProva = findViewById(R.id.editNotaProva);
        editNotaTrabalho = findViewById(R.id.editNotaTrabalho);
        btnCalcular = findViewById(R.id.btnCalcular);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editNotaProva.getText().toString().length()>0) {
                    notaProva = Double.parseDouble(editNotaProva.getText().toString());
                    dadosValidados = true;
                }else {
                    editNotaProva.setError("Complete o campo!");
                    dadosValidados = false;
                }

                if (editNotaTrabalho.getText().toString().length()>0) {
                    notaTrabalho = Double.parseDouble(editNotaTrabalho.getText().toString());
                    dadosValidados = true;
                }else {
                    editNotaTrabalho.setError("Complete campo");
                    dadosValidados = false;
                }

                if (editMateria.getText().toString().equals("")){
                    editMateria.setError("Complete o campo");
                    dadosValidados = false;
                }else {
                    dadosValidados = true;
                }

                if (dadosValidados) {
                    media = (notaProva + notaTrabalho) / 2;
                    txtResultado.setText(String.valueOf(media));

                    apr = "Aprovado!";
                    rpr = "Reprovado!";

                    if (media >= 7) txtSituacaoFinal.setText(apr);
                    else txtSituacaoFinal.setText(rpr);
                }
            }
        });


    }


}
