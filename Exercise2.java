package Java_P2;

import java.util.Scanner;
import Java_P2.Data;
import Java_P2.Hora;

class ConsultaAgendada {
    private Data data;
    private Hora hora;
    private String nomePaciente;
    private String nomeMedico;
    static int quantidade;

    public ConsultaAgendada(int h, int mi, int s, int d, int m, int a, String p, String me) {
        quantidade++;
        Data data = new Data(d, m, a);
        Hora hora = new Hora(h, mi, s);
        this.setData(data);
        this.setHora(hora);
        setNomePaciente(p);
        setNomeMedico(me);
    }

    public ConsultaAgendada() {
        quantidade++;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do paciente: ");
        setNomePaciente(scanner.nextLine());
        System.out.println("Digite o nome do médico: ");
        setNomeMedico(scanner.nextLine());
        Data data = new Data();
        setData(data);
        Hora hora = new Hora();
        setHora(hora);
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public String getData() {
        return data.mostra1();
    }

    public String getHora() {
        return hora.handleGetHora();
    }

    public void setData(Data data) {
        this.data = data;
    }

    public void setData() {
         quantidade++;
        Data data = new Data();
        this.data = data;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    public void setHora() {
        Hora hora = new Hora();
        this.hora = hora;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public void setNomeMedico() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do médico: ");
        setNomeMedico(scanner.nextLine());
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public void setNomePaciente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do paciente: ");
        setNomePaciente(scanner.nextLine());
    }
}

public class Exercise2 {

    public static void main(String[] args) {
        System.out.println("--------------------------------------------------------");
        System.out.println("");
        System.out.println("");
        System.out.println("--------------------------------------------------------");
        System.out.println("---------------------------Dados de sua consulta-----------------------------");
        System.out.println("");
        ConsultaAgendada p1 = new ConsultaAgendada(17, 45, 0, 07, 07, 2023, "Miguel Pataro", "João Pedral");
        System.out.println("Paciente: " + p1.getNomePaciente());
        System.out.println("Médico: " + p1.getNomeMedico());
        System.out.println("Data: " + p1.getData());
        System.out.println("Hora: " + p1.getHora());
        System.out.println("");
        System.out.println("--------------------------------------------------------");
        System.out.println("----------------------Agende a Consulta----------------------------------");
        System.out.println("");
        ConsultaAgendada p2 = new ConsultaAgendada();
        System.out.println("");
        System.out.println("--------------------------------------------------------");
        System.out.println("---------------------------Dados de sua consulta-----------------------------");
        System.out.println("");
        System.out.println("Paciente: " + p2.getNomePaciente());
        System.out.println("Médico: " + p2.getNomeMedico());
        System.out.println("Data: " + p2.getData());
        System.out.println("Hora: " + p2.getHora());
        System.out.println("--------------------------------------------------------");
        System.out.println("");
        System.out.println("--------------------------------------------------------");
        System.out.println("----------------------Agende a Consulta----------------------------------");
        System.out.println("");
        p1.setData();
        p1.setHora();
        p1.setNomePaciente();
        p1.setNomeMedico();
        System.out.println("");
        System.out.println("--------------------------------------------------------");
        System.out.println("---------------------------Dados de sua consulta-----------------------------");
        System.out.println("");
        System.out.println("Paciente: " + p1.getNomePaciente());
        System.out.println("Médico: " + p1.getNomeMedico());
        System.out.println("Data: " + p1.getData());
        System.out.println("Hora: " + p1.getHora());
        System.out.println("");
        System.out.println("--------------------------------------------------------");
        System.out.println("Quantidade de consultas: " + ConsultaAgendada.quantidade);
    }
}
