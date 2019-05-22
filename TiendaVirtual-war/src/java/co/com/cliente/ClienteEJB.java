/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.cliente;

import co.com.entidades.Comprador;
import co.com.entidades.InformacionEnvio;
import co.com.entidades.InformacionFactura;
import co.com.entidades.Producto;
import co.com.logica.AdministracionOrdenLocal;
import co.com.logica.AdministracionPersistenciaJPALocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jeisson
 */
public class ClienteEJB extends HttpServlet {
    
    //AdministracionPersistenciaLocal administacionPersistencia;
    @EJB
    AdministracionPersistenciaJPALocal administacionPersistencia;
    
    @EJB
    AdministracionOrdenLocal administracionOrden;
    

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClienteEJB</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClienteEJB at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            Producto pro = administacionPersistencia.consultarProducto(4);
            administracionOrden.adicionarProducto(pro);
            pro = new Producto();
            pro = administacionPersistencia.consultarProducto(5);
            administracionOrden.adicionarProducto(pro);
            
            Comprador com = administacionPersistencia.consultaComprador("pedro");
            administracionOrden.adicionarComprador(com);
            
            InformacionEnvio infEnv = new InformacionEnvio();
            infEnv.setCiudad("BOGOTA");
            infEnv.setDepartamento("CUNDINAMARCA");
            infEnv.setPais("COLOMBIA");
            infEnv.setDireccion("cr123 # 12-12");
            administracionOrden.adicionarInformacionEnvio(infEnv);
            
            InformacionFactura infFac = new InformacionFactura();
            infFac.setCodigoTarjeta("0001");
            infFac.setFechaExpiracion(new Date());
            infFac.setNumeroTarjeta("23456789");
            administracionOrden.adicionarInformacionFactura(infFac);
            
            administracionOrden.crearOrdenCompra();
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
