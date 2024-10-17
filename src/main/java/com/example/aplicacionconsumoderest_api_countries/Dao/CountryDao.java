package com.example.aplicacionconsumoderest_api_countries.Dao;

import com.example.aplicacionconsumoderest_api_countries.Entity.Country;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CountryDao {

    public Country getCountry(String country){
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://restcountries.com/v3.1/name/"+country;

        try {
            //Usamos ParameterizedTypeReference para mapear la respuesta a una lista de objetos Country
            ResponseEntity<List<Country>> responseJSON = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Country>>() {
                    }
            );

            //Obtenemos la lista de paises de la respuesta JSON
            List<Country> countryJSON = responseJSON.getBody();

            //Retornamos el primer objeto que es el pais encontrado
            return countryJSON.get(0);

            //Luego ,Cuando la API no encuentra el país, devuelve un Objeto de Error con código HTTP 404.
            //Para gestionar elloo, se emplea el manejo de la excepción
            //HttpClientErrorException que se lanza cuando RestTemplate recibe una respuesta de error.
        } catch (HttpClientErrorException e) {
            // Manejo del error cuando no se encuentra el país
            // {"status":404,
            // "message": "Not Found"}
            if (e.getStatusCode().value() == 404) {
                System.out.println("Error: El país no fue encontrado.");
                return null;
            } else {
                //Si hay Otro tipo de error
                System.out.println("Error al realizar la solicitud: " + e.getMessage());
                return null;
            }
        } catch (Exception e) {
            //Manejo de cualquier otro error
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            return null;
        }
    }

}

