package co.edu.umanizales.myfirstapi1.Service;

import co.edu.umanizales.myfirstapi1.Model.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Getter
public class StoreService {

    @Value("${stores_filename}")
    private String StoresFileName;

    private  List<Store> stores = new ArrayList<>();
    private final Map<String, Municipality> municipalities = new HashMap<>();

    public StoreService() {
        loadMunicipalities(); // Cargar municipios de referencia
        loadStoresFromCSV();  // Cargar tiendas desde CSV
    }

    private void loadMunicipalities() {
        // Datos de ejemplo (pueden cargarse desde otro CSV)
        municipalities.put("17001", new Municipality("17", "Caldas", "17001", "Manizales", "Municipio", "-75.517", "5.070"));
        municipalities.put("66001", new Municipality("66", "Risaralda", "66001", "Pereira", "Municipio", "-75.715", "4.813"));
        municipalities.put("05001", new Municipality("05", "Antioquia", "05001", "Medellín", "Municipio", "-75.567", "6.235"));
    }

    private void loadStoresFromCSV() {
        try {
            // 1. Obtener el archivo desde resources
            File file = ResourceUtils.getFile("classpath:CDCM.CSV");

            // 2. Leer el archivo línea por línea
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                boolean isFirstLine = true;

                while ((line = br.readLine()) != null) {
                    if (isFirstLine) {
                        isFirstLine = false;
                        continue; // Saltar cabecera
                    }

                    // 3. Procesar cada línea del CSV
                    String[] data = line.split(",");
                    if (data.length >= 5) { // Validar que tenga todas las columnas
                        Store store = createStoreFromCSV(data);
                        if (store != null) {
                            stores.add(store);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("❌ Error: Archivo CDCM.CSV no encontrado en resources. Verifica la ubicación.");
        } catch (IOException e) {
            System.err.println("❌ Error al leer el archivo CSV: " + e.getMessage());
        }
    }

    private Store createStoreFromCSV(String[] data) {
        try {
            String code = data[0].trim();
            String name = data[1].trim();
            String address = data[2].trim();
            String phone = data[3].trim();
            String municipalityCode = data[4].trim();

            // Obtener municipio o usar "Desconocido"
            Municipality municipality = municipalities.get(municipalityCode);
            Location location = new Location(
                    municipalityCode,
                    municipality != null ? municipality.getMunicipalityName() : "Desconocido"
            );

            return new Store(code, name, location, address, phone);
        } catch (Exception e) {
            System.err.println("⚠️ Error al procesar línea del CSV: " + String.join(",", data));
            return null;
        }
    }



    public List<Map<String, String>> listLocations() {
        List<Map<String, String>> result = new ArrayList<>();
        municipalities.values().forEach(mun -> {
            Map<String, String> location = new HashMap<>();
            location.put("departmentCode", mun.getDepartmentCode());
            location.put("departmentName", mun.getDepartmentName());
            location.put("municipalityCode", mun.getMunicipalityCode());
            location.put("municipalityName", mun.getMunicipalityName());
            result.add(location);
        });
        return result;
    }
}
//stores:list