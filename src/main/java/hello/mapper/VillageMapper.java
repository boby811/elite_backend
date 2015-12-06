package hello.mapper;

import hello.pojo.Village;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface VillageMapper {
	
	@Insert("INSERT into village(id,name,district) VALUES(#{vid}, #{villageName}, #{district})")
	void insertVillage(Village village);
	
	@Select("SELECT * from village WHERE id = #{id}")
	Village selectVillage(int id);
	
	@Select("SELECT * from village")
	List<Village> selectAllVillage();
	
	@Update("UPDATE village SET name=#{villageName}, district =#{district} WHERE id =#{vid}")
	void updateVillage(Village village);
	
	@Delete("DELETE FROM village WHERE id =#{id}")
	void deleteVillage(int id);
}