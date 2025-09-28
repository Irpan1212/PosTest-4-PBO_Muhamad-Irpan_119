/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bandmetal.model;

/**
 *
 * @author muham
 */
public abstract class Band { 
    protected String nama;
    protected String genre;
    protected int tahunBerdiri;
    protected int jumlahAnggota;

    // KONSTRUKTOR
    public Band(String nama, String genre, int tahunBerdiri, int jumlahAnggota) {
        this.nama = nama;
        this.genre = genre;
        this.tahunBerdiri = tahunBerdiri;
        this.jumlahAnggota = jumlahAnggota;
    }

    // METHOD ABSTRAK (Untuk Abstraction & Overriding)
    public abstract String getDetailTambahan(); 
    
    // METHOD UNTUK POLYMORPHISM (Overloading)
    public int hitungUsia(int tahunSaatIni) {
        return tahunSaatIni - tahunBerdiri;
    }
    
    // =========================================================
    // GETTERS & SETTERS YANG BENAR (MEMPERBAIKI ERROR)
    // =========================================================

    public String getNama() { 
        return nama; // Kembalikan nilai String
    }
    public void setNama(String nama) {
        this.nama = nama; // Tetapkan nilai
    }

    public String getGenre() { // TIPE KEMBALIAN HARUS STRING!
        return genre; 
    }
    public void setGenre(String genre) {
        this.genre = genre; 
    }

    public int getTahunBerdiri() { 
        return tahunBerdiri; 
    }
    public void setTahunBerdiri(int tahunBerdiri) {
        this.tahunBerdiri = tahunBerdiri; 
    }

    public int getJumlahAnggota() { 
        return jumlahAnggota; 
    }
    public void setJumlahAnggota(int jumlahAnggota) {
        this.jumlahAnggota = jumlahAnggota;
    }

    // =========================================================
    
    @Override
    public String toString() {
        return String.format(
            "--- Data Band Utama ---%n" +
            "Nama Band: %s%n" +
            "  Genre: %s%n" +
            "  Tahun Berdiri: %d%n" +
            "  Jumlah Anggota: %d%n" +
            "%s", 
            nama, genre, tahunBerdiri, jumlahAnggota, getDetailTambahan()
        );
    }
}