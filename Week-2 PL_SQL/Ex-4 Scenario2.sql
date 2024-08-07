CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loan_amount IN NUMBER,
    p_interest_rate IN NUMBER,
    p_loan_duration IN NUMBER
) RETURN NUMBER AS
    v_monthly_installment NUMBER;
    v_monthly_rate NUMBER;
    v_num_payments NUMBER;
BEGIN
    -- Convert annual interest rate to monthly and calculate number of payments
    v_monthly_rate := p_interest_rate / 12 / 100;
    v_num_payments := p_loan_duration * 12;
    
    -- Calculate monthly installment using the formula
    v_monthly_installment := p_loan_amount * (v_monthly_rate * POWER(1 + v_monthly_rate, v_num_payments)) /
                              (POWER(1 + v_monthly_rate, v_num_payments) - 1);
    
    RETURN v_monthly_installment;
END CalculateMonthlyInstallment;
/
