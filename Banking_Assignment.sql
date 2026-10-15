USE bank_db;
-- Create Customers table;
CREATE TABLE customers (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    city VARCHAR(50)
);

CREATE TABLE accounts (
    account_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    account_type VARCHAR(20),
    balance DECIMAL(10,2),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

SELECT * FROM Customers;
INSERT INTO customers (name, city) VALUES
('Janani','Chennai'),
('Arun','Coimbatore'),
('Priya','Madurai'),
('Karthik','Salem');
SELECT * FROM Accounts;
INSERT INTO accounts (customer_id, account_type, balance) VALUES
(1,'Savings',50000),
(1,'Current',20000),
(2,'Savings',30000),
(3,'Savings',15000),
(4,'Current',40000);

SELECT * FROM customers;

SELECT* FROM accounts WHERE balance > 20000;

SELECT * 
FROM customers
WHERE city = 'Chennai';

SELECT * 
FROM accounts
WHERE balance BETWEEN 20000 AND 50000;

SELECT * 
FROM customers
WHERE name LIKE 'J%';

SELECT * FROM accounts WHERE
account_type IN ('Savings','Current');

SELECT * FROM accounts WHERE
account_type <> 'Savings';

SELECT *
FROM customers
 WHERE name LIKE '%a%';

 SELECT *
 FROM accounts
 WHERE balance <=30000;

 SELECT *
 FROM customers
 WHERE city <> 'Madurai';

 SELECT *
 FROM accounts
 WHERE balance NOT BETWEEN
 10000 AND 40000;

SELECT *
FROM customers
WHERE name LIKE '%!';

SELECT *
FROM accounts
WHERE balance = 50000;

SELECT *
FROM customers 
WHERE city IN ('Chennai',
'Salem');

SELECT *
FROM accounts
WHERE balance > 10000
And balance < 40000;

SELECT *
FROM accounts
WHERE account_type NOT IN
('Current');

SELECT *
FROM accounts
ORDER BY balance DESC;

SELECT * 
FROM customers
ORDER BY name ASC;

SELECT *
FROM accounts
ORDER BY account_type ASC,
balance DESC;

SELECT SUM(balance)AS
total_balance
FROM accounts;

SELECT AVG(balance)AS
average_balance
FROM accounts;

SELECT MAX(balance)AS
maximum_balnce
FROM accounts;

SELECT MIN(balance)AS
minimum_balance
FROM accounts;

SELECT COUNT(*)AS
total_customers
FROM customers;

SELECT account_type,
SUM(balance)AS total_balance
FROM accounts
GROUP BY account_type;

SELECT account_type,
AVG(balance)AS
average_balance
FROM accounts
GROUP BY account_type;

SELECT account_type,
AVG(balance)AS
average_balance
FROM accounts
GROUP BY account_type
HAVING AVG (balance) > 20000;

SELECT customer_id,COUNT(*)
AS account_count
FROM accounts
GROUP BY customer_id;

SELECT customer_id, COUNT(*)
AS account_count
FROM accounts
GROUP BY customer_id
HAVING COUNT(*) > 1;

SELECT c.name,a.balance
FROM customers c
INNER JOIN accounts a
ON c.customer_id =
a.customer_id;

SELECT c.*,a.*
FROM customers c
LEFT JOIN accounts a
ON c.customer_id=
a.customer_id;

SELECT a.*,c.*
FROM accounts a
INNER JOIN customers c
ON a.customer_id=
c.customer_id;

SELECT c.name,a.account_type
FROM customers c
INNER JOIN accounts a
ON c.customer_id=
a.customer_id
WHERE a.balance > 20000;

SELECT c.name,
SUM(a.balance)AS
total_balance
FROM customers c
INNER JOIN accounts a
ON c.customer_id=
a.customer_id
GROUP BY c.customer_id,c.name;

SELECT c.name,a.balance
FROM customers c
INNER JOIN accounts a
ON c.customer_id=a.customer_id
ORDER BY a.balance DESC;

SELECT c.name,COUNT(a.account_id)AS account_count
FROM customers c
LEFT JOIN accounts a
ON c.customer_id=a.customer_id
GROUP BY c.customer_id,c.name;

SELECT *
FROM accounts
WHERE balance >
(SELECT AVG(balance)
FROM accounts);

SELECT *
FROM customers
WHERE customer_id IN
(SELECT customer_id FROM accounts );

SELECT *
FROM customers
WHERE customer_id NOT IN
(SELECT customer_id FROM accounts);

SELECT
FROMaccounts
WHERE balance =
(SELECT MAX (balance)
FROM accounts);

SELECT*
FROM customers
WHERE customer_id IN
(
    SELECT customer_id
    FROM accounts
    GROUP BY customer_id
    HAVING SUM(balance)>
    40000
);