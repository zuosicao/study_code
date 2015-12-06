<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>文件异步上传</title>
<link href="resources/css/dpl.css" rel="stylesheet"> 
  <link href="resources/css/bui.css" rel="stylesheet">
  <style>
   .success img{
  	max-width: 120px;
  } 
  .imageViewTheme .bui-queue .bui-queue-item{
  width:120px;
  }
  </style>
</head>
<body>

  <div id="fileupload">
  </div>
<!--   <button onclick="upload();">确认上传</button> -->
  <div id="progress"></div>
  <div id="result"></div>
</body>
   <script src="resources/js/jquery-1.10.2.js"></script>
   <script src="resources/js/bui.js"></script>
	<script>
	var uploader;
  BUI.use('bui/uploader', function(Uploader){
	  
	//添加自定义主题
      Uploader.Theme.addTheme('imageView', {
        elCls: 'imageViewTheme',
        //可以设定该主题统一的上传路径
        url: '../../../test/upload/upload.php',
        queue:{
          //结果的模板，可以根据不同状态进进行设置
          resultTpl: {
            'default': '<div class="default">{name}</div>',
            'success': '<div class="success" onclick="parentclick();"><img src="{url}" data-a="{url}" onclick="de(\'{url}\')" /></div>',
            'error': '<div class="error"><span class="uploader-error">{msg}</span></div>',
            'progress': '<div class="progress"><div class="bar" style="width:{loadedPercent}%;background:red none repeat scroll 0 0"></div></div>'
          }
        }
     
      });
     
	
      uploader  = new Uploader.Uploader({
          render: '#fileupload',//指定控件的容器
          name:'file',
          url: 'fileupLoad/handle',
          text:'上传大片',
          //autoUpload:false,是否自动上传
          srcNode : '#fileupload',//配置根节点的Dom
          theme:'imageView',
          //prefixCls :'cao-',
          //elTagName :'span',
          //elAttrs :{'data-a':'a','data-b':'b'},
    	  //content:"<h3 style='color:red'>什么鬼怪</h3>",      
          elStyle:{width:300,height:300,background:'#F0F0F0',color:'green',overflow:'hidden','font-size':'11px'},
      	   button:{
      		   tpl : '<a class="bui-uploader-button-wrap" href="javascript:void(0);" style="background:red;color:white"><span class="bui-uploader-button-text"></span></a>',
      		   childContainer : 'a', 
      		  // elStyle:{background:'red'},
      		   //srcNode:"#abutton",
      		   text:'什么鬼2',
      	   },
      	   
           rules: {
               //文的类型
               ext: ['.png,.jpg','文件类型只能为{0}'],
               //上传的最大个数
               max: [5, '文件的最大个数不能超过{0}个'],
               //文件大小的最小值,这个单位是kb
               minSize: [10, '文件的大小不能小于{0}KB'],
               //文件大小的最大值,单位也是kb
               maxSize: [1024, '文件大小不能大于1M']
             }
          
      });
	
    uploader.render();
    
    uploader.on('start', function(ev){
    	//alert("已经开始");
  	 });
    
    uploader.on('progress', function(ev){
    	$("#progress").html(ev.total + ":" + ev.loaded );
  	 });
    
    uploader.on('click', function(e){
    	//alert(e.domTarget.tagName);
    	if (e.domTarget.tagName.toLowerCase() == 'span'){
    		var image = $(e.domTarget).parents("li").find("img").attr("src");
    		alert("delete>" + image);
    	}
    	
  	 });
    
    uploader.on('success', function(ev){
    	   var result = ev.result;
    	  // alert(result.url);
    	   $("#result").html("<img src='"+result.url+"'"+"><span>hello</span>");
    	 });
    
    uploader.on('error', function(ev){
 	   alert("上传失败");
 	 });
    
   
  });
  
  function upload(){
  	uploader.upload();
  }
  
  function de(url){
	  alert(url);
  }
  
  function parentclick(){
	  
	  alert("parentclick");
  }
</script>


</html>