package exemplolistview.ronei.com.exemplolistview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    static final String[] cidades = new String[]{
            "Santa Rosa - RS",
            "Três de Maio - RS",
            "Horizontina - RS",
            "São Martinho - RS",
            "Boa Vista do Buricá - RS",
            "Santo Ângelo - RS",
            "Ijuí - RS",
            "Três Passos - RS",
            "Santo Augusto - RS",
            "Palmeira das Missões - RS",
            "Catuípe - RS",
            "Nova Candelária - RS",
            "Santo Cristo - RS",
            "Independência - RS",
            "Alegria - RS",
            "Humaitá - RS",
            "Crissiumal - RS",
            "Campo Novo - RS",
            "Entre-Ijuís - RS",
            "Santa Maria - RS",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //adapter
        setListAdapter(new ArrayAdapter<>(this, R.layout.activity_main, cidades));
        //setar lista
        ListView cidadesListView = getListView();
        //pegar o click
        cidadesListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Toast.makeText(getApplicationContext(),"Cidade "+cidades[position],Toast.LENGTH_LONG).show();
            }
        });
    }
}
