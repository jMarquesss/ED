/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapp.Exceptions;

/**
 *
 * @author admin
 */

public class EmptyCollectionException extends RuntimeException
{
   /******************************************************************
     Sets up this exception with an appropriate message.
   ******************************************************************/
   public EmptyCollectionException (String collection)
   {
      super ("The " + collection + " is empty.");
   }
}
