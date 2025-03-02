package animal.shelter.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDAO {
    protected DBAccess dbAccess;
    protected PreparedStatement preparedStatement;

    public AbstractDAO(DBAccess dbAccess) {
        this.dbAccess = dbAccess;
    }

    /**
     * Builds a prepared Statement from the sql string. A DAO should used this to
     * fill the parameters.
     *
     * @param sql,
     *            the SQl query
     */
    protected void setupPreparedStatement(String sql) throws SQLException {
        preparedStatement = dbAccess.getConnection().prepareStatement(sql);
    }

    /**
     * Executes the prepared statement without result. Used for insert, update and
     * delete statements.
     *
     */
    protected void executeManipulateStatement() throws SQLException {
        preparedStatement.executeUpdate();
    }

    /**
     * Executes the prepared statement with result. Used for select statements.
     *
     *
     */
    protected ResultSet executeSelectStatement() throws SQLException {
        return preparedStatement.executeQuery();
    }

    /**
     * Executes a prepared statement with result to get a generated key.
     *
     * @param sql,
     *            the SQL query
     */
    protected void setupPreparedStatementWithKey(String sql) throws SQLException {
        preparedStatement = dbAccess.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    }

    protected int executeInsertStatementWithKey() throws SQLException {
        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        int gegenereerdeSleutel = 0;
        while (resultSet.next()) {
            gegenereerdeSleutel = resultSet.getInt(1);
        }
        return gegenereerdeSleutel;
    }
}
