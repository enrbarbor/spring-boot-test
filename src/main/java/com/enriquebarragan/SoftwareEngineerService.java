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

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }


    public void insertSoftwareEngineer(SoftwareEngineerDTO request) {
        SoftwareEngineer engineer = SoftwareEngineer.builder()
                .name(request.name())
                .techStack(request.techStack())
                .build();
        softwareEngineerRepository.save(engineer);
    }

    public SoftwareEngineer getAllSoftwareEngineersById(Integer id) {
        return softwareEngineerRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "SoftwareEngineer id " + id + " not found")
        );
    }

    public void deleteSoftwareEngineer(Integer id) {
        SoftwareEngineer engineer = getAllSoftwareEngineersById(id);
        softwareEngineerRepository.delete(engineer);
    }

    public void updateSoftwareEngineer(Integer id,  SoftwareEngineerDTO request) {
        SoftwareEngineer engineer = getAllSoftwareEngineersById(id);
        engineer.setName(request.name());
        engineer.setTechStack(request.techStack());
        softwareEngineerRepository.save(engineer);
    }
}
