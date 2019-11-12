/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.TravelAgency;

import Business.TravelAgency.Booking;
import Business.TravelAgency.BookingDirectory;
import Business.Customer.CustomerDirectory;
import Business.Flights.Flight;
import Business.Flights.FlightDirectory;
import Business.Customer.Passenger;
import Business.TravelAgency.Seat;
import java.awt.CardLayout;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shriya22
 */
public class CreatePassengerdetails extends javax.swing.JPanel {

    /**
     * Creates new form CreatePassengerdetails
     */
    private FlightDirectory fltDir;
    private JPanel rightPanel;
    private Flight flight;
    private Booking booking;
    private BookingDirectory bookDir;
    private ArrayList<Passenger> pList;
    private int travellerCount;
    private CustomerDirectory custDir;
    private Passenger passenger;
    private ArrayList<Passenger> custList;

    CreatePassengerdetails(JPanel rightPanel, Flight flight, Booking booking, BookingDirectory bookDir, int travellerCount, FlightDirectory fltDir, CustomerDirectory custDir) {
        initComponents();
        pList = new ArrayList<>();
        custList = custDir.getCustomerList();
        this.rightPanel = rightPanel;
        this.flight = flight;
        this.booking = booking;
        this.bookDir = bookDir;
        this.fltDir = fltDir;
        this.custDir = custDir;
        this.passenger = passenger;
        this.travellerCount = travellerCount;
        lblP1.setVisible(false);
        lblP1name.setVisible(false);
        lblP1age.setVisible(false);
        txtP1Age.setVisible(false);
        lblP2.setVisible(false);
        lblP2name.setVisible(false);
        lblP2age.setVisible(false);
        txtP2Age.setVisible(false);
        lblP3.setVisible(false);
        lblP3name.setVisible(false);
        lblP3age.setVisible(false);
        txtP3Age.setVisible(false);
        jCnameP1.setVisible(false);
        jCnameP2.setVisible(false);
        jCnameP3.setVisible(false);
        txtP1Age.setEditable(false);
        txtP2Age.setEditable(false);
        txtP3Age.setEditable(false);
        populateFlightDetails();

    }

    private void populateFlightDetails() {
        populateSeats();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        txtFlightName.setText(flight.getFlAirlinerName());
        txtSource.setText(flight.getFlFromLoc());
        txtDestination.setText(flight.getFlToLoc());
        txtFlNumber.setText(String.valueOf(flight.getFlNumber()));
        txtDate.setText(s.format(flight.getFlDate()));
        txtFTravellerNumber.setText(String.valueOf(travellerCount));
        txtTCost.setText(String.valueOf(travellerCount * flight.getFlCost()));
        if (txtFTravellerNumber.getText().equals("1")) {
            lblP1.setVisible(true);
            lblP1name.setVisible(true);
            lblP1age.setVisible(true);
            txtP1Age.setVisible(true);
            jCnameP1.setVisible(true);
            populateP1name();
        }

        if (txtFTravellerNumber.getText().equals("2")) {
            lblP1.setVisible(true);
            lblP1name.setVisible(true);
            lblP1age.setVisible(true);
            txtP1Age.setVisible(true);
            lblP2.setVisible(true);
            lblP2name.setVisible(true);
            lblP2age.setVisible(true);
            txtP2Age.setVisible(true);
            jCnameP1.setVisible(true);
            jCnameP2.setVisible(true);
            populateP1name();
            populateP2name();
        }

        if (txtFTravellerNumber.getText().equals("3")) {
            lblP1.setVisible(true);
            lblP1name.setVisible(true);
            lblP1age.setVisible(true);
            txtP1Age.setVisible(true);
            lblP2.setVisible(true);
            lblP2name.setVisible(true);
            lblP2age.setVisible(true);
            txtP2Age.setVisible(true);
            lblP3.setVisible(true);
            lblP3name.setVisible(true);
            lblP3age.setVisible(true);
            txtP3Age.setVisible(true);
            jCnameP1.setVisible(true);
            jCnameP2.setVisible(true);
            jCnameP3.setVisible(true);
            populateP1name();
            populateP2name();
            populateP3name();
        }
    }

