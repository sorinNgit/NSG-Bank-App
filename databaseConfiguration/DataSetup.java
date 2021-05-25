package databaseConfiguration;

import repository.RepositoryHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSetup {

    public void setUp(String table) {
        String createTableSql = "";
        if(table == "clients") {
            createTableSql += "CREATE TABLE IF NOT EXISTS " + table +
                    "(id int PRIMARY KEY AUTO_INCREMENT, name varchar(30))";
        }
        else if(table == "current_accounts"){
            createTableSql += "CREATE TABLE IF NOT EXISTS " + table +
                    "(id int PRIMARY KEY AUTO_INCREMENT, name varchar(30)," +
                    "founds double, acc_number integer(4), iban varchar(40))";
        }
        else if(table == "savings_accounts"){
            createTableSql += "CREATE TABLE IF NOT EXISTS " + table +
                    "(id int PRIMARY KEY AUTO_INCREMENT, name varchar(30)," +
                    "founds double, acc_number integer(4), iban varchar(40))";
        }
        else if(table == "cards") {
            createTableSql += "CREATE TABLE IF NOT EXISTS " + table +
                    "(id int PRIMARY KEY AUTO_INCREMENT, name varchar(30)," +
                    "cvc integer(4), card_nr varchar(30), exp varchar(30))";
        }
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeSql(databaseConnection, createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addNewClient(String name) {
        String insertPersonSql = "INSERT INTO clients(name) VALUES('"+name+"')";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeUpdateSql(databaseConnection, insertPersonSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayClient() {
        String selectSql = "SELECT * FROM clients";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            ResultSet resultSet = repositoryHelper.executeQuerySql(databaseConnection, selectSql);
            while (resultSet.next()) {
                System.out.println("\n Clients");
                System.out.println("Id:" + resultSet.getString(1));
                System.out.println("Name:" + resultSet.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
