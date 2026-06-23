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
import java.util.ArrayList;
import java.util.List;
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
        
     try {
         Usuarios usuarios = (Usuarios) object;
         String sql = "UPDATE mpv_usuarios SET mpv_nome=?,"
                 + "mpv_cpf=?, mpv_dataNascimento=?, mpv_nivel=?, mpv_senha=?,"
                 + "mpv_ativo=? WHRE mpv_idusuarios=?";
         
         PreparedStatement pst = cnt.prepareStatement(sql);
         pst.setString(1, usuarios.getMpvNome());
         pst.setString(2, usuarios.getMpvCpf());
         pst.setDate(4,(Date) usuarios.getMpvDataNascimento());
         pst.setInt(5, usuarios.getMpvNivel());
         pst.setString(6, usuarios.getMpvSenha());
         pst.setString(7, usuarios.getMpvAtivo());
         pst.setInt(8, usuarios.getMpvidUsuarios());
     } catch (SQLException ex) {
         Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
     }
        
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
           //import java.sql.ResultSet;
            ResultSet resp = smt.executeQuery();
            if(resp.next()){
                usuarios = new Usuarios();
                
                usuarios.setMpvidUsuarios(resp.getInt("mpv_idusuarios"));
                usuarios.setMpvNome(resp.getString("mpv_nome"));
                 usuarios.setMvpApelido(resp.getString("mpv_apelido"));
                usuarios.setMpvCpf(resp.getString("mpv_cpf"));
                usuarios.setMpvDataNascimento(resp.getDate("mpv_data_nascimento"));
                usuarios.setMpvNivel(resp.getInt("mpv_nivel"));
                usuarios.setMpvSenha(resp.getString("mpv_senha"));
                usuarios.setMpvAtivo(resp.getString("mpv_ativo"));
            }
        }catch (SQLException ex ){
            return null;
        }
        
        return null;
    }

    @Override
    public Object listAll() {
         List lista = new ArrayList();
         String sql = "SELECT * FROM mpv_usuarios";
        try{
            PreparedStatement smt = cnt.prepareStatement(sql);
            ResultSet resp = smt.executeQuery();
            while(resp.next()){
                Usuarios usuarios = new Usuarios();
                usuarios.setMpvidUsuarios(resp.getInt("mpv_idusuarios"));
                usuarios.setMpvNome(resp.getString("mpv_nome"));
                 usuarios.setMvpApelido(resp.getString("mpv_apelido"));
                usuarios.setMpvCpf(resp.getString("mpv_cpf"));
                usuarios.setMpvDataNascimento(resp.getDate("mpv_data_nascimento"));
                usuarios.setMpvNivel(resp.getInt("mpv_nivel"));
                usuarios.setMpvSenha(resp.getString("mpv_senha"));
                usuarios.setMpvAtivo(resp.getString("mpv_ativo"));
                lista.add(usuarios);
            }
        }catch (SQLException ex ){
            return null;
        }
        return lista;
    }
    
}
