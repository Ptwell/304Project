package database;
import java.sql.*;
import java.util.ArrayList;

import TableClasses.TableSetUp;
import model.Company;

import javax.swing.*;

public class companyHandler extends TableSetUp {
    // Use this version of the ORACLE_URL if you are running the code off of the server
//	private static final String ORACLE_URL = "jdbc:oracle:thin:@dbhost.students.cs.ubc.ca:1522:stu";
    // Use this version of the ORACLE_URL if you are tunneling into the undergrad servers
    private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";
    private static final String EXCEPTION_TAG = "[EXCEPTION]";
    private static final String WARNING_TAG = "[WARNING]";
    private String[] columns;
    private JTable table;

    private Connection connection = null;

    public companyHandler() {
        try {
            // Load the Oracle JDBC driver
            // Note that the path could change for new drivers
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    public JTable makeTable() {
        Object[] data = this.getCompanyInfo();
        table = new JTable((Object[][]) data, columns);
        return table;

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

    public void deleteCompany(String name) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM Company WHERE CompanyName = ?");
            ps.setString(1, name);

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                JOptionPane.showMessageDialog(null, WARNING_TAG + " Company " + name + " does not exist!");
            }

            connection.commit();

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }
    }

    public void insertBranch(Company model) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO branch VALUES (?,?)");
            ps.setString(1, model.getCompanyName());
            ps.setString(2, model.getLocation());



            ps.executeUpdate();
            connection.commit();

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }
    }

    public Company[] getCompanyInfo() {
        ArrayList<Company> result = new ArrayList<Company>();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Company");

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
                Company model = new Company(rs.getString("CompanyName"),
                        rs.getString("Location"));

                result.add(model);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, EXCEPTION_TAG + " " + e.getMessage());
        }

        return result.toArray(new Company[result.size()]);
    }

    public void updateCompany(String location, String name) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE branch SET Location = ? WHERE CompanyName = ?");
            ps.setString(1, location);
            ps.setString(2, name);

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                JOptionPane.showMessageDialog(null, WARNING_TAG + " Company " + name + " does not exist!");
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
            stmt.executeUpdate("CREATE TABLE (Cname CHAR(20), Location CHAR(20), PRIMARY KEY(Cname))");
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, EXCEPTION_TAG + " " + e.getMessage());
        }


    }

    private void dropBranchTableIfExists() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select table_name from user_tables");

            while(rs.next()) {
                if(rs.getString(1).toLowerCase().equals("company")) {
                    stmt.execute("DROP TABLE Company");
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
