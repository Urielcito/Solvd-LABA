package MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySql {

    protected Statement st;
    protected ResultSet rs;
    protected String strSQL;

    public MySql() {

        st = JDBC.getInstance().getStatement();
    }

    public void select(String filtro) {
        try {
            rs = st.executeQuery(filtro);
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }

    public void update(String strSQL) throws SQLException{
        try {
            System.out.println(strSQL);
            st.executeUpdate(strSQL);

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }

    public void query(String strSQL) {
        try {
            System.out.println(strSQL);
            st.executeQuery(strSQL);
            rs.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }


}

