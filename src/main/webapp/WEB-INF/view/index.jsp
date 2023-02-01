<%@page
    import="java.util.List"
    import="com.ud.jobonboard.model.Company"
    import="com.ud.jobonboard.model.Job"
%>

<%
    List<Company> companyList = (List)request.getAttribute("companyList");
    List<Job> jobList = (List)request.getAttribute("jobList");
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Job Onboard</title>
    <style>
        *{
            padding: 0;
            margin: 0;
            box-sizing: border-box;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        a{
            text-decoration:none;
            color:black;
        }
        .main{
            min-height: 100vh;
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
        .companies{
            display: inline-flex;
        }
        .company{
            border:2px solid gray;
            width: 150px;
            padding: 15px 20px;
            font-weight: 600;
            font-size: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 10px;
            border-radius: 8px;
        }
    </style>
</head>

<body>
    <div class="main">
        <div class="companies">
            <%
                for(Company item:companyList){
                    %>
                        <a href="company/<%=item.getId()%>">
                            <div class="company">
                                <%=item.getName()%>
                            </div>
                        </a>
                    <%
                }
            %>
        </div>
        <div class="jobs">
            <%
                for(Job item:jobList){
                    %>
                        <div class="job">
                            <h1><%=item.getTitle()%></h1>
                            <span>Location - <%=item.getLocation()%></span>
                            <span>Skills Required: <%=item.getRequiredSkills()%></span>
                            <span>Experience Required: <%=item.getRequiredExperience()%> Years</span>
                            <a href="job/<%=item.getId()%>"><button>Apply Now</button></a>
                        </div>
                    <%
                }
            %>
        </div>
    </div>
</body>

</html>