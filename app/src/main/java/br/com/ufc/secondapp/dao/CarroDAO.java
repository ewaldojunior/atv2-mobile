package br.com.ufc.secondapp.dao;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.ufc.secondapp.model.AdpterListView;
import br.com.ufc.secondapp.model.Carro;

public class CarroDAO {
    private final static List<Carro> carros = new ArrayList<>();
    AdpterListView adL = new AdpterListView();
    public void salva(Carro carro) {
        carros.add(carro);
    }

    public void editCar(int id, Carro carro) {
        for (Carro car:carros
             ) {
            if(car.getId() == id){
                carros.set(id, carro);
            }
        }
    }
    public List<Carro> todos() {
        return new ArrayList<>(carros);
    }
}
