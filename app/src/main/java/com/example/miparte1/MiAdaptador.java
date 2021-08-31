package com.example.miparte1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

public class MiAdaptador extends
        RecyclerView.Adapter<MiAdaptador.ViewHolder> {
    private LayoutInflater inflador;
    private Vector<String> lista;

    Context micontext;
    public MiAdaptador(Context context, Vector<String> lista) {
        this.micontext = context;
        this.lista = lista;
        inflador = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflador.inflate(R.layout.miitem, parent, false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        holder.titulo.setText(lista.get(i));
        holder.miboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((InterfaceToast)micontext).mensaje("El item de la posición: "+ i + " Su valor es: " + lista.get(i));
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((InterfaceToast)micontext).mensaje("El item pulsado del itemview de la posición: "+ i + " Su valor es: " + lista.get(i));
            }
        });
    }
    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titulo, subtitutlo;
        public ImageView icon;
        Button miboton;
        ViewHolder(View itemView) {
            super(itemView);
            titulo = (TextView)itemView.findViewById(R.id.titulo);
            subtitutlo = (TextView)itemView.findViewById(R.id.subtitulo);
            miboton = itemView.findViewById(R.id.mibotonitem);
        }
    }
}
