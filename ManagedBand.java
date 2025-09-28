/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bandmetal.model;


public class ManagedBand extends Band {
    private String namaManager;
    private int jumlahTurTahunIni;

     public ManagedBand(String nama, String genre, int tahunBerdiri, int jumlahAnggota, String namaManager, int jumlahTurTahunIni) {
        // Panggil konstruktor dari Superclass Band
        super(nama, genre, tahunBerdiri, jumlahAnggota); 
        this.namaManager = namaManager;
        this.jumlahTurTahunIni = jumlahTurTahunIni;
    }
    
    @Override
    public String getDetailTambahan() {
        return String.format(
            "Detail Manager:%n" +
            "  Nama Manajer: %s%n" +
            "  Jumlah Tur Tahun Ini: %d",
            namaManager, jumlahTurTahunIni
        );
    }
    public String hitungUsia(int tahunSaatIni, String namaLabel) {
        int usia = super.hitungUsia(tahunSaatIni); 
        return nama + " telah bersama label " + namaLabel + " selama " + usia + " tahun!";
    }
    
    @Override
    public String toString() {
        return String.format(
            "Jenis Band: Managed%n" +
            "Nama Band: %s%n" +
            "  Genre: %s%n" +
            "  Tahun Berdiri: %d%n" +
            "  Jumlah Anggota: %d%n" +
            "%s",
            nama, genre, tahunBerdiri, jumlahAnggota, getDetailTambahan() 
    }

}
