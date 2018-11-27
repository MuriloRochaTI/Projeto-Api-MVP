package br.com.senaijandira.projetomvp.presenter;

import android.util.Log;

import java.util.List;

import br.com.senaijandira.projetomvp.model.Carro;
import br.com.senaijandira.projetomvp.service.CarroService;
import br.com.senaijandira.projetomvp.view.MainView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {

    MainView mainView;
    CarroService service;

    public MainPresenter(MainView mainview, CarroService service){
        this.mainView = mainview;
        this.service = service;
    }

    //Carregar a lista de Carros
    public void carregarCarros() {

        //Objeto de chamada a API de carros
        Call<List<Carro>> call = service.obterCarros();

           mainView.exibirBarraProgresso();
        //Efetuar a chamada a API
        call.enqueue(new Callback<List<Carro>>() {
            @Override
            public void onResponse(Call<List<Carro>> call, Response<List<Carro>> response) {

                //Lista de carros retornada pelo servidor
                List<Carro> carros = response.body();

                //*** EXIBE A LISTA DE CARROS NA TELA ***
                mainView.preencherLista(carros);

                //Esconde a barra de progresso após o carregando da lista de carros
                mainView.esconderBarraProgresso();
            }

            @Override
            public void onFailure(Call<List<Carro>> call, Throwable t) {
                Log.e("ERRO_API", t.getMessage());
            }
        });

    }
}
