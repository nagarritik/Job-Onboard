<%@page
    import="com.ud.jobonboard.model.Job"
%>

<%
    Job job = (Job)request.getAttribute("job");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Applying For - <%=job.getTitle()%></title>
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
        .form{
            padding: 200px;
        }
        form{
            display:flex;
            flex-direction: column;
        }
        label{
            font-weight: 550;
            font-size: 20px;
            margin: 20px 0;
        }
        input,textarea{
            padding: 10px 15px;
            width: 600px;
            border: 2px solid gray;
            border-radius: 8px;
        }
    </style>
</head>
<body>
    <div class="main">
        <header>
            <h1><%=job.getTitle()%></h1>
            <span>Job Description:</span>
            <p><%=job.getDescription()%></p>

            <span>Qualification Requirement:</span>
            <p><%=job.getQualificationRequirement()%></p>

            <span>Key Responsibilities:</span>
            <p><%=job.getKeyResponsibilities()%></p>

            <span>Required Skills:</span>
            <p><%=job.getRequiredSkills()%></p>

            <span>Required Experience:</span>
            <p><%=job.getRequiredExperience()%> Years</p>

            <span>Location:</span>
            <p><%=job.getLocation()%></p>

            <span>Company</span>
            <p><%=job.getCompany().getName()%></p>
        </header>

        <div class="form">
            <form action="../applicant/post" method="post">
                <input type="hidden" value="<%=job.getId()%>" name="jobId" id="jobId">

                <label for="name">Name</label>
                <input type="text" name="name" id="name" required placeholder="Enter Your Name Here">

                <label for="email">Email</label>
                <input type="email" name="email" id="email" placeholder="Enter Your Email Here" required>

                <label for="mobileNumber">Mobile Number</label>
                <input type="number" name="mobileNumber" id="mobileNumber" placeholder="Enter Mobile Number Here" required>
                
                <label for="skill">Skill</label>
                <textarea name="skill" id="skill" cols="30" rows="10" placeholder="Enter Your Skills Saperated By Comma" required></textarea>

                <label for="experience">Experience</label>
                <input type="number" name="experience" id="experience" placeholder="Enter Experience In Years" required>

                <button>Apply For This Job</button>
            </form>
        </div>
    </div>
</body>
</html>