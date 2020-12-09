package com.prominentpixel.knowledgebuilder.service;

import com.prominentpixel.knowledgebuilder.domain.KBUserMaster;
import com.prominentpixel.knowledgebuilder.dto.KBUserMasterDTO;

public interface KBUserMasterService {
   KBUserMaster create(KBUserMasterDTO kbUserMasterDTO) throws Exception;
   KBUserMaster forgotPassword(KBUserMasterDTO kbUserMasterDTO) throws Exception;
   KBUserMaster loginUser(KBUserMasterDTO kbUserMasterDTO) throws Exception;
   KBUserMaster changePassword(KBUserMasterDTO kbUserMasterDTO) throws Exception;
   KBUserMaster getUserByEmailID(String name);

   KBUserMaster userProfile(KBUserMasterDTO kbUserMasterDTO) throws Exception;

   KBUserMasterDTO getUserById(Long id);
}
