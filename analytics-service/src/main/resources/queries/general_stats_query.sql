SELECT
    'reservations' AS recordType,
    COUNT(*) AS rowCount
FROM
    reservations_service_db.public.reservations
UNION ALL SELECT
    'customers' AS recordType,
    COUNT(*) AS rowCount
FROM
    customers_service_db.customersdb.customers