package model;

import java.util.ArrayList;
import java.util.List;

public class ContaBancaria {

    private String titular;
    private String senha;
    private double saldo;
    private List<String> historico;

    public ContaBancaria(String titular, String senha) {
        this.titular = titular;
        this.senha = senha;
        this.saldo = 0.0;
        this.historico = new ArrayList<>();
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            historico.add("Depósito: +" + valor);
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            historico.add("Saque: -" + valor);
            return true;
        }
        return false;
    }

    public void exibirHistorico() {
        for (String h : historico) {
            System.out.println(h);
        }
    }
}
