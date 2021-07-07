package com.example.autogalleryspring.service;

import com.example.autogalleryspring.dto.AliciDTO;
import com.example.autogalleryspring.dto.AraciDTO;
import com.example.autogalleryspring.entity.Alici;
import com.example.autogalleryspring.entity.Araci;
import com.example.autogalleryspring.repo.IAraciRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service(value = "araciService")
public class AraciServiceImpl implements IAraciService {

    private IAraciRepo araciRepo;
    private ModelMapper modelMapper;

    @Autowired
    public AraciServiceImpl(IAraciRepo araciRepo, ModelMapper modelMapper) {
        this.araciRepo = araciRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public AraciDTO idyeGoreGetir(Long id) {
        return modelMapper.map(araciRepo.getById(id), AraciDTO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AraciDTO araciKaydet(AraciDTO araci) throws Exception {
        List<Araci> araciList = araciRepo.findAllByTcKimlikNo(araci.getTcKimlikNo());
        if(araciList.size()>0){
            throw new Exception("Bu tc kimlik numarasına ait bir alıcı zaten var.");
        }else{
//            Alici ak = new Alici();
//            ak.setAdi(alici.getAdi());
//            ak.setSoyadi(alici.getSoyadi());
//            ak.setDogumTarihi(alici.getDogumTarihi());
//            ak.setTcKimlikNo(alici.getTcKimlikNo());
//            ak.setYas(alici.getYas());
            Araci _araci = modelMapper.map(araci,Araci.class);
            return modelMapper.map(araciRepo.save(_araci), AraciDTO.class);
        }
    }

    @Override
    public AraciDTO araciGuncelle(AraciDTO araci) throws Exception {
        if (araci.getId() == null)
            throw new Exception("id bos olamaz..");
        Araci arg = araciRepo.getOne(araci.getId());
        if (arg == null)
            throw new Exception("kisi bulunamadi");

        List<Araci> araciList = araciRepo.findAllByTcKimlikNo(araci.getTcKimlikNo());
        if(araciList.size()>0){
            throw new Exception("Bu tc kimlik numarasına ait bir alıcı zaten var.");
        }else{
        Araci _araci = modelMapper.map(araci,Araci.class);
        return modelMapper.map(araciRepo.save(_araci), AraciDTO.class);
    }
    }

    @Override
    public void araciSil(Long id) {
        araciRepo.deleteById(id);
    }
}

