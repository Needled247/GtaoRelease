var mark = 0;
$(function(){
    var tbl = "rl_film";
    $.post("DetailInit",{mark:mark,tbl:tbl},function(data){
        $("#film_block").append(data);
        mark += 20;
    })
});