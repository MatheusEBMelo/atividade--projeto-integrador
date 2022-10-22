/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojainformatica.model;

/**
 *
 * @author Mathe
 */
public class computador {
   
    public static String marca = "Matheus Melo";
    private String HD;
    private String processador;
    
    /**
     *
     */
    
   
     public computador(){  
   }
    public String getMarca(){  
          return this.marca;
      }

    public void setHD(String HD) {
        this.HD = HD;
    }
    public String getHD() {
        return HD;
    }
   
    public void setProcessador(String processador) {
        this.processador = processador;
    }
     public String getProcessador() {
        return processador;
    }

    
}
