DROP TABLE IF EXISTS TblExpenses;

CREATE TABLE TblExpenses (
                             id INT AUTO_INCREMENT  PRIMARY KEY,
                             expenseName VARCHAR(250) NOT NULL,
                             expenseAmount DOUBLE NOT NULL,
                             description VARCHAR(250) NOT NULL,
                             date DATE DEFAULT NULL
);


INSERT INTO TblExpenses (expenseName, expenseAmount, description,date) VALUES
  ('Petrol',500.00 , 'Petrol for Bike','2015-09-04' ),
  ('Food',5050.21 , 'Birthday Treat','2017-12-30'),
  ('Grocessary',923.45 , 'Pooja supermarket','2013-02-12' ),
  ('Apparals',2500.00 , 'Casula dresses','2019-07-23' ),
  ('Shopping',5000.00 , 'Festival Shopping','2019-12-09' ),
  ('Travel',2000.00 , 'Chennai to Bangalore','2019-12-07' );
