$.fn.mypagination = function(totalProperty,pageNo,pageSize){	
	return this.each(function(){
		function numPages(){
			if(pageSize == 0) {
				return 1;
			} else {
				return Math.ceil(totalProperty/pageSize);
			}
		}
		function selectPage(page){
			return function(){
				if(page<=1){
					page=1;
				}else if ( page>=numPages()) {
					page=numPages();
                }
                render();
				$('img.page-wait',panel).attr('src','images/wait.gif');
				select(page);
				$('img.page-wait',panel).attr('src','images/nowait.gif');
				
			}
		}
		
		function render(){
			var html = '<table><tbody><tr>' 
				+'<td><img class="page-first"></td>'
				+'<td><img class="page-prev"></td>'
				+'<td><span>第<input type="text" style="margin:0 auto;" class="page-num">页/共'+numPages()+'页</span></td>'
				+'<td><img class="page-next"></td>'
				+'<td><img class="page-last"></td>'
				//+'<td><img src="images/nowait.gif" class="page-wait"></td>'
				+'<td style="padding-left:50px;">检索到<span style="font-size:12px; color:#09C;">'+totalProperty+'</span>记录</td>'
				+'</tr></tbody></table>';
			//var imgFirst = 'images/page-first-disabled.gif';
			//var imgPr= 'images/page-prev-disabled.gif';
			var imgFirst = 'images/btm_pageFirst.gif';
			var imgPrev = 'images/btm_pagePrev.gif';
			var imgNext = 'images/btm_pageNext.gif';
			var imgLast = 'images/btm_pageEnd.gif';
			//var imgNext = 'images/page-next-disabled.gif';
			//var imgLast = 'images/page-last-disabled.gif';
			if (pageNo > 1){
				imgFirst = 'images/btm_pageFirst.gif';
				imgPrev = 'images/btm_pagePrev.gif';
			}
			if (pageNo < numPages()){
				imgNext = 'images/btm_pageNext.gif';
				imgLast = 'images/btm_pageEnd.gif';
			}
			panel.empty();
			panel.append(html);
			if(pageNo == 1) {
				$('img.page-first',panel)
				.attr('src',imgFirst);
				$('img.page-prev',panel)
					.attr('src',imgPrev);
			}
			if(pageNo > 1) {
				$('img.page-first',panel)
					.bind('click',selectPage(1))
					.css('cursor', 'pointer')
					.attr('src',imgFirst);	
				$('img.page-prev',panel)
					.bind('click',selectPage(pageNo-1))
					.css('cursor', 'pointer')
					.attr('src',imgPrev);
			}
			if(pageNo < numPages()) {
				$('img.page-next',panel)
					.bind('click',selectPage(pageNo+1))
					.css('cursor', 'pointer')
					.attr('src',imgNext);	
				$('img.page-last',panel)
					.bind('click',selectPage(numPages()))
					.css('cursor', 'pointer')
					.attr('src',imgLast);
			}
			if(pageNo == numPages() || numPages() == 0) {
				$('img.page-next',panel)
				.attr('src',imgNext);	
				$('img.page-last',panel)
					.attr('src',imgLast);
			}
			$('input.page-num',panel)
				.val(pageNo)
				.keypress(function(event){
					var e = event || window.event;
					var code = e.which || e.keyCode;
					if (code == 13) {
						if(numPages() == 0) {
							$(this).val(1);
						}
						selectPage($(this).val())();
					}
				});
		}
		var panel = $(this);
		render();
			
	});
};