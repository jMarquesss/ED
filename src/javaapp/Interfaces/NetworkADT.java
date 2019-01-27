/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapp.Interfaces;

/**
 *
 * @author ricar
 */
public interface NetworkADT<T> extends GraphADT<T> {
    
    public void addEdge(T vertex1,T vertex2,double Weight);
    
    public double shortestPathWeight(T vertex1,T vertex2);
    
}
