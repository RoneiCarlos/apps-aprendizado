package mediaescolar.ronei.com.mediaescolar3;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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

                    salvarSharedPreferences();
                }
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Desenvolvido por: Ronei Carlos", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id== R.id.limpar){
            editMateria.setText("");
            editNotaProva.setText("");
            editNotaTrabalho.setText("");
            txtResultado.setText("");
            txtSituacaoFinal.setText("");
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sair) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void salvarSharedPreferences(){

        SharedPreferences mediaEscolarPref = getSharedPreferences("mediaEscolarPref",0);

        SharedPreferences.Editor mediaEscolar = mediaEscolarPref.edit();

        mediaEscolar.putString("editMateriaPrimeiroBimestre", editMateria.getText().toString());
        mediaEscolar.putString("notaProvaPrimeiroBimestre", String.valueOf(notaProva));
        mediaEscolar.putString("notaTrabalhoPrimeiroBimestre", String.valueOf(notaTrabalho));
        mediaEscolar.putString("mediaPrimeiroBimestre", String.valueOf(media));
        mediaEscolar.putString("txtResultadoPrimeiroBimestre", txtResultado.getText().toString());
        mediaEscolar.putString("txtSituacaoFinalPrimeiroBimestre", txtSituacaoFinal.getText().toString());
        mediaEscolar.putBoolean("primeiroBimestre", true);

        mediaEscolar.apply();
    }

}
