package br.com.ufc.secondapp.model;


import java.io.Serializable;

public class Carro implements Serializable {
    private int id;
    private String cor;
    private String modelo;
    private String ano;

    public Carro(int id, String cor, String modelo, String ano) {
        this.id = id;
        this.cor = cor;
        this.modelo = modelo;
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Carro [ " + " Id = " + id + ", cor = "+ modelo +  ", modelo = " + cor +  ", ano = " + ano+ " ]";
    }
}
