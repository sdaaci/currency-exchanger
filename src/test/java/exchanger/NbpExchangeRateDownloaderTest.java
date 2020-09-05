package exchanger;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


class NbpExchangeRateDownloaderTest {

    NbpExchangeRateDownloader subject = new NbpExchangeRateDownloader();

    @Test
    public void shouldReturnExchangeTest() {
        //given

        LocalDate givenExchangeDate = LocalDate.of(2069, 8, 10);

        NbpExchangeRateResult expected = new NbpExchangeRateResult(false, "Podałeś date z przyszłości", null);

        //when
        NbpExchangeRateResult actual = subject.download(givenExchangeDate.toString());
        //then

        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

}