package recyclerview.jmdevelopers.com.recyclerview.activity.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import recyclerview.jmdevelopers.com.recyclerview.R;
import recyclerview.jmdevelopers.com.recyclerview.activity.RecyclerItemClickListener;
import recyclerview.jmdevelopers.com.recyclerview.activity.adapter.Adapter;
import recyclerview.jmdevelopers.com.recyclerview.activity.model.Filme;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Filme> listafilmes= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerViewid);

        // Listando filmes
        this.criarfilmes();
        // configurar o adapter
        Adapter adapter=new Adapter(listafilmes);

        // configurar o recycler
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        //adicionando o divisor de cada item
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        // tamanho fixo
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        // clique
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Filme filme=listafilmes.get(position);
                // pegando a posição
                Toast.makeText(getApplicationContext(),"foi clicado"+filme.getTituloFilme(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Filme filme=listafilmes.get(position);

                Toast.makeText(getApplicationContext(),"foi clicado longo"+filme.getTituloFilme() ,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));
    }
    public void criarfilmes(){
        Filme filme = new Filme("Homem aranha","ação","2018");
        this.listafilmes.add(filme);
        filme = new Filme("brasil","or","2018");
        this.listafilmes.add(filme);
        filme = new Filme("hoje","amor","2015");
        this.listafilmes.add(filme);
    }
}
