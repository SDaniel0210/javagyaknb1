package com.example.javagyaknb1.controller;

import com.example.javagyaknb1.repository.PosztRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class DiagramController {

    private final PosztRepository posztRepository;

    public DiagramController(PosztRepository posztRepository) {
        this.posztRepository = posztRepository;
    }

    // DIAGRAM OLDAL
    @GetMapping("/diagram")
    public String diagram() {
        return "diagram";
    }

    // JSON ADATOK
    @GetMapping("/api/diagramdata")
    @ResponseBody
    public ResponseEntity<Map<String, Double>> getDiagramData() {

        var rows = posztRepository.countPlayersByPoszt(); // saját JPQL

        double total = rows.stream()
                .mapToDouble(r -> (Long) r[1])
                .sum();

        Map<String, Double> result = new LinkedHashMap<>();

        for (Object[] r : rows) {
            String nev = (String) r[0];
            Long db = (Long) r[1];

            double szazalek = (total == 0)
                    ? 0
                    : Math.round((db / total) * 10000.0) / 100.0;

            result.put(nev, szazalek);
        }

        return ResponseEntity.ok(result);
    }
}
