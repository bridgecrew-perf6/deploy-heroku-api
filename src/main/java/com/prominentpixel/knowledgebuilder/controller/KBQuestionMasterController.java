package com.prominentpixel.knowledgebuilder.controller;

import com.prominentpixel.knowledgebuilder.dto.KBQuestionMasterDTO;
import com.prominentpixel.knowledgebuilder.service.KBQuestionMasterService;
import com.prominentpixel.knowledgebuilder.service.KBUserMasterService;
import com.prominentpixel.knowledgebuilder.utils.CommonConstants;
import com.prominentpixel.knowledgebuilder.utils.Constants;
import com.prominentpixel.knowledgebuilder.utils.GenericResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RequestMapping(Constants.API_BASE + Constants.KB_QUESTION)
@RestController
public class KBQuestionMasterController {

    private static final Logger log = LogManager.getLogger(KBQuestionMasterController.class);

    @Autowired
    private KBQuestionMasterService kbQuestionMasterService;

    @Autowired
    private KBUserMasterService kbUserMasterService;

    @GetMapping(value = "/getAllQuestions", produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse getAllQuestions() {
        GenericResponse genericResponse = new GenericResponse();
        try {
            List<KBQuestionMasterDTO> kbQuestionMaster = kbQuestionMasterService.getAllQuestions();

            if (kbQuestionMaster != null) {
                genericResponse.setData(kbQuestionMaster);
                genericResponse.setStatus(true);
            } else {
                genericResponse.setMessage(CommonConstants.RECORD_NOT_FOUND);
                genericResponse.setData(null);
                genericResponse.setStatus(false);
            }
        } catch (Exception e) {
            log.error("(KBQuestionMasterController) getAllQuestions() Error :" + e.getMessage(), e);
            genericResponse.setMessage(e.getMessage());
            genericResponse.setStatus(false);
        }
        return genericResponse;
    }

    @GetMapping(value = "/getAllQuestionsSameCategory/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse getAllQuestionSameCategory(@PathVariable(value = "id") Long categoryId) {
        GenericResponse genericResponse = new GenericResponse();
        try {
            List<KBQuestionMasterDTO> kbQuestionMaster = kbQuestionMasterService.getAllQuestionsSameCategory(categoryId);

            if (kbQuestionMaster != null) {
                genericResponse.setData(kbQuestionMaster);
                genericResponse.setStatus(true);
            } else {
                genericResponse.setMessage(CommonConstants.RECORD_NOT_FOUND);
                genericResponse.setData(null);
                genericResponse.setStatus(false);
            }
        } catch (Exception e) {
            log.error("(KBQuestionMasterController) getAllQuestionSameCategory() Error :" + e.getMessage(), e);
            genericResponse.setMessage(e.getMessage());
            genericResponse.setStatus(false);
        }
        return genericResponse;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse getQuestionById(@PathVariable(value = "id") Long id) {
        GenericResponse genericResponse = new GenericResponse();
        try {
            KBQuestionMasterDTO kbQuestionMasterDTO = kbQuestionMasterService.getQuestionById(id);
            if (kbQuestionMasterDTO != null) {
                genericResponse.setData(kbQuestionMasterDTO);
                genericResponse.setStatus(true);
            } else {
                genericResponse.setMessage(CommonConstants.RECORD_NOT_FOUND);
                genericResponse.setData(null);
                genericResponse.setStatus(false);
            }
        } catch (Exception e) {
            log.error("(KBQuestionMasterController) getQuestionById() Error :" + e.getMessage(), e);
            genericResponse.setMessage(e.getMessage());
            genericResponse.setStatus(false);
        }
        return genericResponse;
    }

    @PostMapping(value = "/createQuestion", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse createQuestionMST(@RequestBody KBQuestionMasterDTO kbQuestionMasterDTO, final HttpServletRequest request) throws IOException {
        GenericResponse genericResponse = new GenericResponse();
        try {
            genericResponse.setData(kbQuestionMasterService.createQuestion(kbQuestionMasterDTO));
            genericResponse.setStatus(true);
        } catch (Exception e) {
            log.error("(KBUserMasterController) createQuestionMST() Error :" + e.getMessage(), e);
            genericResponse.setMessage(e.getMessage());
            genericResponse.setStatus(false);
        }
        return genericResponse;
    }

    @PutMapping(value = "/updateQuestion", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse updateQuestionMST(@RequestBody KBQuestionMasterDTO kbQuestionMasterDTO, final HttpServletRequest request) throws IOException {
        GenericResponse genericResponse = new GenericResponse();
        try {
            // long userID = getUserId(request);
            genericResponse.setData(kbQuestionMasterService.updateQuestion(kbQuestionMasterDTO));
            genericResponse.setStatus(true);
        } catch (Exception e) {
            log.error("(KBUserMasterController) updateQuestionMST() Error :" + e.getMessage(), e);
            genericResponse.setMessage(e.getMessage());
            genericResponse.setStatus(false);
        }
        return genericResponse;
    }
}
