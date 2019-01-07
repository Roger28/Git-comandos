package com.example.android.gitcomandos.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.gitcomandos.R;
import com.example.android.gitcomandos.db.entity.Comando;

import java.util.ArrayList;
import java.util.List;

/**
 * Sexta classe a ser criada
 * O adapter receberá os dados da ViewModel e mostrará na UI
 * Interface para setar click na lista do recyclerview
 **/

public class ComandoAdapter extends RecyclerView.Adapter<ComandoAdapter.ComandoHolder> {

    private OnItemClickListener listener;
    private List<Comando> comandos = new ArrayList<>();

    public void setComandos(List<Comando> comandos){
        this.comandos = comandos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ComandoHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ComandoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComandoHolder comandoHolder, int position) {
        Comando current = this.comandos.get(position);
        comandoHolder.textViewComando.setText(current.getComando());
        comandoHolder.textViewDescricao.setText(current.getDescricao());
    }

    @Override
    public int getItemCount() {
        return this.comandos.size();
    }

    private Comando getComandoAt(int position) {
        return this.comandos.get(position);
    }

    class ComandoHolder extends RecyclerView.ViewHolder {
        private TextView textViewComando;
        private TextView textViewDescricao;

        ComandoHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewComando = itemView.findViewById(R.id.text_view_comando);
            this.textViewDescricao = itemView.findViewById(R.id.text_view_descricao);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getComandoAt(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Comando comando);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

}
