<%@page import="database.Student"%>
<%@page import="database.Database"%>
<%@ taglib prefix = "ex" uri = "WEB-INF/custom.tld"%>



<!DOCTYPE html>
<html>
    <head>
        <title>Student Management System</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css">
        <style>
            table,th,td {
                border : 1px solid black;
                border-collapse: collapse;
            }
            th,td {
                padding: 5px;
            }

            .fold {
                display: none;
            }

            #view01:target {
                display: block
            }

            #view02:target {
                display: block
            }

            #view03:target {
                display: block
            }

            #view04:target {
                display: block
            }


        </style>
    </head>
    <body>
        <%  Student student;
            Database db = new Database();
            Integer id = null;
            if (request.getAttribute("studentId") != null) {
                id = (Integer) request.getAttribute("studentId");
            } else if(request.getParameter("id") != null) {
                id = Integer.parseInt(request.getParameter("studentId"));
            }
            
            System.out.println("request:studentId " + id);
            
            student = db.getStudent(id);
            if (student == null) {
                System.out.println("student == null");
            }
        %>
        <header>
            <ul>
                <li><a href='MainServlet?page=home&id=<% out.print(id);%>'>Home</a></li>
                <li><a href='MainServlet?page=edit&id=<% out.print(id);%>'>Edit page</a></li>
                <li id='title'>Student Management System</li>
                <li><a href="index.html">Exit</a></li>
            </ul>
        </header>

        <main>
            <h2>Basic Info</h2>
            <a href='#view01'>Fold/Unfold</a>
            <div class='fold' id='view01'>
                <p>Student ID   <% out.print(student.id); %></p>
                <p>First Name   <% out.print(student.basicInfo.firstName); %></p>
                <p>Last Name    <% out.print(student.basicInfo.lastName); %></p>
                <p>Gender       <% out.print(student.basicInfo.gender); %></p>
                <p>Birthday Date <% out.print(student.basicInfo.birthday); %></p>
                <p>Telephone 1  <% out.print(student.basicInfo.telephone1); %></p>
                <p>Telephone 2  <% out.print(student.basicInfo.telephone2); %></p>
                <p>Email 1      <% out.print(student.basicInfo.email1); %></p>
                <p>Email 2      <% out.print(student.basicInfo.email2); %></p>
                <p>Address      <% out.print(student.basicInfo.address); %></p>
                <p>Nationality  <% out.print(student.basicInfo.nationality); %></p>
                <p>Document Type <% out.print(student.document.documentType); %></p>
                <p>Document Number <% out.print(student.document.documentNumber); %></p>
                <p>Document Expire Time <% out.print(student.document.documentExpire); %></p>
                <p>Document Issue Organization <% out.print(student.document.documentIssueOrganization); %></p>
            </div>

            <h2>Current Education Info</h2>
            <a href='#view02'>Fold/Unfold</a>
            <div class='fold' id='view02'>
                <p>Entry Year <% out.print(student.currentEducationInfo.entryYear); %></p>
                <p>Education Level <% out.print(student.currentEducationInfo.educationLevel); %></p>
                <p>Payment Type <% out.print(student.currentEducationInfo.paymentType); %></p>
                <p>Faculty  <% out.print(student.currentEducationInfo.faculty); %></p>
                <p>Specialty  <% out.print(student.currentEducationInfo.specialty); %> </p>
            </div>

            <h2>Parent Info</h2>
            <a href='#view03'>Fold/Unfold</a>
            <div class='fold' id='view03'>Father Name <% out.print(student.father.name); %><br>
                <p>Father Working Place <% out.print(student.father.workingPlace); %></p>
                <p>Father Mobile Phone <% out.print(student.father.mobilePhone); %></p>
                <p>Father Home Phone <% out.print(student.father.homePhone); %></p>
                <p>Father Email <% out.print(student.father.email); %></p>
                <p>Father Address <% out.print(student.father.address); %></p>
                <p>Mother Name <% out.print(student.mother.name); %></p>
                <p>Mother Working Place <% out.print(student.mother.workingPlace); %></p>
                <p>Mother Mobile Phone <% out.print(student.mother.mobilePhone); %></p>
                <p>Mother Home Phone <% out.print(student.mother.homePhone); %></p>
                <p>Mother Email <% out.print(student.mother.email); %></p>
                <p>Mother Address <% out.print(student.mother.address); %></p>
            </div>

            <h2>Education History</h2> 
            <a href='#view04'>Fold/Unfold</a>
            <div class='fold' id='view04'>
                <p>Education Place Name <% //out.print(student.educationHistory.educationHistoryArray.get(0)); %></p>
                <p>During Time <% //out.print(student.educationHistory.educationHistoryArray.get(0)); %>.</p>
                <p>Address <% //out.print(student.educationHistory.educationHistoryArray.get(0)); %></p>
            </div>
            <br>

        </main>
        <footer>
            <p>Almaty 2017</p>    
        </footer>
    </body> 
</html>
