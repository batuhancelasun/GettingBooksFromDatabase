import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class BookProject {
    static Connection con;

    public static void main(String args[]) {

        con = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://db4free.net/booklist", "batubaba06", "batubaba06");

        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame jframe = new JFrame("Book");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(500, 500);

        JButton btn = new JButton("Search");
        btn.setBounds(30, 60, 100, 29);
        jframe.add(btn);

        JTextField jtf = new JTextField();
        jtf.setBounds(30, 25, 200, 30);
        jframe.add(jtf);

        String bklist[] = { "Book_Number", "Book_Name", "Author" };
        JComboBox cb = new JComboBox(bklist);
        cb.setBounds(250, 25, 200, 30);
        jframe.add(cb);

        JTextArea jta = new JTextArea();
        jta.setBounds(19, 99, 450, 355);
        JScrollPane sc = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jta.setEditable(false);
        jframe.add(jta);
        jframe.add(sc);

        jframe.setLayout(null);
        jframe.setVisible(true);

        btn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent f) {

                String string = (String) cb.getSelectedItem();

                String string1 = jtf.getText();

                if (string == "Book_Number") {
                    try {
                        String query = "SELECT * FROM booklist2013 WHERE `Book_Number` LIKE '%" + string1 + "%'";
                        ResultSet rset = con.createStatement().executeQuery(query);
                        while (rset.next()) {
                            String string2 = String.valueOf(rset.getInt("Book_Number"));
                            String string3 = rset.getString("Book_Name");
                            String string4 = rset.getString("Author");
                            jta.append(string2 + "  " + string3 + "  " + string4 + "\n");

                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                } else if (string == "Book_Name") {
                    try {
                        String query = "SELECT * FROM booklist2013 WHERE `Book_Name` LIKE '%" + string1 + "%'";
                        ResultSet rset = con.createStatement().executeQuery(query);
                        while (rset.next()) {
                            String string2 = String.valueOf(rset.getInt("Book_Number"));
                            String string3 = rset.getString("Book_Name");
                            String string4 = rset.getString("Author");
                            jta.append(string2 + "  " + string3 + "  " + string4 + "\n");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                } else if (string == "Author") {
                    try {
                        String query = "SELECT * FROM booklist2013 WHERE `Author` LIKE '%" + string1 + "%'";
                        ResultSet rset = con.createStatement().executeQuery(query);
                        while (rset.next()) {
                            String string2 = String.valueOf(rset.getInt("Book_Number"));
                            String string3 = rset.getString("Book_Name");
                            String string4 = rset.getString("Author");
                            jta.append(string2 + "  " + string3 + "  " + string4 + "\n");
                        }
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }
}