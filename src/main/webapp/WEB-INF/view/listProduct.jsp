<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 27/05/2025
  Time: 3:23 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
  body {
    font-family: Arial, sans-serif;
    margin: 20px;
    background-color: #f9f9f9;
  }

  .container {
    width: 90%;
    max-width: 1200px;
    margin: 0 auto;
  }

  h1 {
    text-align: center;
    margin-bottom: 20px;
  }

  .btn-add {
    padding: 8px 16px;
    background-color: #28a745;
    color: white;
    border: none;
    border-radius: 6px;
    cursor: pointer;
    font-size: 14px;
    margin-bottom: 15px;
  }

  .btn-add:hover {
    background-color: #218838;
  }

  .table-wrapper {
    overflow-x: auto;
  }

  table {
    width: 100%;
    border-collapse: collapse;
    background-color: white;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
  }

  th, td {
    padding: 12px 16px;
    text-align: center;
    border-bottom: 1px solid #ddd;
  }

  th {
    background-color: #007bff;
    color: white;
    text-transform: uppercase;
    letter-spacing: 0.5px;
  }

  tr:hover {
    background-color: #f1f1f1;
  }

  img {
    border-radius: 4px;
    box-shadow: 0 0 5px rgba(0,0,0,0.1);
  }

  .action-buttons {
    display: flex;
    justify-content: center;
    gap: 10px;
  }

  .btn-edit,
  .btn-delete {
    padding: 6px 12px;
    border: none;
    border-radius: 4px;
    color: white;
    font-size: 13px;
    cursor: pointer;
  }

  .btn-edit {
    background-color: #ffc107;
  }

  .btn-edit:hover {
    background-color: #e0a800;
  }

  .btn-delete {
    background-color: #dc3545;
  }

  .btn-delete:hover {
    background-color: #c82333;
  }
</style>

<body>
<div class="container">
  <h1>Danh sách sản phẩm</h1>
  <a href="addProduct">
    <button class="btn-add">Thêm sản phẩm</button>
  </a>
  <div class="table-wrapper">
    <table>
      <thead>
      <tr>
        <th>ID</th>
        <th>Tên sản phẩm</th>
        <th>Giá</th>
        <th>Số lượng</th>
        <th>Hình ảnh</th>
        <th>Thao tác</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="product" items="${products}">
        <tr>
          <td>${product.id}</td>
          <td>${product.name}</td>
          <td>${product.price}</td>
          <td>${product.quantity}</td>
          <td><img src="${product.image}" alt="product image" width="80"/></td>
          <td>
            <div class="action-buttons">
              <a href="editProduct?id=${product.id}"><button class="btn-edit">Sửa</button></a>
              <a href="delProduct?id=${product.id}" onclick="return confirm('Bạn có muốn xóa sản phẩm này không?')"><button class="btn-delete">Xóa</button></a>
            </div>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>
</body>
</html>
