package com.service;

import com.bean.Diary;
import com.dao.DiaryDao;
import com.dao.DiaryDaolmpl;

import java.util.List;

public class DiaryServicelmpl implements DiaryService {

    DiaryDao dd = new DiaryDaolmpl();
    @Override
    public void addDiary(Diary diary) {
        dd.addDiary(diary);
    }

    @Override
    public List<Diary> getAllDiary() {
        return dd.getAllDiary();
    }

    @Override
    public int cot(String now) {
        return dd.cot(now);
    }
}