    public void populateSeats() {
        DefaultTableModel dtm = (DefaultTableModel) tblSeats.getModel();
        dtm.setRowCount(0);

        for (Seat s : flight.getFlSeatDir().getSeatDir()) {
            if (!s.getSeatAvailable()) {
                Object[] row = new Object[dtm.getColumnCount()];
                row[0] = s;
                row[2] = s.getSeatAvailable();
                row[1] = s.getSeatType();
                dtm.addRow(row);
            }
        }
    }

    private void populateP1name() {
        ArrayList<Passenger> passengers = custDir.getCustomerList();
        ArrayList<String> duplicateList = new ArrayList<String>();
        for (Passenger p : passengers) {
            if (!duplicateList.contains(p.getName())) {
                duplicateList.add(p.getName());
            }
        }
        DefaultComboBoxModel dml = new DefaultComboBoxModel();
        for (String p1 : duplicateList) {
            dml.addElement(p1);
            jCnameP1.setModel(dml);
            populateAge1(String.valueOf(jCnameP1.getSelectedItem()));
        }
    }

    private void populateP2name() {
        ArrayList<Passenger> passengers = custDir.getCustomerList();
        ArrayList<String> duplicateList = new ArrayList<String>();
        for (Passenger p : passengers) {
            if (!duplicateList.contains(p.getName())) {
                duplicateList.add(p.getName());
            }
        }
        DefaultComboBoxModel dml = new DefaultComboBoxModel();
        for (String p1 : duplicateList) {
            dml.addElement(p1);
            jCnameP2.setModel(dml);
            populateAge2(String.valueOf(jCnameP2.getSelectedItem()));
        }
    }

