package recyclerview.jmdevelopers.com.recyclerview.activity.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import recyclerview.jmdevelopers.com.recyclerview.R;
import recyclerview.jmdevelopers.com.recyclerview.activity.model.Filme;

/**
 * Created by Jamerson Macedo on 20/08/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{
   private List<Filme> listafilmes;
// construtor
    public Adapter(List<Filme> lista)
    {
        this.listafilmes=lista;
    }

    @NonNull
    @Override
    // cria as vizualizações

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // converter o xml do adapter
        // layoutinflater converte
        View itemlista= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list,parent,false);

        return new MyViewHolder(itemlista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Filme filme= listafilmes.get(position);

        holder.titulo.setText(filme.getTituloFilme());
        holder.genero.setText(filme.getGenero());
        holder.ano.setText(filme.getAno());

    }

    @Override
    public int getItemCount() {
        return listafilmes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titulo;
        TextView ano;
        TextView genero;


        public MyViewHolder(View itemView) {
            super(itemView);

            titulo=itemView.findViewById(R.id.tituloid);
            ano=itemView.findViewById(R.id.anoid);
            genero=itemView.findViewById(R.id.generoid);
        }
    }
}
