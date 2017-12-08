/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Serikov S.
 */
public class Database {

    public static HashMap<Integer, Student> students = new HashMap<>();

    public static Connection conn;
    public static Statement smt;
    public static ResultSet resSet;

    public Database() {
        try {
            Conn();
            CreateDB();
            FillDB();
            getStudentsFromDB();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Student getDefaultStudent() {
        Faculty f = new Faculty("");

        Specialty s = new Specialty("");

        CurrentEducationInfo cur = new CurrentEducationInfo("", "",
                "", f, s);

        BasicInfo basicInfo = new BasicInfo("",
                "", "", "", "",
                "", "", "",
                "", "");

        Document document = new Document("", "",
                "", "");

        Parent father = new Parent("", "", 
                "", "", 
                "", "");

        Parent mother = new Parent("", "", 
                "", "", 
                "", "");

        EducationHistoryArray eh = new EducationHistoryArray();

        Student student = new Student(0, basicInfo, cur, document, 
                father, mother, "", eh);

        return student;
    }

    public void replace(Student student) {
        int prevId = student.id;
        students.remove(prevId);
        students.put(student.id, student);
    }

    public Student getStudent(int id) {
        return students.get(id);
    }

    public void putStudent(int id, Student student) {
        students.put(id, student);
    }

    public void Conn() throws ClassNotFoundException, SQLException {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:TEST1.s3db");

        System.out.println("Database connected");
    }

    public void CreateDB() throws ClassNotFoundException, SQLException {
        smt = conn.createStatement();

        smt.execute("CREATE TABLE IF NOT EXISTS 'education_history' ("
                + "'id' INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "'educated_place_name' TEXT, "
                + "'during_time' TEXT,"
                + "'address' TEXT);");
        smt.close();

        smt = conn.createStatement();
        smt.execute("CREATE TABLE IF NOT EXISTS 'specialty' ("
                + "'id' INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "'id_faculty' INTEGER, "
                + "'name' TEXT);");
        smt.close();

        //dropStudentTable();
        smt = conn.createStatement();
        smt.execute("CREATE TABLE IF NOT EXISTS 'student' ("
                + "'id' INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "'id_student INTEGER,'"
                + "'id_specialty' TEXT, "
                + "'first_name' TEXT, "
                + "'last_name' TEXT, "
                + "'entry_year' TEXT, "
                + "'edu_level' TEXT, "
                + "'payment_type' TEXT, "
                + "'gender' TEXT, "
                + "'birthday' TEXT, "
                + "'telephone1' TEXT, "
                + "'telephone2' TEXT, "
                + "'email1' TEXT, "
                + "'email2' TEXT, "
                + "'address' TEXT, "
                + "'nationality' TEXT, "
                + "'doc_type' TEXT, "
                + "'doc_number' TEXT, "
                + "'doc_expire' TEXT, "
                + "'doc_issue_organization' TEXT, "
                + "'edu_place_name' TEXT, "
                + "'during_time' TEXT, "
                + "'edu_address' TEXT, "
                + "'father_name' TEXT, "
                + "'father_workplace' TEXT, "
                + "'father_mobile_phone' TEXT, "
                + "'father_home_phone' TEXT, "
                + "'father_email' TEXT, "
                + "'father_adress' TEXT, "
                + "'mother_name' TEXT, "
                + "'mother_workplace' TEXT, "
                + "'mother_mobile_phone' TEXT, "
                + "'mother_home_phone' TEXT, "
                + "'mother_email' TEXT, "
                + "'mother_address' TEXT, "
                + "'Image_path' TEXT, "
                + "'idEdu' INTEGER);");
        smt.close();

        smt = conn.createStatement();
        smt.execute("CREATE TABLE IF NOT EXISTS 'faculty' ("
                + "'id' INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "id_faculty INTEGER, "
                + "'name' TEXT);");
        smt.close();

        System.out.println("Table is created or already exists");
    }

    public void createStudentTable() throws SQLException {
        smt = conn.createStatement();
        smt.execute("CREATE TABLE IF NOT EXISTS 'student' ("
                + "'id' INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "'id_student INTEGER,'"
                + "'id_specialty' TEXT, "
                + "'first_name' TEXT, "
                + "'last_name' TEXT, "
                + "'entry_year' TEXT, "
                + "'edu_level' TEXT, "
                + "'payment_type' TEXT, "
                + "'gender' TEXT, "
                + "'birthday' TEXT, "
                + "'telephone1' TEXT, "
                + "'telephone2' TEXT, "
                + "'email1' TEXT, "
                + "'email2' TEXT, "
                + "'address' TEXT, "
                + "'nationality' TEXT, "
                + "'doc_type' TEXT, "
                + "'doc_number' TEXT, "
                + "'doc_expire' TEXT, "
                + "'doc_issue_organization' TEXT, "
                + "'edu_place_name' TEXT, "
                + "'during_time' TEXT, "
                + "'edu_address' TEXT, "
                + "'father_name' TEXT, "
                + "'father_workplace' TEXT, "
                + "'father_mobile_phone' TEXT, "
                + "'father_home_phone' TEXT, "
                + "'father_email' TEXT, "
                + "'father_adress' TEXT, "
                + "'mother_name' TEXT, "
                + "'mother_workplace' TEXT, "
                + "'mother_mobile_phone' TEXT, "
                + "'mother_home_phone' TEXT, "
                + "'mother_email' TEXT, "
                + "'mother_address' TEXT, "
                + "'Image_path' TEXT, "
                + "'idEdu' INTEGER);");
        smt.close();
    }

    public void dropStudentTable() throws SQLException {
        smt = conn.createStatement();
        smt.execute("DROP student if exists;");
        smt.close();
    }

    public void FillDB() throws SQLException {
        smt.execute("INSERT INTO specialty (id_faculty, name) VALUES "
                + "(1, 'Information System'),"
                + "(1, 'Software Engineer'),"
                + "(1, 'Hardword Engineer'),"
                + "(2, 'Local Economy'),"
                + "(2, 'Global Economy'),"
                + "(3, 'Kazakhstan Low'),"
                + "(3, 'International Low '),"
                + "(4, 'Turik culture ');");

        smt.execute("INSERT INTO faculty (id_faculty, name) VALUES "
                + "(2,'ECO'),"
                + "(1,'Engineering'),"
                + "(3,'LOW'),"
                + "(4,'Philo');");

        System.out.println("Table is filled");
    }

    public void PrintFaculty() throws SQLException {
        System.out.println("PrintFaculty()");
        resSet = smt.executeQuery("SELECT * FROM specialty");
        while (resSet.next()) {
            String idFaculty = resSet.getString("id_faculty");
            String name = resSet.getString("name");

            System.out.println(idFaculty + " " + name);
        }
    }

    public void UpdateDB() throws SQLException {
        //dropStudentTable();
        createStudentTable();

        Iterator it = students.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            InsertIntoStudentTable((Student) pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }

    public void InsertIntoStudentTable(Student student) throws SQLException {
        smt.execute("INSERT INTO student ("
                + "id_student, id_specialty, first_name, last_name, entry_year, "
                + "edu_level, payment_type, gender, birthday, telephone1, "
                + "telephone2, email1, email2, address, nationality, doc_type, "
                + "doc_expire, doc_issue_organization, edu_place_name, "
                + "during_time, edu_address, father_name, father_workplace, "
                + "father_mobile_phone, father_home_phone, father_email, "
                + "father_adress, mother_name, mother_workplace, "
                + "mother_mobile_phone, mother_home_phone, mother_email, "
                + "mother_address) VALUES "
                + "(" + student.id + ", "
                + student.currentEducationInfo.specialty.id + ", "
                + student.basicInfo.firstName + ", "
                + student.basicInfo.lastName + ", "
                + student.currentEducationInfo.entryYear + ", "
                + student.currentEducationInfo.educationLevel + ", "
                + student.currentEducationInfo.paymentType + ", "
                + student.basicInfo.gender + ", "
                + student.basicInfo.birthday + ", "
                + student.basicInfo.telephone1 + ", "
                + student.basicInfo.telephone2 + ", "
                + student.basicInfo.email1 + ", "
                + student.basicInfo.email2 + ", "
                + student.basicInfo.address + ", "
                + student.basicInfo.nationality + ", "
                + student.document.documentType + ", "
                + student.document.documentExpire + ", "
                + student.document.documentIssueOrganization + ", "
                + student.educationHistory.educationHistoryArray.get(0).educationPlaceName + ", "
                + student.educationHistory.educationHistoryArray.get(0).duringTime + ", "
                + student.educationHistory.educationHistoryArray.get(0).address + ", "
                + student.father.name + ", "
                + student.father.workingPlace + ", "
                + student.father.mobilePhone + ", "
                + student.father.homePhone + ", "
                + student.father.email + ", "
                + student.father.address + ", "
                + student.mother.name + ", "
                + student.mother.workingPlace + ", "
                + student.mother.mobilePhone + ", "
                + student.mother.homePhone + ", "
                + student.mother.email + ", "
                + student.mother.address + ");");
    }

    public void getStudentsFromDB() throws SQLException {
        resSet = smt.executeQuery("SELECT * FROM student");
        while (resSet.next()) {
            String studentId = resSet.getString("id_student");
            String firstName = resSet.getString("first_name");
            String lastName = resSet.getString("last_name");
            String gender = resSet.getString("gender");
            String birthday = resSet.getString("birthday");
            String telephone1 = resSet.getString("telephone1");
            String telephone2 = resSet.getString("telephone2");
            String email1 = resSet.getString("email1");
            String email2 = resSet.getString("email2");
            String address = resSet.getString("address");
            String nationality = resSet.getString("nationality");

            BasicInfo basicInfo = new BasicInfo(firstName, lastName, gender, birthday,
                    telephone1, telephone2, email1, email2, address, nationality);

            String docType = resSet.getString("doc_type");
            String docNumber = resSet.getString("doc_number");
            String docExpireTime = resSet.getString("doc_expire_time");
            String docIssueOrganization = resSet.getString("doc_issue_organization");

            Document document = new Document(docType, docNumber, docExpireTime, docIssueOrganization);

            String entryYear = resSet.getString("entry_year");
            String eduLevel = resSet.getString("edu_level");
            String paymentType = resSet.getString("payment_type");
            String faculty = resSet.getString("faculty");
            String specialty = resSet.getString("specialty");

            Faculty f = new Faculty(faculty);
            Specialty s = new Specialty(specialty);
            CurrentEducationInfo cur = new CurrentEducationInfo(entryYear, eduLevel, paymentType, f, s);

            String fatherName = resSet.getString("father_name");
            String fatherWorkplace = resSet.getString("father_workplace");
            String fatherMobilePhone = resSet.getString("father_mobile_phone");
            String fatherHomePhone = resSet.getString("father_home_phone");
            String fatherEmail = resSet.getString("father_email");
            String fatherAddress = resSet.getString("father_address");

            Parent father = new Parent(fatherName, fatherWorkplace, fatherHomePhone,
                    fatherMobilePhone, fatherEmail, fatherAddress);

            String motherName = resSet.getString("mother_name");
            String motherWorkplace = resSet.getString("mother_workplace");
            String motherMobilePhone = resSet.getString("mother_mobile_phone");
            String motherHomePhone = resSet.getString("mother_home_phone");
            String motherEmail = resSet.getString("mother_email");
            String motherAddress = resSet.getString("mother_address");

            Parent mother = new Parent(motherName, motherWorkplace, motherMobilePhone,
                    motherHomePhone, motherEmail, motherAddress);

            String eduPlaceName = resSet.getString("edu_place_name");
            String duringTime = resSet.getString("during_time");
            String eduAddress = resSet.getString("edu_address");

            EducationHistoryArray eh = new EducationHistoryArray();

            eh.add(new EducationHistory(eduPlaceName, duringTime, eduAddress));

            Student student = new Student(0, basicInfo, cur, document, father, mother, "image f", eh);

            Integer intId = Integer.parseInt(studentId);
            students.put(intId, student);
        }

        System.out.println("Table is shown");
    }

    public void CloseDB() throws ClassNotFoundException, SQLException {
        conn.close();
        smt.close();
        resSet.close();
        System.out.println("Connections are closed");
    }
}
