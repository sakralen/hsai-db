SELECT @@transaction_ISOLATION;
SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
SELECT @@transaction_ISOLATION;

SELECT * FROM miniature WHERE id = 70;

-- root:
START TRANSACTION;
UPDATE miniature SET wounds = wounds + 10 WHERE id = 70;

-- parallel:
START TRANSACTION;
UPDATE miniature SET wounds = wounds + 100 WHERE id = 70;
-- Возникновение блокировки до завершения 
-- транзакции пользователем root.

-- root:
COMMIT;
-- Снятие блокировки для пользователя parallel, успешное выполнение запроса.

-- parallel:
COMMIT;

SELECT * FROM miniature WHERE id = 70;
