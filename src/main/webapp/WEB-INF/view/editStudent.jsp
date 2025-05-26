<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 27/05/2025
  Time: 2:28 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <div>
    <h1>Cập nhật sinh viên</h1>
    <form:form modelAttribute="student" action="student-edit" method="post">
      <form:hidden path="id"/>
      <label>Tên sinh viên</label>
      <form:input path="name"/> <br>
      <form:errors path="name" cssClass="error"/><br>
      <label>Email</label>
      <form:input path="email"/><br>
      <form:errors path="email" cssClass="error"/><br>
      <label>Ngày sinh</label>
      <form:input path="dob" type="date"/><br>
      <form:errors path="dob" cssClass="error"/><br>
      <input value="Cập nhật sinh viên" type="submit">
    </form:form>
  </div>
  </body>
</html>
