/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.MpvUsuaios;
import java.sql.Connection;
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
public class DaoMpvUsuario extends DaoAbstract{

    @Override
    public void insert(Object object) {
        MpvUsuaios mpvUsuarios = (MpvUsuaios) object;
          try {
             Class.forName("com.mysql.jdbc.Driver");
                     String url, user, password;
                     url ="jdbc:mysql://10.7.0.51:33062/db_marcos_vilhanueva";
                     user ="marcos_vilhanueva";
                     password ="marcos_vilhanueva";

                     Connection cnt;
                     cnt = DriverManager.getConnection(url, user, password);
                             
                String sql= "insert into mpv_usuarios values(?,?,?,?,?,?,?,?)";                
              PreparedStatement pst = cnt.prepareStatement(sql);
              pst.setInt(2, mpvUsuarios.getMpvidUsuarios());
              pst.setString(2, mpvUsuarios.getMpvNome());
              pst.setString(3, mpvUsuarios.getMvpApelido());
              pst.setString(4, mpvUsuarios.getMpvCpf());
              pst.setDate(5, null);//mpv_datanascimento
              pst.setInt(6, mpvUsuarios.getMpvNivel());
              pst.setString(7, mpvUsuarios.getMpvSenha());
              pst.setString(8, mpvUsuarios.getMpvAtivo());
              pst.executeUpdate();
     
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(JdbcCrud.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(JdbcCrud.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @Override
    public void update(Object object) {
        MpvUsuaios mpvUsuarios = (MpvUsuaios) object;
    }

    @Override
    public void delete(Object object) {
         MpvUsuaios mpvUsuarios = (MpvUsuaios) object;
    }
  
    @Override
    public Object list(int id) {
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
