<%@page import="entity.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List" %>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   </head>
   <body>
      <h1>Xuất Excel</h1>
      <table cellpadding="1"  cellspacing="1" border="1" bordercolor="gray">
         <tr>
             <td style="text-align:center">ID</td>
             <td style="text-align:center">Name</td>
             <td style="text-align:center">Email</td>
             <td style="text-align:center">Address</td>
             <td style="text-align:center">Phone</td>
             <td style="text-align:center">Number Water</td>
             <td style="text-align:center">Total Money</td>
         </tr>
         <%
            List<Users> employees  = (List<Users>)request.getAttribute("lstUser");
                  if (employees != null) {
                      response.setContentType("application/vnd.ms-excel");
                      response.setHeader("Content-Disposition", "inline; filename="+ "Danhsach.xls");
                  }
            for(Users e: employees){
            %>
         <tr>
             <td><%=e.getId()%></td>
             <td><%=e.getName()%></td>
             <td><%=e.getEmail()%></td>
             <td><%=e.getAddress()%></td>
             <td><%=e.getPhone()%></td>
             <td><%=e.getNumberWater()%></td>
             <td><%=e.getTotalMoney()%></td>
         </tr>
         <% 
            }
            %>
      </table>
   </body>
</html>