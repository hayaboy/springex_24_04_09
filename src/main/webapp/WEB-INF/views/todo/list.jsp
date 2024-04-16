
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Title</title>
</head>
<h1>Todo Project</h1>
<body>

<%--${dtoList}--%>

<%--현재의 Application : ${appName}--%>

<%--${loginInfo.mid}님 방가방가--%>

<div class="container-fluid">

    <div class="row">

        <div class="col">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Menu</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                        <div class="navbar-nav">
                            <a class="nav-link active" aria-current="page" href="#">Home</a>
                            <a class="nav-link" href="#">Features</a>
                            <a class="nav-link" href="#">Pricing</a>
                            <a class="nav-link disabled">Disabled</a>
                        </div>
                    </div>
                </div>
            </nav>
        </div>

    </div>




    <div class="row content">
        <div class="col">
            <div class="card">

                <div class="card-header">
                    할 일 목록
                </div>

                <div class="card-body">
                    <%--<h5 class="card-title">할 일 목록</h5>--%>

                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">Tno</th>
                            <th scope="col">Title</th>
                            <th scope="col">Writer</th>
                            <th scope="col">DueDate</th>
                            <th scope="col">Finished</th>
                        </tr>
                        </thead>
                        <tbody>

<%--                        <c:forEach items="${dtoList}" var="dto" >--%>
<%--                            <tr>--%>
<%--                                <th scope="row"><c:out value="${dto.tno}" /></th>--%>
<%--                                <td> <a href="/springex/todo/read?tno=${dto.tno}"> <c:out value="${dto.title}" /> </a></td>--%>
<%--                                <td> <c:out value="${dto.writer}" /></td>--%>
<%--                                <td> <c:out value="${dto.dueDate}" /></td>--%>
<%--                                <td> <c:out value="${dto.finished}" /></td>--%>
<%--                            </tr>--%>

<%--                        </c:forEach>--%>

                        <c:forEach items="${responseDTO.dtoList}" var="dto" >
                            <tr>
                                <th scope="row"><c:out value="${dto.tno}" /></th>
                                <td> <a href="/springex/todo/read?tno=${dto.tno}"> <c:out value="${dto.title}" /> </a></td>
                                <td> <c:out value="${dto.writer}" /></td>
                                <td> <c:out value="${dto.dueDate}" /></td>
                                <td> <c:out value="${dto.finished}" /></td>
                            </tr>

                        </c:forEach>



                        </tbody>



                    </table>


                </div>


            </div>




        </div>


    </div>




</div>











<%--<ul>
    <c:forEach items="${dtoList}" var="dto">
        <li>
            <span><a href="/jdbcex/todo/read?tno=${dto.tno}">${dto.tno}</a></span>
            <span>${dto.title}</span>
            <span>${dto.dueDate}</span>
            <span>${dto.finished? "DONE": "NOT YET"}</span>
        </li>
    </c:forEach>
</ul>--%>


<%--<form action="/jdbcex/logout" method="post">--%>
<%--    <button>LOGOUT</button>--%>
<%--</form>--%>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>
