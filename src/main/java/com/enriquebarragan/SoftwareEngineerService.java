package com.enriquebarragan;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public List<SoftwareEngineerDTO> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public SoftwareEngineerDTO getAllSoftwareEngineersById(Integer id) {
        SoftwareEngineer engineer = softwareEngineerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "SoftwareEngineer id " + id + " not found")
        );
        return toDTO(engineer);
    }

    public SoftwareEngineerDTO insertSoftwareEngineer(SoftwareEngineerDTO request) {
        SoftwareEngineer engineer = SoftwareEngineer.builder()
                .name(request.name())
                .techStack(request.techStack())
                .build();
        return toDTO(softwareEngineerRepository.save(engineer));
    }

    public void deleteSoftwareEngineer(Integer id) {
        SoftwareEngineer engineer = softwareEngineerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "SoftwareEngineer id " + id + " not found")
        );
        softwareEngineerRepository.delete(engineer);
    }

    public SoftwareEngineerDTO updateSoftwareEngineer(Integer id, SoftwareEngineerDTO request) {
        SoftwareEngineer engineer = softwareEngineerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "SoftwareEngineer id " + id + " not found")
        );
        engineer.setName(request.name());
        engineer.setTechStack(request.techStack());
        return toDTO(softwareEngineerRepository.save(engineer));
    }

    // -- Conversión privada entidad -> DTO --
    private SoftwareEngineerDTO toDTO(SoftwareEngineer engineer) {
        return SoftwareEngineerDTO.builder()
                .name(engineer.getName())
                .techStack(engineer.getTechStack())
                .build();
    }
}