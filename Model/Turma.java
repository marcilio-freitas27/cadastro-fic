import java.util.ArrayList;
import java.util.List;

//import java.util.*;
// import java.time.LocalDate;

/**
 * 
 */
public class Turma {

    /**
     * Default constructor
     */
    public Turma(String nomeTurma,String dataInicio, String dataTermino) {    
        this.nomeTurma = nomeTurma;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        // this.professor = new ArrayList<Professor>();
    }

    private String nomeTurma;

    /**
     * 
     */
    private String dataInicio;

    /**
     * 
     */
    private String dataTermino;

    /**
     * 
     */
    // private ArrayList<Professor> professor;

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    // public ArrayList<Professor> getProfessor() {
    //     return this.professor;
    // }
    
}