    private void populateP3name() {
        ArrayList<Passenger> passengers = custDir.getCustomerList();
        ArrayList<String> duplicateList = new ArrayList<String>();
        for (Passenger p : passengers) {
            if (!duplicateList.contains(p.getName())) {
                duplicateList.add(p.getName());
            }
        }
        DefaultComboBoxModel dml = new DefaultComboBoxModel();
        for (String p1 : duplicateList) {
            dml.addElement(p1);
            jCnameP3.setModel(dml);
            populateAge3(String.valueOf(jCnameP3.getSelectedItem()));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblFlName = new javax.swing.JLabel();
        txtFlightName = new javax.swing.JTextField();
        lblDate = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        lblFlNumber = new javax.swing.JLabel();
        lblNoOfTravellers = new javax.swing.JLabel();
        txtFlNumber = new javax.swing.JTextField();
        txtFTravellerNumber = new javax.swing.JTextField();
        lblP1 = new javax.swing.JLabel();
        lblP1name = new javax.swing.JLabel();
        lblP2name = new javax.swing.JLabel();
        lblP2 = new javax.swing.JLabel();
        lblP3 = new javax.swing.JLabel();
        lblP3name = new javax.swing.JLabel();
        lblP1age = new javax.swing.JLabel();
        txtP1Age = new javax.swing.JTextField();
        lblP2age = new javax.swing.JLabel();
        txtP2Age = new javax.swing.JTextField();
        lblP3age = new javax.swing.JLabel();
        txtP3Age = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();
        lblSource = new javax.swing.JLabel();
        txtSource = new javax.swing.JTextField();
        txtDestination = new javax.swing.JTextField();
        lblSource1 = new javax.swing.JLabel();
        lblTCost = new javax.swing.JLabel();
        txtTCost = new javax.swing.JTextField();
        jCnameP1 = new javax.swing.JComboBox<>();
        jCnameP2 = new javax.swing.JComboBox<>();
        jCnameP3 = new javax.swing.JComboBox<>();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSeats = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        comboSeatType = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setText("Booking Details");

        lblFlName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblFlName.setText("Flight Name:");

        txtFlightName.setEditable(false);

        lblDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDate.setText("Departing Date:");

        txtDate.setEditable(false);

        lblFlNumber.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblFlNumber.setText("Flight number:");

        lblNoOfTravellers.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNoOfTravellers.setText("No. of Travellers:");

        txtFlNumber.setEditable(false);

        txtFTravellerNumber.setEditable(false);

        lblP1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblP1.setText("Passenger1");

        lblP1name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblP1name.setText("Name:");

        lblP2name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblP2name.setText("Name:");

        lblP2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblP2.setText("Passenger2");

        lblP3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblP3.setText("Passenger3");

        lblP3name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblP3name.setText("Name:");

        lblP1age.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblP1age.setText("Age:");

        lblP2age.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblP2age.setText("Age:");

        lblP3age.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblP3age.setText("Age:");

        btnConfirm.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        lblSource.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSource.setText("Source:");

        txtSource.setEditable(false);

        txtDestination.setEditable(false);

        lblSource1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSource1.setText("Destination:");

        lblTCost.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTCost.setText("Total Cost:");

        txtTCost.setEditable(false);

        jCnameP1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCnameP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCnameP1ActionPerformed(evt);
            }
        });

        jCnameP2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCnameP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCnameP2ActionPerformed(evt);
            }
        });

        jCnameP3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCnameP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCnameP3ActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblSeats.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seat Number", "Seat Type", "Check value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSeats);

        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Search By");

        comboSeatType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Window", "Middle", "Aisle" }));
        comboSeatType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSeatTypeActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/TravelAgency/FlightLayout.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Reference to Book Seats");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31)
                        .addComponent(comboSeatType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(181, 181, 181)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblDate)
                                            .addComponent(lblSource)
                                            .addComponent(lblTCost))
                                        .addGap(38, 38, 38)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSource, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTCost, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(lblFlName)
                                        .addGap(38, 38, 38)
                                        .addComponent(txtFlightName, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblSource1)
                                            .addComponent(lblFlNumber))
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtFlNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNoOfTravellers)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtFTravellerNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblP3name)
                                        .addGap(18, 18, 18)
                                        .addComponent(jCnameP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblP2name)
                                        .addGap(18, 18, 18)
                                        .addComponent(jCnameP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(242, 242, 242)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblP1age)
                                        .addGap(27, 27, 27)
                                        .addComponent(txtP1Age, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblP2age)
                                        .addGap(27, 27, 27)
                                        .addComponent(txtP2Age, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblP3age)
                                        .addGap(27, 27, 27)
                                        .addComponent(txtP3Age, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblP1name)
                                .addGap(18, 18, 18)
                                .addComponent(jCnameP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(228, 228, 228)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblP2)
                                    .addComponent(lblP1)
                                    .addComponent(lblP3)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(btnSearch))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(256, 256, 256)
                        .addComponent(lblTitle)))
                .addContainerGap(270, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(179, 179, 179))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addComponent(lblTitle))
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFlName)
                            .addComponent(txtFlightName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSource)
                            .addComponent(txtSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDestination, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSource1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFlNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFlNumber))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDate)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNoOfTravellers)
                    .addComponent(txtFTravellerNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTCost)
                    .addComponent(txtTCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblP1age)
                                    .addComponent(txtP1Age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCnameP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblP1name))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblP2age)
                                    .addComponent(txtP2Age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblP3age)
                                    .addComponent(txtP3Age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCnameP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblP3name)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblP1)
                                .addGap(46, 46, 46)
                                .addComponent(lblP2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblP2name)
                                    .addComponent(jCnameP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addComponent(lblP3)))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(comboSeatType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)))
                .addComponent(btnSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfirm)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        int bookedSeatCount = 0;
        ArrayList<String> selectedSeats = new ArrayList<>();

        if (txtFTravellerNumber.getText().equals("1")) {

            String P1age = txtP1Age.getText();
            try {
                Integer.parseInt(P1age);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Passenger Age is not valid");
                return;
            }
        }

        if (txtFTravellerNumber.getText().equals("2")) {
            if (jCnameP1.getSelectedItem().toString().equals(jCnameP2.getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(null, "Passenger1 and Passenger2 cannot be same");
            }
            String P1age = txtP1Age.getText();
            try {
                Integer.parseInt(P1age);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Passenger Age is not valid");
                return;
            }

            String P2age = txtP2Age.getText();
            try {
                Integer.parseInt(P2age);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Passenger 2 Age is not valid");
                return;
            }
        }

        if (txtFTravellerNumber.getText().equals("3")) {
            if (jCnameP1.getSelectedItem().toString().equals(jCnameP2.getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(null, "Passenger1 and Passenger2 cannot be same");
            }

            if (jCnameP2.getSelectedItem().toString().equals(jCnameP3.getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(null, "Passenger2 and Passenger3 cannot be same");
            }

            if (jCnameP3.getSelectedItem().toString().equals(jCnameP1.getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(null, "Passenger1 and Passenger3 cannot be same");
            }

            String P1age = txtP1Age.getText();
            try {
                Integer.parseInt(P1age);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Passenger Age is not valid");
                return;
            }

            String P2age = txtP2Age.getText();
            try {
                Integer.parseInt(P2age);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Passenger 2 Age is not valid");
                return;
            }

            String P3age = txtP3Age.getText();
            try {
                Integer.parseInt(P3age);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Passenger 3 Age is not valid");
                return;
            }
        }

        for (int j = 0; j < tblSeats.getRowCount(); j++) {
            Boolean checked = Boolean.valueOf(String.valueOf(tblSeats.getValueAt(j, 2)));
            if (checked) {
                bookedSeatCount++;
                selectedSeats.add(String.valueOf(tblSeats.getValueAt(j, 0)));
            }
        }

        int selectionButton = JOptionPane.YES_NO_OPTION;

        if (bookedSeatCount == Integer.parseInt(txtFTravellerNumber.getText())) {
            int selectionResult = JOptionPane.showConfirmDialog(null, "Can we confirm the booking??", "Warning", selectionButton);
            if (selectionResult == JOptionPane.YES_OPTION) {

                Booking booking = bookDir.addBooking();
                booking.setSource(txtSource.getText());
                booking.setDestination(txtDestination.getText());
                booking.setFlightNumber(Integer.parseInt(txtFlNumber.getText()));
                booking.setStartDate(Date.valueOf(txtDate.getText()));
                booking.setPassengerNumber(Integer.parseInt(txtFTravellerNumber.getText()));
                booking.setFlightName(txtFlightName.getText());
                booking.setFlightName(flight.getFlAirlinerName());
                booking.setSeatCost(flight.getFlCost());

                for (int i = 1; i <= Integer.parseInt(txtFTravellerNumber.getText()); i++) {
                    if (i == 1) {
                        Passenger p = new Passenger();
                        p.setAge(Integer.parseInt(txtP1Age.getText()));
                        p.setName(jCnameP1.getSelectedItem().toString());
                        p.setSeat(selectedSeats.get(0));
                        pList.add(p);
                    }
                    if (i == 2) {
                        Passenger p2 = new Passenger();
                        p2.setAge(Integer.parseInt(txtP2Age.getText()));
                        p2.setName(jCnameP2.getSelectedItem().toString());
                        p2.setSeat(selectedSeats.get(1));
                        pList.add(p2);
                    }
                    if (i == 3) {
                        Passenger p3 = new Passenger();
                        p3.setAge(Integer.parseInt(txtP3Age.getText()));
                        p3.setName(jCnameP3.getSelectedItem().toString());
                        p3.setSeat(selectedSeats.get(2));
                        pList.add(p3);
                    }
                }

                for (Seat s : flight.getFlSeatDir().getSeatDir()) {
                    for (int i = 0; i < bookedSeatCount; i++) {
                        if (s.getSeatNum().equalsIgnoreCase(selectedSeats.get(i))) {
                            s.setSeatAvailable(true);
                            break;
                        }
                    }
                }

                booking.setPassengerList(pList);


                /*SeatAssignmentPanel createAlrPanel = new SeatAssignmentPanel(rightPanel, travellerCount, pList, fltDir, flight, bookDir);
            rightPanel.add("seatAssigment", createAlrPanel);
            CardLayout layout = (CardLayout) rightPanel.getLayout();
            layout.next(rightPanel);*/
                ManageBookingsPanel manageBookings = new ManageBookingsPanel(rightPanel, bookDir, fltDir, booking);// , seatDir , seatList);
                rightPanel.add("ManageBookingsPanel", manageBookings);
                CardLayout layout = (CardLayout) rightPanel.getLayout();
                layout.next(rightPanel);
            } else {
                JOptionPane.showMessageDialog(null, "Please choose a desired flight to book");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please choose 1 seat per passenger!");
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void jCnameP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCnameP1ActionPerformed
        // TODO add your handling code here:
        if (jCnameP1.getItemCount() > 0) {
            populateAge1(String.valueOf(jCnameP1.getSelectedItem()));
        }
    }//GEN-LAST:event_jCnameP1ActionPerformed

    private void jCnameP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCnameP2ActionPerformed
        // TODO add your handling code here:
        if (jCnameP2.getItemCount() > 0) {
            populateAge1(String.valueOf(jCnameP1.getSelectedItem()));
            populateAge2(String.valueOf(jCnameP2.getSelectedItem()));
        }
    }//GEN-LAST:event_jCnameP2ActionPerformed

    private void jCnameP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCnameP3ActionPerformed
        // TODO add your handling code here:
        if (jCnameP3.getItemCount() > 0) {
            populateAge1(String.valueOf(jCnameP1.getSelectedItem()));
            populateAge2(String.valueOf(jCnameP2.getSelectedItem()));
            populateAge3(String.valueOf(jCnameP3.getSelectedItem()));
        }
    }//GEN-LAST:event_jCnameP3ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        rightPanel.remove(this);
        CardLayout layout = (CardLayout) rightPanel.getLayout();
        layout.previous(rightPanel);

    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String selectedFilter = comboSeatType.getSelectedItem().toString();
        if (selectedFilter.equalsIgnoreCase("ALL")) {
            populateSeats();
        } else {
            List<Seat> result = flight.getFlSeatDir().searchBySeatType(selectedFilter);
            if (result.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Invalid search result", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                populateSeats(result);
            }
        }

    }//GEN-LAST:event_btnSearchActionPerformed

    private void comboSeatTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSeatTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSeatTypeActionPerformed

    private void populateSeats(List<Seat> result) {
        DefaultTableModel dtm = (DefaultTableModel) tblSeats.getModel();
        dtm.setRowCount(0);
        for (Seat s : result) {
            Object[] row = new Object[dtm.getColumnCount()];
            row[2] = s.getSeatAvailable();
            row[0] = s;
            row[1] = s.getSeatType();

            dtm.addRow(row);
        }
    }

    private void populateAge1(String selectedPasName) {
        ArrayList<Passenger> passenger = custDir.getCustomerList();
        //   ArrayList<Passenger> Ages = new ArrayList<>();
        Boolean flag = false;
        for (Passenger pas : passenger) {
            if (selectedPasName.equals(pas.getName())) {
                flag = true;

                txtP1Age.setText(String.valueOf(pas.getAge()));

            }
        }
    }

    private void populateAge2(String selectedPasName) {
        ArrayList<Passenger> passenger = custDir.getCustomerList();
        //   ArrayList<Passenger> Ages = new ArrayList<>();
        Boolean flag = false;
        for (Passenger pas : passenger) {
            if (selectedPasName.equals(pas.getName())) {
                flag = true;

                txtP2Age.setText(String.valueOf(pas.getAge()));
            }
        }
    }

    private void populateAge3(String selectedPasName) {
        ArrayList<Passenger> passenger = custDir.getCustomerList();
        //   ArrayList<Passenger> Ages = new ArrayList<>();
        Boolean flag = false;
        for (Passenger pas : passenger) {
            if (selectedPasName.equals(pas.getName())) {
                flag = true;

                txtP3Age.setText(String.valueOf(pas.getAge()));
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> comboSeatType;
    private javax.swing.JComboBox<String> jCnameP1;
    private javax.swing.JComboBox<String> jCnameP2;
    private javax.swing.JComboBox<String> jCnameP3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblFlName;
    private javax.swing.JLabel lblFlNumber;
    private javax.swing.JLabel lblNoOfTravellers;
    private javax.swing.JLabel lblP1;
    private javax.swing.JLabel lblP1age;
    private javax.swing.JLabel lblP1name;
    private javax.swing.JLabel lblP2;
    private javax.swing.JLabel lblP2age;
    private javax.swing.JLabel lblP2name;
    private javax.swing.JLabel lblP3;
    private javax.swing.JLabel lblP3age;
    private javax.swing.JLabel lblP3name;
    private javax.swing.JLabel lblSource;
    private javax.swing.JLabel lblSource1;
    private javax.swing.JLabel lblTCost;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblSeats;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtDestination;
    private javax.swing.JTextField txtFTravellerNumber;
    private javax.swing.JTextField txtFlNumber;
    private javax.swing.JTextField txtFlightName;
    private javax.swing.JTextField txtP1Age;
    private javax.swing.JTextField txtP2Age;
    private javax.swing.JTextField txtP3Age;
    private javax.swing.JTextField txtSource;
    private javax.swing.JTextField txtTCost;
    // End of variables declaration//GEN-END:variables

}
