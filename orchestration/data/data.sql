INSERT INTO brand (name, code) VALUES ('Facebook', 'FB');
INSERT INTO brand (name, code) VALUES ('Google', 'GOO');
INSERT INTO brand (name, code) VALUES ('Apple', 'APL');
INSERT INTO brand (name, code) VALUES ('Microsoft', 'MSFT');

INSERT INTO location(company_code, name, city)
VALUES('FB','J P Nagar','Bangalore'),
      ('FB','White Fields','Bangalore'),
      ('GOO','Faridabad','Delhi'),
      ('GOO','Noida','Delhi'),
      ('GOO','Gurgaon','Delhi'),
      ('APL','Banjara Hills','Hyderabad'),
      ('APL','Jubilee Hills','Hyderabad'),
      ('MSFT','Hirandandani','Mumbai');

INSERT INTO employee(name, company_code)
VALUES('Mark Zuckerberg','FB'),
      ('Sundar Pichai','GOO'),
      ('Tim Cook','APL'),
      ('Satya Nadala','MSFT');