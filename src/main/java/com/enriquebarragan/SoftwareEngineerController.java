package com.enriquebarragan;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/softwareEngineer")
@AllArgsConstructor
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    @GetMapping
    public List<SoftwareEngineer> getSoftwareEngineers() {
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    @GetMapping("{id}")
    public SoftwareEngineer getSoftwareEngineerById(
            @PathVariable Integer id) {
        return softwareEngineerService.getAllSoftwareEngineersById(id);
    }

    @PostMapping
    public void addNewSoftwareEngineer(
            @RequestBody SoftwareEngineerDTO request) {
        softwareEngineerService.insertSoftwareEngineer(request);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSoftwareEngineer(
            @PathVariable Integer id) {
        softwareEngineerService.deleteSoftwareEngineer(id);
    }

    @PutMapping("{id}")
    public void updateSoftwareEngineer(
            @PathVariable Integer id,
            @RequestBody SoftwareEngineerDTO request) {
        softwareEngineerService.updateSoftwareEngineer(id, request);
    }
}
