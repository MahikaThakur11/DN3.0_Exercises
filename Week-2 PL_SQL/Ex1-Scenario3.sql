DECLARE
    CURSOR loan_cursor IS
        SELECT l.LoanID, c.CustomerID, c.Name, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;

    customer_name Customers.Name%TYPE;
    end_date Loans.EndDate%TYPE;
BEGIN
    FOR loan_record IN loan_cursor LOOP
        customer_name := loan_record.Name;
        end_date := loan_record.EndDate;
        
        -- Print reminder message
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || loan_record.LoanID || ' for customer ' || customer_name || ' is due on ' || TO_CHAR(end_date, 'YYYY-MM-DD') || '.');
    END LOOP;
END;
/

