/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import javax.servlet.ServletRequest;

/**
 *
 * @author Serikov S.
 */
public class EditPageHandler {
    public Parameter studentId;
    public Parameter firstName;
    public Parameter lastName;
    public Parameter gender;
    public Parameter birthdayDate;
    public Parameter telephone1;
    public Parameter telephone2;
    public Parameter email1;
    public Parameter email2;
    public Parameter address;
    public Parameter nationality;
    public Parameter docType;
    public Parameter docNumber;
    public Parameter docExpireTime;
    public Parameter docIssueOrganization;
    public Parameter entryYear;
    public Parameter eduLevel;
    public Parameter paymentType;
    public Parameter faculty;
    public Parameter specialty;
    public Parameter fatherName;
    public Parameter fatherWorkplace;
    public Parameter fatherHomePhone;
    public Parameter fatherAddress;
    public Parameter motherName;
    public Parameter motherWorkplace;
    public Parameter fatherMobilePhone;
    public Parameter motherMobilePhone;
    public Parameter motherHomePhone;
    public Parameter fatherEmail;
    public Parameter motherEmail;
    public Parameter motherAddress;
    public Parameter eduPlaceName;
    public Parameter duringTime;
    public Parameter duringTime1;
    public Parameter duringTime2;
    public Parameter eduAddress;

    public Parameter getStudentId() {
        return studentId;
    }

    public Parameter getFirstName() {
        return firstName;
    }

    public Parameter getLastName() {
        return lastName;
    }

    public Parameter getGender() {
        return gender;
    }

    public Parameter getBirthdayDate() {
        return birthdayDate;
    }

    public Parameter getTelephone1() {
        return telephone1;
    }

    public Parameter getTelephone2() {
        return telephone2;
    }

    public Parameter getEmail1() {
        return email1;
    }

    public Parameter getEmail2() {
        return email2;
    }

    public Parameter getAddress() {
        return address;
    }

    public Parameter getNationality() {
        return nationality;
    }

    public Parameter getDocType() {
        return docType;
    }

    public Parameter getDocNumber() {
        return docNumber;
    }

    public Parameter getDocExpireTime() {
        return docExpireTime;
    }

    public Parameter getDocIssueOrganization() {
        return docIssueOrganization;
    }

    public Parameter getEntryYear() {
        return entryYear;
    }

    public Parameter getEduLevel() {
        return eduLevel;
    }

    public Parameter getPaymentType() {
        return paymentType;
    }

    public Parameter getFaculty() {
        return faculty;
    }

    public Parameter getSpecialty() {
        return specialty;
    }

    public Parameter getFatherName() {
        return fatherName;
    }

    public Parameter getFatherWorkplace() {
        return fatherWorkplace;
    }

    public Parameter getFatherHomePhone() {
        return fatherHomePhone;
    }

    public Parameter getFatherAddress() {
        return fatherAddress;
    }

    public Parameter getMotherName() {
        return motherName;
    }

    public Parameter getMotherWorkplace() {
        return motherWorkplace;
    }

    public Parameter getFatherMobilePhone() {
        return fatherMobilePhone;
    }

    public Parameter getMotherMobilePhone() {
        return motherMobilePhone;
    }

    public Parameter getMotherHomePhone() {
        return motherHomePhone;
    }

    public Parameter getFatherEmail() {
        return fatherEmail;
    }

    public Parameter getMotherEmail() {
        return motherEmail;
    }

    public Parameter getMotherAddress() {
        return motherAddress;
    }

    public Parameter getEduPlaceName() {
        return eduPlaceName;
    }

    public Parameter getDuringTime1() {
        return duringTime1;
    }
    
    public Parameter getDuringTime2() {
        return duringTime2;
    }

    public Parameter getEduAddress() {
        return eduAddress;
    }

    public void setStudentId(Parameter studentId) {
        this.studentId = studentId;
    }

    public void setFirstName(Parameter firstName) {
        this.firstName = firstName;
    }

    public void setLastName(Parameter lastName) {
        this.lastName = lastName;
    }

    public void setGender(Parameter gender) {
        this.gender = gender;
    }

    public void setBirthdayDate(Parameter birthday) {
        this.birthdayDate = birthday;
    }

    public void setTelephone1(Parameter telephone1) {
        this.telephone1 = telephone1;
    }

    public void setTelephone2(Parameter telephone2) {
        this.telephone2 = telephone2;
    }

    public void setEmail1(Parameter email1) {
        this.email1 = email1;
    }

    public void setEmail2(Parameter email2) {
        this.email2 = email2;
    }

    public void setAddress(Parameter address) {
        this.address = address;
    }

    public void setNationality(Parameter nationality) {
        this.nationality = nationality;
    }

    public void setDocType(Parameter docType) {
        this.docType = docType;
    }

    public void setDocNumber(Parameter docNumber) {
        this.docNumber = docNumber;
    }

    public void setDocExpireTime(Parameter docExpireTime) {
        this.docExpireTime = docExpireTime;
    }

