package ContaBancaria.Service;

import java.util.Map;

import ContaBancaria.Modelo.Usuario;

import java.util.HashMap;
import java.util.Collection;

public class SistemadoUsuario {
    Map<Integer, Usuario> usuarios = new HashMap<>();

    public String adicionarCliente(int id, Usuario usuario) {

        Usuario existente = usuarios.get(id);

        if (existente == null) {
            return "Usuário inválido. ";
        }
        if (existente != null) {
            return "Usúario já cadastrado. ";
        }
            usuarios.put(id, usuario);
            return "Usúsrio cadastrado com sucesso! ";

    }

    public String removerConta(int id) {

        Usuario user = usuarios.get(id);

        if (user == null) {
            return "Usuário não essiste. ";
        }
            usuarios.remove(id);
            return "Usuário removido com sucesso. ";

    }

    public boolean adicionarSaldo(int id, double valor) {

        Usuario usuario = usuarios.get(id);

        if (usuario == null && valor <= 0) {
            return false;
        }

        usuario.setSaldo(usuario.getSaldo() + valor);
            return true;

    }

    public String sacarSaldo(int id, double valorSaque) {

        Usuario user = usuarios.get(id);

        if (user == null) {
            return "Usuário não existe. ";
        }
        if (valorSaque <= 0) {
            return "Valor Inválido. ";
        }
        if (user.getSaldo() < valorSaque) {
            return "Saldo insuficiente. ";
        }

        user.setSaldo(user.getSaldo() - valorSaque);
        return "Saque efetuado com sucesso. ";
    
    
    }

    public Usuario buscarConta(int id) {

        Usuario user = usuarios.get(id);
        
        if (user != null) {
            return user;
        }

        return null;

    }


        public Collection<Usuario> listarUsuarios() {
            return usuarios.values();
        }

    

    public String transferenciaEntreContas(int numeroConta, int numeroConta02, double valorDaTransferencio) {
        Usuario user01 = usuarios.get(numeroConta);
        Usuario user02 = usuarios.get(numeroConta02);

        if (user01 == null) {
            return "Conta origem não existe. ";
        }

        if (user02 == null) {
            return "Conta destino não ixiste. ";
        }

        if (valorDaTransferencio <= 0) {
            return "Valor inválido. ";
        }

        if (user01.getSaldo() < valorDaTransferencio) {
            return "Saldo insuficiente. ";
        }

        user01.setSaldo(user01.getSaldo() - valorDaTransferencio);
        user02.setSaldo(user02.getSaldo() + valorDaTransferencio);

            return "Transferencia comcluida. ";


    }






}



    

