package segundoapp.com.ti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nome,sobrenome,email,curso;
    Button btnSalvar,btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.nome);
        sobrenome = findViewById(R.id.sobrenome);
        email = findViewById(R.id.email);
        curso = findViewById(R.id.curso);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nome.setText(null);
                sobrenome.setText(null);
                email.setText(null);
                curso.setText(null);
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nome.getText().length()==0){
                    Toast.makeText(getApplicationContext(),"Insira seu Nome"+nome.getText(),Toast.LENGTH_SHORT).show();
                }
                if (sobrenome.getText().length()==0){
                    Toast.makeText(getApplicationContext(),"Insira seu Sobrenome"+sobrenome.getText(),Toast.LENGTH_SHORT).show();
                }
                if (email.getText().length()==0){
                    Toast.makeText(getApplicationContext(),"Insira seu E-mail"+email.getText(),Toast.LENGTH_SHORT).show();
                }
                if (curso.getText().length()==0) {
                    Toast.makeText(getApplicationContext(), "insira seu Curso" + curso.getText(), Toast.LENGTH_SHORT).show();
                }
                if (nome.getText().length()!=0 && sobrenome.getText().length()!=0 && email.getText().length()!=0 && curso.getText().length()!=0) {
                    Toast.makeText(getApplicationContext(), "Nome: " + nome.getText(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Sobrenome: " + sobrenome.getText(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "E-mail: " + email.getText(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "Curso: " + curso.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
