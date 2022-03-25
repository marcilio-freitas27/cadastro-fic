import java.util.ArrayList;
import java.util.List;

public class Curso {

    /**
     * Default constructor
     */
    public Curso(int cargaHoraria, String nomeCurso, String conteudo, double valorCurso) {
        this.cargaHoraria = cargaHoraria;
        this.nomeCurso = nomeCurso;
        this.conteudo = conteudo;
        this.valorCurso = valorCurso;
        this.turma = new ArrayList<Turma>();
    }

    private int cargaHoraria;
    private String nomeCurso;
    private String conteudo;
    private double valorCurso;
    private List<Turma> turma;

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public String getConteudo() {
        return conteudo;
    }

    public double getValorCurso() {
        return valorCurso;
    }

    public List<Turma> getTurma() {
        return this.turma;
    }

    public void setTurma(List<Turma> turma) {
        this.turma = turma;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void setValorCurso(double valorCurso) {
        this.valorCurso = valorCurso;
    }
    
}