package com.service;

import com.bean.Diary;

import java.util.List;

public interface DiaryService {

    void addDiary (Diary diary);
    List<Diary> getAllDiary();
}
