
function postData(){
    var formData = new FormData();
    formData.append("uploadForm",$("#uploadForm")[0]);
    formData.append("service",'App.Passion.UploadFile');
    $.ajax({
        url:'/importExcel', /*接口域名地址*/
        type:'post',
        data: formData,
        contentType: false,
        processData: false,
        success:function(res){
            console.log(res.data);
            if(res.data["code"]=="succ"){
                alert('成功');
            }else if(res.data["code"]=="err"){
                alert('失败');
            }else{
                console.log(res);
            }
        }
    })
}
