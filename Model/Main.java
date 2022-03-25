import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.IndexOutOfBoundsException;

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
	
	/* enquanto for verdadeiro execute*/
        while (true) {
	    /* switch representa a opcao de cadastro e exibição dos dados.
	     * */
            switch (menuCadastro()) {
                case 1:
                /* Por enquanto os cadastros precisar ser feitos um apoós o outro e nessa ordem:
                * Turma precisa do professor
                * Curso precisa da turma
                */
                    cadastroProfessores();
                    cadastroTurmas();
                    cadastroCursos();
                    break;
                case 2:
                    listarProfessores();
                    break;
                case 3:
                    try {
                        listarCursos();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Lista vazia. Por favor, cadastre pelo menos uma turma." + e);
                    }
                    break;
                case 4:
                    try {
                        listarTurmas();
                    } catch (Exception e) {
                        System.out.println("Lista vazia. Por favor, cadastre pelo menos uma turma." + e);
                    }
                    break;
                case 5:
                    return;
            }
        }

    }
	
    /* métodos de cadastro
     * Solicitam os dados, inserem na instância da classe
     * inserem na lista*/

     /* menu inicial*/
    public static int menuCadastro(){
        System.out.println("Ocurso - Formando profissionais.");
        System.out.println("Qual a operção deseja fazer? Escolha entre 1 e 5. ");
        System.out.println("1 - Cadastrar professor, curso e turma");
        System.out.println("2 - Listar professor");
        System.out.println("3 - Listar curso");
        System.out.println("4 - Listar turma");
        System.out.println("5 - Sair");
	/* opcao que o usuário irá executar */
        int opcao = scanner.nextInt();
        return opcao;
    }

    public static void cadastroProfessores(){
        System.out.println("Cadastro do professor.");
        System.out.println("Informe o nome do professor: ");
        String nome = scanner.next();
        System.out.println("Informe o seu email: ");
        String email = scanner.next();
        System.out.println("Qual o valo da hora/aula? ");
        double valor = scanner.nextDouble();
        Professor professor01 = new Professor(nome,email,valor);
        professores.add(professor01);
        System.out.println("Professor cadastrado com sucesso.");
    }


    public static void cadastroCursos(){
        System.out.println("Cadastro do curso.");
        System.out.println("Informe o nome do curso: ");
        String nomeCurso = scanner.next();
        System.out.println("Informe a carga horária: ");
        int carga = scanner.nextInt();
        System.out.println("Qual o o conteúdo do curso? ");
        String conteudo = scanner.next();
        System.out.println("Qual o valo da curso? ");
        double valor = scanner.nextDouble();
        Curso curso01 = new Curso(carga,nomeCurso,conteudo,valor);
        cursos.add(curso01);
        curso01.getTurma().addAll(turmas);
        System.out.println("Curso cadastrado com sucesso.");
    }

    public static void cadastroTurmas(){
        System.out.println("Cadastro da turma.");
        System.out.println("Informe o nome da turma: ");
        String nomeTurma = scanner.next();
        System.out.println("Informe a data de inicio: ");
        LocalDate inicio = LocalDate.parse(scanner.next());
        System.out.println("Informe a data de término: ");
        LocalDate termino = LocalDate.parse(scanner.next());
        Turma turma01 = new Turma(nomeTurma,inicio,termino);
        turmas.add(turma01);
        turma01.getProfessor().addAll(professores);
        System.out.println("Turma cadastrada com sucesso.");
    }

    /*Métodos para listagem
     *Fazem a busca dos campos através do índice(get(indice)) */

    public static void listarProfessores(){
        System.out.println("ID --- Nome --- Email ---- Valor ---- Salário");
        for(int i = 0;i < professores.size();i++){
            System.out.println(i + 1 +" - "+ professores.get(i).getNomeProfessor() +" - "+ professores.get(i).getEmail() + " - " + professores.get(i).getValorHoraAula() + " - " + professores.get(i).calcularSalario(4));
        }
    }

    public static void listarCursos(){
        System.out.println("ID --- Nome --- Carga ---- Conteúdo ---- Valor --- Turma");
        for(int i = 0;i < cursos.size();i++){
            System.out.println(i + 1 +" - "+ cursos.get(i).getNomeCurso() +" - "+ cursos.get(i).getCargaHoraria() + " - "+ cursos.get(i).getConteudo() +" - "+cursos.get(i).getValorCurso()+" - "+cursos.get(i).getTurma().get(i).getNomeTurma());
        }
    }

    public static void listarTurmas(){
        System.out.println("ID --- Nome --- Inicio ---- Término --- Professor");
        for(int i = 0;i < turmas.size();i++){
            System.out.println(i + 1 +" - "+ turmas.get(i).getNomeTurma() +" - "+ turmas.get(i).getDataInicio() + " - " + turmas.get(i).getDataTermino()+ " - " + turmas.get(i).getProfessor().get(i).getNomeProfessor());
        }
    }
}
