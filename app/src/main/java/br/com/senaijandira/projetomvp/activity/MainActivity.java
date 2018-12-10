package br.com.senaijandira.projetomvp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;

import br.com.senaijandira.projetomvp.R;
import br.com.senaijandira.projetomvp.adapter.CarroAdapter;
import br.com.senaijandira.projetomvp.model.Carro;
import br.com.senaijandira.projetomvp.presenter.MainPresenter;
import br.com.senaijandira.projetomvp.service.ServiceFactory;
import br.com.senaijandira.projetomvp.view.MainView;


//implementando o contrato
public class MainActivity extends AppCompatActivity implements MainView, AdapterView.OnItemClickListener {

    //Declarando a ListView
    ListView listView;

    //Declarando o CarroAdapter
    CarroAdapter adapter;

    //Declarando o progressBar
    ProgressBar progressBar;

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progressBar = findViewById(R.id.progressBar);

        listView = findViewById(R.id.listView);

        //Instância do Adapter
        adapter = new CarroAdapter(this);

        //Plugar o adpter na lista
        listView.setAdapter(adapter);

        //Clique da lista
        listView.setOnItemClickListener(this);

        //config presenter
        presenter = new MainPresenter(this, ServiceFactory.create());

    }

    @Override
    protected void onResume() {
        super.onResume();

        //Atualizar a Lista
        presenter.carregarCarros();
    }

    //Funcao para exibir
    @Override
    public void exibirBarraProgresso(){
        progressBar.setVisibility(View.VISIBLE);//Visivel
        listView.setVisibility(View.GONE);//Invisivel
    }
    //Funcao para esconder
    @Override
    public void esconderBarraProgresso(){
        progressBar.setVisibility(View.GONE);//Invisivel
        listView.setVisibility(View.VISIBLE);//Visivel
    }

    //funcao para preencher a list view
    @Override
    public void preencherLista(List<Carro> lstCarros){
        adapter.clear();
        adapter.addAll(lstCarros);
    }


    //Activity de Cadastro *ALT+ENTER*
    public void abrirCadastro(View view) {
        startActivity(new Intent(this, CadastroActivity.class));//Abrir uma nova activity ao clicar no botão
    }

    //TODO: Identifica o clique na lista
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Carro carroSelecionado = adapter.getItem(position);

        Intent intent = new Intent(this,VisualizarActivity.class);
        intent.putExtra("idCarro", carroSelecionado.getId());

        startActivity(intent);
    }
}
