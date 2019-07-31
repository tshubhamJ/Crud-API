package com.auth0.ads.controller;

import ch.qos.logback.core.status.Status;
import com.auth0.ads.Service.ContactPersonService;
import com.auth0.ads.model.ContactPersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import javax.net.ssl.SSLEngineResult;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/v1" , produces={MediaType.APPLICATION_JSON_VALUE})
public class ContactPersonController {

    @Autowired
    private ContactPersonService contactpersonService;

    @GetMapping(value = "/contactperson/{contactpersonId}")
    public @ResponseBody ContactPersonDto getContactPerson(@PathVariable Long contactpersonId) {
        ContactPersonDto opObj = contactpersonService.findById(contactpersonId);
        if (opObj != null)
            return opObj;
        else {
            return new ContactPersonDto();
        }

    }

    @GetMapping(value = "/contactperson")
    public @ResponseBody
    List<ContactPersonDto> getContactPerson() {
        return contactpersonService.findAll();
    }

    @DeleteMapping(value = "/contactperson/{id}")
    public @ResponseBody
         Map<String, Object> deleteAd(@PathVariable("id") Long id) {
        ContactPersonDto opObj = contactpersonService.findById(id);
        if (opObj != null) {
            contactpersonService.deleteById(id);
            // String responseMessage = "Your id" + " " + id + " is successfully Deleted with statuscode";
            Map<String, Object> res = new HashMap<>();
            res.put("message", "Deleted Successfully");
            res.put("status", HttpStatus.OK);
         //   res.put("codes", HttpStatus.valueOf());
            return res;
        } else {
            Map<String, Object> res = new HashMap<>();
            res.put("message", "Id not Present");
         Object tring  = res.put("status", HttpStatus.NO_CONTENT);
         //   res.put("code",HttpStatus.valueOf(No_CONTENT));
          return res;
        }
    }

    @PutMapping(value = "/contactperson/{id}")
    public @ResponseBody ResponseEntity<List<String>> updateAd(@PathVariable("id") Long id, @Valid @RequestBody ContactPersonDto contactperson) {
        ContactPersonDto adObj = contactpersonService.findById(id);
        if (adObj != null) {
            contactperson.setId(id);

            contactpersonService.save(contactperson);
            return new ResponseEntity<List<String>>(HttpStatus.OK);
        } else{
           // @ResponseStatus(HttpStatus.NO_CONTENT)
                return new ResponseEntity<List<String>>(HttpStatus.UNPROCESSABLE_ENTITY);
            }
    }

    @PostMapping(value = "/contactperson")
    public @ResponseBody
    ContactPersonDto postContactPerson(@Valid @RequestBody ContactPersonDto contactperson) {

            ContactPersonDto responseDTO = contactpersonService.save(contactperson);
            return responseDTO;

    }
}
