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
public class EducationHistory {
        public String educationPlaceName;
        public String duringTime;
        public String address;

    public EducationHistory(String educationPlaceName, String duringTime, String address) {
        this.educationPlaceName = educationPlaceName;
        this.duringTime = duringTime;
        this.address = address;
    }

    public EducationHistory() {
        this.educationPlaceName = "";
        this.duringTime = "";
        this.address = "";
    }

    public String getEducationPlaceName() {
        return educationPlaceName;
    }

    public void setEducationPlaceName(String educationPlaceName) {
        this.educationPlaceName = educationPlaceName;
    }

    public String getDuringTime() {
        return duringTime;
    }

    public void setDuringTime(String duringTime) {
        this.duringTime = duringTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
        
        
    }
