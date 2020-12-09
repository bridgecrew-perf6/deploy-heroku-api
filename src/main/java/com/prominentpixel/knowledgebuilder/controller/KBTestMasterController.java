package com.prominentpixel.knowledgebuilder.controller;

import com.prominentpixel.knowledgebuilder.dto.KBTestMasterDTO;
import com.prominentpixel.knowledgebuilder.service.KBTestMasterService;
import com.prominentpixel.knowledgebuilder.utils.CommonConstants;
import com.prominentpixel.knowledgebuilder.utils.Constants;
import com.prominentpixel.knowledgebuilder.utils.GenericResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequestMapping(Constants.API_BASE + Constants.KB_TEST)
@RestController
public class KBTestMasterController {

    private static final Logger log = LogManager.getLogger(KBTestMasterController.class);

    @Autowired
    private KBTestMasterService kbTestMasterService;
    GenericResponse genericResponse = new GenericResponse();

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse getByTestId(@PathVariable(value = "id") Long id) {
        try {
            KBTestMasterDTO kbTestMaster = kbTestMasterService.getTestById(id);
            if (kbTestMaster != null) {
                genericResponse.setData(kbTestMaster);
                genericResponse.setStatus(true);
            } else {
                genericResponse.setMessage(CommonConstants.RECORD_NOT_FOUND);
                genericResponse.setData(null);
                genericResponse.setStatus(false);
            }
        } catch (Exception e) {
            log.error("(KBTestMasterController) getByTestId() Error :" + e.getMessage(), e);
            genericResponse.setMessage(e.getMessage());
            genericResponse.setStatus(false);
        }
        return genericResponse;
    }

    @GetMapping(value = "/getAllTest", produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse getAllTests() {
        try {
            List<KBTestMasterDTO> kbTestMaster = kbTestMasterService.getAllTests();
            if (kbTestMaster != null) {
                genericResponse.setData(kbTestMaster);
                genericResponse.setStatus(true);
            } else {
                genericResponse.setMessage(CommonConstants.RECORD_NOT_FOUND);
                genericResponse.setData(null);
                genericResponse.setStatus(false);
            }
        } catch (Exception e) {
            log.error("(KBTestMasterController) getAllTests() Error :" + e.getMessage(), e);
            genericResponse.setMessage(e.getMessage());
            genericResponse.setStatus(false);
        }
        return genericResponse;
    }


}

