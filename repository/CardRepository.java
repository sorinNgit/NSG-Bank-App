package repository;

import client.Client;
import databaseConfiguration.DatabaseConfiguration;
import card.Card;
import java.sql.*;

public class CardRepository {

    // CallableStatement
    public void insertCard(Card card) {
        String insertCardSql = "INSERT INTO cards VALUES("+card.getId()+",'"+card.getName()+"',"+card.getCvc()+",'"+card.getNumber()+"','"+card.getExp()+"')";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeUpdateSql(databaseConnection, insertCardSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // PreparedStatement - use when we have parameters
    public Card getCardById(int id) {
        String selectSql = "SELECT * FROM cards WHERE id=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToCard(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // PreparedStatement
    public void updateCvc(int cvc, int id) {
        String updateCvcSql = "UPDATE cards SET cvc=? WHERE id=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateCvcSql);
            preparedStatement.setInt(1, cvc);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCards(int id){
        String sql = "DELETE FROM cards WHERE id=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    private Card mapToCard(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new Card(resultSet.getInt(1), resultSet.getString(2),resultSet.getInt(3),resultSet.getString(4), resultSet.getString(5));
        }
        return null;
    }

    public void displayCards() {
        String selectSql = "SELECT * FROM cards";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            ResultSet resultSet = repositoryHelper.executeQuerySql(databaseConnection, selectSql);
            while (resultSet.next()) {
                System.out.println("\n Cards");
                System.out.println("Id:" + resultSet.getString(1));
                System.out.println("Name:" + resultSet.getString(2));
                System.out.println("Cvc:" + resultSet.getString(3));
                System.out.println("Number:" + resultSet.getString(4));
                System.out.println("Expiry:" + resultSet.getString(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
