package br.com.calcTMB.repository;

import br.com.calcTMB.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CalcRepository extends JpaRepository<Patient, Long>{

    //@Query(value = "select p.age, p.gender, p.height, p.weight from Patient p where p.id = ?1")
    //Patient valueCalc(Long id);
}
