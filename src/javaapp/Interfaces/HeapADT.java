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
public interface HeapADT<T> extends BinaryTreeADT<T> {
    
    public void addElement(T obj);
    
    public T removeMin();
    
    public T findMin();
}
