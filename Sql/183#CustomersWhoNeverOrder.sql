-- Suppose that a website contains two tables, the Customers table and the Orders table. Write a SQL query to find all customers who never order anything.

-- Table: Customers.

-- +----+-------+
-- | Id | Name  |
-- +----+-------+
-- | 1  | Joe   |
-- | 2  | Henry |
-- | 3  | Sam   |
-- | 4  | Max   |
-- +----+-------+
-- Table: Orders.

-- +----+------------+
-- | Id | CustomerId |
-- +----+------------+
-- | 1  | 3          |
-- | 2  | 1          |
-- +----+------------+
SELECT A.Name as Customers from Customers A
LEFT JOIN Orders B on  A.Id = B.CustomerId
WHERE B.CustomerId is NULL

SELECT A.Name as Customers from Customers A
WHERE NOT EXISTS (SELECT 1 FROM Orders B WHERE A.Id = B.CustomerId)

select name as Customers
from Customers
where Id not in (
    select CustomerId
    from Orders
)