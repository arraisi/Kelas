/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package belajar;

import java.util.Map;

/**
 *
 * @author arrai
 */
public class Kelas {
    private Map<String, Pengajar> daftarPengajar;
    private Map<String, Mahasiswa> daftarMahasiswa;
    private String namaKelas, idKelas;

    public Map<String, Pengajar> getDaftarPengajar() {
        return daftarPengajar;
    }

    public void setDaftarPengajar(Map<String, Pengajar> daftarPengajar) {
        this.daftarPengajar = daftarPengajar;
    }



    public Map<String, Mahasiswa> getDaftarMahasiswa() {
        return daftarMahasiswa;
    }

    public void setDaftarMahasiswa(Map<String, Mahasiswa> daftarMahasiswa) {
        this.daftarMahasiswa = daftarMahasiswa;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public String getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(String idKelas) {
        this.idKelas = idKelas;
    }

    
}
