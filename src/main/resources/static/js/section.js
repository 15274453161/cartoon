/*登录判断*/
$(function() {
    $('.u_cbox_write_wrap').click(function () {
        var userId=$('#userInfor').val();
        if (userId==0){
           // window.location.href='http://localhost:8090/account-login-show';
            alert("please login");
            console.log("please login");

        }

    });
});


//评论输入框获得焦点事件
function textareaFunFocus() {

    var flist = document.getElementsByClassName('u_cbox_guide');

    for(var i=0;i<flist.length;i++  ){
        flist[i].style.display='none';
    }

}
function textareaFunBlur() {
    var blist = document.getElementsByClassName('u_cbox_guide');
    for(var i=0;i<blist.length;i++ ){
        blist[i].style.display='';
    }
}



