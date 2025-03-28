package co.edu.umanizales.myfirstapi1.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Location {
    private String code;
    private String description;

    @Override
    public String toString() {
        return description + " (" + code + ")";
    }
}