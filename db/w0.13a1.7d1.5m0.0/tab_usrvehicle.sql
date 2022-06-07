CREATE TABLE usrvehicle (
	id int4 NOT NULL, -- id by sequence
	subscribid int4 NOT NULL, -- FK of subscribers table
	vbrand varchar NOT NULL, -- name of vehicle's brand
	vmodel varchar NOT NULL, -- name of vehicle model
	vdateofmanuf date NOT NULL, -- date of manufacture
	vtotalmileage int4 NOT NULL, -- mileage of vehicle
	vlastservice date NULL, -- Last service check
	"type" varchar NOT NULL, -- type of a vehicle
	statenumber varchar NOT NULL, -- unique number of vehicle in state
	CONSTRAINT usrvehicle_pk PRIMARY KEY (id),
	CONSTRAINT usrvehicle_fk FOREIGN KEY (subscribid) REFERENCES subscribers(id)
);
CREATE UNIQUE INDEX usrvehicle_statenumber_idx ON usrvehicle USING btree (statenumber);
COMMENT ON TABLE usrvehicle IS 'Table which stores subscriber''s vehicles';

-- Column comments

COMMENT ON COLUMN usrvehicle.id IS 'id by sequence';
COMMENT ON COLUMN usrvehicle.subscribid IS 'FK of subscribers table';
COMMENT ON COLUMN usrvehicle.vbrand IS 'name of vehicle''s brand';
COMMENT ON COLUMN usrvehicle.vmodel IS 'name of vehicle model';
COMMENT ON COLUMN usrvehicle.vdateofmanuf IS 'date of manufacture';
COMMENT ON COLUMN usrvehicle.vtotalmileage IS 'mileage of vehicle';
COMMENT ON COLUMN usrvehicle.vlastservice IS 'Last service check';
COMMENT ON COLUMN usrvehicle."type" IS 'type of a vehicle';
COMMENT ON COLUMN usrvehicle.statenumber IS 'unique number of vehicle in state';