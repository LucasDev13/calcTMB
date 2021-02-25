package br.com.calcTMB.service;

import br.com.calcTMB.model.Patient;
import org.springframework.stereotype.Service;

@Service
public class Calculator {


    public Double calcTbm(Patient patient) {
        Double result = 0.0;
        if(patient.getGender().equals("masculino")) {
            result = 66.5 + (13.75 * patient.getWeight()) + (5.0 * patient.getHeight()) - (6.8 * patient.getAge());
        }else{
            result = 665.1 + (9.56 * patient.getWeight()) + (1.8 * patient.getHeight()) - (4.7 * patient.getAge());
        }
        return result;
    }

   /** public Double calcTbmFem(Integer age, Double weight, Integer height) {
        Double resultFem = 0.0;
        return resultFem = 665.1 + (9.56 * weight) + (1.8 * height) - (4.7 * age);
    }*/
}
