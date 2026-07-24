
ALTER TABLE Customers ADD IsVIP VARCHAR2(5) DEFAULT 'FALSE';

SET SERVEROUTPUT ON;

BEGIN
    FOR customer_rec IN (SELECT CustomerID, Balance FROM Customers) LOOP
        IF customer_rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = customer_rec.CustomerID;
            
            DBMS_OUTPUT.PUT_LINE('Promoted CustomerID: ' || customer_rec.CustomerID || ' to VIP status.');
        END IF;
    END LOOP;
    
    COMMIT;
END;
/
