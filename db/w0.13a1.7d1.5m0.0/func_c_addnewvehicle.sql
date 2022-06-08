CREATE OR REPLACE FUNCTION c_addnewvehicle(i_usrname character varying, i_brand character varying, i_model character varying, 
                           i_dmanuf integer, i_tmilleage integer, i_lastservice date, i_type character varying, i_statenumber character varying)
 RETURNS integer
 LANGUAGE plpgsql
AS $function$
declare 
v_result int4;
v_subcriber_subid int8;
v_count int4;
begin
	
	select s.id into v_subcriber_subid from subscribers s 
	where s.login = i_usrname;
	
	-- return values: 0 - success, -1 - error
	insert into usrvehicle(id,subscribid,vbrand,vmodel,vdateofmanuf,vtotalmileage,vlastservice,"type",statenumber)
		values (nextval('park.seq_vehicle_id'),v_subcriber_subid,i_brand,i_model,i_dmanuf,i_tmilleage,
	            i_lastservice,i_type,i_statenumber);
    
	-- check wheater of registrarion --
   select count(*) 
	   into v_count
	from usrvehicle p
	where p.subscribid  = v_subcriber_subid;

  if v_count > 0 then 
     v_result = 0;
  else
     v_result = -1;
  end if;

  return v_result;	  

END;
$function$
;