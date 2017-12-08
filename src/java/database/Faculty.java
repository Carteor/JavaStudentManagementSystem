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
public class Faculty {
        public String name = "";
        
        public Faculty (String name) {
            this.name = name;
        }

    public Faculty() {
        this.name = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
        
        
    }
