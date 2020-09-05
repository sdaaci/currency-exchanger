package exchanger;

import java.math.BigDecimal;

public class CurrencyExchangeService {


    NbpExchangeRateDownloader NBPDownloader= new NbpExchangeRateDownloader();

    public BigDecimal exchange(BigDecimal value, String fordate){
        NbpExchangeRateResult download = NBPDownloader.download(fordate);




        BigDecimal result= value.divide(download.getRate());

        return result;


    }}

