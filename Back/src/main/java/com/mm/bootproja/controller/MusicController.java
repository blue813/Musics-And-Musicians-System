package com.mm.bootproja.controller;

import com.mm.bootproja.biz.MusicBiz;
import com.mm.bootproja.entity.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MusicController {
    @Autowired
    private MusicBiz biz;

    @RequestMapping("/music/list")
    public Map findMusics(int pn){
        List<Music> list = biz.findAll();
        System.out.println("i can ddd");
        if((pn*10)< list.size()){
            Map result = new HashMap<>();
            result.put("isOk",true);
            result.put("msg","查询成功");
            result.put("musics",list.subList((pn-1)*10, pn*10));
            return result;
        }
        else if(((pn-1)*10) < list.size()){
            Map result = new HashMap<>();
            result.put("isOk",true);
            result.put("msg","查询成功");
            result.put("musics",list.subList((pn-1)*10, list.size()));
            return result;
        }
        else{
            Map result = new HashMap<>();
            result.put("isOk",true);
            result.put("msg","我们只有"+list.size()+"条数据");
            return result;
        }
    }
    @RequestMapping("/music/add")
    public Map add(Music music){
        this.biz.addMusic(music);
        Map result = new HashMap<>();
        result.put("isOk",true);
        result.put("msg","添加");
        return result;
    }
    @RequestMapping("/music/del")
    public Map del(int id){

        Map result = new HashMap<>();
        if(this.biz.delMusic(id)){
            result.put("isOk",true);
            result.put("msg","删除成功");
        }else{
            result.put("isOk",false);
            result.put("msg","删除失败");
        }

        return result;
    }
    @RequestMapping("/music/like")
    public Map like(int id,int like){
        System.out.println("like"+like+",id"+id);
        Music music=this.biz.selectMusic(id);
        music.setLike(music.getLike()+1);
        System.out.println(music.getLike());
        this.biz.likeMusic(music);
        Map result = new HashMap<>();
        result.put("isOk",true);
        result.put("msg","点赞成功");
        return result;
    }

    @RequestMapping("/music/search")
    public Map search(String name){

        List<Music> all = biz.findAll();
        List<Music> list = new ArrayList<Music>();
        //List<Music> list = null;
        int count1=0;
        System.out.println(name);
        for (Music music:all) {
            if(music.getMusicName().equals(name)){
                list.add(music);
                count1++;
            }
        }
        Map result = new HashMap<>();
        result.put("isOk",true);
        result.put("msg","有"+count1+"条符合条件的音乐");
        result.put("musics",list);
        return result;
    }



    public void setBiz(MusicBiz biz) {
        this.biz = biz;
    }
}
