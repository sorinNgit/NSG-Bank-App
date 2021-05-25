package repository;

import card.Card;
import client.*;
import databaseConfiguration.*;
import java.sql.*;

public class ClientRepository {
    // CallableStatement
    public void insertClient(Client client) {
        String insertPersonSql = "INSERT INTO clients(name) VALUES('"+client.getName()+"')";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeUpdateSql(databaseConnection, insertPersonSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // PreparedStatement - use when we have parameters
    public Client getPersonById(int id) {
        String selectSql = "SELECT * FROM clients WHERE id=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToClient(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // PreparedStatement
    public void updateClientName(String name, int id) {
        String updateNameSql = "UPDATE clients SET name=? WHERE id=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteClient(int id){
        String sql = "DELETE FROM clients WHERE id=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    private Client mapToClient(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new Client(resultSet.getInt(1), resultSet.getString(2));
        }
        return null;
    }

}
