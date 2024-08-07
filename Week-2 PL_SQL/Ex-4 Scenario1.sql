CREATE OR REPLACE FUNCTION CalculateAge (
    pdob IN DATE
) RETURN NUMBER AS
    vage NUMBER;
BEGIN
    -- Calculate age
    vage := FLOOR(MONTHS_BETWEEN(SYSDATE, pdob) / 12);
    RETURN vage;
END CalculateAge;
/
