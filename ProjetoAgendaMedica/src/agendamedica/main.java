package agendamedica;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Fluxo inicial
        System.out.println("Bem-vindo ao sistema de agendamento de consultas.");
        System.out.print("O paciente já possui ficha? (sim/nao): ");
        String possuiFicha = scanner.nextLine().toLowerCase();

        Paciente paciente;

        if (possuiFicha.equals("nao")) {
            System.out.println("Preencha as informações do paciente:");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Endereço: ");
            String endereco = scanner.nextLine();
            System.out.print("Motivo da consulta: ");
            String motivo = scanner.nextLine();

            paciente = new Paciente(nome, cpf, telefone, endereco, motivo);
            ExcelConnection.salvarFichaPaciente(paciente);
        } else {
            System.out.print("Informe o CPF do paciente: ");
            String cpf = scanner.nextLine();
            paciente = ExcelConnection.buscarPacientePorCPF(cpf);

            if (paciente == null) {
                System.out.println("Paciente não encontrado.");
                return;
            } else {
                System.out.println("Ficha do paciente encontrada: " + paciente.getNome());
            }
        }

        // Triagem
        System.out.println("Realize a triagem do paciente:");
        System.out.print("Sintomas: ");
        String sintomas = scanner.nextLine();
        System.out.print("Duração dos sintomas: ");
        String duracao = scanner.nextLine();
        System.out.print("Gravidade (Leve, Moderada, Grave): ");
        String gravidade = scanner.nextLine();

        Triagem triagem = new Triagem(sintomas, duracao, gravidade);
        System.out.println("Triagem realizada: " + triagem);

        // Agendamento da consulta
        Medico medico = new Medico("Dr. João", "Cardiologia", "12345");

        System.out.println("Escolha a data e hora da consulta no formato (dd/MM/yyyy HH:mm): ");
        String dataHoraInput = scanner.nextLine();
        LocalDateTime dataHora;

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            dataHora = LocalDateTime.parse(dataHoraInput, formatter);

            Agenda agenda = new Agenda();
            if (agenda.adicionarEvento(paciente.getNome(), dataHora, 30)) {
                ExcelConnection.salvarConsulta(medico, paciente, dataHora);
            }

        } catch (DateTimeParseException e) {
            System.out.println("Formato de data e hora inválido.");
        }

        scanner.close();
    }
}

