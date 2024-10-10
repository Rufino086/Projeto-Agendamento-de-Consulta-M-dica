package agendamedica;


public class Paciente {
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private String motivoConsulta;

    public Paciente(String nome, String cpf, String telefone, String endereco, String motivoConsulta) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.motivoConsulta = motivoConsulta;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }
}
