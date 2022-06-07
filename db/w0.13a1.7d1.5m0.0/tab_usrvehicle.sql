CREATE TABLE park.usrvehicle (
	id int4 NOT NULL, -- id by sequence
	subscribid int4 NOT NULL, -- FK of subscribers table
	vbrand varchar NOT NULL, -- name of vehicle's brand
	vmodel varchar NOT NULL, -- name of vehicle model
	vdateofmanuf date NOT NULL, -- date of manufacture
	vtotalmileage int4 NOT NULL, -- mileage of vehicle
	vlastservice date NULL, -- Last service check
	"type" varchar NOT NULL, -- type of a vehicle
	CONSTRAINT usrvehicle_fk FOREIGN KEY (subscribid) REFERENCES auth.subscribers(id)
);
COMMENT ON TABLE park.usrvehicle IS 'Table which stores subscriber''s vehicles';

-- Column comments

COMMENT ON COLUMN park.usrvehicle.id IS 'id by sequence';
COMMENT ON COLUMN park.usrvehicle.subscribid IS 'FK of subscribers table';
COMMENT ON COLUMN park.usrvehicle.vbrand IS 'name of vehicle''s brand';
COMMENT ON COLUMN park.usrvehicle.vmodel IS 'name of vehicle model';
COMMENT ON COLUMN park.usrvehicle.vdateofmanuf IS 'date of manufacture';
COMMENT ON COLUMN park.usrvehicle.vtotalmileage IS 'mileage of vehicle';
COMMENT ON COLUMN park.usrvehicle.vlastservice IS 'Last service check';
COMMENT ON COLUMN park.usrvehicle."type" IS 'type of a vehicle';