package com.auth0.ads.Service;


import com.auth0.ads.Entity.Editor;
import com.auth0.ads.Repository.EditorRepository;
import com.auth0.ads.model.EditorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EditorService {

    @Autowired
    private EditorRepository editorRepository;

    public EditorDto findById(Long editorId) {
        Optional<Editor> entityObj = editorRepository.findById(editorId);
        if (entityObj.isPresent()) {
            return entityObj.get()._toConvertEditorDto();
        } else {
            return null;
        }
    }

    public void deleteById(Long id) {
        editorRepository.deleteById(id);
    }

    public EditorDto save(EditorDto editor) {
        Editor editorEntity = editor.convertToEditorEntity();
        editorRepository.save(editorEntity);
        return editorEntity._toConvertEditorDto();
    }

    public List<EditorDto> findAll() {
        Iterable<Editor> opList = editorRepository.findAll();
        List<EditorDto> list = new ArrayList<>();
        for (Editor opObj : opList) {
            list.add(opObj._toConvertEditorDto());
        }
        return list;
    }
}


