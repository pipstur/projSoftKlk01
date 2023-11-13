/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author vojislav
 */
public enum Zvanje {
    ASISTENT(1),
    ASISTENT_SA_DOKTORATOM(2),
    DOCENT(3),
    VANREDNI_PROFESOR(4),
    REDOVNI_PROFESOR(5);

    private final int zvanjeId;

    Zvanje(int zvanjeId) {
        this.zvanjeId = zvanjeId;
    }
    
    // lakse mi jer su vrednosti u bazi numericke za zvanje pa da nema cimanja sa parsiranjem
    public int getZvanjeId() {
        return zvanjeId;
    }
    
    // Ovo mozda i nije moralo da se implementira mada eto ga tu
    public static Zvanje valueOf(int zvanjeId) {
        for (Zvanje zvanje : values()) {
            if (zvanje.getZvanjeId() == zvanjeId) {
                return zvanje;
            }
        }
        throw new IllegalArgumentException("Invalid zvanje_id: " + zvanjeId);
    }
}
