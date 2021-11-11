CREATE TABLE auth.subscribersmodes (
	id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
	subid bigint NOT NULL,
	login int8 NULL DEFAULT 0,
	"password" int8 NULL DEFAULT 0,
	firstname int8 NULL DEFAULT 0,
	lastname int8 NULL DEFAULT 0,
	loginlasttime timestamp NULL,
	passwordlasttime timestamp NULL,
	fnamelasttime timestamp NULL,
	lnamelasttime timestamp NULL,
	CONSTRAINT subscribersmodes_pk PRIMARY KEY (id),
	CONSTRAINT subscribersmodes_fk FOREIGN KEY (subid) REFERENCES auth.subscribers(id) ON DELETE CASCADE
);
COMMENT ON TABLE auth.subscribersmodes IS 'Table for save changing in subscribers table';

-- Column comments

COMMENT ON COLUMN auth.subscribersmodes.id IS 'primary key';
COMMENT ON COLUMN auth.subscribersmodes.subid IS 'foreign key of subscribers table';
COMMENT ON COLUMN auth.subscribersmodes.login IS 'counter of changing login';
COMMENT ON COLUMN auth.subscribersmodes."password" IS 'counter of changing password';
COMMENT ON COLUMN auth.subscribersmodes.firstname IS 'counter of change firstname';
COMMENT ON COLUMN auth.subscribersmodes.lastname IS 'counter of change lastname';
COMMENT ON COLUMN auth.subscribersmodes.loginlasttime IS 'time mark for last login change';
COMMENT ON COLUMN auth.subscribersmodes.passwordlasttime IS 'time mark of last change password';
COMMENT ON COLUMN auth.subscribersmodes.fnamelasttime IS 'time mark of last changing firstname';
COMMENT ON COLUMN auth.subscribersmodes.lnamelasttime IS 'time mark of last changing lastname';