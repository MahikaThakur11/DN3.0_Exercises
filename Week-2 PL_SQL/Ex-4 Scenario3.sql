CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_account_id IN NUMBER,
    p_amount IN NUMBER
) RETURN BOOLEAN AS
    v_balance Accounts.Balance%TYPE;
BEGIN
    -- Retrieve account balance
    SELECT Balance INTO v_balance FROM Accounts WHERE AccountID = p_account_id;
    
    -- Check if balance is sufficient
    RETURN v_balance >= p_amount;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        -- Handle case where account does not exist
        RETURN FALSE;
END HasSufficientBalance;
/
