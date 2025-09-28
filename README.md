# Sistem Manajemen Band Metal

## Deskripsi Program
Sistem Manajemen Band Metal adalah program sederhana untuk mengelola data band metal. Program ini dirancang dengan menggunakan arsitektur MVC (Model-View-Controller) dan menerapkan konsep **inheritance** serta **enkapsulasi** untuk menciptakan kode yang lebih terstruktur dan *reusable*.

## Penjelasan Alur Program dan Struktur Package
Proyek ini diorganisir ke dalam tiga package utama, sesuai dengan arsitektur MVC dan konsep OOP:

1.  **`com.mycompany.bandmetal.model`**
    * **Fungsi:** Package ini berfungsi sebagai **Model**.
    * **Isi:** Berisi superclass `Band.java` dan dua subclassnya, `ManagedBand.java` dan `TouringBand.java`. Kelas `Band` memiliki properti dasar yang diwarisi oleh kedua subclass. Setiap subclass memiliki properti unik dan meng-*override* metode `toString()` untuk menampilkan informasi spesifik. Semua properti menggunakan *access modifier* `protected` atau `private` untuk memastikan **enkapsulasi** data.

2.  **`com.mycompany.bandmetal.service`**
    * **Fungsi:** Package ini berfungsi sebagai **Controller** (logika bisnis).
    * **Isi:** Berisi kelas `BandService.java`. Kelas ini bertanggung jawab penuh atas semua operasi CRUD (Create, Read, Update, Delete) dan pencarian. Kelas ini dapat mengelola objek dari berbagai jenis (superclass dan subclass), menunjukkan kekuatan **polimorfisme**.

3.  **`com.mycompany.bandmetal.main`**
    * **Fungsi:** Package ini berfungsi sebagai **View** dan **Controller** utama (*entry point*).
    * **Isi:** Berisi kelas `Main.java` yang mengelola menu interaktif untuk pengguna. Kelas ini menerima input, melakukan validasi, dan kemudian memanggil metode yang sesuai dari `BandService` untuk menjalankan operasi, termasuk memilih jenis band yang akan ditambahkan.

4. **Dokumentasi tiap Class**
   
    <img width="868" height="753" alt="image" src="https://github.com/user-attachments/assets/700d1181-bc90-423d-ada0-fdbb4224e7af" />

    Gambar Diatas adalah Code dari Superclass dengan nama class Band.java

    <img width="1370" height="775" alt="image" src="https://github.com/user-attachments/assets/02edfb3d-7d94-40ea-b8ba-1313f7d3324d" />

    Gambar diatas adalah coode dari subclass dengan nama class ManagedBand.java

    <img width="1414" height="805" alt="image" src="https://github.com/user-attachments/assets/7a10a812-7b77-4e3c-9d54-7300e400bde7" />

    Gambar diatas adalah code dari subclass dengan nama class TouringBand.java

    <img width="530" height="794" alt="image" src="https://github.com/user-attachments/assets/ab1784c6-22e8-4713-a08b-e710765e21de" />

    Gambar diatas adalah code class BandService.java

    <img width="616" height="255" alt="image" src="https://github.com/user-attachments/assets/c8d97ccd-95d2-4d4c-84fb-e1d5a4139352" />

    Gambar diatas adalah gambar untuk import apa saja pada class Main dengan nama class Main.java

   ## Pengunaan Getter dan Setter

    <img width="1122" height="262" alt="image" src="https://github.com/user-attachments/assets/8aaeed84-09b3-4b28-a331-87f6ab40c561" />

    Gambar diatas adalah penggunaan getter dan setter pada superclass Band.java

   ## Penggunaan Override

    <img width="709" height="346" alt="image" src="https://github.com/user-attachments/assets/9718e1a4-bb5f-4f19-9c70-a48d1a73fd31" />

   Gambar diatas adalah penggunaan override pada superclass Band.java
   
  ## Output program

  1. Menu tambah Band Metal
  
  <img width="587" height="558" alt="Screenshot 2025-09-23 201953" src="https://github.com/user-attachments/assets/6a702cbc-4fec-4249-9667-0732a275973a" />

  Pada gambar diatas menu tambah Band Metal, pada pilihan ini terdapat 2 pilihan yaitu managed Band atau Touring Band

  2. Menu Tampilkan Band Metal

  <img width="415" height="681" alt="image" src="https://github.com/user-attachments/assets/e2d90a45-63c2-416e-bbcb-48dbbd901e27" />

  Pada gambar diatas adalah tampilan jika memiliih menu menu tampilkan Band Metal    

  3. Menu ubah data Band, Hapus Band, cari Band, Keluar

  <img width="388" height="223" alt="image" src="https://github.com/user-attachments/assets/d34bd1b6-9a0b-42a6-9f5e-fd86c675fb0d" />

   ## Penambahan Abstraction Dan Polymorphism

   1. penerapan Abstraction

      <img width="836" height="263" alt="image" src="https://github.com/user-attachments/assets/99cbff4a-108d-49ab-a481-ff46349303bd" />

       Kelas Band dideklrasikan sebagai abstract , pada kelas ini ada atribut umum seperti nama, genre, tahun berdiri dan tidak dapat di insratiente secara langsung.

      <img width="540" height="144" alt="image" src="https://github.com/user-attachments/assets/c87487a6-4088-4c14-82a7-20e690bc4aba" />

        Gambar diatas adalah method abstrak pada getDetailTambahan().

  3. Penerapan Interface

     <img width="795" height="195" alt="image" src="https://github.com/user-attachments/assets/af1bab88-3cfa-48bf-99e3-ba80e84bae31" />

     Gambar diatas interface BandManagement yang mendefinisikan kontrak CRUD.

     <img width="616" height="154" alt="image" src="https://github.com/user-attachments/assets/95622eb5-ffa1-421b-ab49-ef5d2cd84335" />

     Gambar diatas ada dikelas BandService yang dimana mengimplemtasikan BandManagement, agar menjamin semua operasi CRUD telah disedikan dan memenuhi kontrak yang didefinisikan oleh interface.


  4. Penerapan Overriding

     <img width="516" height="222" alt="image" src="https://github.com/user-attachments/assets/0d5feac3-453f-4b3f-b4ec-52364a2c6cb0" />

     Penerapan overriding pada kelas TouringBand.

     Kedua subclass (Managed dan Touring) wajib meng-override method abstrak getDetailTambahan() dari Band. ManagedBand mengembalikan detail manajer, sementara TouringBand mengembalikan detail venue dan tiket.

     <img width="670" height="224" alt="image" src="https://github.com/user-attachments/assets/ace2b602-62a4-40e0-8755-fa79313706cb" />

     Penerapan Overriding pada kelas ManagedBand.

     Kedua subclass juga meng-override toString() untuk menyertakan detail tambahan tersebut, sehingga panggilan band.toString() di Main.java memberikan format yang berbeda sesuai dengan tipe objeknya (Managed atau Touring).


  5. Penerapan Overloading

     <img width="958" height="110" alt="image" src="https://github.com/user-attachments/assets/a132585f-2352-4cf3-8a51-56a1c8c5c3d2" />


     <img width="827" height="168" alt="image" src="https://github.com/user-attachments/assets/9dc61edb-5a01-4d1e-a2f0-b65b7ac10736" />

     Kelas model memiliki method dengan nama yang sama tetapi dengan daftar parameter yang berbeda.



      



  
