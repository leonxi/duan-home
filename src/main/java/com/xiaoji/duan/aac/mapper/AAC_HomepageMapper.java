package com.xiaoji.duan.aac.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xiaoji.duan.aac.entity.AAC_Homepage;


@Mapper
public interface AAC_HomepageMapper {

	@Select("SELECT UNIONID, HOME_SUBDOMAIN, HOME_PREFIX, HOME_PATH, CREATE_TIME FROM AAC_Homepage WHERE UNIONID = #{unionId} OR HOME_SUBDOMAIN = #{subdomain}")
	@Results({
		@Result(column="UNIONID", property="unionId"),
		@Result(column="HOME_SUBDOMAIN", property="homeSubdomain"),
		@Result(column="HOME_PREFIX", property="homePrefix"),
		@Result(column="HOME_PATH", property="homePath"),
		@Result(column="CREATE_TIME", property="createTime"),
	})
	public AAC_Homepage findByPK(@Param("unionId") String uniondId, @Param("subdomain") String subdomain);

	@Insert("INSERT INTO AAC_Homepage (UNIONID, HOME_SUBDOMAIN, HOME_PREFIX, HOME_PATH, CREATE_TIME) "
			+ "VALUES(#{unionId}, #{homeSubdomain}, #{homePrefix}, #{homePath}, Now())")
	public int insert(AAC_Homepage menu);
	
	@Update("UPDATE AAC_Homepage SET HOME_PREFIX = #{homePrefix}, HOME_PATH = #{homePath} WHERE UNIONID = #{unionId}")
	public int update(AAC_Homepage menu);
	
	@Delete("DELETE FROM AAC_Homepage WHERE UNIONID = #{unionId}")
	public int delete(@Param("unionId") String unionId);
}
