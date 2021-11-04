package com.innowise.danko.service.impl;

import com.innowise.danko.dao.RecordBookDao;
import com.innowise.danko.entity.RecordBook;
import com.innowise.danko.service.RecordBookService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RecordBookServiceImpl implements RecordBookService {

    public final RecordBookDao recordBookDao;

    public RecordBookServiceImpl(RecordBookDao recordBookDao) {
        this.recordBookDao = recordBookDao;
    }

    @Override
    public void addRecordBook(RecordBook recordBook) {
        recordBookDao.save(recordBook);
    }
}
