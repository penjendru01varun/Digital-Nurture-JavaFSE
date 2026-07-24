
SET SERVEROUTPUT ON;

DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT c.Name, a.AccountID, t.TransactionDate, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE);
          
    v_name Customers.Name%TYPE;
    v_account_id Accounts.AccountID%TYPE;
    v_date Transactions.TransactionDate%TYPE;
    v_amount Transactions.Amount%TYPE;
    v_type Transactions.TransactionType%TYPE;
BEGIN
    OPEN GenerateMonthlyStatements;
    
    LOOP
        FETCH GenerateMonthlyStatements INTO v_name, v_account_id, v_date, v_amount, v_type;
        EXIT WHEN GenerateMonthlyStatements%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE('Customer: ' || v_name || ' | Account: ' || v_account_id || 
                             ' | Date: ' || TO_CHAR(v_date, 'YYYY-MM-DD') || 
                             ' | ' || v_type || ': $' || v_amount);
    END LOOP;
    
    CLOSE GenerateMonthlyStatements;
END;
/
