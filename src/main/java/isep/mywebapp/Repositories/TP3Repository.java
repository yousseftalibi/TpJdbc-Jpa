package isep.mywebapp.Repositories;

import org.springframework.stereotype.Repository;
import java.sql.*;

@Repository
public class TP3Repository {

    public static ResultSet displayTable(Connection connection, String tableName) throws SQLException {
        String query = "SELECT * FROM " + tableName;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
    }

    public static void displayDepartment(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SELECT DEPTNO, DNAME, LOC FROM TP1SCHEMA.dept";
        ResultSet result = statement.executeQuery(query);

        while(result.next()) {
            int deptNo = result.getInt("DEPTNO");
            String dName = result.getString("DNAME");
            String location = result.getString("LOC");
            System.out.println("Departement "+ deptNo + " is for " + dName + " and located in " + location);
        }

        result.close();
    }

    public static void moveDepartment(int empNo, int newDeptNo, Connection connection) throws SQLException {
        String query = "UPDATE TP1SCHEMA.EMP SET DEPTNO = ? WHERE EMPNO = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, newDeptNo);
        preparedStatement.setInt(2, empNo);
        int updateStatus = preparedStatement.executeUpdate();
        System.out.println("numbers of rows updated: " + updateStatus);

    }


}
