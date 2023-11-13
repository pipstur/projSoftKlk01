/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import domain.Nastavnik;
import domain.Zvanje;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vojislav
 */
public class NastavnikTableModel extends AbstractTableModel{

    private List<Nastavnik> nastavnici; 

    public NastavnikTableModel(List<Nastavnik> nastavnici) {
        this.nastavnici = nastavnici;
    }
    
    @Override
    public boolean isCellEditable(int row, int column) {
        //ovo je da bi svi cellovi bili editable
        return true;
    }
    @Override
    public int getRowCount() {
        return nastavnici.size();
    }

    @Override
    public int getColumnCount() {
        return 3; 
    }
    
    // implementirana metoda
    public void addRow(Nastavnik nastavnik) {
        nastavnici.add(nastavnik);
        fireTableRowsInserted(nastavnici.size()-1, nastavnici.size()-1);
    }
    
    // u sustini ovo bi moglo i preko nastavnik objekta al nije neophodno, trebalo bi da je okej
    public void removeRow(int red){
        nastavnici.remove(red);
        fireTableRowsDeleted(nastavnici.size()-1, nastavnici.size()-1);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Nastavnik nastavnik = nastavnici.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return nastavnik.getIme(); 
            case 1:
                return nastavnik.getPrezime(); 
            case 2:
                return nastavnik.getZvanje(); 
            default:
                return null; 
        }
    }
     @Override
       public void setValueAt(Object value, int row, int col) {
           
        Nastavnik nastavnik = nastavnici.get(row);
        switch (col) {
            case 0:
                nastavnik.setIme((String) value);
                break;
            case 1:
                nastavnik.setPrezime((String) value);
                break;
            case 2:
                nastavnik.setZvanje(Zvanje.valueOf(value.toString()));
                break;
            default:
                break;
        }
        
        fireTableCellUpdated(row, col);
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Ime";
            case 1:
                return "Prezime";
            case 2:
                return "Zvanje";
            default:
                return null;
        }
    }
    
}
