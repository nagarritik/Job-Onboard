<%
    String success = (String)session.getAttribute("success");
    String url = (String)session.getAttribute("url");

    if(success==null||url==null){
        response.sendRedirect("index");
    }
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Success</title>
    <style>
        * {
            padding: 0;
            margin: 0;
            box-sizing: border-box;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        .main {
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }

        button {
            width: 250px;
            margin-top: 20px;
            background-color: green;
            color: white;
            border: 0;
            border-radius: 5px;
            padding: 5px 0;
        }

        p {
            max-width: 500px;
            border: 2px solid gray;
            padding: 15px 20px;
            border-radius: 8px;
            margin-bottom: 50px;
        }
    </style>
</head>

<body>
    <div class="main">
        <p><%=success%></p>
        <a href="<%=url%>"><button>Go Back</button></a>
    </div>
</body>

</html>

<%
    session.removeAttribute("success");
    session.removeAttribute("url");
%>