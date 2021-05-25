package repository;

import account.CurrentAccount;
import client.Client;
import databaseConfiguration.DatabaseConfiguration;

import java.sql.*;

public class CurrentAccountRepository {


    public void insertCurrentAccount(CurrentAccount currentAccount) {
        String insertCardSql = "INSERT INTO current_accounts VALUES("+currentAccount.getId()+",'"+currentAccount.getAccHolder()+"',"+currentAccount.getFounds()+",'"+currentAccount.getAccNr()+"','"+currentAccount.getIban()+"')";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeUpdateSql(databaseConnection, insertCardSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CurrentAccount getCurrentAccountById(int id) {
        String selectSql = "SELECT * FROM current_accounts WHERE id=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToCurrentAccount(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void displayCurrentAccounts() {
        String selectSql = "SELECT * FROM current_accounts";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            ResultSet resultSet = repositoryHelper.executeQuerySql(databaseConnection, selectSql);
            while (resultSet.next()) {
                System.out.println("\n Current Accounts");
                System.out.println("Id:" + resultSet.getString(1));
                System.out.println("Name:" + resultSet.getString(2));
                System.out.println("Founds:" + resultSet.getString(3));
                System.out.println("Account Number:" + resultSet.getString(4));
                System.out.println("Iban:" + resultSet.getString(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // PreparedStatement
    public void updateFoundsCurrentAccount(double founds, int id) {
        String updateFounds = "UPDATE current_accounts SET founds=? WHERE id=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateFounds);
            preparedStatement.setDouble(1, founds);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCurrentAccount(int id){
        String sql = "DELETE FROM current_accounts WHERE id=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    private CurrentAccount mapToCurrentAccount(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new CurrentAccount(resultSet.getInt(1), resultSet.getString(2),resultSet.getDouble(3),resultSet.getInt(4), resultSet.getString(5));
        }
        return null;
    }
}
