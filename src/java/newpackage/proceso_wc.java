/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package newpackage;

import javax.jws.WebService;
import java.io.*;
import java.sql.*;
import javax.jws.WebMethod;
import javax.swing.JOptionPane;

@WebService()
public class proceso_wc {

    private int id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String sexo;

          //---------------comienzo procedimiento para insertar usuario----------------
    @WebMethod
  public boolean insertarUsuario(String ce,String no,String ap, String dir, String se){

      String conexionBD="jdbc:mysql://127.0.0.1/datos_almacenados_ws";
      Connection conexion=null;
      boolean funciono=false;
      String con;

      try{
       // JOptionPane.showMessageDialog(null,"entro");
        Class.forName("com.mysql.jdbc.Driver");//el driver de mysql
        conexion=DriverManager.getConnection(conexionBD, "root","12345");//conexion a la base de datos
        Statement s = conexion.createStatement();
        // JOptionPane.showMessageDialog(null,no+" "+ap);
       con= "INSERT INTO USUARIOS VALUES (NULL,'"+ce+"','"+no+"','" + ap +"','"+ dir +"','"+se+"')";
        s.executeUpdate(con);

        funciono=true;
      }
      catch(Exception e){
        System.out.println("No se ha completado la peticiÃ³n...");
        }

        return funciono;
    }
    //------


      @WebMethod
  public boolean buscarUsuarioCedula(String ced){

      String conexionBD="jdbc:mysql://127.0.0.1/datos_almacenados_ws";
      Connection conexion=null;
      boolean funciono=false;
      String con;
      ResultSet rs;
      try{
       // JOptionPane.showMessageDialog(null,"entro");
        Class.forName("com.mysql.jdbc.Driver");//el driver de mysql
        conexion=DriverManager.getConnection(conexionBD, "root","12345");//conexion a la base de datos
        Statement s = conexion.createStatement();
        // JOptionPane.showMessageDialog(null,no+" "+ap);
        con="SELECT * FROM usuarios where cedula = '" + ced + "'" ;
        rs = s.executeQuery (con); {
            while (rs.next()) {
            cedula=rs.getString("cedula");
            nombre=rs.getString("nombre");
            apellido=rs.getString("apellido");
            direccion=rs.getString("direccion");
            sexo=rs.getString("sexo");
            funciono=true;

            MostrarCedula();
            MostrarNombre();
            MostrarApellido();
            MostrarDireccion();
            MostrarSexo();
            break;
            //JOptionPane.showMessageDialog(null, "si");
            }
        }

      }
      catch(Exception e){
        System.out.println("No se ha completado la peticiÃ³n...");
        }
        return funciono;
    }

     //--------


     @WebMethod
  public String MostrarNombre(){
      String nomb;
      nomb="";
      nomb=nombre;
      return nomb;

    }

   @WebMethod
  public String MostrarApellido(){
      String apell;
      apell="";
      apell=apellido;
      return apell;

    }

   @WebMethod
     public String MostrarCedula(){
      String codi;
      codi="";
      codi=cedula;
      return codi;

    }

  @WebMethod
  public String MostrarDireccion(){
      String dire;
      dire="";
      dire=direccion;
      return dire;
    }


  @WebMethod
  public String MostrarSexo(){
      String se;
      se="";
      se=sexo;
      return se;
    }

//------------comienzo procedimiento de actualizacion---------

   @WebMethod
  public boolean actualizarUsuario(String ced, String no,String ap, String dir, String se){

      String conexionBD="jdbc:mysql://127.0.0.1/datos_almacenados_ws";
      Connection conexion=null;
      boolean funciono=false;
      String con;

      try{
       // JOptionPane.showMessageDialog(null,"entro");
        Class.forName("com.mysql.jdbc.Driver");//el driver de mysql
        conexion=DriverManager.getConnection(conexionBD, "root","12345");//conexion a la base de datos
        Statement s = conexion.createStatement();
        // JOptionPane.showMessageDialog(null,no+" "+ap);
       con= "update usuarios set nombre='"+no+"',apellido='"+ap+"',direccion='"+dir+"',sexo='"+se+"' where cedula='"+ced+"'";
        s.executeUpdate(con);
        funciono=true;
      }
      catch(Exception e){
        System.out.println("No se ha completado la peticiÃ³n...");
        }

        return funciono;
    }
    //------

      //-----------comienzo procedimiento de eliminacion------------

   @WebMethod
  public boolean eliminarUsuario(String ced){

      String conexionBD="jdbc:mysql://127.0.0.1/datos_almacenados_ws";
      Connection conexion=null;
      boolean funciono=false;
      String con;

      try{
       // JOptionPane.showMessageDialog(null,"entro");
        Class.forName("com.mysql.jdbc.Driver");//el driver de mysql
        conexion=DriverManager.getConnection(conexionBD, "root","12345");//conexion a la base de datos
        Statement s = conexion.createStatement();
        // JOptionPane.showMessageDialog(null,no+" "+ap);
        con= "delete from usuarios where cedula='"+ced+"'";
        s.executeUpdate(con);
        funciono=true;
      }
      catch(Exception e){
        System.out.println("No se ha completado la peticiÃ³n...");
        }

        return funciono;
    }
    //------

}
