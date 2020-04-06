package TableClasses;
import database.offeredHandler;
import database.platformHandler;
import database.companyHandler;
import database.distributorHandler;
import database.gameHandler;

import javax.swing.*;

public class TableSetUp {
    public static JTable makeTable(String s1) {
        JTable table = null;
        switch (s1){
            case ("Game"):
                gameHandler g = new gameHandler();
                table = g.makeTable();
                break;

            case ("Distributor"):
                distributorHandler d = new distributorHandler();
                table = d.makeTable();
                break;

            case ("Company"):
                companyHandler c = new companyHandler();
                table = c.makeTable();
                break;

            case ("Offered"):
                offeredHandler o = new offeredHandler();
                table = o.makeTable();
                break;

            case ("Platform"):
                platformHandler p = new platformHandler();
                table = p.makeTable();
                break;
            default:
                JOptionPane.showMessageDialog(null, "[Illegal State Exception] Illegal string:" + s1);
        }

        return table;
    }
}
