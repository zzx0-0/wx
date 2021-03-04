<!DOCTYPE html>
<html lang="en" xmlns:th="https://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>填写</title>
    <meta name="renderer" content="webkit">
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-10 column">
            <div class="col-md-3 column">
            </div>
            <div class="col-md-6 column">
                <form role="form" id="Form">
                    <#if (redirect.id)?? >
                        <div class="form-group">
                            <label for="exampleInputEmail1">ID</label>
                            <input type="text" class="form-control" readonly name="id" value="${(redirect.id)!''}" />
                        </div>
                    </#if>

                    <div class="form-group">
                        <label for="exampleInputEmail1">state</label>
                        <input type="text" class="form-control" name="state" value="${(redirect.state)!''}" />
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">url</label>
                        <input type="text" class="form-control" name="url" value="${(redirect.url)!''}" />
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail1">备注</label>
                        <input type="text" class="form-control" name="remark" value="${(redirect.remark)!''}" />
                    </div>

                    <button type="button" class="btn btn-default" id="sub">提交</button>
                </form>
            </div>
            <div class="col-md-3 column">
            </div>
        </div>
    </div>
</div>
</body>

<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery.serializeJSON/2.9.0/jquery.serializejson.js"></script>
<script type="text/javascript">
    $("#sub").click(function () {
        $.ajax({
            url: "/gai",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify($("#Form").serializeJSON()),
            dataType: "json",
            success: function (result){
                console.log(result);
                if (result.code === 0) {
                    alert(result.msg);
                    self.location=document.referrer;
                } else {
                    alert("错误msg:" + result.msg);
                }
            },
            error: function (result) {
                alert(result.responseText);
            }
        });
    });
</script>
</html>
