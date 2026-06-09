/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Usuarios;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import teste.JdbcCrud;

/**
 *
 * @author u11174571179
 */
public class UsuariosDAO extends DaoAbstract{
 Connection cnt;
    
  public UsuariosDAO(){
    try {
      Class.forName("com.mysql.jdbc.Driver");
                     String url, user, password;
                     url ="jdbc:mysql://10.7.0.51:33062/db_marcos_vilhanueva";
                     user ="marcos_vilhanueva";
                     password ="marcos_vilhanueva";

                     Connection cnt;
                     cnt = DriverManager.getConnection(url, user, password);
    } catch (ClassNotFoundException ex) {
             Logger.getLogger(JdbcCrud.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(JdbcCrud.class.getName()).log(Level.SEVERE, null, ex);
         }
         
    }
    
    @Override
    public boolean insert(Object object) {
        Usuarios UsuariosDAO = (Usuarios) object;
          try {
                             
                String sql= "insert into mpv_usuarios(mpv_nome,mpv_apelido, mpv_cpf,"
                        + " mpv_dataNascimento, mpv_nivel, mpv_senha, mpv_ativo) "
                        + "value(?,?,?,?,?,?,?)";                
              PreparedStatement pst = cnt.prepareStatement(sql);
             // pst.setInt(1, mpvUsuarios.getMpvidUsuarios());
              pst.setString(1, UsuariosDAO.getMpvNome());
              pst.setString(2, UsuariosDAO.getMvpApelido());
              pst.setString(3, UsuariosDAO.getMpvCpf());
              pst.setDate(4, (Date) UsuariosDAO.getMpvDataNascimento());
              pst.setInt(5, UsuariosDAO.getMpvNivel()+1);
              pst.setString(6, UsuariosDAO.getMpvSenha());
              pst.setString(7, UsuariosDAO.getMpvAtivo());
              pst.executeUpdate();
    
         } catch (SQLException ex) {
             Logger.getLogger(JdbcCrud.class.getName()).log(Level.SEVERE, null, ex);
             return false;
         }
          return true;
    }

    @Override
    public void update(Object object) {
        Usuarios UsuariosDAO = (Usuarios) object;
    }

    @Override
    public void delete(Object object) {
        Usuarios usuarios = (Usuarios) object;
        String sql = "DELETE FROM mpv_usuarios  WHERE mpv_idusuarios=?";
        
          try{
            PreparedStatement smt = cnt.prepareStatement(sql);
            smt.setInt(1, usuarios.getMpvidUsuarios());
            smt.executeUpdate();   
        }catch (SQLException e){
              System.out.println("Erro ao excluir usuarios: "+ e.getMessage());
        }
        
    }
  
    @Override
    public Object list(int id) {
       Usuarios usuarios = null;
       String sql = "SELECT * FROM mpv_usuarios WHERE mpv_idusuarios=?";
       
        try{
            PreparedStatement smt = cnt.prepareStatement(sql);
            smt.setInt(1, id);
            smt.executeUpdate();   
        }catch (SQLException ex ){
            return null;
        }
        
        return null;
    }

    @Override
    public Object listAll() {
    try {
             Class.forName("com.mysql.jdbc.Driver");
                     String url, user, password;
                     url ="jdbc:mysql://10.7.0.51:33062/db_marcos_vilhanueva";
                     user ="marcos_vilhanueva";
                     password ="marcos_vilhanueva";

                     Connection cnt;
                     cnt = DriverManager.getConnection(url, user, password);
                             
                String sql= "select * from mpv_usuarios";                
              PreparedStatement pst = cnt.prepareStatement(sql);
              ResultSet rs = pst.executeQuery();
              while(rs.next()== true) {
                  System.out.println("id:"+rs.getInt("mpv_idusuarios"));
             System.out.println("nome:"+rs.getString("mpv_nome"));
         }
              
              
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(JdbcCrud.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(JdbcCrud.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
    }
  
}
