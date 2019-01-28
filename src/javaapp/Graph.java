/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapp;

import javaapp.Interfaces.GraphADT;
import javaapp.Pessoa.Pessoa;

import java.util.Iterator;

/**
 *
 * @author ricar
 */
public class Graph<T> implements GraphADT<T> {

    protected final int DEFAULT_CAPACITY = 10;
    protected int numVertices;
    protected double[][] adjMatrix;
    protected T[] vertices;

    public Graph() {
        numVertices = 0;
        this.adjMatrix = new double[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        this.vertices = (T[]) (new Object[DEFAULT_CAPACITY]);
    }
    public String toString()
    {
        if (numVertices == 0)
            return "Graph is empty";

        String result = new String("");

        result += "Adjacency Matrix\n";
        result += "----------------\n";
        result += "index\t";

        for (int i = 0; i < numVertices; i++)
        {
            result += "" + i;
            if (i < 10)
                result += " ";
        }
        result += "\n\n";

        for (int i = 0; i < numVertices; i++)
        {
            result += "" + i + "\t";

            for (int j = 0; j < numVertices; j++)
            {
                if (adjMatrix[i][j]!=0)
                    result += adjMatrix[i][j]+ " ";
                else
                    result += "0 ";
            }
            result += "\n";
        }

        result += "\n\nVertex Values";
        result += "\n-------------\n";
        result += "index\tvalue\n\n";

        for (int i = 0; i < numVertices; i++)
        {
            Pessoa temp= (Pessoa) vertices[i];
            result += "" + i + "\t";
            result += temp.getNome() + "\n";
        }
        result += "\n";
        return result;
    }

    @Override
    public void addVertex(T vertex) {
        if (numVertices == vertices.length) {
            expandCapacity();
        }
                vertices[numVertices] = vertex;
        for (int i = 0; i <= numVertices; i++) {
            adjMatrix[numVertices][i] = 0;
            adjMatrix[i][numVertices] = 0;
        }
        numVertices++;
    }

    @Override
    public void removeVertex (T vertex) {
        for (int i = 0; i < numVertices; i++)        {
            if (vertex.equals(vertices[i]))
            {
                removeVertex(i);
                return;
            }
        }
    }

    public void removeVertex (int index) {
        if (indexIsValid(index))
        {
            numVertices--;

            for (int i = index; i < numVertices; i++)
                vertices[i] = vertices[i+1];

            for (int i = index; i < numVertices; i++)
                for (int j = 0; j <= numVertices; j++)
                    adjMatrix[i][j] = adjMatrix[i+1][j];

            for (int i = index; i < numVertices; i++)
                for (int j = 0; j < numVertices; j++)
                    adjMatrix[j][i] = adjMatrix[j][i+1];
        }
    }

    @Override
    public void addEdge(T vertex1, T vertex2, double weight1, double weight2) {
        addEdge(getIndex(vertex1), getIndex(vertex2), weight1, weight2);

    }

    public void addEdge(int index1, int index2, double weight1, double weight2) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2]=weight1;
            adjMatrix[index2][index1] = weight2;
        }
    }

    @Override
    public void removeEdge (T vertex1, T vertex2)
    {
        removeEdge (getIndex(vertex1), getIndex(vertex2));
    }

    public void removeEdge (int index1, int index2) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = 0;
            adjMatrix[index2][index1] = 0;
        }
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
    public Iterator<T> iteratorShortestPath(T startVertex, T targetVertex)
    {
        return iteratorShortestPath(getIndex(startVertex),
                getIndex(targetVertex));
    }

    protected Iterator<Integer> iteratorShortestPathIndices
            (int startIndex, int targetIndex)
    {
        double shortestPathLength0=-1;

        return null;
    }

    public Iterator<T> iteratorShortestPath(int startIndex,
                                            int targetIndex)
    {
        ArrayUnorderedList<T> resultList = new ArrayUnorderedList<T>();
        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex))
            return resultList.iterator();

        Iterator<Integer> it = iteratorShortestPathIndices(startIndex,
                targetIndex);
        while (it.hasNext())
            resultList.addToRear(vertices[((Integer)it.next()).intValue()]);
        return resultList.iterator();
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
        double[][] tempAdjMatrix= new double [vertices.length*2][vertices.length*2];
        
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
