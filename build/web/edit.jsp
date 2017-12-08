<%@ taglib prefix = "ex" uri = "WEB-INF/custom.tld"%>
<%@ page import="src.EditPageHandler" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Edit page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> 
        <style>
            label{
                width: 15%;
                display: inline-block;
            }
            b {
                color: red;
            }
        </style>
        <script>
            function addRow() {
                var div = document.createElement('div');

                div.className = 'row';

                div.innerHTML = "<input type=\"button\" value=\"-\" onclick=\"removeRow(this)\"><br>\n\
                    <p>Education Place Name <input type=\"text\" name='edu_place_name'></p>\
                    <p>During Time <input type=\"text\" name='during_time'>   </p>\
                    <p>Address <input type=\"text\" name='address'>       </p><br>";

                document.getElementById('content').appendChild(div);

                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        document.getElementById("content").innerHTML = this.responseText;
                    }
                };
                xhttp.open("GET", "MainServlet", true);
                xhttp.send();
            }

            function removeRow(input) {
                document.getElementById('content').removeChild(input.parentNode);
            }
            
            
            $(document).on('change', '#sel_fac_tag', function () {
                //alert("facultyClicked()");
                var id = $(this).val();
                //alert("id: " + id);
                $("#spec_tag").load("specialty.jsp", {specid : id});
                
            });
        </script>
        <script>
            //ajax
            $(document).ready(function () {
                
                var id = 0;
                //alert("id: " + id);
                $("#spec_tag").load("specialty.jsp", {specid : id});
                
                //alert("ajax ready");
                $.ajax({
                    url: 'MainServlet',
                    type: 'post',
                    data: {fac: 0},
                    dataType: 'json',
                    success: function (response) {
                        //alert("ajax success");
                        var len = response.length;
                        //window.alert(len);
                        $("#sel_faculty").empty();
                        for (var i = 0; i < len; i++) {
                            var id = response[i]['id'];
                            var name = response[i]['name'];

                            $("#sel_faculty").append("<option value='" + id + "'>" + name + "</option>");
                        }
                    }
                });
                $.ajax({
                    url: 'MainServlet',
                    type: 'post',
                    data: {sec: 1},
                    dataType: 'json',
                    success: function (response) {
                        //alert("ajax success");
                        var len = response.length;
                        //window.alert(len);
                        $("#sel_spec").empty();
                        for (var i = 0; i < len; i++) {
                            var id = response[i]['id'];
                            var name = response[i]['name'];

                            $("#sel_spec").append("<option value='" + id + "'>" + name + "</option>");
                        }
                    }
                });
            });

            $(document).on('change', '#sel_faculty', function () {
                alert("select changed");
                var id = $(this).val();
                alert("id: " + id);
                $.ajax({
                    url: 'MainServlet',
                    type: 'post',
                    data: {sec: id},
                    dataType: 'json',
                    success: function (response) {
                        //alert("ajax success");
                        var len = response.length;
                        //window.alert(len);
                        $("#sel_spec").empty();
                        for (var i = 0; i < len; i++) {
                            var id = response[i]['id'];
                            var name = response[i]['name'];

                            $("#sel_spec").append("<option value='" + id + "'>" + name + "</option>");
                        }
                    }
                });
            });
        </script>
        <% 
            EditPageHandler handler = (EditPageHandler) request.getAttribute("handler");
            if (handler != null){    
//                out.print("<script>window.alert(\"Incorrect Input \");</script>");
//                out.println("<script>window.alert(\""+  handler.getFirstName() 
//                        + " " + handler.firstName + " " + handler.firstName.name
//                        + "" + handler.getFirstName().name + "\");</script>");
            } else {
            //    out.print("<script>window.alert(\"Handler is null\");</script>");
            }
        %>
    </head>
    <body>
        <header>
            <ul>
                <li><a href='MainServlet?page=home'>Home</a></li>
                <li><a href='MainServlet?page=edit'>Edit page</a></li>
                <li id='title'>Student Management System</li>
            </ul>
        </header>
        <main>
            
            
            <form action="MainServlet" form="post">
                <input type="hidden" name="is_submit" value="true">
                <fieldset>
                    <legend>Basic Info</legend>
                    
                    
                    <p><label for='first_name' >First Name:</label>
                        <input type="text" name='first_name' required="true" <% if (handler != null) { out.print("value='" + handler.getFirstName().name + "'"); } %>>*</p>   
                    <p><label for='last_name'>Last Name:</label>  
                        <input type="text" name='last_name' required="true"<% if (handler != null) { out.print("value='" + handler.getLastName().name + "'"); } %>>*</p>    
                    <p><label for='gender'>Gender:</label>        
                    <select name="gender">
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                    </select>
                    <p><label for='birthday_date'>Birthday Date:</label>
                        <input type="text" name='birthday_date' placeholder="dd.mm.yyyy" <% if (handler != null) { out.print("value='" + handler.getBirthdayDate().name + "'"); }%>>*  <% if (handler != null && !handler.getBirthdayDate().isOk) { out.print("<b>wrong</b>"); }%></p>
                    <p><label for='tel1'>Telephone 1:</label>    
                        <input type="text" name='telephone1' <% 
                            if (handler != null) { out.print("value='" + handler.getTelephone1().name + "'"); }%>>  
                        <% if (handler != null && !handler.getTelephone1().isOk) { out.print("<b>wrong</b>"); }%></p>         
                    <p><label for='tel2'>Telephone 2:</label>     
                        <input type="text" name='telephone2' <% if (handler != null) { 
                            out.print("value='" + handler.getTelephone2().name + "'"); }%>>
                      <% if (handler != null && !handler.getTelephone2().isOk) { out.print("<b>wrong</b>"); }%></p>         
                    <p><label for='email'>Email 1:</label>
                        <input type="text" name='email1' <% if (handler != null) { 
                            out.print("value='" + handler.getEmail1().name + "'"); }%>>
                      <% if (handler != null && !handler.getEmail1().isOk) { out.print("<b>wrong</b>"); }%></p>       
                    <p><label for='email2'>Email 2</label>         
                        <input type="text" name='email2' <% 
                            if (handler != null) { out.print("value='" + handler.getEmail2().name + "'"); }%>>
                      <% if (handler != null && !handler.getEmail2().isOk) { out.print("<b>wrong</b>"); }%></p>       
                    <p><label for='address'>Address</label>         
                        <input type="text" name='address' <% 
                            if (handler != null) { out.print("value='" + handler.getAddress().name + "'"); }%>>
                      <% if (handler != null && !handler.getAddress().isOk) { out.print("<b>wrong</b>"); }%></p>     
                    <p><label for='nationality'>Nationality</label>    
                        <input type="text" name='nationality' <% 
                            if (handler != null) { out.print("value='" + handler.getNationality().name + "'"); }%>>
                      <% if (handler != null && !handler.getNationality().isOk) { out.print("<b>wrong</b>"); }%></p>  
                </fieldset>
            
                <fieldset>
                    <legend>Document</legend>
                    <input type="hidden" name="form_name" value="document">
                    <p><label for='doc_type'>Document Type</label>   
                        <input type="text" name='doc_type' <% 
                            if (handler != null) { out.print("value='" + handler.getDocType().name + "'"); }%>>  
                      <% if (handler != null && !handler.getDocType().isOk) { out.print("<b>wrong</b>"); }%></p>     
                    <p><label for='doc_number'>Document Number</label> 
                        <input type="text" name='doc_number' <% 
                            if (handler != null) { out.print("value='" + handler.getDocNumber().name + "'"); }%>>
                      <% if (handler != null && !handler.getDocNumber().isOk) { out.print("<b>wrong</b>"); }%></p>   
                    
                    <p><label for='doc_expire_time'>Document Expire Time</label>        
                        <input type="text" name='doc_expire_time' <% 
                            if (handler != null) { out.print("value='" + handler.getDocExpireTime().name + "'"); }%>>
                      <% if (handler != null && !handler.getDocExpireTime().isOk) { out.print("<b>wrong</b>"); }%></p> 
                    
                    <p><label for='doc_issue_organization'>Document Issue Organization</label> 
                        <input type="text" name='doc_issue_organization' <%
                            if (handler != null) { out.print("value='" + handler.getDocIssueOrganization().name + "'"); }%>>
                      <% if (handler != null && !handler.getDocIssueOrganization().isOk) { out.print("<b>wrong</b>"); }%></p>
                </fieldset>
            

            <!--<form action="MainServlet" form="post">
                <fieldset>
                    <legend>Current Education Info</legend>
                    <p><label for='entry_year'>Entry Year</label>      <input type="text" name='entry_year'>   </p>
                    <p><label for='edu_level'>Education Level</label> <input type="text" name='edu_level'>    </p>
                    <p><label for='payment_type'>Payment Type</label>    <input type="text" name='payment_type'> </p>

                    <div class="container">
                        <div id="div_content">
                            <p>Faculties 
                                <select id="sel_faculty">
                                    <option value="0">- Select -</option>
                                    <option value="1">Faculty 1</option>
                                    <option value="2">Faculty 2</option>
                                    <option value="3">Faculty 3</option>
                                    <option value="4">Faculty 4</option>
                                    <option value="5">Faculty 5</option>
                                    <option value="6">Faculty 6</option>
                                </select>
                            </p>
                            <div class="clear"></div>
                            <p>Specialties 
                                <select id="sel_spec">
                                    <option value="0">- Select -</option>
                                </select>
                            </p>
                        </div>
                    </div>
                    <input type='submit' value='Submit'>
                </fieldset>-->
                
                <fieldset>
                    <legend>Current Education Info</legend>
                    <input type="hidden" name="form_name" value="current_education_info">
                    <p><label for='student_id'>Student ID:</label>
                        <input type="text" name='student_id' required="true" <% 
                            if (handler != null) { out.print("value='" + handler.getStudentId().name + "'"); }%>>* 
                      <% if (handler != null && !handler.getStudentId().isOk) { out.print("<b>wrong</b>"); }%></p> 
                    <p><label for='entry_year'>Entry Year</label>      
                        <input type="text" name='entry_year' <% 
                            if (handler != null) { out.print("value='" + handler.getEntryYear().name + "'"); }%>>   
                      <% if (handler != null && !handler.getEntryYear().isOk) { out.print("<b>wrong</b>"); }%></p>
                    <p><label for='edu_level'>Education Level</label> 
                        <input type="text" name='edu_level' <% 
                            if (handler != null) { out.print("value='" + handler.getEduLevel().name + "'"); }%>>    
                      <% if (handler != null && !handler.getEduLevel().isOk) { out.print("<b>wrong</b>"); }%></p>
                    <p><label for='payment_type'>Payment Type</label>    
                        <input type="text" name='payment_type' <% 
                            if (handler != null) { out.print("value='" + handler.getPaymentType().name + "'"); }%>> 
                      <% if (handler != null && !handler.getPaymentType().isOk) { out.print("<b>wrong</b>"); }%></p>

                    <div class="container">
                        <div id="div_content">
                            <p>Faculties 
                            <ex:Faculty />
                            </p>
                            <div class="clear"></div>
                            <% %>
                            <p>Specialties 
                            <div id="spec_tag"></div>
                            <%--<jsp:include page="specialty.html" />.--%>
                            </p>
                        </div>
                    </div>
                </fieldset>

                    <fieldset>
                        <legend>Parent Info</legend>
                        <input type="hidden" name="form_name" value="parent_info">
                        <p><label for='father_name'>Father Name</label>    
                            <input type="text" name='father_name' <% 
                                if (handler != null) { out.print("value='" + handler.getFatherName().name + "'"); }%>>        
                          <% if (handler != null && !handler.getFatherName().isOk) { out.print("<b>wrong</b>"); }%></p>
                        <p><label for='father_workplace'>Father Working Place</label>    
                            <input type="text" name='father_workplace' <% 
                                if (handler != null) { out.print("value='" + handler.getFatherWorkplace().name + "'"); }%>>  
                          <% if (handler != null && !handler.getFatherWorkplace().isOk) { out.print("<b>wrong</b>"); }%></p>
                        <p><label for='father_mobile_phone'>Father Mobile Phone</label>     
                            <input type="text" name='father_mobile_phone' <% 
                                if (handler != null) { out.print("value='" + handler.getFatherMobilePhone().name + "'"); }%>>
                          <% if (handler != null && !handler.getFatherMobilePhone().isOk) { out.print("<b>wrong</b>"); }%></p>
                        <p><label for='father_home_phone'>Father Home Phone</label>       
                            <input type="text" name='father_home_phone' <% 
                                if (handler != null) { out.print("value='" + handler.getFatherHomePhone().name + "'"); }%>>  
                          <% if (handler != null && !handler.getFatherHomePhone().isOk) { out.print("<b>wrong</b>"); }%></p>
                        <p><label for='father_email'>Father Email</label>            
                            <input type="text" name='father_email' <% 
                                if (handler != null) { out.print("value='" + handler.getFatherEmail().name + "'"); }%>>       
                          <% if (handler != null && !handler.getFatherEmail().isOk) { out.print("<b>wrong</b>"); }%></p>
                        <p><label for='father_address'>Father Address</label>          
                            <input type="text" name='father_address' <% 
                                if (handler != null) { out.print("value='" + handler.getFatherAddress().name + "'"); }%>>     
                          <% if (handler != null && !handler.getFatherAddress().isOk) { out.print("<b>wrong</b>"); }%></p>
                        <p><label for='mother_name'>Mother Name</label>             
                            <input type="text" name='mother_name' <% 
                                if (handler != null) { out.print("value='" + handler.getMotherName().name + "'"); }%>>        
                          <% if (handler != null && !handler.getMotherName().isOk) { out.print("<b>wrong</b>"); }%></p>
                        <p><label for='mother_workplace'>Mother Working Place</label>    
                            <input type="text" name='mother_workplace' <% 
                                if (handler != null) { out.print("value='" + handler.getMotherWorkplace().name + "'"); }%>>   
                          <% if (handler != null && !handler.getMotherWorkplace().isOk) { out.print("<b>wrong</b>"); }%></p>
                        <p><label for='mother_mobile_phone'>Mother Mobile Phone</label>     
                            <input type="text" name='mother_mobile_phone' <% 
                                if (handler != null) { out.print("value='" + handler.getMotherMobilePhone().name + "'"); }%>>
                          <% if (handler != null && !handler.getMotherMobilePhone().isOk) { out.print("<b>wrong</b>"); }%></p>
                        <p><label for='mother_home_phone'>Mother Home Phone</label>       
                            <input type="text" name='mother_home_phone' <% 
                                if (handler != null) { out.print("value='" + handler.getMotherHomePhone().name + "'"); }%>>  
                          <% if (handler != null && !handler.getMotherHomePhone().isOk) { out.print("<b>wrong</b>"); }%></p>
                        <p><label for='mother_email'>Mother Email</label>            
                            <input type="text" name='mother_email' <% 
                                if (handler != null) { out.print("value='" + handler.getMotherEmail().name + "'"); }%>>      
                          <% if (handler != null && !handler.getMotherEmail().isOk) { out.print("<b>wrong</b>"); }%></p>
                        <p><label for='mother_address'>Mother Address</label>          
                            <input type="text" name='mother_address' <% 
                                if (handler != null) { out.print("value='" + handler.getMotherAddress().name + "'"); }%>>     
                          <% if (handler != null && !handler.getMotherAddress().isOk) { out.print("<b>wrong</b>"); }%></p>
                    </fieldset>
                
                    <fieldset>
                        <legend>Education History</legend> 
                        <input type="hidden" name="form_name" value="education_history">
                        <p><label for='edu_place_name'>Education Place Name</label> 
                            <input type="text" name='edu_place_name' <% 
                                if (handler != null) { out.print("value='" + handler.getEduPlaceName().name + "'"); }%>>
                          <% if (handler != null && !handler.getEduPlaceName().isOk) { out.print("<b>wrong</b>"); }%></p>
                        <p><label for='during_time'>During Time</label> </p>        
                        <p><label for="during_time1">From:</label> 
                            <input type="text" name='during_time1' <% 
                                if (handler != null) { out.print("value='" + handler.getDuringTime1().name + "'"); }%>>
                          <% if (handler != null && !handler.getDuringTime1().isOk) { out.print("<b>wrong</b>"); }%></p>
                        <p><label for="during_time2">To:</label> 
                            <input type="text" name='during_time2' <% 
                                if (handler != null) { out.print("value='" + handler.getDuringTime2().name + "'"); }%>>
                          <% if (handler != null && !handler.getDuringTime2().isOk) { out.print("<b>wrong</b>"); }%></p>
                        <p><label for='edu_address'>Address</label>              
                            <input type="text" name='edu_address' <% 
                                if (handler != null) { out.print("value='" + handler.getEduAddress().name + "'"); }%>>       
                          <% if (handler != null && !handler.getEduAddress().isOk) { out.print("<b>wrong</b>"); }%></p><br>
                        <input type="button" value="+" onclick="addRow()">
                        <div id="content"></div>
            
                    </fieldset>
                            <input type='submit' value='Submit'><br>
                </form>
        </main>
        <footer>
            <p>Almaty 2017</p>    
        </footer>
    </body>

</html>
