package com.achords.service.user;

import com.achords.model.entity.user.Role;
import com.achords.repository.userRepo.RoleRepo;
import com.achords.utils.exceptions.RoleNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepo roleRepo;

    public Role findById(Integer id) throws RoleNotFoundException {
        return roleRepo.findById(id).orElseThrow(RoleNotFoundException::new);
    }

}
