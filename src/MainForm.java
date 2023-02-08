import com.aspose.words.Document;
import com.aspose.words.DocumentBuilder;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Arrays;
import java.util.Date;


public class MainForm {
    public void initialize() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://asigurari.accdb");
            System.out.println("Connectat cu succes");

            JFrame Form = new JFrame();

            JButton jbcalc = new JButton("Calculeaza Suma");
            JButton jbintro = new JButton("Salveaza contract");
            JButton jbmodif = new JButton("Modificare contract");
            JButton jbadd = new JButton("Modificare Plata");
            JButton jbprint = new JButton("Printare contract");
            JButton jbverif = new JButton("Verifiacre Plata");

            JLabel jl1 = new JLabel("Nume");
            JLabel jl2 = new JLabel("Prenume");
            JLabel jl3 = new JLabel("Accidente");
            JLabel jl4 = new JLabel("Adresa");
            JLabel jl5 = new JLabel("Mobil");
            JLabel jl6 = new JLabel("Email");
            JLabel jl7 = new JLabel("Data emiterii carnetului");

            JTextField jtf1 = new JTextField();
            JTextField jtf2 = new JTextField();
            JTextField jtf3 = new JTextField();
            JTextField jtf4 = new JTextField();
            JTextField jtf5 = new JTextField();
            JTextField jtf6 = new JTextField();
            ((AbstractDocument) jtf1.getDocument()).setDocumentFilter(new CharFilter());
            ((AbstractDocument) jtf2.getDocument()).setDocumentFilter(new CharFilter());
            ((AbstractDocument) jtf3.getDocument()).setDocumentFilter(new MyIntFilter());
            ((AbstractDocument) jtf5.getDocument()).setDocumentFilter(new MyIntFilter());
            final JTextField text = new JTextField();
            text.setEnabled(false);
            JButton b = new JButton("Selecteaza");
            JPanel p = new JPanel();
            p.setLayout(new GridLayout(1, 2));
            p.add(text);
            p.add(b);
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    text.setText(new DatePicker(Form).setPickedDate());
                }
            });

            JButton jbmodi = new JButton("Modifica Client");
            JButton jbada = new JButton("Adauga Client");

            JPanel jp1 = new JPanel();
            jp1.setLayout(new GridLayout(11, 2, 10, 5));
            jp1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            jp1.add(jl1);
            jp1.add(jtf1);
            jp1.add(jl2);
            jp1.add(jtf2);
            jp1.add(jl3);
            jp1.add(jtf3);
            jp1.add(jl4);
            jp1.add(jtf4);
            jp1.add(jl5);
            jp1.add(jtf5);
            jp1.add(jl6);
            jp1.add(jtf6);
            jp1.add(jl7);
            jp1.add(p);
            jp1.add(jbada);
            jp1.add(jbmodi);
            jp1.add(jbintro);
            jp1.add(jbverif);
            jp1.add(jbmodif);
            jp1.add(jbprint);


            JLabel jla1 = new JLabel("Marca");
            JLabel jla2 = new JLabel("Anul");
            JLabel jla3 = new JLabel("Modelul");
            JLabel jla3a = new JLabel("Vin");
            JLabel jla4 = new JLabel("Capacitate cilindrica");
            JLabel jla5 = new JLabel("Ind.Poluare/ Combustibil");
            JLabel jla6 = new JLabel("Tip riscuri");
            JLabel jla7 = new JLabel("Complectatia");
            JLabel jla8 = new JLabel("Plata");

            String[] carStrings = {"Isuzu", "Daihatsu", "Subaru", "Honda", "Kawasaki (motociclete)", "Mazda", "Mitsubishi", "Nissan", "Suzuki", "Toyota", "Yamaha(motociclete)", "Daewoo", "Hyundai", "Kia", "BYD Auto", "Land Rover", "Jaguar", "MG ROVER", "Lotus Cars", "Autosan", "Wielton", "BOSMAL", "Fiat", "Jelcz", "FSC Lublin", "FSO", "Solaris", "Zasław", "Solbus", "SOMMER", "Epoka", "BWW", "BORO", "Skoda Auto", "Ikarus", "Audi", "Renault", "Peugeot", "Citroën", "SEAT", "Mercedes-Benz", "MAN AG", "MINI", "Porsche", "Opel", "Volkswagen", "Saab", "Volvo Cars", "Alfa Romeo", "Ferrari", "Ford", "Freightliner", "General Motors", "Chevrolet", "Pontiac", "HondaUSA", "Lincoln", "Mercury", "Mack Truck", "Volvo", "TESLA"};
            JComboBox<String> jcbmasini = new JComboBox<>(carStrings);

            String[] aniStrings = {"2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935"};
            JComboBox<String> jcban = new JComboBox<>(aniStrings);

            JTextField jtfa3a = new JTextField();
            JTextField jtfa3 = new JTextField();
            JTextField jtfa4 = new JTextField();
            ((AbstractDocument) jtfa4.getDocument()).setDocumentFilter(new MyIntFilter());

            String[] indiceStrings = {"Euro7", "Euro6", "Euro5", "Euro4", "Euro3", "Euro2"};
            JComboBox<String> jcpolu1 = new JComboBox<>(indiceStrings);

            String[] combustibil = {"Bunzina", "Diesel", "Hybrid", "Electic", "Gpl"};
            JComboBox<String> jcpolu2 = new JComboBox<>(combustibil);

            String[] riscString = {"accident", "cutremur", "incendiu"};
            JComboBox<String> jcrisc = new JComboBox<>(riscString);

            String[] complectatiaString = {"Econom", "Comfort", "Lux"};
            JComboBox<String> jccompl = new JComboBox<>(complectatiaString);

            String[] plataString = {"Anual", "Lunar", "Saptaminal"};
            JComboBox<String> jcplata = new JComboBox<>(plataString);

            JPanel jcpolu = new JPanel();
            jcpolu.setLayout(new GridLayout(1, 2));
            jcpolu.add(jcpolu1);
            jcpolu.add(jcpolu2);

            JPanel jp2 = new JPanel();
            jp2.setLayout(new GridLayout(11, 2, 10, 5));
            jp2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            jp2.add(jla1);
            jp2.add(jcbmasini);
            jp2.add(jla2);
            jp2.add(jcban);
            jp2.add(jla3);
            jp2.add(jtfa3);
            jp2.add(jla3a);
            jp2.add(jtfa3a);
            jp2.add(jla4);
            jp2.add(jtfa4);
            jp2.add(jla5);
            jp2.add(jcpolu);
            jp2.add(jla6);
            jp2.add(jcrisc);
            jp2.add(jla7);
            jp2.add(jccompl);
            jp2.add(jla8);
            jp2.add(jcplata);
            jp2.add(jbcalc);
            jp2.add(jbadd);

            JPanel jpfirst = new JPanel();
            jpfirst.setLayout(new GridLayout(1, 2));
            jpfirst.add(jp2);
            jpfirst.add(jp1);

            jbverif.addActionListener(new ActionListener() {//Verifiacre Plata
                public void actionPerformed(ActionEvent ae) {
                    JFrame f=new JFrame();
                    int idc=Integer.parseInt(JOptionPane.showInputDialog(f,"Introdu id contract"));
                    try {
                        String qwerycontract = "SELECT achitat FROM Contracte WHERE idcontract=?";
                        PreparedStatement statement = conn.prepareStatement(qwerycontract);
                        statement.setInt(1,idc);
                        ResultSet result = statement.executeQuery();
                        while (result.next()){
                            JOptionPane.showMessageDialog(null, result.getString("achitat"));
                        }
                    } catch (Exception e) {
                        System.out.println("Eroare la incarcarea tabelei Contract");
                    }
                }
            });
            jbadd.addActionListener(new ActionListener() {//Adaugare plata
                public void actionPerformed(ActionEvent ae) {
                    JFrame f=new JFrame();
                    int idc=Integer.parseInt(JOptionPane.showInputDialog(f,"Introdu id contract"));
                    try {
                        String qwerycontract = "SELECT achitat FROM Contracte WHERE idcontract=?";
                        PreparedStatement statement = conn.prepareStatement(qwerycontract);
                        statement.setInt(1,idc);
                        ResultSet result = statement.executeQuery();
                        while (result.next()){
                            JOptionPane.showMessageDialog(null, result.getString("achitat")+" | Selectati data noua");
                            String achitare = new DatePicker(Form).setPicker();
                            String qwer = "UPDATE Contracte SET achitat WHERE idcontract=?";
                            PreparedStatement qwrt = conn.prepareStatement(qwer);
                            qwrt.setString(1,achitare);
                            qwrt.close();
                        }
                    } catch (Exception e) {
                        System.out.println("Eroare la incarcarea tabelei Contract");
                    }
                }
            });
            jbcalc.addActionListener(new ActionListener() {//Calculeaza Suma
                public void actionPerformed(ActionEvent ae) {
                    int cm3 = Integer.parseInt(jtfa4.getText());
                    int nraccidente = Integer.parseInt(jtf3.getText());
                    int risc = jcrisc.getSelectedIndex();
                    int anul = Integer.parseInt(jcban.getEditor().getItem().toString());
                    int combustibil = jcpolu2.getSelectedIndex();
                    int poluare = jcpolu1.getSelectedIndex();
                    int complectatia = jccompl.getSelectedIndex();
                    int jplata = jcplata.getSelectedIndex();
                    int plata = 1;
                    if(cm3<1500){
                        plata = cm3*nraccidente*risc*poluare*poluare;
                    } else if (cm3<2500){
                        plata = cm3*nraccidente*risc*poluare*poluare;
                    } else if (cm3<3500) {
                        plata = cm3*nraccidente*risc*poluare*poluare;
                    } else if (cm3>=3500) {
                        plata = cm3*nraccidente*risc*poluare*poluare;
                    }
                    if (jplata == 1){
                        plata = plata - (plata/10);
                    }
                    if (jplata == 2){
                        plata = plata - (plata/20);
                    }

                    //contractul indice client
                    JOptionPane.showMessageDialog(null, "Suma Contractului " + String.valueOf(plata));
                }
            });
            jbada.addActionListener(new ActionListener() {//Adauga Client
                public void actionPerformed(ActionEvent ae) {
                    try {
                        String sqlClient = "INSERT INTO Client (nume, prenume, acidente, adresa, mobil, email, permisconducere) Values (?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement statement = conn.prepareStatement(sqlClient);
                        statement.setString(1, jtf1.getText());
                        statement.setString(2, jtf2.getText());
                        statement.setString(3, jtf3.getText());
                        statement.setString(4, jtf4.getText());
                        statement.setString(5, jtf5.getText());
                        statement.setString(6, jtf6.getText());
                        statement.setString(7, text.getText());
                        int c1 = statement.executeUpdate();
                        if (c1>0) {
                            JOptionPane.showMessageDialog(null, "Datele sau inregistrat");
                        }
                        statement.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Datele nu sau inregistrat");
                    }
                }
            });
            jbmodi.addActionListener(new ActionListener() {//Modifica Client
                public void actionPerformed(ActionEvent ae) {
                    JFrame f=new JFrame();
                    int id=Integer.parseInt(JOptionPane.showInputDialog(f,"Introduceti Id Client"));
                    try {
                        String qweryclient = "SELECT* FROM Client WHERE idclient=?";
                        PreparedStatement intro = conn.prepareStatement(qweryclient);
                        intro.setInt(1,id);
                        ResultSet client = intro.executeQuery();
                        while (client.next()){
                            try {
                                jtf1.setText(client.getString("nume"));
                                jtf2.setText(client.getString("prenume"));
                                jtf3.setText(client.getString("accidente"));
                                jtf4.setText(client.getString("adresa"));
                                jtf5.setText(client.getString("mobil"));
                                jtf6.setText(client.getString("email"));
                                text.setText(client.getString("permisconducere"));
                            }catch (Exception e)
                            {
                                System.out.println("ceva");
                            }
                        intro.close();
                        }
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Nu Exista, Introducetil");
                    }
                }
            });
            jbmodif.addActionListener(new ActionListener() {//Modificare Contract
                public void actionPerformed(ActionEvent ae) {
                    JFrame f=new JFrame();
                    int idc=Integer.parseInt(JOptionPane.showInputDialog(f,"Introdu id contract"));
                    try {
                        String qwerycontract = "SELECT * FROM Contracte WHERE idcontract=?";
                        PreparedStatement statement = conn.prepareStatement(qwerycontract);
                        statement.setInt(1,idc);
                        ResultSet result = statement.executeQuery();
                        while (result.next()){
                            jcbmasini.setSelectedIndex(Arrays.asList(carStrings).indexOf(result.getString("marca")));
                            jcban.setSelectedIndex(Arrays.asList(carStrings).indexOf(result.getString("anul")));
                            jccompl.setSelectedIndex(Arrays.asList(carStrings).indexOf(result.getString("complectatia")));
                            jcplata.setSelectedIndex(Arrays.asList(carStrings).indexOf(result.getString("plata")));
                            jcpolu1.setSelectedIndex(Arrays.asList(carStrings).indexOf(result.getString("indicepoluare")));
                            jcpolu2.setSelectedIndex(Arrays.asList(carStrings).indexOf(result.getString("combustibil")));
                            jcrisc.setSelectedIndex(Arrays.asList(carStrings).indexOf(result.getString("risc")));
                            jtfa3a.setText(result.getString("vin"));
                            jtfa3.setText(result.getString("model"));
                            jtfa4.setText(result.getString("cm3"));
                        }
                        statement.close();
                    } catch (Exception e) {
                        System.out.println("Eroare la incarcarea tabelei Contract");
                    }
                }
            });
            jbprint.addActionListener(new ActionListener() {//printeaza contract
                public void actionPerformed(ActionEvent ae) {
                    try {
                        Document doc = new Document();
                        DocumentBuilder builder = new DocumentBuilder(doc);

                        builder.moveToDocumentStart();
                        builder.writeln("Aici Se poate de completat datele automat");

                        doc.save("Output.docx");


                    } catch (Exception e) {
                        System.out.println("err write docx");
                        throw new RuntimeException(e);
                    }
                }
            });
            jbintro.addActionListener(new ActionListener() {//Salveaza contract
                public void actionPerformed(ActionEvent ae) {
                    try {
                        JOptionPane.showMessageDialog(null, "Selectati data achitaii contractului");
                        String achitare = new DatePicker(Form).setPickedDate();
                        java.util.Date d1 = new Date();
                        String sqlContract = "INSERT INTO Contracte (plata, achitat, vin, idclient, dataintocmirii, marca, anul, model, cm3, indicepoluare, complectatia, combustibil, risc) Values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement statement = conn.prepareStatement(sqlContract);
                        statement.setString(1, jcplata.getEditor().getItem().toString());
                        statement.setString(2, achitare);
                        statement.setString(3, jtfa3a.getText());
                        statement.setInt(4, 1);
                        statement.setString(5, d1.toLocaleString());
                        statement.setString(6, jcbmasini.getEditor().getItem().toString());
                        statement.setString(7, jcban.getEditor().getItem().toString());
                        statement.setString(8, jtfa3.getText());
                        statement.setString(9, jtf5.getText());
                        statement.setString(10, jcpolu1.getEditor().getItem().toString());
                        statement.setString(11, jccompl.getEditor().getItem().toString());
                        statement.setString(12, jcpolu2.getEditor().getItem().toString());
                        statement.setString(13, jcrisc.getEditor().getItem().toString());

                        int c1 = statement.executeUpdate();
                        if (c1 > 0) {
                            JOptionPane.showMessageDialog(null, "Datele sau inregistrat");
                        }
                        statement.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Datele nu sau inregistrat");
                    }
                }
            });

            Form.add(jpfirst);
            Form.setTitle("Asigurari Auto");
            Form.setResizable(false);
            Form.setSize(800, 500);
            Form.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Form.setLocationRelativeTo(null);
            Form.setVisible(true);
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Eroare la conectarea bazei de date");
        }
        finally {

        }


    }
}