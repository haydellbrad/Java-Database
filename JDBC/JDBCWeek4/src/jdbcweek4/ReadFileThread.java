/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcweek4;

import java.io.*;
import java.util.*;


public class ReadFileThread extends Thread{
    public void run()
    {
        String fileName = "animalTextFile.txt"; //Variable for File
        String line;
        
        // ArrayList for Animal Objects
        
        Collection<String> animalObject = new ArrayList<>();
        
        try
        {
            // Reads external file that was Pre-created
            
            FileReader reader = new FileReader(fileName);
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            
            // if file is not ready, will throw exception
            
            if(!input.ready())
            {
                throw new IOException();
            }
            
            // while file is being read, if line is not empty, will populate the
            // ArrayList
            
            while((line = input.readLine()) != null)
            {
                animalObject.add(line); 
            }
            input.close();      
        }
        
        catch (IOException e)
        {
            System.out.println(e);
        }
        
        // Iterator to read line by line and print the animal objects 
        // on screen
       
        Iterator<String> animalsIt = animalObject.iterator();
        
        while(animalsIt.hasNext())
        {
            String value = animalsIt.next();
        
            System.out.println(value);
        
            
        }
       
        
    } 
     
     

}
    
class DefineAnimals2 // Object for animals
{
    String name;
    String group;
    String skin;
    String diet;
    String life;
    
    public void defineAnimals2(String name, String group, String diet, 
                          String skin, String life)
    {
        this.name = name;
        this.group = group;
        this.skin = skin;
        this.diet = diet;
        this.life = life;
        
    }
    
    public String toString() // Prints the Characteristics of the animal selected
    {
        return "Common Name:  " + name +
               "\nGroup:  " + group +
               "\nSkin Type:  " + skin +
               "\nDiet:  " + skin +
               "\nLife Span:  " + life;
    }
}


