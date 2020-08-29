package exchanger;

import java.util.List;

public class NbpExchangeRateSeries {
    private String table;
    private String currency;
    private String code;
    private List<NbpExchangeRate> rates;

    public String getTable() {
        return table;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public List<NbpExchangeRate> getRates() {
        return rates;
    }
}
