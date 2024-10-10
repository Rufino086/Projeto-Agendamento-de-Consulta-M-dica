package agendamedica;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.time.LocalDateTime;

public class ExcelConnection {
    private static final String FILE_PATH = "consultas.xlsx";

    // Método para salvar a ficha do paciente no Excel
    public static void salvarFichaPaciente(Paciente paciente) {
        try {
            File file = new File(FILE_PATH);
            Workbook workbook;
            Sheet sheet;

            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                workbook = new XSSFWorkbook(fis);
                sheet = workbook.getSheetAt(0); // Planilha de Pacientes
            } else {
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("Pacientes");
                Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("Nome");
                headerRow.createCell(1).setCellValue("CPF");
                headerRow.createCell(2).setCellValue("Telefone");
                headerRow.createCell(3).setCellValue("Endereço");
                headerRow.createCell(4).setCellValue("Motivo");
            }

            int rowNum = sheet.getLastRowNum() + 1;
            Row row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(paciente.getNome());
            row.createCell(1).setCellValue(paciente.getCpf());
            row.createCell(2).setCellValue(paciente.getTelefone());
            row.createCell(3).setCellValue(paciente.getEndereco());
            row.createCell(4).setCellValue(paciente.getMotivoConsulta());

            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            workbook.write(fos);
            fos.close();
            workbook.close();

            System.out.println("Dados salvos em " + FILE_PATH);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar um paciente pelo CPF
    public static Paciente buscarPacientePorCPF(String cpf) {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                System.out.println("Arquivo de pacientes não encontrado.");
                return null;
            }

            FileInputStream fis = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0); // Planilha de Pacientes

            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Começa em 1 para pular o cabeçalho
                Row row = sheet.getRow(i);
                if (row.getCell(1).getStringCellValue().equals(cpf)) {
                    String nome = row.getCell(0).getStringCellValue();
                    String telefone = row.getCell(2).getStringCellValue();
                    String endereco = row.getCell(3).getStringCellValue();
                    String motivo = row.getCell(4).getStringCellValue();
                    return new Paciente(nome, cpf, telefone, endereco, motivo);
                }
            }

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Retorna nulo se não encontrar
    }

    public static void salvarConsulta(Medico medico, Paciente paciente, LocalDateTime dataHora) {
        try {
            File file = new File(FILE_PATH);
            Workbook workbook;
            Sheet sheet;

            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                workbook = new XSSFWorkbook(fis);
                // Verifica se já existe uma planilha de consultas
                if (workbook.getNumberOfSheets() > 1) {
                    sheet = workbook.getSheetAt(1); // Planilha de Consultas
                } else {
                    sheet = workbook.createSheet("Consultas");
                    Row headerRow = sheet.createRow(0);
                    headerRow.createCell(0).setCellValue("Paciente");
                    headerRow.createCell(1).setCellValue("Médico");
                    headerRow.createCell(2).setCellValue("Data e Hora");
                }
            } else {
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("Pacientes");
                Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("Nome");
                headerRow.createCell(1).setCellValue("CPF");
                headerRow.createCell(2).setCellValue("Telefone");
                headerRow.createCell(3).setCellValue("Endereço");
                headerRow.createCell(4).setCellValue("Motivo");

                // Agora cria a planilha de consultas
                sheet = workbook.createSheet("Consultas");
                Row headerRowConsultas = sheet.createRow(0);
                headerRowConsultas.createCell(0).setCellValue("Paciente");
                headerRowConsultas.createCell(1).setCellValue("Médico");
                headerRowConsultas.createCell(2).setCellValue("Data e Hora");
            }

            int rowNum = sheet.getLastRowNum() + 1;
            Row row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(paciente.getNome());
            row.createCell(1).setCellValue(medico.getNome());
            row.createCell(2).setCellValue(dataHora.toString());

            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            workbook.write(fos);
            fos.close();
            workbook.close();

            System.out.println("Consulta agendada e salva em " + FILE_PATH);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
