package br.com.senaijandira.projetomvp.model;

import com.google.gson.annotations.SerializedName;

public class Carro {

    private int id;
    private String nome;
    @SerializedName("data_lancamento")
    private int dataLancamento;
    private int placa;
    private String fabricante;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(int dataNascimento) {
        this.dataLancamento = dataLancamento;
    }

    public int getPlaca() {
        return placa;
    }

    public void setPlaca(int placa) {
        this.placa = placa;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }



}
