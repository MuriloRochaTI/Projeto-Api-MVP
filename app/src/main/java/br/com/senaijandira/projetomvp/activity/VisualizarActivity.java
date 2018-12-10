package br.com.senaijandira.projetomvp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import br.com.senaijandira.projetomvp.R;
import br.com.senaijandira.projetomvp.model.Carro;
import br.com.senaijandira.projetomvp.presenter.VisualizarPresenter;
import br.com.senaijandira.projetomvp.service.CarroService;
import br.com.senaijandira.projetomvp.service.ServiceFactory;
import br.com.senaijandira.projetomvp.util.DateUtil;
import br.com.senaijandira.projetomvp.view.VisualizarCarroView;


public class VisualizarActivity extends AppCompatActivity implements VisualizarCarroView {

    //Declarando as EditText
    TextView txtNome, txtDtLancamento, txtPlaca, txtFabricante;

    //Instanciando a classe de serviço da API
    CarroService service = ServiceFactory.create();

    VisualizarPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        txtNome = findViewById(R.id.txtNome);
        txtDtLancamento = findViewById(R.id.txtDtLancamento);
        txtPlaca = findViewById(R.id.txtPlaca);
        txtFabricante = findViewById(R.id.txtFabricante);

        //Instância do presenter
        presenter = new VisualizarPresenter(this, ServiceFactory.create());

        int idCarro = getIntent().getIntExtra("idCarro", 0);

        //carregar carro
        presenter.carregarCarro(idCarro);

    }

    @Override
    public void mostrarDadosCarro(Carro carro) {

        DateUtil util = new DateUtil();

        txtNome.setText(carro.getNome());
        txtFabricante.setText(carro.getFabricante());
        txtPlaca.setText(carro.getPlaca()+"");
        txtDtLancamento.setText(util.convertToString(carro.getDataLancamento()));

    }

}
