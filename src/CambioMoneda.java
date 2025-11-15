import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CambioMoneda {
    Scanner sc = new Scanner(System.in);
    Moneda buscarCambio(String api_key){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+api_key+"/latest/MXN");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Moneda.class);

        }catch (IOException | InterruptedException e){
            throw  new RuntimeException("No se encontro la moneda");
        }

    }

    String conversion(double valorCambio){
        System.out.println("Cantidad a cambiar MXN -> ");
        double cantidad = sc.nextDouble();

        return cantidad+" MXN --> "+(cantidad*valorCambio);
    }
}
