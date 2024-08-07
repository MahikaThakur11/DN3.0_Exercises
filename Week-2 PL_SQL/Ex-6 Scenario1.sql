DECLARE
    CURSOR transaction_cursor IS
        SELECT c.CustomerID, c.Name, t.TransactionDate, t.Amount, t.TransactionType
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        JOIN Customers c ON a.CustomerID = c.CustomerID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE);

    v_customer_id Customers.CustomerID%TYPE;
    v_name Customers.Name%TYPE;
    v_transaction_date Transactions.TransactionDate%TYPE;
    v_amount Transactions.Amount%TYPE;
    v_transaction_type Transactions.TransactionType%TYPE;
BEGIN
    OPEN transaction_cursor;
    LOOP
        FETCH transaction_cursor INTO v_customer_id, v_name, v_transaction_date, v_amount, v_transaction_type;
        EXIT WHEN transaction_cursor%NOTFOUND;
        
        -- Print the statement (or use another method to generate the report)
        DBMS_OUTPUT.PUT_LINE('Customer ID: ' || v_customer_id ||
                             ', Name: ' || v_name ||
                             ', Date: ' || TO_CHAR(v_transaction_date, 'YYYY-MM-DD') ||
                             ', Amount: ' || v_amount ||
                             ', Type: ' || v_transaction_type);
    END LOOP;
    CLOSE transaction_cursor;
END;
/
