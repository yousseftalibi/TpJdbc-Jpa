package isep.mywebapp.Models;

import isep.mywebapp.Repositories.DAO.DAO;
import isep.mywebapp.Repositories.DAO.DeptDAO;
import isep.mywebapp.Repositories.DAO.EmpDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;

@Component
public class DAOFactory {
    @Autowired
    Connection connection;

    public DAO<Dept> getDeptDAO(){
        return new DeptDAO(connection);
    }

    public DAO<ResultSet> getEmpDAO(){
        return new EmpDAO(connection);
    }
}

