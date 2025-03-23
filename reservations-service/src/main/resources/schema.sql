CREATE
    TABLE
        IF NOT EXISTS reservations(
            reservation_id INT PRIMARY KEY,
            customer_id INT,
            venue VARCHAR(100),
            reservation_date TIMESTAMP,
            guests_count INT
        );
