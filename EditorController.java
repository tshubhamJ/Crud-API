package com.auth0.ads.controller;

import com.auth0.ads.Entity.Editor;
import com.auth0.ads.Service.EditorService;
import com.auth0.ads.model.EditorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping(value = "/v1", produces={MediaType.APPLICATION_JSON_VALUE})
public class EditorController {

        @Autowired
        private EditorService editorService;

    /**
     *
     * @param editorId
     * @return
     */
    @GetMapping(value = "/editor/{editorId}")
        public @ResponseBody
        EditorDto getEditor(@PathVariable Long editorId) {
            EditorDto opObj = editorService.findById(editorId);
            if (opObj != null)
                return opObj;
            else {
                return new EditorDto();
            }

        }

    /**
     *
     * @return
     */
    @GetMapping(value = "/editor")
        public @ResponseBody List<EditorDto> getEditor() {
            return editorService.findAll();
        }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/editor/{id}")
        public @ResponseBody ResponseEntity<String> deleteEditor(@PathVariable("id") Long id) {
           Optional <EditorDto> opObj = Optional.ofNullable(editorService.findById(id));
            if (opObj.isPresent()) {
                editorService.deleteById(id);
                Map<String, Object> res = new HashMap<>();
                res.put("message","Deleted Successfully");
                res.put("status", HttpStatus.OK);
                return (ResponseEntity<String>) res;
            } else {
                Map<String, Object> res = new HashMap<>();
                res.put("message", "Id not Present");
                res.put("status", HttpStatus.NO_CONTENT);
                return (ResponseEntity<String>) res;
            }
        }

    /**
     *
     * @param id
     * @param editor
     * @return
     */

        @PutMapping(value = "/editor/{id}")
        public @ResponseBody ResponseEntity<String>updateEditor(@PathVariable("id") Long id, @Valid @RequestBody EditorDto editor)
        {
            EditorDto adObj = editorService.findById(id);
            if (adObj != null) {
                editor.setId(id);
                editorService.save(editor);
                return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<String>(HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }

    /**
     *
     * @param editor
     * @return
     */
        @PostMapping(value = "/editor")
        public @ResponseBody EditorDto postEditor(@Valid @RequestBody EditorDto editor) {
            // System.out.println(ad.description);
            //System.out.println(ad.owner);

             {
                EditorDto responseDTO = editorService.save(editor);
                return responseDTO;
            }
        }


    }



