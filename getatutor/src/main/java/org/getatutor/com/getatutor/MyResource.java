package org.getatutor.com.getatutor;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.JSONArray;
import org.json.JSONObject;


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
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{para}")
    public JSONArray getLogin(@PathParam("para") int id) {
    System.out.println("hey");	
    	String output="";
    	JSONArray list=null;
    	try
    	    {
System.out.println("INside try");
    		Class.forName("com.mysql.jdbc.Driver");
    	        Connection conn=null;
    	        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
    	        ResultSet rs,rs1=null;
    	        Statement stm1=conn.createStatement();
    	       //String sql="Select StudentName FROM student WHERE StudentID="+id;
    	       String abc="Select * FROM student";
    	         list = new JSONArray();
    	        rs=stm1.executeQuery(abc);
    	        //rs1=stm1.executeQuery(abc);
    	   
    	        while(rs.next())
    	        {
    	            JSONObject obj= new JSONObject();
    	            obj.put("no", rs.getString("StudentID"));
    	            obj.put("name", rs.getString("StudentName"));
    	            System.out.println(obj);
    	            list.put(obj);
    	            //obj.put("dept", rs.getString("department"));
    	            //obj.put("addr", rs.getString("address"));
    	            
    	        	 //output=rs.getString("StudentName");
    	        	//System.out.println("name:"+output);
    	          // System.out.println(obj.toString());
    	       //output=rs.getString("StudentName");  
    	       
    	        }
                 
    	        System.out.println(list);
    	        //JSONObject obj=new JSONObject();
    	        //obj.put("Name", rs.getString("StudentName"));
    	        
    	       //System.out.println(list);
    	        
    	        
    	    }
    	    catch(Exception ex)
    	    {
    	        System.out.println(ex);
    	    }
    	
        return list;
    }
}