package isep.mywebapp.Repositories.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class EmpDAO extends DAO{
    @Autowired
    public EmpDAO(Connection connect) {
        super(connect);
        super.connect = connect;

    }
    @Override
    public ResultSet find(int id) throws SQLException {
        String getEmpById = "SELECT * FROM TP1SCHEMA.EMP WHERE EMPNO = ?";
        PreparedStatement preparedStatement = connect.prepareStatement(getEmpById);
        preparedStatement.setInt(1, id);
        if(preparedStatement.executeQuery().next()){
            return preparedStatement.executeQuery();
        }
            return null;
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
