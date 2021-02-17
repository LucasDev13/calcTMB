package br.com.calcTMB.resources;

import br.com.calcTMB.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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


}