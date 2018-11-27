package br.com.senaijandira.projetomvp.util;

public class DateUtil {


    public String convertToString(int data){

        String dataString = String.valueOf(data);

        String ano = dataString.substring(0, 4);

        String mes = dataString.substring(4, 6);

        String dia = dataString.substring(6, 8);

        return String.format("%s/%s/%s", dia, mes , ano);
    }

    public int convertToInt(String data){

        //Quebra a String a partir da /
       String[]  dataSplit = data.split("/");

       //01/02/2000
       String dia = dataSplit[0];// Vetor na posição 1
       String mes = dataSplit[1]; //Vetor na posição 2
       String ano = dataSplit[2]; //Vetor na posição 3

        //String q inverte a posição dos vetores
       String dataFormatada = ano + mes + dia;

        //TODO: fazer lógica
        return Integer.parseInt(dataFormatada);
    }
}
