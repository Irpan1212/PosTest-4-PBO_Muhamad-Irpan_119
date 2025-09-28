/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bandmetal.service;
import com.mycompany.bandmetal.model.Band;
import java.util.ArrayList;
/**
 *
 * @author muham
 */
public class BandService implements BandManagement { 
    private ArrayList<Band> bands = new ArrayList<>();
    @Override
    public void addBand(Band band) {
        bands.add(band);
    }
    @Override
    public ArrayList<Band> getAllBands() {
        return bands;
    }
   @Override
    public ArrayList<Band> searchBands(String keyword) {
        ArrayList<Band> hasilPencarian = new ArrayList<>();
        String key = keyword.toLowerCase(); // Hindari memanggil toLowerCase() berulang-ulang
    
    for (Band band : bands) {
        // Kondisi Positif: Jika ditemukan di Genre ATAU ditemukan di Nama
        if (band.getGenre().toLowerCase().contains(key) ||
            band.getNama().toLowerCase().contains(key)) {
            
            hasilPencarian.add(band);
        }
    }
    return hasilPencarian;
}
    @Override
    public boolean updateBand(int index, Band updatedBand) {
        if (index >= 0 && index < bands.size()) {
            bands.set(index, updatedBand);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBand(int index) {
        if (index >= 0 && index < bands.size()) {
            bands.remove(index);
            return true;
        }
        return false;
    }
    
    @Override
    public Band getBand(int index) {
        if (index >= 0 && index < bands.size()) {
            return bands.get(index);
        }
        return null;
    }
}