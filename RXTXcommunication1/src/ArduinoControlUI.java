package ui;

import serial.SerialManager;
import javax.swing.*;

public class ArduinoControlUI extends JFrame {

    SerialManager serial = new SerialManager();

    JTextField txtPort = new JTextField("COM5", 6);
    JTextField txtValue = new JTextField("5", 5);

    JButton btnConnect = new JButton("Connect");
    JButton btnSend = new JButton("Send");
    JButton btnDisconnect = new JButton("Disconnect");

    public ArduinoControlUI() {
        setTitle("Arduino Control App");
        setSize(300,150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        txtPort.setBounds(20,20,60,25);
        btnConnect.setBounds(100,20,100,25);

        txtValue.setBounds(20,60,60,25);
        btnSend.setBounds(100,60,100,25);

        btnDisconnect.setBounds(70,100,120,25);

        add(txtPort);
        add(btnConnect);
        add(txtValue);
        add(btnSend);
        add(btnDisconnect);

        btnConnect.addActionListener(e -> {
            if (serial.connect(txtPort.getText())) {
                JOptionPane.showMessageDialog(this,"Connected");
            } else {
                JOptionPane.showMessageDialog(this,"Connect failed");
            }
        });

        btnSend.addActionListener(e ->
            serial.send(txtValue.getText())
        );

        btnDisconnect.addActionListener(e -> serial.disconnect());
    }

    public static void main(String[] args) {
        new ArduinoControlUI().setVisible(true);
    }
}
