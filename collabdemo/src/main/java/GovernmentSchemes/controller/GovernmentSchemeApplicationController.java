package GovernmentSchemes.controller;

import GovernmentSchemes.dto.GovernmentSchemeApplicationDTO;
import GovernmentSchemes.service.GovernmentSchemeApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/applications")
public class GovernmentSchemeApplicationController {

    private final GovernmentSchemeApplicationService appService;

    @Autowired
    public GovernmentSchemeApplicationController(GovernmentSchemeApplicationService appService) {
        this.appService = appService;
    }

    @PostMapping("/apply")
    public ResponseEntity<String> apply(@Valid @RequestBody GovernmentSchemeApplicationDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder errors = new StringBuilder();
            result.getAllErrors().forEach(error -> errors.append(error.getDefaultMessage()).append("\n"));
            return ResponseEntity.badRequest().body(errors.toString());
        }
        appService.apply(dto);
        return ResponseEntity.ok("Application submitted!");
    }

    @GetMapping("/all")
    public ResponseEntity<List<GovernmentSchemeApplicationDTO>> getAllApplications() {
        return ResponseEntity.ok(appService.getAllApplications());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GovernmentSchemeApplicationDTO> getApplicationById(@PathVariable int id) {
        GovernmentSchemeApplicationDTO dto = appService.getApplication(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateApplication(@Valid @RequestBody GovernmentSchemeApplicationDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder errors = new StringBuilder();
            result.getAllErrors().forEach(error -> errors.append(error.getDefaultMessage()).append("\n"));
            return ResponseEntity.badRequest().body(errors.toString());
        }

        boolean updated = appService.updateApplication(dto);
        return updated ? ResponseEntity.ok("Application updated!") : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteApplication(@PathVariable int id) {
        boolean deleted = appService.deleteApplication(id);
        return deleted ? ResponseEntity.ok("Application deleted!") : ResponseEntity.notFound().build();
    }
}
