package GovernmentSchemes.controller;

import GovernmentSchemes.dto.GovernmentSchemeDTO;
import GovernmentSchemes.model.GovernmentScheme;
import GovernmentSchemes.service.GovernmentSchemeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/schemes")
public class GovernmentSchemeController {

    private final GovernmentSchemeService schemeService;

    @Autowired
    public GovernmentSchemeController(GovernmentSchemeService schemeService) {
        this.schemeService = schemeService;
    }

    @PostMapping
    public ResponseEntity<String> createScheme(@Valid @RequestBody GovernmentSchemeDTO dto) {
        schemeService.createScheme(dto);
        return ResponseEntity.ok("Scheme added successfully.");
    }

    @GetMapping
    public ResponseEntity<List<GovernmentScheme>> getAllSchemes() {
        List<GovernmentScheme> schemes = schemeService.getAllSchemes();
        return ResponseEntity.ok(schemes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GovernmentScheme> getSchemeById(@PathVariable int id) {
        GovernmentScheme scheme = schemeService.getSchemeById(id);
        return scheme != null ? ResponseEntity.ok(scheme) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateScheme(@PathVariable int id, @Valid @RequestBody GovernmentSchemeDTO dto) {
        boolean updated = schemeService.updateScheme(id, dto);
        return updated ? ResponseEntity.ok("Scheme updated successfully.") : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteScheme(@PathVariable int id) {
        boolean deleted = schemeService.deleteScheme(id);
        return deleted ? ResponseEntity.ok("Scheme deleted successfully.") : ResponseEntity.notFound().build();
    }
}
