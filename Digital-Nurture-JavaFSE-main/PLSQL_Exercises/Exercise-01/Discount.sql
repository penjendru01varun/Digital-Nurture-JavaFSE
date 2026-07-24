
SET SERVEROUTPUT ON;

DECLARE
    v_age NUMBER;
BEGIN
    FOR customer_rec IN (SELECT c.CustomerID, c.DOB FROM Customers c) LOOP
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, customer_rec.DOB) / 12);
        
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = customer_rec.CustomerID;
            
            DBMS_OUTPUT.PUT_LINE('Applied 1% interest discount to CustomerID: ' || customer_rec.CustomerID || ' (Age: ' || v_age || ')');
        END IF;
    END LOOP;
    
    COMMIT;
END;
/
