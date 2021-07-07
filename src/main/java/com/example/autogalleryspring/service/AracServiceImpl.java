package com.example.autogalleryspring.service;

import com.example.autogalleryspring.dto.AracDTO;
import com.example.autogalleryspring.entity.Arac;
import com.example.autogalleryspring.repo.IAracRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "aracService")
public class AracServiceImpl implements IAracService {


    private IAracRepo aracRepo;
    private ModelMapper modelMapper;

    @Autowired
    public AracServiceImpl(IAracRepo aracRepo, ModelMapper modelMapper) {
        this.aracRepo = aracRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public AracDTO idyeGoreGetir(Long id) {
        return modelMapper.map(aracRepo.getById(id), AracDTO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AracDTO aracKaydet(AracDTO arac) throws Exception {

        if (arac.getId() != null)
            throw new Exception("Id dolu olamaz");

            Arac _arac = modelMapper.map(arac,Arac.class);
            return modelMapper.map(aracRepo.save(_arac), AracDTO.class);
        }


    @Override
    public AracDTO aracGuncelle(AracDTO arac) throws Exception {
        if (arac.getId() == null)
            throw new Exception("id bos olamaz..");
        Arac ag = aracRepo.getOne(arac.getId());
        if (ag == null)
            throw new Exception("Arac bulunamadi");

        ag.setMarka(arac.getMarka());
        ag.setModel(arac.getModel());
            return modelMapper.map(aracRepo.save(ag), AracDTO.class);
        }

    @Override
    public void aracSil(Long id) {
        aracRepo.deleteById(id);
    }
}
