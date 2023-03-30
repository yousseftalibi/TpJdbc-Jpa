package isep.mywebapp.Services;

import isep.mywebapp.Models.DAOFactory;
import isep.mywebapp.Models.Dept;
import isep.mywebapp.Models.EmpOld;
import isep.mywebapp.Repositories.TP3Repository;
import isep.mywebapp.Repositories.DAO.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
@Service
public class TP3Service {
    @Autowired
    TP3Repository tp3Repository;
    @Autowired
    DAOFactory daoFactory;
    @Autowired
    Connection connection;
    public String getTableDataWithColumns(String tableName) throws SQLException {
        ResultSet resultSet = tp3Repository.displayTable(connection, tableName);
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnCount = rsmd.getColumnCount();
        String output = "";
        for(int i = 1; i<=columnCount; i++){
            output= output + (rsmd.getColumnName(i) + " | ");
        }
        output = output + "<br/>";
        while(resultSet.next()){
            for(int i = 1; i<=columnCount; i++) {
                output = output + (resultSet.getString(rsmd.getColumnName(i)) + " | ");
            }
            output = output + "<br/>";
        }
        return output;
    }

    public Dept getDeptById(int id) throws SQLException {
        DAO<Dept> departmentDao = daoFactory.getDeptDAO();

        Dept dept20 = departmentDao.find(id);
        return dept20;
    }

    public EmpOld getEmpById(int id) throws SQLException{
        DAO<ResultSet> empDAO = daoFactory.getEmpDAO();

        if(empDAO.find(id)==null){
            return null;
        }
        EmpOld empOld = mapResultSetToEmp(empDAO.find(id));
        return empOld;
    }

    private EmpOld mapResultSetToEmp(ResultSet resultSet) throws SQLException {
        EmpOld empOld = new EmpOld();
        if(resultSet.next()){
            empOld.setEmpNo(resultSet.getLong("empno"));
            empOld.setEname(resultSet.getString("ename"));
            empOld.setEfirst(resultSet.getString("efirst"));
            empOld.setJob(resultSet.getString("job"));
            empOld.setMgr(getEmpById(resultSet.getInt("mgr")));
            empOld.setHireDate(resultSet.getDate("hiredate"));
            empOld.setSal(resultSet.getInt("sal"));
            empOld.setComm(resultSet.getInt("comm"));
            empOld.setTel(resultSet.getInt("tel"));
            empOld.setDepartment(getDeptById(resultSet.getInt("deptno")));
        }
        return empOld;
    }

}


