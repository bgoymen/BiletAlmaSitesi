/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Users;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Göymen
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    public static int user_type;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String url = req.getRequestURI();

        Users u = (Users) req.getSession().getAttribute("valid_user");

        if (u == null) {
            if ((url.contains("/Admin/Admin")) || (url.contains("/Admin/Admin"))
                    || (url.contains("/Admin/Admin") || (url.contains("/Admin/Admin")))
                    || (url.contains("/Admin/Firmalar/Otobus/OtobusFirmalari"))
                    || (url.contains("/Admin/Firmalar/Tren/TrenFirmalari"))
                    || (url.contains("/Admin/Firmalar/Ucak/UcakFirmalari"))
                    || (url.contains("/Admin/Firmalar/Firmalar"))
                    || (url.contains("/Admin/Other/Haberler/Haberler"))
                    || (url.contains("/Admin/Other/Kampanyalar/Kampanyalar"))
                    || (url.contains("/Admin/Other/Kullanicilar/Kullanicilar"))
                    || (url.contains("/Admin/Other/Iletisimler"))
                    || (url.contains("/Admin/Seferler/Otobus/OtobusSeferleri"))
                    || (url.contains("/Admin/Seferler/Tren/TrenSeferleri"))
                    || (url.contains("/Admin/Seferler/Ucak/UcakSeferleri"))
                    || (url.contains("/Admin/Seferler/Seferler"))
                    || (url.contains("/Standart/Standart"))
                    || (url.contains("/Standart/BiletAl/Otobus/OtobusBileti"))
                    || (url.contains("/Standart/BiletAl/Otobus/Listele"))
                    || (url.contains("/Standart/BiletAl/Otobus/SatinAl"))
                    || (url.contains("/Standart/BiletAl/Tren/TrenBileti"))
                    || (url.contains("/Standart/BiletAl/Tren/Listele"))
                    || (url.contains("/Standart/BiletAl/Tren/SatinAl"))
                    || (url.contains("/Standart/BiletAl/Ucak/UcakBileti"))
                    || (url.contains("/Standart/BiletAl/Ucak/Listele"))
                    || (url.contains("/Standart/BiletAl/Ucak/SatinAl"))
                    || (url.contains("/Standart/BiletAl/BiletAl"))
                    || (url.contains("/Standart/SatinAldigimBiletler/SatinAldigimBiletler"))
                    || (url.contains("/Standart/SatinAldigimBiletler/Otobus"))
                    || (url.contains("/Standart/SatinAldigimBiletler/Tren"))
                    || (url.contains("/Standart/SatinAldigimBiletler/Ucak"))
                    || (url.contains("/Standart/Ayarlar"))
                    || (url.contains("/Standart/Haberler"))
                    || (url.contains("/Standart/Kampanyalar"))) {
                res.sendRedirect(req.getContextPath() + "/Login.xhtml");
            } else {
                chain.doFilter(request, response);
            }
        } else {
            if (url.contains("Register") || url.contains("Login")) {
                if (user_type == 0) {
                    res.sendRedirect(req.getContextPath() + "/Standart/Standart.xhtml");
                } else if (user_type == 1) {
                    res.sendRedirect(req.getContextPath() + "/Admin/Admin.xhtml");
                } else {
                    System.out.println("LoginFilter(Hata) (type kontrol if)");
                }
            } else if (url.contains("index")) {
                u = null;
                req.getSession().invalidate();
                res.sendRedirect(req.getContextPath() + "");
            } else {
                if (u.getType() == 0) {
                    if ((url.contains("/Admin/Admin")) || (url.contains("/Admin/Admin"))
                            || (url.contains("/Admin/Admin") || (url.contains("/Admin/Admin")))
                            || (url.contains("/Admin/Firmalar/Otobus/OtobusFirmalari"))
                            || (url.contains("/Admin/Firmalar/Tren/TrenFirmalari"))
                            || (url.contains("/Admin/Firmalar/Ucak/UcakFirmalari"))
                            || (url.contains("/Admin/Firmalar/Firmalar"))
                            || (url.contains("/Admin/Other/Haberler/Haberler"))
                            || (url.contains("/Admin/Other/Kampanyalar/Kampanyalar"))
                            || (url.contains("/Admin/Other/Kullanicilar/Kullanicilar"))
                            || (url.contains("/Admin/Other/Iletisimler"))
                            || (url.contains("/Admin/Seferler/Otobus/OtobusSeferleri"))
                            || (url.contains("/Admin/Seferler/Tren/TrenSeferleri"))
                            || (url.contains("/Admin/Seferler/Ucak/UcakSeferleri"))
                            || (url.contains("/Admin/Seferler/Seferler"))) {
                        res.sendRedirect(req.getContextPath() + "/Standart/Standart.xhtml");
                    } else {
                        chain.doFilter(request, response);
                    }
                } else if (u.getType() == 1) {
                    chain.doFilter(request, response);
                } else {
                    System.out.println("LoginFilter(Hata) (type kontro else)");
                    System.out.println(user_type);
                }
            }
        }
    }

    public static int getUser_type() {
        return user_type;
    }

    public static void setUser_type(int user_type) {
        LoginFilter.user_type = user_type;
    }

}
