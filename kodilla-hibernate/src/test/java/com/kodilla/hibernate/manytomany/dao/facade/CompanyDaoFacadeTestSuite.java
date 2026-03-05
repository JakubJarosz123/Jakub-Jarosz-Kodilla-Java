package com.kodilla.hibernate.manytomany.dao.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import com.kodilla.hibernate.manytomany.facade.CompanyDaoFacade;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class CompanyDaoFacadeTestSuite {

    @Autowired
    private CompanyDaoFacade companyDaoFacade;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void searchForCompanyByNameFragment() {
        //Given
        Company companyOne = new Company("Data Masters");
        Company companyTwo = new Company("School Programmers");
        Company companyThree = new Company("FreeStyle Masters");

        companyDao.save(companyOne);
        companyDao.save(companyTwo);
        companyDao.save(companyThree);
        //When
        List<Company> result = companyDaoFacade.retrieveByNameFragment("Mast");
        //Then
        assertEquals(2, result.size());
        //Clean up
        companyDao.deleteAll();
        employeeDao.deleteAll();
    }

    @Test
    void searchForEmployeeByLastnameFragment() {
        //Given
        employeeDao.deleteAll();

        Employee employeeOne = new Employee("John", "Smith");
        Employee employeeTwo = new Employee("Melani", "Smith");
        Employee employeeThree = new Employee("George", "Smiles");

        employeeDao.save(employeeOne);
        employeeDao.save(employeeTwo);
        employeeDao.save(employeeThree);
        //When
        List<Employee> result = companyDaoFacade.retrieveByLastnameFragment("Smi");
        //Then
        assertEquals(3, result.size());
        //Clean up
        employeeDao.deleteAll();
        companyDao.deleteAll();
    }
}