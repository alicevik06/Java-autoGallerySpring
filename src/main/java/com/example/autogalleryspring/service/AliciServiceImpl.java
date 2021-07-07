package com.example.autogalleryspring.service;

import com.example.autogalleryspring.dto.AliciDTO;
import com.example.autogalleryspring.entity.Alici;
import com.example.autogalleryspring.repo.IAliciRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "aliciService")
public class AliciServiceImpl implements IAliciService {

    private IAliciRepo aliciRepo;
    private ModelMapper modelMapper;

    @Autowired
    public AliciServiceImpl(IAliciRepo aliciRepo, ModelMapper modelMapper) {
        this.aliciRepo = aliciRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public AliciDTO idyeGoreGetir(Long id) {
        return modelMapper.map(aliciRepo.getById(id), AliciDTO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AliciDTO aliciKaydet(AliciDTO alici) throws Exception {
        List<Alici> aliciList = aliciRepo.findAllByTcKimlikNo(alici.getTcKimlikNo());
        if (aliciList.size() > 0) {
            throw new Exception("Bu tc kimlik numarasına ait bir alıcı zaten var.");
        } else {
            Alici _alici = modelMapper.map(alici, Alici.class);
            return modelMapper.map(aliciRepo.save(_alici), AliciDTO.class);

            //            Alici ak = new Alici();
//            ak.setAdi(alici.getAdi());
//            ak.setSoyadi(alici.getSoyadi());
//            ak.setDogumTarihi(alici.getDogumTarihi());
//            ak.setTcKimlikNo(alici.getTcKimlikNo());
//            ak.setYas(alici.getYas());
        }
    }

    @Override
    public AliciDTO aliciGuncelle(AliciDTO alici) throws Exception {
        if (alici.getId() == null)
            throw new Exception("id bos olamaz..");
        Alici ag = (Alici) aliciRepo.getById(alici.getId());
        if (ag == null)
            throw new Exception("kisi bulunamadi");
        List<Alici> aliciList = aliciRepo.findAllByTcKimlikNo(alici.getTcKimlikNo());
        if (aliciList.size() > 0) {
            throw new Exception("Bu tc kimlik numarasına ait bir alıcı zaten var.");
        } else {
            Alici _alici = modelMapper.map(alici, Alici.class);
            return modelMapper.map(aliciRepo.save(_alici), AliciDTO.class);
        }
    }


    @Override
    public void aliciSil(Long id) {
        aliciRepo.deleteById(id);
    }
}


