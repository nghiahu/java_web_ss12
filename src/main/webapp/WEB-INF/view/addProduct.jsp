<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 27/05/2025
  Time: 3:27 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sản phẩm</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<div>
    <h1>Thêm sản phẩm</h1>
    <form:form modelAttribute="product" action="product-save" method="post" enctype="multipart/form-data">
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

        <input type="submit" value="Thêm sản phẩm" />
    </form:form>
</div>
</body>
</html>