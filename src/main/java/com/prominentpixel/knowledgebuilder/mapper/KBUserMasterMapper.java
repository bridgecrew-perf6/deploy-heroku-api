package com.prominentpixel.knowledgebuilder.mapper;

import com.prominentpixel.knowledgebuilder.domain.KBUserMaster;
import com.prominentpixel.knowledgebuilder.dto.KBUserMasterDTO;
import org.springframework.stereotype.Component;

@Component
public class KBUserMasterMapper {

//    public KBUserMaster createUserMaster(KBUserMaster savedUserMaster) {
//        return savedUserMaster;
//    }

    public KBUserMaster forgotPassword(KBUserMaster kbUserMaster) {
        return kbUserMaster;
    }

    public KBUserMaster getLoginDetail(KBUserMaster kbUserMaster) {
        return kbUserMaster;
    }

    public KBUserMaster changePassword(KBUserMaster kbUserMaster) {
        return kbUserMaster;
    }

    public KBUserMasterDTO convertKbUserMaster(KBUserMaster fetchedkbUserMaster) {
        KBUserMasterDTO kbUserMasterDTO = new KBUserMasterDTO();
        kbUserMasterDTO.setId(fetchedkbUserMaster.getId());
        kbUserMasterDTO.setFirstName(fetchedkbUserMaster.getFirstName());
        kbUserMasterDTO.setLastName(fetchedkbUserMaster.getLastName());
        kbUserMasterDTO.setEmail(fetchedkbUserMaster.getEmail());
        kbUserMasterDTO.setMobile(fetchedkbUserMaster.getMobile());
        kbUserMasterDTO.setPassword(fetchedkbUserMaster.getPassword());
        kbUserMasterDTO.setCurrentPassword(fetchedkbUserMaster.getCurrentPassword());
        kbUserMasterDTO.setNewPassword(fetchedkbUserMaster.getNewPassword());
        kbUserMasterDTO.setCreatedBy(fetchedkbUserMaster.getCreatedBy());
        kbUserMasterDTO.setCreatedOn(fetchedkbUserMaster.getCreatedOn());
        kbUserMasterDTO.setUpdatedBy(fetchedkbUserMaster.getUpdatedBy());
        kbUserMasterDTO.setUpdatedOn(fetchedkbUserMaster.getUpdatedOn());
        return kbUserMasterDTO;
    }
}
