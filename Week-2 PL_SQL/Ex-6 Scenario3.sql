DECLARE
    CURSOR loan_cursor IS
        SELECT LoanID, InterestRate
        FROM Loans;

    v_loan_id Loans.LoanID%TYPE;
    v_current_rate Loans.InterestRate%TYPE;
    v_new_rate NUMBER;
BEGIN
    OPEN loan_cursor;
    LOOP
        FETCH loan_cursor INTO v_loan_id, v_current_rate;
        EXIT WHEN loan_cursor%NOTFOUND;
        
        v_new_rate := v_current_rate + 0.5; -- Example increase of 0.5%

        UPDATE Loans
        SET InterestRate = v_new_rate
        WHERE LoanID = v_loan_id;
    END LOOP;
    CLOSE loan_cursor;
    
    COMMIT;
END;
/
