package co.edu.umanizales.myfirstapi1.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Sale {
    private String code;
    private Store store;
    private Seller seller;
    private short quantity;
    private double total;
    private String paymentMethod; // Efectivo, Tarjeta, Transferencia
    private String date; // Formato: "YYYY-MM-DD HH:MM"
}