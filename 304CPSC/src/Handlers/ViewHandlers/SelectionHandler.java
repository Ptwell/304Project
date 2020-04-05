package Handlers.ViewHandlers;
import javax.swing.*;
import java.lang.*;
public class SelectionHandler {
    private final String selection1;
    private final String selection2;
    private final String option;
    private JTable returnTable;

    public SelectionHandler(String selection1, String selection2, String option) {
        this.selection1 = selection1;
        this.selection2 = selection2;
        this.option = option;
    }

    public String getSelection1(){
        return selection1;
    }

    public String getSelection2(){
        return selection2;
    }

    public JTable join(JTable s1, JTable s2) {
        return returnTable;
    }



}
