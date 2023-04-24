package com.example.examen4echevarne.ui.gallery;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen4echevarne.R;
import com.example.examen4echevarne.modelo.Nota;

import java.util.List;

public class NotaAdapter extends RecyclerView.Adapter<NotaAdapter.ViewHolder> {
    private Context context;
    private List<Nota> notas;
    private LayoutInflater layoutInflater;

    public NotaAdapter(Context context, List<Nota> notas, LayoutInflater layoutInflater) {
        this.context = context;
        this.notas = notas;
        this.layoutInflater = layoutInflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root=layoutInflater.inflate(R.layout.nota,parent,false);
        return new  ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.titulo.setText(notas.get(position).getTitulo()+"");
        holder.prioridad.setText(notas.get(position).getPrioridad()+"");
        holder.fecha.setText(notas.get(position).getFecha()+"");
    }

    @Override
    public int getItemCount() {
        return notas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titulo,fecha,prioridad;
        Button btnDetalle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo=itemView.findViewById(R.id.tvTiulo);
            fecha=itemView.findViewById(R.id.tvFecha);
            prioridad=itemView.findViewById(R.id.tvPrioridad);
            btnDetalle=itemView.findViewById(R.id.btnDetalle);

            btnDetalle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("notas", notas.get(getAdapterPosition()));
                    bundle.putSerializable("index",getAdapterPosition());

                    Navigation.findNavController( (Activity)context,R.id.nav_host_fragment_content_main).navigate(R.id.action_nav_gallery_to_descripcion,bundle);
                }
            });
        }
    }


}
