package br.com.senaijandira.projetomvp.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceFactory {

    public static CarroService create(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CarroService.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(CarroService.class);
    }
}
