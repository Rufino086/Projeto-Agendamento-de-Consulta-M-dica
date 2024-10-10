package agendamedica;

public class Medico {
    private String nome;
    private String especializacao;
    private String ra;

    public Medico(String nome, String especializacao, String ra) {
        this.nome = nome;
        this.especializacao = especializacao;
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public String getRa() {
        return ra;
    }

    @Override
    public String toString() {
        return "Médico: " + nome + ", Especialização: " + especializacao + ", RA: " + ra;
    }
}
