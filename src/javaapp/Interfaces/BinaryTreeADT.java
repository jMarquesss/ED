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
public interface BinaryTreeADT <T> {
    
    public T getRoot();
    
    public boolean isEmpty();
    
    public int size();
    
    public boolean contains(T targetElement);
    
    public T find(T targetElement);
    
    public String toString();
    
    public Iterator <T> iteratorInOrder();
    
    public Iterator <T> iteratorPreOrder();
    
    public Iterator <T> iteratorPostOrder();
    
    public Iterator <T> iteratorLevelOrder();
}
