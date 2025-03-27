package co.edu.umanizales.myfirstapi1.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Store {
    private String code;
    private String name;
    private Location location;
    private String address;
    private String phone;
    private Seller manager;
    private boolean active;
}