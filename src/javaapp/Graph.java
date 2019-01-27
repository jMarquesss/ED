/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapp;

import javaapp.Interfaces.GraphADT;
import java.util.Iterator;

/**
 *
 * @author ricar
 */
public class Graph<T> implements GraphADT<T> {

    protected final int DEFAULT_CAPACITY = 10;
    protected int numVertices;
    protected boolean[][] adjMatrix;
    protected T[] vertices;

    public Graph() {
        numVertices = 0;
        this.adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        this.vertices = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    @Override
    public void addVertex(T vertex) {
        if (numVertices == vertices.length) {
            expandCapacity();
        }

        vertices[numVertices] = vertex;
        for (int i = 0; i <= numVertices; i++) {
            adjMatrix[numVertices][i] = false;
            adjMatrix[i][numVertices] = false;
        }
        numVertices++;
    }

    @Override
    public void removeVertex(T vertex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addEdge(T vertex1, T vertex2) {
        addEdge(getIndex(vertex1), getIndex(vertex2));

    }

    public void addEdge(int index1, int index2) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2]=true;
            adjMatrix[index2][index1] = true;
        }
    }

    @Override
    public void removeEdge(T vertex1, T vertex2) {
       
    }

    public Iterator iteratorBFS(int startIndex) {
        Integer x;
        LinkedQueue<Integer> traversalQueue = new LinkedQueue<Integer>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<T>();

        if (!indexIsValid(startIndex)) {
            return resultList.iterator();
        }

        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }
        traversalQueue.enqueue(new Integer(startIndex));
        visited[startIndex] = true;

        while (!traversalQueue.isEmpty()) {
            x = traversalQueue.dequeue();
            resultList.addToRear(vertices[x.intValue()]);

            for (int i = 0; i < numVertices; i++) {
                traversalQueue.enqueue(new Integer(i));
                visited[i] = true;
            }
        }
        return resultList.iterator();
    }
     @Override
     public Iterator iteratorBFS(T startVertex ){
         return iteratorBFS(getIndex(startVertex));
     }

    
    public Iterator iteratorDFS(int startIndex) {
        Integer x;
        boolean found;
        LinkedStack<Integer> traversalStack = new LinkedStack<Integer>();
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<T>();
        boolean[] visited = new boolean[numVertices];

        if (!indexIsValid(startIndex)) {
            return resultList.iterator();
        }

        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        traversalStack.push(new Integer(startIndex));
        resultList.addToRear(vertices[startIndex]);
        visited[startIndex] = true;

        while (!traversalStack.isEmpty()) {
            x = traversalStack.peek();
            found = false;

            for (int i = 0; (i < numVertices) && !found; i++) {
                traversalStack.push(new Integer(i));
                resultList.addToRear(vertices[i]);
                visited[i] = true;
                found = true;
            }
            if (!found && !traversalStack.isEmpty()) {
                traversalStack.pop();
            }
        }
        return resultList.iterator();
    }

    @Override
    public Iterator iteratorDFS(T startVertex){
        return iteratorDFS(getIndex(startVertex));
    }
    @Override
    public Iterator iteratorShortestPath(T startVertex, T targetVertex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return numVertices == 0;
    }

    @Override
    public boolean isConnected() {
        if(isEmpty()){
            return false;
        }
        Iterator<T> pes=iteratorBFS(0);
        int count=0;
        
        while(pes.hasNext()){
            pes.next();
            count++;
        }
        return (count==numVertices);
    }

    @Override
    public int size() {
        return numVertices;
    }

    protected boolean indexIsValid(int index) {
       return ((index<numVertices) && (index>=0));
    }
    public int getIndex(T vertex){
        for(int i=0;i<numVertices;i++){
            if(vertices[i].equals(vertex)){
                return i;
            }
            
        }return -1;
    }
    protected void expandCapacity() {
        T[] tempVertices=(T[])(new Object[vertices.length*2]);
        boolean[][] tempAdjMatrix= new boolean [vertices.length*2][vertices.length*2];
        
        for(int i=0;i<numVertices;i++){
            for(int j=0;j<numVertices;j++){
                tempAdjMatrix[i][j]=adjMatrix[i][j];
            }
            tempVertices[i]=vertices[i];
        }
        vertices=tempVertices;
        adjMatrix=tempAdjMatrix;
    }
}
