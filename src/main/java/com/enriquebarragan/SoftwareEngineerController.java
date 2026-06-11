package com.enriquebarragan;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/softwareEngineer")
@AllArgsConstructor
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    @GetMapping
    public ResponseEntity<List<SoftwareEngineerDTO>> getSoftwareEngineers() {
        return ResponseEntity.ok(softwareEngineerService.getAllSoftwareEngineers());
    }

    @GetMapping("{id}")
    public ResponseEntity<SoftwareEngineerDTO> getSoftwareEngineerById(
            @PathVariable Integer id) {
        return ResponseEntity.ok(softwareEngineerService.getAllSoftwareEngineersById(id));
    }

    @PostMapping
    public ResponseEntity<SoftwareEngineerDTO> addNewSoftwareEngineer(
            @RequestBody @Valid SoftwareEngineerDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(softwareEngineerService.insertSoftwareEngineer(request));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSoftwareEngineer(
            @PathVariable Integer id) {
        softwareEngineerService.deleteSoftwareEngineer(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<SoftwareEngineerDTO> updateSoftwareEngineer(
            @PathVariable Integer id,
            @RequestBody @Valid SoftwareEngineerDTO request) {
        return ResponseEntity.ok(softwareEngineerService.updateSoftwareEngineer(id, request));
    }
}