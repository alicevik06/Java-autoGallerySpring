package com.example.autogalleryspring.service;


import com.example.autogalleryspring.dto.HareketDTO;
import com.example.autogalleryspring.entity.Kisi;
import com.example.autogalleryspring.entity.Hareket;
import com.example.autogalleryspring.entity.KisiGorev;
import com.example.autogalleryspring.repo.IHareketRepo;
import com.example.autogalleryspring.repo.IKisiGorevRepo;
import com.example.autogalleryspring.repo.IStokRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service(value = "hareketService")
public class HareketServiceImpl implements IHareketService {

    private IHareketRepo hareketRepo;
    private ModelMapper modelMapper;
    private IStokRepo stokRepo;
    private IKisiGorevRepo kisiGorevRepo;

    @Autowired
    public HareketServiceImpl(IHareketRepo hareketRepo, ModelMapper modelMapper, IStokRepo stokRepo,IKisiGorevRepo kisiGorevRepo) {
        this.hareketRepo = hareketRepo;
        this.modelMapper = modelMapper;
        this.stokRepo=stokRepo;
        this.kisiGorevRepo=kisiGorevRepo;

    }

    @Override
    @Transactional(readOnly = true)
    public HareketDTO idyeGoreGetir(Long id) {
        return modelMapper.map(hareketRepo.getById(id), HareketDTO.class);

    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public HareketDTO hareketKaydet(HareketDTO hareket) throws Exception {

        if (hareket.getId() != null)
            throw new Exception("Id dolu olamaz");

        Hareket hk=new Hareket();
        KisiGorev kg=new KisiGorev();
//        hk.setHareketTipi(hareket.getHareketTipi());
//        hk.setHareketTarihi(hareket.getHareketTarihi());
//        hk.setKisiler(hareket.getKisiler());
//        hk.setStok(hareket.getStok());


        Hareket h = modelMapper.map(hareket, Hareket.class);
        return modelMapper.map(hareketRepo.save(h), HareketDTO.class);
    }

    @Override
    public HareketDTO hareketGuncelle(HareketDTO hareket) throws Exception {
        if(hareket.getId() == null)
            throw new Exception("Id Bos Olamaz");
        Hareket hg = hareketRepo.getOne(hareket.getId());
        if (hg == null)
            throw new Exception("Hareket Bulunamadı");

        hg.setHareketTipi(hareket.getHareketTipi());
        hg.setHareketTarihi(hareket.getHareketTarihi());
        hg.setHareketTipi(modelMapper.map(hareket.getHareketTipi(),new TypeToken<List<Kisi>>(){}.getType()));

        return modelMapper.map(hareketRepo.save(hg), HareketDTO.class);
    }

    @Override
    public void hareketSil(Long id) {
        hareketRepo.deleteById(id);
    }

    @Override
    public List<HareketDTO> tumunuGetir() {
        return modelMapper.map(hareketRepo.findAll(),new TypeToken<List<HareketDTO>>(){}.getType());
    }

}
