CREATE TABLE auth.subscribers (
	id bigint NOT NULL,
	login varchar NOT NULL,
	"password" varchar NOT NULL,
	firstname varchar NULL,
	lastname varchar NULL,
	"type" char NOT NULL DEFAULT 'U',
	lastlogindate timestamp NULL,
	CONSTRAINT subscribers_pk PRIMARY KEY (id)
);
CREATE UNIQUE INDEX subscribers_login_idx ON auth.subscribers (login);
COMMENT ON TABLE auth.subscribers IS 'Table of users';

-- Column comments

COMMENT ON COLUMN auth.subscribers.id IS 'UserID in the table';
COMMENT ON COLUMN auth.subscribers.login IS 'login of subscribers';
COMMENT ON COLUMN auth.subscribers."password" IS 'password of subscribers';
COMMENT ON COLUMN auth.subscribers.firstname IS 'firstname of subscribers';
COMMENT ON COLUMN auth.subscribers.lastname IS 'lastname of subscribers';
COMMENT ON COLUMN auth.subscribers."type" IS 'permission by default';
COMMENT ON COLUMN auth.subscribers.lastlogindate IS 'last succesfully authorization';
