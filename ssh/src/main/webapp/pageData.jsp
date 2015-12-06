<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>bui分页</title>
<link href="resources/css/dpl.css" rel="stylesheet">
<link href="resources/css/bui.css" rel="stylesheet">
</head>
<script src="resources/js/jquery-1.10.2.js"></script>
<script src="resources/js/bui.js"></script>
<body>
	<div class="demo-content">
		<div class="row">
			<div class="span16">
				<div id="grid"></div>
			</div>
		</div>
	</div>
</body>
<!-- script start -->
<script type="text/javascript">
	BUI.use([ 'bui/grid', 'bui/data' ], function(Grid, Data) {
		var Grid = Grid, Store = Data.Store, columns = [ {
			title : '学生id',
			dataIndex : 'id',
			sortable:false,
			width : '50%',
			visible:false,
			//tpl : '<div  style="text-align:center;color:red;background:black;height:50px; line-height:50px;"><span class="bui-grid-hd-title">{title}</span><span class="bui-grid-sort-icon">&nbsp;</span></div>',
		}, {
			title : '学生姓名',
			sortable:false,
			dataIndex : 'name',
			width : '50%',
			//elStyle:{'height':'50px'},
			//tpl : '<div  style="text-align:center;color:red;background:gray;height:50px; line-height:50px;"><span class="bui-grid-hd-title">{title}</span><span class="bui-grid-sort-icon">&nbsp;</span></div>',
		},
        {title : '操作',dataIndex : 'd',width:200,renderer : function (value,obj) {
            if(obj.id == '1'){
              return '<span class="grid-command btn1" onclick="modify('+obj.id +')">修改</span>';
            }

            if(obj.id=='2'){
              return '<span class="grid-command btn2" onclick="add('+obj.id +')">增加</span>';
            }
            	return '<span class="grid-command btn1" onclick="add('+obj.id +')">增加2</span> <span class="grid-command btn2" onclick="modify('+obj.id +')">修改2</span>';
          }},
		];
		//var data = [{id:'123'},{id:'cdd',name:'edd'},{id:'1333',name:'eee'}];
		/**
		 * 自动发送的数据格式：
		 *  1. start: 开始记录的起始数，如第 20 条,从0开始
		 *  2. limit : 单页多少条记录
		 *  3. pageIndex : 第几页，同start参数重复，可以选择其中一个使用
		 *
		 * 返回的数据格式：
		 *  {
		 *     "rows" : [{},{}], //数据集合
		 *     "results" : 100, //记录总数
		 *     "hasError" : false, //是否存在错误
		 *     "error" : "" // 仅在 hasError : true 时使用
		 *   }
		 * 
		 */
		var store = new Store({
			url : 'buiPage',
			//data:data,
			autoLoad : true, //自动加载数据
			params : { //配置初始请求的参数
				/* id : 'a1',
				name : 'b1' */
			},
			pageSize : 3
		// 配置分页数目
		});
		var grid = new Grid.Grid({
			render : '#grid',
			columns : columns,
			//loadMask : true, //加载数据时显示屏蔽层
			store : store,
			// 底部工具栏
			bbar : {
				// pagingBar:表明包含分页栏
				pagingBar : true
			},
			//rowTpl :'<tr style="background:red;color:green;height:50px;border:none;">{{cellsTpl}}</tr>'
            tbar:{
                // items:工具栏的项， 可以是按钮(bar-item-button)、 文本(bar-item-text)、 默认(bar-item)、 分隔符(bar-item-separator)以及自定义项 
                items:[{
                    //xclass:'bar-item-button',默认的是按钮
                    btnCls : 'button button-small',
                    text:'命令一',
                    click:function(e){
                    	alert("ddd");
                    }
                }, {
                    xclass:'bar-item-text',
                    text:'<a href="#">链接</a>'
                },{
                  xclass : 'select',
                  elTagName : 'li',
                  items : [{text : '1',value : '1'},{text : '2',value : '2'}],
                  listeners : {
                    change : function(ev){
                      alert(ev.value);
                      //ev.item,ev.text
                    }
                  }
                }]
                // pagingBar:表明包含分页栏
                // pagingBar:true
            },
		});

		grid.render();
	});
	
	function modify(id){
		alert("修改id为：" + id)
	}
	
	function add(id){
		alert("增加id为：" + id)
	}
</script>
<!-- script end -->
</html>