package com.biblioteca.gaia;

import java.sql.SQLException;
import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Biblioteca da Gaia - Menu");
                System.out.println("1. Inserir Livro");
                System.out.println("2. Selecionar Livros");
                System.out.println("3. Atualizar Disponibilidade");
                System.out.println("4. Deletar Livro");
                System.out.println("5. Inserir Usuário");
                System.out.println("6. Verificar Senha do Usuário");
                System.out.println("7. Consultar Top 10 Livros Mais Emprestados");
                System.out.println("8. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (opcao) {
                    case 1:
                        System.out.print("Titulo: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Autor: ");
                        String autor = scanner.nextLine();
                        System.out.print("Editora: ");
                        String editora = scanner.nextLine();
                        System.out.print("Ano de Publicacao: ");
                        int anoPublicacao = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        System.out.print("Genero: ");
                        String genero = scanner.nextLine();
                        System.out.print("Disponibilidade (true/false): ");
                        boolean disponibilidade = scanner.nextBoolean();
                        Livro.inserirLivro(titulo, autor, editora, anoPublicacao, genero, disponibilidade);
                        break;
                    case 2:
                        Livro.selecionarLivros();
                        break;
                    case 3:
                        System.out.print("ID do Livro: ");
                        int idAtualizar = scanner.nextInt();
                        System.out.print("Disponibilidade (true/false): ");
                        boolean novaDisponibilidade = scanner.nextBoolean();
                        Livro.atualizarDisponibilidade(idAtualizar, novaDisponibilidade);
                        break;
                    case 4:
                        System.out.print("ID do Livro: ");
                        int idDeletar = scanner.nextInt();
                        Livro.deletarLivro(idDeletar);
                        break;
                    case 5:
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Sobrenome: ");
                        String sobrenome = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Telefone: ");
                        String telefone = scanner.nextLine();
                        System.out.print("Senha: ");
                        String senha = scanner.nextLine();
                        Usuario.inserirUsuario(nome, sobrenome, email, telefone, senha);
                        break;
                    case 6:
                        System.out.print("ID do Usuário: ");
                        int idUsuario = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        System.out.print("Senha: ");
                        String senhaUsuario = scanner.nextLine();
                        boolean senhaValida = Usuario.verificarSenha(idUsuario, senhaUsuario);
                        System.out.println("Senha válida: " + senhaValida);
                        break;
                    case 7:
                        Livro.consultarTop10LivrosMaisEmprestados();
                        break;
                    case 8:
                        System.out.println("Saindo...");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
