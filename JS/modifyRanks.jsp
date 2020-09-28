<%@ page import="djt.pojo.Ranks" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>天梯排行修改</title>
    <style type="text/css">
        body {

            background-image: url("images/senlin10.jpg");
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
        Ranks ranks = (Ranks) request.getAttribute("ranks");
        if (ranks == null){
            return;
        }
    %>


    <form id="form1" name="form1" method="post"   action="Ranks99?method=5">
        <input type="hidden" name="id" value="<%=ranks.getId()%>">
        <table align="center" width="260" border="1" cellpadding="0" cellspacing="0">
            <tr>
                <th width="64" scope="row">玩家昵称：</th>
                <td width="120"><input type="text" name="name" id="textfield1"value="<%=ranks.getName()%>"/>
                </td>
            </tr>
            <tr>
                <th scope="row">恐龙名称：</th>
                <td><input type="text" name="konlon" id="textfield2" value="<%=ranks.getKonlon()%>"/></td>
            </tr>
            <tr>
                <th scope="row" >战力：</th>
                <td><input type="text" name="powers" id="textfield3"value="<%=ranks.getPowers()%>"/></td>
            </tr>
            <tr>
                <th scope="row" >排名：</th>
                <td><input type="text" name="ranking" id="textfield4"value="<%=ranks.getRanking()%>"/></td>
            </tr>
            <tr>

                <td colspan="2" align="center"><input type="reset"
                                                      name="button" id="button" value="重置"/> &nbsp;&nbsp;&nbsp;&nbsp; <input
                        type="submit" name="button2" id="button2" value="提交"/>
                    &nbsp;&nbsp;&nbsp;&nbsp; <a href="Ranks99?method=1"><input type="button" name="button3" id="button3" value="返回"/></a></td>
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
