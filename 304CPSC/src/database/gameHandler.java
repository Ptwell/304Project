package database;

import java.sql.*;
import java.util.ArrayList;

import TableClasses.TableSetUp;
import model.Game;

import javax.swing.*;

public class gameHandler extends TableSetUp {
    private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";
    private static final String EXCEPTION_TAG = "[EXCEPTION]";
    private static final String WARNING_TAG = "[WARNING]";
    private String[] columns;
    private JTable table;

    private Connection connection = null;
    public gameHandler() {
        try {
            // Load the Oracle JDBC driver
            // Note that the path could change for new drivers
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, EXCEPTION_TAG + " " + e.getMessage());
        }
    }


    public JTable makeTable() {
        Object[] data = this.getGameInfo();
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

    public void deleteGame(int gamID) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM Game WHERE GameID = ?");
            ps.setInt(1, gamID);

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                JOptionPane.showMessageDialog(null, WARNING_TAG + " game " + gamID + " does not exist!");
            }

            connection.commit();

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }
    }

    public void insertGame(Game model) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Game VALUES (?,?)");
            ps.setInt(1, model.getGameID());
            ps.setString(2, model.getGameName());

            /*if (model.getPhoneNumber() == 0) {
                ps.setNull(5, java.sql.Types.INTEGER);
            } else {
                ps.setInt(5, model.getPhoneNumber());
            }**/

            ps.executeUpdate();
            connection.commit();

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }
    }

    public Game[] getGameInfo() {
        ArrayList<Game> result = new ArrayList<Game>();

        try {
            connection = DriverManager.getConnection(ORACLE_URL, "ora_peterle", "a21320163");
          //  connection.setAutoCommit(false);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Game");

////    		// get info on ResultSet
//    		ResultSetMetaData rsmd = rs.getMetaData();
////
////    		JOptionPane.showMessageDialog(null, " ");
////
//    		// display column names;
//            int cc = rsmd.getColumnCount();
//            columns = new String[cc];
            columns = new String[]{"gameID", "gameName"};

//    		for (int i = 0; i < cc; i++) {
//    			// get column name and print it
//    			columns[i] =  rsmd.getColumnName(i + 1);
//    			rsmd.get
//    		}

            while(rs.next()) {
                Game model = new Game(rs.getInt("gameID"),
                        rs.getString("gameName"));

                result.add(model);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, EXCEPTION_TAG + " " + e.getMessage());
        }

        return result.toArray(new Game[result.size()]);
    }

    public void updateGame(int id, String name) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE Game SET GameName = ? WHERE GameID = ?");
            ps.setString(1, name);
            ps.setInt(2, id);

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                JOptionPane.showMessageDialog(null, WARNING_TAG + " GAME " + id + " does not exist!");
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
//
//                PreparedStatement ps = connection.prepareStatement("start databaseGames.sql");
//                connection.commit();
//                ps.executeUpdate();
//                ps = connection.prepareStatement("start populate_games.sql");
//                connection.commit();
//                ps.executeUpdate();
//                ps.close();

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
            stmt.executeUpdate("create_table_Game(GameID INTEGER(20), GName CHAR(20), PRIMARY_KEY(GameID));");
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, EXCEPTION_TAG + " " + e.getMessage());
        }

        //*BranchModel branch1 = new BranchModel("123 Charming Ave", "Vancouver", 1, "First Branch", 1234567);
        //insertBranch(branch1);

       // BranchModel branch2 = new BranchModel("123 Coco Ave", "Vancouver", 2, "Second Branch", 1234568);
       // insertBranch(branch2);
    }

    private void dropBranchTableIfExists() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select table_name from user_tables");

            while(rs.next()) {
                if(rs.getString(1).toLowerCase().equals("game")) {
                    stmt.execute("DROP TABLE Game");
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
