#sql("test1")
	select * from blog where id = #para(0)
#end


#sql("test2")
	select * from blog where title like concat("%",#para(title),"%")
#end

#sql("test3")
		
#end