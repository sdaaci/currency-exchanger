package exchanger;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CurrencyExchangeServiceTest {

    CurrencyExchangeService subject = new CurrencyExchangeService();

    @Test
    public void shouldReturnCurrencyExchangeServiceTest() {
        //given
        LocalDate givenExchangeDate = LocalDate.of(2020, 9, 4);
        BigDecimal givenBigDecimalValue = new BigDecimal("500");
        String givenCurrency= "EUR";

        //when
        BigDecimal result = subject.exchange(givenBigDecimalValue, givenExchangeDate, givenCurrency);

        //then
        assertThat(result).isEqualTo(new BigDecimal("112.34"));


    }
}