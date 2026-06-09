package ContaBancaria.UsuarioDAO;

import ContaBancaria.Modelo.Usuario;
import ContaBancaria.Database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class UsuarioDao {

    public void salvar(Usuario usuario) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = Conexao.conectar();

            String sql = "INSERT INTO usuarios (nome, saldo) VALUES (?, ?)";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, usuario.getNome());
            stmt.setDouble(2, usuario.getSaldo());

            stmt.executeUpdate();

        }catch (Exception e) {
            System.out.println("erro ao adicionar Usuario.");
            e.printStackTrace();
        } finally {
            try {

                if (conn != null) conn.close();
                if (stmt != null) stmt.close();

            }catch (Exception e) {
                System.out.println("erro ao fechar.");
            }
        }

    }

    public List<Usuario> listar() {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            List<Usuario> usuarios = new ArrayList<>(); 

            conn = Conexao.conectar();

            String sql = "SELECT * FROM usuarios";
            stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                String nome = rs.getString("nome");
                int id = rs.getInt("id");
                double saldo = rs.getDouble("saldo");

                Usuario u = new Usuario(nome, id, saldo);

                usuarios.add(u);

            }
            System.out.println("Quantidade:" + usuarios.size());
            return usuarios;

        }catch (Exception e) {
            System.out.println("erro ao listar.");
            return null;
        } finally {
            try {
                if (conn != null) conn.close();
                if (stmt != null) stmt.close();

            } catch (Exception e) {
                System.out.println("erro ao fechar.");
            }
        }

    }

    public Usuario mostraPorId(int id) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = Conexao.conectar();

            String sql = "SELECT * FROM usuarios WHERE id = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                String nome = rs.getString("nome");
                double saldo = rs.getDouble("saldo");

                Usuario u = new Usuario(nome, id, saldo);

                return u;

            }

            return null;

        }catch (Exception e) {
            System.out.println("erro ao mostrar usuario.");
            return null;
        } finally {
            try {
                if (conn != null) conn.close();
                if (stmt != null) stmt.close();

            }catch (Exception e) {
                System.out.println("erro ao fechar.");
            }
        }

    }

    public void atualizar(Usuario usuario) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = Conexao.conectar();

            String sql = "UPDATE usuarios SET saldo = ? WHERE id = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setDouble(1, usuario.getSaldo());
            stmt.setInt(2, usuario.getId());

            stmt.executeUpdate();


        }catch (Exception e) {
            System.out.println("erro ao atualizar.");
        } finally {
            try {
                if (conn != null) conn.close();
                if (stmt != null) stmt.close();

            }catch (Exception e) {
                System.out.println("erro ao fechar.");
            }
        }


    }

    public void adicionarSaldo(int id, double saldo) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = Conexao.conectar();

            String sql = "UPDATE usuarios SET saldo = saldo + ? WHERE id = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setDouble(1, saldo);
            stmt.setInt(2, id);

            stmt.executeUpdate();


        }catch (Exception e) {
            System.out.println("erro ao atualizar.");
        } finally {
            try {
                if (conn != null) conn.close();
                if (stmt != null) stmt.close();

            }catch (Exception e) {
                System.out.println("erro ao fechar.");
            }
        }


    }

    public void subtrairSaldo(int id, double saldo) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = Conexao.conectar();

            String sql = "UPDATE usuarios SET saldo = saldo - ? WHERE id = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setDouble(1, saldo);
            stmt.setInt(2, id);

            stmt.executeUpdate();


        }catch (Exception e) {
            System.out.println("erro ao atualizar.");
        } finally {
            try {
                if (conn != null) conn.close();
                if (stmt != null) stmt.close();

            }catch (Exception e) {
                System.out.println("erro ao fechar.");
            }
        }


    }

    public void deletar(int id) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = Conexao.conectar();
            String sql = "DELETE FROM usuarios WHERE id = ?";

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.executeUpdate();


        }catch (Exception e) {
            System.out.println("erro ao deletar.");
        }finally {
            try {
                if (conn != null) conn.close();
                if (stmt != null) stmt.close();

            }catch (Exception e) {
                System.out.println("erro ao fechar.");
            }
        }

    }

}
