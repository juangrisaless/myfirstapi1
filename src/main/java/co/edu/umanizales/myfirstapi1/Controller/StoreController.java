package co.edu.umanizales.myfirstapi1.Controller;

import co.edu.umanizales.myfirstapi1.Model.Store;
import co.edu.umanizales.myfirstapi1.Service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreService storeService;



    @GetMapping
    public List<Store> getAllStores() {
        return storeService.getStores();
    }


}