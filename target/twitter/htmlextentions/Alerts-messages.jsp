<%--
  Created by IntelliJ IDEA.
  User: shariorh
  Date: 3/26/24
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String success =(String) request.getAttribute("success");
    String error = (String) request.getAttribute("error");
    String warning = (String) request.getAttribute("warning");
%>

<% if ( error != null) { %>
<p style="color: red;">
    <%= error %>
</p>
<% } %>
<% if (success != null) { %>
<p style="color: green;">
    <%= success %>
</p>
<% } %>
<% if (warning != null) { %>
<p style="color: yellow;">
    <%= warning %>
</p>
<% } %>