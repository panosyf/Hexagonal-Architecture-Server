DROP TABLE IF EXISTS "transaction";
DROP TABLE IF EXISTS "account";

CREATE TABLE "account" (
   id VARCHAR,
   name VARCHAR(64) NOT NULL,
   balance DECIMAL(19,2) NOT NULL,
   created_at TIMESTAMP NOT NULL,
   updated_at TIMESTAMP,
   PRIMARY KEY (id)
);

CREATE TABLE "transaction" (
   id VARCHAR,
   type VARCHAR(64) NOT NULL,
   amount DECIMAL(19,2) NOT NULL,
   description VARCHAR DEFAULT NULL,
   debtor_account_id VARCHAR,
   beneficiary_account_id VARCHAR,
   status VARCHAR(64) NOT NULL,
   created_at TIMESTAMP NOT NULL,
   updated_at TIMESTAMP,
   PRIMARY KEY (id),
   CONSTRAINT FK_DebtorAccountTransaction FOREIGN KEY (debtor_account_id) REFERENCES "account"(id) ON DELETE CASCADE,
   CONSTRAINT FK_BeneficiaryAccountTransaction FOREIGN KEY (beneficiary_account_id) REFERENCES "account"(id) ON DELETE CASCADE
);