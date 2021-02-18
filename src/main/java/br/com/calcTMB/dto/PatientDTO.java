package br.com.calcTMB.dto;

import br.com.calcTMB.model.Patient;

public class PatientDTO {
    private Long id;
    private String name;//nome
    private Integer age;//idade
    private String gender;//genero
    private Double weight;//peso
    private Integer height;//altura
    private String activityLevel;//nivel de atividade

    public PatientDTO(){
    }

    public PatientDTO(Long id, String name, Integer age, String gender, Double weight, Integer height, String activityLevel) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.activityLevel = activityLevel;
    }

    public PatientDTO(Patient patient){
        this.id = patient.getId();
        this.name = patient.getName();
        this.age = patient.getAge();
        this.gender = patient.getGender();
        this.weight = patient.getWeight();
        this.height = patient.getHeight();
        this.activityLevel = patient.getActivityLevel();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }


}
