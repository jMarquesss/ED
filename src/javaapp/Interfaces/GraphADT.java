/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapp.Interfaces;

import java.util.Iterator;

/**
 *
 * @author ricar
 */
public interface GraphADT<T> {
    
    
    public void addVertex(T vertex);
    
    public void removeVertex(T vertex);
    
    public void addEdge(T vertex,T vertex2);
    
    public void removeEdge(T vertex1,T vertex2);
    
    public Iterator iteratorBFS(T startVertex);
    
    public Iterator iteratorDFS(T startVertex);
    
    public Iterator iteratorShortestPath(T startVertex, T targetVertex);
    
    public boolean isEmpty();
    
    public boolean isConnected();
    
    public int size();
    
    public String toString();
}
