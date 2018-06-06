import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double amount = Double.parseDouble(reader.readLine());

        System.out.println("NOTAS:");
        for (Notes note : Notes.values()) {
            while (note.amount <= amount) {
                note.increment();
                amount = round(amount - note.amount);
            }

            System.out.println(note);
        }

        System.out.println("MOEDAS:");
        for (Cents cent : Cents.values()) {
            while (cent.amount <= amount) {
                cent.increment();
                amount = round(amount - cent.amount);
            }

            System.out.println(cent);
        }
    }

    private static double round(double d) {
        return Math.round(d * 100.0) / 100.0;
    }
}

enum Notes {
    HUNDRED(100),
    FIFTY(50),
    TWENTY(20),
    TEN(10),
    FIVE(5),
    TWO(2);

    int count = 0;
    double amount;

    Notes(double amount) {
        this.amount = amount;
    }

    void increment() {
        count++;
    }

    public String toString() {
        return String.format("%d nota(s) de R$ %.2f", count, amount);
    }
}

enum Cents {
    HUNDRED(1),
    FIFTY(0.50),
    TWENTY_FIVE(0.25),
    TEN(0.10),
    FIVE(0.05),
    ONE(0.01);

    int count = 0;
    double amount;

    Cents(double amount) {
        this.amount = amount;
    }

    void increment() {
        count++;
    }

    public String toString() {
        return String.format("%d moeda(s) de R$ %.2f", count, amount);
    }
}