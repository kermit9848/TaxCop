package com.driko.dtrytomergemarkone;

public class User {
    public String nama, nik, npwp, alamat, notelp, email;

    public User(){

    }

    public User(String nama, String nik, String npwp, String alamat, String notelp, String email){
        this.nama=nama;
        this.nik=nik;
        this.npwp=npwp;
        this.alamat=alamat;
        this.notelp=notelp;
        this.email=email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
