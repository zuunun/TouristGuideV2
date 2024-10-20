package org.example.touristguide.repository;

import org.example.touristguide.model.TouristAttraction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;

@Repository
public class TouristRepository {

    @Value("touristguidev2.mysql.database.azure.com")
    private String dbUrl;
    @Value("zuzu")
    private String username;
    @Value("Zuhurunun123")
    private String password;

    // CREATE
    public void saveAttraction(TouristAttraction attraction) {
        String sql = "INSERT INTO TouristAttractions (name, description, city_id) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(dbUrl, username, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, attraction.getName());
            statement.setString(2, attraction.getDescription());
            int cityId = getCityIdByName(attraction.getCity());
            statement.setInt(3, cityId);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ - Get All Attractions
    public List<TouristAttraction> getAllAttractions() {
        List<TouristAttraction> attractions = new ArrayList<>();
        String sql = "SELECT * FROM TouristAttractions";
        try (Connection connection = DriverManager.getConnection(dbUrl, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                TouristAttraction attraction = mapToAttraction(resultSet);
                attractions.add(attraction);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attractions;
    }

    // READ - Get Attraction by Name
    public TouristAttraction getAttractionByName(String name) {
        String sql = "SELECT * FROM TouristAttractions WHERE name = ?";
        try (Connection connection = DriverManager.getConnection(dbUrl, username, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return mapToAttraction(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // DELETE
    public void deleteAttraction(String name) {
        String sql = "DELETE FROM TouristAttractions WHERE name = ?";
        try (Connection connection = DriverManager.getConnection(dbUrl, username, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new NoSuchElementException("Attraction not found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void updateAttraction(TouristAttraction updatedAttraction) {
        String sql = "UPDATE TouristAttractions SET description = ?, city_id = ? WHERE name = ?";
        try (Connection connection = DriverManager.getConnection(dbUrl, username, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, updatedAttraction.getDescription());
            int cityId = getCityIdByName(updatedAttraction.getCity());
            statement.setInt(2, cityId);
            statement.setString(3, updatedAttraction.getName());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                throw new NoSuchElementException("Attraction not found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get City ID by Name
    private int getCityIdByName(String cityName) {
        String sql = "SELECT id FROM Cities WHERE name = ?";
        try (Connection connection = DriverManager.getConnection(dbUrl, username, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, cityName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new NoSuchElementException("City not found");
    }

    // Get City Name by ID
    private String getCityNameById(int cityId) {
        String sql = "SELECT name FROM Cities WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(dbUrl, username, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, cityId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("name");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new NoSuchElementException("City not found");
    }

    // Map ResultSet to TouristAttraction Object
    private TouristAttraction mapToAttraction(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        int cityId = resultSet.getInt("city_id");

        String cityName = getCityNameById(cityId);

        TouristAttraction attraction = new TouristAttraction(id, name, description, cityName);
        // Note: Set tags if necessary
        return attraction;
    }

    // READ - Get all Cities
    public List<String> getCities() {
        List<String> cities = new ArrayList<>();
        String sql = "SELECT name FROM Cities";
        try (Connection connection = DriverManager.getConnection(dbUrl, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                cities.add(resultSet.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    // READ - Get all Tags
    public List<String> getTags() {
        // Placeholder method for getting tags from the database if needed
        return Collections.emptyList();
    }
}
