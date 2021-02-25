package br.com.calcTMB.resources;

import br.com.calcTMB.dto.PatientDTO;
import br.com.calcTMB.model.Patient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping(value="/api")
@Api(value = "API REST Patients")
//TODO libera todos os dominios para acessarem a API
@CrossOrigin(origins = "*")
public class PatientResource {

    @Autowired
    private PatientService service;

    @PostMapping(value = "/save")
    @ApiOperation(value = "Insere um novo paciente")
    public ResponseEntity<Patient> insert(@RequestBody Patient entity){
        entity = service.insert(entity);
        return ResponseEntity.ok().body(entity);
    }

    @GetMapping(value = "/patients")
    @ApiOperation(value = "Busca todos os pacientes")
    public ResponseEntity<List<Patient>> findAll(){
        List<Patient> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Busca um paciente pelo id")
    public ResponseEntity<Patient> findById(@PathVariable Long id){
        Patient patient = service.findById(id);
        return ResponseEntity.ok().body(patient);//body - corpo
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualiza um paciente com base no id passado")
    public ResponseEntity<PatientDTO> update(@PathVariable Long id, @RequestBody PatientDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Deleta um paciente")
    public ResponseEntity<PatientDTO> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
