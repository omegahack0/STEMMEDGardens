package com.tutorialtwo.tutorialtwo.images;


import java.sql.*;
import java.io.*;
 
public class saveImage 
{
        public static void main(String[] args) 
        {
                DB db = new DB();
                Connection conn=db.dbConnect(
                  "jdbc:sqlserver://localhost:1433;database=stemmeddb","user3","Blue");
                db.insertImage(conn,"C:\\Users\\eliu\\eclipse-workspace\\Stemmed\\TImage1.png");
                db.getImageData(conn);
        } 
}
 
class DB
{
        public DB() {}
 
        public Connection dbConnect(String db_connect_string,
           String db_userid, String db_password)
        {
                try
                {
                        //Class.forName("net.sourceforge.jtds.jdbc.Driver");
                		////Class.forName("net.sourceforge.jdbc.Driver");
                        Connection conn = DriverManager.getConnection(
                          db_connect_string, db_userid, db_password);
 
                        System.out.println("connected");
                        return conn;
                         
                }
                catch (Exception e)
                {
                        e.printStackTrace();
                        return null;
                }
        }
 
        public void insertImage(Connection conn,String img)
        {
                int len;
                String query;
                PreparedStatement pstmt;
                 
                try
                {
                        File file = new File(img);
                        FileInputStream fis = new FileInputStream(file);
                        len = (int)file.length();
 
                        query = ("insert into TableImages VALUES(?,?,?)");
                        pstmt = conn.prepareStatement(query);
                        pstmt.setString(1,file.getName());
                        pstmt.setInt(2, len);
   
                        // Method used to insert a stream of bytes
                        pstmt.setBinaryStream(3, fis, len); 
                        pstmt.executeUpdate();
 
                }
                catch (Exception e)
                {
                        e.printStackTrace();
                }
        }
 
        public void getImageData(Connection conn)
        {
                 
                 byte[] fileBytes;
                 String query;
                 try
                 {
                         query = "select image from TableImages";
                         Statement state = conn.createStatement();
                         ResultSet rs = state.executeQuery(query);
                         if (rs.next())
                        {
                                  fileBytes = rs.getBytes(1);
                                  OutputStream targetFile=  
                                  new FileOutputStream(
                                       "/new1.png");
 
                                  targetFile.write(fileBytes);
                                  targetFile.close();
                        }        
                         
                 }
                 catch (Exception e)
                 {
                         e.printStackTrace();
                 }
        }
};
