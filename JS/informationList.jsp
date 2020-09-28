<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %>
<%@ page import="djt.pojo.Information" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="CSS/style.css">
    <link rel="stylesheet" href="CSS/bootstrap.min.css" />
    <link rel="stylesheet" href="CSS/1.css" />
    <title>白垩纪公园盒子-恐龙信息</title>
    <style type="text/css">
        body {
            background-color: #F0F0F0;
            background-image: url("images/kl5.jpg");
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
<jsp:useBean id="informationDao" class="djt.dao.impl.InformationDaoImpl"/>
<div class="tianchon"></div>
<table width="800" border="0" align="center" cellpadding="0"
       cellspacing="0" background="images/back1.gif">
    <tr>
        <td width="10" valign="top"><jsp:include page="JS/back_Left.jsp"
                                                  flush="true" /></td>
        <td width="740" valign="top"><table width="740" border="0"
                                            cellpadding="0" cellspacing="0">
            <tr>
                <td><img src="images/back_noword_03.jpg" width="760px"
                         height="25"></td>
            </tr>
        </table>
            <table width="740" border="0" cellpadding="" cellspacing="0">
<%--                   background="images/back_noword_05.jpg">--%>
                <tr>
                    <td valign="top" align="center">

                        <p align=left>
                            &nbsp;&nbsp;&nbsp;&nbsp;<img src=images/icon.gif width=10
                                                         height=10>&nbsp;&nbsp;恐龙信息
                        </p>
                        <a href="addInformation.jsp">新增信息</a>
                        <table width="700" border="1" cellpadding="1" cellspacing="1"
                               bgcolor="#FECE62">
                            <tr>
                                <td width="50" height="25"><div align="center">中文学名</div></td>
                                <td width="110"><div align="center">拉丁学名</div></td>
                                <td width="45"><div align="center">别称</div></td>
                                <td width="160"><div align="center">体型</div></td>
                                <td width="80"><div align="center">重量</div></td>
                                <td width="170"><div align="center">地位</div></td>
                                <td width="80"><div align="center">操作</div></td>
                            </tr>
                            <%
                                List<Information> list=informationDao.getAllInformation();
                                for (Information information:list){
                            %>

                            <tr bgcolor="#FFFFFF">
                                <td><%=information.getName1()%>
                                </td>
                                <td><%=information.getName2()%>
                                </td>
                                <td><%=information.getName3()%>
                                </td>
                                <td>
                                    <p style="max-width: 170px;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;"><%=information.getTixin()%></p>
                                </td>
                                <td>
                                    <p style="max-width: 80px;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;"><%=information.getWeight1()%></p>
                                </td>
                                <td>
                                    <p style="max-width: 170px;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;"><%=information.getDiwei()%></p>
                                </td>
                                <td align="center"><a href="Information99?method=4&id=<%=information.getId()%>">修改&nbsp;&nbsp;</a>
                                    <a href="Information99?method=2&id=<%=information.getId()%>">删除</a></td>
                            </tr>
                            <% }%>
                        </table>




                    </td>
                </tr>
            </table>
            <table width="740" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td><img src="images/back_noword_18.jpg" width="760"
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