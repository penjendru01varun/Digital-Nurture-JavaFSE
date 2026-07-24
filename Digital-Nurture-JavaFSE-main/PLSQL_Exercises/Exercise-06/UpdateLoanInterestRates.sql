
SET SERVEROUTPUT ON;

DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID, InterestRate
        FROM Loans
        FOR UPDATE OF InterestRate;
        
    v_loan_id Loans.LoanID%TYPE;
    v_interest_rate Loans.InterestRate%TYPE;
    v_new_rate NUMBER;
BEGIN
    OPEN UpdateLoanInterestRates;
    
    LOOP
        FETCH UpdateLoanInterestRates INTO v_loan_id, v_interest_rate;
        EXIT WHEN UpdateLoanInterestRates%NOTFOUND;
        
        IF v_interest_rate > 10 THEN
            v_new_rate := v_interest_rate - 1;
        ELSE
            v_new_rate := v_interest_rate + 0.5;
        END IF;
        
        UPDATE Loans
        SET InterestRate = v_new_rate
        WHERE CURRENT OF UpdateLoanInterestRates;
        
        DBMS_OUTPUT.PUT_LINE('Loan ID ' || v_loan_id || ' updated to new interest rate: ' || v_new_rate || '%');
    END LOOP;
    
    CLOSE UpdateLoanInterestRates;
    COMMIT;
END;
/
