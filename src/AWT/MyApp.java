package AWT;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class MyApp extends Frame implements WindowListener, ActionListener, MouseListener {
    // build app ( constructor )
    TextField txtId,txtName,txtQty,txtPrice,txtTotal;
    Button btnCash,btnAdd,btnUpdate,btnDelete,btnClear;
    JTable table;
    DefaultTableModel model;
    public MyApp(){
        // title
        Label label = new Label("SHOP");
        label.setBounds(0,20,1200,80);
        label.setFont(new Font("",Font.BOLD,40));
        label.setForeground(new Color(25, 94, 243));
        label.setAlignment(Label.CENTER);
        add(label); // mean add label( Hello world to screen )

        for (int i = 0; i < 5; i++) {
            label = new Label((i==0)?"Id":(i==1)?"Name":(i==2)?"Quantity":(i==3)?"Price":"Total");
            label.setBounds(100,(i==0)?100:(i==1)?160:(i==2)?210:(i==3)?270:330,150,60);
            label.setFont(new Font("",Font.PLAIN,24));
            add(label);
        }

        // Id
        txtId = new TextField();
        txtId.setBounds(270,110,200,40);
        txtId.setFont(new Font("",Font.PLAIN,24));
        add(txtId);
        // Name
        txtName = new TextField();
        txtName.setBounds(270,160,200,40);
        txtName.setFont(new Font("",Font.PLAIN,24));
        add(txtName);
        // Quantity
        txtQty = new TextField();
        txtQty.setBounds(270,220,200,40);
        txtQty.setFont(new Font("",Font.PLAIN,24));
        add(txtQty);
        // Price
        txtPrice = new TextField();
        txtPrice.setBounds(270,280,200,40);
        txtPrice.setFont(new Font("",Font.PLAIN,24));
        add(txtPrice);
        // Total
        txtTotal = new TextField();
        txtTotal.setBounds(270,340,200,40);
        txtTotal.setFont(new Font("",Font.PLAIN,24));
        txtTotal.setEditable(false);
        add(txtTotal);

        // Cash
        btnCash= new Button("Cash");
        btnCash.setBounds(125,400,155,40);
        btnCash.setFont(new Font("",Font.PLAIN,24));
        btnCash.setBackground(new Color(225, 110, 12));
        add(btnCash);
        btnCash.addActionListener(this);
        // Add
        btnAdd= new Button("Add");
        btnAdd.setBounds(295,400,155,40);
        btnAdd.setFont(new Font("",Font.PLAIN,24));
        btnAdd.setBackground(new Color(17, 255, 0));
        add(btnAdd);
        btnAdd.addActionListener(this);

        // Table
        String[] header = {"Id","Name","Quantity","Price","Total"};
        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(header);
        table.setRowHeight(25);
        table.setFont(new Font("",Font.PLAIN,24));
        table.setModel(model);
        JScrollPane js = new JScrollPane(table);
        js.setBounds(600,100,500,280);
        add(js);
        table.addMouseListener(this);

        // Update
        btnUpdate= new Button("Update");
        btnUpdate.setBounds(600,400,155,40);
        btnUpdate.setFont(new Font("",Font.PLAIN,24));
        btnUpdate.setBackground(new Color(246, 200, 85));
        add(btnUpdate);
        btnUpdate.addActionListener(this);
        // Delete
        btnDelete= new Button("Delete");
        btnDelete.setBounds(770,400,155,40);
        btnDelete.setFont(new Font("",Font.PLAIN,24));
        btnDelete.setBackground(new Color(201, 87, 87));
        add(btnDelete);
        btnDelete.addActionListener(this);
        // Payment
        btnClear= new Button("Clear");
        btnClear.setBounds(940,400,155,40);
        btnClear.setFont(new Font("",Font.PLAIN,24));
        btnClear.setBackground(new Color(43, 72, 246));
        add(btnClear);
        btnClear.addActionListener(this);

        // UI
        setLayout(null);
        setSize(1200,800);
        setLocationRelativeTo(this); // center
        setVisible(true); // can pop up
        addWindowListener(this);
    }
    // main method ( for Run App )
    public static void main(String[] args) {
        new MyApp();
    }

    // For get data from list insert to table
    public void getData(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        Shop.list.forEach(product->{
            Object[] row = {
                    product.getId(),
                    product.getName(),
                    product.getQty(),
                    product.getPrice(),
                    product.getTotal()
            };
            model.addRow(row);
        });
    }
    // Clear Text field
    public void clear(){
        txtId.setText("");
        txtName.setText("");
        txtQty.setText("");
        txtPrice.setText("");
        txtTotal.setText("");
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCash){
            int qty = Integer.parseInt(txtQty.getText());
            double price = Double.parseDouble(txtPrice.getText());
            double total = qty * price;
            txtTotal.setText(String.valueOf(total));
        } else if (e.getSource() == btnAdd) {
            int id = Integer.parseInt(txtId.getText());
            String name = txtName.getText();
            int qty = Integer.parseInt(txtQty.getText());
            double price = Double.parseDouble(txtPrice.getText());
            double total = qty * price;
            Shop.list.add(new Shop(id,name,qty,price,total));
            getData();
            clear();
        } else if (e.getSource() == btnUpdate) {
            int id = Integer.parseInt(txtId.getText());
            String name = txtName.getText();
            int qty = Integer.parseInt(txtQty.getText());
            double price = Double.parseDouble(txtPrice.getText());
            double total = qty * price;
            int index = table.getSelectedRow();
            Shop.list.set(index,new Shop(id,name,qty,price,total));
            getData();
            clear();
        } else if (e.getSource() == btnDelete) {
            int index = table.getSelectedRow();
            Shop.list.remove(index);
            getData();
            clear();
        } else if (e.getSource() == btnClear) {
            Shop.list.clear();
            getData();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int row = table.getSelectedRow();

        txtId.setText(model.getValueAt(row,0).toString());
        txtName.setText(model.getValueAt(row,1).toString());
        txtQty.setText(model.getValueAt(row,2).toString());
        txtPrice.setText(model.getValueAt(row,3).toString());
        txtTotal.setText(model.getValueAt(row,4).toString());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
