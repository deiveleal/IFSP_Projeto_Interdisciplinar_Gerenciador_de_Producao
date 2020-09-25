-- Criação de usuarios do banco + privilegios

CREATE USER IF NOT EXISTS 'desenvolvedor'@'localhost'
	IDENTIFIED BY 'dev12345'
	PASSWORD EXPIRE INTERVAL 90 DAY;
    
CREATE USER IF NOT EXISTS 'admdb'@'localhost'
	IDENTIFIED BY 'mandb123'
    PASSWORD EXPIRE INTERVAL 365 DAY;
    
CREATE USER IF NOT EXISTS 'userdb'@'localhost'
	IDENTIFIED BY 'user1234'
    PASSWORD EXPIRE INTERVAL 365 DAY;
    
GRANT ALTER, DELETE, INSERT, SELECT, UPDATE
	ON tribos_kombucha.*
    TO 'desenvolvedor'@'localhost' WITH GRANT OPTION;
    
GRANT ALL
	ON tribos_kombucha.*
    TO 'admdb'@'localhost' WITH GRANT OPTION;
    
GRANT DELETE, INSERT, SELECT, UPDATE
	ON tribos_kombucha.*
    TO 'userdb'@'localhost';
    
FLUSH PRIVILEGES;
    
    
    
    
    
    
    
    
    