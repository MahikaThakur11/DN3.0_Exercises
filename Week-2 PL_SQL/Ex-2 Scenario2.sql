CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_employee_id IN NUMBER,
    p_percentage IN NUMBER
) AS
    v_current_salary Employees.Salary%TYPE;
BEGIN
    -- Start transaction
    BEGIN
        -- Retrieve current salary
        SELECT Salary INTO v_current_salary FROM Employees WHERE EmployeeID = p_employee_id;

        -- Update salary
        UPDATE Employees
        SET Salary = v_current_salary * (1 + p_percentage / 100)
        WHERE EmployeeID = p_employee_id;

        -- Commit transaction
        COMMIT;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            -- Handle case where employee ID does not exist
            DBMS_OUTPUT.PUT_LINE('Error: Employee ID ' || p_employee_id || ' does not exist.');
            ROLLBACK;
        WHEN OTHERS THEN
            -- Handle other errors
            DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
            ROLLBACK;
    END;
END UpdateSalary;
/
