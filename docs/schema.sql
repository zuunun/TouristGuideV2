-- Drop tables if they exist to avoid conflicts
DROP TABLE IF EXISTS TouristAttractions;
DROP TABLE IF EXISTS Cities;
DROP TABLE IF EXISTS Tags;

-- Create tables
CREATE TABLE Cities (
            id INT AUTO_INCREMENT PRIMARY KEY,
            name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE Tags (
            id INT AUTO_INCREMENT PRIMARY KEY,
            displayName VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE TouristAttractions (
            id INT AUTO_INCREMENT PRIMARY KEY,
            name VARCHAR(100) NOT NULL,
            description TEXT,
            city_id INT,
            FOREIGN KEY (city_id) REFERENCES Cities(id) ON DELETE CASCADE
);
