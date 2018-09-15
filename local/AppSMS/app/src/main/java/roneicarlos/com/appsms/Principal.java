package roneicarlos.com.appsms;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    //criar um objeto para o SMS - sdk android
    SmsManager objSmsManager;

    Button btnEnviar;
    EditText editSMSPara;
    EditText editSMSMensagem;

    String smsPara;
    String smsMensagem;

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode){
            case 1:{
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if (ContextCompat.checkSelfPermission(Principal.this,
                            Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this,"Permissão concedida", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this, "Permissão negada", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        if (ContextCompat.checkSelfPermission(Principal.this,
                Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(Principal.this,
                    Manifest.permission.SEND_SMS)){
                ActivityCompat.requestPermissions(Principal.this,
                        new String[]{Manifest.permission.SEND_SMS},1);
            }else {
                ActivityCompat.requestPermissions(Principal.this,
                        new String[]{Manifest.permission.SEND_SMS},1);
            }
        }

        editSMSPara = findViewById(R.id.editSMSPara);
        editSMSMensagem = findViewById(R.id.editSMSMensagem);

        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smsPara = editSMSPara.getText().toString();
                smsMensagem = editSMSMensagem.getText().toString();

                if (editSMSMensagem.length()==0 && editSMSPara.length()!=0){
                    editSMSMensagem.requestFocus();
                    editSMSMensagem.setError("Não podes enviar mensagem vazia!");
                }
                else if (editSMSMensagem.length()!=0 && editSMSPara.length()==0){
                    editSMSPara.requestFocus();
                    editSMSPara.setError("Deves ter um número destinatário!");
                }
                else if (editSMSPara.length()==0 && editSMSMensagem.length()==0){
                    editSMSMensagem.requestFocus();
                    editSMSMensagem.setError("Não podes enviar mensagem vazia!");
                    editSMSPara.requestFocus();
                    editSMSPara.setError("Deves ter um número destinatário!");
                }
                else {
                    objSmsManager = SmsManager.getDefault();
                    objSmsManager.sendTextMessage(smsPara,null,smsMensagem,null,null);

                    Toast.makeText(getApplicationContext(),"Enviando SMS...",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
