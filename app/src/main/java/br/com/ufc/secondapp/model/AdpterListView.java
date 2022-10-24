package br.com.ufc.secondapp.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.zip.Inflater;

import br.com.ufc.secondapp.R;

public class AdpterListView extends BaseAdapter {
    private ArrayList<Carro> carros;



    @Override
    public int getCount() {
        return carros.size();
    }

    @Override
    public Object getItem(int id) {
        return carros.get(id);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
