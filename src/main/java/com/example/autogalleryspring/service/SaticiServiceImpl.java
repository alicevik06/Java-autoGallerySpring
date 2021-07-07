package com.example.autogalleryspring.service;

import com.example.autogalleryspring.dto.AliciDTO;
import com.example.autogalleryspring.dto.SaticiDTO;
import com.example.autogalleryspring.entity.Alici;
import com.example.autogalleryspring.entity.Satici;
import com.example.autogalleryspring.repo.ISaticiRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "saticiService")
public class SaticiServiceImpl implements ISaticiService {

    private ISaticiRepo saticiRepo;
    private ModelMapper modelMapper;

    @Autowired
    public SaticiServiceImpl(ISaticiRepo saticiRepo, ModelMapper modelMapper) {
        this.saticiRepo = saticiRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public SaticiDTO idyeGoreGetir(Long id) {
        return modelMapper.map(saticiRepo.getById(id), SaticiDTO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SaticiDTO saticiKaydet(SaticiDTO satici) throws Exception {
        List<Satici> saticiList = saticiRepo.findAllByTcKimlikNo(satici.getTcKimlikNo());
        if(saticiList.size()>0){
            throw new Exception("Bu tc kimlik numarasına ait bir alıcı zaten var.");
        }else{
//            Alici ak = new Alici();
//            ak.setAdi(alici.getAdi());
//            ak.setSoyadi(alici.getSoyadi());
//            ak.setDogumTarihi(alici.getDogumTarihi());
//            ak.setTcKimlikNo(alici.getTcKimlikNo());
//            ak.setYas(alici.getYas());
            Satici _satici = modelMapper.map(satici,Satici.class);
            return modelMapper.map(saticiRepo.save(_satici), SaticiDTO.class);
        }
    }

    @Override
    public SaticiDTO saticiGuncelle(SaticiDTO satici) throws Exception {
        if (satici.getId() == null)
            throw new Exception("id bos olamaz..");
        Satici sg =saticiRepo.getOne(satici.getId());
        if (sg == null)
            throw new Exception("kisi bulunamadi");

        List<Satici> saticiList = saticiRepo.findAllByTcKimlikNo(satici.getTcKimlikNo());
        if(saticiList.size()>0){
            throw new Exception("Bu tc kimlik numarasına ait bir alıcı zaten var.");
        }else {
            Satici _satici = modelMapper.map(satici, Satici.class);
            return modelMapper.map(saticiRepo.save(_satici), SaticiDTO.class);
        }
    }

    @Override
    public void saticiSil(Long id) {
        saticiRepo.deleteById(id);
    }
}
