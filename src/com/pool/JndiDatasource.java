package com.pool;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JndiDatasource {

	public static void main(String[] args) {
		//work in J2EE environment JNDI define on web server which have to lookup
		//it will not work in stand alone programe.
		System.out.println(testJndi());
	}


public static Connection testJndi()  {
    try {
        
        /*InitialContext:-
         An InitialContext object is required as the starting context for any naming operations. Other contexts and subcontexts may be created later. Contexts may consist of different implementations according to the needs of the application. All naming operations are performed relative to a context and names are resolved beginning with the initial context.
         
         On successful completion of InitialContext initialization, the service provider implementation will have returned an appropriate Context object which can be used for looking up and manipulating names which may or may not be URL names. InitialContext methods other than those dealing with environments should delegate context operations to that Context object.  
         */
        /*DataSource:-
        An interface for the creation of Connection objects which represent a connection to a database. This interface is an alternative to the java.sql.DriverManager. 
       A class which implements the DataSource interface is typically registered with a JNDI naming service directory and is retrieved from there by name. 
       
       The DataSource interface is typically implemented by the writer of a JDBC driver. There are three variants of the DataSource interface, which produce Connections with differing characteristics: 
       
       Standard DataSource, which produces standard Connection objects with no special features. 
       Connection Pool DataSource, which produces PooledConnection objects which are able to participate in connection pooling, typically involving a connection pooling manager as an intermediary between applications and the database. 
       Distributed transaction DataSource ("XADataSource"), which produces XAConnection objects which can be used to handle distributed transactions and which typically involve a transaction manager component in the system. XAConnection objects also typically provide connection pooling capabilities as well as distributed transaction capabilities. 
       Note that a JDBC driver which is accessed via the DataSource interface is loaded via a JNDI lookup process. A driver loaded in this way does not register itself with the DriverManager.
        * */
        InitialContext context=new InitialContext();
        
        DataSource dataSource=(DataSource)context.lookup("TRDSN");/* lookup("JNDI") : Returns the object(DataSource objects or EJB references) bound to the specified name in this context. If the specified name is empty, a new instance of this context is returned, complete with its own environment properties.*/
        Connection connection= dataSource.getConnection("LOGINID", "PASSWORD");
        return connection;
    }
    catch (Exception e) {
        System.out.println(e);
    }
    return null;
}
}
