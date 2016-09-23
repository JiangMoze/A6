package com.weikun.dao;

import com.weikun.db.DB;
import com.weikun.vo.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/23.
 */
public class MessageDAOImpl implements  IMessageDAO {

    public MessageDAOImpl(){

    }
    @Override
    public List<Message> queryMessage() {
        Connection conn= DB.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql="select * from message order by id desc";
        List<Message> list=new ArrayList<Message>();
        try{
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()){
                Message mes=new Message();
                mes.setId(rs.getInt("id"));
                mes.setName(rs.getString("name"));
                mes.setEmail(rs.getString("email"));
                mes.setContent(rs.getString("content"));
                mes.setTitle(rs.getString("title"));
                mes.setDate(rs.getString("date"));
                list.add(mes);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(pstmt!=null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            DB.CloseConnection();
        }


        return list;
    }

    @Override
    public boolean add(Message message) {
        Connection conn= DB.getConnection();
        PreparedStatement pstmt=null;
        boolean flag=false;
        String sql="insert into message(title,content,date) values(?,?,now())";

        try{
            pstmt=conn.prepareStatement(sql);

            pstmt.setString(1,message.getTitle());
            pstmt.setString(2,message.getContent());

            flag=pstmt.executeUpdate()>0?true:false;

        }catch(Exception e){
            e.printStackTrace();
        }finally{

            if(pstmt!=null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            DB.CloseConnection();
        }


        return flag;
    }

    @Override
    public boolean del(int id) {
        Connection conn= DB.getConnection();
        PreparedStatement pstmt=null;
        boolean flag=false;
        String sql="delete from message where id = ?";

        try{
            pstmt=conn.prepareStatement(sql);

            pstmt.setInt(1,id);

            flag=pstmt.executeUpdate()>0?true:false;

        }catch(Exception e){
            e.printStackTrace();
        }finally{

            if(pstmt!=null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            DB.CloseConnection();
        }


        return flag;
    }
}
