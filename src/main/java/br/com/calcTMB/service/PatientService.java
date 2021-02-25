package br.com.calcTMB.service;

import br.com.calcTMB.dto.PatientDTO;
import br.com.calcTMB.model.Patient;
import br.com.calcTMB.repository.PatientRepository;
import br.com.calcTMB.service.exceptions.DatabaseException;
import br.com.calcTMB.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private Calculator calc;

    @Autowired
    private PatientRepository repository;


    public Patient insert(Patient entity){
        entity.setTbm(calc.calcTbm(entity));
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

    @Transactional
    @Modifying
    public PatientDTO update (Long id, PatientDTO dto){
        try {
            Patient patient= repository.getOne(id);
            copyDtoToEntity(patient, dto);
            patient = repository.save(patient);
            return new PatientDTO(patient);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    @Transactional
    @Modifying
    public void delete (Long id){
        try{
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id not found " + id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Integrity violation");
        }
    }


    private void copyDtoToEntity(Patient patient, PatientDTO dto){
        patient.setName(dto.getName());
        patient.setAge(dto.getAge());
        patient.setGender(dto.getGender());
        patient.setWeight(dto.getWeight());
        patient.setHeight(dto.getHeight());
        patient.setActivityLevel(dto.getActivityLevel());
    }

}
