delimiter $$
create procedure update_PlanType(in p_uid int, in p_id int,
                                                         in p_newType int ,in p_newIndex int,
                                                         in p_oldType int , in p_oldIndex int)
begin
    
    create table tmp as SELECT id FROM pig_video.plan  
        where uid = p_uid and plan_type = p_newType and plan_index >= p_newIndex   order by plan_index;
    update plan set plan_index=plan_index +1  where id in (select id from tmp);
    drop table tmp;

    create table tmp as SELECT id FROM pig_video.plan   
        where uid = p_uid  and plan_type = p_oldType and plan_index > p_oldIndex   order by plan_index;
    update plan set plan_index=plan_index -1  where id in (select id from tmp);
    drop table tmp;

    update plan set plan_type = p_newType where id  = p_id;
    update plan set plan_index = p_newIndex where id  = p_id;
    
end$$
delimiter ;


select * from  pig_video.plan  where uid = 1 and plan_type = 0 and plan_index >= 1   order by plan_index;