<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增恐龙分布</title>
    <style type="text/css">
        body {

            background-image: url("images/caodi.jpg");
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
<p align="center">新增恐龙分布</p>

<form id="form1" name="form1" method="post"   action="Distribution99?method=3">
    <table align="center" width="260" border="1" cellpadding="0" cellspacing="0">
        <tr>
            <th width="64" scope="row">恐龙名称：</th>
            <td width="120"><input type="text" name="name" id="textfield1"/>
            </td>
        </tr>
        <tr>
            <th scope="row">生存年代：</th>
            <td><input type="text" name="time" id="textfield2"/></td>
        </tr>
        <tr>
            <th scope="row" >分布地址：</th>
            <td><input type="text" name="dizi" id="textfield3"/></td>
        </tr>
        <tr>

            <td colspan="2" align="center"><input type="reset"
                                                  name="button" id="button" value="重置"/> &nbsp;&nbsp;&nbsp;&nbsp; <input
                    type="submit" name="button2" id="button2" value="提交"/>
                &nbsp;&nbsp;&nbsp;&nbsp; <a href="Distribution99?method=1"><input type="button" name="button3" id="button3" value="返回"/></a></td>
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
