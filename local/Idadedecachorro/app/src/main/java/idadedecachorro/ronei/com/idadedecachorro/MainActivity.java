package idadedecachorro.ronei.com.idadedecachorro;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import static idadedecachorro.ronei.com.idadedecachorro.R.*;

public class MainActivity extends AppCompatActivity {

    EditText idadeCachorro;
    Button btnDescobrirIdade;
    TextView resultadoIdade;
    ImageView imgCachorro;

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        //atribui as variáveis na memória
        idadeCachorro = findViewById(id.idadeCachorro);
        btnDescobrirIdade = findViewById(id.btnDescobrirIdade);
        resultadoIdade = findViewById(id.resultadoIdade);
        imgCachorro = findViewById(id.imgCachorro);


        //clique no botão
        btnDescobrirIdade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //se o campo for vazio ira exibir um erro e tocará um rosnado
                //se o campo estiver completo ele irá fazer o cálculo e exibirá na tela a idade
                //em anos humanos não incrementais e tocará um latido
                if (idadeCachorro.getText().toString().isEmpty()||idadeCachorro.getText().toString().equals("0")){

                    idadeCachorro.setError("Complete o campo");
                    resultadoIdade.setText("");

                    mp = MediaPlayer.create(MainActivity.this, raw.rosnado);
                    mp.start();

                }else{

                    int calculo = Integer.parseInt(idadeCachorro.getText().toString());

                    String exibe = String.valueOf(calculo*7);

                    resultadoIdade.setText(("Seu cachorro tem, em anos humanos, "+exibe+" anos."));

                    mp = MediaPlayer.create(MainActivity.this, raw.latido);
                    mp.start();

                }

            }
        });

        //quando pressionado por um periodo de tempo, o botão de calcuar limpará o campo da idade
        //e tocará um rangido de cachorro
        btnDescobrirIdade.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                idadeCachorro.setText("");
                resultadoIdade.setText("");

                mp = MediaPlayer.create(MainActivity.this, raw.rangido);
                mp.start();

                return true;
            }
        });

        //quando pressionado por um período de tempo a imagem do robô canino
        //irá reproduzir o áudio de um meme
        imgCachorro.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mp = MediaPlayer.create(MainActivity.this, raw.troll);
                mp.start();

                return false;
            }
        });


    }
}
