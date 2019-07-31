package com.auth0.ads.Service;

import com.auth0.ads.Entity.Ad;
import com.auth0.ads.Repository.AdRepository;
import com.auth0.ads.model.AdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdService {

    @Autowired
    private AdRepository adRepository;

    public AdDto findById(Long adId) {
        Optional<Ad> entityObj = adRepository.findById(adId);
        if (entityObj.isPresent()) {
            return entityObj.get()._toConvertAdDto();
        } else {
            return null;
        }
    }

    public void deleteById(Long id)
    {
        adRepository.deleteById(id);
    }



    public AdDto save(AdDto ad) {
        Ad adEntity = ad.convertToAdEntity();
        adRepository.save(adEntity);
        return adEntity._toConvertAdDto();
    }

    public List<AdDto> findAll() {
        Iterable<Ad> opList = adRepository.findAll();
        List<AdDto> list = new ArrayList<>();
        for (Ad opObj: opList) {
            list.add(opObj._toConvertAdDto());
        }
        return list;
    }
}
