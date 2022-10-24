package br.com.ufc.secondapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.ufc.secondapp.R;
import br.com.ufc.secondapp.dao.CarroDAO;
import br.com.ufc.secondapp.model.Carro;

public class Activity2 extends AppCompatActivity {

    static private EditText id,cor,modelo,ano;
    private final Activity1 act1 = new Activity1();
    private CarroDAO dao = new CarroDAO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        iniciandoComponentes();
        configurandoBtnSalvar();
        configurandoBtnCancelar();
        setIdentification();
        setObjetoIndentificador();


    }

    private void setObjetoIndentificador() {
        String idV = getIntent().getStringExtra("car");
        id.setText(idV);
    }

    private void setIdentification() {
        String id1 = getIntent().getStringExtra("id1");
        String cor1 = getIntent().getStringExtra("cor");
        String modelo1 = getIntent().getStringExtra("modelo");
        String ano1 = getIntent().getStringExtra("ano");
        id.setText(id1);
        cor.setText(cor1);
        modelo.setText(modelo1);
        ano.setText(ano1);

    }

    private void configurandoBtnCancelar() {
        Button cancelar = findViewById(R.id.act2Cancelar);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void configurandoBtnSalvar() {
        Button salvar = findViewById(R.id.act2Salvar);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean edit = getIntent().getBooleanExtra("edit",true);
                    Carro carroCriado = criaCarro();
                    salva(carroCriado);
            }
        });
    }


    private void salva(Carro carro) {
        dao.salva(carro);
        finish();
          }

          public void editar(int id, Carro carro){
        dao.editCar(id,carro);
        finish();
          }

    private Carro criaCarro() {
              int idCarro = Integer.valueOf(id.getText().toString());
              String corCarro = cor.getText().toString();
              String modeloCarro = modelo.getText().toString();
              String anoCarro = ano.getText().toString();

              return new Carro(idCarro, corCarro, modeloCarro, anoCarro);
          }


    private void iniciandoComponentes() {
        id = findViewById(R.id.act2Id);
        cor = findViewById(R.id.act2Cor);
        modelo = findViewById(R.id.act2Modelo);
        ano = findViewById(R.id.act2Ano);
    }

}