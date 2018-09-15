package projetoteste.com.projetoteste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText nome,telefone,sobrenome,email;
    Button btnSalvar,btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.nome);
        telefone = findViewById(R.id.telefone);
        sobrenome = findViewById(R.id.sobrenome);
        email = findViewById(R.id.email);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnLimpar = findViewById(R.id.btnLimpar);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nome.setText(null);
                sobrenome.setText(null);
                telefone.setText(null);
                email.setText(null);
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nome.getText().length()==0){
                    nome.setError("Insira seu Nome");
                }

                if (sobrenome.getText().length()==0){
                    sobrenome.setError("Insira seu Sobrenome");
                }

                if (telefone.getText().length()==0){
                    telefone.setError("Insira seu Telefone");
                }

                if (email.getText().length()==0){
                    email.setError("Insira seu Email");
                }

                if (nome.getText().length()!=0 && sobrenome.getText().length()!=0 && telefone.getText().length()!=0 && email.getText().length()!=0) {
                    /*aqui será colocado a chamada com o banco futuramente, após fazer os testes e retornar caso haja algum campo não preenchido
                    * quando clicar no botão salvar, ele irá abrir um AlertDialog exibindo os dados inseridos e perguntará se deseja gravar esses
                    * dados no banco*/
                    Toast.makeText(getApplicationContext(),"Nome: "+nome.getText()+" Sobrenome: "+sobrenome.getText()+" Telefone: "+telefone.getText()+" E-mail: "+email.getText(), Toast.LENGTH_SHORT).show();
                }
            }


        });


    }
}
