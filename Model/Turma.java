package Model;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Turma {

    /**
     * Default constructor
     */
    public Turma(String nomeTurma,LocalDate dataInicio, LocalDate dataTermino) {    
        this.nomeTurma = nomeTurma;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.professor = new ArrayList<Professor>();
        this.curso = new ArrayList<Curso>();
    }

    private String nomeTurma;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private List<Professor> professor;
    private List<Curso> curso;

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public List<Professor> getProfessor() {
        return this.professor;
    }

    public List<Curso> getCurso() {
        return this.curso;
    }

    public List<Professor> setProfessor() {
        return this.professor;
    }

    public List<Curso> setCurso() {
        return this.curso;
    }
    
}