 
package com.tech.blog.servlets;

import com.sun.java.swing.plaf.windows.resources.windows;
import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@MultipartConfig
public class otpServlet extends HttpServlet {
    
        //this is responsible to send email..
  

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
         
            HttpSession session = request.getSession();
            
            
            String check = request.getParameter("check");
            
//           out.println(check);

            if(check==null){
                out.print("box is uncheck");
            }else{
                
                String name= request.getParameter("user_name");
                String email= request.getParameter("email");
                String password= request.getParameter("password");
                String gender= request.getParameter("gender");
                String about= request.getParameter("about");
                
                User user = new User(name,email,gender,about,password);
                
                UserDao userDao = new UserDao(ConnectionProvider.getConnection());
                Random random  = new Random();
                int otp = random.nextInt(999999)+100000; 
                    
                   
               
                
                
                
                
                //boolean status =userDao.saveUser(user);
                
//                if(status){
//                    out.print("Done");
//                }
//                else{
//                    out.print("error");
//                }
            }
            
            
            
            
 
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
