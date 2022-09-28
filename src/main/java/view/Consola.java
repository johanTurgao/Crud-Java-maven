/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import DAO.DAOLogin;
import java.util.ArrayList;
import java.util.List;

/* @author David */
public class Consola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DAOLogin Consulta = new DAOLogin();
        List <String> Lista = new ArrayList();
        Lista.add("5");
        Lista.add("5");
        System.out.println(Lista);
        for(String a:Lista){
            System.out.println(a);
        }
        
    }
    
}
