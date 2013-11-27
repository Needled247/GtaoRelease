var mark = 0;
$(function(){
    $.post("FilmInit",{mark:mark},function(data){
        $("#film_block").append(data);
        mark += 20;
    })
});