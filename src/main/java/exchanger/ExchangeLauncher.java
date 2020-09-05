package exchanger;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class ExchangeLauncher {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Podaj wartosc w PLN");
        BigDecimal pln = scan.nextBigDecimal();
        scan.nextLine();

        System.out.println("Podaj datę kursu yyyy-mm-dd");
        String date = scan.nextLine();


        BigDecimal exchange = new CurrencyExchangeService().exchange(pln, date);

        System.out.println(exchange);

    }
}
