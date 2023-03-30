package isep.mywebapp.Repositories.DAO;
import isep.mywebapp.Models.Dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptDAO extends DAO{
    public DeptDAO(Connection connect) {
        super(connect);
        super.connect = connect;
    }

    @Override
    public Dept find(int id) throws SQLException {
        String getDeptById = "SELECT * FROM TP1SCHEMA.DEPT WHERE DEPTNO = ?";
        PreparedStatement preparedStatement = connect.prepareStatement(getDeptById);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        return mapResultSetToDept(resultSet);
    }

    private Dept mapResultSetToDept(ResultSet resultSet) throws SQLException {
        Dept dept = new Dept();
        while(resultSet.next()){
            int id = resultSet.getInt("deptno");
            String name = resultSet.getString("dname");
            String location = resultSet.getString("loc");
            dept.setDeptNo(id);
            dept.setdName(name);
            dept.setLoc(location);
        }
        return dept;
    }

    @Override
    public boolean create(Object object) {
        return false;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public boolean delete(Object object) {
        return false;
    }


}
