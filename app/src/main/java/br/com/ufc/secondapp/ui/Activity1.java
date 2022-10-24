package br.com.ufc.secondapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import br.com.ufc.secondapp.dao.CarroDAO;
import br.com.ufc.secondapp.model.Carro;
import br.com.ufc.secondapp.R;

public class Activity1 extends AppCompatActivity {
    static private Button add,edt;
    static private EditText identification;
    static private ListView listCar;
    private final CarroDAO dao = new CarroDAO();
    static private ArrayAdapter myAdapter;
    private final static List<Carro> carros = new ArrayList<>();
    static private String item;
    static private Integer indexVal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        inicializacaoDosCampos();
        carros.add(new Carro(1,"Amarelo","Camaro","2021"));
        carros.add(new Carro(2,"Amarelo","Camaro","2014"));
        carros.add(new Carro(3,"Amarelo","Camaro","2012"));
        configurandoBtnAdd();
        ItemlListCar();
        configurandoBtnEdt();
        configurandoListCar();


    }

    private void ItemlListCar() {
        listCar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(Activity1.this,"posição"+i,Toast.LENGTH_SHORT).show();
                indexVal = i;
            }
        });
    }

    private void configurandoListCar() {
        myAdapter = new ArrayAdapter<>(Activity1.this, android.R.layout.simple_spinner_item,dao.todos());
        listCar.setAdapter(myAdapter);
    }

    private void inicializacaoDosCampos() {
        add = findViewById(R.id.Adicionar);
        edt = findViewById(R.id.Editar);
        identification = findViewById(R.id.identificador);
        listCar = findViewById(R.id.listCar);

    }

    private void configurandoBtnEdt() {
        edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity1.this, Activity2.class);
                int valor = Integer.parseInt(identification.getText().toString());
                    for (Carro car : dao.todos()
                    ) {
                        if (car.getId() == valor) {
                            intent.putExtra("posicao",dao.todos().indexOf(car));
                            intent.putExtra("id", valor);
                            intent.putExtra("cor", car.getCor());
                            intent.putExtra("modelo", car.getModelo());
                            intent.putExtra("ano", car.getAno());
                            intent.putExtra("edit",true);
                            startActivity(intent);
                            myAdapter.notifyDataSetChanged();
                            identification.setText("");
                            return;

                        }
                    }
                    Toast.makeText(Activity1.this, "Id não existe", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void configurandoBtnAdd() {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(Activity1.this, Activity2.class);
                    intent.putExtra("car", identification.getText().toString());
                    startActivity(intent);
                    identification.setText("");
            }
        });

    }


}