$(function(){
    $.getJSON("IndexInit",function(data){
        //film dom
        $("#film").html("");
        $.each(data.film,function(i,item){
            $("#film").append(
                "<li class=\"list-group-item\"><a href='filmDetail.jsp?id="+item.id+"'>"+item.name+"</a></li>"
            );
        });
        //game dom
        $("#game").html("");
        $.each(data.game,function(i,item){
            $("#game").append(
                "<li class=\"list-group-item\"><a href='gameDetail.jsp?id="+item.id+"'>"+item.name+"</a></li>"
            );
        });
        //soft dom
        $("#soft").html("");
        $.each(data.soft,function(i,item){
            $("#soft").append(
                "<li class=\"list-group-item\"><a href='softDetail.jsp?id="+item.id+"'>"+item.name+"</a></li>"
            );
        });
    })
});