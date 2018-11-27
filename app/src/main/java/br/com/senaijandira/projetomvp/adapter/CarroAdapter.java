package br.com.senaijandira.projetomvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.senaijandira.projetomvp.R;
import br.com.senaijandira.projetomvp.model.Carro;

public class CarroAdapter extends ArrayAdapter<Carro>{

    //Construindo um ArrayAdapter e passando o contexto por parametro
    public CarroAdapter(Context ctx){

        //Construtor padrão, criando uma lista vazia
        super(ctx, 0, new ArrayList<Carro>());
    }

    //
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //variavel para criar uma view. Cada bloco é uma view
        View v = convertView;


        if(v == null){
            v = LayoutInflater.from(getContext()).inflate(R.layout.list_view_item, parent, false);
        }

        //Pegando Carro por posicao
        Carro carro = getItem(position);

        //Exibe na tela inicial o NOME e o FABRICANTE do CARRO
        TextView txtNome = v.findViewById(R.id.txtNomeCarro);
        TextView txtFabricante = v.findViewById(R.id.txtFabricanteCarro);

        //Criando o setText de NOME e PLACA do CARRO
        txtNome.setText(carro.getNome());

        txtFabricante.setText(carro.getPlaca()+"");

        return v;
    }
}

