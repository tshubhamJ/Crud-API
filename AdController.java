package com.auth0.ads.controller;

import com.auth0.ads.model.AdDto;
import com.auth0.ads.Service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.*;

  @Controller
  @RequestMapping(value="/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
  public class AdController
  {
      @Autowired
      private AdService adService;

      /**
       *
        * @param adId
       * @return
       */
      @GetMapping(value="/ad/{adId}")
        public @ResponseBody AdDto getAd(@PathVariable Long adId)
        {
           AdDto opObj=adService.findById(adId);
           if (opObj != null)
           {
              return opObj;
           }
           else
           {
              return new AdDto();
           }
        }

      /**
       *
       * @return
       */
      @GetMapping(value="/ad")
        public @ResponseBody List<AdDto> getAds()
        {
           return adService.findAll();
        }

      /**
       *
       * @param id
       * @return
       */
      @DeleteMapping(value="/ad/{id}")
        public @ResponseBody Map<String,Object> deleteAd(@PathVariable("id") Long id)
         {
            AdDto opObj=adService.findById(id);
            if (opObj != null)
            {
               adService.deleteById(id);
               Map<String,Object> res=new HashMap<>();
               res.put("message","Deleted Successfully");
               res.put("status",HttpStatus.OK);
               return res;
            }
            else
            {
               Map<String,Object> res=new HashMap<>();
               res.put("message","Id not Present");
               res.put("status",HttpStatus.UNPROCESSABLE_ENTITY);
               return res;
            }
         }

      /**
       *
       * @param id
       * @param ad
       * @return
       */
      @PutMapping(value="/ad/{id}")
       public @ResponseBody Map<String,Object> updateAd(@PathVariable("id") Long id, @Valid@RequestBody AdDto ad)
        {
            AdDto adObj=adService.findById(id);
             if (adObj != null)
              {
                ad.setId(id);
                adService.save(ad);
                 Map<String,Object> res=new HashMap<>();
              res.put("message","Updated Successfully");
              res.put("status",HttpStatus.OK);
              return res;
        }
        else
        {
             Map<String,Object> res=new HashMap<>();
             res.put("message","Id not Present/Entries Not Valid");
             res.put("status",HttpStatus.UNPROCESSABLE_ENTITY);
             return res;
        }
    }

    @PostMapping(value="/ad")
    public @ResponseBody AdDto postAd(@Valid@RequestBody AdDto ad)
    {
        AdDto responseDTO=adService.save(ad);
        return responseDTO;
    }
}
