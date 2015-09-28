var user = user || {};
$(function() {
	user.userDoHash = function(hash) {
		//alert(123);
		if (tk.nohash){
			alert("000");
			return;
		}
		if (hash) {
			if("#task.receipt-list-undo"==hash){
				tk.load(contextPath+'/d/page/task.receipt-list-undo','',tk.menuFocus,[$("#sidebar .menu ul.toggle li a[href='#task.receipt-list-undo']")[0]]);
			}else{
				alert("111");
				tk.load(contextPath+'/d/page/user.user-list','',tk.menuFocus,[$("#sidebar .menu ul.toggle li a[href='#user.user-list']")[0]]);
			}
		}else{
			tk.load(contextPath+'/d/page/user.user-list','',tk.menuFocus,[$("#sidebar .menu ul.toggle li a[href='#user.user-list']")[0]]);
		}
	};
	user.userDoHash(firstClickMenu);
});