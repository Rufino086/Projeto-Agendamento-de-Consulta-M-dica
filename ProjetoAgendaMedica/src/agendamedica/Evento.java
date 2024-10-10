package agendamedica;

import java.time.LocalDateTime;

public class Evento {
    private String pessoa;
    private LocalDateTime inicio;
    private int duracao;

    public Evento(String pessoa, LocalDateTime inicio, int duracao) {
        this.pessoa = pessoa;
        this.inicio = inicio;
        this.duracao = duracao;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFim() {
        return inicio.plusMinutes(duracao);
    }

    public String getPessoa() {
        return pessoa;
    }

    @Override
    public String toString() {
        return "Evento de " + pessoa + " das " + inicio + " às " + getFim();
    }
}
