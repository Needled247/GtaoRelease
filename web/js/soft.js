var mark = 0;
$(function(){
    var tbl = "rl_software";
    $.post("DetailInit",{mark:mark,tbl:tbl},function(data){
        $("#soft_block").append(data);
        mark += 20;
    })
});