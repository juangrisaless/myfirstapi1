package co.edu.umanizales.myfirstapi1.Service;

import co.edu.umanizales.myfirstapi1.Model.Municipality;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class MunicipalityService {
    private List<Municipality> municipalities = new ArrayList<>();

    @PostConstruct
    public void init() {
        loadMunicipalitiesFromCSV();
    }

    private void loadMunicipalitiesFromCSV() {
        try {
            InputStream is = new ClassPathResource("Codigos_municipios.csv").getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            // Saltar cabecera
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = parseCSVLine(line);
                if(data.length >= 7) {
                    Municipality municipality = new Municipality(
                            data[0], data[1], data[2],
                            data[3], data[4], data[5], data[6]
                    );
                    municipalities.add(municipality);
                }
            }
            System.out.println("Municipios cargados: " + municipalities.size());
        } catch (Exception e) {
            System.err.println("Error cargando municipios: " + e.getMessage());
        }
    }

    private String[] parseCSVLine(String line) {
        List<String> values = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inQuotes = false;

        for (char c : line.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                values.add(sb.toString().trim());
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        values.add(sb.toString().trim());
        return values.toArray(new String[0]);
    }

    public List<Municipality> getAllMunicipalities() {
        return municipalities;
    }

    public Municipality getMunicipalityByCode(String code) {
        for (Municipality m : municipalities) {
            if (m.getMunicipalityCode().equals(code)) {
                return m;
            }
        }
        return null;
    }
}