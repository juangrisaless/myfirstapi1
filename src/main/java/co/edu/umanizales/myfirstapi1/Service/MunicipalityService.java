package co.edu.umanizales.myfirstapi1.Service;

import co.edu.umanizales.myfirstapi1.Model.Municipality;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MunicipalityService {
    // Mapa para almacenar los municipios (clave: código del municipio)
    private final Map<String, Municipality> municipalities = new HashMap<>();

    public MunicipalityService() {
        // Inicializar con algunos datos de ejemplo (puedes cargarlos desde CSV o BD)
        loadSampleData();
    }

    private void loadSampleData() {
        municipalities.put("05001", new Municipality("05", "Antioquia", "05001", "Medellín", "Municipio", "-75.567", "6.235"));
        municipalities.put("17001", new Municipality("17", "Caldas", "17001", "Manizales", "Municipio", "-75.517", "5.070"));
        municipalities.put("66001", new Municipality("66", "Risaralda", "66001", "Pereira", "Municipio", "-75.715", "4.813"));
    }

    /**
     * Método para buscar un municipio por su código.
     * @param code Código del municipio (ej: "05001")
     * @return Objeto Municipality o null si no se encuentra.
     */
    public Municipality getMunicipalityByCode(String code) {
        return municipalities.get(code);
    }
}