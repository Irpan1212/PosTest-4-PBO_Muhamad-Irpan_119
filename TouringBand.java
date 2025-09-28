/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bandmetal.model;

/**
 *
 * @author muham
 */
public class TouringBand extends Band {
    private String venueTerakhir;
    private int tiketTerjualTerakhir;
    
    // Baris 15 (ERROR DI SINI)
    public TouringBand(String nama, String genre, int tahunBerdiri, int jumlahAnggota, String venueTerakhir, int tiketTerjualTerakhir) {
        // Panggil konstruktor dari Superclass Band
        super(nama, genre, tahunBerdiri, jumlahAnggota); 
        this.venueTerakhir = venueTerakhir;
        this.tiketTerjualTerakhir = tiketTerjualTerakhir;
    }
    // ... (Konstruktor & Getters/Setters) ...

    // Poin 1: Polymorphism - Overriding (Implementasi method abstrak)
    @Override
    public String getDetailTambahan() {
        return String.format(
            "Detail Touring:%n" +
            "  Venue Tur Terakhir: %s%n" +
            "  Tiket Terjual Terakhir: %d",
            venueTerakhir, tiketTerjualTerakhir
        );
    }
    
    // Poin 2: Polymorphism - Overloading (Contoh: Menghitung rata-rata tiket)
    public double hitungRataRataTiket(int totalKonser, int totalTiket) { // Versi 1
        return (double) totalTiket / totalKonser;
    }
    
    public double hitungRataRataTiket(int totalKonser, double totalPendapatan) { // Versi 2 (Overloading)
        // Logika berbeda, misalnya menghitung rata-rata pendapatan per konser
        return totalPendapatan / totalKonser;
    }
    
    @Override
    public String toString() { // Overriding toString() untuk tampilan spesifik
        return String.format(
            "Jenis Band: Touring%n" +
            "Nama Band: %s%n" +
            "  Genre: %s%n" +
            "  Tahun Berdiri: %d%n" +
            "  Jumlah Anggota: %d%n" +
            "%s",
            nama, genre, tahunBerdiri, jumlahAnggota, getDetailTambahan()
        );
    }
}