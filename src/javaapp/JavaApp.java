/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapp;

import javaapp.Pessoa.CargosProfissionais;
import javaapp.Pessoa.FormacaoAcademica;
import javaapp.Pessoa.Pessoa;

import java.util.Iterator;

/**
 *
 * @author admin
 */
public class JavaApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Reader r = new Reader();
        Graph g = r.fileReader("test.txt");
        System.out.println(g.toString());
        Iterator i = g.iteratorShortestPath(g.vertices[0], g.vertices[4]);
        System.out.println(i);
    }
    
}
