/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aitor.ra5.tools;

/**
 *
 * @author aitor
 */
public class PasswordValidator {
    
    /**
     *  (?=.*[A-Z]) Al menos una mayuscula
     *  (?=.*[0-9]) Al menos un numero
     *  (?=.*[!@#$%^&*(),.?\":{}|<>]) al menos un caracter especial
     *  [A-Za-z0-9!@#$%^&*(),.?\":{}|<>]{8,} Cualquier caracter descrito un 
     *                                      minimo de 8 caracteres
     */
    private static final String pattern = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*(),.?\":{}|<>])[A-Za-z0-9!@#$%^&*(),.?\":{}|<>]{8,}$";
    public static int pswdVal(String pswd){
        int i = -1;
        System.out.println(pswd);
        if(pswd.matches(pattern)){
            i = 1;
        }else if(!pswd.matches(pattern)){
            i = 0;
        }
        return i;
    }
}   
