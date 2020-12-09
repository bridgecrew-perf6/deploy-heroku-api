package com.prominentpixel.knowledgebuilder.service.impl;

import com.prominentpixel.knowledgebuilder.dao.KBUserMasterDAO;
import com.prominentpixel.knowledgebuilder.domain.KBUserMaster;
import com.prominentpixel.knowledgebuilder.domain.UserBean;
import com.prominentpixel.knowledgebuilder.dto.KBUserMasterDTO;
import com.prominentpixel.knowledgebuilder.mapper.KBUserMasterMapper;
import com.prominentpixel.knowledgebuilder.service.EmailService;
import com.prominentpixel.knowledgebuilder.service.KBUserMasterService;
import com.prominentpixel.knowledgebuilder.utils.CommonConstants;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.util.Date;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class KBUserMasterServiceImpl implements KBUserMasterService {

    @Autowired
    KBUserMasterDAO kbUserMasterDAO;

    @Autowired
    KBUserMasterMapper kbUserMasterMapper;

    @Autowired
    EmailService emailService;

    @Autowired
    UserBean userBean;

    @Override
    public KBUserMaster create(KBUserMasterDTO kbUserMasterDTO) throws Exception {
        File resource = new ClassPathResource("static/emailtemplate/createuser/createuser.txt").getFile();
        String fileContent = new String(Files.readAllBytes(resource.toPath()));
        long userID = userBean.getUserId();

        if (kbUserMasterDAO.findByEmail(kbUserMasterDTO.getEmail()).isPresent()) {
            throw new Exception(CommonConstants.USER_ALREADY_EXIST);
        }

        KBUserMaster kbUserMaster = new KBUserMaster();
        kbUserMaster.setFirstName(kbUserMasterDTO.getFirstName());
        kbUserMaster.setLastName(kbUserMasterDTO.getLastName());
        kbUserMaster.setEmail(kbUserMasterDTO.getEmail());
        kbUserMaster.setPassword(kbUserMasterDTO.getPassword());
        kbUserMaster.setMobile(kbUserMasterDTO.getMobile());
        kbUserMaster.setStatus(kbUserMasterDTO.getStatus());
        kbUserMaster.setCreatedBy(userID);
        kbUserMaster.setUpdatedBy(userID);
        kbUserMaster.setCreatedOn(new Date());
        kbUserMaster.setUpdatedOn(new Date());
        KBUserMaster savedUserMaster = kbUserMasterDAO.saveAndFlush(kbUserMaster);
        emailService.sendSimpleMessage(kbUserMaster.getEmail(), "Email Send", fileContent + " " + kbUserMaster.getEmail());
        return null;
        //   return kbUserMasterMapper.createUserMaster(savedUserMaster);
    }

    @Override
    public KBUserMaster forgotPassword(KBUserMasterDTO kbUserMasterDTO) throws Exception {
        File resource = new ClassPathResource("static/emailtemplate/createuser/forgotpassword.txt").getFile();
        String fileContent = new String(Files.readAllBytes(resource.toPath()));
        String randomValues = RandomStringUtils.randomAlphanumeric(5).toUpperCase();

        KBUserMaster kbUserMaster = kbUserMasterDAO.findByEmail(kbUserMasterDTO.getEmail()).orElseThrow(() -> new Exception(CommonConstants.USER_NOT_FOUND + kbUserMasterDTO.getEmail()));
        kbUserMaster.setPassword(randomValues);
        KBUserMaster savedUserMaster = kbUserMasterDAO.saveAndFlush(kbUserMaster);
        emailService.sendSimpleMessage(kbUserMaster.getEmail(), "Random Password", fileContent + " " + randomValues);
        return kbUserMasterMapper.forgotPassword(savedUserMaster);
    }

    @Override
    public KBUserMaster loginUser(KBUserMasterDTO kbUserMasterDTO) throws Exception {
        KBUserMaster kbUserMaster = kbUserMasterDAO.findByPassword(kbUserMasterDTO.getPassword()).orElseThrow(() -> new Exception(CommonConstants.USER_NOT_FOUND));
        return kbUserMasterMapper.getLoginDetail(kbUserMaster);
    }

    @Override
    public KBUserMaster changePassword(KBUserMasterDTO kbUserMasterDTO) throws Exception {
        Pattern p = Pattern.compile(CommonConstants.EMAIL_PATTERN);
        if (!p.matcher(kbUserMasterDTO.getEmail()).matches())
            throw new Exception(CommonConstants.EMAIL_SHOULD_BE_VALID);

        KBUserMaster kbUserMaster = kbUserMasterDAO.findByEmail(kbUserMasterDTO.getEmail()).orElseThrow(() -> new Exception(CommonConstants.USER_NOT_FOUND + kbUserMasterDTO.getEmail()));
        System.out.println(kbUserMasterDTO.getCurrentPassword());
        System.out.println(kbUserMasterDTO.getNewPassword());

        if (!kbUserMaster.getPassword().equals(kbUserMasterDTO.getCurrentPassword()))
            throw new Exception(CommonConstants.CURRENT_PASSWORD_WRONG);
        kbUserMaster.setPassword(kbUserMasterDTO.getNewPassword());
        KBUserMaster savedUserMaster = kbUserMasterDAO.saveAndFlush(kbUserMaster);
        return kbUserMasterMapper.changePassword(savedUserMaster);
    }

    @Override
    public KBUserMaster getUserByEmailID(String name) {
        return kbUserMasterDAO.getUserByEmailID(name);
    }

    @Override
    public KBUserMaster userProfile(KBUserMasterDTO kbUserMasterDTO) throws Exception {
        System.out.println(kbUserMasterDTO);
        Optional<KBUserMaster> updatedKBUserMaster = kbUserMasterDAO.findById(kbUserMasterDTO.getId());
        long userID = userBean.getUserId();
        if (updatedKBUserMaster == null) {
            throw new Exception(CommonConstants.USER_NOT_FOUND + updatedKBUserMaster.get().getId());
        } else {
            updatedKBUserMaster.get().setFirstName(kbUserMasterDTO.getFirstName());
            updatedKBUserMaster.get().setLastName(kbUserMasterDTO.getLastName());
            updatedKBUserMaster.get().setMobile(kbUserMasterDTO.getMobile());
            updatedKBUserMaster.get().setEmail(kbUserMasterDTO.getEmail());
            updatedKBUserMaster.get().setStatus("ACTIVE");
     //       updatedKBUserMaster.get().setCreatedBy(userID);
            updatedKBUserMaster.get().setUpdatedBy(userID);
      //      updatedKBUserMaster.get().setCreatedOn(new Date());
            updatedKBUserMaster.get().setUpdatedOn(new Date());
            kbUserMasterDAO.saveAndFlush(updatedKBUserMaster.get());
        }
        return null;
    }

    @Override
    public KBUserMasterDTO getUserById(Long id) {
        if (kbUserMasterDAO.findById(id).isPresent()) {
            KBUserMaster fetchedkbUserMaster = kbUserMasterDAO.findById(id).get();
            return kbUserMasterMapper.convertKbUserMaster(fetchedkbUserMaster);
        } else {
            return null;
        }
    }
}
