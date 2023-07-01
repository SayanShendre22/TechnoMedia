
<%-- 
    Document   : contact
    Created on : 8 Apr, 2023, 5:02:56 PM
    Author     : mahes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.tech.blog.entities.Categories"%>
<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@page import="com.tech.blog.dao.PostDao"%>
<%@page import="com.tech.blog.entities.Message"%>
<%@page errorPage="error_page.jsp" %>
<%@page import="com.tech.blog.entities.User"%>
<%

    User user = (User) session.getAttribute("currentUser");

    if (user == null) {
        response.sendRedirect("login.jsp");
    } else {

    }

%>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>contact us</title>

   <!-- font awesome cdn link  -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">

   <!-- custom css file link  -->
   <link rel="stylesheet" href="css/style.css">

</head>
<body>

 <header class="header">
   
   <section class="flex">

      <a href="home.html" class="logo">Techno Media</a>

      <form action="search.html" method="post" class="search-form">
          <input onKeyUp="myFunction()" class="form-control text-center" type="text"   placeholder="Search" aria-label="Search"  id="search"  >
         <button type="submit" class="fas fa-search"></button>
      </form>

      <div class="icons">
         <div id="menu-btn" class="fas fa-bars"></div>
         <div id="search-btn" class="fas fa-search"></div>
         <div id="user-btn" class="fas fa-user"></div>
         <div id="toggle-btn" class="fas fa-sun"></div>
      </div>

      <div class="profile">
          <%if(user.getProfile()==""){
          %>
          <img src="ProfilePic/defualt.png" style="border-radius: 50%; width: 8rem "  >
          <%
          }else
            {           
          %>
         <img src="ProfilePic/<%= user.getProfile()%>" style="border-radius: 50%; width: 8rem "  >
         <%}%>
         <h3 class="modal-title  " > <%= user.getName()%> </h3>
         <%if(user.getUserPosition()==2)
         {
             %>
          
          <p class="role">Teacher</p>
           <img src="BlogPic/verified.png" style="border-radius: 50%; width: 3rem "  >
          <%}
        else{
            %>
             <p class="role">Student</p>
            <%

}
          
          %>
        
          <br>
         
         <div class="flex-btn">
            <a href="LogoutServlet" class="option-btn">Logout</a>
            
             <a href="" class="option-btn" data-toggle="modal" data-target="#profile-view" > View </a>
         </div>
      </div>

   </section>

</header> 

<div class="side-bar">

   <div id="close-btn">
      <i class="fas fa-times"></i>
   </div>

   <div class="profile">
     <%if(user.getProfile()==""){
          %>
          <img src="ProfilePic/defualt.png" style="border-radius: 50%; width: 8rem "  >
          <%
          }else
            {           
          %>
         <img src="ProfilePic/<%= user.getProfile()%>" style="border-radius: 50%; width: 8rem "  >
         <%}%>
      <h3 class="name"><%= user.getName()%></h3>
       <%if(user.getUserPosition()==2)
         {
             %>
          <p class="role">Teacher</p>
           <img src="BlogPic/verified.png" style="border-radius: 50%; width: 3rem "  >
          <%}
        else{
            %>
             <p class="role">Student</p>
            <%

}
          
          %>
     <button class="btn btn-outline-primary"   data-toggle="modal" data-target="#profile-view" > View Profile </button>
   </div>
     
   <nav class="navbar">
      <a href="Profile.jsp"><i class="fas fa-home"></i><span>Home</span></a>
      <br>
<!--      <a href="about.jsp"><i class="fas fa-question"></i><span>About</span></a>-->
      <a onclick="getPosts(0, this)" href=""><i class="fas fa-graduation-cap"></i><span>All posts</span></a>
      
      <a href="teachers.jsp"><i class="fas fa-chalkboard-user"></i><span>Teachers</span></a>
      <a href="contact.jsp"><i class="fas fa-headset"></i><span>Contact us</span></a>
   </nav>

</div>

<section class="contact">

   <div class="row">

      <div class="image">
         <img src="images/contact-img.svg" alt="">
      </div>

      <form action="" method="post">
         <h3>get in touch</h3>
         <input type="text" placeholder="enter your name" name="name" required maxlength="50" class="box">
         <input type="email" placeholder="enter your email" name="email" required maxlength="50" class="box">
         <input type="number" placeholder="enter your number" name="number" required maxlength="50" class="box">
         <textarea name="msg" class="box" placeholder="enter your message" required maxlength="1000" cols="30" rows="10"></textarea>
         <input type="submit" value="send message" class="inline-btn" name="submit">
      </form>

   </div>

   <div class="box-container">

      <div class="box">
         <i class="fas fa-phone"></i>
         <h3>phone number</h3>
         <a href="tel:1234567890">123-456-7890</a>
         <a href="tel:1112223333">111-222-3333</a>
      </div>
      
      <div class="box">
         <i class="fas fa-envelope"></i>
         <h3>email address</h3>
         <a href="mailto:shaikhanas@gmail.com">shaikhanas@gmail.come</a>
         <a href="mailto:anasbhai@gmail.com">anasbhai@gmail.come</a>
      </div>

      <div class="box">
         <i class="fas fa-map-marker-alt"></i>
         <h3>office address</h3>
         <a href="#">flat no. 1, a-1 building, jogeshwari, mumbai, india - 400104</a>
      </div>

   </div>

</section>














<footer class="footer">

   &copy; copyright @ 2023<span>Techno Media</span> | all rights reserved!

</footer>

<!-- custom js file link  -->
<script src="js/script.js"></script>

   
</body>
</html>