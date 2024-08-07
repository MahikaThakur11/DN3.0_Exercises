CREATE OR REPLACE PROCEDURE TransferFunds (
    pfrom_account_id IN NUMBER,
    pto_account_id IN NUMBER,
    pamount IN NUMBER
) AS
    vfrom_balance Accounts.Balance%TYPE;
    vto_balance Accounts.Balance%TYPE;
BEGIN
    -- Start transaction
    BEGIN
        -- Lock the accounts to prevent concurrent modifications
        SELECT Balance INTO vfrom_balance FROM Accounts WHERE AccountID = pfrom_account_id FOR UPDATE;
        SELECT Balance INTO vto_balance FROM Accounts WHERE AccountID = pto_account_id FOR UPDATE;

        -- Check for sufficient funds
        IF vfrom_balance < pamount THEN
            RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in the source account.');
        END IF;

        -- Update balances
        UPDATE Accounts
        SET Balance = vfrom_balance - pamount
        WHERE AccountID = pfrom_account_id;

        UPDATE Accounts
        SET Balance = vto_balance + pamount
        WHERE AccountID = pto_account_id;

        -- Commit transaction
        COMMIT;
    EXCEPTION
        WHEN OTHERS THEN
            -- Rollback transaction in case of error
            ROLLBACK;
            -- Log the error message
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
    END;
END TransferFunds;
/
