package br.com.calcTMB.resources;

import br.com.calcTMB.dto.PatientDTO;
import br.com.calcTMB.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.calcTMB.service.PatientService;

import java.util.List;

@RestController
@RequestMapping(value = "/patients")
public class PatientResource {

    @Autowired
    private PatientService service;

    @PostMapping
    public ResponseEntity<Patient> insert(@RequestBody Patient entity){
        entity = service.insert(entity);
        return ResponseEntity.ok().body(entity);
    }

    @GetMapping
    public ResponseEntity<List<Patient>> findAll(){
        List<Patient> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Patient> findById(@PathVariable Long id){
        Patient patient = service.findById(id);
        return ResponseEntity.ok().body(patient);//body - corpo
    }

    //update
    @PutMapping(value = "/{id}")
    public ResponseEntity<PatientDTO> update(@PathVariable Long id, @RequestBody PatientDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }
}
