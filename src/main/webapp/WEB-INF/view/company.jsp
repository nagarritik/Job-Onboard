<%@page
    import="com.ud.jobonboard.model.Company"
    import="com.ud.jobonboard.model.Job"
    import="java.util.List"
%>

<%
    Company company = (Company)request.getAttribute("company");
    List<Job> jobList = company.getJobList();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%=company.getName()%> - Job Onboard</title>
    <style>
        *{
            padding: 0;
            margin: 0;
            box-sizing: border-box;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .main{
            min-height: 100vh;
        }
        header{
            padding: 30px 50px;
            background-color: rgba(128, 128, 128, 0.3);
        }
        button{
            width: 250px;
            margin-top: 20px;
            background-color: blue;
            color: white;
            border: 0;
            border-radius: 5px;
            padding: 5px 0;
        }
        span{
            font-weight: 550;
            font-size: 20px;
        }
        p{
            margin-bottom: 20px;
            text-align: justify;
        }
        .jobs{
            display: inline-flex;
            width: 100vw;
            align-items: center;
            flex-direction: column;
            margin-top: 100px;
        }
        .job{
            border: 1.5px solid gray;
            margin-top: 5px;
            border-radius: 8px;
            display: flex;
            flex-direction: column;
            padding: 10px 15px;
            width: 750px;
        }
        .job:hover{
            position: relative;
            bottom: 2.5px;
            right: 2.5px;
            box-shadow: 2.5px 2.5px rgba(128, 128, 128, 0.3);
        }
        .job button{
            width: 250px;
            margin-top: 10px;
            background-color: blue;
            color: white;
            border: 0;
            border-radius: 5px;
            padding: 5px 0;
        }
    </style>
</head>
<body>
    <div class="main">
        <header>
            <h1><%=company.getName()%></h1>

            <span>Company Website:</span>
            <a href="<%=company.getWebsite()%>" target="_blank">
                <p><%=company.getWebsite()%></p>
            </a>

            <span>Company Location:</span>
            <p><%=company.getLocation()%></p>
        </header>
        
        <div class="jobs">
            <%
                for(Job item:jobList){
                    %>
                        <div class="job">
                            <h1><%=item.getTitle()%></h1>
                            <span>Location - <%=item.getLocation()%></span>
                            <span>Skills Required: <%=item.getRequiredSkills()%></span>
                            <span>Experience Required: <%=item.getRequiredExperience()%> Years</span>
                            <a href="../job/<%=item.getId()%>"><button>Apply Now</button></a>
                        </div>
                    <%
                }
            %>
        </div>
    </div>
</body>
</html>