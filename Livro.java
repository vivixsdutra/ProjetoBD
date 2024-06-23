package com.biblioteca.gaia;

import java.sql.*;

public class Livro {
    public static void inserirLivro(String titulo, String autor, String editora, int anoPublicacao, String genero, boolean disponibilidade) throws SQLException {
        String query = "INSERT INTO Livros (Titulo, Autor, Editora, Ano_Publicacao, Genero, Disponibilidade) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, titulo);
            stmt.setString(2, autor);
            stmt.setString(3, editora);
            stmt.setInt(4, anoPublicacao);
            stmt.setString(5, genero);
            stmt.setBoolean(6, disponibilidade);
            stmt.executeUpdate();
        }
    }

    public static void selecionarLivros() throws SQLException {
        String query = "SELECT * FROM Livros";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID"));
                System.out.println("Titulo: " + rs.getString("Titulo"));
                System.out.println("Autor: " + rs.getString("Autor"));
                System.out.println("Editora: " + rs.getString("Editora"));
                System.out.println("Ano de Publicacao: " + rs.getInt("Ano_Publicacao"));
                System.out.println("Genero: " + rs.getString("Genero"));
                System.out.println("Disponibilidade: " + rs.getBoolean("Disponibilidade"));
                System.out.println();
            }
        }
    }

    public static void atualizarDisponibilidade(int id, boolean disponibilidade) throws SQLException {
        String query = "UPDATE Livros SET Disponibilidade = ? WHERE ID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setBoolean(1, disponibilidade);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

    public static void deletarLivro(int id) throws SQLException {
        String query = "DELETE FROM Livros WHERE ID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public static void consultarTop10LivrosMaisEmprestados() throws SQLException {
        String query = "SELECT * FROM Top10LivrosMaisEmprestados";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("Top 10 Livros Mais Emprestados:");
            while (rs.next()) {
                System.out.println("Titulo: " + rs.getString("Titulo") + " - Total de Empréstimos: " + rs.getInt("TotalEmprestimos"));
            }
        }
    }
}
