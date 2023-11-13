/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author vojislav
 */
public class Nastavnik {
        int id; // treba nam id kako bismo se organizovali sa bazom podataka, imace default vrednost 0 kad se inicijalizuje
        String ime;
        String prezime;
        Zvanje zvanje;

    public Nastavnik(int id, String ime, String prezime, Zvanje zvanje) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.zvanje = zvanje;
    }

    public Nastavnik() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Zvanje getZvanje() {
        return zvanje;
    }

    public void setZvanje(Zvanje zvanje) {
        this.zvanje = zvanje;
    }

    @Override
    public String toString() {
        return "Nastavnik{" + "id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", zvanje=" + zvanje + '}';
    }
        
        
}
