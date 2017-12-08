/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Serikov S.
 */
 public class CurrentEducationInfo {
        public String entryYear;
        public String educationLevel;
        public String paymentType;
        public Faculty faculty;
        public Specialty specialty;
        
        public CurrentEducationInfo(String entryYear, String educationLevel,
                String paymentType, Faculty faculty, Specialty specialty) {
            this.entryYear = entryYear;
            this.educationLevel = educationLevel;
            this.paymentType = paymentType;
            this.faculty = faculty;
            this.specialty = specialty;
        }

    public CurrentEducationInfo() {
        this.entryYear = "";
        this.educationLevel = "";
        this.paymentType = "";
        this.faculty = null;
        this.specialty = null;
    }

    public String getEntryYear() {
        return entryYear;
    }

    public void setEntryYear(String entryYear) {
        this.entryYear = entryYear;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }
        
        
    }
