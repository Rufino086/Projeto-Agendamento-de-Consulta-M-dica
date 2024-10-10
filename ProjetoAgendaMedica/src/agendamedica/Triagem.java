package agendamedica;

public class Triagem {
    private String sintomas;
    private String duracao;
    private String gravidade;

    public Triagem(String sintomas, String duracao, String gravidade) {
        this.sintomas = sintomas;
        this.duracao = duracao;
        this.gravidade = gravidade;
    }

    @Override
    public String toString() {
        return "Sintomas: " + sintomas + ", Duração: " + duracao + ", Gravidade: " + gravidade;
    }
}
