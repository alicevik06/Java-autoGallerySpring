package com.example.autogalleryspring.service;



import com.example.autogalleryspring.dto.KisiGorevDTO;
import com.example.autogalleryspring.entity.KisiGorev;
import com.example.autogalleryspring.repo.IKisiGorevRepo;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "kisiGorevService")
public class KisiGorevServiceImpl implements IKisiGorevService {

    private IKisiGorevRepo kisiGorevRepo;
    private ModelMapper modelMapper;

    @Autowired
    public KisiGorevServiceImpl(IKisiGorevRepo kisiGorevRepo, ModelMapper modelMapper) {
        this.kisiGorevRepo = kisiGorevRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public KisiGorevDTO idyeGoreGetir(Long id) {
        return modelMapper.map(kisiGorevRepo.getById(id), KisiGorevDTO.class);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public KisiGorevDTO kisiGorevKaydet(KisiGorevDTO kisiGorev) throws Exception {

        if (kisiGorev.getId() != null)
            throw new Exception("Id dolu olamaz");

        KisiGorev k = modelMapper.map(kisiGorev, KisiGorev.class);
        return modelMapper.map(kisiGorevRepo.save(k), KisiGorevDTO.class);
    }

    @Override
    public KisiGorevDTO kisiGorevGuncelle(KisiGorevDTO kisiGorev) throws Exception {
        if(kisiGorev.getId() == null)
            throw new Exception("Id Bos Olamaz");
        KisiGorev kg = kisiGorevRepo.getOne(kisiGorev.getId());
        if (kg == null)
            throw new Exception("Kisi Bulunamadı");

        KisiGorev kgg = modelMapper.map(kisiGorev, KisiGorev.class);
        return modelMapper.map(kisiGorevRepo.save(kgg), KisiGorevDTO.class);
    }

    @Override
    public void kisiGorevSil(Long id) {
        kisiGorevRepo.deleteById(id);
    }

    @Override
    public List<KisiGorevDTO> tumunuGetir() {
        return modelMapper.map(kisiGorevRepo.findAll(),new TypeToken<List<KisiGorevDTO>>(){}.getType());
    }

}
