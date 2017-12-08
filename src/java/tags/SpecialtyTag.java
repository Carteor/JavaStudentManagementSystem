/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;
/**
 *
 * @author Serikov S
 */
public class SpecialtyTag extends SimpleTagSupport {
    private String id;
    
    public void setId(String id){
        this.id = id;
    }
    
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();

        out.println("<select id=\"sel_fac_tag\" name=\"specialty\" onChange=\"facultyClicked()\">");
        
        for (int i = 0; i < 5; i++) {
            out.println("<option value=\"" + id + "\">Specialty " + id + " " + i + "</option>\n");
        
        }
        out.println("</select>\n");
    }
}
