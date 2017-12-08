/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;

/**
 *
 * @author Serikov S.
 */
public class EducationHistoryArray {
        public static ArrayList<EducationHistory> educationHistoryArray = new ArrayList<>();
        
        public EducationHistoryArray() {
        }
        
        public void add(EducationHistory eha) {
            educationHistoryArray.add(eha);
        }
    }
