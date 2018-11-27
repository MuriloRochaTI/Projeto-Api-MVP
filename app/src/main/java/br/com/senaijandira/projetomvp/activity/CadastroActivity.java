package br.com.senaijandira.projetomvp.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

import br.com.senaijandira.projetomvp.R;
import br.com.senaijandira.projetomvp.model.Carro;
import br.com.senaijandira.projetomvp.presenter.CadastroPresenter;
import br.com.senaijandira.projetomvp.service.CarroService;
import br.com.senaijandira.projetomvp.service.ServiceFactory;
import br.com.senaijandira.projetomvp.util.DateUtil;
import br.com.senaijandira.projetomvp.view.CadastroView;


public class CadastroActivity extends AppCompatActivity implements CadastroView {

    //Declarando as EditText
    static EditText txtNome, txtDtLancamento, txtPlaca, txtFabricante;

    //Instanciando a classe de serviço da API
    CarroService service = ServiceFactory.create();

    CadastroPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        //Instância do presenter
        presenter = new CadastroPresenter(this, service);

        //Pegando o ID das EditText
        txtNome = findViewById(R.id.txtNome);
        txtDtLancamento = findViewById(R.id.txtDtLancamento);
        txtPlaca = findViewById(R.id.txtPlaca);
        txtFabricante = findViewById(R.id.txtFabricante);
    }

    //Cadastrar Carro
    public void cadastrarCarro(View view) {

        String nome = txtNome.getText().toString();
        String dtLancamento = txtDtLancamento.getText().toString();
        String placa = txtPlaca.getText().toString();
        String fabricante = txtFabricante.getText().toString();

        int dataFormatada = new DateUtil().convertToInt(dtLancamento);

        //Criando um novo carro
        Carro carro = new Carro();

        carro.setNome(nome);
        carro.setDataLancamento(dataFormatada);
        carro.setPlaca(Integer.parseInt(placa));
        carro.setFabricante(fabricante);

        presenter.cadastrarCarro(carro);

    }

    public void abrirCalendario(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }


    //CadastroView showMessage
    @Override
    public void showMessage(String titulo, String mensagem) { //ALERT

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(titulo);
        alert.setMessage(mensagem);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alert.show();
    }

    //ABRIR O CALENDÁRIO
    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {

            //String dia = String.format("%02d",day);
            //String mes = String.format("%02d", month+1);
            //String ano = String.format("%d", year);

            //Outra forma
            String data = String.format("%02d/%02d/%d", day, month, year);
            txtDtLancamento.setText(data);
        }
    }
}
