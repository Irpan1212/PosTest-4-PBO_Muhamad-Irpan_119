/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bandmetal.main;

import com.mycompany.bandmetal.model.Band;
import com.mycompany.bandmetal.model.ManagedBand;
import com.mycompany.bandmetal.model.TouringBand;
import com.mycompany.bandmetal.service.BandService;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static final BandService bandService = new BandService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try (scanner) {
            boolean running = true;
            while (running) {
                tampilkanMenu();
                try {
                    int pilihan = scanner.nextInt();
                    scanner.nextLine();
                    
                    switch (pilihan) {
                        case 1 -> tambahBand();
                        case 2 -> tampilkanSemuaBand();
                        case 3 -> ubahDataBand();
                        case 4 -> hapusBand();
                        case 5 -> cariBand();
                        case 6 -> {
                            running = false;
                            System.out.println("Terima kasih telah menggunakan aplikasi manajemen band metal!");
                        }
                        default -> System.out.println("Pilihan tidak valid. Silakan pilih 1-6.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Input tidak valid! Silakan masukkan angka.");
                    scanner.nextLine();
                }
            }
        }
    }

    private static void tampilkanMenu() {
        System.out.println("\n=== MANAJEMEN BAND METAL ===");
        System.out.println("1. Tambah Band Baru");
        System.out.println("2. Tampilkan Semua Band");
        System.out.println("3. Ubah Data Band");
        System.out.println("4. Hapus Band");
        System.out.println("5. Cari Band");
        System.out.println("6. Keluar");
        System.out.print("Pilih menu (1-6): ");
    }

    private static void tambahBand() {
        System.out.println("\n--- TAMBAH BAND BARU ---");
        System.out.println("Pilih jenis band:");
        System.out.println("1. Managed Band");
        System.out.println("2. Touring Band");
        System.out.print("Pilihan (1/2): ");
        
        try {
            int jenis = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Masukkan nama band: ");
            String nama = scanner.nextLine();
            
            System.out.print("Masukkan genre: ");
            String genre = scanner.nextLine();
            
            System.out.print("Masukkan tahun berdiri: ");
            int tahun = scanner.nextInt();
            System.out.print("Masukkan jumlah anggota: ");
            int anggota = scanner.nextInt();
            scanner.nextLine();
            
            Band bandBaru = null;

            switch (jenis) {
                case 1 -> {
                    System.out.print("Nama manajer: ");
                    String namaManager = scanner.nextLine();
                    System.out.print("Jumlah tur tahun ini: ");
                    int jumlahTur = scanner.nextInt();
                    scanner.nextLine();
                    bandBaru = new ManagedBand(nama, genre, tahun, anggota, namaManager, jumlahTur);
                }
                case 2 -> {
                    System.out.print("Venue tur terakhir: ");
                    String venueTerakhir = scanner.nextLine();
                    System.out.print("Jumlah tiket terjual terakhir: ");
                    int tiketTerjual = scanner.nextInt();
                    scanner.nextLine();
                    bandBaru = new TouringBand(nama, genre, tahun, anggota, venueTerakhir, tiketTerjual);
                }
                default -> {
                    System.out.println("Pilihan tidak valid. Band tidak ditambahkan.");
                    return;
                }
            }
            
            bandService.addBand(bandBaru);
            System.out.println("Band '" + nama + "' berhasil ditambahkan!");
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Operasi dibatalkan.");
            scanner.nextLine();
        }
    }
    

    private static void tampilkanSemuaBand() {
        System.out.println("\n=== DAFTAR SEMUA BAND ===");
        ArrayList<Band> bands = bandService.getAllBands();
        if (bands.isEmpty()) {
            System.out.println("Belum ada data band.");
            return;
        }
        for (int i = 0; i < bands.size(); i++) {
            System.out.println((i + 1) + ". " + bands.get(i).toString());
            System.out.println();
        }
    }
    
    private static void ubahDataBand() {
        System.out.println("\n--- UBAH DATA BAND ---");
        tampilkanSemuaBand();
        if (bandService.getAllBands().isEmpty()) {
            return;
        }
        
        System.out.print("Pilih nomor band yang ingin diubah: ");
        try {
            int index = scanner.nextInt() - 1;
            scanner.nextLine();
            
            Band band = bandService.getBand(index);
            if (band == null) {
                System.out.println("Nomor band tidak valid!");
                return;
            }
            
            System.out.println("Data saat ini: \n" + band.toString());
            
            System.out.print("Masukkan nama baru (kosongkan jika tidak diubah): ");
            String namaBaru = scanner.nextLine();
            if (!namaBaru.isEmpty()) band.setNama(namaBaru);
            
            System.out.print("Masukkan genre baru (kosongkan jika tidak diubah): ");
            String genreBaru = scanner.nextLine();
            if (!genreBaru.isEmpty()) band.setGenre(genreBaru);
            
            System.out.print("Masukkan tahun berdiri baru (kosongkan jika tidak diubah): ");
            String tahunInput = scanner.nextLine();
            if (!tahunInput.isEmpty()) {
                band.setTahunBerdiri(Integer.parseInt(tahunInput));
            }

            System.out.print("Masukkan jumlah anggota baru (kosongkan jika tidak diubah): ");
            String anggotaInput = scanner.nextLine();
            if (!anggotaInput.isEmpty()) {
                band.setJumlahAnggota(Integer.parseInt(anggotaInput));
            }
            
            bandService.updateBand(index, band);
            System.out.println("Data band berhasil diubah!");
            
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Input tidak valid. Operasi dibatalkan.");
            scanner.nextLine();
        }
    }
    
    private static void hapusBand() {
        System.out.println("\n--- HAPUS BAND ---");
        tampilkanSemuaBand();
        if (bandService.getAllBands().isEmpty()) {
            return;
        }
        
        System.out.print("Pilih nomor band yang ingin dihapus: ");
        try {
            int index = scanner.nextInt() - 1;
            scanner.nextLine();
            
            Band band = bandService.getBand(index);
            if (band == null) {
                System.out.println("Nomor band tidak valid!");
                return;
            }
            
            System.out.print("Yakin ingin menghapus data band '" + band.getNama() + "'? (y/t): ");
            String konfirmasi = scanner.nextLine();
            
            if (konfirmasi.equalsIgnoreCase("y")) {
                bandService.deleteBand(index);
                System.out.println("Band berhasil dihapus!");
            } else {
                System.out.println("Penghapusan dibatalkan.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Operasi dibatalkan.");
            scanner.nextLine();
        }
    }
    
    private static void cariBand() {
        System.out.println("\n--- CARI BAND ---");
        System.out.print("Masukkan kata kunci (nama/genre): ");
        String keyword = scanner.nextLine();
        
        ArrayList<Band> hasil = bandService.searchBands(keyword);
        
        if (hasil.isEmpty()) {
            System.out.println("Tidak ada band yang ditemukan untuk kata kunci '" + keyword + "'.");
        } else {
            System.out.println("\n=== Hasil Pencarian ===");
            for (Band band : hasil) {
                System.out.println(band.toString());
                System.out.println();
            }
        }
    }
}
