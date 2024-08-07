DECLARE
    balance Customers.Balance%TYPE;
BEGIN
    FOR customer_record IN (SELECT CustomerID, Balance FROM Customers) LOOP
        balance := customer_record.Balance;
        
        IF balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'  -- Ensure there is an IsVIP column in the Customers table
            WHERE CustomerID = customer_record.CustomerID;
        END IF;
    END LOOP;
    
    COMMIT;
END;
/
