<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 27/05/2025
  Time: 3:28 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Cập nhật sản phẩm</title>
  <style>
    .error {
      color: red;
    }
  </style>
</head>
<body>
<div>
  <h1>Cập nhật sản phẩm</h1>
  <form:form modelAttribute="product" action="product-edit" method="post" enctype="multipart/form-data">
    <form:hidden path="id" />

    <label>Tên sản phẩm</label>
    <form:input path="name" /><br>
    <form:errors path="name" cssClass="error" /><br>

    <label>Giá</label>
    <form:input path="price" /><br>
    <form:errors path="price" cssClass="error" /><br>

    <label>Số lượng</label>
    <form:input path="quantity" /><br>
    <form:errors path="quantity" cssClass="error" /><br>

    <label>Hình ảnh</label>
    <input type="file" name="file" /><br><br>

    <c:if test="${not empty product.image}">
      <img src="${product.image}" width="100" alt="Ảnh sản phẩm hiện tại" /><br><br>
    </c:if>

    <input type="submit" value="Cập nhật sản phẩm" />
  </form:form>
</div>
</body>
</html>
