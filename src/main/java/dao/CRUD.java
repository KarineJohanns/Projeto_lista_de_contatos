package dao;

import model.Contato;

import java.util.List;

public interface CRUD {
    public static void create(Contato contato){};
    public static void delete(int id){};
    public static List<Contato> find(String pesquisa){return null;}
    public static Contato findByPk(int clienteId) {return null;}
    public static void update(Contato contato) {};
}
