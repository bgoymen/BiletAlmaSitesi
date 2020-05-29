/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Otobus_Seferleri;
import entity.Satin_Alinan_Bilet;
import entity.Tren_Seferleri;
import entity.Ucak_Seferleri;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnection;

/**
 *
 * @author Göymen
 */
public class Satin_Alinan_BiletDao extends DBConnection {

    public void create(Satin_Alinan_Bilet s) {

        switch (s.getSeyehat_turu()) {
            case 1:

                try {
                    Statement st = this.connect().createStatement();
                    st.executeUpdate("insert into satin_alinan_bilet(user_id,seyehat_turu, otobus_seferleri_id,ucak_seferleri_id,tren_seferleri_id,koltuk_no) values(" + s.getUser_id() + "," + s.getSeyehat_turu() + "," + s.getOtobus_seferleri_id() + ",0,0," + s.getKoltuk_no() + ")");

                } catch (SQLException ex) {
                    System.out.println("Hata(Satin_Alinan_BiletDao(Create(1))):" + ex.getMessage());
                }

                break;
            case 2:

                try {
                    Statement st = this.connect().createStatement();
                    st.executeUpdate("insert into satin_alinan_bilet(user_id,seyehat_turu, otobus_seferleri_id,ucak_seferleri_id,tren_seferleri_id,koltuk_no) values(" + s.getUser_id() + "," + s.getSeyehat_turu() + ",0," + s.getUcak_seferleri_id() + ",0," + s.getKoltuk_no() + ")");

                } catch (SQLException ex) {
                    System.out.println("Hata(Satin_Alinan_BiletDao(Create(2))):" + ex.getMessage());
                }

                break;
            case 3:

                try {
                    Statement st = this.connect().createStatement();
                    st.executeUpdate("insert into satin_alinan_bilet(user_id,seyehat_turu, otobus_seferleri_id,ucak_seferleri_id,tren_seferleri_id,koltuk_no) values(" + s.getUser_id() + "," + s.getSeyehat_turu() + ",0,0," + s.getTren_seferleri_id() + "," + s.getKoltuk_no() + ")");

                } catch (SQLException ex) {
                    System.out.println("Hata(Satin_Alinan_BiletDao(Create(3))):" + ex.getMessage());
                }

                break;
            default:
                System.out.println("Hata(Satin_Alinan_Bilet(Create): Switch-Case)");
                break;
        }
    }

    public List<Satin_Alinan_Bilet> read(int kalkis_sehri, int varis_sehri, int seyehat_turu) {
        return null;
//        boolean control = this.readConrol(kalkis_sehri, varis_sehri);
//        if (control == false) {
//            return null;
//        } else {
//            List<Satin_Alinan_Bilet> list = new ArrayList<>();
//            try {
//                Statement st = this.connect().createStatement();
//                ResultSet rs = st.executeQuery("select * from satin_alinan_bilet order by id asc");
//
//                switch (seyehat_turu) {
//                    case 1:
//                        while (rs.next()) {
//                            if ((rs.getInt("kalkis_nok") == kalkis_sehri) && (rs.getInt("varis_nok") == varis_sehri)) {
//                                Satin_Alinan_Bilet tmp = new Satin_Alinan_Bilet(rs.getInt("id"), rs.getInt("otobus_seferi_id"), rs.getInt("kalkis_nok"), rs.getInt("varis_nok"), rs.getInt("fiyat"), 1, rs.getInt("koltuk_no"));
//                                list.add(tmp);
//                            }
//                        }
//                        break;
//
//                    case 2:
//                        while (rs.next()) {
//                            if ((rs.getInt("kalkis_nok") == kalkis_sehri) && (rs.getInt("varis_nok") == varis_sehri)) {
//                                Satin_Alinan_Bilet tmp = new Satin_Alinan_Bilet(rs.getInt("id"), rs.getInt("ucak_seferi_id"), rs.getInt("kalkis_nok"), rs.getInt("varis_nok"), rs.getInt("fiyat"), 2, rs.getInt("koltuk_no"));
//                                list.add(tmp);
//                            }
//                        }
//                        break;
//                    case 3:
//                        while (rs.next()) {
//                            if ((rs.getInt("kalkis_nok") == kalkis_sehri) && (rs.getInt("varis_nok") == varis_sehri)) {
//                                Satin_Alinan_Bilet tmp = new Satin_Alinan_Bilet(rs.getInt("id"), rs.getInt("tren_seferi_id"), rs.getInt("kalkis_nok"), rs.getInt("varis_nok"), rs.getInt("fiyat"), 3, rs.getInt("koltuk_no"));
//                                list.add(tmp);
//                            }
//                        }
//                        break;
//                    default:
//                        break;
//                }
//            } catch (SQLException e) {
//                System.out.println("Hata(Otobus_SeferleriDao(read)):" + e.getMessage());
//            }
//
//            return list;
//        }
    }

