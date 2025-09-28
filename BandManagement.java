/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.bandmetal.service;

/**
 *
 * @author muham
 */
import com.mycompany.bandmetal.model.Band;
import java.util.ArrayList;

// Interface untuk mendefinisikan kontrak manajemen data (Abstraction)
public interface BandManagement {
    void addBand(Band band);
    ArrayList<Band> getAllBands();
    ArrayList<Band> searchBands(String keyword);
    boolean updateBand(int index, Band updatedBand);
    boolean deleteBand(int index);
    Band getBand(int index);
}