CREATE TABLE reservations (
                              reservation_id INT PRIMARY KEY,
                              customer_id INT,
                              venue_id INT,
                              reservation_date DATETIME,
                              guests_count INT,
                              FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
                              FOREIGN KEY (venue_id) REFERENCES venues(venue_id)
);