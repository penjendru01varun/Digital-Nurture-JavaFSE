
CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_employee_id NUMBER,
    p_percentage NUMBER
) AS
    v_employee_id NUMBER;
BEGIN
    SELECT EmployeeID INTO v_employee_id 
    FROM Employees 
    WHERE EmployeeID = p_employee_id;

    UPDATE Employees
    SET Salary = Salary + (Salary * (p_percentage / 100))
    WHERE EmployeeID = p_employee_id;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Successfully increased salary for Employee ID: ' || p_employee_id || ' by ' || p_percentage || '%');

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Employee with ID ' || p_employee_id || ' does not exist. Cannot update salary.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('An unexpected error occurred: ' || SQLERRM);
END UpdateSalary;
/
