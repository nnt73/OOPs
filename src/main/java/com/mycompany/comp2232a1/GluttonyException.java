/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comp2232a1;

/**
 *
 * @author Kristian Patrick
 */
public class GluttonyException extends Exception{
    public GluttonyException()
    {
        super();
    }
    
    @Override
    public String toString()
    {
        return("Death by gluttony!");
    }
}
