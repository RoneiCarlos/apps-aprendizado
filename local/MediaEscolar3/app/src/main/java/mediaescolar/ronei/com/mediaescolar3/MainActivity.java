package mediaescolar.ronei.com.mediaescolar3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnPrimeiroBimestre,btnSegundoBimestre,btnTerceiroBimestre,btnQuartoBimestre,btnMediaFinal;
    boolean primeiroBimestre, segundoBimestre, terceiroBimestre, quartoBimestre;
    String situacaoFinalPrimeiroBimestre, situacaoFinalSegundoBimestre, situacaoFinalTerceiroBimestre, situacaoFinalQuartoBimestre;
    String materiaPrimeiroBimestre, materiaSegundoBimestre, materiaTerceiroBimestre, materiaQuartoBimestre;
    String notaProvaPrimeiroBimestre, notaProvaSegundoBimestre, notaProvaTerceiroBimestre, notaProvaQuartoBimestre;
    String notaTrabalhoPrimeiroBimestre, notaTrabalhoSegundoBimestre, notaTrabalhoTerceiroBimestre, notaTrabalhoQuartoBimestre;
    String mediaPrimeiroBimestre, mediaSegundoBimestre, mediaTerceiroBimestre, mediaQuartoBimestre;

    String txtPrimeiroBimestretxt,txtSegundoBimestretxt, txtTerceiroBimestretxt, txtQuartoBimstretxt;

    double mediaFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lerSharedPreferences();

        btnPrimeiroBimestre = findViewById(R.id.btnPrimeiroBimestre);
        btnSegundoBimestre = findViewById(R.id.btnSegundoBimestre);
        btnTerceiroBimestre = findViewById(R.id.btnTerceiroBimestre);
        btnQuartoBimestre = findViewById(R.id.btnQuartoBimestre);
        btnMediaFinal = findViewById(R.id.btnMediaFinal);

        btnPrimeiroBimestre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, PrimeiroBimestreActivity.class);
                startActivity(it);
            }
        });

        btnSegundoBimestre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, SegundoBimestreActivity.class);
                startActivity(it);
            }
        });

        btnTerceiroBimestre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, TerceiroBimestreActivity.class);
                startActivity(it);
            }
        });

        btnQuartoBimestre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, QuartoBimestreActivity.class);
                startActivity(it);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Limpando todos os registros...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                clearSharePreferences();
            }
        });
        visualizarResultados();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_sair) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume(){
        super.onResume();

        lerSharedPreferences();
        visualizarResultados();
    }

    private void lerSharedPreferences(){
        SharedPreferences mediaEscolarPref = getSharedPreferences("mediaEscolarPref",0);

        primeiroBimestre = mediaEscolarPref.getBoolean("primeiroBimestre",false);
        situacaoFinalPrimeiroBimestre = mediaEscolarPref.getString("txtSituacaofinalPrimeiroBimestre","");
        materiaPrimeiroBimestre = mediaEscolarPref.getString("editMateriaPrimeiroBimestre", "");
        mediaPrimeiroBimestre = mediaEscolarPref.getString("mediaPrimeiroBimestre", "0.0");
        notaProvaPrimeiroBimestre = mediaEscolarPref.getString("notaProvaPrimeiroBimestre", "0.0");
        notaTrabalhoPrimeiroBimestre = mediaEscolarPref.getString("notaTrabalhoPrimeiroBimestre", "0.0");

        segundoBimestre = mediaEscolarPref.getBoolean("segundoBimestre",false);
        situacaoFinalSegundoBimestre = mediaEscolarPref.getString("txtSituacaofinalSegundoBimestre","");
        materiaSegundoBimestre = mediaEscolarPref.getString("editMateriaSegundoBimestre", "");
        mediaSegundoBimestre = mediaEscolarPref.getString("mediaSegundoBimestre", "0.0");
        notaProvaSegundoBimestre = mediaEscolarPref.getString("notaProvaSegundoBimestre", "0.0");
        notaTrabalhoSegundoBimestre = mediaEscolarPref.getString("notaTrabalhoSegundoBimestre", "0.0");

        terceiroBimestre = mediaEscolarPref.getBoolean("terceiroBimestre",false);
        situacaoFinalTerceiroBimestre = mediaEscolarPref.getString("txtSituacaofinalTerceiroBimestre","");
        materiaTerceiroBimestre = mediaEscolarPref.getString("editMateriaTerceiroBimestre", "");
        mediaTerceiroBimestre = mediaEscolarPref.getString("mediaTerceiroBimestre", "0.0");
        notaProvaTerceiroBimestre = mediaEscolarPref.getString("notaProvaTerceiroBimestre", "0.0");
        notaTrabalhoTerceiroBimestre = mediaEscolarPref.getString("notaTrabalhoTerceiroBimestre", "0.0");

        quartoBimestre = mediaEscolarPref.getBoolean("quartoBimestre",false);
        situacaoFinalQuartoBimestre = mediaEscolarPref.getString("txtSituacaofinalQuartoBimestre","");
        materiaQuartoBimestre = mediaEscolarPref.getString("editMateriaQuartoBimestre", "");
        mediaQuartoBimestre = mediaEscolarPref.getString("mediaQuartoBimestre", "0.0");
        notaProvaQuartoBimestre = mediaEscolarPref.getString("notaProvaQuartoBimestre", "0.0");
        notaTrabalhoQuartoBimestre = mediaEscolarPref.getString("notaTrabalhoQuartoBimestre", "0.0");
    }

    private void visualizarResultados(){
        if (primeiroBimestre){
            txtPrimeiroBimestretxt = materiaPrimeiroBimestre+" - 1º Bimestre "+situacaoFinalPrimeiroBimestre+" - Nota "+mediaPrimeiroBimestre;
            btnPrimeiroBimestre.setText(txtPrimeiroBimestretxt);
            btnPrimeiroBimestre.setEnabled(false);
            btnSegundoBimestre.setEnabled(primeiroBimestre);
        }

        if (segundoBimestre){
            txtSegundoBimestretxt = materiaSegundoBimestre+" - 2º Bimestre "+situacaoFinalSegundoBimestre+" - Nota "+mediaSegundoBimestre;
            btnSegundoBimestre.setText(txtSegundoBimestretxt);
            btnSegundoBimestre.setEnabled(false);
            btnTerceiroBimestre.setEnabled(segundoBimestre);
        }

        if (terceiroBimestre){
            txtTerceiroBimestretxt = materiaTerceiroBimestre+" - 3º Bimestre "+situacaoFinalTerceiroBimestre+" - Nota "+mediaTerceiroBimestre;
            btnTerceiroBimestre.setText(txtTerceiroBimestretxt);
            btnTerceiroBimestre.setEnabled(false);
            btnQuartoBimestre.setEnabled(terceiroBimestre);
        }

        if (quartoBimestre) {
            txtQuartoBimstretxt = materiaQuartoBimestre + " - 4º Bimestre " + situacaoFinalQuartoBimestre + " - Nota " + mediaQuartoBimestre;
            btnQuartoBimestre.setText(txtQuartoBimstretxt);
            btnQuartoBimestre.setEnabled(false);
            btnMediaFinal.setEnabled(true);

            mediaFinal = 0;
            mediaFinal += Double.parseDouble(mediaPrimeiroBimestre);
            mediaFinal += Double.parseDouble(mediaSegundoBimestre);
            mediaFinal += Double.parseDouble(mediaTerceiroBimestre);
            mediaFinal += Double.parseDouble(mediaQuartoBimestre);

            String mensagemFinal;

            mediaFinal /=4;

            if ((Double.parseDouble(mediaPrimeiroBimestre)>=7)
                    && (Double.parseDouble(mediaSegundoBimestre)>=7)
                    && (Double.parseDouble(mediaTerceiroBimestre)>=7)
                    && (Double.parseDouble(mediaQuartoBimestre)>=7)){
                mensagemFinal = mediaFinal >= 7 ?
                        "Aprovado com média final " + mediaFinal :
                        "Reprovado com média final " + mediaFinal;
            }else{
                mensagemFinal = "Reprovado por matéria com média final " + mediaFinal;
            }

            btnMediaFinal.setText(mensagemFinal);
        }
    }

    private void clearSharePreferences(){
        SharedPreferences mediaEscolarPref = getSharedPreferences("mediaEscolarPref", 0);
        SharedPreferences.Editor editor = mediaEscolarPref.edit();
        editor.clear();
        editor.apply();

        clearMenu();
    }

    private void clearMenu(){

        btnPrimeiroBimestre.setEnabled(true);
        btnSegundoBimestre.setEnabled(false);
        btnTerceiroBimestre.setEnabled(false);
        btnQuartoBimestre.setEnabled(false);
        btnMediaFinal.setEnabled(false);

        btnPrimeiroBimestre.setText("1º Bimestre");
        btnSegundoBimestre.setText("2º Bimestre");
        btnTerceiroBimestre.setText("3º Bimestre");
        btnQuartoBimestre.setText("4º Bimestre");
        btnMediaFinal.setText("Média Final");
    }
}