<%@page
    import="java.util.List"
    import="com.ud.jobonboard.model.Company"
%>

<%
    List<Company> companyList = (List)request.getAttribute("companyList");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Job - Job Onboard</title>
    <style>
        *{
            padding: 0;
            margin: 0;
            box-sizing: border-box;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .form{
            display:flex;
            justify-content:center;
            align-item:center;
            margin:50px 0;
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
        input,textarea,select{
            padding: 10px 15px;
            width: 600px;
            border: 2px solid gray;
            border-radius: 8px;
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
    </style>
</head>
<body>
    <div class="form">
        <form action="job/post" method="post">
            <label for="title">Title</label>
            <input type="text" name="title" id="title" placeholder="Enter Title Here" required>

            <label for="description">Description</label>
            <textarea name="description" id="description" cols="30" rows="10" placeholder="Enter Job Description Here" required></textarea>

            <label for="qualificationRequirement">Qualification Requirement</label>
            <textarea name="qualificationRequirement" id="qualificationRequirement" cols="30" rows="10" placeholder="Enter Qualification Requirement Here" required></textarea>

            <label for="keyResponsibilities">Key Responsibilities</label>
            <textarea name="keyResponsibilities" id="keyResponsibilities" cols="30" rows="10" placeholder="Enter Key Responsibilities Here" required></textarea>

            <label for="requiredSkills">Required Skills</label>
            <textarea name="requiredSkills" id="requiredSkills" cols="30" rows="10" placeholder="Enter Required Skills Here" required></textarea>

            <label for="requiredExperience">Required Experience</label>
            <input type="text" name="requiredExperience" id="requiredExperience" placeholder="Enter Required Experience Here" required>

            <label for="location">Location</label>
            <input type="text" name="location" id="location" placeholder="Enter Job Location Here" required>

            <label for="companyId">Company</label>
            <select name="companyId" id="companyId" required>
                <%
                    for(Company item:companyList){
                        %>
                            <option value="<%=item.getId()%>"><%=item.getName()%></option>
                        <%
                    }
                %>
            </select>

            <button>Add Job</button>
        </form>
    </div>
</body>
</html>