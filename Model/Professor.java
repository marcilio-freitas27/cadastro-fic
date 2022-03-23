
//import java.util.*;

/**
 * 
 */
public class Professor {

    /**
     * Default constructor
     */
    public Professor(String nomeProfessor, String email, double valorHoraAula) {    
        this.nomeProfessor = nomeProfessor;
        this.email = email;
        this.valorHoraAula = valorHoraAula;
    }

    private String nomeProfessor;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private double valorHoraAula;


    /**
     * @return
     */
    public double calcularSalario(double valor) {
        double total = this.getValorHoraAula() * valor;
        return total;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getValorHoraAula() {
        return valorHoraAula;
    }

    public void setValorHoraAula(double valorHoraAula) {
        this.valorHoraAula = valorHoraAula;
    }
    
    
}