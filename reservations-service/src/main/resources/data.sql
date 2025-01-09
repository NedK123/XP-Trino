INSERT INTO reservations (reservation_id, customer_id, venue_id, reservation_date, guests_count)
VALUES
    (1, 1, 1, '2025-02-01 18:00:00', 4),
    (2, 2, 3, '2025-02-02 19:30:00', 2),
    (3, 3, 2, '2025-02-03 20:00:00', 6),
    -- Repeat the next line 997 times to generate 1000 records
    (1000, 1000, 1000, '2025-02-28 17:00:00', 3);
