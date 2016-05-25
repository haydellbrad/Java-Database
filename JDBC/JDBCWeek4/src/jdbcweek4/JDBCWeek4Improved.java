/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcweek4;
/**
 *
 * @author bradhaydell
 */

import java.sql.*;
import java.util.*;

public class JDBCWeek4Improved 
{
    
    // Variables for the the drivers, url, username, and password of database

    static final String driver = "org.apache.derby.jdbc.ClientDriver";
    static final String drurl = "jdbc:derby://localhost:1527/ANIMALS";
    
    static final String user = "animals";
    static final String pass = "1234";
    
    public static void main(String[] args) 
    {
        // Variable to manually close the program
        Connection connection = null;
        Statement stmt = null;
        Boolean close = false;
        
        // Try - catch for database connection
        
        ReadFileThread rft = new ReadFileThread();
        rft.start();
        
        try
        {
            //Input scanner for end user.
            
            Scanner choice = new Scanner(System.in);
            
            // Registration of the JDBC driver
            
            Class.forName(driver);
            System.out.println("Connecting to a selected database...");
            
            // Open a connection to the database
            
            connection = DriverManager.getConnection(drurl,user,pass);
            System.out.println("Connected database successfully...");
            System.out.println("Creating table in given database...");
            

            // Execute a query to the database
 
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "select * from ANIMALS.ANIMALS";
            ResultSet rs = stmt.executeQuery(sql);
            //int count = 1;
            
            
            // Have program loop through until the end user manually close program
            while(close == false)
            {
                // Display all animals into a list and ask end user to choose
                // one of the animals.
                 System.out.println();
                while(rs.next())
                {   
                    String name = rs.getString("NAME");
                    System.out.println(rs.getRow() + ":  " + name);
                }
                rs.beforeFirst();
                    System.out.println();
                    
                    System.out.print("Enter number of animal to be displayed (0 to close):  ");
                    while (!choice.hasNextInt())
                    {
                    
                        System.out.println();
                        System.out.println("Your name cannot have letters or"
                                   + " special characters in it.");
                        System.out.println();
                        
                        System.out.print("Enter number of animal to be displayed(0 to close) : ");
                        choice.nextInt();
                    }
                    
                System.out.println();
                String input = choice.next();
 
                Statement stmt2 = connection.createStatement();
                String sql2 = "SELECT NAME, TYPE, SKIN, DIET, LIFESPAN FROM ANIMALS.ANIMALS WHERE NAME = 'Bear'";
                ResultSet rs2 = stmt2.executeQuery(sql2);
                ResultSetMetaData meta2 = rs2.getMetaData(); 
                    
                Statement stmt3 = connection.createStatement();
                String sql3 = "SELECT NAME, TYPE, SKIN, DIET, LIFESPAN FROM ANIMALS.ANIMALS WHERE NAME = 'Snake'";
                ResultSet rs3 = stmt3.executeQuery(sql3);
                ResultSetMetaData meta3 = rs3.getMetaData();    
                
                Statement stmt4 = connection.createStatement();
                String sql4 = "SELECT NAME, TYPE, SKIN, DIET, LIFESPAN FROM ANIMALS.ANIMALS WHERE NAME = 'Fish'";
                ResultSet rs4 = stmt4.executeQuery(sql4);
                ResultSetMetaData meta4 = rs4.getMetaData();
                
                Statement stmt5 = connection.createStatement();
                String sql5 = "SELECT NAME, TYPE, SKIN, DIET, LIFESPAN FROM ANIMALS.ANIMALS WHERE NAME = 'Bird'";
                ResultSet rs5 = stmt5.executeQuery(sql5);
                ResultSetMetaData meta5 = rs5.getMetaData();
                
                // input switch for end user choices
            
            switch (input) 
            {
                
                //If end user chooses 0, ends program
                
                case "0":
                    close = true;
                    break;
                    
                //If end user chooses 1, Displays animal characteristics
                    
                case "1":
                    
                    System.out.println("Fetching records with condition...");
                    System.out.println();
                    
                    
                    
                    for(int i = 1; i <= meta2.getColumnCount();i++)
                    {
                        System.out.printf("%-12s", meta2.getColumnName(i));              
                    }
                    System.out.println();
                    System.out.println("_______________________________________________________________________");
                    System.out.println();
                    
                    
                    while(rs2.next()){
                    //Retrieve by column name
                    String name  = rs2.getString("NAME");
                    String type = rs2.getString("TYPE");
                    String skin = rs2.getString("SKIN");
                    String diet = rs2.getString("DIET");
                    String life = rs2.getString("LIFESPAN");

                    //Display values
                        //System.out.printf("%-12s%", name);
                    System.out.printf("%-12s", name);
                    System.out.printf("%-12s", type);
                    System.out.printf("%-12s", skin);
                    System.out.printf("%-12s", diet);
                    System.out.printf("%-12s", life);
                    }
                    System.out.println();
                    break;
                    
                //If end user chooses 2, Displays animal characteristics
                    
                case "2":
                   System.out.println("Fetching records with condition...");
                    System.out.println();
                    
                   
                    
                    for(int i = 1; i <= meta3.getColumnCount();i++)
                    {
                        System.out.printf("%-12s", meta3.getColumnName(i));              
                    }
                    System.out.println();
                    System.out.println("_______________________________________________________________________");
                    System.out.println();
                    
                    
                    while(rs3.next()){
                    //Retrieve by column name
                    String name  = rs3.getString("NAME");
                    String type = rs3.getString("TYPE");
                    String skin = rs3.getString("SKIN");
                    String diet = rs3.getString("DIET");
                    String life = rs3.getString("LIFESPAN");

                    //Display values
                        //System.out.printf("%-12s%", name);
                    System.out.printf("%-12s", name);
                    System.out.printf("%-12s", type);
                    System.out.printf("%-12s", skin);
                    System.out.printf("%-12s", diet);
                    System.out.printf("%-12s", life);
                    }
                    System.out.println();
                    break;
                    
                //If end user chooses 3, Displays animal characteristics
                    
                case "3":
                    System.out.println("Fetching records with condition...");
                    System.out.println();
                    
                   
                    
                    for(int i = 1; i <= meta4.getColumnCount();i++)
                    {
                        System.out.printf("%-12s", meta4.getColumnName(i));              
                    }
                    System.out.println();
                    System.out.println("_______________________________________________________________________");
                    System.out.println();
                    
                    
                    while(rs4.next()){
                    //Retrieve by column name
                    String name  = rs4.getString("NAME");
                    String type = rs4.getString("TYPE");
                    String skin = rs4.getString("SKIN");
                    String diet = rs4.getString("DIET");
                    String life = rs4.getString("LIFESPAN");

                    //Display values
                        //System.out.printf("%-12s%", name);
                    System.out.printf("%-12s", name);
                    System.out.printf("%-12s", type);
                    System.out.printf("%-12s", skin);
                    System.out.printf("%-12s", diet);
                    System.out.printf("%-12s", life);
                    }
                    System.out.println();
                    break;
                
                //If end user chooses 4, Displays animal characteristics
                    
                case "4":
                    System.out.println("Fetching records with condition...");
                    System.out.println();
                    
                   
                    
                    for(int i = 1; i <= meta5.getColumnCount();i++)
                    {
                        System.out.printf("%-12s", meta5.getColumnName(i));              
                    }
                    System.out.println();
                    System.out.println("_______________________________________________________________________");
                    System.out.println();
                    
                    
                    while(rs5.next()){
                    //Retrieve by column name
                    String name  = rs5.getString("NAME");
                    String type = rs5.getString("TYPE");
                    String skin = rs5.getString("SKIN");
                    String diet = rs5.getString("DIET");
                    String life = rs5.getString("LIFESPAN");

                    //Display values
                        //System.out.printf("%-12s%", name);
                    System.out.printf("%-12s", name);
                    System.out.printf("%-12s", type);
                    System.out.printf("%-12s", skin);
                    System.out.printf("%-12s", diet);
                    System.out.printf("%-12s", life);
                    }
                    System.out.println();
                    break;
                    
                
                }
            }
                    
        
        
        // If program can make connection to database throws error.
        
            
        }
        
        catch (SQLException | ClassNotFoundException se)
        {
            se.printStackTrace();
        }

    }
    
}



                
