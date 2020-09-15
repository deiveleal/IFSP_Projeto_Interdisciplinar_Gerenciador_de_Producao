CREATE VIEW ingredientes_saboreskombucha AS
SELECT * FROM saborkombucha;

CREATE VIEW qtd_base_sabor AS 
    SELECT     chaBase,
            prePreparoQuantCha,
            prePreparoQuantAgua
    FROM saborkombucha;