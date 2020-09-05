package exchanger;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyExchangeService {


    NbpExchangeRateDownloader NBPDownloader = new NbpExchangeRateDownloader();

    public BigDecimal exchange(BigDecimal value, String fordate) {

        NbpExchangeRateResult download = NBPDownloader.download(fordate);

        BigDecimal result = value.divide(download.getRate(), 2, RoundingMode.HALF_DOWN);



        return result;


    }
}

