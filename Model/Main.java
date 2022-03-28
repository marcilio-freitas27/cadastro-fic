package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author Marc�lio
 */

public class Main {

    /**
     * @param args the command line arguments
     */
    
    /* criando constantes para inserir dados nas listas e que serão exibidos*/
    public static final List<Professor> professores = new ArrayList<Professor>();
    public static final List<Turma> turmas = new ArrayList<Turma>();
    public static final List<Curso> cursos = new ArrayList<Curso>();
    /* entrada de dados com scanner*/
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]) {
	
    /* menus de escolha de opções*/
	/* enquanto for verdadeiro execute*/
        while (true) {
	    /* switch representa a opcao de cadastro e exibição dos dados.
	     * */
            switch (menuCadastro()) {
                case 1:
                    menuProfessor();
                    break;
                case 2:
                    menuCursos();
                    break;
                case 3:
                    menuTurmas();
                    break;
                case 4:
                    return;
            }
        }
    }
	public static void menuProfessor(){
        while (true) {
            switch(menuCadastroProfessor()){
                case 1:
                    cadastroProfessores();
                    break;
                case 2:
                    listarProfessores();
                    break;
                case 3:
                    salarioProfessor();
                    break;
                case 4:
                    return;
            }
        }
    }

    public static void menuCursos(){
        while (true) {
            switch(menuCadastroCurso()){
                case 1:
                    cadastroCursos();
                    break;
                case 2:
                    listarCursos();
                    break;
                case 3:
                    incluirTurmas();
                    break;
                case 4:
                    return;
            }
        }
    }

    public static void menuTurmas(){
        while (true) {
            switch(menuCadastroTurma()){
                case 1:
                    cadastroTurmas();
                    break;
                case 2:
                    listarTurmas();
                    break;
                case 3:
                    incluirProfessor();
                case 4:
                    return;
            }
        }
    }
    
    /* métodos para menus de cadastro.*/

     /* menu inicial*/
    public static int menuCadastro(){
        System.out.println("Ocurso - Formando profissionais.");
        System.out.println("Qual a operção deseja fazer? Escolha entre 1 e 4. ");
        System.out.println("1 - Menu professor");
        System.out.println("2 - Menu curso");
        System.out.println("3 - Menu turma");
        System.out.println("4 - Sair");
        System.out.println("Dashboard: ");
        System.out.println("Turmas " +  " Cursos " + " Professores");
        System.out.println("     " + turmas.size() + " --- " + cursos.size() + " --- " + professores.size());
	/* opcao que o usuário irá executar */
        int opcao = scanner.nextInt();
        return opcao;
    }

    public static int menuCadastroProfessor(){
        System.out.println("Qual a operção deseja fazer? Escolha entre 1 e 4. ");
        System.out.println("1 - Cadastrar professor");
        System.out.println("2 - Listar professor");
        System.out.println("3 - Calcular salário do professor");
        System.out.println("4 - voltar");
	/* opcao que o usuário irá executar */
        int opcao = scanner.nextInt();
        return opcao;
    }

    public static int menuCadastroCurso(){
        System.out.println("Qual a operção deseja fazer? Escolha entre 1 e 4. ");
        System.out.println("1 - Cadastrar curso");
        System.out.println("2 - Listar cursos");
        System.out.println("3 - Inserir turma");
        System.out.println("4 - Voltar");
	/* opcao que o usuário irá executar */
        int opcao = scanner.nextInt();
        return opcao;
    }

    public static int menuCadastroTurma(){
        System.out.println("Qual a operção deseja fazer? Escolha entre 1 e 4. ");
        System.out.println("1 - Cadastrar turma");
        System.out.println("2 - Listar turmas");
        System.out.println("3 - Inserir professor");
        System.out.println("4 - Voltar");
	/* opcao que o usuário irá executar */
        int opcao = scanner.nextInt();
        return opcao;
    }

    

    /*métodos de incluir professores em turmas e turmas em cursos */

    private static void incluirTurmas() {
        System.out.println("Qual curso vc deseja incluir uma turma? ");
        listarCursos();
        int idCurso = scanner.nextInt();
        System.out.println("Digite o id da turma: ");
        listarTurmas();
        int idTurma = scanner.nextInt();
        if(idTurma > 0 && idTurma <= turmas.size()){
            cursos.get(idCurso - 1).getTurma().add(turmas.get(idTurma - 1));
        }
    }

    private static void incluirProfessor() {
        System.out.println("Qual turma vc deseja incluir um professor? ");
        listarTurmas();
        int idCurso = scanner.nextInt();
        System.out.println("Digite o id do professor: ");
        listarProfessores();
        int idProfessor = scanner.nextInt();
        if(idProfessor > 0 && idProfessor <= professores.size()){
            turmas.get(idCurso - 1).getProfessor().add(professores.get(idProfessor - 1));
        }
    }

    //exibir e calcular o salário do professor baseado nas horas trabalhadas

    private static void salarioProfessor() {
        System.out.println("Qual o professor você deseja calcular o salário? ");
        listarProfessores();
        int idProfessor = scanner.nextInt();
        System.out.println("Quantas horas trabalhadas? ");
        int horas = scanner.nextInt();
        System.out.println(professores.get(idProfessor - 1).calcularSalario(horas));
    }

    /* métodos de cadastro
     * Solicitam os dados, inserem na instância da classe
     * inserem na lista*/

    public static void cadastroProfessores(){
        System.out.println("Cadastro do professor.");
        System.out.println("Informe o nome do professor: ");
        // consumindo linha
        scanner.nextLine();
        String nome = scanner.nextLine();
        System.out.println("Informe o seu email: ");
        String email = scanner.nextLine();
        System.out.println("Qual o valor da hora/aula? ");
        double valor = Double.parseDouble(scanner.nextLine());
        Professor professor01 = new Professor(nome,email,valor);
        professores.add(professor01);
        System.out.println("Professor cadastrado com sucesso.");
    }


    public static void cadastroCursos(){
        System.out.println("Cadastro do curso.");
        System.out.println("Informe o nome do curso: ");
        scanner.nextLine();
        String nomeCurso = scanner.nextLine();
        System.out.println("Informe a carga horária: ");
        int carga = Integer.parseInt(scanner.nextLine());
        System.out.println("Qual o conteúdo do curso? ");
        String conteudo = scanner.nextLine();
        System.out.println("Qual o valor do curso? ");
        double valor = Double.parseDouble(scanner.nextLine());
        Curso curso01 = new Curso(carga,nomeCurso,conteudo,valor);
        cursos.add(curso01);
        System.out.println("Curso cadastrado com sucesso.");
    }

    public static void cadastroTurmas(){
        System.out.println("Cadastro da turma.");
        System.out.println("Informe o nome da turma: ");
        scanner.nextLine();
        String nomeTurma = scanner.nextLine();
        System.out.println("Informe a data de inicio: ");
        LocalDate inicio = LocalDate.parse(scanner.next());
        System.out.println("Informe a data de término: ");
        LocalDate termino = LocalDate.parse(scanner.next());
        Turma turma01 = new Turma(nomeTurma,inicio,termino);
        turmas.add(turma01);
        System.out.println("Turma cadastrada com sucesso.");
    }

    /*Métodos para listagem
     *Fazem a busca dos campos através do índice(get(indice)) */

    public static void listarProfessores(){
        System.out.println("ID --- Nome --- Email ---- Valor");
        for(int i = 0;i < professores.size();i++){
            System.out.println(i + 1 +" --- "+ professores.get(i).getNomeProfessor() +
            " --- "+ professores.get(i).getEmail() + 
            " --- " + professores.get(i).getValorHoraAula());
        }  
    }

    public static void listarCursos(){
        System.out.println("ID --- Nome --- Carga ---- Conteúdo ---- Valor --- Turma");
        for(int i = 0;i < cursos.size();i++){
            System.out.println(i + 1 + " - "+ cursos.get(i).getNomeCurso() +
            " --- "+ cursos.get(i).getCargaHoraria() + 
            " --- "+ cursos.get(i).getConteudo() + 
            " ---- "+cursos.get(i).getValorCurso());
            for (int j = 0; j < cursos.get(i).getTurma().size(); j++) {
                System.out.println(" --- "+cursos.get(j).getTurma().get(j).getNomeTurma());    
            }
            
        } 
    }

    public static void listarTurmas(){
        System.out.println("ID --- Nome --- Inicio ---- Término --- Professor");
        for(int i = 0;i < turmas.size();i++){
            System.out.println(i + 1 + " --- " + turmas.get(i).getNomeTurma() + 
            " --- " + turmas.get(i).getDataInicio() + 
            " --- " + turmas.get(i).getDataTermino());
            for (int j = 0; j < turmas.get(i).getProfessor().size(); j++) {
                System.out.println(" --- " + turmas.get(i).getProfessor().get(i).getNomeProfessor());    
            }
        }
    }
}
