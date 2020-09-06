package exchanger;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


class NbpExchangeRateDownloaderTest {

    NbpExchangeRateDownloader subject = new NbpExchangeRateDownloader();

    @Test
    public void shouldReturnExchangeTest() {
        //given

        LocalDate givenExchangeDate = LocalDate.of(2069, 8, 10);
        NbpExchangeRateResult expected = new NbpExchangeRateResult(false, "Podałeś nieprawidłowa date", null);
        String givenCurrency = "EUR";

        //when
        NbpExchangeRateResult actual = subject.download(givenExchangeDate, givenCurrency);
        //then

        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @Test
    public void shouldReturnExchangeTestCorrect() {
        //given

        LocalDate givenExchangeDate = LocalDate.of(2020, 9, 4);
        NbpExchangeRateResult expected = new NbpExchangeRateResult(true, "OK", new BigDecimal("4.4508"));
        String givenCurrency = "EUR";
        //when
        NbpExchangeRateResult actual = subject.download(givenExchangeDate, givenCurrency);
        //then

        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }
}
