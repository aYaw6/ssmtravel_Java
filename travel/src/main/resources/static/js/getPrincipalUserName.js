/*获取用户登录名称*/

    $.get('/user/getUsername',function (data){
        $('#asideName').text(data)
        $('#headName').text(data)
    });