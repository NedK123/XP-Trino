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
            {item_id: "I001", item_name: "Smartwatch", quantity: 1, price: 250},
            {item_id: "I002", item_name: "Wireless Earbuds", quantity: 1, price: 80}
        ],
        total_amount: 330,
        shipping_address: "123 Elm St, Springfield, IL",
        payment_method: "Credit Card"
    },
    {
        customer_id: 2,
        purchase_date: new Date(),
        items: [
            {item_id: "I003", item_name: "Gaming Laptop", quantity: 1, price: 1500},
            {item_id: "I004", item_name: "Laptop Cooler", quantity: 1, price: 40}
        ],
        total_amount: 1540,
        shipping_address: "456 Oak Ave, New York, NY",
        payment_method: "PayPal"
    },
    {
        customer_id: 3,
        purchase_date: new Date(),
        items: [
            {item_id: "I005", item_name: "Bluetooth Speaker", quantity: 1, price: 70},
            {item_id: "I006", item_name: "Portable Charger", quantity: 1, price: 40}
        ],
        total_amount: 110,
        shipping_address: "789 Pine Rd, Los Angeles, CA",
        payment_method: "Debit Card"
    },
    {
        customer_id: 4,
        purchase_date: new Date(),
        items: [
            {item_id: "I007", item_name: "4K TV", quantity: 1, price: 1200},
            {item_id: "I008", item_name: "HDMI Cable", quantity: 2, price: 10}
        ],
        total_amount: 1220,
        shipping_address: "101 Maple Dr, Miami, FL",
        payment_method: "Credit Card"
    },
    {
        customer_id: 5,
        purchase_date: new Date(),
        items: [
            {item_id: "I009", item_name: "Smartphone", quantity: 1, price: 800},
            {item_id: "I010", item_name: "Screen Protector", quantity: 2, price: 20}
        ],
        total_amount: 840,
        shipping_address: "202 Birch St, Austin, TX",
        payment_method: "Credit Card"
    },
    {
        customer_id: 6,
        purchase_date: new Date(),
        items: [
            {item_id: "I011", item_name: "Tablet", quantity: 1, price: 500},
            {item_id: "I012", item_name: "Tablet Case", quantity: 1, price: 30}
        ],
        total_amount: 530,
        shipping_address: "303 Cedar Ave, Denver, CO",
        payment_method: "Debit Card"
    },
    {
        customer_id: 7,
        purchase_date: new Date(),
        items: [
            {item_id: "I013", item_name: "Laptop", quantity: 1, price: 1200},
            {item_id: "I014", item_name: "Laptop Bag", quantity: 1, price: 50}
        ],
        total_amount: 1250,
        shipping_address: "404 Pine St, Seattle, WA",
        payment_method: "PayPal"
    },
    {
        customer_id: 8,
        purchase_date: new Date(),
        items: [
            {item_id: "I015", item_name: "Smartwatch", quantity: 1, price: 250},
            {item_id: "I016", item_name: "Fitness Band", quantity: 1, price: 70}
        ],
        total_amount: 320,
        shipping_address: "505 Maple St, Boston, MA",
        payment_method: "Credit Card"
    },
    {
        customer_id: 9,
        purchase_date: new Date(),
        items: [
            {item_id: "I017", item_name: "Headphones", quantity: 1, price: 150},
            {item_id: "I018", item_name: "Headphone Case", quantity: 1, price: 20}
        ],
        total_amount: 170,
        shipping_address: "606 Oak St, Chicago, IL",
        payment_method: "Debit Card"
    },
    {
        customer_id: 10,
        purchase_date: new Date(),
        items: [
            {item_id: "I019", item_name: "Smartphone", quantity: 1, price: 700},
            {item_id: "I020", item_name: "Charging Cable", quantity: 1, price: 15}
        ],
        total_amount: 715,
        shipping_address: "707 Elm St, Phoenix, AZ",
        payment_method: "Credit Card"
    }
]);

// Check if the _schema collection exists. If not, create it manually
db.createCollection("_schema");

// Create the _schema collection for the retail_records collection
db.getCollection("_schema").insertOne({
    table: "retail_records",
    fields: [
        {
            name: "_id",
            type: "ObjectId",
            hidden: true
        },
        {
            name: "customer_id",
            type: "double",
            hidden: false
        },
        {
            name: "purchase_date",
            type: "timestamp(3)",
            hidden: false
        },
        {
            name: "items",
            type: "array(row(\"item_id\" varchar,\"item_name\" varchar,\"quantity\" double,\"price\" double))",
            hidden: false
        },
        {
            name: "total_amount",
            type: "double",
            hidden: false
        },
        {
            name: "shipping_address",
            type: "varchar",
            hidden: false
        },
        {
            name: "payment_method",
            type: "varchar",
            hidden: false
        }
    ]
});