package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Distributor;

import javax.swing.*;

public class distributorHandler {
    // Use this version of the ORACLE_URL if you are running the code off of the server
//	private static final String ORACLE_URL = "jdbc:oracle:thin:@dbhost.students.cs.ubc.ca:1522:stu";
    // Use this version of the ORACLE_URL if you are tunneling into the undergrad servers
    private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";
    private static final String EXCEPTION_TAG = "[EXCEPTION]";
    private static final String WARNING_TAG = "[WARNING]";

    private Connection connection = null;

    public distributorHandler() {
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

    public void deleteDistributor(String distributorName) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM Distributor WHERE distributorName = ?");
            ps.setString(1, distributorName);

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                JOptionPane.showMessageDialog(null, WARNING_TAG + " distributor " + distributorName + " does not exist!");
            }

            connection.commit();

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }
    }

    public void insertBranch(Distributor model) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO branch VALUES (?,?)");
            ps.setString(1, model.getDistributorName());
            ps.setString(2, model.getPaymentMethod());
           /* if (model.getPhoneNumber() == 0) {
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

    public Distributor[] getDistributorInfo() {
        ArrayList<Distributor> result = new ArrayList<Distributor>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM branch");

//    		// get info on ResultSet
//    		ResultSetMetaData rsmd = rs.getMetaData();
//
//    		JOptionPane.showMessageDialog(null, " ");
//
//    		// display column names;
//    		for (int i = 0; i < rsmd.getColumnCount(); i++) {
//    			// get column name and print it
//    			System.out.printf("%-15s", rsmd.getColumnName(i + 1));
//    		}

            while(rs.next()) {
                Distributor model = new Distributor(rs.getString("distributorName"),
                        rs.getString("paymentMethod"));
                result.add(model);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, EXCEPTION_TAG + " " + e.getMessage());
        }

        return result.toArray(new Distributor[result.size()]);
    }

    public void updateDistributor(String name, String paymentMethod) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE branch SET paymentMethod = ? WHERE name = ?");
            ps.setString(2, name);
            ps.setString(1, paymentMethod);

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                JOptionPane.showMessageDialog(null, WARNING_TAG + " Distributor " + name + " does not exist!");
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
            stmt.executeUpdate("CREATE TABLE Distributor(DiName CHAR(20), PaymentMethod CHAR (20), PRIMARY_KEY(DiName));");
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, EXCEPTION_TAG + " " + e.getMessage());
        }

       // BranchModel branch1 = new BranchModel("123 Charming Ave", "Vancouver", 1, "First Branch", 1234567);
       // insertBranch(branch1);

       // BranchModel branch2 = new BranchModel("123 Coco Ave", "Vancouver", 2, "Second Branch", 1234568);
       // insertBranch(branch2);
    }

    private void dropBranchTableIfExists() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select table_name from user_tables");

            while(rs.next()) {
                if(rs.getString(1).toLowerCase().equals("distributor")) {
                    stmt.execute("DROP TABLE Distributor");
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
