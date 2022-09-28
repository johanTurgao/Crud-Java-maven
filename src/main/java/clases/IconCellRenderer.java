/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 package clases;

import java.awt.Component;
 import javax.swing.JLabel;
 import javax.swing.JTable;
 import javax.swing.table.DefaultTableCellRenderer;

public class IconCellRenderer extends DefaultTableCellRenderer {

    @Override
     public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof JLabel) {
           JLabel label = (JLabel) value;
           label.setOpaque(true);
           fillColor(table, label, isSelected);
           return label;
        } else {
           return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
     }
    public void fillColor(JTable t, JLabel l, boolean isSelected) {
       if (isSelected) {
           l.setBackground(t.getSelectionBackground());
           l.setForeground(t.getSelectionForeground());
       } else {
       l.setBackground(t.getBackground());
       l.setForeground(t.getForeground());
       }
    }
 }

