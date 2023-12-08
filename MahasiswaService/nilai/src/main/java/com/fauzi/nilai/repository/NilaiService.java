/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fauzi.nilai.repository;

import com.fauzi.nilai.entity.Nilai;
import com.fauzi.nilai.vo.Mahasiswa;
import com.fauzi.nilai.vo.Matakuliah;
import com.fauzi.nilai.vo.ResponseTemplate;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Fauzi
 */
@Service
public class NilaiService {
    @Autowired
    private NilaiRepository nilaiRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    public List<Nilai> getAll(){
        return nilaiRepository.findAll();
    } 
    
    public void insert(Nilai nilai){
        Optional<Nilai> nilaiOptional = nilaiRepository.findById(nilai.getId());
        
        
        if (nilaiOptional.isPresent()) {
            throw new IllegalStateException("Nilai Mahasiswa Sudah Ada");
        }
        
       nilaiRepository.save(nilai);
    }
    
    public void delete(long id){
        boolean ada = nilaiRepository.existsById(id);
        if (!ada) {
            throw new IllegalStateException("Nilai ini tidak ada");
        }
        nilaiRepository.deleteById(id);
    }
    
    @Transactional
    public void update(Long id, Long idMahasiswa, Long idMatakuliah, Double nilai){
        Nilai nilaiUpdate = nilaiRepository.findById(id)
        .orElseThrow(()-> new IllegalStateException("Nilai tidak ada"));
        
        if (idMahasiswa != null && !Objects.equals(nilaiUpdate.getIdMahasiswa(), idMahasiswa)) {
            nilaiUpdate.setIdMahasiswa(idMahasiswa);
        }
        
        if (idMatakuliah != null && !Objects.equals(nilaiUpdate.getIdMatakuliah(), idMatakuliah)) {
            nilaiUpdate.setIdMatakuliah(idMatakuliah);
        }
        
        if (nilai != null && Objects.equals(nilaiUpdate.getNilai(), nilai)) {
            nilaiUpdate.setNilai(nilai);
        }
    }
    
    
    public ResponseTemplate getNilai(Long nilaiId){
        ResponseTemplate vo = new ResponseTemplate();
        Nilai nilai = nilaiRepository.findById(nilaiId).orElseThrow(()->new IllegalStateException("Nilai Tidak Ada"));
        Mahasiswa mahasiswa = restTemplate.getForObject("http://localhost:9001/api/v1/mahasiswa/"
                +nilai.getIdMahasiswa(),Mahasiswa.class);
        
        Matakuliah matakuliah = restTemplate.getForObject("http://localhost:9002/api/v1/matakuliah/"+nilai.getIdMatakuliah(),Matakuliah.class );
        vo.setNilai(nilai);
        vo.setMahasiswa(mahasiswa);
        vo.setMatakuliah(matakuliah);
        return vo;
    }
}
