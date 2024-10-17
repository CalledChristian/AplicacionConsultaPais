package com.example.aplicacionconsumoderest_api_countries.Controller;


import com.example.aplicacionconsumoderest_api_countries.Dao.CountryDao;
import com.example.aplicacionconsumoderest_api_countries.Entity.Country;
import com.example.aplicacionconsumoderest_api_countries.Entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@RequestMapping(value="/",method= RequestMethod.GET)
public class CountryController {

    @Autowired
    CountryDao countryDao;

    @GetMapping("")
    public String indexCountries() {
        return "index";
    }

    @PostMapping("/search")
    public String searchCountry(@RequestParam String country, RedirectAttributes redirectAttributes){

        Country country1 = countryDao.getCountry(country);
        if(country1!=null) {
            System.out.println(country1.getName().getCommon() + " " + country1.getCapital().get(0));

            // Accedemos a los currencies (monedas), que varían según el país
            Map<String, Currency> monedas = country1.getCurrencies();
            for (Map.Entry<String, Currency> moneda : monedas.entrySet()) {
                String monedaOF = moneda.getKey();  // Clave (ej: "spa", "aym")
                Currency monedaData = moneda.getValue();  // Valor que es el objeto NativeName

                System.out.println("Moneda: " + monedaOF);
                System.out.println("Nombre Moneda " + monedaOF + ": " + monedaData.getName());
                System.out.println("Símbolo Moneda" + monedaOF + ": " + monedaData.getSymbol());
            }
            redirectAttributes.addFlashAttribute("msg", "País Encontrado");
            redirectAttributes.addFlashAttribute("country", country1);
        }else{
            redirectAttributes.addFlashAttribute("msg2", "País No Encontrado");
        }
        return "redirect:/";
    }
}
