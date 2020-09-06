package exchanger;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.LocalDate;


public class NbpExchangeRateDownloader {


    public NbpExchangeRateResult download(LocalDate forDate, String currency) {
        try {
            URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/A/" + currency + "/" + forDate.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "aplication/json");

            if (conn.getResponseCode() == 400 || conn.getResponseCode() == 404) {

                return new NbpExchangeRateResult(false, "Podałeś nieprawidłowa date", null);
            }

            if (conn.getResponseCode() == 200)
            {
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream())));

                System.out.println("Output from Server .... \n");
                NbpExchangeRateSeries series = new ObjectMapper().readValue(br.readLine(), NbpExchangeRateSeries.class);

                BigDecimal rate = series.getRates().get(0).getMid();

                return new NbpExchangeRateResult(true, "OK", rate);
            }

            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }




    public static void main(String[] args) {

        try {

            URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/A/EUR/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            System.out.println("Output from Server .... \n");
            NbpExchangeRateSeries series = new ObjectMapper().readValue(br.readLine(), NbpExchangeRateSeries.class);

            BigDecimal rate = series.getRates().get(0).getMid();

            System.out.println(rate);

            conn.disconnect();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public boolean isCorrectDate(LocalDate date) throws IOException {
        URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/A/EUR/" + date);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        return conn.getResponseCode() == 200;
    }
}