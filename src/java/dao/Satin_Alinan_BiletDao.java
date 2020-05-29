/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Satin_Alinan_Bilet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
                    st.executeUpdate("insert into satin_alinan_bilet(user_id,seyeha_turu, otobus_firma_id,kalkis_nok,varis_nok) values(" + s.getUser_id() + "," + s.getSeyehat_turu() + "," + s.getOtobus_firma_id() + "," + s.getKalkis_nok() + "," + s.getVaris_nok() + ")");

                } catch (SQLException ex) {
                    System.out.println("Hata(Satin_Alinan_BiletDao(Create(1))):" + ex.getMessage());
                }

                break;
            case 2:

                try {
                    Statement st = this.connect().createStatement();
                    st.executeUpdate("insert into satin_alinan_bilet(user_id,seyeha_turu, ucak_firma_id,kalkis_nok,varis_nok) values(" + s.getUser_id() + "," + s.getSeyehat_turu() + "," + s.getUcak_firma_id() + "," + s.getKalkis_nok() + "," + s.getVaris_nok() + ")");

                } catch (SQLException ex) {
                    System.out.println("Hata(Satin_Alinan_BiletDao(Create(2))):" + ex.getMessage());
                }

                break;
            case 3:

                try {
                    Statement st = this.connect().createStatement();
                    st.executeUpdate("insert into satin_alinan_bilet(user_id,seyeha_turu, tren_firma_id,kalkis_nok,varis_nok) values(" + s.getUser_id() + "," + s.getSeyehat_turu() + "," + s.getTren_firma_id() + "," + s.getKalkis_nok() + "," + s.getVaris_nok() + ")");

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
        boolean control = this.readConrol(kalkis_sehri, varis_sehri);
        if (control == false) {
            return null;
        } else {
            List<Satin_Alinan_Bilet> list = new ArrayList<>();
            try {
                Statement st = this.connect().createStatement();
                ResultSet rs = st.executeQuery("select * from sain_alinan_bilet order by id asc");

                switch (seyehat_turu) {
                    case 1:
                        while (rs.next()) {
                            if (rs.getInt("kalkis_nok") == rs.getInt("varis_nok")) {
                                Satin_Alinan_Bilet tmp = new Satin_Alinan_Bilet(rs.getInt("id"), rs.getInt("otobus_firma_id"), rs.getInt("kalkis_nok"), rs.getInt("varis_nok"), rs.getInt("fiyat"), 1);
                                list.add(tmp);
                            }
                        }
                        break;

                    case 2:
                        while (rs.next()) {
                            if (rs.getInt("kalkis_nok") == rs.getInt("varis_nok")) {
                                Satin_Alinan_Bilet tmp = new Satin_Alinan_Bilet(rs.getInt("id"), rs.getInt("ucak_firma_id"), rs.getInt("kalkis_nok"), rs.getInt("varis_nok"), rs.getInt("fiyat"), 2);
                                list.add(tmp);
                            }
                        }
                        break;
                    case 3:
                        while (rs.next()) {
                            if (rs.getInt("kalkis_nok") == rs.getInt("varis_nok")) {
                                Satin_Alinan_Bilet tmp = new Satin_Alinan_Bilet(rs.getInt("id"), rs.getInt("tren_firma_id"), rs.getInt("kalkis_nok"), rs.getInt("varis_nok"), rs.getInt("fiyat"), 3);
                                list.add(tmp);
                            }
                        }
                        break;
                    default:
                        break;
                }
            } catch (SQLException e) {
                System.out.println("Hata(Otobus_SeferleriDao(read)):" + e.getMessage());
            }

            return list;
        }
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
}
