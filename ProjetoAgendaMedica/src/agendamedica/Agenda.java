package agendamedica;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Evento> eventos;

    public Agenda() {
        this.eventos = new ArrayList<>();
    }

    private boolean temConflito(Evento novoEvento) {
        for (Evento evento : eventos) {
            if (evento.getInicio().isBefore(novoEvento.getFim()) && novoEvento.getInicio().isBefore(evento.getFim())) {
                return true;
            }
        }
        return false;
    }

    public boolean adicionarEvento(String pessoa, LocalDateTime inicio, int duracao) {
        Evento novoEvento = new Evento(pessoa, inicio, duracao);

        if (temConflito(novoEvento)) {
            System.out.println("Conflito de horário! Não é possível agendar o evento.");
            return false;
        } else {
            eventos.add(novoEvento);
            System.out.println("Evento adicionado com sucesso: " + novoEvento);
            return true;
        }
    }

    public void listarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento agendado.");
        } else {
            System.out.println("Eventos agendados:");
            for (Evento evento : eventos) {
                System.out.println(evento);
            }
        }
    }
}
