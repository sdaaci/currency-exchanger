package exchanger;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NbpExchangeRateDownloader {

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

            System.out.println(series.getRates().get(0).getMid());

            conn.disconnect();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}