INSERT INTO users (id, username, email, password, full_name, created_at, updated_at)
VALUES
  (1, 'john', 'john@example.com', 'password123', 'John Doe', '2022-01-01 00:00:00','2022-01-01 00:00:00'),
  (2, 'jane', 'jane@example.com', 'password456', 'Jane Smith', '2022-01-02 00:00:00','2022-01-01 00:00:00'),
  (3, 'bob', 'bob@example.com', 'password789', 'Bob Johnson', '2022-01-03 00:00:00','2022-01-01 00:00:00');

INSERT INTO accounts (id, name, type, balance, created_at, updated_at, owner_id)
VALUES (
   1,
  'Savings Account',
  'SAVINGS',
  5000,
  '2023-04-11 10:00:00',
  '2023-04-11 10:00:00',
  1
);


