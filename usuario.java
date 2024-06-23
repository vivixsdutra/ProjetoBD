package com.biblioteca.gaia;

import java.sql.*;

public class Usuario {
    public static void inserirUsuario(String nome, String sobrenome, String email, String telefone, String senha) throws SQLException {
        String query = "INSERT INTO Usuarios (Nome, Sobrenome, Email, Telefone, Senha) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nome);
            stmt.setString(2, sobrenome);
            stmt.setString(3, email);
            stmt.setString(4, telefone);
            stmt.setString(5, senha);
            stmt.executeUpdate();
        }
    }

    public static boolean verificarSenha(int id, String senha) throws SQLException {
        String query = "SELECT Senha FROM Usuarios WHERE ID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("Senha").equals(senha);
                }
            }
        }
        return false;
    }
}
