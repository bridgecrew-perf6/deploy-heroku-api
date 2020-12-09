package com.prominentpixel.knowledgebuilder.controller;

import com.prominentpixel.knowledgebuilder.service.KBQuestionOptionMasterService;
import com.prominentpixel.knowledgebuilder.utils.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(Constants.API_BASE + Constants.KB_OPTIONS)
@RestController
public class KBQuestionOptionMasterController {

    private static final Logger log = LogManager.getLogger(KBQuestionOptionMasterController.class);

    @Autowired
    private KBQuestionOptionMasterService kbQuestionOptionMasterService;

}