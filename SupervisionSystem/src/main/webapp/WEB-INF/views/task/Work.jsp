<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="workDetails.jsp"/>

<script>

    var oTable;
    $(document).ready(function () {
       oTable= $.ajax({
            url:"findWork",
            contentType:"application/json;charset=UTF-8",
            dataType: "json",
            type:"get",
            success:function (data) {
                var worktable=window.document.getElementById("worktable");
                var str = "";
                str += "<tr>" +
                    "<td>" + "姓名" + "</td>" +
                    "<td>" + "科目" + "</td>" +
                    "<td>" + "操作" + "</td>" +
                    "</tr>";
                for (var i=0;i<data.length;i++){
                    str += "<tr>" +
                        "<td>" + data[i].studentName + "</td>" +
                        "<td>" + data[i].subjects + "</td>" +
                        "<td>" + '<button class="btn btn-info" onclick="ckClickDetails(\''+data[i].studentName+'\',\''+data[i].subjects+'\')">查看作业</i> </button>' + "</td>" +
                        "</tr>";
                    worktable.innerHTML=str;
                }
            },
            error:function () {
                alert("错啦！");
            }
        });
    });


    //查看作业详情
    function ckClickDetails(se,ss) {

        var studentName=se;
        var subjects=ss;

        $("#stu_work").attr("studentName", studentName);
        $("#stu_work").attr("subjects", subjects);
        $('#workDetails').modal('show');
    }

    //  绑定模态框展示的方法
    $("#workDetails").on("show.bs.modal", function (e) {
        var studentName = $("#stu_work").attr("studentName");
        var subjects = $("#stu_work").attr("subjects");
        //    获得模态框本身
        var modal = $(this);

        $.ajax({
            url: "findWorkByNameAndSubject",
            type: "POST",
            data: {"studentName":studentName,"subjects":subjects},
            success: function (data) {
                modal.find(".modal-body #studentName").val(data.studentName);
                modal.find(".modal-body #subjects").val(data.subjects);
                modal.find(".modal-body #w_content").val(data.w_content);
            }

        });

    });

</script>



<body>

    <input type="hidden" value="" id="stu_work"/>

    <table class="table table-striped table-bordered table-hover " id="worktable">
     <thead>
        <tr>
        <th width="100">姓名</th>
        <th width="100">科目</th>
        <th width="100">操作</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>


</body>

