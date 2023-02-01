<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Company - Job Onboard</title>
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
        input,textarea{
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
        <form action="company/post" method="post">
            <label for="name">Name</label>
            <input type="text" name="name" id="name" placeholder="Enter Company Name Here" required>

            <label for="website">Website</label>
            <input type="url" name="website" id="website" placeholder="Enter Company Website Here" required>

            <label for="location">Location</label>
            <textarea name="location" id="location" cols="30" rows="10" placeholder="Enter Company Location Here (Saperate By Comma If Multiple Location)" required></textarea>

            <button type="submit">Add Company</button>
        </form>
    </div>
</body>
</html>