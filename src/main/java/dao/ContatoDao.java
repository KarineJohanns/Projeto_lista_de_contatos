package dao;

import db.MySqlConnection;
import model.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContatoDao implements CRUD{
    private static Connection connection = MySqlConnection.createConnection();
    private static String sql;


    public static void create(Contato contato){

        sql = "INSERT INTO pessoa VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, contato.getNome());
            preparedStatement.setString(2, contato.getCpf());
            preparedStatement.setString(3, contato.getTelefone());
            preparedStatement.setString(4, contato.getCelular());
            preparedStatement.setString(5, contato.getEmail());
            preparedStatement.setString(6, contato.getCep());
            preparedStatement.setString(7, contato.getEndereco());
            preparedStatement.setString(8, contato.getNumero());
            preparedStatement.setString(9, contato.getCidade());
            preparedStatement.setString(10, contato.getEstado());

            preparedStatement.executeUpdate();

            System.out.println("--Correct insert on database");

        } catch (SQLException e) {
            System.out.println("--Incorrect insert ond database. " + e.getMessage());
        }

    };
    public static void delete(int contatoId){

        sql = "delete from pessoa where id=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, contatoId);
            preparedStatement.executeUpdate();
            System.out.println("--Correct delete on contato");

        } catch (SQLException e) {
            System.out.println("--Incorrect delete on contato");
        }
    };
    public static List<Contato> find(String pesquisa) {

        sql = String.format("SELECT * FROM pessoa WHERE nome like '%s%%' OR cpf LIKE '%s%%' ", pesquisa, pesquisa);
        List<Contato> contatos = new ArrayList<Contato>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Contato contato = new Contato();
                contato.setId(resultSet.getInt("id"));
                contato.setNome(resultSet.getString("nome"));
                contato.setTelefone(resultSet.getString("telefone"));
                contato.setCelular(resultSet.getString("celular"));
                contato.setEmail(resultSet.getString("email"));
                contato.setCpf(resultSet.getString("cpf"));
                contato.setCep(resultSet.getString("cep"));
                contato.setEndereco(resultSet.getString("endereco"));
                contato.setCidade(resultSet.getString("cidade"));
                contato.setEstado(resultSet.getString("estado"));

                contatos.add(contato);
            }
            System.out.println("--Correct find contato");
            return contatos;

        } catch (SQLException e) {
            System.out.println("--Incorrect find contato. " + e.getMessage());
            return null;
        }
    }
    public static Contato findByPk(int contatoId) {

        sql = String.format("SELECT * FROM pessoa WHERE id = %d", contatoId);
        Contato contato = new Contato();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){

                contato.setId(resultSet.getInt("id"));
                contato.setNome(resultSet.getString("nome"));
                contato.setTelefone(resultSet.getString("telefone"));
                contato.setEndereco(resultSet.getString("endereco"));
                contato.setEmail(resultSet.getString("email"));

            }
            System.out.println("--Correct find by pk");
            return contato;

        } catch (SQLException e){
            System.out.println("--Incorrect find by pk. " +e.getMessage());
            return null;
        }
    }
    public static void update(Contato contato) {
        sql = "UPDATE pessoa SET nome=?, telefone=?, celular=?, email=?, cpf=?, cep=?, endereco=?, numero=?, cidade=?, estado=? where id=?";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, contato.getNome());
            preparedStatement.setString(2, contato.getTelefone());
            preparedStatement.setString(3, contato.getCelular());
            preparedStatement.setString(4, contato.getEmail());
            preparedStatement.setString(5, contato.getCpf());
            preparedStatement.setString(6, contato.getCep());
            preparedStatement.setString(7, contato.getEndereco());
            preparedStatement.setString(8, contato.getNumero());
            preparedStatement.setString(9, contato.getCidade());
            preparedStatement.setString(10, contato.getEstado());
            preparedStatement.setInt(11, contato.getId());

            preparedStatement.executeUpdate();

            System.out.println("--Correct update on Database");

        } catch (SQLException e) {
            System.out.println("--Incorrect update on Database. " + e.getMessage());
        }
    };
}
