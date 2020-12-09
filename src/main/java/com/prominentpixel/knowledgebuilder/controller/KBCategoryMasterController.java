package com.prominentpixel.knowledgebuilder.controller;

import com.prominentpixel.knowledgebuilder.dto.KBCategoryMasterDTO;
import com.prominentpixel.knowledgebuilder.service.KBCategoryMasterService;
import com.prominentpixel.knowledgebuilder.utils.CommonConstants;
import com.prominentpixel.knowledgebuilder.utils.Constants;
import com.prominentpixel.knowledgebuilder.utils.GenericResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(Constants.API_BASE + Constants.KB_CATEGORY)
@RestController
public class KBCategoryMasterController {

    private static final Logger log = LogManager.getLogger(KBCategoryMasterController.class);
    @Autowired
    private KBCategoryMasterService kbCategoryMasterService;
    GenericResponse genericResponse = new GenericResponse();

    @GetMapping(value = "/getAllCategory", produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse getByTestId() {
        try {
            List<KBCategoryMasterDTO> kbTestMaster = kbCategoryMasterService.getAllCategory();
            if (kbTestMaster != null) {
                genericResponse.setData(kbTestMaster);
                genericResponse.setStatus(true);
            } else {
                genericResponse.setMessage(CommonConstants.RECORD_NOT_FOUND);
                genericResponse.setData(null);
                genericResponse.setStatus(false);
            }
        } catch (Exception e) {
            log.error("(KBCategoryMasterController) getByTestId() Error :" + e.getMessage(), e);
            genericResponse.setMessage(e.getMessage());
            genericResponse.setStatus(false);
        }
        return genericResponse;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse getCategoryById(@PathVariable(value = "id") Long id) {
        GenericResponse genericResponse = new GenericResponse();
        try {
            KBCategoryMasterDTO kbCategoryMasterDTO = kbCategoryMasterService.getCategoryById(id);
            if (kbCategoryMasterDTO != null) {
                genericResponse.setData(kbCategoryMasterDTO);
                genericResponse.setStatus(true);
            } else {
                genericResponse.setMessage(CommonConstants.RECORD_NOT_FOUND);
                genericResponse.setData(null);
                genericResponse.setStatus(false);
            }
        } catch (Exception e) {
            log.error("(KBCategoryMasterController) getCategoryById() Error :" + e.getMessage(), e);
            genericResponse.setMessage(e.getMessage());
            genericResponse.setStatus(false);
        }
        return genericResponse;
    }
}
