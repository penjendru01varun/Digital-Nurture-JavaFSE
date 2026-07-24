
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loan_amount NUMBER,
    p_annual_interest_rate NUMBER,
    p_duration_years NUMBER
) RETURN NUMBER IS
    v_monthly_rate NUMBER;
    v_total_months NUMBER;
    v_installment NUMBER;
BEGIN
    IF p_annual_interest_rate = 0 THEN
        RETURN p_loan_amount / (p_duration_years * 12);
    END IF;

    v_monthly_rate := (p_annual_interest_rate / 100) / 12;
    v_total_months := p_duration_years * 12;

    v_installment := p_loan_amount * v_monthly_rate * POWER(1 + v_monthly_rate, v_total_months) / (POWER(1 + v_monthly_rate, v_total_months) - 1);
    
    RETURN ROUND(v_installment, 2);
END CalculateMonthlyInstallment;
/
