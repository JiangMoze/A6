package com.weikun.control;

import com.weikun.service.IMessageService;
import com.weikun.service.MessageServiceImpl;
import com.weikun.vo.Message;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/9/23.
 */

@WebServlet(
        name="/mc",
        urlPatterns = {"/MessageControl"}
)
public class MessageControl extends javax.servlet.http.HttpServlet {
    private IMessageService service=new MessageServiceImpl();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
       this.doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action=request.getParameter("action");
        List<Message> list=null;

        if(action.equals("show")){
            list =service.queryMessage();
        }else if(action.equals("add")){//增加
            Message m=new Message();
            m.setTitle(request.getParameter("title"));
            m.setContent(request.getParameter("content"));
           if(service.add(m)){
               list =service.queryMessage();
           }
        }else if(action.equals("del")){//删除
            String id=request.getParameter("id");
            if(service.del(Integer.parseInt(id))){
                list =service.queryMessage();
            }
        }
        RequestDispatcher dispatcher=request.getRequestDispatcher("show.jsp");
        request.setAttribute("list",list);
        dispatcher.forward(request,response);

    }
}
