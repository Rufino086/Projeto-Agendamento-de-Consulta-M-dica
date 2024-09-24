package FichaPaciente;

import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Preencha as informa��es do paciente:");

        System.out.print("Nome Completo: ");
        String nomeComp = scanner.nextLine();

        System.out.print("Data de Nascimento (dd/MM/yyyy): ");
        String dataStr = scanner.nextLine();
        Date dataNascimento = new Date(); 

        System.out.print("Sexo (M/F): ");
        char sexo = scanner.nextLine().charAt(0);

        System.out.print("Endere�o: ");
        String endereco = scanner.nextLine();

        System.out.print("N�mero de Telefone: ");
        String numTelefone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("RG: ");
        String rg = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Nome do Contato de Emerg�ncia: ");
        String nomeContatoEmergencia = scanner.nextLine();

        System.out.print("N�mero do Contato de Emerg�ncia: ");
        String numContatoEmergencia = scanner.nextLine();

        System.out.print("Parentesco com o Contato de Emerg�ncia: ");
        String parentescoContatoEmergencia = scanner.nextLine();

        System.out.print("Motivo da Consulta: ");
        String motivo = scanner.nextLine();
        
        FichaPaciente ficha = new FichaPaciente(nomeComp, dataNascimento, sexo, endereco, numTelefone, email, rg, cpf, nomeContatoEmergencia, numContatoEmergencia, parentescoContatoEmergencia, motivo);
        
        ficha.exibirInformacoes();

        scanner.close();
    }
}

