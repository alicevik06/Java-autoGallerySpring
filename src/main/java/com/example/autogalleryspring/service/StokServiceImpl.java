package com.example.autogalleryspring.service;

import com.example.autogalleryspring.dto.SaticiDTO;
import com.example.autogalleryspring.dto.StokDTO;
import com.example.autogalleryspring.entity.Arac;
import com.example.autogalleryspring.entity.Satici;
import com.example.autogalleryspring.entity.Stok;
import com.example.autogalleryspring.repo.IAracRepo;
import com.example.autogalleryspring.repo.IStokRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "stokService")
public class StokServiceImpl implements IStokService{

    private IStokRepo stokRepo;
    private IAracRepo aracRepo;
    private ModelMapper modelMapper;

    @Autowired
    public StokServiceImpl(IStokRepo stokRepo, ModelMapper modelMapper,IAracRepo aracRepo) {
        this.stokRepo = stokRepo;
        this.aracRepo= aracRepo;
        this.modelMapper = modelMapper;

    }
    @Override
    @Transactional(readOnly = true)
    public StokDTO idyeGoreGetir(Long id) {
        return modelMapper.map(stokRepo.getById(id), StokDTO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public StokDTO stokKaydet(StokDTO stok) throws Exception {
        if (stok.getId() != null)
            throw new Exception("Id dolu olamaz");
//        Arac m = (Arac) aracRepo.getById(stok.getAracId());
//        Stok sk = new Stok();
//
//        sk.setRenk(stok.getRenk());
//        sk.setKilometre(stok.getKilometre());
//        sk.setModelYili(stok.getModelYili());
//        sk.setFiyat(stok.getFiyat());
//        sk.setArac(m);
//        return modelMapper.map(stokRepo.save(sk), StokDTO.class);
        Stok _stok = modelMapper.map(stok, Stok.class);
        return modelMapper.map(stokRepo.save(_stok), StokDTO.class);
    }

    @Override
    public StokDTO stokGuncelle(StokDTO stok) throws Exception {
        if (stok.getId() == null)
            throw new Exception("id bos olamaz..");

        Stok sg =stokRepo.getOne(stok.getId());
        if (sg == null)
            throw new Exception("Stok bulunamadi");

        sg.setRenk(stok.getRenk());
        sg.setKilometre(stok.getKilometre());
        sg.setModelYili(stok.getModelYili());
        sg.setFiyat(stok.getFiyat());

        return modelMapper.map(stokRepo.save(sg), StokDTO.class);
    }

    @Override
    public void stokSil(Long id) {
        stokRepo.deleteById(id);
    }


}