    public void setDocIssueOrganization(Parameter docIssueOrganization) {
        this.docIssueOrganization = docIssueOrganization;
    }

    public void setEntryYear(Parameter entryYear) {
        this.entryYear = entryYear;
    }

    public void setEduLevel(Parameter eduLevel) {
        this.eduLevel = eduLevel;
    }

    public void setPaymentType(Parameter paymentType) {
        this.paymentType = paymentType;
    }

    public void setFaculty(Parameter faculty) {
        this.faculty = faculty;
    }

    public void setSpecialty(Parameter specialty) {
        this.specialty = specialty;
    }

    public void setFatherName(Parameter fatherName) {
        this.fatherName = fatherName;
    }

    public void setFatherWorkplace(Parameter fatherWorkplace) {
        this.fatherWorkplace = fatherWorkplace;
    }

    public void setFatherHomePhone(Parameter fatherHomePhone) {
        this.fatherHomePhone = fatherHomePhone;
    }

    public void setFatherAddress(Parameter fatherAddress) {
        this.fatherAddress = fatherAddress;
    }

    public void setMotherName(Parameter motherName) {
        this.motherName = motherName;
    }

    public void setMotherWorkplace(Parameter motherWorkplace) {
        this.motherWorkplace = motherWorkplace;
    }

    public void setFatherMobilePhone(Parameter fatherMobilePhone) {
        this.fatherMobilePhone = fatherMobilePhone;
    }

    public void setMotherMobilePhone(Parameter motherMobilePhone) {
        this.motherMobilePhone = motherMobilePhone;
    }

    public void setMotherHomePhone(Parameter motherHomePhone) {
        this.motherHomePhone = motherHomePhone;
    }

    public void setFatherEmail(Parameter fatherEmail) {
        this.fatherEmail = fatherEmail;
    }

    public void setMotherEmail(Parameter motherEmail) {
        this.motherEmail = motherEmail;
    }

    public void setMotherAddress(Parameter motherAddress) {
        this.motherAddress = motherAddress;
    }

    public void setEduPlaceName(Parameter eduPlaceName) {
        this.eduPlaceName = eduPlaceName;
    }

    public void setDuringTime1(Parameter duringTime) {
        this.duringTime1 = duringTime;
    }
    
    public void setDuringTime2(Parameter duringTime) {
        this.duringTime2 = duringTime;
    }

    public void setEduAddress(Parameter eduAddress) {
        this.eduAddress = eduAddress;
    }
    
    
    
    EditPageHandler() { }
    
    EditPageHandler(ServletRequest request) {
        
        studentId.name      = (String) request.getParameter("student_id");
        if (request.getParameter("student_id") == null) {
            System.out.println("student_id == null");
        }
        studentId.name = (String) request.getParameter("student_id");

        firstName.name      = (String) request.getParameter("first_name");
        lastName.name       = (String) request.getParameter("last_name");
        gender.name         = (String) request.getParameter("gender");
        birthdayDate.name       = (String) request.getParameter("birthday");
        telephone1.name     = (String) request.getParameter("telephone1");
        telephone2.name     = (String) request.getParameter("telephone2");
        email1.name         = (String) request.getParameter("email1");
        email2.name         = (String) request.getParameter("email2");
        address.name        = (String) request.getParameter("address");
        nationality.name    = (String) request.getParameter("nationality");
        docType.name        = (String) request.getParameter("doc_type");
        docNumber.name      = (String) request.getParameter("doc_number");
        docExpireTime.name  = (String) request.getParameter("doc_expire_time");
        docIssueOrganization.name = (String) request.getParameter("doc_issue_organization");
        entryYear.name      = (String) request.getParameter("entry_year");
        eduLevel.name       = (String) request.getParameter("edu_level");
        paymentType.name    = (String) request.getParameter("payment_type");
        faculty.name        = (String) request.getParameter("faculty");
        specialty.name      = (String) request.getParameter("specialty");
        fatherName.name     = (String) request.getParameter("father_name");
        fatherWorkplace.name = (String) request.getParameter("father_workplace");
        fatherHomePhone.name = (String) request.getParameter("father_home_phone");
        fatherAddress.name  = (String) request.getParameter("father_address");
        motherName.name     = (String) request.getParameter("mother_name");
        motherWorkplace.name = (String) request.getParameter("mother_workplace");
        fatherMobilePhone.name = (String) request.getParameter("father_mobile_phone");
        motherMobilePhone.name = (String) request.getParameter("mother_mobile_phone");
        motherHomePhone.name = (String) request.getParameter("mother_home_phone");
        fatherEmail.name    = (String) request.getParameter("father_email");
        motherEmail.name    = (String) request.getParameter("mother_email");
        motherAddress.name  = (String) request.getParameter("mother_address");
        eduPlaceName.name   = (String) request.getParameter("edu_place_name");
        duringTime.name     = (String) request.getParameter("during_time");
        eduAddress.name     = (String) request.getParameter("edu_address");
    }
}
