package com.example.userservice.service;


import com.example.userservice.DTO.Department;
import com.example.userservice.DTO.ResponseTemplateDto;
import com.example.userservice.entity.Users;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Users saveUser(Users user) {

        return userRepository.save(user);
    }

    public Users findUserById(Integer userId) {

        return userRepository.findUserById(userId);
    }

    public List<Users> list() {
        return userRepository.findAll();
    }

    public void delete(Integer id) {
      userRepository.deleteById(id);
    }

    public ResponseTemplateDto getUserWithDepartment(Integer userId){
            ResponseTemplateDto dto = new ResponseTemplateDto();
            Users users = userRepository.findUserById(userId);
            Department department = restTemplate.getForObject("http://DEPARTMENT/department/"+users.getDepartmentId(),Department.class);
            dto.setUsers(users);
            dto.setDepartment(department);
        return dto;
    }


}
