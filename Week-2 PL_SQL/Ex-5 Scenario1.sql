CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON CUSTOMERS
FOR EACH ROW
BEGIN
	:NEW.LastModified:=SYSDATE;
END UpdateCustomerLastModified
/
	
