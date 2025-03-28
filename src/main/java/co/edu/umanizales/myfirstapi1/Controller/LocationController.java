package co.edu.umanizales.myfirstapi1.Controller;

import co.edu.umanizales.myfirstapi1.Model.Location;
import co.edu.umanizales.myfirstapi1.Model.Municipality;
import co.edu.umanizales.myfirstapi1.Service.MunicipalityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public class LocationController {
    private final MunicipalityService municipalityService;

    public LocationController(MunicipalityService municipalityService) {
        this.municipalityService = municipalityService;
    }

    @GetMapping
    public Location getSampleLocation() {
        // Ejemplo: Medellín (código 05001)
        Municipality municipality = municipalityService.getMunicipalityByCode("05001");
        if(municipality != null) {
            return new Location(
                    municipality.getMunicipalityCode(),
                    municipality.getMunicipalityName()
            );
        }
        return new Location("00000", "Desconocido");
    }
}