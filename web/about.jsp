<%-- 
    Document   : about
    Created on : 8 Apr, 2023, 5:00:43 PM
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
   <title>about us</title>

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
      <a href="about.jsp"><i class="fas fa-question"></i><span>About</span></a>
      <a onclick="getPosts(0, this)" href=""><i class="fas fa-graduation-cap"></i><span>All posts</span></a>
      
      <a href="teachers.jsp"><i class="fas fa-chalkboard-user"></i><span>Teachers</span></a>
      <a href="contact.jsp"><i class="fas fa-headset"></i><span>Contact us</span></a>
   </nav>

</div>

<section class="about">

   <div class="row">

      <div class="image">
         <img src="images/about-img.svg" alt="">
      </div>

      <div class="content">
         <h3>why choose us?</h3>
         <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Ut dolorum quasi illo? Distinctio expedita commodi, nemo a quam error repellendus sint, fugiat quis numquam eum eveniet sequi aspernatur quaerat tenetur.</p>
         <a href="courses.html" class="inline-btn">our courses</a>
      </div>

   </div>

   <div class="box-container">

      <div class="box">
         <i class="fas fa-graduation-cap"></i>
         <div>
            <h3>+10k</h3>
            <p>online courses</p>
         </div>
      </div>

      <div class="box">
         <i class="fas fa-user-graduate"></i>
         <div>
            <h3>+40k</h3>
            <p>brilliant students</p>
         </div>
      </div>

      <div class="box">
         <i class="fas fa-chalkboard-user"></i>
         <div>
            <h3>+2k</h3>
            <p>expert tutors</p>
         </div>
      </div>

      <div class="box">
         <i class="fas fa-briefcase"></i>
         <div>
            <h3>100%</h3>
            <p>job placement</p>
         </div>
      </div>

   </div>

</section> 

<section class="reviews">

   <h1 class="heading">student's reviews</h1>

   <div class="box-container">

      <div class="box">
         <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Necessitatibus, suscipit a. Quibusdam, dignissimos consectetur. Sed ullam iusto eveniet qui aut quibusdam vero voluptate libero facilis fuga. Eligendi eaque molestiae modi?</p>
         <div class="student">
            <img src="images/pic-2.jpg" alt="">
            <div>
               <h3>john deo</h3>
               <div class="stars">
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star-half-alt"></i>
               </div>
            </div>
         </div>
      </div>

      <div class="box">
         <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Necessitatibus, suscipit a. Quibusdam, dignissimos consectetur. Sed ullam iusto eveniet qui aut quibusdam vero voluptate libero facilis fuga. Eligendi eaque molestiae modi?</p>
         <div class="student">
            <img src="images/pic-3.jpg" alt="">
            <div>
               <h3>john deo</h3>
               <div class="stars">
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star-half-alt"></i>
               </div>
            </div>
         </div>
      </div>

      <div class="box">
         <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Necessitatibus, suscipit a. Quibusdam, dignissimos consectetur. Sed ullam iusto eveniet qui aut quibusdam vero voluptate libero facilis fuga. Eligendi eaque molestiae modi?</p>
         <div class="student">
            <img src="images/pic-4.jpg" alt="">
            <div>
               <h3>john deo</h3>
               <div class="stars">
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star-half-alt"></i>
               </div>
            </div>
         </div>
      </div>

      <div class="box">
         <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Necessitatibus, suscipit a. Quibusdam, dignissimos consectetur. Sed ullam iusto eveniet qui aut quibusdam vero voluptate libero facilis fuga. Eligendi eaque molestiae modi?</p>
         <div class="student">
            <img src="images/pic-5.jpg" alt="">
            <div>
               <h3>john deo</h3>
               <div class="stars">
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star-half-alt"></i>
               </div>
            </div>
         </div>
      </div>

      <div class="box">
         <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Necessitatibus, suscipit a. Quibusdam, dignissimos consectetur. Sed ullam iusto eveniet qui aut quibusdam vero voluptate libero facilis fuga. Eligendi eaque molestiae modi?</p>
         <div class="student">
            <img src="images/pic-6.jpg" alt="">
            <div>
               <h3>john deo</h3>
               <div class="stars">
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star-half-alt"></i>
               </div>
            </div>
         </div>
      </div>

      <div class="box">
         <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Necessitatibus, suscipit a. Quibusdam, dignissimos consectetur. Sed ullam iusto eveniet qui aut quibusdam vero voluptate libero facilis fuga. Eligendi eaque molestiae modi?</p>
         <div class="student">
            <img src="images/pic-7.jpg" alt="">
            <div>
               <h3>john deo</h3>
               <div class="stars">
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star"></i>
                  <i class="fas fa-star-half-alt"></i>
               </div>
            </div>
         </div>
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