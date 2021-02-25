package br.com.calcTMB.service;

import br.com.calcTMB.model.Patient;
import org.springframework.stereotype.Service;

@Service
public class Calculator {


    public Double calcTbmMas(Patient patient) {
        Double resultMas = 0.0;
        if(patient.getGender().equals("masculino")) {
            resultMas = 66.5 + (13.75 * patient.getWeight()) + (5.0 * patient.getHeight()) - (6.8 * patient.getAge());
        }
        return resultMas;
    }

    public Double calcTbmFem(Integer age, Double weight, Integer height) {
        Double resultFem = 0.0;
        return resultFem = 665.1 + (9.56 * weight) + (1.8 * height) - (4.7 * age);
    }
}
