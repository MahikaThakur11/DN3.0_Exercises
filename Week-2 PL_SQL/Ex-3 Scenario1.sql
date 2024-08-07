CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    -- Update balances for savings accounts
    UPDATE Accounts
    SET Balance = Balance * 1.01
    WHERE AccountType = 'Savings';
    
    -- Commit changes
    COMMIT;
END ProcessMonthlyInterest;
/
