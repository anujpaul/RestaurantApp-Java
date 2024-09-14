CREATE TABLE MenuItemTable (
    ItemId BIGINT PRIMARY KEY,
    itemName VARCHAR(255) NOT NULL,
    amount DECIMAL(10, 2) Not null
);

INSERT INTO ItemTable (itemId, itemName, amount)
VALUES 
(1, 'Chicken Dum Biryani', 25.00),
(2, 'Butter Chicken', 15.50),
(3, 'Paneer Tikka', 12.00),
(4, 'Masala Dosa', 8.00),
(5, 'Chole Bhature', 10.00),
(6, 'Biryani', 20.00),
(7, 'Rogan Josh', 18.00),
(8, 'Dal Makhani', 9.50),
(9, 'Aloo Paratha', 7.00),
(10, 'Malai Kofta', 14.00),
(11, 'Tandoori Chicken', 17.00);


create table orderstatustable (ordernumber bigint  PRIMARY KEY, status varchar(50), created_at DATETIME DEFAULT);

create table OrderItemTable(Id BIGINT, Ordernumber BIGINT, ItemId BIGINT, QTY INT);


Create order API:
{

    "status": "New",
    "orderItems": [
        {
            "itemTable": {
                
                "id": 2
                
                
            },
            "quantity": 3
        },
        {
            "itemTable": {
                
                "id": 3
                
            },
            "quantity": 1
        },
        {
            "itemTable": {
                
                "id": 4
                
            },
            "quantity": 1
        }
    ]
}


Add Item:

{
    "itemname": "Tandoori Chicken",
    "amount": 17.0
}

