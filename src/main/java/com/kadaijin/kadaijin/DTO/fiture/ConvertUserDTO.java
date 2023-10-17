package com.kadaijin.kadaijin.DTO.fiture;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.kadaijin.kadaijin.DTO.log.LogDTO;
import com.kadaijin.kadaijin.DTO.log.UserDTO;
import com.kadaijin.kadaijin.model.log.UserModel;

@Component
public class ConvertUserDTO {

    public UserDTO userModelToDTO(UserModel userModel) {

        LogDTO logDTO = new LogDTO();
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userModel.getId());
        userDTO.setUserName(userModel.getUserName());

        // Diarahkan ke Mesin logDTO.ListLogToDTO untuk di proses di jadikan ListDTO
        userDTO.setLog(logDTO.ListLogToDTO(userModel.getLog()));

        return userDTO;
    }

    public List<UserDTO> listModelToDTO(List<UserModel> userModels) {
        List<UserDTO> dto = new ArrayList<>();
        for (UserModel model : userModels) {
            UserDTO userDTO = userModelToDTO(model);
            dto.add(userDTO);
        }
        return dto;
    }

    public List<UserDTO> listModelToDTO(Page<UserModel> userModels) {
        List<UserDTO> dto = new ArrayList<>();
        for (UserModel model : userModels) {
            UserDTO userDTO = userModelToDTO(model);
            dto.add(userDTO);
        }
        return dto;
    }

        public List<UserDTO> listModelToDTO(Set<UserModel> userModels) {
        List<UserDTO> dto = new ArrayList<>();
        for (UserModel model : userModels) {
            UserDTO userDTO = userModelToDTO(model);
            dto.add(userDTO);
        }
        return dto;
    }
}
