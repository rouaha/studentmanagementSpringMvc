package abi.repository;

import abi.entity.UserTempPassData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by BS190 on 7/26/2017.
 */
@Repository
public class UserTempPassRepository {
    @Autowired
    UserTempPassRepo userTempPassRepo;

    public void create(UserTempPassData userTempPassData) {
        userTempPassRepo.save(userTempPassData);
    }

    public UserTempPassData getForgetPassDetailsByTempPassword(String userTempPass) {
        return userTempPassRepo.findByTemPass(userTempPass);
    }

    public void deleteById(long id) {
        userTempPassRepo.delete(id);
    }

    public void deleteByUserId(long id) {
        userTempPassRepo.deleteByUserId(id);
    }
}
