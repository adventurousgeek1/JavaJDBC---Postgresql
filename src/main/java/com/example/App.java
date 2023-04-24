package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

public class App {
    public static void main(String[] args) {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/informaticateste",
                    "postgres", "admin4");
            if (conexao != null) {
                System.out.println("banco conectado com sucesso");
                Statement stm = conexao.createStatement();
                consultaDados(stm);
            } else {
                System.out.println("conexao falhada!");
            }
        } catch (Exception e) {

        }

    }

    static void consultaDados(Statement stm) {
        String query = "select id, nome, from clientes";

        try {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("id") + ",  Nome : " + rs.getString("nome"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
