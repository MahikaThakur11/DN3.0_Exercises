CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) AS
    v_from_balance Accounts.Balance%TYPE;
    v_to_balance Accounts.Balance%TYPE;
BEGIN
    
    BEGIN
        
        SELECT Balance INTO v_from_balance FROM Accounts WHERE AccountID = p_from_account_id FOR UPDATE;
        SELECT Balance INTO v_to_balance FROM Accounts WHERE AccountID = p_to_account_id FOR UPDATE;

        
        IF v_from_balance < p_amount THEN
            RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in the source account.');
        END IF;

        -- Update balances
        UPDATE Accounts
        SET Balance = v_from_balance - p_amount
        WHERE AccountID = p_from_account_id;

        UPDATE Accounts
        SET Balance = v_to_balance + p_amount
        WHERE AccountID = p_to_account_id;

        -- Commit transaction
        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            -- Rollback transaction in case of error
            ROLLBACK;
            -- Log the error message
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END;
END SafeTransferFunds;
/
