<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en" xmlns:th="https://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<#--${pageInfoResponseVo.status}<br/>-->
<#--${pageInfoResponseVo.data}<br/>-->
<#--${pageInfoResponseVo.data.total}<br/>-->


<div class="container">
    <div class="row clearfix">

        <div class="col-md-10 column">
            <h3 align="center"> 重定向 </h3>
            <div class="col-md-1 column">
            </div>
            <div class="col-md-10 column">
                <table class="table table-bordered">
                    <thead>
                    <tr class="success">
                        <th align="center">id</th>
                        <th align="center">state</th>
                        <th align="center">url</th>
                        <th align="center">备注</th>
                        <th align="center">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list all as re>
                        <tr>
                            <td>${(re.id)!''}</td>
                            <td>${(re.state)!''}</td>
                            <td>${(re.url)!''}</td>
                            <td>${(re.remark)!''}</td>
                            <td><a href="/detail?id=${(re.id)!''}">详情</a></td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
                <a href="/detail">添加</a>

            </div>
            <div class="col-md-1 column"></div>

        </div>
        <div class="col-md-2 column"></div>
    </div>
</div>
</body>


</html>