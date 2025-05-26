<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <style>
    .error{
      color: red;
    }
  </style>
  <body>
  <div>
    <h1>Thêm sinh viên</h1>
    <form:form modelAttribute="student" action="student-save" method="post">
      <label>Tên sinh viên</label>
      <form:input path="name"/> <br>
      <form:errors path="name" cssClass="error"/><br>
      <label>Email</label>
      <form:input path="email"/><br>
      <form:errors path="email" cssClass="error"/><br>
      <label>Ngày sinh</label>
      <form:input path="dob" type="date"/><br>
      <form:errors path="dob" cssClass="error"/><br>
      <input value="Thêm sinh viên" type="submit">
    </form:form>
  </div>
  </body>
</html>
