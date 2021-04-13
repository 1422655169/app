<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>POIExcel</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->
    <script type="text/javascript" src="./jquery-easyui-1.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="./jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="./jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" type="text/css" href="./jquery-easyui-1.4.1/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"	href="./jquery-easyui-1.4.1/themes/icon.css">

    <style type="text/css">
        body{ padding:0; margin:0;}
        .div{ padding:0; margin:0;width:80%; height:80%; background:#063; position:absolute;}
    </style>

    <script type="text/javascript">
        $(function(){
            Init();
        });

        function Init(){
            $('#excel').datagrid({
                type : 'post',
                url : './/FallJsonServlet',
                loadMsg : '数据加载中,请稍等!!!!!!!!',
                nowrap : false,
                striped : true,
                fit : true,
                pagination:true,

                /* 	  xh
                      jyrq
                      yelx
                      bz
                      crje
                      zqje
                      zhye
                      dfzh
                      dfxm
                      dfkhh
                      fy
                      zy   */
                columns : [[
                    {field:'checkbox',checkbox:true},
                    {field : 'xh',title : '序号',width : 100,align:'center'},
                    {field : 'jyrq',title : '交易日期',width : 120,align:'center'},
                    {field : 'yelx',title : '业务类型',width : 100,align:'center'},
                    {field : 'bz',title : '币种',width : 120,align:'center'},
                    {field : 'crje',title : '存入金额',width : 150,align:'center'},
                    {field : 'zqje',title : '支取金额',width : 280,align:'center'},
                    {field : 'zhye',title : '账户余额',width : 280,align:'center'},
                    {field : 'dfzh',title : '对方账号',width : 280,align:'center'},
                    {field : 'dfxm',title : '对付姓名',width : 280,align:'center'},
                    {field : 'dfkhh',title : '对方开户行',width : 280,align:'center'},
                    {field : 'zy',title : '摘要',width : 280,align:'center'},
                ]],
                toolbar: [{
                    width:'50',
                    iconCls: 'icon-undo',
                    handler: function(){ExcelImport();}
                }]
            });
        }

        /*Excel导入  */
        function ExcelImport() {
            var url="com/zzx/servlet/ExcelImportServlet";
            window.open(url);
        }


    </script>
</head>

<div align="center">
    <div class="div" title="Excel导入"  background: #fafafa;>"data-options="border:false">
    <table id="excel"></table>
</div>
</div>
</body>
</html>
