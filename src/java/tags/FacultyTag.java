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
 * @author Serikov S.
 */
public class FacultyTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        
        JspWriter out = getJspContext().getOut();
        out.println("<select id=\"sel_fac_tag\" name=\"faculty\" onChange=\"facultyClicked()\">\n" +
"                                    <option value=\"0\">- Select -</option>\n" +
"                                    <option value=\"1\">Faculty 1</option>\n" +
"                                    <option value=\"2\">Faculty 2</option>\n" +
"                                    <option value=\"3\">Faculty 3</option>\n" +
"                                    <option value=\"4\">Faculty 4</option>\n" +
"                                    <option value=\"5\">Faculty 5</option>\n" +
"                                    <option value=\"6\">Faculty 6</option>\n" +
"                                </select>\n" +
"                            </p>");
    }
}