    public List<Otobus_Seferleri> read_otbus_bileti(int kalkis_sehri, int varis_sehri) {
        List<Otobus_Seferleri> list = new ArrayList<>();
        try {

            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from otobus_seferleri order by id asc");
            while (rs.next()) {
                if ((rs.getInt("kalkis_nok") == kalkis_sehri) && (rs.getInt("varis_nok") == varis_sehri)) {
                    Otobus_Seferleri tmp = new Otobus_Seferleri(rs.getInt("id"), rs.getInt("firma_id"), rs.getInt("kalkis_nok"), rs.getInt("varis_nok"), rs.getInt("koltuk_sayisi"), rs.getInt("fiyat"));
                    list.add(tmp);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Satin_Alinan_BiletDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Tren_Seferleri> read_tren_bileti(int kalkis_sehri, int varis_sehri) {
        List<Tren_Seferleri> list = new ArrayList<>();
        try {

            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from tren_seferleri order by id asc");
            while (rs.next()) {
                if ((rs.getInt("kalkis_nok") == kalkis_sehri) && (rs.getInt("varis_nok") == varis_sehri)) {
                    Tren_Seferleri tmp = new Tren_Seferleri(rs.getInt("id"), rs.getInt("tren_firma_id"), rs.getInt("kalkis_nok"), rs.getInt("varis_nok"), rs.getInt("koltuk_sayisi"), rs.getInt("fiyat"));
                    list.add(tmp);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Satin_Alinan_BiletDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Ucak_Seferleri> read_ucak_bileti(int kalkis_sehri, int varis_sehri) {
        List<Ucak_Seferleri> list = new ArrayList<>();
        try {

            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from ucak_seferleri order by id asc");
            while (rs.next()) {
                if ((rs.getInt("kalkis_nok") == kalkis_sehri) && (rs.getInt("varis_nok") == varis_sehri)) {
                    Ucak_Seferleri tmp = new Ucak_Seferleri(rs.getInt("id"), rs.getInt("ucak_firma_id"), rs.getInt("kalkis_nok"), rs.getInt("varis_nok"), rs.getInt("koltuk_sayisi"), rs.getInt("fiyat"));
                    list.add(tmp);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Satin_Alinan_BiletDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean readConrol(int kalkis_nok, int varis_nok) {
        if (kalkis_nok == varis_nok) {
            return false;
        } else {
            return true;
        }
    }

    public void delete(int f) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from satin_alinan_bilet where id=" + f);

        } catch (SQLException e) {
            System.out.println("Hata(Satin_Alinan_BiletDao(Delete)):" + e.getMessage());
        }
    }

    public List<Integer> satin_alirken_koltuklar(int koltuk_sayisi) {
        List<Integer> satin_alirken = new ArrayList<>();
        int sayac = 1;
        for (int i = 1; i <= koltuk_sayisi; i++) {
            satin_alirken.add(sayac);
            sayac++;
        }
        return satin_alirken;
    }

    public boolean koltuk_dolu_mu_otobus(int otobus_seferleri_id, int koltuk_no) {
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from satin_alinan_bilet order by id asc");
            while (rs.next()) {
                if ((rs.getInt("otobus_seferleri_id") == otobus_seferleri_id) && (rs.getInt("koltuk_no") == koltuk_no)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Satin_Alinan_BiletDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean koltuk_dolu_mu_tren(int tren_seferleri_id, int koltuk_no) {
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from satin_alinan_bilet order by id asc");
            while (rs.next()) {
                if ((rs.getInt("tren_seferleri_id") == tren_seferleri_id) && (rs.getInt("koltuk_no") == koltuk_no)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Satin_Alinan_BiletDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean koltuk_dolu_mu_ucak(int ucak_seferleri_id, int koltuk_no) {
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from satin_alinan_bilet order by id asc");
            while (rs.next()) {
                if ((rs.getInt("ucak_seferleri_id") == ucak_seferleri_id) && (rs.getInt("koltuk_no") == koltuk_no)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Satin_Alinan_BiletDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
}
