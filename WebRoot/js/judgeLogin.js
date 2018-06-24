/**
 * 
 */

function isLogin(user) {
	if (user.length < 1) {
		alert('您还没有登录，请登录后再查看！');
		window.location.href = "login.jsp";
		return false;
	}else{
		return true;
	}
}
