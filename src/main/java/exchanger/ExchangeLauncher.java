package exchanger;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class ExchangeLauncher {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Przeliecznik PLN na EUR\nPodaj wartosc w PLN");
        BigDecimal pln = scan.nextBigDecimal();
        scan.nextLine();

            System.out.println("Podaj datę kursu yyyy-mm-dd");
            String date = scan.nextLine();
            LocalDate parsedDate = LocalDate.parse(date);



            BigDecimal exchange = new CurrencyExchangeService().exchange(pln, parsedDate);

            System.out.println(exchange + " EUR");
        }
    }

