package exercicio4;

/**
 *
 * @author Estevao
 */
public class Agenda {

    private String nome;
    private String telefone;

    public Agenda(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getContato(){
        return ("nome: " + this.nome +"\ntelefone: " + this.telefone);
    }
}
