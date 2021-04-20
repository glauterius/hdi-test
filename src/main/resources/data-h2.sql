DROP TABLE IF EXISTS corretor;

CREATE TABLE corretor (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  code VARCHAR(250) NOT NULL,
  document VARCHAR(250) NOT NULL,
  create_date VARCHAR(10),
  commission_rate FLOAT,
  active int DEFAULT 0
);

INSERT INTO corretor (name, code, document, create_date, commission_rate, active) VALUES
  ('João Silva', '000010', '52225508003', '2020-05-16', 0.8, 1),
  ('Maria Santos', '000038', '31784583014', '2020-02-06', 1, 0);