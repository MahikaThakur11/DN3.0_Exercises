DECLARE
    cust_id Customers.CustomerID%TYPE;
    cust_dob Customers.DOB%TYPE;
    cust_age NUMBER;
    loan_interest_rate Loans.InterestRate%TYPE;
BEGIN
    FOR customer_record IN (SELECT CustomerID, DOB FROM Customers) LOOP
        cust_id := customer_record.CustomerID;
        cust_dob := customer_record.DOB;
        
        cust_age := FLOOR(MONTHS_BETWEEN(SYSDATE, cust_dob) / 12);
        
        IF cust_age > 60 THEN
            FOR loan_record IN (SELECT LoanID, InterestRate FROM Loans WHERE CustomerID = cust_id) LOOP
                loan_interest_rate := loan_record.InterestRate;
                
                -- Apply 1% discount
                UPDATE Loans
                SET InterestRate = loan_interest_rate - 1
                WHERE LoanID = loan_record.LoanID;
            END LOOP;
        END IF;
    END LOOP;
    
    COMMIT;
END;
/
