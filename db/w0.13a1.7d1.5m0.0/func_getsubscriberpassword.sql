CREATE OR REPLACE FUNCTION getsubscriberpassword(i_login character varying)
 RETURNS character varying
 LANGUAGE plpgsql
AS $function$
declare
v_result_empty varchar := 'None';
v_result varchar;
	BEGIN
select s.password into v_result from auth.subscribers s
where s.login = i_login;

if(v_result is null) then
  return v_result_empty;
end if;

return v_result;
	END;
$function$
;