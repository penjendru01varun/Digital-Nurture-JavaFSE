
SET SERVEROUTPUT ON;

DECLARE
    v_annual_fee CONSTANT NUMBER := 50; -- $50 fee
    
    CURSOR ApplyAnnualFee IS
        SELECT AccountID, Balance
        FROM Accounts
        FOR UPDATE OF Balance;
        
    v_account_id Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;
BEGIN
    OPEN ApplyAnnualFee;
    
    LOOP
        FETCH ApplyAnnualFee INTO v_account_id, v_balance;
        EXIT WHEN ApplyAnnualFee%NOTFOUND;
        
        UPDATE Accounts
        SET Balance = Balance - v_annual_fee
        WHERE CURRENT OF ApplyAnnualFee;
        
        DBMS_OUTPUT.PUT_LINE('Deducted $' || v_annual_fee || ' fee from Account ID: ' || v_account_id);
    END LOOP;
    
    CLOSE ApplyAnnualFee;
    COMMIT;
END;
/
