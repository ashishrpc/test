package com.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MyCon {
    public  static void main(String arg[]){
        try{
            Class.forName("org.postgresql.Driver");
            Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","infotech@123");
        	//Class.forName("com.ibm.as400.access.AS400JDBCXADataSource");
        	//Connection con=DriverManager.getConnection("jdbc:as400://204.246.150.24","EMRSYSUSR","m3d#s@9");//jdbc:as400:204.246.150.24;prompt=false
            //
            System.out.println("con.isClosed():"+con.isClosed());
            PreparedStatement ps=con.prepareStatement("select * from tremr.pathistory fetch first row only");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            	System.out.println("Name: "+rs.getString("patientid"));
            }
            ps.close();
            rs.close();
            con.close();
            System.out.println("con.isClosed():"+con.isClosed());
            ps=con.prepareStatement("select * from conpool");
            rs=ps.executeQuery();
            /*while(rs.next()){
            	System.out.println("Name: "+rs.getString("name"));
            }
            	*/
            con=null;
            System.out.println("Success");
        }catch(Exception e){
            System.out.println(e);
        } 
    }
    //public static Connection getConnection(){
        
    //}
    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
        System.out.println("MyCon->finalize()");
    }
    
}
