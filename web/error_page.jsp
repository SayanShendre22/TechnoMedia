<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>

<!DOCTYPE html>
<html>
    <head>
        
        
         <!--icons-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <!--css-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/MyCSS.css" rel="stylesheet" type="text/css"/>

        <style>
            .banner-clippath{
                clip-path: polygon(0 0, 100% 0, 100% 100%, 89% 90%, 33% 100%, 0 85%);
            }
        </style>
        
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sorry..! Something Went wrong</title>
    </head>
    <body>
        
        <div class="container" style="text-align:center;" >
            
            <img src="image/error-48252.png"  class="img-fluid" style="width: 50vh; height: 50vh; margin: 20px " >
            <br>
            <br>
            <h4 class="display-3" >OOPS..! Something went wrong</h4>
            <br>
            <%= exception %>
            
            <a href="index.jsp" class="btn primary-background btn-lg text-white mt-3 " >Home</a>
            
        </div>
        
    </body>
</html>
