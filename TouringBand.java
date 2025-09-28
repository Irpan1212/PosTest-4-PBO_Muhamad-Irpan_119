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
    
    public TouringBand(String nama, String genre, int tahunBerdiri, int jumlahAnggota, String venueTerakhir, int tiketTerjualTerakhir) {
        super(nama, genre, tahunBerdiri, jumlahAnggota); 
        this.venueTerakhir = venueTerakhir;
        this.tiketTerjualTerakhir = tiketTerjualTerakhir;
    }
    @Override
    public String getDetailTambahan() {
        return String.format(
            "Detail Touring:%n" +
            "  Venue Tur Terakhir: %s%n" +
            "  Tiket Terjual Terakhir: %d",
            venueTerakhir, tiketTerjualTerakhir
        );
    }
    
    public double hitungRataRataTiket(int totalKonser, int totalTiket) {
        return (double) totalTiket / totalKonser;
    }
    
    public double hitungRataRataTiket(int totalKonser, double totalPendapatan) { 
        return totalPendapatan / totalKonser;
    }
    
    @Override
    public String toString() {
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
