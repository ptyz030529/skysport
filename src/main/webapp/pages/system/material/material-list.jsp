<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<div class="modal fade" id="materialListModal" role="dialog" aria-labelledby="materialListModalLabel"
     aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="materialListModalLabel">物料列表</h4>
      </div>
      <form id="defaultForm" method="post" class="form-horizontal" action="edit">
        <div class="modal-body">
          <div class="row">
            <div class="col-xs-12">
              <table id="example" class="table table-striped table-bordered table-hover">
                <thead>
                <tr>
                  <th>编号</th>
                  <th>材质名称</th>
                  <th>所属类型</th>
                  <th>备注</th>
                  <th>操作</th>
                </tr>
                </thead>
                <tbody></tbody>
                <!-- tbody是必须的 -->
              </table>
            </div>
            <!-- Button trigger modal -->
          </div>

        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
          <button type="button" class="btn btn-info"   id="save">保存</button>
          <button type="button" class="btn btn-info" id="resetBtn">重置</button>
        </div>
      </form>
    </div>
  </div>
</div>
<script type="text/javascript" >
  var formatRepo =function (repo){
    if (repo.loading) return repo.text;
    var markup =  repo.name +'-'+repo.natrualkey;
    return markup;
  }

  var formatRepoSelection =function (repo){
    return     repo.text||repo.id;
  }

  $(function () {
    $('#materialListModal').on('shown.bs.modal', function (e) {
      $('.js-data-example-ajax').select2({
        placeholder: '未选择材料类型',
        searchInputPlaceholder: '请材料类型',
        maximumSelectionLength: 1,
        minimumInputLength: 1,
        allowClear: true,
        ajax: {
          url: '<%=path%>/system/material_type/select',
          method: 'GET',
          dataType: 'json',
          quietMillis: 500,
          data: function(params) {
            return {
              name: params.term,
              limit: 10
            }
          },
          processResults: function(_data) {
            var data = _data.items;
            $.each(data, function(index, value) {
              value.id = value.natrualkey;
              value.text = value.name;
            });
            return {
              results: data
            };
          },
          cache: true
        },
        formatRepo: formatRepo,
        templateSelection: formatRepoSelection,
        escapeMarkup: function(m) {return m;}
      });
    });
  })
</script>