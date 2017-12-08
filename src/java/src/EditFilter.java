/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.regex.Pattern;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author Serikov S.
 */
public class EditFilter implements Filter {

    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public EditFilter() {
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("EditFilter:DoBeforeProcessing");
        }

        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log items on the request object,
        // such as the parameters.
        /*
	for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    String values[] = request.getParameterValues(name);
	    int n = values.length;
	    StringBuffer buf = new StringBuffer();
	    buf.append(name);
	    buf.append("=");
	    for(int i=0; i < n; i++) {
	        buf.append(values[i]);
	        if (i < n-1)
	            buf.append(",");
	    }
	    log(buf.toString());
	}
         */
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("EditFilter:DoAfterProcessing");
        }

        // Write code here to process the request and/or response after
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log the attributes on the
        // request object after the request has been processed. 
        /*
	for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    Object value = request.getAttribute(name);
	    log("attribute: " + name + "=" + value.toString());

	}
         */
        // For example, a filter might append something to the response.
        /*
	PrintWriter respOut = new PrintWriter(response.getWriter());
	respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
         */
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        if (debug) {
            log("EditFilter:doFilter()");
        }

        doBeforeProcessing(request, response);

        //start validating
        System.out.println("EditFilter");
         if (request.getParameter("first_name") == null) {
            System.out.println("first_name is null");
         } else {
             System.out.println("first_name is not null");
         }
        boolean ok = true;
        RequestDispatcher rd;
        
        if (request.getParameter("is_submit") != null) {
//            System.out.println("form from edit.jsp is submitted");
//            
            if (request.getParameter("first_name") == null)
                System.out.println("first_name is null");
            
            if (request.getParameter("birthday_date") == null) {
                System.out.println("request.birthday_date is null");
            } else {
                System.out.println("request.birthday_date is not null : " + request.getParameter("birthday_date"));
            }
            

            EditPageHandler handler = new EditPageHandler();
            handler.setStudentId(new Parameter(request.getParameter("student_id"), request.getParameter("student_id") == null));
            handler.setFirstName(new Parameter(request.getParameter("first_name"), request.getParameter("first_name") == null));
            handler.setLastName(new Parameter(request.getParameter("last_name"), request.getParameter("last_name") == null));
            handler.setGender(new Parameter(request.getParameter("gender"), request.getParameter("gender") == null));
            handler.setBirthdayDate(new Parameter(request.getParameter("birthday_date"), request.getParameter("birthday_date") == null));
            if (handler.birthdayDate.isNull) {
                System.out.println("handler.birthdayDate is null");
            } else {
                System.out.println("handler.birthdayDate is not null : " + handler.birthdayDate.name);
            }
            
            handler.setTelephone1(new Parameter(request.getParameter("telephone1"), request.getParameter("telephone1") == null));
            handler.setTelephone2(new Parameter(request.getParameter("telephone2"), request.getParameter("telephone2") == null));
            handler.setEmail1(new Parameter(request.getParameter("email1"), request.getParameter("email1") == null));
            handler.setEmail2(new Parameter(request.getParameter("email2"), request.getParameter("email2") == null));
            handler.setAddress(new Parameter(request.getParameter("address"), request.getParameter("address") == null));
            handler.setNationality(new Parameter(request.getParameter("nationality"), request.getParameter("nationality") == null));
            
            handler.setDocType(new Parameter(request.getParameter("doc_type"), request.getParameter("doc_type") == null));
            handler.setDocNumber(new Parameter(request.getParameter("doc_number"), request.getParameter("doc_number") == null));
            
            handler.setDocExpireTime(new Parameter(request.getParameter("doc_expire_time"), 
                    request.getParameter("doc_expire_time") == null));
            if (request.getParameter("doc_expire_time") == null) {
                System.out.println("doc_expire_time is null");
            } else {
                System.out.println("doc_expire_time is not null");
            }
            
            handler.setDocIssueOrganization(new Parameter(request.getParameter("doc_issue_organization"), request.getParameter("doc_issue_organization") == null));
            handler.setEntryYear(new Parameter(request.getParameter("entry_year"), 
                    request.getParameter("entry_year") == null));
            handler.setEduLevel(new Parameter(request.getParameter("edu_level"), request.getParameter("edu_level") == null));
            handler.setPaymentType(new Parameter(request.getParameter("payment_type"), request.getParameter("payment_type") == null));
            handler.setFaculty(new Parameter(request.getParameter("faculty"), 
                    request.getParameter("faculty") == null));
            handler.setSpecialty(new Parameter(request.getParameter("specialty"), 
                    request.getParameter("specialty") == null));
            
            handler.setFatherName(new Parameter(request.getParameter("father_name"), request.getParameter("father_name") == null));
            handler.setFatherWorkplace(new Parameter(request.getParameter("father_workplace"), request.getParameter("father_workplace") == null));
            handler.setFatherHomePhone(new Parameter(request.getParameter("father_home_phone"), request.getParameter("father_home_phone") == null));
            handler.setFatherAddress(new Parameter(request.getParameter("father_address"), request.getParameter("father_address") == null));
            handler.setMotherName(new Parameter(request.getParameter("mother_name"), request.getParameter("mother_name") == null));
            handler.setMotherWorkplace(new Parameter(request.getParameter("mother_workplace"), request.getParameter("mother_workplace") == null));
            handler.setFatherMobilePhone(new Parameter(request.getParameter("father_mobile_phone"), request.getParameter("father_mobile_phone") == null));
            handler.setMotherMobilePhone(new Parameter(request.getParameter("mother_mobile_phone"), request.getParameter("mother_mobile_phone") == null));
            handler.setMotherHomePhone(new Parameter(request.getParameter("mother_home_phone"), request.getParameter("mother_home_phone") == null));
            handler.setFatherEmail(new Parameter(request.getParameter("father_email"), request.getParameter("father_email") == null));
            handler.setMotherEmail(new Parameter(request.getParameter("mother_email"), request.getParameter("mother_email") == null));
            handler.setMotherAddress(new Parameter(request.getParameter("mother_address"), request.getParameter("mother_address") == null));
            handler.setEduPlaceName(new Parameter(request.getParameter("edu_place_name"), request.getParameter("edu_place_name") == null));
            handler.setDuringTime1(new Parameter(request.getParameter("during_time1"), request.getParameter("during_time1") == null));
            handler.setDuringTime2(new Parameter(request.getParameter("during_time2"), request.getParameter("during_time2") == null));
            handler.setEduAddress(new Parameter(request.getParameter("edu_address"), request.getParameter("edu_address") == null));

            String regexStr = "^[0-9]*$";
            Pattern ptr = Pattern.compile("(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*:(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)(?:,\\s*(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*))*)?;\\s*)");

            String studentId = handler.studentId.isNull ? null : handler.studentId.name;
            String firstName = handler.firstName.isNull ? null : handler.firstName.name;
            String lastName  = handler.lastName.isNull ? null : handler.lastName.name;
            
            System.out.println("firstName and lastName: " + firstName + lastName);
            
            String gender = handler.lastName.isNull ? null : handler.gender.name;
            if (gender != null) {
                if (!(gender.equals("male") || gender.equals("female"))) {
                    ok = false;
                    
                    handler.gender.isOk = false;
                }
            }
            
            String birthday = handler.birthdayDate.isNull ? null : handler.birthdayDate.name;
            if (handler.birthdayDate.isNull) {
                System.out.println("handler.birthdayDate is null");
            } else {
                System.out.println("hadnler.birthdayDate is not null: " + handler.birthdayDate.name);
            }
            
            if (birthday != null) {
                String[] birthdayArray = birthday.split(Pattern.quote("."));
                if (birthdayArray != null) {
                    if (birthdayArray.length != 3) {
                        System.out.println("birthday is not ok");
                        ok = false;
                        handler.birthdayDate.isOk = false;
                    } else {
                        System.out.println("birthday is ok");
                    }
                }
            } else {
                    System.out.println("birthday is null");
                }
            
                String telephone1 = handler.telephone1.isNull ? null : handler.telephone1.name;
                String telephone2 = handler.telephone2.isNull ? null : handler.telephone2.name;
                
                if (telephone1 != null) {
                    if (!telephone1.matches(regexStr)) {
                        ok = false;
                        handler.telephone1.isOk = false;
                    }
                }
                
                if (telephone2 != null) {
                    if (!telephone2.matches(regexStr)) {
                        ok = false;
                        handler.telephone2.isOk = false;
                    }
                }
            
            String email1 = handler.email1.name;
            String email2 = handler.email2.name;
            if (email1 != null) {
                if (ptr.matcher(email1).matches()) {
                    ok = false;
                    handler.email1.isOk = false;
                }
            }
            
            if (email2 != null) {
                if (ptr.matcher(email2).matches()) {
                    ok = false;
                    handler.email2.isOk = false;
                }
            }
            
            String address = handler.address.name;
            String nationality = handler.nationality.name;

            String docType = handler.docType.name;
            String docNumber = handler.docNumber.name;
            
            String docExpireTime = handler.docExpireTime.name;
            if (request.getParameter("doc_expire_time") != null) {
                System.out.println("request.doc_expire_time is not null: " + request.getParameter("doc_expire_time"));
            } else if (handler.getDocExpireTime().name != null) {
                System.out.println("handler.getDocExpireTime() is not null: " + request.getParameter("doc_expire_time"));
            }
            
            
            if (docExpireTime != null) {
                System.out.println("docExpireTime is not null: " + docExpireTime);
                String[] docExpireTimeArray = docExpireTime.split(".");
                if (docExpireTimeArray.length != 3) {
                    
//                    ok = false;
//                    handler.docExpireTime.isOk = false;
                }
            }
            
            String docIssueOrganization = handler.docIssueOrganization.name;

            String entryYear = handler.entryYear.name;
            if (entryYear != null) {
                String[] entryYearArray = entryYear.split(".");
                if (entryYearArray.length != 3) {
//                    ok = false;
//                    handler.entryYear.isOk = false;
                }
            }
            String eduLevel = handler.eduLevel.name;
            String paymentType = handler.paymentType.name;
            String faculty = handler.faculty.name;
            String specialty = handler.specialty.name;

            String fatherName = handler.fatherName.name;
            String fatherWorkplace = handler.fatherWorkplace.name;
            String fatherHomePhone = handler.fatherHomePhone.name;
            String fatherAddress = handler.fatherAddress.name;
            String motherName = handler.motherName.name;
            String motherWorkplace = handler.motherWorkplace.name;
            
            String fatherMobilePhone = handler.fatherMobilePhone.name;
            String motherMobilePhone = handler.motherMobilePhone.name;
            if (fatherMobilePhone != null) {
                if (!fatherMobilePhone.matches(regexStr)) {
                    ok = false;
                    handler.fatherMobilePhone.isOk = false;
                }
            }
            
            if (motherMobilePhone != null) {
                if (!motherMobilePhone.matches(regexStr)) {
                    ok = false;
                    handler.motherMobilePhone.isOk = false;
                }
            }
            
            String motherHomePhone = handler.motherHomePhone.name;
            
            String fatherEmail = handler.fatherEmail.name;
            String motherEmail = handler.motherEmail.name;
            if (fatherEmail != null) {
                if (!ptr.matcher(fatherEmail).matches()) {
//                    ok = false;
//                    handler.fatherEmail.isOk = false;
                }
            }
            
            if (motherEmail != null) {
                if (!ptr.matcher(motherEmail).matches()) {
//                    ok = false;
//                    handler.motherEmail.isOk = false;
                }
            }
            
            String motherAddress = handler.motherAddress.name;
            String eduPlaceName = handler.eduPlaceName.name;
            String duringTime1 = handler.duringTime1.name;
            String duringTime2 = handler.duringTime2.name;
            String eduAddress = handler.eduAddress.name;

            if (!ok) {
                System.out.println("Errors in fields, redirecting to edit page");
                request.setAttribute("handler", handler);
                rd = request.getRequestDispatcher("edit.jsp");
                rd.forward(request, response);
                return;
            } else {
                System.out.println("Everything is ok");
            }
        }

        

        Throwable problem = null;
        try {
            chain.doFilter(request, response);
        } catch (Throwable t) {
            // If an exception is thrown somewhere down the filter chain,
            // we still want to execute our after processing, and then
            // rethrow the problem after that.
            problem = t;
            t.printStackTrace();
        }

        doAfterProcessing(request, response);

        // If there was a problem, we want to rethrow it if it is
        // a known type, otherwise log it.
        if (problem != null) {
            if (problem instanceof ServletException) {
                throw (ServletException) problem;
            }
            if (problem instanceof IOException) {
                throw (IOException) problem;
            }
            sendProcessingError(problem, response);
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("EditFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("EditFilter()");
        }
        StringBuffer sb = new StringBuffer("EditFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
