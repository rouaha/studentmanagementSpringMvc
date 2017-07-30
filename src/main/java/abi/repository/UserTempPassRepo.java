package abi.repository;

import abi.entity.UserTempPassData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by BS190 on 7/26/2017.
 */
public interface UserTempPassRepo extends JpaRepository<UserTempPassData, Long> {
    @Query("select  ustp from UserTempPassData  ustp where ustp.userTempPass=:userTempPass")
    UserTempPassData findByTemPass(@Param("userTempPass") String userTempPass);

    @Transactional
    @Modifying


    @Query("delete from UserTempPassData ustp where ustp.userId=:id")
    void deleteByUserId(@Param("id") long id);
}
