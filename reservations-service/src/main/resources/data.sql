-- This is testing data
-- Empty the table before inserting new data
DELETE
FROM
    reservations;

INSERT
    INTO
        reservations(
            reservation_id,
            customer_id,
            venue,
            reservation_date,
            guests_count
        )
    VALUES(
        1,
        2,
        'The Grand Palace',
        '2025-03-23 18:30:00',
        4
    ),
    (
        2,
        5,
        'Ocean Breeze Resort',
        '2025-03-24 19:00:00',
        2
    ),
    (
        3,
        9,
        'The Italian Hub',
        '2025-03-25 20:15:00',
        6
    ),
    (
        4,
        2,
        'Greenfield Garden',
        '2025-03-26 17:30:00',
        3
    ),
    (
        5,
        10,
        'Seaside Grill',
        '2025-03-27 18:00:00',
        5
    ),
    (
        6,
        15,
        'Sunset Lounge',
        '2025-03-28 19:45:00',
        7
    ),
    (
        7,
        4,
        'The Oak Tavern',
        '2025-03-29 18:30:00',
        8
    ),
    (
        8,
        5,
        'Riverside Diner',
        '2025-03-30 20:00:00',
        4
    ),
    (
        9,
        7,
        'Greenfield Garden',
        '2025-04-01 17:15:00',
        10
    ),
    (
        10,
        12,
        'City View Restaurant',
        '2025-04-02 18:30:00',
        2
    ),
    (
        11,
        13,
        'The Grand Palace',
        '2025-04-03 19:30:00',
        5
    ),
    (
        12,
        9,
        'The Forest Retreat',
        '2025-04-04 17:45:00',
        3
    ),
    (
        13,
        2,
        'Greenfield Garden',
        '2025-04-05 20:00:00',
        4
    ),
    (
        14,
        20,
        'The Vintage Lounge',
        '2025-04-06 19:00:00',
        6
    ),
    (
        15,
        14,
        'Crystal Palace',
        '2025-04-07 18:15:00',
        7
    ),
    (
        16,
        3,
        'The Italian Hub',
        '2025-04-08 18:45:00',
        3
    ),
    (
        17,
        2,
        'Greenfield Garden',
        '2025-04-09 19:15:00',
        8
    ),
    (
        18,
        17,
        'The Italian Hub',
        '2025-04-10 20:30:00',
        6
    ),
    (
        19,
        7,
        'The Grand Palace',
        '2025-04-11 17:30:00',
        9
    ),
    (
        20,
        20,
        'The Vintage Lounge',
        '2025-04-12 18:00:00',
        4
    ),
    (
        21,
        7,
        'The Grand Palace',
        '2025-07-11 17:30:00',
        19
    ),
    (
        22,
        2,
        'The Vintage Lounge',
        '2025-07-14 17:30:00',
        5
    ),
    (
        23,
        7,
        'Greenfield Garden',
        '2025-11-11 17:30:00',
        1
    ),
    (
        24,
        7,
        'The Grand Palace',
        '2025-11-12 17:30:00',
        200
    );
