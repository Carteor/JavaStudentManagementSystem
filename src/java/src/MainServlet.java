/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import database.Student;
import database.BasicInfo;
import database.CurrentEducationInfo;
import database.Database;
import database.Document;
import database.EducationHistory;
import database.EducationHistoryArray;
import database.Faculty;
import database.Parent;
import database.Specialty;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Serikov S
 */
public class MainServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            System.out.println("MainServlet");
            String facid = null;
            String secid = null;

            //ajax request - don't move to another place or function
            //will give garbage to any ajax request otherwise
            if (request.getParameter("fac") != null) {
                facid = (String) request.getParameter("fac");
                //System.out.println("ajax request " + facid);
                if (facid != null && Integer.parseInt(facid) == 0) {
                    //System.out.println("Ajax request: " + facid);
                    response.setContentType("application/json");
                    String jsonObject = "[\n"
                            + "   {\"id\": \"0\" ,\"name\": \"faculty1\"},"
                            + "   {\"id\": \"1\" ,\"name\": \"faculty2\"},\n"
                            + "   {\"id\": \"2\" ,\"name\": \"faculty3\"\n"
                            + "}]";

                    out.print(jsonObject);
                    out.flush();
                }
            } else if (request.getParameter("sec") != null) {
                secid = (String) request.getParameter("sec");
                //System.out.println("Ajax request: " + secid);
                int id = Integer.parseInt(secid);

                response.setContentType("application/json");
                String jsonObject = "[{"
                        + "   \"name\": \"specialty" + id + " 1\"},"
                        + "   {\"name\": \"specialty" + id + " 2\"},\n"
                        + "   {\"name\": \"specialty" + id + " 3\"\n"
                        + "}]";
                //System.out.println(jsonObject);
                out.print(jsonObject);
                out.flush();
            } else {
                //System.out.println("no ajax, proceeding handling request by default case");

                Database db;
                db = new Database();

                Student student;
                RequestDispatcher rd;
                HttpSession session = request.getSession();

                if (request.getParameter("id") != null) {
                    //System.out.println("id passed");
                    String parameterId = (String) request.getParameter("id");
                    int id = Integer.parseInt(parameterId);
                    //System.out.println(id);
                    student = db.getStudent(id);
                } else {
                    //System.out.println("no passed id, create default student");
                    student = db.getDefaultStudent();
                    db.putStudent(student.id, student);
                }

                session.setAttribute("student", student);

                if (request.getParameter("is_submit") != null) {
                    System.out.println("form from edit.jsp is submitted");
                    student = (Student) session.getAttribute("student");

                    String studentId = request.getParameter("student_id");
                    String firstName = request.getParameter("first_name");
                    String lastName = request.getParameter("last_name");
                    String gender = request.getParameter("gender");
                    String birthday = request.getParameter("birthday_date");
                    String telephone1 = request.getParameter("telephone1");
                    String telephone2 = request.getParameter("telephone2");
                    String email1 = request.getParameter("email1");
                    String email2 = request.getParameter("email2");
                    String address = request.getParameter("address");
                    String nationality = request.getParameter("nationality");

                    BasicInfo basicInfo;
                    basicInfo = new BasicInfo(firstName, lastName, gender,
                            birthday, telephone1, telephone2, email1, email2,
                            address, nationality);

                    int id = Integer.parseInt(studentId);
                    student.setId(id);
                    student.setBasicInfo(basicInfo);

                    String docType = request.getParameter("doc_type");
                    String docNumber = request.getParameter("doc_number");
                    String docExpireTime = request.getParameter("doc_expire_time");
                    String docIssueOrganization = request.getParameter("doc_issue_organization");

                    Document document = new Document(docType, docNumber,
                            docExpireTime, docIssueOrganization);

                    student.setDocument(document);

                    String entryYear = request.getParameter("entry_year");
                    String eduLevel = request.getParameter("edu_level");
                    String paymentType = request.getParameter("payment_type");
                    String faculty = request.getParameter("faculty");
                    String specialty = request.getParameter("specialty");

                    Faculty fac = new Faculty(faculty);
                    Specialty spec = new Specialty(specialty);

                    CurrentEducationInfo cei = new CurrentEducationInfo(entryYear, eduLevel, paymentType, fac, spec);
                    student.setCurrentEducationInfo(cei);
                    String fatherName = request.getParameter("father_name");
                    String fatherWorkplace = request.getParameter("father_workplace");
                    String fatherMobilePhone = request.getParameter("father_mobile_phone");
                    String fatherHomePhone = request.getParameter("father_home_phone");
                    String fatherEmail = request.getParameter("father_email");
                    String fatherAddress = request.getParameter("father_address");
                    String motherName = request.getParameter("mother_name");
                    String motherWorkplace = request.getParameter("mother_workplace");
                    String motherMobilePhone = request.getParameter("mother_mobile_phone");
                    String motherHomePhone = request.getParameter("mother_home_phone");
                    String motherEmail = request.getParameter("mother_email");
                    String motherAddress = request.getParameter("mother_address");

                    Parent father = new Parent(fatherName, fatherWorkplace,
                        fatherMobilePhone, fatherHomePhone, fatherEmail,
                        fatherAddress);
                    Parent mother = new Parent(motherName, motherWorkplace,
                        motherMobilePhone, motherHomePhone, motherEmail, motherAddress);

                    student.setFather(father);
                    student.setMother(mother);

                    String eduPlaceName = request.getParameter("edu_place_name");
                    String duringTime1 = request.getParameter("during_time1");
                    String duringTime2 = request.getParameter("during_time2");
                    String duringTime = duringTime1 + " - " + duringTime2; 
                    String eduAddress = request.getParameter("edu_address");

                    EducationHistory eh = new EducationHistory(eduPlaceName, 
                        duringTime, eduAddress);
                    student.educationHistory.educationHistoryArray.add(eh);

                    db.replace(student);
                    session.setAttribute("student", student);
                    
                    db.UpdateDB();
                }

                request.setAttribute("studentId", student.id);

                if (request.getParameter("page") != null) {
                    String page = (String) request.getParameter("page");
                    //System.out.println("passed page: " + page);
                    if (page.equals("edit")) {
                        //System.out.println("forwarding to edit page");
                        rd = request.getRequestDispatcher("/edit.jsp");
                        rd.forward(request, response);
                        return;
                    } else if (page.equals("home")) {
                        //System.out.println("forwarding to main page");
                        rd = request.getRequestDispatcher("main.jsp");
                        rd.forward(request, response);
                        return;
                    }
                }

                rd = request.getRequestDispatcher("main.jsp");
                rd.forward(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
