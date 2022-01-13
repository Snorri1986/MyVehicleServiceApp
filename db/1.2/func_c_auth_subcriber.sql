CREATE OR REPLACE FUNCTION auth.c_auth_subcriber(i_login character varying, i_password character varying)
 RETURNS integer
 LANGUAGE plpgsql
AS $function$
declare 
v_login varchar;
v_password varchar;
v_result int4;
begin
	
	-- if input parameters are empty --
	if ((i_login is null) or (i_password is null)) 
	   or (i_login is null and i_password is null) then 
	v_result = -1;
    return v_result;
    end if;
	
	
	select login,password 
	   into v_login,v_password
	from auth.subscribers s
	where s.login = i_login
	and s.password = i_password;

   -- find subscriber --  
if (v_login = i_login) and (v_password = i_password) then 
     v_result = 0;
   -- update lastlogindate in subscribers table --
  update auth.subscribers set lastlogindate = current_timestamp + interval '2 hours'
     where login = i_login;
  else
     v_result = -1;
  end if;

  return v_result;
     end 
$function$
;