
import oracle.jdbc.pool.OracleDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Unit {
    
    public Connection connectOracle() {
         Connection con = null;
       
        try {  
           
            OracleDataSource ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            ods.setUser("c##HappyGrades");
            ods.setPassword("password");
            con = ods.getConnection();
            con.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
          return con;
    }
  
}
