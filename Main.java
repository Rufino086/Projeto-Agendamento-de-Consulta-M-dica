import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Medico> medicos = new ArrayList<>();

        medicos.add(new Medico("Dr. João Silva", "Clínica Geral", "RA001"));
        medicos.add(new Medico("Dra. Ana Souza", "Clínica Geral", "RA002"));
        medicos.add(new Medico("Dr. Carlos Lima", "Clínica Geral", "RA003"));

        medicos.add(new Medico("Dra. Fernanda Costa", "Pediatria", "RA004"));
        medicos.add(new Medico("Dr. Bruno Alves", "Pediatria", "RA005"));
        medicos.add(new Medico("Dra. Paula Mendes", "Pediatria", "RA006"));

        medicos.add(new Medico("Dr. Ricardo Rocha", "Ginecologia", "RA007"));
        medicos.add(new Medico("Dra. Beatriz Martins", "Ginecologia", "RA008"));
        medicos.add(new Medico("Dr. André Santos", "Ginecologia", "RA009"));

        medicos.add(new Medico("Dr. Felipe Ferreira", "Ortopedia", "RA010"));
        medicos.add(new Medico("Dra. Juliana Nunes", "Ortopedia", "RA011"));
        medicos.add(new Medico("Dr. Tiago Pereira", "Ortopedia", "RA012"));

        medicos.add(new Medico("Dra. Camila Lima", "Cardiologia", "RA013"));
        medicos.add(new Medico("Dr. Gustavo Ribeiro", "Cardiologia", "RA014"));
        medicos.add(new Medico("Dra. Laura Silva", "Cardiologia", "RA015"));

        for (Medico medico : medicos) {
            System.out.println(medico);
        }
    }
}
