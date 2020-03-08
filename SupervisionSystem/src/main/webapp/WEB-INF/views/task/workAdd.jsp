<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="${pageContext.request.contextPath }/resources/datetimepicker/bootstrap-datetimepicker.min.css"
      rel="stylesheet" media="screen">
<!-- /section:basics/sidebar -->
<script src="${pageContext.request.contextPath }/resources/js/update/plugins/jquery-ui/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/update/plugins/validate/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/jquery.form.min.js"></script>

                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>添加作业</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <form class="form-horizontal"  id="addWork">

                    <div class="form-group">
                        <label class="col-sm-4 control-label">科目</label>
                        <div class="col-sm-4">
                            <select id="subjects" name="subjects" class="col-sm-4">
                                <option selected="selected" value="请选择" >请选择</option>
                                <option value="语文">语文</option>
                                <option value="数学">数学</option>
                                <option value="英语">英语</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 control-label">作业</label>
                        <div class="col-sm-4">
                            <textarea class="form-control"  value=""  rows="6" id="w_content"></textarea>
                        </div>
                    </div>

                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-4">
                                    <button class="btn btn-primary" type="button" onclick="ckClickDetails()">提交</button>
                                    <a class="btn btn-white" href="${pageContext.request.contextPath }/task/mywork">返回</a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript"
        src="${pageContext.request.contextPath }/resources/datetimepicker/bootstrap.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath }/resources/datetimepicker/bootstrap-datetimepicker.js"
        charset="UTF-8"></script>
<script>

    function ckClickDetails() {

        var subjects = document.getElementById("subjects").value;
        var w_content = document.getElementById("w_content").value;
        if(subjects !="请选择"){
            if(w_content!=""){
                $.ajax({
                    url: "addWork",
                    type: "POST",
                    data: {"subjects":subjects,"w_content":w_content},
                    success: function (data) {
                        if(data.failure!=null){
                            alert("已存在该科目作业，请勿重复提交！");
                            window.location.reload();
                        }else {
                            alert("添加成功！");
                            window.location.reload();
                        }
                    },
                    error:function () {
                        alert("出错啦！");
                    }
                });



            }else {
                alert("作业不能为空!");
            }

        }else {
            alert("请选择科目!");
        }

    }


</script>