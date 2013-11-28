var mark = 0;
$(function(){
    var tbl = "rl_app";
    $.post("DetailInit",{mark:mark,tbl:tbl},function(data){
        $("#game_block").append(data);
        mark += 20;
    })
});