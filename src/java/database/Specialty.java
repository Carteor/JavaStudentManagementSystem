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
public class Specialty {

    public Integer id = 0;
    public String name = "";

    public Specialty(String name) {
        id = 0;
        this.name = name;
    }

    public Specialty() {
        id = 0;
        name="";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
