package com.mycompany.lojaInformatica.DAO;

import com.mycompany.lojainformatica.model.computador;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando.fernandes
 */
public class lojaInformaticaDAO {

    public static String url = "jdbc:mysql://localhost:3306/lojaInformatica";
    public static String login = "root";
    public static String senha = "";

   
    public static boolean salvar(computador obj) {
       
        Connection conexao = null;
        boolean retorno = false;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            
            conexao = DriverManager.getConnection(url, login, senha);

            
            PreparedStatement comandoSQL = conexao.prepareStatement(
                    "INSERT INTO "
                            + "lojainformatica (marca, HD, processador) "
                            + "VALUES(?,?,?)");
            comandoSQL.setString(1, obj.getMarca());
            comandoSQL.setString(2, obj.getHD());
            comandoSQL.setString(3, obj.getProcessador());

            
            int linhasAfetadas = comandoSQL.executeUpdate(); 
            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return retorno;
    }

    public static ArrayList<computador> listar() {

        Connection conexao = null;
        ArrayList<computador> lista = new ArrayList<computador>();

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            conexao = DriverManager.getConnection(url, login, senha);

            
            PreparedStatement comandoSQL
                    = conexao.prepareStatement("SELECT * FROM lojainformatica");

           
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    computador novoObjeto = new computador();
                    novoObjeto.setHD(rs.getString("HD"));
                    novoObjeto.setProcessador(rs.getString("processador"));

                    lista.add(novoObjeto);

                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return lista;
    }

    public static computador consultarPorProcessador(String processador) {
        computador lista = new computador();

        
        return lista;
    }

    public static boolean atualizar(computador obj) {

        Connection conexao = null;
        boolean retorno = false;

        try {

            
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            conexao = DriverManager.getConnection(url, login, senha);

            
            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE lojainformatica SET HD=?, processador=? WHERE marca = ?");
            comandoSQL.setString(1, obj.getMarca());
            comandoSQL.setString(2, obj.getHD());
            comandoSQL.setString(3, obj.getProcessador());
            
            

            
            int linhasAfetadas = comandoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return retorno;
    }

    public static boolean excluir(String marca) {

        Connection conexao = null;
        boolean retorno = false;

        try {

            
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            conexao = DriverManager.getConnection(url, login, senha);

            
            PreparedStatement comandoSQL = conexao.prepareStatement("DELETE FROM computador WHERE processador=?");
            comandoSQL.setString(1,marca);

            
            int linhasAfetadas = comandoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return retorno;

    }

}
