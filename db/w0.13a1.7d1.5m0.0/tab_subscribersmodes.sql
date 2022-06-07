CREATE TABLE subscribersmodes (
	id bigint NOT NULL,
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
	CONSTRAINT subscribersmodes_fk FOREIGN KEY (subid) REFERENCES subscribers(id) ON DELETE CASCADE
);
COMMENT ON TABLE auth.subscribersmodes IS 'Table for save changing in subscribers table';

-- Column comments

COMMENT ON COLUMN subscribersmodes.id IS 'primary key';
COMMENT ON COLUMN subscribersmodes.subid IS 'foreign key of subscribers table';
COMMENT ON COLUMN subscribersmodes.login IS 'counter of changing login';
COMMENT ON COLUMN subscribersmodes."password" IS 'counter of changing password';
COMMENT ON COLUMN subscribersmodes.firstname IS 'counter of change firstname';
COMMENT ON COLUMN subscribersmodes.lastname IS 'counter of change lastname';
COMMENT ON COLUMN subscribersmodes.loginlasttime IS 'time mark for last login change';
COMMENT ON COLUMN subscribersmodes.passwordlasttime IS 'time mark of last change password';
COMMENT ON COLUMN subscribersmodes.fnamelasttime IS 'time mark of last changing firstname';
COMMENT ON COLUMN subscribersmodes.lnamelasttime IS 'time mark of last changing lastname';
