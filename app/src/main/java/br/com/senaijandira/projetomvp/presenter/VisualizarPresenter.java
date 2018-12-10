package br.com.senaijandira.projetomvp.presenter;


import android.util.Log;

import br.com.senaijandira.projetomvp.activity.VisualizarActivity;
import br.com.senaijandira.projetomvp.model.Carro;
import br.com.senaijandira.projetomvp.service.CarroService;
import br.com.senaijandira.projetomvp.view.VisualizarCarroView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VisualizarPresenter {

    VisualizarCarroView view;
    CarroService service;

    //ATALHO --> ALT + INSERT
    public VisualizarPresenter(VisualizarActivity view, CarroService service) {
        this.view = view;
        this.service = service;
    }

    public void carregarCarro(int idCarro){
        //Efetuar a chamada; Callback interface

        service.obterCarroPorId(idCarro).enqueue(new Callback<Carro>() {
            @Override
            public void onResponse(Call<Carro> call, Response<Carro> response) {
                //TODO: CERTO!!!

                Carro al = response.body();
                view.mostrarDadosCarro(al);
                Log.d("SUCESSO!", "String");
            }

            @Override
            public void onFailure(Call<Carro> call, Throwable t) {
                Log.d("SUCESSO!", t.getMessage());
            }

        });

    }

}
