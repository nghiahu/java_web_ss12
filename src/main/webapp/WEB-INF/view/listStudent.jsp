<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 27/05/2025
  Time: 12:21 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sinh viên</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 20px;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            background: rgba(255, 255, 255, 0.95);
            border-radius: 15px;
            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.1);
            padding: 30px;
            backdrop-filter: blur(10px);
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
            font-size: 2.5rem;
            font-weight: 600;
            background: linear-gradient(45deg, #667eea, #764ba2);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            background-clip: text;
        }

        .table-wrapper {
            overflow-x: auto;
            border-radius: 12px;
            box-shadow: 0 8px 25px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background: white;
            border-radius: 12px;
            overflow: hidden;
        }

        th {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 18px 15px;
            text-align: left;
            font-weight: 600;
            font-size: 1.1rem;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }

        td {
            padding: 15px;
            border-bottom: 1px solid #e9ecef;
            color: #333;
            font-size: 1rem;
            transition: background-color 0.3s ease;
        }

        tr:hover {
            background-color: #f8f9ff;
            transform: translateY(-2px);
            transition: all 0.3s ease;
        }

        tr:last-child td {
            border-bottom: none;
        }

        .action-buttons {
            display: flex;
            gap: 10px;
            justify-content: center;
        }

        button {
            padding: 8px 16px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-weight: 500;
            font-size: 0.9rem;
            transition: all 0.3s ease;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }
        .btn-add{
            margin: 30px;
            background: deepskyblue;
            color: white;
        }
        .btn-edit {
            background: linear-gradient(45deg, #28a745, #20c997);
            color: white;
        }

        .btn-edit:hover {
            background: linear-gradient(45deg, #218838, #1ba085);
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(40, 167, 69, 0.4);
        }

        .btn-delete {
            background: linear-gradient(45deg, #dc3545, #e74c3c);
            color: white;
        }

        .btn-delete:hover {
            background: linear-gradient(45deg, #c82333, #dc2d37);
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(220, 53, 69, 0.4);
        }

        .student-id {
            font-weight: 600;
            color: #667eea;
        }

        .student-name {
            font-weight: 500;
            color: #333;
        }

        .student-email {
            color: #666;
            font-style: italic;
        }

        .student-dob {
            color: #555;
        }

        @media (max-width: 768px) {
            .container {
                margin: 10px;
                padding: 20px;
            }

            h1 {
                font-size: 2rem;
                margin-bottom: 20px;
            }

            th, td {
                padding: 12px 8px;
                font-size: 0.9rem;
            }

            .action-buttons {
                flex-direction: column;
                gap: 5px;
            }

            button {
                padding: 6px 12px;
                font-size: 0.8rem;
            }
        }

        @media (max-width: 480px) {
            th, td {
                padding: 10px 6px;
                font-size: 0.8rem;
            }

            h1 {
                font-size: 1.5rem;
            }
        }

        @keyframes fadeInUp {
            from {
                opacity: 0;
                transform: translateY(20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        .table-wrapper {
            animation: fadeInUp 0.6s ease-out;
        }

        .empty-state {
            text-align: center;
            padding: 50px 20px;
            color: #666;
            font-size: 1.1rem;
        }

    </style>
</head>
<body>
<div class="container">
    <h1>Danh sách sinh viên</h1>
    <a href="addStudent">
        <button class="btn-add">Thêm sinh viên</button>
    </a>
    <div class="table-wrapper">
        <table>
            <thead>
            <tr>
                <th>Mã sinh viên</th>
                <th>Tên sinh viên</th>
                <th>Email</th>
                <th>Ngày sinh</th>
                <th>Thao tác</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td class="student-id">${student.id}</td>
                    <td class="student-name">${student.name}</td>
                    <td class="student-email">${student.email}</td>
                    <td class="student-dob">${student.dob}</td>
                    <td>
                        <div class="action-buttons">
                            <a href="editStudent?id=${student.id}"><button class="btn-edit">Sửa</button></a>
                            <a href="delStudent?id=${student.id}" onclick=" return confirm('Bạn có muốn xóa sinh viên này không')"><button class="btn-delete">Xóa</button></a>
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