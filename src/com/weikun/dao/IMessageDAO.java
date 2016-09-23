package com.weikun.dao;

import com.weikun.vo.Message;

import java.util.List;

/**
 * Created by Administrator on 2016/9/23.
 */
public interface IMessageDAO {
    public List<Message> queryMessage();
    public boolean add(Message message);
    public boolean del(int id);
}
