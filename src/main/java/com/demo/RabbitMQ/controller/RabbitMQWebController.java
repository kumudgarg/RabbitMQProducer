package com.demo.RabbitMQ.controller;

import com.demo.RabbitMQ.model.Employee;
import com.demo.RabbitMQ.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/demo.rabbitmq")
public class RabbitMQWebController {

    @Autowired
    RabbitMQSender rabbitMQSender;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("empName") String empName, @RequestParam("empId") String empId){
        Employee employee = new Employee();
        employee.setEmpId(empId);
        employee.setEmpName(empName);

        rabbitMQSender.send(employee);
        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }


}
