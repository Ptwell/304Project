package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Platform;


    /**
     * This class handles all database related transactions
     */
    public class platformHandler {
        // Use this version of the ORACLE_URL if you are running the code off of the server
//	private static final String ORACLE_URL = "jdbc:oracle:thin:@dbhost.students.cs.ubc.ca:1522:stu";
        // Use this version of the ORACLE_URL if you are tunneling into the undergrad servers
        private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";
        private static final String EXCEPTION_TAG = "[EXCEPTION]";
        private static final String WARNING_TAG = "[WARNING]";

        private Connection connection = null;

        public platformHandler() {
            try {
                // Load the Oracle JDBC driver
                // Note that the path could change for new drivers
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            } catch (SQLException e) {
                System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            }
        }

        public void close() {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            }
        }

        public void deletePlatform(String brand) {
            try {
                PreparedStatement ps = connection.prepareStatement("DELETE FROM Platform WHERE Brand = ?");
                ps.setString(1, brand);

                int rowCount = ps.executeUpdate();
                if (rowCount == 0) {
                    System.out.println(WARNING_TAG + " Brand " + brand + " does not exist!");
                }

                connection.commit();

                ps.close();
            } catch (SQLException e) {
                System.out.println(EXCEPTION_TAG + " " + e.getMessage());
                rollbackConnection();
            }
        }

        public void insertBranch(Platform model) {
            try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO branch VALUES (?,?,?)");
                ps.setString(1, model.getBrand());
                ps.setString(2, model.getDeviceType());
                ps.setString(3, model.getControl());
                /*if (model.getPhoneNumber() == 0) {
                    ps.setNull(5, java.sql.Types.INTEGER);
                } else {
                    ps.setInt(5, model.getPhoneNumber());
                }*/

                ps.executeUpdate();
                connection.commit();

                ps.close();
            } catch (SQLException e) {
                System.out.println(EXCEPTION_TAG + " " + e.getMessage());
                rollbackConnection();
            }
        }

        public Platform[] getPlatformInfo() {
            ArrayList<Platform> result = new ArrayList<Platform>();

            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM branch");

//    		// get info on ResultSet
//    		ResultSetMetaData rsmd = rs.getMetaData();
//
//    		System.out.println(" ");
//
//    		// display column names;
//    		for (int i = 0; i < rsmd.getColumnCount(); i++) {
//    			// get column name and print it
//    			System.out.printf("%-15s", rsmd.getColumnName(i + 1));
//    		}

                while(rs.next()) {
                    Platform model = new Platform(rs.getString("platformBrand"),
                            rs.getString("platform_devicetype"),
                            rs.getString("platform_controls"));
                    result.add(model);
                }

                rs.close();
                stmt.close();
            } catch (SQLException e) {
                System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            }

            return result.toArray(new Platform[result.size()]);
        }

        public void updatePlatform(String brand, String devicetype, String controls) {
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE Platfrom SET Hardware/DeviceType = ? , SET Controls = ? WHERE Brand = ?");
                ps.setString(3, brand);
                ps.setString(1, devicetype);
                ps.setString(2, controls);
                int rowCount = ps.executeUpdate();
                if (rowCount == 0) {
                    System.out.println(WARNING_TAG + " Platform " + brand + " does not exist!");
                }

                connection.commit();

                ps.close();
            } catch (SQLException e) {
                System.out.println(EXCEPTION_TAG + " " + e.getMessage());
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

                System.out.println("\nConnected to Oracle!");
                return true;
            } catch (SQLException e) {
                System.out.println(EXCEPTION_TAG + " " + e.getMessage());
                return false;
            }
        }

        private void rollbackConnection() {
            try  {
                connection.rollback();
            } catch (SQLException e) {
                System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            }
        }

        public void databaseSetup() {
            dropBranchTableIfExists();

            try {
                Statement stmt = connection.createStatement();
                stmt.executeUpdate("create_table_Platform(Brand CHAR(20), Hardware/DeviceType CHAR(20), controls CHAR(20), PRIMARY_KEY(Brand, Hardware/DeviceType)");
            } catch (SQLException e) {
                System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            }

           // BranchModel branch1 = new BranchModel("123 Charming Ave", "Vancouver", 1, "First Branch", 1234567);
           // insertBranch(branch1);

            //BranchModel branch2 = new BranchModel("123 Coco Ave", "Vancouver", 2, "Second Branch", 1234568);
            //insertBranch(branch2);
        }

        private void dropBranchTableIfExists() {
            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("select table_name from user_tables");

                while(rs.next()) {
                    if(rs.getString(1).toLowerCase().equals("platform")) {
                        stmt.execute("DROP TABLE Platform");
                        break;
                    }
                }

                rs.close();
                stmt.close();
            } catch (SQLException e) {
                System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            }
        }
}
