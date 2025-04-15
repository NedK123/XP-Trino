// Switch to the retaildb database
db = db.getSiblingDB("retaildb");

// Create a user with readWrite role
db.createUser({
  user: "retail-service-user",
  pwd: "retail-service-password",
  roles: [{ role: "readWrite", db: "retaildb" }],
});

// Create the retail_records collection and insert a sample document
db.retail_records.insertMany([
  {
    customer_id: 1,
    purchase_date: new Date(),
    items: [
      { item_id: "I001", item_name: "Smartwatch", quantity: 1, price: 250 },
      {
        item_id: "I002",
        item_name: "Wireless Earbuds",
        quantity: 1,
        price: 80,
      },
    ],
    total_amount: 330,
    shipping_address: "123 Elm St, Springfield, IL",
    payment_method: "Credit Card",
    delivery_info: {
      delivery_date: new Date(),
      tracking_number: "TRK123456789",
      carrier: "FedEx",
    },
  },
  {
    customer_id: 2,
    purchase_date: new Date(),
    items: [
      { item_id: "I003", item_name: "Gaming Laptop", quantity: 1, price: 1500 },
      { item_id: "I004", item_name: "Laptop Cooler", quantity: 1, price: 40 },
    ],
    total_amount: 1540,
    shipping_address: "456 Oak Ave, New York, NY",
    payment_method: "PayPal",
    delivery_info: {
      delivery_date: new Date(),
      tracking_number: "TRK987654321",
      carrier: "UPS",
    },
  },
  {
    customer_id: 3,
    purchase_date: new Date(),
    items: [
      {
        item_id: "I005",
        item_name: "Bluetooth Speaker",
        quantity: 1,
        price: 70,
      },
      {
        item_id: "I006",
        item_name: "Portable Charger",
        quantity: 1,
        price: 40,
      },
    ],
    total_amount: 110,
    shipping_address: "789 Pine Rd, Los Angeles, CA",
    payment_method: "Debit Card",
    delivery_info: {
      delivery_date: new Date(),
      tracking_number: "TRK555666777",
      carrier: "DHL",
    },
  },
  {
    customer_id: 4,
    purchase_date: new Date(),
    items: [
      { item_id: "I007", item_name: "4K TV", quantity: 1, price: 1200 },
      { item_id: "I008", item_name: "HDMI Cable", quantity: 2, price: 10 },
    ],
    total_amount: 1220,
    shipping_address: "101 Maple Dr, Miami, FL",
    payment_method: "Credit Card",
    delivery_info: {
      delivery_date: new Date(),
      tracking_number: "TRK444333222",
      carrier: "USPS",
    },
  },
  {
    customer_id: 5,
    purchase_date: new Date(),
    items: [
      { item_id: "I009", item_name: "Smartphone", quantity: 1, price: 800 },
      {
        item_id: "I010",
        item_name: "Screen Protector",
        quantity: 2,
        price: 20,
      },
    ],
    total_amount: 840,
    shipping_address: "202 Birch St, Austin, TX",
    payment_method: "Credit Card",
    delivery_info: {
      delivery_date: new Date(),
      tracking_number: "TRK112233445",
      carrier: "Royal Mail",
    },
  },
  {
    customer_id: 6,
    purchase_date: new Date(),
    items: [
      { item_id: "I011", item_name: "Smart TV", quantity: 1, price: 800 },
      { item_id: "I012", item_name: "Soundbar", quantity: 1, price: 150 },
    ],
    total_amount: 950,
    shipping_address: "303 Cedar St, Springfield, IL",
    payment_method: "Credit Card",
    delivery_info: {
      delivery_date: new Date(),
      tracking_number: "TRK223344556",
      carrier: "FedEx",
    },
  },
  {
    customer_id: 7,
    purchase_date: new Date(),
    items: [
      { item_id: "I013", item_name: "Digital Camera", quantity: 1, price: 500 },
      { item_id: "I014", item_name: "Tripod", quantity: 1, price: 75 },
    ],
    total_amount: 575,
    shipping_address: "404 Birch St, Springfield, IL",
    payment_method: "Debit Card",
    delivery_info: {
      delivery_date: new Date(),
      tracking_number: "TRK667788990",
      carrier: "UPS",
    },
  },
  {
    customer_id: 8,
    purchase_date: new Date(),
    items: [
      { item_id: "I015", item_name: "Coffee Maker", quantity: 1, price: 120 },
      { item_id: "I016", item_name: "Coffee Grinder", quantity: 1, price: 40 },
    ],
    total_amount: 160,
    shipping_address: "505 Walnut St, Springfield, IL",
    payment_method: "PayPal",
    delivery_info: {
      delivery_date: new Date(),
      tracking_number: "TRK998877665",
      carrier: "USPS",
    },
  },
  {
    customer_id: 9,
    purchase_date: new Date(),
    items: [
      { item_id: "I017", item_name: "Smartphone Case", quantity: 1, price: 25 },
      {
        item_id: "I018",
        item_name: "Screen Protector",
        quantity: 1,
        price: 10,
      },
    ],
    total_amount: 35,
    shipping_address: "606 Pine St, Springfield, IL",
    payment_method: "Credit Card",
    delivery_info: {
      delivery_date: new Date(),
      tracking_number: "TRK223355667",
      carrier: "DHL",
    },
  },
  {
    customer_id: 10,
    purchase_date: new Date(),
    items: [
      { item_id: "I019", item_name: "Gaming Chair", quantity: 1, price: 200 },
      { item_id: "I020", item_name: "Mouse Pad", quantity: 1, price: 15 },
    ],
    total_amount: 215,
    shipping_address: "707 Oak St, Springfield, IL",
    payment_method: "Debit Card",
    delivery_info: {
      delivery_date: new Date(),
      tracking_number: "TRK112233667",
      carrier: "Royal Mail",
    },
  },
]);

// TODO then lets add some new records
// db.retail_records.insertMany([
//     {
//         customer_id: 11,
//         purchase_date: new Date(),
//         items: [
//             {item_id: "I001", item_name: "Smartwatch", quantity: 1, price: 250},
//             {item_id: "I002", item_name: "Wireless Earbuds", quantity: 1, price: 80}
//         ],
//         total_amount: 330,
//         shipping_address: "123 Elm St, Springfield, IL",
//         payment_method: "Credit Card",
//         status: "Completed"  // New field added
//     },
//     {
//         customer_id: 12,
//         purchase_date: new Date(),
//         items: [
//             {item_id: "I003", item_name: "Gaming Laptop", quantity: 1, price: 1500},
//             {item_id: "I004", item_name: "Laptop Cooler", quantity: 1, price: 40}
//         ],
//         total_amount: 1540,
//         shipping_address: "456 Oak Ave, New York, NY",
//         payment_method: "PayPal",
//         status: "Pending"  // New field added
//     }
// ]);
