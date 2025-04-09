// Switch to the retaildb database
db = db.getSiblingDB("retaildb");

// Create a user with readWrite role
db.createUser({
    user: "retail-service-user",
    pwd: "retail-service-password",
    roles: [{role: "readWrite", db: "retaildb"}]
});

// Create the retail_records collection and insert a sample document
db.retail_records.insertMany([
    {
        customer_id: 1,
        purchase_date: new Date(),
        items: [
            {item_id: "I001", item_name: "Laptop", quantity: 1, price: 1200},
            {item_id: "I002", item_name: "Mouse", quantity: 2, price: 25}
        ],
        total_amount: 1250
    },
    {
        customer_id: 2,
        purchase_date: new Date(),
        items: [
            {item_id: "I003", item_name: "Keyboard", quantity: 1, price: 50},
            {item_id: "I004", item_name: "Monitor", quantity: 1, price: 300}
        ],
        total_amount: 350
    },
    {
        customer_id: 3,
        purchase_date: new Date(),
        items: [
            {item_id: "I005", item_name: "Desk Chair", quantity: 1, price: 150},
            {item_id: "I006", item_name: "Desk Lamp", quantity: 1, price: 40}
        ],
        total_amount: 190
    },
    {
        customer_id: 4,
        purchase_date: new Date(),
        items: [
            {item_id: "I007", item_name: "Tablet", quantity: 1, price: 500},
            {item_id: "I008", item_name: "Tablet Case", quantity: 1, price: 30}
        ],
        total_amount: 530
    },
    {
        customer_id: 5,
        purchase_date: new Date(),
        items: [
            {item_id: "I009", item_name: "Smartphone", quantity: 1, price: 800},
            {item_id: "I010", item_name: "Screen Protector", quantity: 2, price: 20}
        ],
        total_amount: 840
    }
]);
