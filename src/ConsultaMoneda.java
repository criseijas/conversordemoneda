import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    //eae03212c99f4ee77a7d3fff (apikey)
    //Example Request: https://v6.exchangerate-api.com/v6/eae03212c99f4ee77a7d3fff/latest/USD

    String apiKey = "eae03212c99f4ee77a7d3fff";
    String direccion = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/";

    public Conversor buscaMoneda(String monedaBase) {

        URI url = URI.create(direccion + monedaBase);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        try {
            HttpResponse<String> response = client
                 .send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println("RESPONSE" + response.body());
            return new Gson().fromJson(response.body(), Conversor.class);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo realizar la conversión");
        }
    }
}
