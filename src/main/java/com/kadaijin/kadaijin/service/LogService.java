package com.kadaijin.kadaijin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kadaijin.kadaijin.model.KadaijinModel;
import com.kadaijin.kadaijin.model.log.LogModel;
import com.kadaijin.kadaijin.model.log.UserModel;
import com.kadaijin.kadaijin.repository.log.LogRepository;
import com.kadaijin.kadaijin.repository.log.UserRepository;

@Service
public class LogService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LogRepository logRepository;

    @Transactional
    public void logInsert(UserModel userModel) {

        System.out.println(logRepository.countOnesInMyColumn(1));
        userRepository.updateTotalLogin(logRepository.countOnesInMyColumn(userModel.getUserID()),
                userModel.getUserName());
        if (userRepository.findIdByUsername(userModel.getUserName()) == null) {
            userRepository.save(userModel);
        }

        Integer foreignKey = userRepository.findIdByUsername(userModel.getUserName());

        // Buat instance LogModel
        LogModel logModel = new LogModel();
        logModel.setID(foreignKey);

        // Simpan LogModel
        logRepository.save(logModel);
    }

    public List<UserModel> getLog() {
        return this.userRepository.findAll();
    }
}
