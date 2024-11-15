package com.mm.bootproja.biz;

import com.mm.bootproja.entity.Music;
import com.mm.bootproja.mapper.MusicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//标识成业务类
public class MusicBiz {
    @Autowired//spring通过setter给这个属性注入一个对象，
    // 如果属性是接口或抽象类行的，spring会自己去匹配其实现类或子类
    private MusicMapper musicMapper;

    public List<Music> findAll(){
        return musicMapper.selectMusics();
    }

    public Music selectMusic(int id){
        return musicMapper.selectMusicById(id);
    }

    public void addMusic(Music music){
        this.musicMapper.insertMusic(music);
    }

    public boolean delMusic(int bookId){
        return this.musicMapper.deleteMusicById(bookId)>0;
    }

    public void setMusicMapper(MusicMapper bookMapper) {
        this.musicMapper = musicMapper;
    }

    public void likeMusic(Music music){this.musicMapper.likeMusicById(music);}
}
