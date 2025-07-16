package com.talentpool.retoaws.domain.model.person;

public class PersonModel {
    private Long id;
    private String identificationNumber;
    private String name;
    private String email;

    public PersonModel() {
    }

    public PersonModel(Long id, String identificationNumber, String name, String email) {
        this.id = id;
        this.identificationNumber = identificationNumber;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        return identificationNumber != null ? identificationNumber.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        PersonModel that = (PersonModel) obj;
        return identificationNumber != null ? identificationNumber.equals(that.identificationNumber)
                : that.identificationNumber == null;
    }

    @Override
    public String toString() {
        return "PersonModel{" +
                "id=" + id +
                ", identificationNumber='" + identificationNumber + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
