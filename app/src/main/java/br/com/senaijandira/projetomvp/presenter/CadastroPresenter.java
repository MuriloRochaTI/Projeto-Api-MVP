package br.com.senaijandira.projetomvp.presenter;


import br.com.senaijandira.projetomvp.model.ApiResult;
import br.com.senaijandira.projetomvp.model.Carro;
import br.com.senaijandira.projetomvp.service.CarroService;
import br.com.senaijandira.projetomvp.view.CadastroView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroPresenter {

    CadastroView view;
    CarroService service;

    //ATALHO --> ALT + INSERT
    public CadastroPresenter(CadastroView view, CarroService service) {
        this.view = view;
        this.service = service;
    }

    public void cadastrarCarro(Carro carro){
        //Efetuar a chamada; Callback interface
        service.cadastrarCarro(carro).enqueue(new Callback<ApiResult>() {
            @Override
            public void onResponse(Call<ApiResult> call, Response<ApiResult> response) {

                ApiResult result = response.body();

                if(result.isSucesso()){
                    view.showMessage ("Sucesso", "Cadastrado com sucesso!");

                }else{
                    view.showMessage("Erro", "Erro ao cadastrar");
                    //txtNome.setTextColor(Color.parseColor("#e80404"));
                }
            }

            @Override
            public void onFailure(Call<ApiResult> call, Throwable t) {
                view.showMessage("Erro", t.getMessage());
                t.printStackTrace();
            }
        });
    }
}
