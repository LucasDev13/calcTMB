package br.com.calcTMB.service;

import br.com.calcTMB.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.calcTMB.repository.PatientRepository;

import java.util.List;

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
}
