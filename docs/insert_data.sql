-- Insert into Cities
INSERT INTO Cities (name) VALUES
                              ('Giza'),
                              ('Cairo'),
                              ('Luxor'),
                              ('Aswan');

-- Insert into Tags
INSERT INTO Tags (displayName) VALUES
                                   ('HISTORY'),
                                   ('UNESCO'),
                                   ('MONUMENT'),
                                   ('MUSEUM'),
                                   ('FAMOUS'),
                                   ('TEMPLE'),
                                   ('ANCIENT'),
                                   ('FORTRESS'),
                                   ('ARCHITECTURE');

-- Insert into TouristAttractions
INSERT INTO TouristAttractions (name, description, city_id)
VALUES
    ('Pyramids of Giza', 'The iconic pyramids built as tombs for ancient Pharaohs.', 1),
    ('Egyptian Museum', 'Houses an extensive collection of ancient Egyptian antiquities.', 2),
    ('Cairo Citadel', 'A medieval Islamic fortification located in Cairo.', 2),
    ('Luxor Temple', 'A large Ancient Egyptian temple complex located on the east bank of the Nile.', 3),
    ('The Valley of the Kings', 'The burial site of many ancient Egyptian Pharaohs.', 3),
    ('Karnak Temple', 'A massive temple complex dedicated to the Theban triad of Amun, Mut, and Khonsu.', 3),
    ('Abu Simbel', 'Two massive rock temples built during the reign of Pharaoh Ramses II.', 4);
