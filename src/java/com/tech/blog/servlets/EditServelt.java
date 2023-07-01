/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.tech.blog.servlets;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;
import com.tech.blog.helper.ProfilePicHelper;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Asus
 */
@MultipartConfig
public class EditServelt extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditServelt</title>");
            out.println("</head>");
            out.println("<body>");

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String pass = request.getParameter("password");
            String about = request.getParameter("user_about");

            Part part = request.getPart("image");

            //fecth image name by its part
            String Iname = part.getSubmittedFileName();

            HttpSession session = request.getSession();

            User user = (User) session.getAttribute("currentUser");

            user.setName(name);
            user.setEmail(email);
            user.setPassword(pass);
            user.setAbout(about);
            String oldProfile = user.getProfile();
            if(Iname.length()==0){
                user.setProfile(oldProfile);
            }else{
            user.setProfile(Iname);
            }
//            System.out.println("The image name is "+Iname);

            UserDao Upt = new UserDao(ConnectionProvider.getConnection());

            boolean uptStatus = Upt.UpdateUser(user);

            if (uptStatus) {
                out.print("updated");

                String path = request.getRealPath("/") + "ProfilePic" + File.separator + part.getSubmittedFileName();
                String Oldpath = request.getRealPath("/") + "ProfilePic" + File.separator + oldProfile;

                //delete old profile
                if (!oldProfile.equalsIgnoreCase("defualt.png") &&  !user.getProfile().equalsIgnoreCase(oldProfile) ) {
                    ProfilePicHelper.deleteProfile(Oldpath);
                }

                if (ProfilePicHelper.saveProfilePic(part.getInputStream(), path)) {
                     out.print("updated");
                }

                Message msg = new Message("User Profile Updated...!!!", "success", "alert-success");

                HttpSession s1 = request.getSession();
                s1.setAttribute("msg", msg);
                response.sendRedirect("Profile.jsp");

            } else {
                out.print("not updated");
                Message msg = new Message("something went wrong..!! please Try again", "error", "alert-danger");

                HttpSession s1 = request.getSession();
                s1.setAttribute("msg", msg);
                response.sendRedirect("Profile.jsp");
            }

            out.println("</body>");
            out.println("</html>");
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
