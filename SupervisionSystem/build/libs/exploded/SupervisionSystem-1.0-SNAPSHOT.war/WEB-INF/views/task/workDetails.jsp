<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="modal fade" id="workDetails" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true" style="z-index: 1000">
    <div class="modal-dialog" style="width:1200px;height: 1000px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">作业详情</h4>
            </div>

            <div class="modal-body">
                <div class="ibox float-e-margins">
                    <div class="ibox-content">
                        <div class="form-horizontal">

                            <input type="hidden" id="stu_work"/>

                            <div class="form-group">
                                <label class="col-sm-4 control-label">姓名</label>
                                <div class="col-sm-4">
                                    <input class="form-control" disabled="disabled" value="" id="studentName"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-4 control-label">科目</label>
                                <div class="col-sm-4">
                                    <input class="form-control" disabled="disabled" value="" id="subjects"/>
                                </div>
                            </div>


                            <div class="form-group">
                                <label class="col-sm-4 control-label">作业</label>
                                <div class="col-sm-4">
                                    <textarea class="form-control" disabled="disabled" rows="6" id="w_content">

                                    </textarea>
                                </div>
                            </div>

                            </form>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
    </div>
</div>