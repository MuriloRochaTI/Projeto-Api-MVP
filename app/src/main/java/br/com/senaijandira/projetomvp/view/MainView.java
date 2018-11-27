package br.com.senaijandira.projetomvp.view;

import java.util.List;

import br.com.senaijandira.projetomvp.model.Carro;


//MainActivity
public interface MainView {

    void exibirBarraProgresso();

    void esconderBarraProgresso();

    void preencherLista(List<Carro> lstCarros);

}