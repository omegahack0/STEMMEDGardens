package com.tutorialtwo.tutorialtwo.sqldbconnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLDBConnection {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) {
        String connectionUrl =
        		//remote sql server
                //"jdbc:sqlserver://yourserver.database.windows.net:1433;"
        		
        		//local sql server on default port 1433
                "jdbc:sqlserver://localhost:1433;"
                        + "database=stemmeddb;"
                        + "user=user3;"
                        + "password=Blue;"
                        //+ "encrypt=true;"
                        //+ "trustServerCertificate=false;"
                        + "loginTimeout=30;";
        
        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl); 
        Statement statement = connection.createStatement();) {
            // Code here.
        	        	
        	        	
        	String CreateTablePersons = "CREATE TABLE Persons ("
        			+ "PersonID int,"
        			+ "LastName varchar(50),"
        			+ "FirstName varchar(50),"
        			+ "Address varchar(50),"
        			+ "City varchar(50),"
        			+ "ZipCode varchar(5)"
        			+ ");";
	      	//statement.executeUpdate(CreateTablePersons);
        	
        	
        	
        	String CreateTableTomato = "CREATE TABLE Tomato ("
        			+ "TomatoID int NOT NULL PRIMARY KEY,"
        			+ "TomatoCommonName varchar(50) NOT NULL,"
        			+ "TomatoSpecies varchar(50),"
        			+ "FruitBearing varchar(25),"
        			+ "Type varchar(25),"
        			+ "Sun varchar(25),"
        			+ "Spread varchar(25),"
        			+ "FruitWeight varchar(25),"
        			+ "DaysToMaturity varchar(255)"
        			+ ");";
        	statement.executeUpdate(CreateTableTomato);

        	
        	String SelectAllFromPersons = "SELECT * FROM Persons";
        	//statement.executeUpdate(SelectAllFromPersons);
        	
        	String SQLInsert = "INSERT INTO Persons (PersonID, LastName, FirstName) VALUES ('1', 'Garcia', 'Eli');";
        	//statement.executeUpdate(SQLInsert);
        	String SQLInsert2 = "INSERT INTO Persons (PersonID, LastName, FirstName) VALUES ('2', 'Alonge', 'Michael');";
        	String SQLInsert3 = "INSERT INTO Persons (PersonID, LastName, FirstName) VALUES ('2', 'Alonge', 'Michael');";
        	//statement.executeUpdate(SQLInsert3);
        	        	 
        	
        	
        	// view the table data
        	
        	/*ResultSet rs = statement.executeQuery("SELECT * FROM Persons");
        	System.out.println("personID  LastName  FirstName");
        	
        	while (rs.next()) {
                int personID = rs.getInt("personID");
                String LastName = rs.getString("LastName");
                String FirstName = rs.getString("FirstName");
                System.out.println(personID+"   "+LastName+"    "+FirstName);*/
                
                
            ResultSet rs2 = statement.executeQuery("SELECT * FROM Tomato");
        	System.out.println("TomatoID  TomatoCommonName  TomatoSpecies   FruitBearing   Type  Sun  Spread   FruitWeight   DaysToMaturity");
        	
        	while (rs2.next()) {
                int TomatoID = rs2.getInt("TomatoID");
                String TomatoCommonName = rs2.getString("TomatoCommonName");
                String TomatoSpecies = rs2.getString("TomatoSpecies");
                String FruitBearing = rs2.getString("FruitBearing");
                String Type = rs2.getString("Type");
                String Sun = rs2.getString("Sun");
                String Spread = rs2.getString("Spread");
                String FruitWeight = rs2.getString("FruitWeight");
                String DaysToMaturity = rs2.getString("DaysToMaturity");
                System.out.println(TomatoID+"   "+TomatoCommonName+"    "+TomatoSpecies+"    "+FruitBearing+"    "+Type+"    "+Sun+"    "+Spread+"    "+FruitWeight+"    "+DaysToMaturity);
        	}
        	
        	
        }
        
        
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        
    }
}