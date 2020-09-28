<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %>
<%@ page import="djt.pojo.Equipment" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="CSS/style.css">
    <link rel="stylesheet" href="CSS/bootstrap.min.css" />
    <link rel="stylesheet" href="CSS/1.css" />
    <title>白垩纪公园盒子-装备模块</title>
    <style type="text/css">
        body {
            background-color: #F0F0F0;
            background-image: url("images/senlin2.jpg");
        }
    </style>
</head>
<%--<script type="text/javascript">--%>
<%--	function deleteForm(id) {--%>
<%--		if (confirm("确定要删除此公告信息吗？")) {--%>
<%--			window.location.href = "discussList.jsp?method=3&id=" + id;--%>
<%--		}--%>
<%--	}--%>
<%--</script>--%>

<body>
<jsp:include page="JS/back_Top.jsp" flush="true" />
<jsp:useBean id="equipmentDao" class="djt.dao.impl.EquipmentDaoImpl"/>
<div class="tianchon"></div>
<table width="800" border="0" align="center" cellpadding="0"
       cellspacing="0" background="images/back1.gif">
    <tr>
        <td width="227" valign="top"><jsp:include page="JS/back_Left.jsp"
                                                  flush="true" />
            <img src="images/KL-LOGO.png" style="position: relative;top:-750px;left:10px; width:200px;" ></td>
        <td width="573" valign="top"><table width="227" border="0"
                                            cellpadding="0" cellspacing="0">
            <tr>
                <td><img src="images/back_noword_03.jpg" width="573"
                         height="25"></td>
            </tr>
        </table>
            <table width="573" border="0" cellpadding="0" cellspacing="0"
                   background="images/back_noword_05.jpg">
                <tr>
                    <td valign="top" align="center">

                        <p align=left>
                            &nbsp;&nbsp;&nbsp;&nbsp;<img src=images/icon.gif width=10
                                                         height=10>&nbsp;&nbsp;恐龙装备
                        </p>
                        <a href="addEquipment.jsp">新增信息</a>
                        <table width="500" border="1" cellpadding="1" cellspacing="1"
                               bgcolor="#FECE62">
                            <tr>
                                <td width="94" height="25"><div align="center">装备名称</div></td>
                                <td width="169"><div align="center">类别</div></td>
                                <td width="133"><div align="center">属性</div></td>
                                <td width="81"><div align="center">操作</div></td>
                            </tr>
                            <%
                                List<Equipment> list=equipmentDao.getAllEquipment();
                                for (Equipment equipment:list){
                            %>

                            <tr bgcolor="#FFFFFF">
                                <td><%=equipment.getName()%>
                                </td>
                                <td>
                                    <p style="max-width: 150px;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;"><%=equipment.getCategory()%></p>
                                </td>
                                <td><%=equipment.getAttribute1()%>
                                </td>
                                <td align="center"><a href="Equipment99?method=4&id=<%=equipment.getId()%>">修改&nbsp;&nbsp;</a>
                                    <a href="Equipment99?method=2&id=<%=equipment.getId()%>">删除</a></td>
                            </tr>
                            <% }%>
                            <%--								abc99?method=4&id=<%=discuss.getId()%>--%>
                        </table>




                    </td>
                </tr>
            </table>
            <table width="227" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td><img src="images/back_noword_18.jpg" width="573"
                             height="21"></td>
                </tr>
            </table></td>
    </tr>
</table>
<jsp:include page="JS/back_Down.jsp" flush="true" />
<%
    String result =(String) request.getAttribute("result");
    if (result != null) {
        out.println(result);
    }
%>
</body>
</html>