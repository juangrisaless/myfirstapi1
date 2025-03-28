// En src/main/java/co/edu/umanizales/myfirstapi1/Model/Municipality.java
package co.edu.umanizales.myfirstapi1.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Municipality {
    private String departmentCode;
    private String departmentName;
    private String municipalityCode;
    private String municipalityName;
    private String type;
    private String longitude;
    private String latitude;
}
