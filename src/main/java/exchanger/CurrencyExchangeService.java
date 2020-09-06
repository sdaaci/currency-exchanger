package exchanger;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class CurrencyExchangeService {


    NbpExchangeRateDownloader NBPDownloader = new NbpExchangeRateDownloader();

    boolean isCorrectDate(LocalDate date) throws IOException {
        return NBPDownloader.isCorrectDate(date);
    }

    public BigDecimal exchange(BigDecimal value, LocalDate fordate, String currency) {

        NbpExchangeRateResult download = NBPDownloader.download(fordate, currency);


        if (download.isSuccess()) {

            BigDecimal result = value.divide(download.getRate(), 2, RoundingMode.HALF_DOWN);
            return result;
        }

        return null;
    }
}






