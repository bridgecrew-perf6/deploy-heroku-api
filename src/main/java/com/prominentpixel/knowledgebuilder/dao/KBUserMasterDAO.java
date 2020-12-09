package com.prominentpixel.knowledgebuilder.dao;

import com.prominentpixel.knowledgebuilder.domain.KBUserMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface KBUserMasterDAO extends JpaRepository<KBUserMaster, Long> {
    Optional<KBUserMaster> findByEmail(String email);
    Optional<KBUserMaster> findByPassword(String password);

    @Query("SELECT u FROM KBUserMaster u WHERE u.email = :email")
    KBUserMaster getUserByEmailID(@Param("email") String email);
}
