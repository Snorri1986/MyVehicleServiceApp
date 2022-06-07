CREATE OR REPLACE FUNCTION c_subscriber(i_login character varying, i_password character varying, i_name character varying, i_surname character varying)
 RETURNS integer
 LANGUAGE plpgsql
AS $function$
declare 
v_result int4;
v_count int4;
begin
	
	-- if login already exists - return -1 --
	select count(*) 
	   into v_count
	from auth.subscribers s
	where s.login = i_login;

    if v_count > 0 then
       v_result = -1;
      return v_result;
    end if;
    
	-- return values: 0 - success, -1 - error
	insert into auth.subscribers(id,login,password,firstname,lastname,lastlogindate)
		values (nextval('auth.seq_subscribers_id'),i_login,i_password,i_name,i_surname,current_timestamp + interval '2 hours');
    
	-- check wheater of registrarion --
   select count(*) 
	   into v_count
	from auth.subscribers s
	where s.login = i_login;

  if v_count > 0 then 
     v_result = 0;
  else
     v_result = -1;
  end if;

  return v_result;
     end 
$function$
;
