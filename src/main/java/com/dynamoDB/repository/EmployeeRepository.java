package com.dynamoDB.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.dynamoDB.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Employee saveEmployee(Employee employee) {
        dynamoDBMapper.save(employee);
        return employee;
    }

    public Employee getEmployeeById(String employeeId) {
        return dynamoDBMapper.load(Employee.class, employeeId);
    }

    public String deleteEmployee(String employeeID) {
        Employee emp = dynamoDBMapper.load(Employee.class, employeeID);
        dynamoDBMapper.delete(emp);
        return "Employee deleted";
    }

    public String updateEmployee(String employeeId, Employee employee) {
        dynamoDBMapper.save(employee,
            new DynamoDBSaveExpression()
        .withExpectedEntry("employeeID",
            new ExpectedAttributeValue(
                new AttributeValue().withS(employeeId)
            )));
        return employeeId;
    }
}
