/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Nal
 */
public class giaNuocDT {
    private int id;
    private String doiTuong;
    private float donGia;
    private int namApdung;

    public giaNuocDT() {
    }

    public giaNuocDT(int id, String doiTuong, float donGia, int namApdung) {
        this.id = id;
        this.doiTuong = doiTuong;
        this.donGia = donGia;
        this.namApdung = namApdung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoiTuong() {
        return doiTuong;
    }

    public void setDoiTuong(String doiTuong) {
        this.doiTuong = doiTuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public int getNamApdung() {
        return namApdung;
    }

    public void setNamApdung(int namApdung) {
        this.namApdung = namApdung;
    }

    @Override
    public String toString() {
        return "giaNuocDT{" + "id=" + id + ", doiTuong=" + doiTuong + ", donGia=" + donGia + ", namApdung=" + namApdung + '}';
    }
    
}
