package com.prominentpixel.knowledgebuilder.domain;

import com.prominentpixel.knowledgebuilder.service.KBUserMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Configuration
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserBean {

    @Autowired
    HttpServletRequest request;

    @Autowired
    KBUserMasterService kbUserMasterService;

    public long getUserId() {
        Principal principal = request.getUserPrincipal();
        KBUserMaster kbUserMaster = kbUserMasterService.getUserByEmailID(principal.getName());
        return kbUserMaster.getId();
    }
}
