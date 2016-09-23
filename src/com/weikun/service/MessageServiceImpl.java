package com.weikun.service;

import com.weikun.dao.IMessageDAO;
import com.weikun.dao.MessageDAOImpl;
import com.weikun.vo.Message;

import java.util.List;

/**
 * Created by Administrator on 2016/9/23.
 */
public class MessageServiceImpl implements  IMessageService{
    private IMessageDAO dao=new MessageDAOImpl();
    @Override
    public List<Message> queryMessage() {
        return dao.queryMessage();
    }

    @Override
    public boolean add(Message message) {
        return dao.add(message);
    }

    @Override
    public boolean del(int id) {
        return dao.del(id);
    }
}
