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
	
	/* menu inicial*/
        System.out.println("Ocurso - Formando profissionais.");
        System.out.println("Qual a operção deseja fazer? Escolha entre 1 e 7. ");
        System.out.println("1 - Cadastrar professor");
        System.out.println("2 - Cadastrar curso");
        System.out.println("3 - Cadastrar turma");
        System.out.println("4 - Listar professor");
        System.out.println("5 - Listar curso");
        System.out.println("6 - Listar turma");
        System.out.println("7 - Sair");
	/* opcao que o usuário irá executar */
        int opcao = scanner.nextInt();
	
	/* enquanto for verdadeiro execute*/
        while (true) {
	    /* switch representa a opcao de cadastro e exibição dos dados.
	     * */
            switch (opcao) {
                case 1:
                    cadastroProfessores();
                    break;
                case 4:
                    listarProfessores();
                    break;
                case 2:
                    cadastroCursos();
                    break;
                case 5:
                    listarCursos();
                    break;
                case 3:
                    cadastroTurmas();
                    break;
                case 6:
                    listarTurmas();
                    break;
                case 7:
                    return;
            }
            System.out.println("Se deseja fazer outra operação escolha entre 1 e 6. Senão, tecle 7 para sair");
            System.out.println("1 - Cadastrar professor");
            System.out.println("2 - Cadastrar curso");
            System.out.println("3 - Cadastrar turma");
            System.out.println("4 - Listar professor");
            System.out.println("5 - Listar curso");
            System.out.println("6 - Listar turma");
            System.out.println("7 - Sair");
	    /* caso o usuário queira executar outra opção */
            opcao = scanner.nextInt();
        }

    }
	
    /* métodos de cadastro
     * Solicitam os dados, inserem na instância da classe
     * inserem na lista*/

    public static void cadastroProfessores(){
        
        System.out.println("Informe o nome do professor: ");
        String nome = scanner.next();
        System.out.println("Informe o seu email: ");
        String email = scanner.next();
        System.out.println("Qual o valo da hora/aula? ");
        double valor = scanner.nextDouble();
        Professor professor01 = new Professor(nome,email,valor);
        professores.add(professor01);
    }

    public static void cadastroCursos(){
        
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
        System.out.println(curso01.getTurma());
    }

    public static void cadastroTurmas(){
        
        System.out.println("Informe o nome da turma: ");
        String nomeTurma = scanner.next();
        System.out.println("Informe a data de inicio: ");
        LocalDate inicio = LocalDate.parse(scanner.next());
        System.out.println("Informe a data de término: ");
        LocalDate termino = LocalDate.parse(scanner.next());
        Turma turma01 = new Turma(nomeTurma,inicio,termino);
        turmas.add(turma01);
        turma01.getProfessor().addAll(professores);
        System.out.println(turma01.getProfessor());
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
