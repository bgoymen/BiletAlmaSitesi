/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Göymen
 */
public class Otobus_Seferleri {
    private int id;
    private int firma_id;
    private int kalkis_nok;
    private int varis_nok;

    public Otobus_Seferleri() {
    }
    
    

    public Otobus_Seferleri(int id, int firma_id, int kalkis_nok, int varis_nok) {
        this.id = id;
        this.firma_id = firma_id;
        this.kalkis_nok = kalkis_nok;
        this.varis_nok = varis_nok;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFirma_id() {
        return firma_id;
    }

    public void setFirma_id(int firma_id) {
        this.firma_id = firma_id;
    }

    public int getKalkis_nok() {
        return kalkis_nok;
    }

    public void setKalkis_nok(int kalkis_nok) {
        this.kalkis_nok = kalkis_nok;
    }

    public int getVaris_nok() {
        return varis_nok;
    }

    public void setVaris_nok(int varis_nok) {
        this.varis_nok = varis_nok;
    }
    
    
    
    
}
