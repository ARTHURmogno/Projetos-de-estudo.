package ContaBancaria.Modelo;

public class Usuario {

    private String nome;
    private int id;
    private double saldo;

    public Usuario(String nome, int id, double saldo) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome Inválido. ");
        }
        if (id < 10000 || id > 99999) {
            throw new IllegalArgumentException("Número da Conta Inválido. ");
        }
        if (saldo < 0) {
            throw new IllegalArgumentException("Saldo Não pode ser Negativo. ");
        }
        this.nome = nome;
        this.id = id;
        this.saldo = saldo;

    }

    public Usuario(int id, double saldo) {
        if (id < 10000 || id > 99999) {
            throw new IllegalArgumentException("Número da Conta Inválido. ");
        }
        if (saldo < 0) {
            throw new IllegalArgumentException("Saldo Não pode ser Negativo. ");
        }
        this.id = id;
        this.saldo = saldo;

    }

    public Usuario(String nome, double saldo) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome Inválido. ");
        }
        if (saldo < 0) {
            throw new IllegalArgumentException("Saldo Não pode ser Negativo. ");
        }
        this.nome = nome;
        this.saldo = saldo;

    }



    public String getNome()  {
        return nome;
    }

    public int getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "nome: " + nome +
        ", id: " + id +
        ", saldo: " + saldo; 

    }


}
