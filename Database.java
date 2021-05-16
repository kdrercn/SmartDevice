import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static Database instance = null;

    private Database() {
    }

    public static Database getInstance() {
        if (instance == null) {
            synchronized (Database.class) {
                if (instance == null) {
                    instance = new Database();
                }
            }
        }
        return instance;
    }


    static final String url = "jdbc:postgresql:SmartDevice";
    static final String user = "postgres";
    static final String password = "123456";


    private boolean readDatabase(String user_name, String pass_word) {
        java.sql.Connection conn = null;
        Statement stmt = null;
        boolean onay = false;
        try {
            Class.forName("org.postgresql.Driver");


            conn = DriverManager.getConnection(url, user, password);


            stmt = conn.createStatement();
            String sql = "SELECT username, password FROM users";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                String id = rs.getString("username");
                String pass = rs.getString("password");


                if (id.equals(user_name) && pass.equals(pass_word)) {
                    onay = true;
                    break;
                }

            }


            rs.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return onay;
    }


    public boolean veritabaniOku(String user_name, String pass_word) {
        return readDatabase(user_name, pass_word);

    }


}
