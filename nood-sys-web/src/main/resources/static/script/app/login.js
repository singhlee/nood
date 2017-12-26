

$(document).ready(function(){
    $("#loginForm").validate({
        onsubmit:true,// 是否在提交是验证
        onfocusout:false,// 是否在获取焦点时验证
        onkeyup :false,// 是否在敲击键盘时验证
        rules: {
            username: {
                required: true,
                minlength: 4
            },
            password: {
                required: true,
                minlength: 6
            }
        },
        messages : {
            username : {
                required : "请填写用户名",
                minlength: "用户名最小4位"
            },
            password : {
                required : "请填写密码",
                minlength: "用户名最小6位"
            }
        }

    });


});

