DECLARE
    CURSOR account_cursor IS
        SELECT AccountID, Balance
        FROM Accounts;

    v_account_id Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;
    v_annual_fee CONSTANT NUMBER := 50; -- Example fee amount
BEGIN
    OPEN account_cursor;
    LOOP
        FETCH account_cursor INTO v_account_id, v_balance;
        EXIT WHEN account_cursor%NOTFOUND;
        
        -- Deduct annual maintenance fee
        UPDATE Accounts
        SET Balance = v_balance - v_annual_fee
        WHERE AccountID = v_account_id;

        -- Check if balance is negative
        IF (v_balance - v_annual_fee) < 0 THEN
            DBMS_OUTPUT.PUT_LINE('Warning: Account ' || v_account_id || ' has insufficient funds after fee deduction.');
        END IF;
    END LOOP;
    CLOSE account_cursor;
    
    -- Commit changes
    COMMIT;
END;
/
