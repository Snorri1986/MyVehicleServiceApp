CREATE TABLE subscribers (
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
COMMENT ON TABLE subscribers IS 'Table of users';

-- Column comments

COMMENT ON COLUMN subscribers.id IS 'UserID in the table';
COMMENT ON COLUMN subscribers.login IS 'login of subscribers';
COMMENT ON COLUMN subscribers."password" IS 'password of subscribers';
COMMENT ON COLUMN subscribers.firstname IS 'firstname of subscribers';
COMMENT ON COLUMN subscribers.lastname IS 'lastname of subscribers';
COMMENT ON COLUMN subscribers."type" IS 'permission by default';
COMMENT ON COLUMN subscribers.lastlogindate IS 'last succesfully authorization';
