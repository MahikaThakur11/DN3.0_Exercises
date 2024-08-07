CREATE TABLE AUDITLOG(
AuditID NUMBER PRIMARY KEY,
TransactionID NUMBER,
ActionTime DATE,
ActionType VARCHAR2(10),
Amount NUMBER);

CREATE SEQUENCE AuditLog_seq START ITH 1 INCREMENT BY 1;


CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
	INSERT INTO AuditLog(AuditID,TransactionID,ActionTime,ActionType,Amount)
	VALUES(AuditLog_seq.NEXTVAL, :NEW.TransactionID,'INSERT',:NEW.Amount);
END LogTransaction
/
 