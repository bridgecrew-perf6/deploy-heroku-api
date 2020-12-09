package com.prominentpixel.knowledgebuilder.controller;

import com.prominentpixel.knowledgebuilder.dto.KBQuestionMasterDTO;
import com.prominentpixel.knowledgebuilder.dto.KBUserMasterDTO;
import com.prominentpixel.knowledgebuilder.service.KBUserMasterService;
import com.prominentpixel.knowledgebuilder.utils.CommonConstants;
import com.prominentpixel.knowledgebuilder.utils.Constants;
import com.prominentpixel.knowledgebuilder.utils.GenericResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(Constants.API_BASE + Constants.KB_USER)
@RestController
public class KBUserMasterController {

    private static final Logger log = LogManager.getLogger(KBUserMasterController.class);

    @Autowired
    private KBUserMasterService kbUserMasterService;

    @PostMapping(value = "/createSignup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse createSignup(@RequestBody(required = false) KBUserMasterDTO kbUserMasterDTO) {
        GenericResponse genericResponse = new GenericResponse();
        try {
            genericResponse.setData(kbUserMasterService.create(kbUserMasterDTO));
            genericResponse.setStatus(true);
        } catch (Exception e) {
            log.error("(KBUserMSTController) createSignup() Error :" + e.getMessage(), e);
            genericResponse.setMessage(e.getMessage());
            genericResponse.setStatus(false);
        }
        return genericResponse;
    }

    @PostMapping(value = "/forgotPassword", produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse forgotPassword(@RequestBody KBUserMasterDTO kbUserMasterDTO) {
        GenericResponse genericResponse = new GenericResponse();
        try {
            genericResponse.setData(kbUserMasterService.forgotPassword(kbUserMasterDTO));
            genericResponse.setStatus(true);
        } catch (Exception e) {
            log.error("(KBUserMSTController) forgotPassword() Error :" + e.getMessage(), e);
            genericResponse.setMessage(e.getMessage());
            genericResponse.setStatus(false);
        }
        return genericResponse;
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse loginUser(@RequestBody KBUserMasterDTO kbUserMasterDTO) {
        GenericResponse genericResponse = new GenericResponse();
        try {
            genericResponse.setData(kbUserMasterService.loginUser(kbUserMasterDTO));
            genericResponse.setStatus(true);
        } catch (Exception e) {
            log.error("(KBUserMSTController) loginUser() Error :" + e.getMessage(), e);
            genericResponse.setData(null);
            genericResponse.setMessage(e.getMessage());
            genericResponse.setStatus(false);
        }
        return genericResponse;
    }

    @PutMapping(value = "/changePassword", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse changePassword(@RequestBody KBUserMasterDTO kbUserMasterDTO) {
        GenericResponse genericResponse = new GenericResponse();
        try {
            kbUserMasterService.changePassword(kbUserMasterDTO);
            genericResponse.setStatus(true);
        } catch (Exception e) {
            log.error("(KBUserMSTController) changePassword() Error :" + e.getMessage(), e);
            genericResponse.setMessage(e.getMessage());
            genericResponse.setStatus(false);
        }
        return genericResponse;
    }

    @PutMapping(value = "/userProfile", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse userProfile(@RequestBody KBUserMasterDTO kbUserMasterDTO) {
        GenericResponse genericResponse = new GenericResponse();
        try {
            kbUserMasterService.userProfile(kbUserMasterDTO);
            genericResponse.setStatus(true);
        } catch (Exception e) {
            log.error("(KBUserMSTController) userProfile() Error :" + e.getMessage(), e);
            genericResponse.setMessage(e.getMessage());
            genericResponse.setStatus(false);
        }
        return genericResponse;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse getUserById(@PathVariable(value = "id") Long id) {
        GenericResponse genericResponse = new GenericResponse();
        try {
            KBUserMasterDTO kbUserMasterDTO = kbUserMasterService.getUserById(id);
            if (kbUserMasterDTO != null) {
                genericResponse.setData(kbUserMasterDTO);
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
}
