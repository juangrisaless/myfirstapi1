package co.edu.umanizales.myfirstapi1.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class Location {
    private String code;
    private String description;


}