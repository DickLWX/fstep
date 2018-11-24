package com.dick.fstep.service.impl;

import com.dick.fstep.dao.PersonMapperDao;
import com.dick.fstep.entity.Person;
import com.dick.fstep.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonMapperDao personMapperDao;
    public Person findPersonById(long id) {
        return personMapperDao.findPersonById(id);
    }
}