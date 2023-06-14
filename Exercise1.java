package Java_P2;
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;

 /**
  * @author Miguel da Silva Pataro
  * @author João Vitor Pedral do Nascimento
  */

class Data {
    private int dia;
    private int mes;
    private int ano;
    private Scanner scanner = new Scanner(System.in);

 
    public Data() {
        int maxValueDia = 0;

        this.entrada(1, 1000000, "ano", "Informe um valor maior que 0.");
        bissexto();
        this.entrada(1, 12, "mês", "Informe um número entre 1 e 12.");
        maxValueDia = this.diasDoMes(mes);

        this.entrada(1, maxValueDia, "dia", "Informe um número entre 1 e " + maxValueDia + ".");

    }

    public Data(int d, int m, int a) {
        this.setDia(d);
        this.setMes(m);
        this.setAno(a);
    }

    public void entrada(int init, int finalValue, String message, String errorMessage) {
        int value = 0;

        // Validação
        do {
            try {
                System.out.print("Digite o " + message + ": ");
                value = this.scanner.nextInt();
                if (value < init || value > finalValue) {
                    throw new ArithmeticException(errorMessage);
                }
            } catch (Exception error) {
                System.out.println(error.getMessage());
                this.scanner.nextLine();
            }
        } while (value < init || value > finalValue);

        switch (message) {
            case "ano":
                setAno(value);
                break;
            case "mês":
                setMes(value);
                break;
            case "dia":
                setDia(value);
                break;
        }
    }

    // Getter
    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    // Setter
    public void setDia(int d) {
        this.dia = d;
    }

    public void setMes(int m) {
        this.mes = m;
    }

    public void setAno(int a) {
        this.ano = a;
    }

    //Mostra a data gravada no formato dd/mm/aaaa
    public String mostra1() {
        int d = getDia();
        int m = getMes();
        int a = getAno();
        
        String dia = Integer.toString(d);
        String mes = Integer.toString(m);
        String ano = Integer.toString(a);
        
        if (dia.length() == 1)
        dia = "0" + dia;
        if (mes.length() == 1)
        mes = "0" + mes;
        
        switch (ano.length()) {
            case 1:
            ano = "000" + ano;
            break;
            case 2:
                ano = "00" + ano;
                break;
            case 3:
                ano = "0" + ano;
                break;
        }

        return "Data: " + dia + "/" + mes + "/" + ano;

    }

    //Mostra a data gravada no formato dd/mêsPorExtenso/aaaa
    public String mostra2() {
        int d = getDia();
        int m = getMes();
        int a = getAno();

        String dia = Integer.toString(d);
        String mes = "";
        String ano = Integer.toString(a);

        if (dia.length() == 1)
            dia = "0" + dia;

        switch (m) {
            case 1:
                mes = "janeiro";
                break;
            case 2:
                mes = "fevereiro";
                break;
            case 3:
                mes = "março";
                break;
            case 4:
                mes = "abril";
                break;
            case 5:
                mes = "maio";
                break;
            case 6:
                mes = "junho";
                break;
            case 7:
                mes = "julho";
                break;
            case 8:
                mes = "agosto";
                break;
            case 9:
                mes = "setembro";
                break;
            case 10:
                mes = "outubro";
                break;
            case 11:
                mes = "novembro";
                break;
            default:
                mes = "dezembro";
                break;
        }

        switch (ano.length()) {
            case 1:
                ano = "000" + ano;
                break;
            case 2:
                ano = "00" + ano;
                break;
            case 3:
                ano = "0" + ano;
                break;
        }

        return "Data digitada: " + dia + "/" + mes + "/" + ano;
    }

    //Verifica se o ano é bissexto
    public boolean bissexto() {
        int ano = getAno();
        return (ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0;
    }

    //Mostra a data atual
    public void apresentaDataAtual() {
        DateFormat dataAtual = DateFormat.getDateInstance();
        String data = dataAtual.format(new Date());
        System.out.println("Data atual: " + data);
    }

    //Mostra a quantidade de dias transcorridos no ano até a data digitada.
    public int diasTranscorridos() {
        int diasTranscorridos = 0;
        for (int i = 1; i < getMes(); i++) {
            diasTranscorridos += diasDoMes(i);
        }
        diasTranscorridos += getDia();
        return diasTranscorridos;
    }

    //Identifica o máximo de dias no mês digitado
    public int diasDoMes(int mes) {
        int diasDoMes = 0;
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                diasDoMes = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                diasDoMes = 30;
                break;
            case 2:
                if (bissexto()) {
                    diasDoMes = 29;
                } else {
                    diasDoMes = 28;
                }
                break;
        }
        return diasDoMes;
    }
}

public class Exercise1 {
    public static void main(String[] args) {

        int userValue = 0;
        Scanner ler = new Scanner(System.in);
        Data teste = new Data();

        do {
            do {
                try {
                    System.out.println("Menu: ");
                    System.out.println("1 - Inserir data");
                    System.out.println("2 - Mostrar data no formato dd/mm/aaaa");
                    System.out.println("3 - Mostrar data no formato dd/NomeDoMês/aaaa");
                    System.out.println("4 - Mostrar dias transcorridos no ano");
                    System.out.println("5 - Mostrar data atual");
                    System.out.println("6 - Sair");
                    System.out.print("Opção escolhida: ");
                    userValue = ler.nextInt();
                } catch (Exception e) {
                    System.out.println("Escolha uma opção de 1 a 6.");
                    ler.nextLine();
                }
            } while (userValue < 1 || userValue > 6);

            switch (userValue) {
                case 1:
                    teste.Data();
                    break;
                case 2:
                    System.out.println(teste.mostra1());
                    break;
                case 3:
                    System.out.println(teste.mostra2());
                    break;
                case 4:
                    System.out.println("Dias transcorridos no ano: " + teste.diasTranscorridos());
                    break;
                case 5:
                    teste.apresentaDataAtual();
                    break;
                default:
                    break;
            }
        } while (userValue != 6);

        ler.close();

    }
}