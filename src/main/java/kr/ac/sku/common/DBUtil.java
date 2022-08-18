package kr.ac.sku.common;
//DB접속
import java.sql.*;

public class DBUtil {
    //접속
    public static Connection getConnection() throws Exception{
        Connection conn = null;                      //접속

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://127.0.0.1:3306/skudb";
        String user = "sku";
        String password = "0000";

        conn = DriverManager.getConnection(url, user, password);

        return conn;
    }
    //종료
    public static void close(Connection conn , PreparedStatement ps, ResultSet rs){
        if(rs != null) {
            try {
                rs.close();                         //핵심코드
            } catch (SQLException e) {              //null이면 실행x
                e.printStackTrace();
            }
        }
       close(conn, ps);
    }
    public static void close(Connection conn, PreparedStatement ps){
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}