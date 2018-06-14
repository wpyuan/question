/*
    pages/main.jsp
    20180604
 */
var answerList = {};//答案汇总
function checkbox(name){
    //console.log('--checkbox--');
    //console.log('name='+name);
    obj = $(":checkbox[name='"+name+"']");
    check_id = [];
    for(k in obj){
        if(obj[k].checked)
            check_id.push(obj[k].id);
    }
    //console.log(check_id);
    return check_id;
}
function text(name) {
    var arr=$(":text[name='"+name+"']");//获取相同name的对象，然后再遍历这个数组就行了。
    text_id = [];
    for(var i=0;i<arr.length;i++){
        var val=$(arr[i]).val();//获取value值
        if (val.trim()!=""){
            //console.log(val);
            text_id.push(arr[i].id);
        }
    }
    return text_id;
}

function textarea(name) {
    var arr=$("textarea[name='"+name+"']");//获取相同name的对象，然后再遍历这个数组就行了。
    textarea_id = [];
    for(var i=0;i<arr.length;i++){
        var val=$(arr[i]).val();//获取value值
        if (val.trim()!=""){
            //console.log(val);
            textarea_id.push(arr[i].id);
        }
    }
    return textarea_id;
}
function checkOptions() {
    var num = $('#questionNum').val();
    var answerCount = 0;
    //console.log("num="+num);
    //alert($(':radio[name="q1"]:checked').val());
    for (var i = 0; i < num; i++) {
        var rowdata = new Object();
        if($(":radio[name='q"+i+"']").length > 0){
            $(":radio[name='q"+i+"']").parent().parent().parent().css("border","1px solid white");
            if ($(":radio[name='q"+i+"']:checked").val()==undefined){
                alert("没有填写完整。");
                $(":radio[name='q"+i+"']").parent().parent().parent().css("border","1px solid #337ab7");
                return false;
            }
            //console.log("q"+i+":radio");
            var id = $(":radio[name='q"+i+"']:checked").attr("id");
            //console.log("id="+id);
            rowdata[id] = $(":radio[name='q"+i+"']:checked").val();
            answerList[answerCount++]=rowdata;
        }
        if ($(":checkbox[name='q"+i+"']").length > 0){
            //console.log("q"+i+":checkbox");
            $(":checkbox[name='q"+i+"']").parent().parent().parent().css("border","1px solid white");
            var check_id = checkbox("q"+i);
            if (check_id.length==0){
                alert("没有填写完整。");
                $(":checkbox[name='q"+i+"']").parent().parent().parent().css("border","1px solid #337ab7");
                return false;
            }
            for (var j = 0; j < check_id.length; j++) {
                //console.log("id="+check_id[j]);
                var rowobj = new Object();
                rowobj[check_id[j]] = $("#"+check_id[j]).val();
                answerList[answerCount++]=rowobj;
            }
            //console.log(answerList[(i-1)].toString());
        }
        if ($(":text[name='q"+i+"']").length > 0){
            //console.log("q"+i+":text");
            var text_id = text("q"+i);
            if (text_id.length!=0) {
                for (var j = 0; j < text_id.length; j++) {
                    //console.log("id="+text_id[j]);
                    var rowobj = new Object();
                    rowobj[text_id[j]] = $("#"+text_id[j]).val();
                    answerList[answerCount++]=rowobj;
                }
            }
        }
        if ($("textarea[name='q"+i+"']").length > 0){
            $("textarea[name='q"+i+"']").parent().parent().parent().css("border","1px solid white");
            //console.log("q"+i+":textarea");
            var textarea_id = textarea("q"+i);
            if (textarea_id.length==0){
                alert("没有填写完整。");
                $("textarea[name='q"+i+"']").parent().parent().parent().css("border","1px solid #337ab7");
                return false;
            }
            for (var j = 0; j < textarea_id.length; j++) {
                //console.log("id="+textarea_id[j]);
                var rowobj = new Object();
                rowobj[textarea_id[j]] = $("#"+textarea_id[j]).val();
                answerList[answerCount++]=rowobj;
            }
        }
    }
    return true;
}
function sumbit(){
    console.log("--sumbit()--");
    if (!checkOptions()){
        return false;
    }
    answerList = JSON.stringify(answerList);
    $.ajax({
        url:"/sumbit.do",
        data:{
            "answerList":answerList,
            "questionnaireNo":$('#questionnaireNo').val(),
            "name":$('#qymc').val(),
            "nsrsbh":$('#nsrsbh').val()
        },
        type:"post",
        success:function(result){
            alert(result);
        },
        error:function(){
            alert("网络访问失败！");
        }
    });
}