/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iden;
package com.mycompany.practicalenguajes;
/**
 *
 * @author LL829
 */
public enum Tipo {
    IDENTIFICADOR("IDENTIFICADOR:"),
    ENTERO("ENTERO:"),
    DECIMAL("DECIMAL:"),
    CARACTER("CARACTER:"),
    ERROR("ERROR:");
    String tipo;
}
private Tipo(String tipo){
        this.tipo = tipo;
    }
    public String getTipo(){
        return this.tipo;
    }
