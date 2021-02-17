package br.com.calcTMB.service;

import br.com.calcTMB.model.Patient;
import br.com.calcTMB.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.calcTMB.repository.PatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public Patient insert(Patient entity){
        entity = repository.save(entity);
        return entity;
    }

    @Transactional(readOnly = true)
    public List<Patient> findAll(){
        List<Patient> list = repository.findAll();
        return list;
    }

    @Transactional(readOnly = true)
    public Patient findById(Long id){
        Optional<Patient> obj = repository.findById(id);
        Patient patient = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return patient;
    }

}
