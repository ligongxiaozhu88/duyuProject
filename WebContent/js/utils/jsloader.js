/**
 * 动态加载js文件 src：js文件路径 reload： 如果js文件已经存在，是否重新加载 true：重新加载 一般用于js文件中有需立即执行代码的情况；false 不重新加载
 * callback：加载完成后的回调函数。加载js文件时都是异步加载的，所以如果立即执行的代码与所加载的js文件相关联，就需要把立即执行的代码写在回调函数中。
 * 目前callback带参数时，需要写成字符串；不带参数时可以直接写函数名
*/
function jsloader(src,reload,callback){
	var scripts=document.getElementsByTagName("script");
	//reload默认值是：需重新加载js文件
	reload=reload==null?true:reload;
	for(var i=0;i<scripts.length;i++){
		if(scripts[i].src.match(src)){
			scripts[i].parentNode.removeChild(scripts[i]);
			break;
		}else{
			//不需要重新加载时，直接执行回调函数
			if(callback){
				if(typeof callback=="function"){
					callback();
				}else{
					eval(callback);				
				}
			}
			return ;
		}
	}
	var script =document.createElement('script');
	script.type="text/javascript";
	script.src=src;
	document.getElementsByTagName('head')[0].appendChild(script);
	if(callback){
		//js文件加载完成后才执行callback函数
		script.onload=script.onreadystatechange=function(){
			if(this.readyState && this.readyState!='loaded' && this.readyState!='complete')
				return ;
			this.onreadystatechange=this.onload=null;
			if(typeof callback =="function"){
				callback();
			}else{
				eval(callback);
			}
		}
	}	
}
/**
*动态加载批量js文件，如果有回调函数，所有js加载完成之后才执行回调函数。srcArray:'js文件路径' 数组
*reload：如果js文件存在,true 重新加载 一般用于js文件中有需立即执行代码的情况 false不重新加载
*callback:加载完成后的回调函数，加载js文件时都是异步加载的 。所以如果立即执行的代码与所加载的js文件相关联，就需要把立即执行的代码写在回调函数中。
*callback需要写成字符串 不能直接写函数 直接写的话 会被先解析
*/
function jsgrouploader(srcArray,reload,callback){
	var scripts=document.getElementsByTagName("script");
	//reload默认值是：需要重新加载js文件
	reload=reload==null?true:reload;
	//‘是否重新加载’数组，初始全设置成需要重新加载，然后根据reload值及判断相应js文件是否已经加载来判断是否需要重新加载。
	var reloadscript=new Array();
	
	var count =1;
	for(var j=0;j<srcArry.length;i++){
		reloadscript[j]=true;
		for(var i=0;i<scripts.length;i++){
			if(reload=true){
				scripts[i].parentNode.removeChild(scripts[i]);
			}else{
				count++;
				reloadscript[j]=false;
			}
			break;
		}
	}
	//如果reload=false 所有的js文件已存在 则直接执行回调函数
	if(!reload){
		if(count>srcArray.length){
			if(callback){
				eval(callback);
			}
			return;
		}	
	}
	for(j=0;i<srcArray.length;j++){
		if(!reloadscript[j]){
			continue;
		}
		var script =document.createElement('script');
		script.type="text/javascript";
		script.src=srcArray[j];
		document.getElementsByTagName('head')[0].appendChild(script);
		if(callback){
			//js文件加载完成后才执行callback函数
			script.onload=script.onreadystatechange=function(){
				if(this.readyState && this.readyState!='loaded' && this.readyState!='complete')
					return ;
				this.onreadystatechange=this.onload=null;
				if(typeof callback =="function"){
					callback();
				}else{
					eval(callback);
				}
			}
		}	
	}
}

/**
*递归调用 按序动态加载批量js文件 如果有回调函数，所有js加载完成之后才执行回调函数。srcArray:'js文件路径' 数组
*reload：如果js文件存在,true 重新加载 一般用于js文件中有需立即执行代码的情况 false不重新加载
*callback:加载完成后的回调函数，加载js文件时都是异步加载的 。所以如果立即执行的代码与所加载的js文件相关联，就需要把立即执行的代码写在回调函数中。
*callback需要写成字符串 不能直接写函数 直接写的话 会被先解析
*num 当前递归调用使用到的数组元素的顺序号
*/
function jsloaderByOrder(srcArray,reload,callback,num){
	var scripts=document.getElementsByTagName("script");
	//reload默认值是：需重新加载js文件
	reload=reload==null?true:reload;
	for(var i=0;i<scripts.length;i++){
		if(scripts[i].src.match(srcArray[num])){
			if(reload){
				scripts[i].parentNode.removeChild(scripts[i]);
				break;
			}else{
				if(srcArray.length==num+1){
					if(callback){
						eval(callback);				
					}
					return ;
				}
			}
		}
	}
	var script =document.createElement('script');
	script.type="text/javascript";
	script.src=srcArray[num];
	document.getElementsByTagName('head')[0].appendChild(script);
	if(srcArray.length==num+1){
		if(callback){
			//js文件加载完成后才执行callback函数
			script.onload=script.onreadystatechange=function(){
				if(this.readyState && this.readyState!='loaded' && this.readyState!='complete')
					return ;
				this.onreadystatechange=this.onload=null;
				eval(callback);
			}
		}
	}else{
		script.onload=script.onreadystatechange=function(){
				if(this.readyState && this.readyState!='loaded' && this.readyState!='complete')
					return ;
				this.onreadystatechange=this.onload=null;
				jsloaderByOrder(srcArray,reload,callback,num+1);
			}
		}
	}
}

/**
*统一的动态加载js函数如果有回调函数，所有js加载完成后执行回调函数 srcArray:'js文件路径' 数组
*reload：如果js文件存在,true 重新加载 一般用于js文件中有需立即执行代码的情况 false不重新加载
*order 当前递归调用使用到的数组元素的顺序号
*callback:加载完成后的回调函数，加载js文件时都是异步加载的 。所以如果立即执行的代码与所加载的js文件相关联，就需要把立即执行的代码写在回调函数中。
*callback需要写成字符串 不能直接写函数 直接写的话 会被先解析
*
*/