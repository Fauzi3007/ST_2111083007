/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fauzi.nilai.vo;


/**
 *
 * @author Fauzi
 */


public class Mahasiswa {
  
    private long id;
    private String nama;
    private String email;

    public Mahasiswa() {
    }

    public Mahasiswa(long id, String nama, String email) {
        this.id = id;
        this.nama = nama;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Mahasiswa{" + "id=" + id + ", nama=" + nama + ", email=" + email + '}';
    }
    
    
    
    
}
