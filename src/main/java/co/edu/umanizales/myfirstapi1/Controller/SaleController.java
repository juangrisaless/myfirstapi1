package co.edu.umanizales.myfirstapi1.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sale")
public class SaleController {

    // Método original CORREGIDO (sin referencia a stores)
    @GetMapping
    public String getSale() {
        return "Venta";
    }
}