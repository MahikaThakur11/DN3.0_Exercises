CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_customer_id IN NUMBER,
    p_name IN VARCHAR2,
    p_dob IN DATE,
    p_balance IN NUMBER
) AS
BEGIN
    -- Start transaction
    BEGIN
        -- Attempt to insert new customer
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);

        -- Commit transaction
        COMMIT;
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            -- Handle case where customer ID already exists
            DBMS_OUTPUT.PUT_LINE('Error: Customer ID ' || p_customer_id || ' already exists.');
            ROLLBACK;
        WHEN OTHERS THEN
            -- Handle other errors
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            ROLLBACK;
    END;
END AddNewCustomer;
/
