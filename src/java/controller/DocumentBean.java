/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DocumentDao;
import entity.Document;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author Göymen
 */
@Named
@SessionScoped
public class DocumentBean implements Serializable {

    private Document entity;
    private DocumentDao dao;

    private Part doc;

    private final String uploadto = "C:/Users/Göymen/Desktop/";

    public void upload(int user_id) {

        try {
            InputStream input = doc.getInputStream();
            File f = new File(uploadto + doc.getSubmittedFileName());

            Files.copy(input, f.toPath());

            entity = this.getEntity();
            entity.setUser_id(user_id);
            entity.setFilePath(f.getParent());
            entity.setFileName(f.getName());
            entity.setFileType(doc.getContentType());
            if (entity.getFileType().contains("image")) {
                List<Document> list = this.read(user_id);
                this.getDao().create(entity);
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Lütfen Bir Resim Dosyası Giriniz!"));
            }

        } catch (IOException e) {
            System.out.println("Hata(DocumentBean(Upload)): " + e.getMessage());
        }

    }

    public List<Document> read(int id) {
        return this.getDao().read(id);
    }

    public Document getEntity() {
        if (this.entity == null) {
            entity = new Document();
        }
        return entity;
    }

    public void setEntity(Document entity) {
        this.entity = entity;
    }

    public DocumentDao getDao() {
        if (this.dao == null) {
            dao = new DocumentDao();
        }
        return dao;
    }

    public void setDao(DocumentDao dao) {
        this.dao = dao;
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }

    public String getUploadto() {
        return uploadto;
    }

}
