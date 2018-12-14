package com.dick.fstep.controller;

import com.dick.fstep.entity.Person;
import com.dick.fstep.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/selectPerson")
    public void selectPerson(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        long personId = Long.parseLong(request.getParameter("id"));
        Person person =personService.findPersonById(personId);
        System.out.println("test git");
        ObjectMapper mapper = new ObjectMapper();

        response.getWriter().write(mapper.writeValueAsString(person));
        response.getWriter().close();
    }

    @RequestMapping("/testController")
    @ResponseBody
    public Object testController(@RequestBody Person dto,HttpServletResponse response) throws IOException {
        System.out.println("---------------------");
        System.out.println(dto.getId());
        return dto;
        //response.getWriter().write(dto.getId()+"");
    }
}