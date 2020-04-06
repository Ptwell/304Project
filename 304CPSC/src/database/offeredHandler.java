package database;
import java.sql.*;
import java.util.ArrayList;

import TableClasses.TableSetUp;
import model.Offered;

import javax.swing.*;


public class offeredHandler extends TableSetUp {
    // Use this version of the ORACLE_URL if you are running the code off of the server
//	private static final String ORACLE_URL = "jdbc:oracle:thin:@dbhost.students.cs.ubc.ca:1522:stu";
    // Use this version of the ORACLE_URL if you are tunneling into the undergrad servers
    private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";
    private static final String EXCEPTION_TAG = "[EXCEPTION]";
    private static final String WARNING_TAG = "[WARNING]";
    private String[] columns;
    private JTable table;
    private Connection connection = null;

    public offeredHandler() {
        try {
            // Load the Oracle JDBC driver
            // Note that the path could change for new drivers
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, EXCEPTION_TAG + " " + e.getMessage());
        }
    }
    public JTable makeTable() {
        Object[] data = this.getOfferedInfo();
        table = new JTable((Object[][]) data, columns);
        return table;

    }
    public void deleteBranch(int gameID, String distributorName) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM Offered WHERE GameID = ?, DistributorName = ?");
            ps.setInt(1, gameID);
            ps.setString(2, distributorName);

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                JOptionPane.showMessageDialog(null, WARNING_TAG + " Offered " + gameID + distributorName+" does not exist!");
            }

            connection.commit();

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }
    }

    public void insertOffered(Offered model) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO branch VALUES (?,?,?,?)");
            ps.setInt(1, model.getGameID());
            ps.setString(2, model.getDistributorName());
            ps.setInt(3, model.getPriceGiven());
            ps.setString(4, model.getPublisher());
            /*if (model.getPhoneNumber() == 0) {
                ps.setNull(5, java.sql.Types.INTEGER);
            } else {
                ps.setInt(5, model.getPhoneNumber());
            }*/

            ps.executeUpdate();
            connection.commit();

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }
    }

    public Offered[] getOfferedInfo() {
        ArrayList<Offered> result = new ArrayList<Offered>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Offered");

//    		// get info on ResultSet
            ResultSetMetaData rsmd = rs.getMetaData();
//
//    		JOptionPane.showMessageDialog(null, " ");
//
            // display column names;
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                // get column name and print it
                columns[i] =  rsmd.getColumnName(i + 1);
            }

            while(rs.next()) {
                Offered model = new Offered(rs.getInt("GameID"),
                        rs.getString("distributorName"),
                        rs.getInt("priceGiven"),
                        rs.getString("publisher"));
                result.add(model);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, EXCEPTION_TAG + " " + e.getMessage());
        }

        return result.toArray(new Offered[result.size()]);
    }

    public void updateOffered(int gameId, String distributorNname, int priceGiven, String publisher) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE Offered SET PriceGiven = ?, Publisher = ?  WHERE GameID = ?, DistributorName = ?");
            ps.setString(2, publisher);
            ps.setInt(1, priceGiven);
            ps.setString(4, distributorNname);
            ps.setInt(3, gameId);

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                JOptionPane.showMessageDialog(null, WARNING_TAG + " Offered " + gameId + distributorNname +" does not exist!");
            }

            connection.commit();

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }
    }

    public boolean login(String username, String password) {
        try {
            if (connection != null) {
                connection.close();
            }

            connection = DriverManager.getConnection(ORACLE_URL, username, password);
            connection.setAutoCommit(false);

            JOptionPane.showMessageDialog(null, "\nConnected to Oracle!");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, EXCEPTION_TAG + " " + e.getMessage());
            return false;
        }
    }

    private void rollbackConnection() {
        try  {
            connection.rollback();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    public void databaseSetup() {
        dropBranchTableIfExists();

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("create_table_Offered(GameID INTEGER, DiName(20), Price_Given INTEGER, publisher CHAR(20), " +
                    "PRIMARY_KEY(GameID, DiName), FOREIGN_KEY(GameID) reference from Game(GameID) ON DELETE CASCADE, ON UPDATE CASCADE," +
                    " FOREIGN_KEY(DiName) reference from Distributor(DiName), ON DELETE CASCADE, ON UPDATE CASCADE ");

            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, EXCEPTION_TAG + " " + e.getMessage());
        }

        //BranchModel branch1 = new BranchModel("123 Charming Ave", "Vancouver", 1, "First Branch", 1234567);
        //insertBranch(branch1);

       // BranchModel branch2 = new BranchModel("123 Coco Ave", "Vancouver", 2, "Second Branch", 1234568);
       // insertBranch(branch2);
    }

    private void dropBranchTableIfExists() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select table_name from user_tables");

            while(rs.next()) {
                if(rs.getString(1).toLowerCase().equals("offered")) {
                    stmt.execute("DROP TABLE Offered");
                    break;
                }
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, EXCEPTION_TAG + " " + e.getMessage());
        }
    }
}
