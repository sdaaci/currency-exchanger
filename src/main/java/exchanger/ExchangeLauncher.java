package exchanger;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExchangeLauncher {


    public static void main(String[] args) {

        CurrencyExchangeService currencyExchangeService = new CurrencyExchangeService();

        BigDecimal pln = null;


        Scanner scan = new Scanner(System.in);
        System.out.println("Przelicznik Walut\n");

        String currency ="EUR";
        System.out.println("Podaj wartosc w PLN");
        boolean correct = true;
        boolean correctDate = true;
        while (correct) {
            try {

                pln = scan.nextBigDecimal();
                scan.nextLine();
                correct = false;
            } catch (InputMismatchException ex) {
                System.out.println("Nieprawidlowa wartosc. Wprowadz ponownie.");
                scan.nextLine();
            }
        }
        System.out.println("Podaj walute do przeliczenia " +currency);

        System.out.println("Podaj datę kursu yyyy-mm-dd");
        LocalDate parsedDate = null;
        while (correctDate) {
            try {

                String date = scan.nextLine();
                parsedDate = LocalDate.parse(date);
                if(parsedDate.isAfter(LocalDate.now())) {
                    System.out.println("Podana data jest z przyszlosci");
                    continue;
                }
                if(!currencyExchangeService.isCorrectDate(parsedDate)) {
                    System.out.println("Podana data jest niepoprawna. Brak kursu wymiany w tym dniu.");
                    continue;
                }
                correctDate = false;

            } catch (DateTimeParseException | IOException e) {
                System.out.println("Nieprawidlowy format. Podaj date w formacie yyyy-mm-dd");
            }
        }
        BigDecimal exchange = currencyExchangeService.exchange(pln, parsedDate, currency);
        System.out.println(exchange +" " +currency);
    }
}

