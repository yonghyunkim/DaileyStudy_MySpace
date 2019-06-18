import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;


public class Test2 extends DBConnection implements ExampleInterface{
	static DBConnection conn = null;
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		String aa ="";
		
		
		ArrayList list = new ArrayList();
		
		for(int i = 0; i < 20; i++) {
			int randomInt = (int)(Math.random() *10);
			
			list.add(randomInt);
			
			
		}
		
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i+" :::::::::::::::::::  "+list.get(i));
			
			
			
		}
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		Collections.sort(list);
		
		
		
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i+" :::::::::::::::::::  "+list.get(i));
			
			
			
		}
		
		
	}
	
	
	
	
	
	static String StatisticsKeyword(String exTable, String date){
		
    	String result = "";
    	Statement stmt = null;
    	PreparedStatement pstmt = null;
    	
        ResultSet rs = null;
        StringBuffer sb = null;
        
        JSONArray jsonArr = new JSONArray();
        JSONObject jsonObj = null; 
        
        try{
        	stmt = conn.createStatement();
        	
        	
        	
        		

    		sb = new StringBuffer();
    		sb.append(" SELECT SG_SEQ, DATE_FORMAT(SG_REGDATE,'%Y%m%d') AS SG_REGDATE, SG_NAME FROM SITE_GROUP	\n");
        	rs = stmt.executeQuery(sb.toString());
        	rs.last();
        	String[] arSgCode = new String[rs.getRow()];
        	rs.beforeFirst();
        	
        	int idx = 0;
        	
        	/*while(rs.next()){
        		arSgCode[idx++] = rs.getString("SG_SEQ");
        		System.out.println(rs.getString("SG_SEQ"));
        		System.out.println(rs.getMetaData().getColumnName(rs.getMetaData().getColumnCount()));
        	}*/
        	
        	ResultSetMetaData mda =  rs.getMetaData();
        	
        	while(rs.next()) {
        		jsonObj = new JSONObject();
        		for(int i = 1; i <= mda.getColumnCount(); i++) {
        			
        			//jsonObj.put(rs.getMetaData().getColumnLabel(i), rs.getString(i));
        			jsonObj.put(mda.getColumnName(i), rs.getString(i));
        		}
        		
        		jsonArr.put(jsonObj);
        		
        	}
        		
            System.out.println(jsonArr.toString());
        		        		
        
        } catch(Exception ex) {
        	System.out.println("catch문");
        	ex.printStackTrace();
        	ex.getMessage();
			System.exit(1);
			
        } finally {
        	sb = null;
            if (rs != null) try { rs.close(); rs = null;} catch(SQLException ex) {}
            if (stmt != null) try { stmt.close(); stmt = null;} catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); pstmt = null;} catch(SQLException ex) {}
        }
        
        return result;
    }
	
	
	
	
	
static String StatisticsKeyword2(String exTable, String date){
		
    	String result = "";
    	Statement stmt = null;
    	PreparedStatement pstmt = null;
    	
        ResultSet rs = null;
        StringBuffer sb = null;
        
        ArrayList list = new ArrayList();
        
        HashMap map = null; 
        
        try{
        	stmt = conn.createStatement();
        	
        	
        	
        		

    		sb = new StringBuffer();
    		sb.append(" SELECT SG_SEQ, DATE_FORMAT(SG_REGDATE,'%Y%m%d') AS SG_REGDATE, SG_NAME FROM SITE_GROUP	\n");
        	rs = stmt.executeQuery(sb.toString());
        	rs.last();
        	String[] arSgCode = new String[rs.getRow()];
        	rs.beforeFirst();
        	
        	int idx = 0;
        	
        	/*while(rs.next()){
        		arSgCode[idx++] = rs.getString("SG_SEQ");
        		System.out.println(rs.getString("SG_SEQ"));
        		System.out.println(rs.getMetaData().getColumnName(rs.getMetaData().getColumnCount()));
        	}*/
        	
        	ResultSetMetaData mda =  rs.getMetaData();
        	
        	while(rs.next()) {
        		map = new HashMap();
        		for(int i = 1; i <= mda.getColumnCount(); i++) {
        			
        			//jsonObj.put(rs.getMetaData().getColumnLabel(i), rs.getString(i));
        			map.put(mda.getColumnName(i), rs.getString(i));
        		}
        		
        		list.add(map);
        		
        	}
        		
            for(int i = 0; i < list.size(); i++) {
            	map = (HashMap)list.get(i);
            	Iterator iter = map.keySet().iterator();
            	while(iter.hasNext()) {
            		String key = iter.next().toString();
            		System.out.println(key);
            		System.out.println(map.get(key));
            		
            	}
            	
            	
            }
        		        		
        
        } catch(Exception ex) {
        	System.out.println("catch문");
        	ex.printStackTrace();
        	ex.getMessage();
			System.exit(1);
			
        } finally {
        	sb = null;
            if (rs != null) try { rs.close(); rs = null;} catch(SQLException ex) {}
            if (stmt != null) try { stmt.close(); stmt = null;} catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); pstmt = null;} catch(SQLException ex) {}
        }
        
        return result;
    }




	@Override
	public void close2() {
		// TODO 자동 생성된 메소드 스텁
		
	}



}
