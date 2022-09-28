/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Controller.LoginJpaController;
import Controller.exceptions.NonexistentEntityException;
import Entity.Login;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/** * @author David */

public class DAOLogin {
    
    private Login Objeto = new Login();
    private final LoginJpaController Metodo = new LoginJpaController();
    
    public boolean Crear(String Usuario, String Contrasenna, int Nivel, String Foto){
        Objeto.setUsuario(Usuario);
        Objeto.setContraseña(Contrasenna);
        Objeto.setNivel(Nivel);
        Objeto.setFoto(Foto);
        
        try{
            Metodo.create(Objeto);
            return true;
        }
        catch(Exception Ex){
            return false;
        }
    }
    public boolean Editar(int id, String Usuario, String Contrasenna, int Nivel, String Foto){
        Objeto.setId(id);
        Objeto.setUsuario(Usuario);
        Objeto.setContraseña(Contrasenna);
        Objeto.setNivel(Nivel);
        Objeto.setFoto(Foto);
        
        try{
            Metodo.edit(Objeto);
            return true;
        }
        catch(Exception Ex){
            return false;
        }
    }
    public boolean Borrar(int id){
        try{
            Metodo.destroy(id);
            return true;
        }
        catch(NonexistentEntityException Ex){
            return false;
        }
    }
    public Login BuscarId(int id){ 
        this.Objeto=Metodo.findLogin(id);
        if(Objeto!=null) {
            return this.Objeto;
        } else {
            return null;
        } 
    }
    public List<Login> BuscarTodo(){ 
         return Metodo.findLoginEntities();
    }
    public String Codificar_Imagen(String DireccionImagen) throws IOException{//c:/imagen.png
        FileInputStream file = new FileInputStream(DireccionImagen);
        byte[] fileContent = file.readAllBytes();
        String encodedString = Base64
          .getEncoder()
          .encodeToString(fileContent);
        return encodedString;
    }
    //jLabel1.setIcon(Consulta.Deodificar_Imagen(Consulta.BuscarId(3).getFoto())); en swing
    public ImageIcon Deodificar_Imagen(String base64Imagen, int size){
        ImageIcon imagi = null;
        try{
            byte[] decodedBytes = Base64
          .getDecoder()
          .decode(base64Imagen);
          BufferedImage imagen;
          InputStream in = new ByteArrayInputStream(decodedBytes);
          imagen = ImageIO.read(in);
          imagi = new ImageIcon(imagen.getScaledInstance(size, size, 0));
          return imagi;
        }
        catch(IOException e){
           return imagi; 
        }
    }
}
