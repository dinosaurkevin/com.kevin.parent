if (typeof String.prototype.endsWith !== 'function') {
    String.prototype.endsWith = function(suffix) {
        return this.indexOf(suffix, this.length - suffix.length) !== -1;
    };
}
function loadUrl(url, id) {
	$(this).addEventListener('tap', function(event){
		mui.openWindow({
		    url: url,  
		    id: id,  
		    styles: {  
		        //top: newpage - top - position, //新页面顶部位置  
		        //bottom: newage - bottom - position, //新页面底部位置  
		        //width: newpage - width, //新页面宽度，默认为100%  
		        //height: newpage - height, //新页面高度，默认为100%  
		    },  
		    extras: {  
		        //自定义扩展参数，可以用来处理页面间传值  
		    },
		    show: {  
		        //autoShow: true, //页面loaded事件发生后自动显示，默认为true  
		        //aniShow: animationType, //页面显示动画，默认为”slide-in-right“；  
		        //duration: animationTime //页面动画持续时间，Android平台默认100毫秒，iOS平台默认200毫秒；  
		    },  
		    waiting: {  
		        autoShow: true, //自动显示等待框，默认为true  
		        title: '正在加载...', //等待对话框上显示的提示内容  
		        options: {  
		            //width: waiting - dialog - widht, //等待框背景区域宽度，默认根据内容自动计算合适宽度  
		            //height: waiting - dialog - height, //等待框背景区域高度，默认根据内容自动计算合适高度  
		        }
		    }
		})
	})
	//触发submit按钮的点击事件
	mui.trigger($(this),'tap');
}

mui('body').on('tap', 'a', function(){
	// 检测是否禁止事件
	var isTap = this.getAttribute('noTap');
	if (isTap != undefined) {
		return;
	}
	// 获取href
	var href = this.getAttribute('href');
	if (href == undefined) {
		return;
	}
	// 获取id
	var id = this.getAttribute('id');
	if (! href.endsWith('.html') && ! href.endsWith('.html')) {
		return;
	}
	if (id == undefined || ! id.length > 0) {
		id = href.substring(0, href.indexOf('.'));
	}
	mui.openWindow({
		    url: href,  
		    id: id,  
		    styles: {  
		        //top: newpage - top - position, //新页面顶部位置  
		        //bottom: newage - bottom - position, //新页面底部位置  
		        //width: newpage - width, //新页面宽度，默认为100%  
		        //height: newpage - height, //新页面高度，默认为100%  
		    },  
		    extras: {  
		        //自定义扩展参数，可以用来处理页面间传值  
		    },
		    show: {  
		        //autoShow: true, //页面loaded事件发生后自动显示，默认为true  
		        //aniShow: animationType, //页面显示动画，默认为”slide-in-right“；  
		        //duration: animationTime //页面动画持续时间，Android平台默认100毫秒，iOS平台默认200毫秒；  
		    },  
		    waiting: {  
		        autoShow: true, //自动显示等待框，默认为true  
		        title: '正在加载...', //等待对话框上显示的提示内容  
		        options: {  
		            //width: waiting - dialog - widht, //等待框背景区域宽度，默认根据内容自动计算合适宽度  
		            //height: waiting - dialog - height, //等待框背景区域高度，默认根据内容自动计算合适高度  
		        }
		    }
		})
})
