package Java_P2;

import java.util.Scanner;

/** 
 * @author Miguel da Silva Pataro
 * @author João Vitor Pedral Nascimento
 */

/**
 * Hora2
 */

class Hora {
    private int hora;
    private int min;
    private int seg;
    private Scanner scanner = new Scanner(System.in);

    public Hora(int h, int m, int s) {
        this.setHora(h);
        this.setMin(m);
        this.setSeg(s);
    }

    public Hora() {
        this.entrada(0, 23, "hora", "Informe um valor entre 0 e 23.");
        this.entrada(0, 59, "minutos", "Informe um valor entre 0 e 59.");
        this.entrada(0, 59, "segundos", "Informe um valor entre 0 e 59.");
    }

    public void entrada(int init, int finalValue, String message, String errorMessage) {
        int value = 0;

        do {
            try {
                System.out.print("Digite " + message + ":");
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
            case "hora":
                setHora(value);
                break;
            case "minutos":
                setMin(value);
                break;
            case "segundos":
                setSeg(value);
                break;
        }

    }

    public int getHora() {
        return this.hora;
    }

    public int getMin() {
        return this.min;
    }

    public int getSeg() {
        return this.seg;
    }

    public String handleGetHora() {
        return String.format("%02d:%02d:%02d", this.hora, this.min, this.seg);
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setSeg(int seg) {
        this.seg = seg;
    }
}

