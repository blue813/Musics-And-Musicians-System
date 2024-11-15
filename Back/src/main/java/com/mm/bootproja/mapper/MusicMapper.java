package com.mm.bootproja.mapper;

import com.mm.bootproja.entity.Music;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MusicMapper {
    @Select("select * from t_music")
    List<Music> selectMusics();

    @Select("select * from t_music where musicId=#{id}")
    Music selectMusicById(int id);

    @Insert("insert into t_music values(null,#{musicName},#{composer},#{price},#{desc},0)")
    int insertMusic(Music music);

    @Delete("delete from t_music where musicId=#{id}")
    int deleteMusicById(int id);
    @Update("UPDATE t_music SET `like` = #{like} WHERE musicId = #{musicId}")
    void likeMusicById(Music music);
    //UPDATE t_music SET like=#{like} WHERE musicId=#{musicId}
    //UPDATE `web14`.`t_music` SET `like` = 4 WHERE `musicId` = 9
    //musicId
    // update user set name=#{name},pw=#{pw} where id=#{id}
    // ,musicName#{musicName}, composer#{composer}  ,price#{price} ,desc#{desc}
    //update t_music set musicName=#{musicName},composer=#{composer},price=#{price},desc=#{desc},like=#{like} where musicId=#{musicId}
}
