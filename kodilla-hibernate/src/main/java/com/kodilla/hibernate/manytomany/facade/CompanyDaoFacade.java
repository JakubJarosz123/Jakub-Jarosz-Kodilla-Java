package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.smartcardio.CommandAPDU;
import java.util.List;

@Service
public class CompanyDaoFacade {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    public List<Company> retrieveByNameFragment(String name) {
        String result = "%" + name + "%";
        return companyDao.retrieveByNameFragment(result);
    }

    public List<Employee> retrieveByLastnameFragment(String lastname) {
        String result = "%" + lastname + "%";
        return employeeDao.retrieveByLastnameFragment(result);
    }
}
