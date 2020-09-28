<%@ page import="djt.pojo.Discuss" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>公告修改</title>
    <style type="text/css">
        body {

            background-image: url("images/senlin.jpg");
        }
        .konbaiweizi{
            width:400px;
            height: 400px;
            background-color: #F0F0F0;
            margin: 10px auto;

        }
    </style>
</head>
<body>
<p></p>
<div class="konbaiweizi">
<p align="center">公告修改</p>
<%
    Discuss discuss = (Discuss) request.getAttribute("discuss");
    if (discuss == null){
        return;
    }
%>


<form id="form1" name="form1" method="post"   action="abc99?method=5">
    <input type="hidden" name="id" value="<%=discuss.getId()%>">
    <table align="center" width="260" border="1" cellpadding="0" cellspacing="0">
        <tr>
            <th width="64" scope="row">公告题目：</th>
            <td width="120"><input type="text" name="discussTitle" id="textfield1"value="<%=discuss.getDiscussTitle()%>"/>
            </td>
        </tr>
        <tr>
            <th scope="row">公告内容：</th>
            <td><input type="text" name="discussContent" id="textfield2" value="<%=discuss.getDiscussContent()%>"/></td>
        </tr>
        <tr>
            <th scope="row" >发布时间：</th>
            <td><input type="text" name="discussTime" id="textfield3"value="<%=discuss.getDiscussTime()%>"/></td>
        </tr>
        <tr>

            <td colspan="2" align="center"><input type="reset"
                                                  name="button" id="button" value="重置"/> &nbsp;&nbsp;&nbsp;&nbsp; <input
                    type="submit" name="button2" id="button2" value="提交"/>
                &nbsp;&nbsp;&nbsp;&nbsp; <a href="abc99?method=1"><input type="button" name="button3" id="button3" value="返回"/></a></td>
        </tr>
    </table>

    <%
        String result =(String) request.getAttribute("result");
        if (result != null) {
            out.println(result);
        }
    %>
</form>
</div>
<p>&nbsp;</p>
</body>
</html>
