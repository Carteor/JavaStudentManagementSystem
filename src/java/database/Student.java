/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Serikov Sayat
 */
public class Student {

    public Integer id;
    public BasicInfo basicInfo;
    public CurrentEducationInfo currentEducationInfo;

    public Document document;
    public Parent father;
    public Parent mother;
    public String imagePath;
    public EducationHistoryArray educationHistory;

    public Student(int id, BasicInfo bi, CurrentEducationInfo cei, Document d, Parent f, Parent m,
            String ip, EducationHistoryArray e) {
        this.id = id;
        this.basicInfo = bi;
        this.currentEducationInfo = cei;
        this.document = d;
        this.father = f;
        this.mother = m;
        this.imagePath = ip;
        this.educationHistory = e;
    }

    public Student() {
        this.id = 0;
        this.basicInfo = null;
        this.currentEducationInfo = null;
        this.document = null;
        this.father = null;
        this.mother = null;
        this.imagePath = "";
        this.educationHistory = null;
    }
    
    

    public void setId(int id) {
        this.id = id;
    }

    public void setBasicInfo(BasicInfo basicInfo) {
        this.basicInfo = basicInfo;
    }

    public void setCurrentEducationInfo(CurrentEducationInfo currentEducationInfo) {
        this.currentEducationInfo = currentEducationInfo;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public void setFather(Parent father) {
        this.father = father;
    }

    public void setMother(Parent mother) {
        this.mother = mother;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setEducationHistory(EducationHistoryArray educationHistory) {
        this.educationHistory = educationHistory;
    }

}
