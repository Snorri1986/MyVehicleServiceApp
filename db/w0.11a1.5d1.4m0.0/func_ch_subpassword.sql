CREATE OR REPLACE FUNCTION auth.ch_subpassword(i_login character varying, i_oldpassword character varying, i_newpassword character varying)
 RETURNS integer
 LANGUAGE plpgsql
AS $function$
declare 
v_password_before varchar;
v_password_after varchar;
v_subcriber_id int8;
v_password_change_count int4 = 0;
v_result int4;
	BEGIN
select id,password 
into v_subcriber_id,v_password_before 
from auth.subscribers 
where login = i_login;

update auth.subscribers  
       set password = i_newpassword
where login = i_login
and password = i_oldpassword;

select password  
into v_password_after 
from auth.subscribers 
where login = i_login;

if v_password_after <> v_password_before
   then v_result = 0;

select password into v_password_change_count 
from auth.subscribersmodes
where subid = v_subcriber_id;
  
if v_password_change_count > 0 then
 update auth.subscribersmodes 
    set subid = v_subcriber_id,
        password = password + 1,
        passwordlasttime = current_timestamp
    where subid = v_subcriber_id;
else 
  insert into auth.subscribersmodes(id,subid,password,firstname,lastname,passwordlasttime,fnamelasttime,lnamelasttime)
		values (nextval('auth.seq_subscribersmodes_id'),v_subcriber_id,1,0,0,current_timestamp,null,null);
end if;
else 
   v_result = -1;
end if;
return v_result;
	END;
$function$
;