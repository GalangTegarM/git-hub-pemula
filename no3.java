import java.util.ArrayList;
import java.util.Scanner;

class kelompok {
    String nama, kategori;
    int rata;

    public kelompok(String nama, String kategori, int rata) {
        this.nama = nama;
        this.kategori = kategori;
        this.rata = rata;
    }

    public String getnama() {
        return nama;
    }

    public String getkategori() {
        return kategori;
    }
    public int getrata(){
        return rata;
    }
    public void setkategori(String kategori){
        this.kategori = kategori;
    }
    public void setrata(int rata){
        this.rata = rata;
    }
}

class gas{
    Scanner inp = new Scanner(System.in);
    ArrayList<kelompok> kel = new ArrayList<>();

    public static void main(String[] args) {
        gas sm = new gas();
        sm.run();
    }

    void run() {
        int pilihan = 0;
        while (pilihan != 4) {
            System.out.println("Menu Pilihan : ");
            System.out.println("1. Input Data Kelompok");
            System.out.println("2. Input Nilai Kelompok");
            System.out.println("3. View Data Kelompok");
            System.out.println("4. Keluar Program");
            System.out.print("Silahkan Pilih : ");
            pilihan = inp.nextInt();
            if (pilihan == 1) {
                namakel();
            }else if(pilihan ==2) {
                nilai();
            }else if(pilihan ==3) {
                viewData();
            }
        }
    }
    void namakel() {
        System.out.println("Masukkan Data Mahasiswa");
        System.out.print("Nama Kelompok: ");
        String nama = inp.next();
        System.out.println("UI/UX");
        System.out.println("Algoritma");
        System.out.println("Data Processing");
        System.out.print("Pilih Kategori Lomba: ");
        String kategori = inp.next();

        
        boolean namaExists = false;
        for (kelompok k : kel) {
            if (k.getnama().equalsIgnoreCase(nama)) {
                namaExists = true;
                break;
            }
        }

        if (!namaExists) {
            kel.add(new kelompok(nama, kategori, 0));
            System.out.println("Berhasil Ditambahkan");
        } else {
            System.out.println("Nama sudah digunakan");
        }
        for(int a = 0;a < kel.size();a++){
            if(kel.get(a).getkategori().toLowerCase().contains("ui")){
                kel.get(a).setkategori("UI/UX");
            }else if(kel.get(a).getkategori().toLowerCase().contains("algo")){
                kel.get(a).setkategori("Algoritma");
            }else if(kel.get(a).getkategori().toLowerCase().contains("data")){
                kel.get(a).setkategori("Data Processing");
            }else{

            }
        }
        } 
    

    void viewData() {
        System.out.println("Data Mahasiswa");
        for (int a = 0; a < kel.size(); a++) {
            String nama = kel.get(a).getnama();
            String kategori = kel.get(a).getkategori();
            int rata = kel.get(a).getrata();
            System.out.println("\tNama : " + nama);
            System.out.println("\tKategori : " + kategori);
            System.out.println("\tNilai Rata-Rata : " + rata);
        }
    }

    void nilai(){
        System.out.println("Masukkan Nama Kelompok =");
        String kelkel = inp.next();

        for(int a = 0;a < kel.size();a++){
            if (kelkel.equals(kel.get(a).getnama())){
                kel.get(a).getkategori();
                if(kel.get(a).getkategori().equals("UI/UX")){
                    System.out.println("Nilai Penjelasan Latar Belakang dan Target Produk =");
                    int target = inp.nextInt();
                    System.out.println("Nilai Skenario Penggunaan =");
                    int skenario = inp.nextInt();
                    System.out.println("Nilai Desain =");
                    int desain = inp.nextInt();
                    System.out.println("Nilai Konsisten =");
                    int konsisten = inp.nextInt();
                    int rata = ((target+skenario+desain+konsisten)/4);
                    System.out.println("Nilai Rata Rata ="+rata);
                    kel.get(a).setrata(rata);
                }else if(kel.get(a).getkategori().equals("Algoritma")){
                    System.out.println("Nilai Ketetapan Hasil =");
                    int tetap = inp.nextInt();
                    System.out.println("Nilai Waktu Eksekusi =");
                    int eksekusi = inp.nextInt();
                    System.out.println("Nilai Pemanfaatan Resource =");
                    int resource = inp.nextInt();
                    int rata = (tetap+eksekusi+resource)/3;
                    System.out.println("Nilai Rata Rata ="+rata);
                    kel.get(a).setrata(rata);
                }else if(kel.get(a).getkategori().equals("Data Processing")){
                    System.out.println("Nilai Ketetapan Hasil =");
                    int tetap = inp.nextInt();
                    System.out.println("Nilai Waktu Eksekusi =");
                    int eksekusi = inp.nextInt();
                    System.out.println("Nilai Pemanfaatan Resource =");
                    int resource = inp.nextInt();
                    int rata = (tetap+eksekusi+resource)/3;
                    System.out.println("Nilai Rata Rata ="+rata);
                    kel.get(a).setrata(rata);
                }
            }else{
                System.out.println("Nama Tidak Ditemukan");
            }
        }
    }
}