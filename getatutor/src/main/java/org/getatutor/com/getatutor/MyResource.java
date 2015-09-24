package org.getatutor.com.getatutor;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
//import org.json.JSONArray;
//import org.json.JSONObject;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!uhbuyuy";
    }
    
    
    //
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{para}")
    public String getLogin(@PathParam("para") int id) {
    System.out.println("hey");	
    	String output="";
    	try
    	    {
System.out.println("INside try");
    		Class.forName("com.mysql.jdbc.Driver");
    	        Connection conn=null;
    	        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
    	        ResultSet rs,rs1=null;
    	        Statement stm1=conn.createStatement();
    	       String sql="Select StudentName FROM student WHERE StudentID="+id;
    	       //String abc="Select StudentName FROM test WHERE StudentID="+id;
    	        //JSONArray list = new JSONArray();
    	        rs=stm1.executeQuery(sql);
    	        //rs1=stm1.executeQuery(abc);
    	   
    	        while(rs.next())
    	        {
    	           /* JSONObject obj= new JSONObject();
    	            //obj.put("no", rs.getString("id"));
    	            obj.put("name", rs.getString("StudentName"));
    	            //obj.put("dept", rs.getString("department"));
    	            //obj.put("addr", rs.getString("address"));
    	            */
    	        	 output=rs.getString("StudentName");
    	        	System.out.println("name:"+output);
    	           // System.out.println(obj.toString());
    	        }

    	        
    	        //JSONObject obj=new JSONObject();
    	        //obj.put("Name", rs.getString("StudentName"));
    	        
    	       //System.out.println(list);
    	        
    	        
    	    }
    	    catch(Exception ex)
    	    {
    	        System.out.println(ex);
    	    }
    	
        return output;
    }
}