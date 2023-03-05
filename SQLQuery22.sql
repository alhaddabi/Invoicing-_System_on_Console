CREATE TABLE Customers (
  Customer_Id INT PRIMARY KEY IDENTITY,
  Customer_Full_Name VARCHAR(50),
  Customer_Phone_Number INT
);

CREATE TABLE Invoices (
  Invoice_Id INT PRIMARY KEY ,
  Customer_Id INT,
  Invoice_Date DATE,
  Number_Of_Items INT,
  total_Amount DECIMAL(10,2),
  paid_Amount DECIMAL(10,2),
  totkal_Balance DECIMAL(10,2),
  FOREIGN KEY (Customer_Id) REFERENCES Customers(Customer_Id)
);

CREATE TABLE InvoiceItems (
  InvoiceItem_Id INT PRIMARY KEY ,
  Invoice_Id INT,
  Item_Id INT,
  Item_Name VARCHAR(50),
  UnitPrice DECIMAL(10,2),
  Quantity INT,
  Qty_Amount DECIMAL(10,2),
  FOREIGN KEY (Invoice_Id) REFERENCES Invoices(Invoice_Id)
);

drop table Customers ;
drop table Invoices ;
drop table InvoiceItems ;




