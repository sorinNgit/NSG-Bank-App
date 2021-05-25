package repository;

import account.CurrentAccount;
import account.SavingsAccount;
import databaseConfiguration.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SavingsAccountRepository {



    public static void insertSavingsAccount(SavingsAccount savingsAccount) {
        String insertCardSql = "INSERT INTO savings_accounts VALUES("+savingsAccount.getId()+",'"+savingsAccount.getAccHolder()+"',"+savingsAccount.getFounds()+",'"+savingsAccount.getAccNr()+"','"+savingsAccount.getIban()+"')";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeUpdateSql(databaseConnection, insertCardSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public SavingsAccount getSavingsAccountById(int id) {
        String selectSql = "SELECT * FROM savings_accounts WHERE id=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToSavingsAccount(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateFoundsSavingsAccount(double founds, int id) {
        String updateFounds = "UPDATE savings_accounts SET founds=? WHERE id=?";

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

    private SavingsAccount mapToSavingsAccount(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new SavingsAccount(resultSet.getInt(1), resultSet.getString(2),resultSet.getDouble(3),resultSet.getInt(4), resultSet.getString(5));
        }
        return null;
    }

    public void deleteSavingsAccount(int id){
        String sql = "DELETE FROM savings_accounts WHERE id=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void displaySavingsAccount() {
        String selectSql = "SELECT * FROM savings_accounts";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            ResultSet resultSet = repositoryHelper.executeQuerySql(databaseConnection, selectSql);
            while (resultSet.next()) {
                System.out.println("\n Savings Accounts");
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
}
