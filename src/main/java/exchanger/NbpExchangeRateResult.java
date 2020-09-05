package exchanger;

import java.math.BigDecimal;

public class NbpExchangeRateResult {
    private boolean success;
    private String errorMessage;
    private BigDecimal rate;

    public NbpExchangeRateResult(boolean success, String errorMessage, BigDecimal rate) {
        this.success = success;
        this.errorMessage = errorMessage;
        this.rate = rate;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

}




