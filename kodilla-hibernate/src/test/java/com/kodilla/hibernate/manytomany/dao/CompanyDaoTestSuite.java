package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();
        companyDao.save(dataMaesters);
        int dataMaesterId = dataMaesters.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaesterId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
//        try {
//            companyDao.deleteById(softwareMachineId);
//            companyDao.deleteById(dataMaesterId);
//            companyDao.deleteById(greyMatterId);
//        } catch (Exception e) {
            //do nothing
//        }
    }

    @Test
    void testNamedQueries() {

        companyDao.deleteAll();
        employeeDao.deleteAll();

        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee heathLedger = new Employee("Heath", "Ledger");
        Employee marySmith = new Employee("Mary", "Smith");

        Company softwareMachine = new Company("Software Machine");
        Company softwareMaesters = new Company("Software Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        softwareMaesters.getEmployees().add(heathLedger);
        softwareMaesters.getEmployees().add(marySmith);
        greyMatter.getEmployees().add(heathLedger);

        johnSmith.getCompanies().add(softwareMachine);
        heathLedger.getCompanies().add(softwareMaesters);
        heathLedger.getCompanies().add(greyMatter);
        marySmith.getCompanies().add(softwareMaesters);

        //When
        companyDao.save(softwareMachine);
        companyDao.save(greyMatter);
        companyDao.save(softwareMaesters);
        employeeDao.save(johnSmith);
        employeeDao.save(heathLedger);
        employeeDao.save(marySmith);

        List<Employee> employees = employeeDao.retrieveEmployeeByLastname("Smith");
        List<Company> companies = companyDao.retrieveCompanyByFirstThreeLetters("Sof");

        //Then
        assertEquals(2, employees.size());
        assertEquals(2, companies.size());

        //CleanUp
        companyDao.deleteAll();
        employeeDao.deleteAll();

    }
}
