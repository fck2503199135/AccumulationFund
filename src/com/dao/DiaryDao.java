package com.dao;

import com.bean.Diary;

import java.util.List;

public interface DiaryDao {

    void addDiary (Diary diary);
    List<Diary> getAllDiary();


}
