package exchanger;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class CurrencyExchangeService {


    NbpExchangeRateDownloader NBPDownloader = new NbpExchangeRateDownloader();

    public BigDecimal exchange(BigDecimal value, LocalDate fordate) {

        NbpExchangeRateResult download = NBPDownloader.download(fordate);


        if (download.isSuccess()) {

            BigDecimal result = value.divide(download.getRate(), 2, RoundingMode.HALF_DOWN);
            return result;
        }

        return null;
    }
}






