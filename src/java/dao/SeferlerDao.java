/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Göymen
 */
public class SeferlerDao {

    public List<Integer> koltuk_sayisi() {
        List<Integer> koltuk = new ArrayList<>();
        int sayac = 10;
        for (int i = 0; i < 10; i++) {
            koltuk.add(sayac);
            sayac += 10;
        }
        return koltuk;
    }

    public List<Integer> fiyat() {
        List<Integer> fiyat = new ArrayList<>();
        int sayac = 10;
        for (int i = 0; i < 99; i++) {
            fiyat.add(sayac);
            sayac += 5;
        }
        return fiyat;
    }
}
