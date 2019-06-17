import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Test {
	static DBConnection conn = new DBConnection();
	
	public static void main(String[] args) {
		
		
		
		StatisticsKeyword("","");
		
		
		
		
		
		
		if(conn != null) {
			conn.close();
			System.out.println("연결종료됨");
		}
		
		
		
	}
	
	
	
	
	
	static String StatisticsKeyword(String exTable, String date){
		
    	String result = "";
    	Statement stmt = null;
    	PreparedStatement pstmt = null;
    	
        ResultSet rs = null;
        StringBuffer sb = null;
        
        
        try{
        	stmt = conn.createStatement();
        	
        	
        		

    		sb = new StringBuffer();
    		sb.append(" SELECT SG_SEQ FROM SITE_GROUP	\n");
        	rs = stmt.executeQuery(sb.toString());
        	rs.last();
        	String[] arSgCode = new String[rs.getRow()];
        	rs.beforeFirst();
        	int idx = 0;
        	while(rs.next()){
        		arSgCode[idx++] = rs.getString("SG_SEQ");
        		System.out.println(rs.getString("SG_SEQ"));
        	}
        	
        		
            	
        		        		
        
        } catch(Exception ex) {
        	ex.printStackTrace();
			System.exit(1);
			
        } finally {
        	sb = null;
            if (rs != null) try { rs.close(); rs = null;} catch(SQLException ex) {}
            if (stmt != null) try { stmt.close(); stmt = null;} catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); pstmt = null;} catch(SQLException ex) {}
        }
        
        return result;
    }
}
