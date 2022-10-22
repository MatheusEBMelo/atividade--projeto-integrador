/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojainformatica;

/**
 *
 * @author Mathe
 */
public class utils {

    public static boolean IsNullOrEmptyOrBlank(String string) {

        boolean status = false;

        if ((string.isBlank()) | (string.isEmpty()) | (string == null)) {
            status = true;
        }
        return status;
    }
}
