package isep.mywebapp.Controllers;

import isep.mywebapp.Models.Dept;
import isep.mywebapp.Models.EmpOld;
import isep.mywebapp.Services.TP3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.SQLException;

@RestController
public class TP3Controller {
    @Autowired
    TP3Service tp3Service;

    @Autowired
    Connection connection;

    @GetMapping(value="database/{tableName}")
    public String getTableData(@PathVariable String tableName) throws SQLException {
        return tp3Service.getTableDataWithColumns(tableName);
    }

    @GetMapping(value="dept/{deptNo}")
    public Dept getDeptByNo(@PathVariable int deptNo) throws SQLException {
        return tp3Service.getDeptById(deptNo);
    }

    @GetMapping(value="emp/{empNo}")
    public String getEmpByNo(@PathVariable int empNo) throws SQLException{
        String output = "Employee: ";
        EmpOld empOld = tp3Service.getEmpById(empNo);
        output = output + " <br/> number: " + empOld.getEmpNo() + " | first name: " + empOld.getEfirst() + " | last name: " + empOld.getEname();
        output = output + " | job: " + empOld.getJob() + " | commission: " + empOld.getComm();
        output = output + " | hire date: "+ empOld.getHireDate() + " | salary: " + empOld.getSal() + " | phone number: " + empOld.getTel() + "<br/>";
        output = output + "<br/> They work in department number "+ empOld.getDepartment().getDeptNo() + " corresponding to "+ empOld.getDepartment().getdName() + "<br/>";
        output = output + "<br/> Their manager's number is : "+ empOld.getMgr().getEmpNo() + " corresponding to "+ empOld.getMgr().getEfirst() + " " + empOld.getMgr().getEname();
        return output;
    }
}


