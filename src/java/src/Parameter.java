/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author Serikov S.
 */
public class Parameter {
        public String name;
        public boolean isOk = true;
        public boolean isNull = true;
        
        Parameter(String name, boolean isNull){
            this.name = name;
            this.isNull = isNull;
        }
    }
