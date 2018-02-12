package com.pool;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class MyCon {
    public  static void main(String arg[]){
    	getDBCPConnection();  
    }

    public static void getDBCPConnection(){
    	System.out.println("getDBCPConnection");
    	Connection con=null;
    	try{
    	con=DataSource.getInstance().getConnection();
    	System.out.println(con.isClosed());
    	con.close();
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}finally{
    		
    	}
    }
    
    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
        System.out.println("MyCon->finalize()");
    }
    
    public static void myConnection(){
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
}

////Singleton class
class DataSource {

    private static DataSource  datasource;
    private BasicDataSource ds;

    private DataSource() throws IOException, SQLException, PropertyVetoException {
        ds = new BasicDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUsername("postgres");
        ds.setPassword("infotech@123");
        ds.setUrl("jdbc:postgresql://localhost:5432/postgres");
       
     // the settings below are optional -- dbcp can work with defaults
        ds.setMinIdle(5);
        ds.setMaxIdle(20);
        ds.setMaxOpenPreparedStatements(180);

    }

    public static DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) {
            datasource = new DataSource();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }

}



