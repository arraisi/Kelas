package belajar;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class mainKelas {

    public static void main(String[] args) {
        // TODO code application logic here

        boolean isTambah = true;
        boolean isKurang = true;
        Scanner input = new Scanner(System.in);
        Map<String, Kelas> daftarKelas = new LinkedHashMap<String, Kelas>();
        //Pengajar pengajar = new Pengajar();
        Map<String, Pengajar> daftarPengajar = new LinkedHashMap<String, Pengajar>();
        //Peminjam pinjam = new Peminjam();
        Map<String, Mahasiswa> daftarMahasiswa = new LinkedHashMap<String, Mahasiswa>();

        //PANGGIL METHODS DAFTAR KELAS
        Map<String, Kelas> daftarKelasSekarang = inputKelas();
        //PANGGIL METHODS DAFTAR PENGAJAR
        Map<String, Pengajar> daftarPengajarSekarang = inputPengajar(daftarKelasSekarang);
        //PANGGIL METHODS DAFTAR PENGAJAR
        Map<String, Mahasiswa> daftarMahasiswaSekarang = inputMahasiswa();
        //PANGGIL METHODS AMBIL KELAS
        Map<String, Kelas> daftarKelasDiPilih = dataKelas(daftarKelasSekarang, daftarPengajarSekarang, daftarMahasiswaSekarang);

    }

//METHODS KELAS
    public static Map<String, Kelas> inputKelas() {
        boolean isTambah = true;
        boolean isKurang = true;
        Map<String, Kelas> daftarKelas = new LinkedHashMap<String, Kelas>();
        while (isTambah) {
            Scanner input = new Scanner(System.in);
            Kelas kelas = new Kelas();
            System.out.println(" ***********************************************************");
            System.out.println(" Tambah Data Kelas ! ");
            System.out.print(" Nama Kelas : ");
            kelas.setNamaKelas(input.next());
            System.out.print(" ID Kelas : ");
            daftarKelas.put(input.next(), kelas);
            System.out.print(" Tambah data baru kembali ?(jawab dengan true/false : ");
            isTambah = input.nextBoolean();
            //return daftarBuku;
        }
        for (Map.Entry<String, Kelas> entry : daftarKelas.entrySet()) {
            System.out.println(entry.getKey());
            Kelas kelas = entry.getValue();
            System.out.println("  Nama Kelas : " + kelas.getNamaKelas());
        }
        System.out.println("____________________________________________________________________ ");

        return daftarKelas;
    }

//METHODS PENGAJAR
    public static Map<String, Pengajar> inputPengajar(Map<String, Kelas> pilihKelas) {
        boolean isTambah = true;
        boolean isKurang = true;
        Kelas kelasPengajar = new Kelas();
        Map<String, Pengajar> daftarPengajar = new LinkedHashMap<String, Pengajar>();
        while (isTambah) {
            Scanner input = new Scanner(System.in);
            Pengajar pengajar = new Pengajar();
            System.out.println(" ***********************************************************");
            System.out.println(" Tambah Data Pengajar ! ");
            System.out.print(" Nama Pengajar : ");
            String namePengajar = input.next();
            pengajar.setNamaPengajar(namePengajar);
            System.out.print(" ID Pengajar : ");
            daftarPengajar.put(input.next(), pengajar);
            System.out.println("Mengajar Dikelas dengan ID: ");
            kelasPengajar.setIdKelas(input.next());
            
            System.out.print(" Tambah data baru kembali ?(jawab dengan true/false : ");
            isTambah = input.nextBoolean();

        }
        for (Map.Entry<String, Pengajar> entry : daftarPengajar.entrySet()) {
            System.out.println(entry.getKey());
            Pengajar pengajar = entry.getValue();
            System.out.println("  Nama Pengajar : " + pengajar.getNamaPengajar());
            System.out.println("  Mengajar di Kelas ID : "+kelasPengajar.getIdKelas()+" "+kelasPengajar.getNamaKelas());
        }
        System.out.println("____________________________________________________________________ ");
        return daftarPengajar;
    }

//MHETODS MAHASISWA
    public static Map<String, Mahasiswa> inputMahasiswa() {
        boolean isTambah = true;
        boolean isKurang = true;
        Map<String, Mahasiswa> daftarMahasiswa = new LinkedHashMap<String, Mahasiswa>();
        while (isTambah) {
            Scanner input = new Scanner(System.in);
            Mahasiswa mahasiswa = new Mahasiswa();
            System.out.println(" ***********************************************************");
            System.out.println(" Tambah Data Mahasiswa ! ");
            System.out.print(" Nama Mahasiswa : ");
            mahasiswa.setNama(input.next());
            System.out.print(" ID Mahasiswa : ");
            daftarMahasiswa.put(input.next(), mahasiswa);
            System.out.print(" Tambah data baru kembali ?(jawab dengan true/false : ");
            isTambah = input.nextBoolean();
            //return daftarBuku;
        }
        for (Map.Entry<String, Mahasiswa> entry : daftarMahasiswa.entrySet()) {
            System.out.println(entry.getKey());
            Mahasiswa mahasiswa = entry.getValue();
            System.out.println("  Nama Mahasiswa : " + mahasiswa.getNama());
        }
        System.out.println("____________________________________________________________________ ");
        return daftarMahasiswa;
    }

//METHODS PILIH KELAS
    private static Map<String, Kelas> dataKelas(Map<String, Kelas> pilihKelas, Map<String, Pengajar> pengajarKelas, Map<String, Mahasiswa> mahasiswaKelas) {
        boolean isTambah = true;
        boolean isKurang = true;
        boolean ambilKelas = true;
        Scanner input = new Scanner(System.in);
        Kelas kelas = new Kelas();
        System.out.println("Pilih kelas? y/n");
        String jawab = input.next();

        if (jawab.equals("y")) {

            System.out.println("ID Pengajar : ");
            String id = input.next();
            Pengajar pengajar = pengajarKelas.get(id);
            kelas.setDaftarPengajar(pengajarKelas);
            System.out.println("Nama : " + pengajar.getNamaPengajar());
            while (isTambah) {
                System.out.println("ID Mahasiswa : ");
                id = input.next();

                Mahasiswa mahasiswa = mahasiswaKelas.get(id);

                mahasiswaKelas.put(id, mahasiswa);
                kelas.setDaftarMahasiswa(mahasiswaKelas);
                System.out.println("Nama : " + mahasiswa.getNama());
                System.out.print(" Tambah mahasiswa ?(jawab dengan true/false : ");
                isTambah = input.nextBoolean();
            }

            while (ambilKelas) {
                System.out.println("Masukan ID kelas yang diambil : ");
                id = input.next();
                kelas = pilihKelas.get(id);
                System.out.println("Nama Kelas : " + kelas.getNamaKelas());
                System.out.println("Yakin Ingin Pilih Kelas Tersebut? y/n");
                jawab = input.next();

                if (jawab.equals("y")) {
                    pilihKelas.put(id, kelas);

                }
                for (Map.Entry<String, Kelas> entry : pilihKelas.entrySet()) {
                    System.out.println(entry.getKey());
                    Kelas dipilih = entry.getValue();
                    System.out.println(" Nama Mahasiswa     : " + kelas.getDaftarMahasiswa());

                }

            }
        }

        return pilihKelas;
    }

}
