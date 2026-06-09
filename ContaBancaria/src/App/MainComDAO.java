package ContaBancaria.App;

import java.util.List;

import ContaBancaria.Modelo.Usuario;
import ContaBancaria.Service.SistemadoUsuario;
import ContaBancaria.UsuarioDAO.UsuarioDao;

import java.util.Scanner;

public class MainComDAO {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        UsuarioDao dao = new UsuarioDao();

        boolean ligado = true;

        while(ligado) {

            System.out.println("=======Opçães/=======");
            System.out.println(" 0 - Encerrar programa: ");
            System.out.println(" 1 - Criar conta: ");
            System.out.println(" 2 - Listar usuario:");
            System.out.println(" 3 - Listar usuarios:");
            System.out.println(" 4 - Adicionar saldo:");
            System.out.println(" 5 - Subtrair saldo: ");
            System.out.println(" 6 - deletar usuario:");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao) {
                case 1:

                System.out.println("Informe seu nome: ");
                String nome = sc.nextLine();

                System.out.println("Informe o saldo: ");
                double saldo = sc.nextDouble();

                System.out.println("Usuario salvo. ");
                Usuario user = new Usuario(nome, saldo);

                dao.salvar(user);

                break;
                case 2:
                    System.out.println("Informe o id: ");
                    int id = sc.nextInt();

                    user = dao.mostraPorId(id);

                    if (user != null) {
                        System.out.println(user);
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    

                break;
                case 3:

                List<Usuario> usuario = dao.listar();

                if (usuario.isEmpty()) {
                    System.out.println("Usuario não existe.");
                } else {

                    for(Usuario u1 : usuario) {
                    System.out.println(u1);

                }
                }

                break;
                case 4:

                System.out.println("Informe ID: ");
                id = sc.nextInt();

                System.out.println("Informe o valor: ");
                saldo = sc.nextDouble();

                dao.adicionarSaldo(id, saldo);

                break;
                case 5:

                System.out.println("Informe ID: ");
                id = sc.nextInt();

                System.out.println("Informe o valor: ");
                saldo = sc.nextDouble();

                dao.subtrairSaldo(id, saldo);

                break;
                case 6:

                System.out.println("Informe o id: ");
                id = sc.nextInt();

                dao.deletar(id);

                break;
                case 0:
                    System.out.println("Programa encerrado.");
                    ligado = false;

                    break;
                default:
                    System.out.println("Opção invalida. ");

            } 




        }

        sc.close();


    }

    
}
