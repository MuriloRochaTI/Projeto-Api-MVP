package br.com.senaijandira.projetomvp.service;

import java.util.List;

import br.com.senaijandira.projetomvp.model.Carro;
import br.com.senaijandira.projetomvp.model.ApiResult;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CarroService {

    String URL_BASE = "http://10.0.2.2:5002/";

    @GET("/carros")
    Call<List<Carro>> obterCarros();

    @GET("/carro/{id}")
    Call<Carro> obterCarroPorId(@Path("id") int id);

    //Call = chamada; ApiResult = sucesso, msg;
    @POST("/novo")
    Call<ApiResult> cadastrarCarro(@Body Carro carro);

}


