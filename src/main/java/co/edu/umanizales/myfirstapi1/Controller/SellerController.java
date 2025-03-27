package co.edu.umanizales.myfirstapi1.Controller;

import co.edu.umanizales.myfirstapi1.Model.Location;
import co.edu.umanizales.myfirstapi1.Model.Seller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/seller")
public class SellerController {

    @GetMapping
    public List<Seller> getSellers() {
        List<Seller> sellers = new ArrayList<>();

        Location city1 = new Location("17001", "Manizales");

        sellers.add(new Seller("123456789", "Juan", "Grisales", 'M', (byte)30, city1));
        sellers.add(new Seller("987654321", "Paula", "Matiz", 'F', (byte)28, city1));
        sellers.add(new Seller("456789123", "Carlos", "Loaiza", 'M', (byte)35, city1));
        sellers.add(new Seller("321654987", "Martina", "Rodríguez", 'F', (byte)25, city1));
        sellers.add(new Seller("789123456", "Fernando", "Martínez", 'M', (byte)40, city1));

        return sellers;
    }
}